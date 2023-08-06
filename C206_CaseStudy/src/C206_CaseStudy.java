
import java.util.ArrayList;
import java.util.Iterator;

public class C206_CaseStudy {


	public static void main(String[] args) {

		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<quote> quoteList = new ArrayList<quote>();
		ArrayList<Request> requesttList = new ArrayList<Request>();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<User> userList = new ArrayList<User>();
	    ArrayList<User> registeredUsers = new ArrayList<User>();
		ArrayList<Service_Provider> SP_List = new ArrayList<Service_Provider>();
		SP_List.add(new Service_Provider("Nippon","qwerty","Cleaning","Jurong East"));
	    registeredUsers.add(new User("WeiSiang","ws@gmail.com",12345,"jalan123","lol123"));
		 String[] list = new String[] { "User", "Appointment", "Request", "Service_Provider", "Quote",
				"Service" };
		 int Sprint =Helper.readInt("1.sprint 1\n2.sprint 2\nPlease enter which sprint:");
		 if(Sprint==1) {

			  int option = 0;
			  while (option != 4) {
			   Menu();
			   option = Helper.readInt("Please enter the number: ");

			   if (option == 1) {
			    System.out.println("\n");
			    for (int i = 0; i < list.length; i++) {
			     System.out.println(i + 1 + ":Add " + list[i]);
			    }
			    int which = Helper.readInt("Please Enter a number to Add:");
			    if (which==1) {
			    	String username=Helper.readString("\nPlease enter username: ");
					String email=Helper.readString("Please enter email: ");
					int contact=Helper.readInt("Please enter contact number: ");
					String address=Helper.readString("Please enter address: ");
					String password=Helper.readString("Please enter password: ");
					User userADD= new User(username,email,contact,address,password);
			     addUser(registeredUsers,userADD);     
			    }else if(which==2) {
			     //
			    }else if(which==3) {
			     Request r = inputRequest();
			     C206_CaseStudy.addRequest(requesttList, r);
				 System.out.println("Request added");
			    }else if (which==4) {
			     //
			    }else if(which==5) {
			     quote quoteinsert = inputQuote();
			     C206_CaseStudy.addQuote(quoteList, quoteinsert);
			     System.out.println("Quote added");
			    }else if(which==6) {
			     //
			    }
			   } else if (option == 2) {
			    System.out.println("\n");
			    for (int i = 0; i < list.length; i++) {
			     System.out.println(i + 1 + ":View " + list[i]);
			    }
			    int which = Helper.readInt("Please Enter a number to :");
			    if (which==1) {
			    	viewAllUser(registeredUsers);	    
			    }else if(which==2) {
			     //C206_CaseStudy.viewAppointment(appointmentList);
			    }else if(which==3) {
			     C206_CaseStudy.viewAllRequest(requesttList);
			    }else if (which==4) {
			     //C206_CaseStudy.viewServiceProvider(quoteList);
			    }else if(which==5) {
			     C206_CaseStudy.viewALLquotes(quoteList);
			    }else if(which==6) {
			     //C206_CaseStudy.viewService(serviceList);
			    }
			   } else if (option == 3) { 
			    System.out.println("\n");
			    for (int i = 0; i < list.length; i++) {
			     System.out.println(i + 1 + ":Delete " + list[i]);
			    }
			    int which = Helper.readInt("Please Enter a number to Delete:");
			    if (which==1) {
			    	System.out.println("Delete User");
					Helper.line(80, "-");
					System.out.println(String.format("%-5s%-20s %-25s %-15s %-25s", "ID","Username","Email","Contact Number","Address"));
					Helper.line(80, "-");
					for (int x = 0; x < registeredUsers.size(); x++) {
						    System.out.println(String.format("%-5d%-20s %-25s %-15d %-25s\n",x+1,registeredUsers.get(x).getname(),registeredUsers.get(x).getEmail(),registeredUsers.get(x).getContact(),registeredUsers.get(x).getAddress()));
						  }
					int removeID=Helper.readInt("Please enter the ID to remove:");
			    	deleteUser(registeredUsers,removeID);     
			    }else if(which==2) {
			     //
			    }else if(which==3) {
			     Request r = inputRequest();
			     C206_CaseStudy.deleteRequest(requesttList, r);
				 System.out.println("Request deleted");
			    }else if (which==4) {
			     //
			    }else if(which==5) {
			     quote quoteinsert = inputQuote();
		         C206_CaseStudy.deleteQuote(quoteList, quoteinsert);
			     System.out.println("Quote deleted");
			    }else if(which==6) {
			     //
			    }
			   } else if (option == 5) {
			    //addUser(userList,list);
			   }
			  }
			 }
		 
		 		 
		 
		 
		 else if(Sprint==2) {
		 String loginSuccess="";
		 String loginAs="";
		 int Sprint2 = 0;
			while (Sprint2 != 3) {
					int category =0;
					while (category != 3) {
					    category = Helper.readInt("Please enter your category:\n1.User\n2.Service Provider");

					    if (category == 1) {
					        String loginName = userLogin(registeredUsers);
					        if (!loginName.isEmpty()) {
					            loginSuccess = loginName;
					            System.out.println("Welcome " + loginName + ", login successful.");
					            loginAs = "user";
					            break;
					        } else {
					            System.out.println("Login failed, please try again.");
					        }
					    } else if (category == 2) {
					        String loginName = SPLogin(SP_List);
					        if (!loginName.isEmpty()) {
					            loginSuccess = loginName;
					            System.out.println("Welcome " + loginName + ", login successful.");
					            loginAs = "sp";
					            break; 
					        } else {
					            System.out.println("Login failed, please try again.");
					        }
					    }}}}
					
					// Code here for the sprint two feature and rmb retrieve the variable loginSuccess as the username and loginAs as the role.
					
					
					
					
					


					
						
				}
		
		
			
		
	
	
//test 
	public static void Menu() {
		System.out.println("Enter 1 for Add");
		System.out.println("Enter 2 View All");
		System.out.println("Enter 3 to Delete");
		System.out.println("Enter 4 to Exit");

	}
	 public static void setHeader(String header) {
		  Helper.line(80, "-");
		  System.out.println(header);
		  Helper.line(80, "-");
		 }
	
