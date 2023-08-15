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
// Updated SP Class
public class Service_Provider extends Service {
    private String companyName;
    private String password;
    private String location;

    public Service_Provider( String companyName, String password, String location, String type, String description,double budget) {
        super(type, description,budget);
        this.location=location;
        this.companyName = companyName;
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPassword() {
        return password;
    }
    public String getlocation() {
    	return location;
    }
}

