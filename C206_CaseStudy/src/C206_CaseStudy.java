
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
		
		 

			  int option = 0;
			  while (option != 8) {
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
			    	String username=Helper.readString("Please enter your username");
			     Request r = inputRequest(username);
			     
			

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
			    	C206_CaseStudy.setHeader("View all user");
			    	viewAllUser(registeredUsers);	    
			    }else if(which==2) {
			     //C206_CaseStudy.viewAppointment(appointmentList);
			    }else if(which==3) {
			    	String username=Helper.readString("Please enter the username's request you wan tot display:");
			     C206_CaseStudy.viewAllRequest(requesttList,username);
			    }else if (which==4) {
			     //C206_CaseStudy.viewServiceProvider(quoteList);
			    }else if(which==5) {
			     C206_CaseStudy.viewALLquotes(quoteList);
			    }else if(which==6) {
			     //C206_CaseStudy.viewService(serviceList);
			    }
			    //Delete 
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
			    	String username=Helper.readString("Please enter your username");

			     Request r = inputRequest(username);
			     C206_CaseStudy.deleteRequest(requesttList, r,username);
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
			    
			    //Update
			   } else if (option == 4) {
				   //Update 
				   System.out.println("\n");
				    for (int i = 0; i < list.length; i++) {
				     System.out.println(i + 1 + ":Update " + list[i]);
				    }
					    int which = Helper.readInt("Please Enter a number to Update:");
					    
					    if (which==1) {
					    	C206_CaseStudy.setHeader("View all user");
					    	viewAllUser(registeredUsers);
							System.out.println("");
							int updateID=Helper.readInt("Please enter the ID to update:");
					    	User userUpdate= inputupdateUser(registeredUsers,updateID);
					    	updateUser(registeredUsers,updateID,userUpdate);
					    	
					    }else if(which==2) {
					     //
					    }else if(which==3) {
					    
						 System.out.println("Request deleted");
					    }else if (which==4) {
					     
					    }else if(which==5) {
					     quote quoteinsert = inputQuote();
				         C206_CaseStudy.deleteQuote(quoteList, quoteinsert);
					     System.out.println("Quote deleted");
					    }else if(which==6) {
					     //
					    }
				    }
			   
			   
			   //Search
			   
			   
			   else if(option == 5) {
				 //Search  
				   System.out.println("\n");
				    for (int i = 0; i < list.length; i++) {
				     System.out.println(i + 1 + ":Search " + list[i]);					
			   }
				    int which = Helper.readInt("Please Enter a number to Search:");
				    if (which==1) {
				    	setHeader("Search user");
				    	System.out.println("Search by\n1.Username\n2.Contact number");
				    	int searchby =Helper.readInt("Enter an number to search:");
				    	if(searchby==1) {
				    		String searchUsername= Helper.readString("Enter the user name you want to search:");
				    	    String search=searchUserName(registeredUsers,searchUsername);
				    		if(search!="") {
				    			for (int x=0;x<registeredUsers.size();x++) {
				    				if(registeredUsers.get(x).getname().equalsIgnoreCase(search)) {
				    					//display search result
				    					System.out.println("1 result founded");
				    					   System.out.println(String.format("%-20s %-25s %-15s %-25s\n","Username","Email","Contact Number","Address"));
				    					   System.out.println(String.format("%-20s %-25s %-15s %-25s\n",registeredUsers.get(x).getname(),registeredUsers.get(x).getEmail(),registeredUsers.get(x).getContact(),registeredUsers.get(x).getAddress()));
				    				}}}
				    		else {
				    			System.out.println("There is no such username.\n");
				    		}
				    	}
						if(searchby==2) {
				    		int  searchUsercontact= Helper.readInt("Enter the user contact number you want to search:");		 
				    		int search=searchUserContact(registeredUsers,searchUsercontact);
				    		if(search!=0) {
				    			for (int x=0;x<registeredUsers.size();x++) {
				    				if(registeredUsers.get(x).getContact()==search) {
				    					//display search result
				    					System.out.println("1 result founded");
				    					   System.out.println(String.format("%-20s %-25s %-15s %-25s\n","Username","Email","Contact Number","Address"));
				    					   System.out.println(String.format("%-20s %-25s %-15s %-25s\n",registeredUsers.get(x).getname(),registeredUsers.get(x).getEmail(),registeredUsers.get(x).getContact(),registeredUsers.get(x).getAddress()));
				    				}}
				    		}
				    		else {
				    			System.out.println("There is no such conatct number.\n");
				    		}
						}
				    	
				    }else if(which==2) {
				     //
				    }else if(which==3) {
				    	String username=Helper.readString("Please enter your username");
				     Request r = inputRequest(username);
				     C206_CaseStudy.deleteRequest(requesttList, r,username);
					 System.out.println("Request deleted");
				    }else if (which==4) {
				     
				    }else if(which==5) {
				     quote quoteinsert = inputQuote();
			         C206_CaseStudy.deleteQuote(quoteList, quoteinsert);
				     System.out.println("Quote deleted");
				    }else if(which==6) {
				     //
				    }
			  }
			   
			   //Login
			  if(option ==6) {
				  String loginNAME="";
					 String loginAs="";
					
								boolean loginSuccess=false;
								while (!loginSuccess) {
								    int category = Helper.readInt("Please enter your category:\n1.User\n2.Service Provider");

								    if (category == 1) {
								        String loginName = userLogin(registeredUsers);
								        if (!loginName.isEmpty()) {
								        	loginNAME = loginName;
								            System.out.println("Welcome " + loginName + ", login successful.");
								            loginAs = "user";
								            loginSuccess=true;
								        } else {
								            System.out.println("Login failed, please try again.");
								        }
								    } else if (category == 2) {
								        String loginName = SPLogin(SP_List);
								        if (!loginName.isEmpty()) {
								        	loginNAME = loginName;
								            System.out.println("Welcome " + loginName + ", login successful.");
								            loginAs = "sp";
								            break; 
								        } else {
								            System.out.println("Login failed, please try again.");
								        }}}
								
								
								User loginUSER = null;
								for (int x=0;x<registeredUsers.size();x++) {
									if(loginNAME.equals(registeredUsers.get(x).getname())) {
										loginUSER=registeredUsers.get(x); 
									}
								}
								System.out.println("!"+loginUSER.getname());
								
								System.out.println("1. Deactivate account");
								int navigate=Helper.readInt("Please enter a number to navigate:");
								if(navigate==1) {
									System.out.println("Are you sure you want delete account?(yes/no)"); 
									String delete=Helper.readString("Please enter yes or no:");
									if(delete.equalsIgnoreCase("yes")) {
										int removeID=0;
										for (int x=0;x<registeredUsers.size();x++) {
											if(loginUSER.getname().equals(registeredUsers.get(x).getname())) {
												removeID=x;
											}
										}
										deleteUser(registeredUsers,removeID+1);  

									}
							    	
								}
								
								}
			  
			  if(option ==7) {
				  setHeader("Register User");
				  System.out.println("Alert! email must end with @gmail.com");
				  String username=Helper.readString("\nPlease enter username: ");
					String email=Helper.readString("Please enter email: ");
					int contact=Helper.readInt("Please enter contact number: ");
					String address=Helper.readString("Please enter address: ");
					String password=Helper.readString("Please enter password: ");
					User userADD= new User(username,email,contact,address,password);
			     addUser(registeredUsers,userADD); 
				  
			  }
						   }
			  }
			  
	
			 
		 
		 		 
		 
		 
		
		 
		 
					    
					
					// Code here for the sprint two feature and rmb retrieve the variable loginSuccess as the username and loginAs as the role.
					
					
					
					
					


					
						
				
		
		
			
		
	
	