	public static void addUser(ArrayList<User> userList,User userAdd) {
		
		
			int before =userList.size();
			userList.add(userAdd);
			int after  =userList.size();
			if(after>before) {
				System.out.println("\nUser added successfully");
						
			}
	}
	public static void deleteUser(ArrayList<User> userList,int removeID) {
		
		userList.remove(removeID-1);
		System.out.println("User remove successfully.");
}
	public static void viewAllUser(ArrayList<User> userList) {
		  C206_CaseStudy.setHeader("View all user");
		  System.out.println(String.format("%-5s%-20s %-25s %-15s %-25s\n", "ID", "Username", "Email", "Contact Number", "Address"));

		String output = "";
		
		output+=retrieveUser(userList);
		System.out.println(output);
	}
	
	
	
	 public static String retrieveUser(ArrayList<User> userList) {
		  // TODO Auto-generated method stub
		  String output = "";
		  // write your code here
		  for (int x = 0; x < userList.size(); x++) {

		   output += String.format("%-5d%-20s %-25s %-15d %-25s\n",x+1,userList.get(x).getname(),userList.get(x).getEmail(),userList.get(x).getContact(),userList.get(x).getAddress());
		  }
		  return output;
		 }
	
	
	
	
	public static String userLogin(ArrayList<User> registeredUsers) {
		System.out.println("Login as User");
		String username=Helper.readString("Please enter your username: ");
		String password=Helper.readString("Please enter your password: ");
		String LoginUsername ="";
		
		for(int x=0; x<registeredUsers.size();x++) {
			System.out.println(username.equals(registeredUsers.get(x).getname()));
			System.out.println(password.equals(registeredUsers.get(x).getPassword()));

			
			if(username.equals(registeredUsers.get(x).getname())&&password.equals(registeredUsers.get(x).getPassword())) {
				 LoginUsername=registeredUsers.get(x).getname();
				 break;
			}
			
			}
		return LoginUsername;
		
	}
	public static String SPLogin(ArrayList<Service_Provider> SP_List) {
		System.out.println("Login as Service Provider");
		String username=Helper.readString("Please enter your username: ");
		String password=Helper.readString("Please enter your password: ");
		String LoginUsername ="";
		
		for(int x=0; x<SP_List.size();x++) {
			System.out.println(username.equals(SP_List.get(x).getcompanyName()));
			System.out.println(password.equals(SP_List.get(x).getpassword()));

			
			if(username.equals(SP_List.get(x).getcompanyName())&&password.equals(SP_List.get(x).getpassword())) {
				 LoginUsername=SP_List.get(x).getcompanyName();
				 break;
			}
			
			}
		return LoginUsername;
		
	}

