/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 65937
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Saturday 08-07-2023 14:02
 */

/**
 * @author 65937
 *
 */
public class Service_Provider {
	String companyName;
	String password;
	String service_category;
	String SP_location;
	public Service_Provider(String companyName,String password,String service_category,String SP_location) {
		this.companyName=companyName;
		this.password=password;
		this.service_category=service_category;
		this.SP_location=SP_location;
	}
	public String getcompanyName() {
		return companyName;
	}
	public String getpassword() {
		return password;
	}
	public String getservice_category() {
		return service_category;
	}
	public String getLocation() {
		return SP_location;
	}

}