//test 
	public static void Menu() {
		System.out.println("Enter 1 for Add");
		System.out.println("Enter 2 View All");
		System.out.println("Enter 3 to Delete");
		System.out.println("Enter 4 to Update");
		System.out.println("Enter 5 to Search");
		System.out.println("Enter 6 to Log in");
		System.out.println("Enter 7 to Register");
		System.out.println("Enter 8 to Exit");


	}
	 public static void setHeader(String header) {
		  Helper.line(80, "-");
		  System.out.println(header);
		  Helper.line(80, "-");
		 }
	
	public static void addUser(ArrayList<User> userList,User userAdd) {
		
		
			int before =userList.size();
			User user=userAdd;
			if(user.getEmail().endsWith("@gmail.com")) {
				boolean duplicate=false;
				for (int x=0;x<userList.size();x++) {
					if(userList.get(x).getname().equals(user.getname())) {
						duplicate=true;
						System.out.println("Username existed please try with a another username");
						break;
					}}
				if(duplicate==false) {
					userList.add(userAdd);
				}
				
				
			}
			else {
				System.out.println("Invalid email format(@gmail.com).");
			}
			
			
			
			
			
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
		  
		  System.out.println(String.format("%-5s%-20s %-25s %-15s %-25s\n", "ID", "Username", "Email", "Contact Number", "Address"));

		String output = "";
		
		output+=retrieveUser(userList);
		System.out.println(output);
	}
	
