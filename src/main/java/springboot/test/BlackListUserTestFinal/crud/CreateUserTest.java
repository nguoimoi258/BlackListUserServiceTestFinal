
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import springboot.test.BlackListUserTestFinal.model.BlackListUser;

public class CreateUserTest {

	public static void main(String[] args) {
		String baseUrl = "http://localhost:8080/api/user/";
		
		UUID userId =  UUID.fromString("4647fcbd-e4cf-4632-a097-02e5ec4aab91");
		BlackListUser user = new BlackListUser("Tran Thi Thao", userId, "09823342348", 10555000, "fbUrl",
				"imageName", "reason") ;
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		
		// Data attached to the request.
		HttpEntity<BlackListUser> requestBody = new HttpEntity<>(user, header);
		
		// Send request with POST method.
		BlackListUser result = restTemplate.postForObject(baseUrl, requestBody, BlackListUser.class);	
		if (result != null) {    
			System.out.println("Black list user created: ");
            System.out.println("FullName: " + result.getFullName() + "\n" +
            					"UserId: "	+ result.getUserId()   + "\n" +
            					"PhoneNumber: "	+ result.getPhoneNumber()   + "\n" +
            					"FbUrl: "	+ result.getFbUrl()   + "\n" +
            					"ImageName: "	+ result.getImageName()   + "\n" +
            					"Salary: "	+ result.getSalary()   + "\n" +
            					"Reason: "	+ result.getReason()   + "\n" );
		}
		else {
			System.out.println("Error");
		}
	}
}
