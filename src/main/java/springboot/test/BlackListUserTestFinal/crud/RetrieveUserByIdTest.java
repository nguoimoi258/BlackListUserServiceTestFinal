package springboot.test.BlackListUserTestFinal.crud;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import springboot.test.BlackListUserTestFinal.model.BlackListUser;

public class RetrieveUserByIdTest {
	
	public static void main(String[] args) {
		
		String baseUrl = "http://localhost:8080/api/user/";
		UUID userId = UUID.fromString("c9f576ff-82ef-4ccd-b4b2-46205b0fa078");
		
		String getUserUrl = baseUrl + userId.toString(); 
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		BlackListUser result = restTemplate.getForObject(getUserUrl, BlackListUser.class, header);
		
		if (result != null) {            
                System.out.println("FullName: " + result.getFullName() + "\n" +
                					"UserId: "	+ result.getUserId()   + "\n" +
                					"PhoneNumber: "	+ result.getPhoneNumber()   + "\n" +
                					"FbUrl: "	+ result.getFbUrl()   + "\n" +
                					"ImageName: "	+ result.getImageName()   + "\n" +
                					"Salary: "	+ result.getSalary()   + "\n" +
                					"Reason: "	+ result.getReason()   + "\n" 
                		);
            
        }		
	}
}
