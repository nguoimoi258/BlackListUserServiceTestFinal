package springboot.test.BlackListUserTestFinal.crud;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class DeleteUserTest {
	
	public static void main(String[] args) {
		String baseUrl = "http://localhost:8080/api/user/";
		
		UUID userId = UUID.fromString("4647fcbd-e4cf-4632-a097-02e5ec4aab91");
		
		String deleteByIdUrl = baseUrl +  userId.toString();
		
		
		
		RestTemplate  restTemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
	      // Send request with DELETE method.
		
		
		try {
			restTemplate.delete(deleteByIdUrl, header);	
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}
}
