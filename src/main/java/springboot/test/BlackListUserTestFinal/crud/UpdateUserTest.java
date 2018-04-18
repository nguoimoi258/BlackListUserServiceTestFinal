package springboot.test.BlackListUserTestFinal.crud;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import springboot.test.BlackListUserTestFinal.model.BlackListUser;

public class UpdateUserTest {
	
	public static void main(String[] args) {
		
		String baseUrl = "http://localhost:8080/api/user/";
		
		UUID userId =  UUID.fromString("c9f576ff-82ef-4ccd-b4b2-46205b0fa078");
		BlackListUser userUpdate = new BlackListUser("Ha thi Thai 22222", userId, "002313", 20, null,
				null, null) ;
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<BlackListUser> requestBody = new HttpEntity<>(userUpdate, header);
		
		 restTemplate.put(baseUrl, requestBody, new Object[] {});
		 
		 String getUserUpdateUrl = baseUrl + userUpdate.getUserId().toString();
		 BlackListUser resultUpdate = restTemplate.getForObject(getUserUpdateUrl, BlackListUser.class);
		if (resultUpdate != null) {    
			System.out.println("Black list user updated: ");
	        System.out.println("FullName: " + resultUpdate.getFullName() + "\n" +
	        					"UserId: "	+ resultUpdate.getUserId()   + "\n" +
	        					"PhoneNumber: "	+ resultUpdate.getPhoneNumber()   + "\n" +
	        					"FbUrl: "	+ resultUpdate.getFbUrl()   + "\n" +
	        					"ImageName: "	+ resultUpdate.getImageName()   + "\n" +
	        					"Salary: "	+ resultUpdate.getSalary()   + "\n" +
	        					"Reason: "	+ resultUpdate.getReason()   + "\n" );
		}
		else {
			System.out.println("Error");
		}
	}
}
