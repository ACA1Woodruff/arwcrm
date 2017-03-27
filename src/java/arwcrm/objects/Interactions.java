package arwcrm.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author awood
 */
public class Interactions implements Serializable {

    private int interactions_id;
    private String first_name;
    private String last_name;
    private String status;
    private String method_of_contact;
    private String email;
    private String phone;
    private String notes;
    private Date contact_date;
    private Customer customer;
    private int Customer_ID;
    private Map<String, String> method_of_contactMap;
    private Map<Integer, String> CustomersMap;

//    public Map<String, String> getStatusMap() {
//        this.statusMap = new LinkedHashMap<String, String>();
//        this.statusMap.put("Active", "Active");
//        this.statusMap.put("Inactive", "Inactive");
//        this.statusMap.put("Prospect", "Prospect");
//        return statusMap;
//    }
    public Map<String, String> getMethod_of_contactMap() {

        this.method_of_contactMap = new LinkedHashMap<String, String>();
        this.method_of_contactMap.put("Direct", "Direct");
        this.method_of_contactMap.put("Phone", "Phone");
        this.method_of_contactMap.put("Email", "Email");
        this.method_of_contactMap.put("Message", "Message");
        return method_of_contactMap;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public int getCustomerID() {
//        return CustomerID;
//    }
//    
//    public void setCustomerID(int CustomerID) {
//        this.CustomerID = CustomerID;
//    }
    
    public int getInteractions_id() {
        return interactions_id;
    }

    public void setInteractions_id(int interactions_id) {
        this.interactions_id = interactions_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod_of_contact() {
        return method_of_contact;
    }

    public void setMethod_of_contact(String method_of_contact) {
        this.method_of_contact = method_of_contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getContact_date() {
        return contact_date;
    }

    public void setContact_date(Date contact_date) {
        this.contact_date = contact_date;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public Map<Integer, String> getCustomersMap() {
        return CustomersMap;
    }

  public void setCustomer(Map<Integer, String> CustomersMap){
      this.CustomersMap = CustomersMap;
  }   
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
//        buffer.append("ID: " + this.interactions_id + ";");
//        buffer.append("First Name: " + first_name);
//        buffer.append("Last Name: " + last_name);
//        buffer.append("Status: " + status);
//        buffer.append("Method of Contact: " + method_of_contact);
//        buffer.append("Email: " + email);
//        buffer.append("Phone: " + phone);
//        buffer.append("Notes: " + notes);
//        buffer.append("Contact Date: " + contact_date);
//        buffer.append("Customer ID: " + this.Customer_ID + ";");
        return buffer.toString();
    }
}