public static User inputupdateUser(ArrayList<User> userList,int updateID) {
		User userUpdate= userList.get(updateID-1);
		String name = userUpdate.getname();
		String email = userUpdate.getEmail();
		int contact = userUpdate.getContact();
		String password = userUpdate.getPassword(); // This is not a recommended practice
		String address = userUpdate.getAddress();
		
		

		System.out.println("1.Username\n2.Email\n3.Contact\n4.Password\n5.Address");
		int update=Helper.readInt("Please enter the number you want to update:");
		if(update==1) {
			String newName=Helper.readString("Please enter yout new name:");
			name=newName;
		}
		else if(update==2) {
			String newEmail=Helper.readString("Please enter yout new email:");
			email=newEmail;
		}
		else if(update==3) {
			int  newContact=Helper.readInt("Please enter yout new contact number:");
			contact=newContact;
				}
		else if(update==4) {
			String newPassword=Helper.readString("Please enter yout new password:");
			password=newPassword;
		}
		else if(update==5) {
			String newAddress=Helper.readString("Please enter yout new address:");
			address=newAddress;
		}
		
		User updatedUser=new User(name,email,contact,password,address);
		return updatedUser;
}
	
	
public static void updateUser(ArrayList<User> userList,int updateID,User userinput) {
		
		userList.set(updateID-1, userinput);
		System.out.println("User update successfully.");
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
	 public static String searchUserName(ArrayList<User> userList,String username) {
			String output="";
			for (int x =0;x<userList.size();x++) {
				if(userList.get(x).getname().equalsIgnoreCase(username)) {
				output=username;					
			}}
			return output;
	}
	 public static int  searchUserContact(ArrayList<User> userList,int contact) {
			
		int output=0;
			for (int x =0;x<userList.size();x++) {
				if(userList.get(x).getContact()==contact) {
				output=contact;					
			}}
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
		   String price = Helper.readString("Enter price > ");
		   String additional = Helper.readString("Enter additional > ");

		   quote quoteinsert= new quote(price,additional);
		   return quoteinsert;
		   
		  }
		  
		  public static void deleteQuote(ArrayList<quote> quoteList, quote quoteToDelete) {
		      Iterator<quote> iterator = quoteList.iterator();
		      while (iterator.hasNext()) {
		          quote item = iterator.next();
		          if (item.getQ_price()==quoteToDelete.getQ_price()) {
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
		    if (item.getQ_price().equalsIgnoreCase(quoteinsert.getQ_price()) )
		     return;
		   }
		   quoteList.add(quoteinsert);
		   
		  }
	 
	 public static Request inputRequest(String username) {
		  String service = Helper.readString("Enter service > ");
		  String description = Helper.readString("Enter description > ");
		  String status = Helper.readString("Enter status > ");

		  Request r = new Request(username, service, description, status);
		  return r;

		 }

		 public static void addRequest(ArrayList<Request> requesttList, Request r) {
		  
			 
			 Request request;
			  for(int i = 0; i < requesttList.size(); i++) {
				  request = requesttList.get(i);
			   if (request.getRequestDescription().equalsIgnoreCase(r.getRequestDescription()) )
			    return;
			  }
			  if ((r.getname().isEmpty()) || (r.getRequestStatus().isEmpty()) ) {
			   return;
			  }
		  requesttList.add(r);

		 }

		 public static String retrieveAllRequest(ArrayList<Request> requesttList, String username) {
		  // TODO Auto-generated method stub
		  String output = "";
		  // write your code here
		  for (int i = 0; i < requesttList.size(); i++) {
		   Request request = requesttList.get(i);
		   if (request.getname().equalsIgnoreCase(username)) {
		    output += String.format("%-20s %-20s %-20s %-20s\n", request.getname(),
		      requesttList.get(i).getRequestService(), requesttList.get(i).getRequestDescription(),
		      requesttList.get(i).getRequestStatus());
		   }
		  }
		  return output;
		 }

		 public static void viewAllRequest(ArrayList<Request> requesttList, String username) {
		  // TODO Auto-generated method stub
		  C206_CaseStudy.setHeader("Request List");
		  String output = String.format("%-20s %-20s %-20s %-20s\n", "Username", "Service", "Description", "Status");
		  output += retrieveAllRequest(requesttList, username);
		  System.out.println(output);
		 }

		 public static void deleteRequest(ArrayList<Request> requesttList, Request requestDelete, String username) {
		  Iterator<Request> iterator = requesttList.iterator();
		  while (iterator.hasNext()) {
		   Request request = iterator.next();
		   if (request.getname().equalsIgnoreCase(username)
		     && request.getRequestDescription().equalsIgnoreCase(requestDelete.getRequestDescription())) {
		    iterator.remove();
		    System.out.println("Request deleted.");
		    return;
		   }
		  }
		  System.out.println("Request not found.");
		 }

		}

		 



