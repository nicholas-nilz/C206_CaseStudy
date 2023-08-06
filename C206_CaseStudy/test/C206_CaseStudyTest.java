import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	    User user1 ;
	    User user2 ;
		ArrayList<User>userList;
		private ArrayList<Request> requesttList;
	    Request r1 ;
	    Request r2 ;
	@Before
	public void setUp() throws Exception {
		//prepare test data 
		 user1 =new User("hahan","hahan@gmail.com",90803674,"jalan123","lol123");
		 user2=new User("jian qi ","jianqi@gmail.com",83945764,"jalan321","jianqi123");
		 r1 = new Request("Painting Service", "Paint living room", "Pending");
		  r2 = new Request("Carpentry Service", "Install shelves", "Pending");
		userList =new ArrayList<User>();
		
		requesttList = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test 
	public void testAddUser() {
		// Test if userlist is not null but empty -boundary
		assertNotNull("Check if there is valid userList arraylist to add to", userList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addUser(userList,user1);
		assertEquals("Check that userList arraylist size is 1", 1, userList.size());
		assertSame("Check that user1 is added", user1, userList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList,user2);
		assertEquals("Check that userList arraylist size is 2", 2, userList.size());
		assertSame("Check that user2 is added", user2, userList.get(1));
	}
	
	String output = String.format("%-20s %-25s %-15s %-25s\n","Username","Email","Contact Number","Address");
	@Test 
	public void testRetrieveUser() {
		// Test if userlist is not null but empty -boundary
		assertNotNull("Check if there is valid userList arraylist to add to", userList);
		
		//test if the list of userList retrieved from the C206_CaseStudy is empty - boundary
		String allUsers= C206_CaseStudy.retrieveUser(userList);
		String testOutput = "";
		assertEquals("Check that ViewAlluserlist", testOutput, allUsers);
	
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addUser(userList, user1);
		C206_CaseStudy.addUser(userList, user2);
		assertEquals("Test that userList arraylist size is 2", 2, userList.size());
		
		//test if the expected output string same as the list of users retrieved from the source
		allUsers= C206_CaseStudy.retrieveUser(userList);
				testOutput = String.format("%-5d%-20s %-25s %-15s %-25s\n",1,"hahan","hahan@gmail.com",90803674,"jalan123","lol123");
				testOutput += String.format("%-5d%-20s %-25s %-15s %-25s\n",2,"jian qi ","jianqi@gmail.com",83945764,"jalan321","jianqi123");
				user1 =new User("hahan","hahan@gmail.com",90803674,"jalan123","lol123");
				 user2=new User("jian qi ","jianqi@gmail.com",83945764,"jalan321","jianqi123");
				
				assertEquals("Test that Viewalluser", testOutput, allUsers);
	}
	@Test 
	public void testDeleteUser() {
				assertNotNull("Test if there is valid userList arraylist to add to", userList);
				C206_CaseStudy.addUser(userList, user1);
				C206_CaseStudy.addUser(userList, user2);
				//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
				assertEquals("Test that userList arraylist size is 2", 2, userList.size());
			   
				C206_CaseStudy.deleteUser(userList, 1);
				//test that the size of userList is reduced.
				assertEquals("Test that userList arraylist size is reduce 1", 1, userList.size());
				
				String allUsers= C206_CaseStudy.retrieveUser(userList);

				String testOutput = String.format("%-5d%-20s %-25s %-15s %-25s\n",1,"jian qi ","jianqi@gmail.com",83945764,"jalan321","jianqi123");
				
				assertEquals("Test that second user is delete ", testOutput, allUsers);

	}
	@Test
	 public void c206_test() {
	  //fail("Not yet implemented"); 
	  assertTrue("C206_CaseStudy_SampleTest ",true);
	 }
	@Test
	 public void testToCreateRequest() {
	  Request r = new Request("Plumbing Service", "Fix leaking faucet", "Pending");
	  assertNotNull(r);
	  assertEquals("Plumbing Service", r.getRequestService());
	        assertEquals("Fix leaking faucet", r.getRequestDescription());
	        assertEquals("Pending", r.getRequestStatus());
	 }
	@Test
    public void testSetStatus() {
  Request r = new Request("Electrical Service", "Install ceiling fan", "Pending");
     assertEquals("Pending", r.getRequestStatus()); // Ensure status is initially "Pending"
     
     r.setRequestStatus("Completed"); // Set status to "Completed"
     assertEquals("Completed", r.getRequestStatus());
    }

	  @Test
	     public void testAddRequest() {
	   // Test if requesttlist is not null but empty -boundary
	   assertNotNull("Check if there is valid userList arraylist to add to", requesttList);
	   
	   //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	   //The item just added is as same as the first item of the list
	   C206_CaseStudy.addRequest(requesttList, r1);
	   assertEquals("Check that userList arraylist size is 1", 1, requesttList.size());
	   assertSame("Check that r1 is added", r1, requesttList.get(0));
	   
	   //Add another item. Test the size of the list is 2? - normal
	   //The item just added is as same as the second item of the list
	   C206_CaseStudy.addRequest(requesttList, r2);
	   assertEquals("Check that userList arraylist size is 2", 2, requesttList.size());
	   assertSame("Check that r2 is added", r2, requesttList.get(1));

	         Request duplicateRequest = new Request("Painting Service", "Paint living room", "Pending");
	         C206_CaseStudy.addRequest(requesttList, duplicateRequest);

	         // Duplicate request should not be added
	         assertEquals(2, requesttList.size());
	     }

	  @Test
	  public void testRetrieveAllRequest() {
	      Request r1 = new Request("Plumbing Service", "Fix leaking faucet", "Pending");
	      Request r2 = new Request("Electrical Service", "Install ceiling fan", "Completed");
	      requesttList.add(r1);
	      requesttList.add(r2);

	      String expectedOutput = "Plumbing Service     Fix leaking faucet   Pending\n"
	              + "Electrical Service   Install ceiling fan  Completed";
	      System.out.println("!" + expectedOutput);
	      System.out.println("!" + C206_CaseStudy.retrieveAllRequest(requesttList));
	      assertEquals(expectedOutput, C206_CaseStudy.retrieveAllRequest(requesttList));
	  }
	  
	    @Test
	     public void testDeleteRequest() {
	         Request r1 = new Request("Plumbing Service", "Fix leaking faucet", "Pending");
	         Request r2 = new Request("Electrical Service", "Install ceiling fan", "Completed");
	         requesttList.add(r1);
	         requesttList.add(r2);

	         C206_CaseStudy.deleteRequest(requesttList, r1);
	         assertEquals(1, requesttList.size());

	         C206_CaseStudy.deleteRequest(requesttList, r2);
	         assertEquals(0, requesttList.size());

	         // Attempt to delete a request that doesn't exist
	         Request nonExistentRequest = new Request("Painting Service", "Paint living room", "Pending");
	         C206_CaseStudy.deleteRequest(requesttList, nonExistentRequest);
	         assertEquals(0, requesttList.size());
	     }

	

		}
