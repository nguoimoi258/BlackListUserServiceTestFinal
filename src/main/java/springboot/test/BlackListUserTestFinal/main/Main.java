package springboot.test.BlackListUserTestFinal.main;

import java.util.UUID;

import springboot.test.BlackListUserTestFinal.model.BlackListUser;
import springboot.test.BlackListUserTestFinal.testAll.BlackListUserTestImpl;

public class Main {

	public static void main(String[] args) {

		BlackListUserTestImpl testImpl = new BlackListUserTestImpl();
		
		UUID userId = UUID.fromString("c9f576ff-e4cf-4632-a097-02e5ec4aa111");
		
		BlackListUser userTest = new BlackListUser("Doan Chi Binh", userId, "09823342348", 10555000, "fbUrl",
				"imageName", "reason");
		
		BlackListUser userUpdate = new BlackListUser("Tran Thi Thao", userId, "09823342348", 10555000, "Co Co",
				"Anh 1212", "Reject 10004") ;

		/*
		 *  1. Initialize userTest
		 *  2. Create user then compare result with userTest
		 *  3. Change userTest
		 *  4. Update userTest 
		 *  5. Get result user update then compare userTest
		 *  6. Delete userTest, then get user -->result return 404 NOT FOUND 
		 */
		
		testImpl.setUserTest(userTest);
		
		System.out.println("------Test API create User-------");
		
		BlackListUser userCreated = testImpl.createUser(testImpl.getUserTest());
		
		testImpl.compareUser(testImpl.getUserTest(), userCreated);
		
		testImpl.setUserTest(userUpdate);
		
		System.out.println("------Test API update User-------");
			
		testImpl.updateUser(userUpdate);
		
		System.out.println("------Test API get User-------");
		
		BlackListUser userUpdated = testImpl.getUser(testImpl.getUserTest().getUserId());
		
		testImpl.compareUser(testImpl.getUserTest(), userUpdated);
		
		System.out.println("------Test API delete User-------");
		
		testImpl.deleteUser(testImpl.getUserTest().getUserId());
		
		try {
			BlackListUser userDeleted = testImpl.getUser(testImpl.getUserTest().getUserId());
			if(userDeleted == null) {
				System.out.println("User not found or already deleted.");
			}
			else {
				System.out.println(userDeleted);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}