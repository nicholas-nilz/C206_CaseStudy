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
		private ArrayList<Appointment> AppointmentList;
	    Request r1 ;
	    Request r2 ;
	    Appointment A1;
	    Appointment A2;
	    private ArrayList<quote> quoteList;
	    quote q1;
	    quote q3;
	    public ArrayList<Service> serviceList;
	     Service s1;
	     Service_Provider sp1;
	     Service_Provider sp2;
	     ArrayList<Service_Provider>SP_List=new  ArrayList<Service_Provider>();

	@Before
	public void setUp() throws Exception {
		//prepare test data 
		sp1=new Service_Provider("Nippon", "qwerty", "Cleaning","toilet", "Jurong East",100.0);
	    sp2=new Service_Provider("Daikin","blah","Cleaning","Aircon","Ang Mo Kio",600.45);
	  SP_List=new ArrayList<>();
		 q1=  new quote("200","Pet Friendly");
		 q3=  new quote("600","Shortage of manpower");
		 user1 =new User("hahan","hahan@gmail.com",90803674,"jalan123","lol123");
		 user2=new User("jian qi ","jianqi@gmail.com",83945764,"jalan321","jianqi123");
		r1 = new Request(0, "John", "Painting Service", "Paint living room", "Pending");
		r2 = new Request(1, "Cena", "Carpentry Service", "Install shelves", "Pending");
		 A1 = new Appointment("9 Aug 2023", "1400", "Please knock on the door instead of ringing the doorbell");
		 A2 = new Appointment("15 Aug 2023", "1000", "We can provide the tools needed for you");
		 
		 s1 = new Service("Plumbing", "Plumbing service for kitchen", "Woodlands", 80.0);
		  serviceList = new ArrayList<> ();
		 
		 
		userList =new ArrayList<User>();
		AppointmentList=new ArrayList<Appointment>();
		requesttList = new ArrayList<>();
		quoteList= new ArrayList<>();
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

		userList.remove(1);
		// test add a duplicate username -error
		User userduplicate =new User("hahan","ws@gmail.com",90128394,"jalan321","lol345");
		C206_CaseStudy.addUser(userList,userduplicate);
		assertEquals("Check that userList arraylist size did not increase", 1, userList.size());
		
		//test add a wrong email format object 
		User useremail =new User("hahan","errortest",90803674,"jalan123","lol123");
		C206_CaseStudy.addUser(userList,userduplicate);
		assertNotEquals("Check that userList arraylist size did not increase", 2, userList.size());
	}
		
		
	    
	
	
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
				
				userList.remove(1);
				User userduplicate =new User("hahan","ws@gmail.com",90128394,"jalan321","lol345");
				C206_CaseStudy.addUser(userList,userduplicate);
				//
		
	}
	@Test 
	public void testDeleteUser() {
				assertNotNull("Test if there is valid userList arraylist to add to", userList);
				C206_CaseStudy.addUser(userList, user1);
				C206_CaseStudy.addUser(userList, user2);
				//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
				assertEquals("Test that userList arraylist size is 2", 2, userList.size());
			   
				boolean deleteuser2= C206_CaseStudy.deleteUser(userList, 1);
				//test the boolean returned is true(success);
				assertTrue(deleteuser2);
				//test that the size of userList is reduced.
				assertEquals("Test that userList arraylist size is reduce 1", 1, userList.size());
				
				String allUsers= C206_CaseStudy.retrieveUser(userList);

				String testOutput = String.format("%-5d%-20s %-25s %-15s %-25s\n",1,"jian qi ","jianqi@gmail.com",83945764,"jalan321","jianqi123");
				
				//test only the second user is remove - normal
				assertEquals("Test that second user is delete ", testOutput, allUsers);
				
				//test delete an object in empty arraylist- error
				userList.clear();
				boolean removeEmptyList =C206_CaseStudy.deleteUser(userList, 0);
				assertFalse(removeEmptyList);
				
				
				
				
				
	}
	@Test
	 public void c206_test() {
	  //fail("Not yet implemented"); 
	  assertTrue("C206_CaseStudy_SampleTest ",true);
	 }
	

	@Test
	 public void testToCreateRequest() {
	  Request r = r1;
	  assertNotNull(r);
	  assertEquals("Painting Service", r.getRequestService());
	        assertEquals("Paint living room", r.getRequestDescription());
	        assertEquals("Pending", r.getRequestStatus());
	 }
	@Test
    public void testSetStatus() {
  Request r =r1;
     assertEquals("Pending", r.getRequestStatus()); // Ensure status is initially "Pending"
     
     r.setRequestStatus("Completed"); // Set status to "Completed"
     assertEquals("Completed", r.getRequestStatus());
    }

	  @Test
	     public void testAddRequest() {
		// Test if requesttlist is not null but empty -boundary
			assertNotNull("Check if there is valid userList arraylist to add to", requesttList);

			// Given an empty list, after adding 1 item, the size of the list is 1 - normal
			// The item just added is as same as the first item of the list
			C206_CaseStudy.addRequest(requesttList, r1);
			assertEquals("Check that userList arraylist size is 1", 1, requesttList.size());
			assertSame("Check that r1 is added", r1, requesttList.get(0));

			// Add another item. Test the size of the list is 2? - normal
			// The item just added is as same as the second item of the list
			C206_CaseStudy.addRequest(requesttList, r2);
			assertEquals("Check that userList arraylist size is 2", 2, requesttList.size());
			assertSame("Check that r2 is added", r2, requesttList.get(1));

			Request duplicateRequest = new Request(1, "John", "Painting Service", "Paint living room", "Pending");
			C206_CaseStudy.addRequest(requesttList, duplicateRequest);

			// Duplicate request should not be added
			assertEquals(2, requesttList.size());
	         assertEquals(2, requesttList.size());
	     }
	  @Test
	  public void testRetrieveAllRequest() {
		   // Test if requesttlist is not null but empty -boundary
		   assertNotNull("Check if there is valid requesttList arraylist to add to", requesttList);
		   
		   //test if the list of requesttList retrieved from the C206_CaseStudy is empty - boundary
		   String allRequests= C206_CaseStudy.retrieveAllRequest(requesttList,"John");
		   String testOutput = "";
		   assertEquals("Check that ViewAllrequesttlist", testOutput, allRequests);
		  
		   //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		   C206_CaseStudy.addRequest(requesttList, r1);
		   C206_CaseStudy.addRequest(requesttList, r2);
		   assertEquals("Test that requesttList arraylist size is 2", 2, requesttList.size());
		   
		   //test if the expected output string same as the list of request retrieved from the source
		   allRequests = C206_CaseStudy.retrieveAllRequest(requesttList,"John");
		     testOutput = String.format("%-20s %-20s %-20s %-20s\n","John","Painting Service", "Paint living room", "Pending");
		     
		     
		     
		     assertEquals("Test that Viewallrequest", testOutput, allRequests);
		  }
	  
	    @Test
	     public void testDeleteRequest() {
	    	Request rq1 = r1;
			requesttList.add(rq1);
			
			C206_CaseStudy.deleteRequest(requesttList, "John", 0);
			assertEquals(0, requesttList.size());

			// Attempt to delete a request that doesn't exist
			C206_CaseStudy.deleteRequest(requesttList, "nonexist", 0);
			assertEquals(0, requesttList.size());
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
            C206_CaseStudy.addAppointment(AppointmentList, duplicateAppointment);

            // Duplicate appointment should not be added
            assertEquals(2, AppointmentList.size());
        }
	    @Test
	     public void testToCreateAppointment() {
	      Appointment A = new Appointment("9 Aug 2023 ", "1400 ", "Please knock on the door instead of ringing the doorbell");
	      assertNotNull(A);
	      assertEquals("9 Aug 2023 ", A.getDate());
	            assertEquals("1400 ", A.getTime());
	            assertEquals("Please knock on the door instead of ringing the doorbell", A.getAdditional_details());
	     }

     @Test
     public void testRetrieveAllAppointment() {
         Appointment A1 = new Appointment("9 Aug 2023", "1400", "Please knock on the door instead of ringing the doorbell");
         Appointment A2 = new Appointment("15 Aug 2023", "1000", "We can provide the tools needed for you");
         AppointmentList.add(A1);
         AppointmentList.add(A2);

         String expectedOutput =String.format("%-20s %-20s %-20s \n",A1.getDate(),A1.getTime(),A1.getAdditional_details());
          expectedOutput +=String.format("%-20s %-20s %-20s \n",A2.getDate(),A2.getTime(),A2.getAdditional_details());
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
            assertEquals(1, AppointmentList.size());

            C206_CaseStudy.deleteAppointment(AppointmentList, A2);
            assertEquals(0, AppointmentList.size());

            // Attempt to delete a appointment that doesn't exist
            Appointment nonExistentAppoinment = new Appointment("9 Aug 2023", "1400", "Please knock on the door instead of ringing the doorbell");
            C206_CaseStudy.deleteAppointment(AppointmentList, nonExistentAppoinment);
            assertEquals(0, AppointmentList.size());
        }
       @Test
       public void testRetrieveQuote() {
           // Test if quotelist is not null but empty - boundary
           assertNotNull("Check if there is a valid quotelist to add to", quoteList);
           
           // Given an empty list, after adding 1 item, test if the size of the list is 2 - normal
           C206_CaseStudy.addQuote(quoteList, q1);
           
           assertEquals("Test that QuoteList arraylist size is 1", 1, quoteList.size());
         
  
  
  quote q2=  new quote("","Special needs workers");
     boolean actual = q2.getQ_price() != null;

     assertFalse(actual);
 }
    
   
       
    
    @Test
    public void testAddQuote() {
    	  // Test if userlist is not null but empty -boundary
        assertNotNull("Check if there is a valid quotelist to add to", quoteList);

        // Add a quote to the list
        C206_CaseStudy.addQuote(quoteList, q1);
        assertEquals("Check that quotelist arraylist size is 1", 1, quoteList.size());
        assertSame("Check that quote1 is added", q1, quoteList.get(0));

        // Check that q_price input is not a special character
        if (q1.getQ_price()=="[^a-zA-Z0-9]") {
            throw new IllegalArgumentException("Cannot add a special character!");
         }else {
          assertSame("Check that quote1 is added", q1, quoteList.get(0));
         }
    }
    @Test
    public void testDeleteQuote() {
         quote rq1 = q1;
         quote rq2 = q3;
         quoteList.add(rq1);
         quoteList.add(rq2);
         
         //Test if Quote is deleted
         C206_CaseStudy.deleteQuote(quoteList, q1);
         assertEquals(1, quoteList.size());

         C206_CaseStudy.deleteQuote(quoteList, q3);
         assertEquals(0, quoteList.size());

         // Attempt to delete a quote that doesn't exist
         quote Missingquote = new quote("10","Animal frendly");
         C206_CaseStudy.deleteQuote(quoteList, Missingquote);
         assertEquals(0, quoteList.size());
         
     }
    @Test
    public void testToCreateService() {
     Service s = s1;
     assertNotNull(s);
     assertEquals("Plumbing", s.getType());
           assertEquals("Plumbing service for kitchen", s.getDescription());
           assertEquals("Woodlands", s.getLocation());
    }
  
      @Test
      public void testAddService() {
          assertNotNull("Check if there is a valid serviceList arraylist to add to", serviceList);

          C206_CaseStudy.addService(serviceList, s1);
          assertEquals("Check that serviceList arraylist size is 1", 1, serviceList.size());
          assertSame("Check that s1 is added", s1, serviceList.get(0));

          Service duplicateService = new Service("Plumbing", "Plumbing service for kitchen", "Woodlands", 80.0);
          C206_CaseStudy.addService(serviceList, duplicateService);

          assertEquals("Check that duplicate service is not added", 1, serviceList.size());
      }

      @Test
      public void testRetrieveAllService() {
          assertNotNull("Check if there is a valid serviceList arraylist to add to", serviceList);

          C206_CaseStudy.addService(serviceList, s1);
          assertEquals("Test that serviceList arraylist size is 1", 1, serviceList.size());

          String allServices = C206_CaseStudy.retrieveAllService(serviceList);

          String expectedOutput = String.format("%-20s %-20s %-20s %-20s\n",
              s1.getType(), s1.getDescription(), s1.getLocation(), s1.getBudget());

          assertEquals("Test that ViewallServices", expectedOutput, allServices);
      }


      @Test
      public void testDeleteService() {
          Service sv1 = s1;
          serviceList.add(s1);

          C206_CaseStudy.deleteService(serviceList, s1, "Plumbing");
          assertEquals("Check that serviceList arraylist size is reduced", 0, serviceList.size());
          Service nonExistentService = new Service("nonExist", "Plumbing service for kitchen", "Woodlands", 80.0);
          C206_CaseStudy.deleteService(serviceList, nonExistentService, "nonExist");
          assertEquals("Check that non-existent service cannot be deleted", 0, serviceList.size());
      }
    //Test Service Provider
      @Test
    public void testCreateServiceProvider() {
     Service_Provider sp = sp1;
     assertNotNull(sp);
     assertEquals("Nippon", sp.getCompanyName());
           assertEquals("qwerty", sp.getPassword());
           assertEquals("Cleaning", sp.getType());
           assertEquals("Jurong East",sp.getLocation());
    }
      
      @Test
       public void testAddServiceProvider() {
     // Test if SP_List is not null but empty -boundary
     assertNotNull("Check if there is valid userList arraylist to add to", SP_List);
     
     //Given an empty list, after adding 1 item, the size of the list is 1 - normal
     //The item just added is as same as the first item of the list
     C206_CaseStudy.addServiceProvider(SP_List, sp1);
     assertEquals("Check that userList arraylist size is 1", 1, SP_List.size());
     assertSame("Check that sp1 is added", sp1, SP_List.get(0));
      
     //Add another item. Test the size of the list is 2? - normal
     //The item just added is as same as the second item of the list
     C206_CaseStudy.addServiceProvider(SP_List, sp2);
     assertEquals("Check that userList arraylist size is 2", 2, SP_List.size());
     assertSame("Check that sp2 is added", sp2, SP_List.get(1));

           Service_Provider duplicateSP = new Service_Provider("Nippon", "qwerty", "Cleaning","toilet", "Jurong East",100.0);
           C206_CaseStudy.addServiceProvider(SP_List, duplicateSP);

           // Duplicate request should not be added
           assertEquals(2, SP_List.size());
       }
      
      @Test
      public void testRetrieveServiceProvider() {
          assertNotNull("Check if there is a valid SP_List ArrayList to add to", SP_List);

          C206_CaseStudy.addServiceProvider(SP_List, sp1);
          assertEquals("Test that SP_List ArrayList size is 1", 1, SP_List.size());

          String type = sp1.getType();
          String allSP = C206_CaseStudy.retrieveAllServiceProvider(SP_List, type);

          String output = String.format("%-20s %-20s %-20s %-20s\n", sp1.getCompanyName(), sp1.getPassword(), sp1.getType(), sp1.getLocation());
          assertEquals("Test that retrieveAllServiceProvider", output, allSP);
      }


      @Test
       public void testDeleteServiceProvider() {
    	  assertNotNull("Test if there is valid userList arraylist to add to", SP_List);
			C206_CaseStudy.addServiceProvider(SP_List, sp1);
			C206_CaseStudy.addServiceProvider(SP_List, sp2);
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			assertEquals("Test that userList arraylist size is 2", 2, SP_List.size());
		   
			boolean deleteSP2= C206_CaseStudy.deleteServiceProvider(SP_List, 1);
			//test the boolean returned is true(success);
			assertTrue(deleteSP2);
			//test that the size of userList is reduced.
			assertEquals("Test that SP_List arraylist size is reduce 1", 1, SP_List.size());
			
			String allUsers= C206_CaseStudy.retrieveAllServiceProvider(SP_List,"Cleaning");

			String testOutput = String.format("%-5d%-20s %-25s %-15s %-25s\n",1,"Nippon","qwerty","Cleaning","Jurong East");
			
			//test only the second SP is remove - normal
			assertEquals("Test that second user is delete ", testOutput, allUsers);
			
			//test delete an object in empty arraylist- error
			SP_List.clear();
			boolean removeEmptyList =C206_CaseStudy.deleteServiceProvider(SP_List, 0);
       }

   }
 



 

  

	

		
