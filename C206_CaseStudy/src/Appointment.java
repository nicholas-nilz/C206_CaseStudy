/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Tan Ying Xi
 * Student ID: 22023689
 * Class: W65C Day 4
 * Date/Time created: Saturday 08-07-2023 14:01
 */

/**
 * @author 65937
 *
 */

public class Appointment {
String date;
String time;
String additional_details;

public Appointment(String date, String time, String additional_details) {
  this.date = date;
  this.time = time;
  this.additional_details = additional_details;  
}

public String getDate() {
  return date;
}

public String getTime() {
	return time;
}

public String getAdditional_details() {
  return additional_details;
}

public String toStirng() {
  String output = super.toString();
  output = String.format("Date: " + getDate() + "\n Time: " + getTime() + "\n Additional Details: " + getAdditional_details());
  
  return output;
}


}