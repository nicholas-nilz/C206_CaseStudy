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
public class quote {
	String Q_details;
	String Q_description;
	float Q_price;
	String additional_information;
	//user register quote
public quote(String Q_details,String Q_description) {
	this.Q_details=Q_details;
	this.Q_description=Q_description;
}

//service provider view quotes
public quote(String Q_details,String Q_description,float Q_price,String additional_information) {
	this.Q_details=Q_details;
	this.Q_description=Q_description;
	this.Q_price=Q_price;
	this.additional_information=additional_information;
	
}
}
