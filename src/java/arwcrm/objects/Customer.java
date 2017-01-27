package arwcrm.objects;

import java.io.Serializable;

/**
 *
 * @author awood
 */
public class Customer implements Serializable {

    private int id;
    private String name;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String fax;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String salesRepEmployeeNumber;
    private String creditLimit;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getContactLastName() {
        return contactLastName;
    }

    /**
     *
     * @param contactLastName
     */
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    /**
     *
     * @return
     */
    public String getContactFirstName() {
        return contactFirstName;
    }

    /**
     *
     * @param contactFirstName
     */
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getFax() {
        return fax;
    }

    /**
     *
     * @param phone
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * @param addressLine1
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
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
     * @param addressLine2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     *
     * @return
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     *
     * @param addressLine3
     */
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    /**
     *
     * @param salesRepEmployeeNumber
     */
    public void setSalesRepEmployeeNumber(String salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    /**
     *
     * @return
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     *
     * @param creditLimit
     */
    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("ContactFirstName: " + contactFirstName);
        buffer.append("ContactLastName: " + contactLastName);
        buffer.append("Phone: " + phone);
        buffer.append("AddressLine1: " + addressLine1);
        buffer.append("AddressLine2: " + addressLine2);
        buffer.append("AddressLine3: " + addressLine3);
        buffer.append("City: " + city);
        buffer.append("State: " + state);
        buffer.append("PostalCode: " + postalCode);
        buffer.append("Country: " + country);
        buffer.append("SalesRepEmployeeNumber: " + salesRepEmployeeNumber);
        buffer.append("CreditLimit: " + creditLimit);
        return buffer.toString();
    }

}