	 public static String retrieveAllQuotes(ArrayList<quote> quoteList) {
	  // TODO Auto-generated method stub
	  String output = "";
	  // write your code here
	  for (int i = 0; i < quoteList.size(); i++) {

	   output += String.format("%-20s %-20s\n", quoteList.get(i).getQ_details(),quoteList.get(i).getQ_description());
	  }
	  return output;
	 }
	 
	 public static void viewALLquotes(ArrayList<quote> quoteList) {
	  // TODO Auto-generated method stub
	  C206_CaseStudy.setHeader("Quote LIST");
	  String output = String.format("%-20s %-20s\n","Details","Description");
	   output += retrieveAllQuotes(quoteList);
	  System.out.println(output);
	 }
	 
	 public static quote inputQuote() {
	  String details = Helper.readString("Enter details > ");
	  String description = Helper.readString("Enter description > ");

	  quote quoteinsert= new quote(details,description);
	  return quoteinsert;
	  
	 }
	 
	 public static void deleteQuote(ArrayList<quote> quoteList, quote quoteToDelete) {
		    Iterator<quote> iterator = quoteList.iterator();
		    while (iterator.hasNext()) {
		        quote item = iterator.next();
		        if (item.getQ_details().equalsIgnoreCase(quoteToDelete.getQ_details())) {
		            iterator.remove();
		            System.out.println("Quote deleted.");
		            return; // Exit the loop after deleting one quote
		        }
		    }
		    System.out.println("Quote not found.");
		}
	 
	 public static void addQuote(ArrayList<quote> quoteList, quote quoteinsert) {
	  quote item;
	  for(int i = 0; i < quoteList.size(); i++) {
	   item = quoteList.get(i);
	   if (item.getQ_details().equalsIgnoreCase(quoteinsert.getQ_details()) )
	    return;
	  }
	  if ((quoteinsert.getQ_details().isEmpty()) || (quoteinsert.getQ_description().isEmpty()) ) {
	   return;
	  }
	  quoteList.add(quoteinsert);
	  
	 }
	 

public static Request inputRequest() {
			String service = Helper.readString("Enter service > ");
			String description = Helper.readString("Enter description > ");
			String date = Helper.readString("Enter date > ");
			String status = Helper.readString("Enter status > ");

			Request r = new Request(service, description, date, status);
			return r;

		}

		public static void addRequest(ArrayList<Request> requesttList, Request r) {
			Request service;
			for (int i = 0; i < requesttList.size(); i++) {
				service = requesttList.get(i);
				if (service.getRequestDescription().equalsIgnoreCase(r.getRequestDescription()))
					return;
			}
			if ((r.getRequestDescription().isEmpty()) || (r.getRequestService().isEmpty())) {
				return;
			}
			requesttList.add(r);

		}

		public static String retrieveAllRequest(ArrayList<Request> requesttList) {
			// TODO Auto-generated method stub
			String output = "";
			// write your code here
			for (int i = 0; i < requesttList.size(); i++) {

				output += String.format("%-20s %-20s %-20s %-20s\n", requesttList.get(i).getRequestService(),
						requesttList.get(i).getRequestDescription(), requesttList.get(i).getRequestDate(), requesttList.get(i).getRequestStatus());
			}
			return output;
		}

		public static void viewAllRequest(ArrayList<Request> requesttList) {
			// TODO Auto-generated method stub
			C206_CaseStudy.setHeader("Request List");
			String output = String.format("%-20s %-20s %-20s %-20s\n", "Service", "Description", "Date", "Status");
			output += retrieveAllRequest(requesttList);
			System.out.println(output);
		}

		public static void deleteRequest(ArrayList<Request> requesttList, Request requestDelete) {
			Iterator<Request> iterator = requesttList.iterator();
			while (iterator.hasNext()) {
				Request r = iterator.next();
				if (r.getRequestDescription().equalsIgnoreCase(requestDelete.getRequestDescription())) {
					iterator.remove();
					System.out.println("Request deleted.");
					return;
				}
			}
			System.out.println("Request not found.");
		}


}
