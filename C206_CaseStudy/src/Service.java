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

public class Service {
 String S_type;
 String S_description;
 double S_budget;

public Service(String type, String description, double budget) {
 this.S_type=type;
 this.S_description=description;
 this.S_budget=budget;
}

public String getType() {
 return S_type;
}
public String getDescription () {
 return S_description;
}

public double getBudget() {
 return S_budget;
}

public String toString() {
 String output=super.toString();
 output=String.format("%-63s %-20s", output,S_type, S_description,S_budget);
 
 return output;
}
}