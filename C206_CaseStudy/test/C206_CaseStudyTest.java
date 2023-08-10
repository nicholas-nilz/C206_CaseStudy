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
		 A1 = new Appointment("9 Aug 2023", "1400", "Please knock on the door instead of ringing the doorbell")
		A2 = new Appointment("15 Aug 2023", "1000", "We can provide the tools needed for you")
		
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

		@Test
		 public void c206_test() {
		  //fail("Not yet implemented"); 
		  assertTrue("C206_CaseStudy_SampleTest ",true);
		 }
		@Test
		 public void testToCreateAppointment() {
		  Appointment A = new Appointment("9 Aug 2023", "1400", "Please knock on the door instead of ringing the doorbell");
		  assertNotNull(A);
		  assertEquals("Date: ", A.getDate());
		        assertEquals("Time: ", A.getTime());
		        assertEquals("Additional Details", A.getAdditional_details());
		 }

		  @Test
		     public void testAddAppointment() {
		   // Test if Appointmentlist is not null but empty -boundary
		   assertNotNull("Check if there is valid userList arraylist to add to", AppointmentList);
		   
		   //Given an empty list, after adding 1 item, the size of the list is 1 - normal
		   //The item just added is as same as the first item of the list
		   C206_CaseStudy.addAppointment(AppointmentList, A1);
		   assertEquals("Check that userList arraylist size is 1", 1, AppointmentList.size());
		   assertSame("Check that A1 is added", A1, AppointmentList.get(0));
		   
		   //Add another item. Test the size of the list is 2? - normal
		   //The item just added is as same as the second item of the list
		   C206_CaseStudy.addAppointment(AppointmentList, A2);
		   assertEquals("Check that userList arraylist size is 2", 2, AppointmentList.size());
		   assertSame("Check that A2 is added", A2, AppointmentList.get(1));

		         Appointment duplicateAppointment = new Appointment("15 Aug 2023", "1000", "We can provide the tools needed for you");
		         C206_CaseStudy.addAppointment(AppointmenttList, duplicateAppointment);

		         // Duplicate appointment should not be added
		         assertEquals(2, AppointmentList.size());
		     }

		  @Test
		  public void testRetrieveAllAppointment() {
		      Appointment A1 = new Appointment("9 Aug 2023 ", "1400 ", "Please knock on the door instead of ringing the doorbell");
		      Appointment A2 = new Appointment("15 Aug 2023", "1000", "We can provide the tools needed for you");
		      AppointmentList.add(A1);
		      AppointmentList.add(A2);

		      String expectedOutput = "9 Aug 2023 1400 Please knock on the door instead of ringing the doorbell \n"
		              + "15 Aug 2023 1000 We can provide the tools needed for you";
		      System.out.println("!" + expectedOutput);
		      System.out.println("!" + C206_CaseStudy.retrieveAllAppointment(AppointmentList));
		      assertEquals(expectedOutput, C206_CaseStudy.retrieveAllAppointment(AppointmentList));
		  }
		  
		    @Test
		     public void testDeleteAppointment() {
		    	Appointment A1 = new Appointment("9 Aug 2023 ", "1400 ", "Please knock on the door instead of ringing the doorbell");
			    Appointment A2 = new Appointment("15 Aug 2023", "1000", "We can provide the tools needed for you");
			    AppointmentList.add(A1);
			    AppointmentList.add(A2);

		         C206_CaseStudy.deleteAppointment(AppointmentList, A1);
		         assertEquals(1, AppoinmentList.size());

		         C206_CaseStudy.deleteAppointment(AppoinmentList, A2);
		         assertEquals(0, AppoinmentList.size());

		         // Attempt to delete a appointment that doesn't exist
		         Appointment nonExistentAppoinment = new Appointment("9 Aug 2023", "1400", "Please knock on the door instead of ringing the doorbell");
		         C206_CaseStudy.deleteAppointment(AppoinmentList, nonExistentAppointment);
		         assertEquals(0, AppointmentList.size());
		     }

	

		}
