import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 65937
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Saturday 08-07-2023 14:00
 */

/**
 * @author 65937
 *
 */
public class User {
	private String username;
	private String email;
	private int contact_Number;
	private String address;
	private String password;
	private String preference;
	private ArrayList<User> Userlist = new ArrayList<User>();

	
	
public User(String username,String email,int contact_Number,String address,String password) {
	this.username=username;
	this.email=email;
	this.contact_Number=contact_Number;
	this.password=password;
	this.address=address;
	
}



/**
 * @param username2
 */
public User(String username2) {
	this.username=username2;
}

public  String getname() {
  return username;
}

public String getEmail() {
	return email;
}

public int getContact() {
	return contact_Number;
}
public String getAddress() {
	return address;
}
public String getPassword() {
	return password;
}



}
