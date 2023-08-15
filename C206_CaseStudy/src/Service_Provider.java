/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: WONG YOKE SHAN BRIDGET
 * Student ID: 22013272
 * Class: W65C Day 4
 * Date/Time created: 
 */

// Updated SP Class
public class Service_Provider extends Service {
    private String companyName;
    private String password;
    private String location;

    public Service_Provider(String companyName, String password, String location, String type, String description,double budget) {
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