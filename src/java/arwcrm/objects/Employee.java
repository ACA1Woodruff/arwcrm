package arwcrm.objects;

import java.io.Serializable;

/**
 *
 * @author awood
 */
public class Employee implements Serializable {

    private int EmployeeID;
    private String employeeFirstName;
    private String employeeLastName;
    private String address1;
    private String address2;
    private String homephone;
    private String extension;
    private String email;
    private String deptNumber;
    private String title;

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
    public String getAddress1() {
        return address1;
    }

    /**
     *
     * @param address1
     */
    public void setAddress1(String address) {
        this.address1 = address;
    }

    /**
     *
     * @return
     */
    public String getAddress2() {
        return address2;
    }

    /**
     *
     * @param address2
     */
    public void setAddress2(String address) {
        this.address2 = address;
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
        return buffer.toString();
    }
}
