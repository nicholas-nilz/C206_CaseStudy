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
public class Service_Provider extends Service {
    private String companyName;
    private String password;

    public Service_Provider(String companyName, String password, String type, String description, String location, double budget) {
        super(type, description, location, budget);
        this.companyName = companyName;
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPassword() {
        return password;
    }
}

