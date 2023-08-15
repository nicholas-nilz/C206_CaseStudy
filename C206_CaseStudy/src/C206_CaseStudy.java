
import java.util.ArrayList;
import java.util.Iterator;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<quote> quoteList = new ArrayList<quote>();
		ArrayList<Request> requesttList = new ArrayList<Request>();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<User> registeredUsers = new ArrayList<User>();
		ArrayList<Service_Provider> SP_List = new ArrayList<Service_Provider>();
		SP_List.add(new Service_Provider("Nippon", "qwerty", "Cleaning","toilet", "Jurong East",100.0));
		registeredUsers.add(new User("WeiSiang", "ws@gmail.com", 12345, "jalan123", "lol123"));
		String[] list = new String[] { "User", "Appointment", "Request", "Service_Provider", "Quote", "Service" };
		serviceList.add(new Service("Cleaning house","clean backyard","jurong east",100.00));
		requesttList.add(new Request(1, "WeiSiang", "Clean", "Clean backyard", "pending"));
		int option = 0;
		while (option != 6) {
			Menu();
			option = Helper.readInt("Please enter the number: ");

			if (option == 1) {
				System.out.println("\n");
				for (int i = 0; i < list.length; i++) {
					System.out.println(i + 1 + ":Add " + list[i]);
				}
				int which = Helper.readInt("Please Enter a number to Add:");
				if (which == 1) {
					doAddUser( registeredUsers);
				} else if (which == 2) {
					Appointment addApointment1 =inputAppointment();
					addAppointment(appointmentList,addApointment1);

				} else if (which == 3) {
					String username = Helper.readString("Please enter your username > ");				
					Request r = inputRequest(username, requesttList.size()+1);

					C206_CaseStudy.addRequest(requesttList, r);
					System.out.println("Request added");
				} else if (which == 4) {
					//
					String type=Helper.readString("Enter your category: ");
					String description=Helper.readString("Enter description: ");
					double budget=Helper.readDouble("Enter price:");
			    	Service_Provider sp= inputServiceProvider(type,description, budget);
			    	addServiceProvider(SP_List,sp);
				} else if (which == 5) {
					quote quoteinsert = inputQuote();
					C206_CaseStudy.addQuote(quoteList, quoteinsert);
					System.out.println("Quote added");
				} else if (which == 6) {
					setHeader("Add Service");
			        String type=Helper.readString("Please enter type: ");
			           Service s = inputService(type);
			           addService(serviceList, s);
			           System.out.println("Service added.");
				}
				//View
			} else if (option == 2) {
				System.out.println("\n");
				for (int i = 0; i < list.length; i++) {
					System.out.println(i + 1 + ":View " + list[i]);
				}
				int which = Helper.readInt("Please Enter a number to :");
				if (which == 1) {
					C206_CaseStudy.setHeader("View all user");
					viewAllUser(registeredUsers);
				} else if (which == 2) {
					C206_CaseStudy.viewAllAppointment(appointmentList);

				} else if (which == 3) {
					String username = Helper.readString("Please enter the username's request you want to display:");
					C206_CaseStudy.viewAllRequest(requesttList, username);
				} else if (which == 4) {
					String type = Helper.readString("Please enter the category you want to display:");
					C206_CaseStudy.viewAllServiceProvider(SP_List, type);;				
					} else if (which == 5) {
					C206_CaseStudy.viewALLquotes(quoteList);
				} else if (which == 6) {
					C206_CaseStudy.viewAllService(serviceList);				}
				// Delete
			} else if (option == 3) {
				System.out.println("\n");
				for (int i = 0; i < list.length; i++) {
					System.out.println(i + 1 + ":Delete " + list[i]);
				}
				int which = Helper.readInt("Please Enter a number to Delete:");
				if (which == 1) {
					doDeleteUser(registeredUsers);
				} else if (which == 2) {
					Appointment addApointment1 =inputAppointment();
					
					deleteAppointment(appointmentList,addApointment1);
					
					
				} else if (which == 3) {
				     System.out.println("Delete Request");
				     Helper.line(80, "-");
				     System.out.println(String.format("%-5s %-20s %-20s %-20s %-20s", "ID", "Username", "Service",
				       "Description", "Status"));
				     Helper.line(80, "-");
				     for (int n = 0; n < requesttList.size(); n++) {
				      System.out.println(String.format("%-5s %-20s %-20s %-20s %-20s\n", n + 1,
				        requesttList.get(n).getname(), requesttList.get(n).getRequestService(),
				        requesttList.get(n).getRequestDescription(), requesttList.get(n).getRequestStatus()));
				     }
				     String username= Helper.readString("Please enter the username: ");
				     int removeID = Helper.readInt("Please enter the ID to remove: ");
				     
				     
				     C206_CaseStudy.deleteRequest(requesttList, username, removeID);
				} else if (which == 4) {
					int id=Helper.readInt("Enter your ID: ");
			     C206_CaseStudy.deleteServiceProvider(SP_List,id );
				} else if (which == 5) {
					quote quoteinsert = inputQuote();
					C206_CaseStudy.deleteQuote(quoteList, quoteinsert);
					System.out.println("Quote deleted");
				} else if (which == 6) {
					  String sd=Helper.readString("Enter service type:");
				        Service serviceInsert = inputService(sd);
				            C206_CaseStudy.deleteService(serviceList, serviceInsert, sd);
				         System.out.println("Service deleted");
				}

				
			} 

			// Login
			if (option == 4) {
				String loginNAME = "";
				String loginAs = "";

				boolean loginSuccess = false;
				while (!loginSuccess) {
					int category = Helper.readInt("Please enter your category:\n1.User\n2.Service Provider");

					if (category == 1) {
						String loginName = userLogin(registeredUsers);
						if (!loginName.isEmpty()) {
							loginNAME = loginName;
							System.out.println("Welcome " + loginName + ", login successful.");
							loginAs = "user";
							loginSuccess = true;
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
						}
					}
				}

				User loginUSER = null;
				int UserID=0;
				for (int x = 0; x < registeredUsers.size(); x++) {
					if (loginNAME.equals(registeredUsers.get(x).getname())) {
						loginUSER = registeredUsers.get(x);
						UserID=x;
					}
				}

				
				int navigate=100;
				while (navigate!=1) {
					System.out.println("1.Exit");
					System.out.println("2. View all service");
					System.out.println("3. Add request");
					System.out.println("4. Deactivate account");
					System.out.println("5. Update account");
					if(requesttList.size()!=0) {
						System.out.println("6. View Request");}
					
				
					
					
				    navigate = Helper.readInt("Please enter a number to navigate:");
					
					 if(navigate==2) {
						C206_CaseStudy.viewAllService(serviceList);

						
					}
					else if(navigate==3) {
						C206_CaseStudy.viewAllService(serviceList);
						Request r = inputRequest(loginUSER.getname(), navigate);
						C206_CaseStudy.addRequest(requesttList, r);
						System.out.println("Request added");
					}
					else if (navigate == 4) {
						System.out.println("Are you sure you want delete account?(yes/no)");
						String delete = Helper.readString("Please enter yes or no:");
						if (delete.equalsIgnoreCase("yes")) {
							int removeID = 0;
							for (int x = 0; x < registeredUsers.size(); x++) {
								if (loginUSER.getname().equals(registeredUsers.get(x).getname())) {
									removeID = x;
								}
							}
							
							deleteUser(registeredUsers, removeID + 1);
						}
					}
					else if(navigate==6) {
						C206_CaseStudy.viewAllRequest(requesttList, loginUSER.getname());
					}
					else if (navigate==5) {
						updateUser(registeredUsers, UserID, inputupdateUser(registeredUsers,UserID));
					}
					 
				}

			}

			if (option == 5) {
				setHeader("Register User");
				System.out.println("Alert! email must end with @gmail.com");
				String username = Helper.readString("\nPlease enter username: ");
				String email = Helper.readString("Please enter email: ");
				int contact = Helper.readInt("Please enter contact number: ");
				String address = Helper.readString("Please enter address: ");
				String password = Helper.readString("Please enter password: ");
				User userADD = new User(username, email, contact, address, password);
				addUser(registeredUsers, userADD);

			}}
		}


	
	private static void doDeleteUser(ArrayList<User> registeredUsers) {
		System.out.println("Delete User");
		Helper.line(80, "-");
		System.out.println(String.format("%-5s%-20s %-25s %-15s %-25s", "ID", "Username", "Email",
				"Contact Number", "Address"));
		Helper.line(80, "-");
		for (int x = 0; x < registeredUsers.size(); x++) {
			System.out.println(String.format("%-5d%-20s %-25s %-15d %-25s\n", x + 1,
					registeredUsers.get(x).getname(), registeredUsers.get(x).getEmail(),
					registeredUsers.get(x).getContact(), registeredUsers.get(x).getAddress()));
		}
		int removeID = Helper.readInt("Please enter the ID to remove:");
		char confirm =  Helper.readChar("Are you sure you wan tot delete(y/n):");
		if(confirm=='y') {
			deleteUser(registeredUsers, removeID);
		}
	}
	

	// Code here for the sprint two feature and rmb retrieve the variable
	// loginSuccess as the username and loginAs as the role.

