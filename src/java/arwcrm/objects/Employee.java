package arwcrm.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author awood
 */
public class Employee implements Serializable {

    private String EmployeeID;
    private String employeeFirstName;
    private String employeeLastName;
    private String addressLine1;
    private String addressLine2;
    private String homephone;
    private String extension;
    private String email;
    private String deptNumber;
    private String title;
    private Customer customer;
    private Map<Integer, String> customers;

    /**
     *
     * @return
     */
    public Map<Integer, String> getCustomers() {
        return customers;
    }

    /**
     *
     * @param customers
     */
    public void setCustomers(Map<Integer, String> customers) {
        this.customers = customers;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     *
     * @param CustomerID
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    private int CustomerID;

    /**
     *
     * @return
     */
    public String getEmployeeID() {
        return EmployeeID;
    }

    /**
     *
     * @param EmployeeID
     */
    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    /**
     *
     * @return
     */
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    /**
     *
     * @param employeeFirstName
     */
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    /**
     *
     * @return
     */
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    /**
     *
     * @param employeeLastName
     */
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    /**
     *
     * @return
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     *
     * @param address
     */
    public void setAddressLine1(String address) {
        this.addressLine1 = address;
    }

    /**
     *
     * @return
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     *
     * @param address
     */
    public void setAddressLine2(String address) {
        this.addressLine2 = address;
    }

    /**
     *
     * @return
     */
    public String getHomephone() {
        return homephone;
    }

    /**
     *
     * @param homephone
     */
    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    /**
     *
     * @return
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getDeptNumber() {
        return deptNumber;
    }

    /**
     *
     * @param deptNumber
     */
    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getReportsTo() {
        return reportsTo;
    }

    /**
     *
     * @param reportsTo
     */
    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    /**
     *
     * @return
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
    private String reportsTo;
    private int salary;

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("ID: " + this.EmployeeID + ";");
        buffer.append("EmployeeFirstName: " + employeeFirstName);
        buffer.append("EmployeeLastName: " + employeeLastName);
        buffer.append("AddressLine1: " + addressLine1);
        buffer.append("AddressLine2: " + addressLine2);
        buffer.append("HomePhone: " + homephone);
        buffer.append("email: " + email);
        buffer.append("DeptNumber: " + deptNumber);
        buffer.append("Title: " + title);
        return buffer.toString();
    }

}
