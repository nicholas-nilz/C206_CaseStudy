import java.util.Date;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 65937
 * Student ID: {22014726}
 * Class: {C206-4-W65C}
 * Date/Time created: Saturday 08-07-2023 14:01
 */

/**
 * @author 65937
 *
 */
public class Request extends User{
    private String requestService;
    private String requestDescription;
    private String requestStatus;

    public Request(String username,String requestService, String requestDescription, String requestStatus) {
        super(username);
    	this.requestService = requestService;
        this.requestDescription = requestDescription;
        this.requestStatus = requestStatus; 
    }



    public String getRequestService() {
        return requestService;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

 public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String status) {
        this.requestStatus = status;
    }
}
