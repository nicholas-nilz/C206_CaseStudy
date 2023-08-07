public class quote {
 String Q_details;
 String Q_description;
 
 //user register quote
 public quote(String Q_details,String Q_description) {
  this.Q_details=Q_details;
  this.Q_description=Q_description;
 }

 //service provider view quotes
 public quote(String Q_details,String Q_description,String Q_price,String additional_information) {
  this.Q_details=Q_details;
  this.Q_description=Q_description;
  this.Q_price=Q_price;
  this.additional_information=additional_information;
  
 }
 
 public String getQ_details() {
  return Q_details;
 }

 public void setQ_details(String q_details) {
  Q_details = q_details;
 }

 public String getQ_description() {
  return Q_description;
 }

 public void setQ_description(String q_description) {
  Q_description = q_description;
 }

 public String getQ_price() {
  return Q_price;
 }

 public void setQ_price(String q_price) {
  Q_price = q_price;
 }

 public String getAdditional_information() {
  return additional_information;
 }

 public void setAdditional_information(String additional_information) {
  this.additional_information = additional_information;
 }

 String Q_price;
 String additional_information;
}