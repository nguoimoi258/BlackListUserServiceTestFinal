package springboot.test.BlackListUserTestFinal.testAll;

import java.util.UUID;

import springboot.test.BlackListUserTestFinal.model.BlackListUser;

public interface BlackListUserTest {

	BlackListUser createUser(BlackListUser userCreate);
	
	BlackListUser getUser(UUID userId);
	
	void updateUser(BlackListUser userUpdate);
	
	void deleteUser(UUID userId);
	
	boolean compareUser(BlackListUser user1, BlackListUser user2);
}
