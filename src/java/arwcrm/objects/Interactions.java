/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arwcrm.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author awood
 */
public class Interactions implements Serializable {

    private int interaction_id;
    private String first_name;
    private String last_name;
    private String status;
    private String method_of_contact;
    private String email;
    private String phone;
    private String notes;
    private Map<String, String> contact_type;
    private String contact_date;
    private int CustomerID;
    private Map<String, String> statusMap;

    public Map<String, String> getStatusMap() {
        this.statusMap = new LinkedHashMap<String, String>();
        this.statusMap.put("Active", "Active");
        this.statusMap.put("Inactive", "Inactive");
        this.statusMap.put("prospect", "Prospect");

        return statusMap;
    }

    public Map<String, String> getContact_type() {
        contact_type = new LinkedHashMap<>();
        contact_type.put("Direct", "Direct");
        contact_type.put("Phone", "Phone");
        contact_type.put("Email", "Email");
        contact_type.put("Message", "Message");

        return contact_type;
    }

    public int getInteraction_id() {
        return interaction_id;
    }

    public void setInteraction_id(int interaction_id) {
        this.interaction_id = interaction_id;
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

    public String getContact_date() {
        return contact_date;
    }

    public void setContact_date(String contact_date) {
        this.contact_date = contact_date;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.interaction_id + ";");
        buffer.append("First Name: " + first_name);
        buffer.append("Last Name: " + last_name);
        buffer.append("Status: " + status);
        buffer.append("Method of Contact: " + method_of_contact);
        buffer.append("Email: " + email);
        buffer.append("Phone: " + phone);
        buffer.append("Notes: " + notes);
        buffer.append("Contact Date: " + contact_date);
        buffer.append("Customer ID: " + this.CustomerID + ";");
        return buffer.toString();
    }

}
