package arwcrm.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author awood
 */
public class Employee implements Serializable {

    private int EmployeeID;
    private String employeeLastName;
    private String employeeFirstName;
    private String address;
//    private String addressLine2;
    private String homePhone;
    private String extension;
    private String email;
    private String deptNumber;
    private String title;
    private String startDate;
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
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     *
     * @param EmployeeID
     */
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
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
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

//    /**
//     *
//     * @return
//     */
//    public String getAddressLine2() {
//        return addressLine2;
//    }
//
//    /**
//     *
//     * @param address
//     */
//    public void setAddressLine2(String address) {
//        this.addressLine2 = address;
//    }
    /**
     *
     * @return
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     *
     * @param homephone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
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
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
        buffer.append("Address: " + address);
//      buffer.append("AddressLine2: " + addressLine2);
        buffer.append("HomePhone: " + homePhone);
        buffer.append("email: " + email);
        buffer.append("DeptNumber: " + deptNumber);
        buffer.append("Title: " + title);
        buffer.append("StartDate: " + startDate);
        return buffer.toString();
    }

}
