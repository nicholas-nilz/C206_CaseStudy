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
public class Request {
    private String requestService;
    private String requestDescription;
    private Date requestDate;
    private String requestStatus;

    public Request(String requestService, String requestDescription, String requestDate, String requestStatus) {
        this.requestService = requestService;
        this.requestDescription = requestDescription;
        this.requestDate = new Date();
        this.requestStatus = "Pending"; 
    }



    public String getRequestService() {
        return requestService;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String status) {
        this.requestStatus = status;
    }
}