//test 
	public static void Menu() {
		System.out.println("Enter 1 for Add");
		System.out.println("Enter 2 View All");
		System.out.println("Enter 3 to Delete");
		System.out.println("Enter 4 to Log in");
		System.out.println("Enter 5 to Register");
		System.out.println("Enter 6 to Exit");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void addUser(ArrayList<User> userList, User userAdd) {

		int size = userList.size();
		int before = size;
		User user = userAdd;
		String email = user.getEmail();
		if (email.endsWith("@gmail.com")) {
			boolean duplicate = false;
			for (int x = 0; x < size; x++) {
				String nameInTheList = userList.get(x).getname();
				String inputName = user.getname();
				if (nameInTheList.equals(inputName)) {
					duplicate = true;
					System.out.println("Username existed please try with a another username");
					break;
				}
			}
			if (duplicate == false) {
				userList.add(userAdd);
			}

		} else {
			System.out.println("Invalid email format(@gmail.com).");
		}

		int after = size;
		if (after > before) {
			System.out.println("\nUser added successfully");
		}
	}

	public static boolean deleteUser(ArrayList<User> userList, int removeID) {
		boolean output =false;
		if(userList.size()>0) {
			userList.remove(removeID - 1);
			System.out.println("User remove successfully.");
			output=true;
		}
		else {
			System.out.println("there is no user to remove.");
		}
		return output;
	}

	public static void viewAllUser(ArrayList<User> userList) {

		System.out.println(
				String.format("%-5s%-20s %-25s %-15s %-25s\n", "ID", "Username", "Email", "Contact Number", "Address"));

		String output = "";

		output += retrieveUser(userList);
		System.out.println(output);
	}

	public static User inputupdateUser(ArrayList<User> userList, int updateID) {
		User userUpdate = userList.get(updateID );
		String name = userUpdate.getname();
		String email = userUpdate.getEmail();
		int contact = userUpdate.getContact();
		String password = userUpdate.getPassword(); 
		String address = userUpdate.getAddress();

		System.out.println("1.Username\n2.Email\n3.Contact\n4.Password\n5.Address");
		int update = Helper.readInt("Please enter the number you want to update:");
		if (update == 1) {
			String newName = Helper.readString("Please enter yout new name:");
			name = newName;
		} else if (update == 2) {
			String newEmail = Helper.readString("Please enter yout new email:");
			email = newEmail;
		} else if (update == 3) {
			int newContact = Helper.readInt("Please enter yout new contact number:");
			contact = newContact;
		} else if (update == 4) {
			String newPassword = Helper.readString("Please enter yout new password:");
			password = newPassword;
		} else if (update == 5) {
			String newAddress = Helper.readString("Please enter yout new address:");
			address = newAddress;
		}

		User updatedUser = new User(name, email, contact, password, address);
		return updatedUser;
	}

	public static void updateUser(ArrayList<User> userList, int updateID, User userinput) {

		userList.set(updateID , userinput);
		System.out.println("User update successfully.");
	}

	public static String retrieveUser(ArrayList<User> userList) {
		// TODO Auto-generated method stub
		String output = "";
		// write your code here
		for (int x = 0; x < userList.size(); x++) {

			String username = userList.get(x).getname();
			String email = userList.get(x).getEmail();
			int contact_number = userList.get(x).getContact();
			String address = userList.get(x).getAddress();
			output += String.format("%-5d%-20s %-25s %-15d %-25s\n", x + 1, username,
					email, contact_number, address);
		}
		return output;
	}

	

	public static String userLogin(ArrayList<User> registeredUsers) {
		System.out.println("Login as User");
		String username = Helper.readString("Please enter your username: ");
		String password = Helper.readString("Please enter your password: ");
		String LoginUsername = "";

		int size = registeredUsers.size();
		for (int x = 0; x < size; x++) {
						String getname = registeredUsers.get(x).getname();
						if (username.equals(getname)
					&& password.equals(registeredUsers.get(x).getPassword())) {
				LoginUsername = getname;
				break;
			}

		}
		return LoginUsername;

	}

	public static String SPLogin(ArrayList<Service_Provider> SP_List) {
		System.out.println("Login as Service Provider");
		String username = Helper.readString("Please enter your username: ");
		String password = Helper.readString("Please enter your password: ");
		String LoginUsername = "";

		for (int x = 0; x < SP_List.size(); x++) {
			System.out.println(username.equals(SP_List.get(x).getCompanyName()));
			System.out.println(password.equals(SP_List.get(x).getPassword()));

			if (username.equals(SP_List.get(x).getCompanyName()) && password.equals(SP_List.get(x).getPassword())) {
				LoginUsername = SP_List.get(x).getCompanyName();
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

			output += String.format("%-20s %-20s\n", quoteList.get(i).getQ_details(),
					quoteList.get(i).getQ_description());
		}
		return output;
	}

	public static void viewALLquotes(ArrayList<quote> quoteList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("Quote LIST");
		String output = String.format("%-20s %-20s\n", "Details", "Description");
		output += retrieveAllQuotes(quoteList);
		System.out.println(output);
	}

	public static quote inputQuote() {
		String price = Helper.readString("Enter price > ");
		String additional = Helper.readString("Enter additional > ");

		quote quoteinsert = new quote(price, additional);
		return quoteinsert;

	}

	public static void deleteQuote(ArrayList<quote> quoteList, quote quoteToDelete) {
		Iterator<quote> iterator = quoteList.iterator();
		while (iterator.hasNext()) {
			quote item = iterator.next();
			if (item.getQ_price() == quoteToDelete.getQ_price()) {
				iterator.remove();
				System.out.println("Quote deleted.");
				return; // Exit the loop after deleting one quote
			}
		}
		System.out.println("Quote not found.");
	}

	public static void addQuote(ArrayList<quote> quoteList, quote quoteinsert) {
		quote item;
		for (int i = 0; i < quoteList.size(); i++) {
			item = quoteList.get(i);
			if (item.getQ_price()==(quoteinsert.getQ_price()))
				return;
		}
		quoteList.add(quoteinsert);

	}

	public static Request inputRequest(String username, int id) {
		String service = Helper.readString("Enter service > ");
		String description = Helper.readString("Enter description > ");
		String status = "Pending";

		Request r = new Request(id, username, service, description, status);
		return r;

	}

	public static void addRequest(ArrayList<Request> requesttList, Request r) {

		Request request;
		for (int i = 0; i < requesttList.size(); i++) {
			request = requesttList.get(i);
			if (request.getRequestDescription().equalsIgnoreCase(r.getRequestDescription()))
				return;
		}
		if ((r.getname().isEmpty()) || (r.getRequestStatus().isEmpty())) {
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

	public static void deleteRequest(ArrayList<Request> requesttList, String username, int removeID) {
		Iterator<Request> iterator = requesttList.iterator();
		while (iterator.hasNext()) {
			Request request = iterator.next();
			if (request.getname().equalsIgnoreCase(username) && request.getRequestId() == removeID) {
				iterator.remove();
				System.out.println("Request deleted.");
				return;
			}
		}
		System.out.println("Request not found.");
	}
	
	public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
		// TODO Auto-generated method stub
		String output = "";
		// write your code here
		for (int i = 0; i < appointmentList.size(); i++) {

			output += String.format("%-20s %-20s %-20s \n", appointmentList.get(i).getDate(),
					appointmentList.get(i).getTime(), appointmentList.get(i).getAdditional_details());
		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
		C206_CaseStudy.setHeader("Appointment List");
		String output = String.format("%-20s %-20s %-20s \n", "Date", "Time", "Additional Details");
		output += retrieveAllAppointment(appointmentList);
		System.out.println(output);
	}

	public static void deleteAppointment(ArrayList<Appointment> AppointmentList,Appointment delete) {
		Iterator<Appointment> iterator = AppointmentList.iterator();
		while (iterator.hasNext()) {
			Appointment A = iterator.next();
			if (A.getAdditional_details().equalsIgnoreCase(delete.getAdditional_details())) {
				iterator.remove();
				System.out.println("Appointment deleted.");
				return;
			}
		}
		System.out.println("Appointment not found.");
	}
	
	
	
	

	public static void addAppointment(ArrayList<Appointment> AppointmentList, Appointment A) {
		Appointment booking;
		for (int i = 0; i < AppointmentList.size(); i++) {
			booking = AppointmentList.get(i);
			if (booking.getAdditional_details().equalsIgnoreCase(A.getAdditional_details()))
				return;
		}
		if ((A.getTime().isEmpty()) || (A.getTime().isEmpty())) {
			return;
		}
		AppointmentList.add(A);

	}

	public static Appointment inputAppointment() {
		String date = Helper.readString("Enter Date > ");
		String time = Helper.readString("Enter Time > ");
		String additional_details = Helper.readString("Enter Additional Details > ");

		Appointment A = new Appointment(date, time, additional_details);
		return A;

	}
	
	//Service Provider
		public static Service_Provider inputServiceProvider(String type,String description,double budget) {
			  String CompanyName = Helper.readString("Enter Company Name: ");
			  String password=Helper.readString("Enter the password: ");
			  String location=Helper.readString("Enter address: ");

			  

			  Service_Provider sp = new Service_Provider(CompanyName, password, type,description, location,budget);
			  return sp;

			 }
		public static void addServiceProvider(ArrayList<Service_Provider> SP_List, Service_Provider sp) {
			Service_Provider provider;
			for (int i = 0; i < SP_List.size(); i++) {
				provider = SP_List.get(i);
				if (provider.getCompanyName().equalsIgnoreCase(sp.getCompanyName()))
					return;
			}
			if ((sp.getType().isEmpty()) || (sp.getCompanyName().isEmpty())) {
				return;
			}
			SP_List.add(sp);
		}

		public static String retrieveAllServiceProvider(ArrayList<Service_Provider> SP_List, String type) {
			// TODO Auto-generated method stub
			String output = "";
			// write your code here
			for (int i = 0; i < SP_List.size(); i++) {
				Service_Provider sp = SP_List.get(i);
				if (sp.getType().equalsIgnoreCase(type)) {
					output += String.format("%-20s %-20s %-20s %-20s\n", sp.getType(),
							SP_List.get(i).getCompanyName(), SP_List.get(i).getPassword(),
							SP_List.get(i).getLocation());
				}
			}
			return output;
		}

		public static void viewAllServiceProvider(ArrayList<Service_Provider> SP_List, String type) {
			// TODO Auto-generated method stub
			C206_CaseStudy.setHeader("Request List");
			String output = String.format("%-20s %-20s %-20s\n", "Company Name", "Service", "Location");
			output += retrieveAllServiceProvider(SP_List, type);
			System.out.println(output);
		}

		public static boolean deleteServiceProvider(ArrayList<Service_Provider> SP_List, int SP_ID) {
			boolean output =false;
			if(SP_List.size()>0) {
				SP_List.remove(SP_ID - 1);
				System.out.println("Service Provider is removed successfully.");
				output=true;
			}
			else {
				System.out.println("there is no Service Provider to remove.");
			}
			return output;
		}
	
	public static Service inputService(String type) {
	      String description = Helper.readString("Enter description: ");
	      String location = Helper.readString("Enter location: ");
	      float budget = Helper.readFloat("Enter budget: ");

	      Service s = new Service(type, description, location, budget);
	      return s;
	  }


	  public static void addService(ArrayList<Service> serviceList, Service s) {
	      for (Service service : serviceList) {
	          if (service.getType().equalsIgnoreCase(s.getType())) {
	              System.out.println("Service with the same type already exists. Cannot add duplicate.");
	              return;
	          }
	      }
	      
	      if (s.getType().isEmpty() || s.getDescription().isEmpty()) {
	          System.out.println("Service type cannot be empty. Service not added.");
	          return;
	      }
	      serviceList.add(s);
	      System.out.println("Service added.");
	  }


	   public static String retrieveAllService(ArrayList<Service> serviceList) {
	    String output = "";
	    for (Service s: serviceList) {
	     output += String.format("%-20s %-20s %-20s %-20s\n", s.getType(), s.getDescription(), s.getLocation(), s.getBudget());
	    }
	    return output;
	   }

	  public static void viewAllService(ArrayList<Service> serviceList) {
	    C206_CaseStudy.setHeader("Service List");
	    String output = String.format("%-20s %-20s %-20s %-20s\n", "Type", "Description", "Location", "Budget");
	    output += retrieveAllService(serviceList);
	    System.out.println(output);
	   }

	   public static void deleteService(ArrayList<Service> serviceList, Service serviceDelete, String S_List) {
	    Iterator<Service> iterator = serviceList.iterator();
	    boolean found=false;
	    while (iterator.hasNext()) {
	     Service service = iterator.next();
	     if (service.getType().equalsIgnoreCase(S_List)
	       && service.getType().equalsIgnoreCase(serviceDelete.getType())) {
	      iterator.remove();
	      found = true;
	      break;
	     }
	    }
	    if (found) {
	    System.out.println("Service deleted.");
	   } else {
	    System.out.println("Service not found.");
	   }
	   }
	//test

		public static void doAddUser(ArrayList<User> registeredUsers) {
			String username = Helper.readString("\nPlease enter username: ");
			String email = Helper.readString("Please enter email: ");
			int contact = Helper.readInt("Please enter contact number: ");
			String address = Helper.readString("Please enter address: ");
			String password = Helper.readString("Please enter password: ");
			User userADD = new User(username, email, contact, address, password);
			addUser(registeredUsers, userADD);
		}}

//testpull
	

