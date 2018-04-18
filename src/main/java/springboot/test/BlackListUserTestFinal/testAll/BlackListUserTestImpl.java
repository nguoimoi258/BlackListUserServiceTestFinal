package springboot.test.BlackListUserTestFinal.testAll;

import springboot.test.BlackListUserTestFinal.model.BlackListUser;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class BlackListUserTestImpl implements BlackListUserTest{

	private BlackListUser userTest;
	
	final String baseUrl = "http://localhost:8080/api/user/";
	
	final double epsilon = 100;
	
	public BlackListUser getUserTest() {
		return userTest;
	}

	public void setUserTest(BlackListUser userTest) {
		this.userTest = userTest;
	}

	@Override
	public BlackListUser createUser(BlackListUser userCreate) {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		
		// Data attached to the request.
		HttpEntity<BlackListUser> requestBody = new HttpEntity<>(userCreate, header);
		
		// Send request with POST method.
		try {
			BlackListUser result = restTemplate.postForObject(baseUrl, requestBody, BlackListUser.class);
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BlackListUser getUser(UUID userId) {
		
		String getUserUrl = baseUrl + userId.toString(); 
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			BlackListUser result = restTemplate.getForObject(getUserUrl, BlackListUser.class, header);
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateUser(BlackListUser userUpdate) {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<BlackListUser> requestBody = new HttpEntity<>(userUpdate, header);
		
		try {
			 restTemplate.put(baseUrl, requestBody, new Object[] {});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

	@Override
	public void deleteUser(UUID userId) {

		String deleteByIdUrl = baseUrl +  userId.toString();
		
		
		
		RestTemplate  restTemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			// Send request with DELETE method.
			restTemplate.delete(deleteByIdUrl, header);	
		} catch (RestClientException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean compareUser(BlackListUser user1, BlackListUser user2) {
		
			
			if(!user1.getUserId().toString().equals(user2.getUserId().toString()))
				return false;

			if(!user1.getFullName().equals(user2.getFullName()))
				return false;
			
			if(!user1.getPhoneNumber().equals(user2.getPhoneNumber()))
				return false;
		
			if(!user1.getFbUrl().equals(user2.getFbUrl()))
				return false;
			
			if(!user1.getImageName().equals(user2.getImageName()))
				return false;
			
			if(!user1.getReason().equals(user2.getReason()))
				return false;
			
			double temp = user1.getSalary()- user2.getSalary();
			
			if(Math.abs(temp) > epsilon)
				return false;
			
			System.out.println("--> OK!");
			return true;
		
	}

}
