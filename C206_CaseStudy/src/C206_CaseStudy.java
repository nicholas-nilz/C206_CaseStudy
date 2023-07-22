
import java.util.ArrayList;

public class C206_CaseStudy {


	public static void main(String[] args) {

		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<quote> quoteList = new ArrayList<quote>();
		ArrayList<Request> requesttList = new ArrayList<Request>();
		ArrayList<Service_Provider> SP_List = new ArrayList<Service_Provider>();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<User> userList = new ArrayList<User>();
		 String[] list = new String[] { "User", "Appointment", "Request", "Service_Provider", "Quote",
				"Service" };
		 
		int option = 0;
		while (option != 4) {
			Menu();
			option = Helper.readInt("Pleasae enter the number: ");

			if (option == 1) {
				System.out.println("\n");
				for (int i = 0; i < list.length; i++) {
					System.out.println(i + 1 + ":Add " + list[i]);
				}
				int which = Helper.readInt("Please Enter a number to Add:");
				if (which==1) {
					addUser(userList,list);
					
					}
					
					
				
				
				
				
				
				
				
			} else if (option == 2) {
				System.out.println("\n");
				for (int i = 0; i < list.length; i++) {
					System.out.println(i + 1 + ":View " + list[i]);
				}
				int which = Helper.readInt("Please Enter a number to View:");
				if (which==1) {
					addUser(userList,list);

			} else if (option == 3) {

			} else if (option == 5) {

			}
			option =Helper.readInt("Pleasae enter the number: ");

		}
	}

	public static void Menu() {
		System.out.println("Enter 1 for ADD section");
		System.out.println("Enter 2 for View section");
		System.out.println("Enter 3 for Delete section");
		System.out.println("Enter 4 to exit\n");
	}
	public static void addUser(ArrayList<User> userList,String[] list) {
		
			String username=Helper.readString("\nPlease enter username: ");
			String email=Helper.readString("Please enter email: ");
			int contact=Helper.readInt("Please enter contact number: ");
			String address=Helper.readString("Please enter address: ");
			String password=Helper.readString("Please enter password: ");
			int before =userList.size();
			userList.add(new User(username, email,contact,address,password));
			int after  =userList.size();
			if(after>before) {
				System.out.println("\nUser added successfully");
				System.out.println("Username: "+username);
				System.out.println("Email: "+email);
				System.out.println("Contact: "+contact);
				System.out.println("Address: "+address);
			
			}
	}
	

	}

}
