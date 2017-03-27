package arwcrm.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author awood
 */
public class Customer implements Serializable {

    private int CustomerID;
    private String customerName;
    private String customerContactLastName;
    private String customerContactFirstName;
    private String phone;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String employeeID;

//    private String salesRepEmployeeNumber;
    private String creditLimit;
//    private Customer customer;
    private Map<Integer, String> customer;
    private Map<String, String> JobCatMap;
    private Map<String, String> JobProMap;
    private Map<String, String> StatesMap;

//    public String getSalesRepEmployeeNumber() {
//        return salesRepEmployeeNumber;
//    }
//
//    public void setSalesRepEmployeeNumber(String salesRepEmployeeNumber) {
//        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
//    }
    public Map<Integer, String> getCustomer() {

        return customer;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContactLastName() {
        return customerContactLastName;
    }

    public void setCustomerContactLastName(String customerContactLastName) {
        this.customerContactLastName = customerContactLastName;
    }

    public String getCustomerContactFirstName() {
        return customerContactFirstName;
    }

    public void setCustomerContactFirstName(String customerContactFirstName) {
        this.customerContactFirstName = customerContactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Map<String, String> getJobCatMap() {

        JobCatMap = new LinkedHashMap<String, String>();
        JobCatMap.put("Developer I", "Developer I");
        JobCatMap.put("Developer II", "Developer II");
        JobCatMap.put("Developer Sr", "Developer Sr");
        JobCatMap.put("Web Administrator", "Web Administrator");
        return JobCatMap;
    }

    public Map<String, String> getJobProMap() {

        JobProMap = new LinkedHashMap<String, String>();
        JobProMap.put("Prospect", "Prospect");
        JobProMap.put("Client", "Client");
        JobProMap.put("Inactive", "Inactive");

        return JobProMap;
    }

    public Map<String, String> getStatesMap() {

        this.StatesMap = new LinkedHashMap<String, String>();
        this.StatesMap.put(
                "AL - Alabama", "AL - Alabama");
        this.StatesMap.put(
                "AK - Alaska", "AK - Alaska");
        this.StatesMap.put(
                "AZ - Arizona", "AZ - Arizona");
        this.StatesMap.put(
                "AR - Arkansas", "AR - Arkansas");
        this.StatesMap.put(
                "CA - California", "CA - California");
        this.StatesMap.put("CO - Colorado", "CO - Colorado");
        this.StatesMap.put("DE - Delaware", "DE - Delaware");
        this.StatesMap.put(
                "FL - Florida", "FL - Florida");
        this.StatesMap.put(
                "GA - Georgia", "GA - Georgia");
        this.StatesMap.put(
                "HI - Hawaii", "HI - Hawaii");
        this.StatesMap.put(
                "ID - Idaho", "ID - Idaho");
        this.StatesMap.put(
                "IL - Illinois", "IL - Illinois");
        this.StatesMap.put(
                "IN - Indiana", "IN - Indiana");
        this.StatesMap.put(
                "IA - Iowa", "IA - Iowa");
        this.StatesMap.put(
                "KS - Kansas", "KS - Kansas");
        this.StatesMap.put(
                "KY - Kentucky", "KY - Kentucky");
        this.StatesMap.put(
                "LA - Louisiana", "LA - Louisiana");
        this.StatesMap.put(
                "ME - Maine", "ME - Maine");
        this.StatesMap.put(
                "MD - Maryland", "MD - Maryland");
        this.StatesMap.put(
                "MA - Massachusetts", "MA - Massachusetts");
        this.StatesMap.put(
                "MI - Michigan", "MI - Michigan");
        this.StatesMap.put(
                "MN - Minnesota", "MN - Minnesota");
        this.StatesMap.put(
                "MS - Mississippi:", "MS - Mississippi");
        this.StatesMap.put(
                "MO - Missouri", "MO - Missouri");
        this.StatesMap.put(
                "MT - Montana", "MT - Montana");
        this.StatesMap.put(
                "NE - Nebraska", "NE - Nebraska");
        this.StatesMap.put(
                "NV - Nevada", "NV - Nevada");
        this.StatesMap.put(
                "NH - New Hampshire", "NH - New Hampshire");
        this.StatesMap.put(
                "NJ - New Jersey", "NJ - New Jersey");
        this.StatesMap.put(
                "NM - New Mexico", "NM - New Mexico");
        this.StatesMap.put(
                "NY - New York", "NY - New York");
        this.StatesMap.put(
                "NC - North Carolina", "NC - North Carolina");
        this.StatesMap.put(
                "ND - North Dakota", "ND - North Dakota");
        this.StatesMap.put(
                "OH - Ohio", "OH - Ohio");
        this.StatesMap.put(
                "OK - Oklahoma", "OK - Oklahoma");
        this.StatesMap.put(
                "OR - Oregon", "OR - Oregon");
        this.StatesMap.put(
                "PA - Pennsylvania", "PA - Pennsylvania");
        this.StatesMap.put(
                "RI - Rhode Island", "RI - Rhode Island");
        this.StatesMap.put(
                "SC - South Carolina", "SC - South Carolina");
        this.StatesMap.put(
                "SD - South Dakota", "SD - South Dakota");
        this.StatesMap.put(
                "TN - Tennessee", "TN - Tennessee");
        this.StatesMap.put(
                "TX - Texas", "TX - Texas");
        this.StatesMap.put(
                "UT - Utah", "UT - Utah");
        this.StatesMap.put(
                "VT - Vermont", "VT - Vermont");
        this.StatesMap.put(
                "VA - Virginia", "VA - Virginia");
        this.StatesMap.put(
                "WA - Washington", "WA - Washington");
        this.StatesMap.put(
                "WV - West Virginia", "WV - West Virginia");
        this.StatesMap.put(
                "WI - Wisconsin", "WI - Wisconsin");
        this.StatesMap.put(
                "WY - Wyoming", "WY - Wyoming");
        this.StatesMap.put(
                "AS - American Samoa", "AS - American Samoa");
        this.StatesMap.put(
                "DC - District of Columbia", "DC - District of Columbia");
        this.StatesMap.put(
                "FM - Federated States of Micronesia", "FM - Federated States of Micronesia");
        this.StatesMap.put("GU - Guam", "GU - Guam");
        this.StatesMap.put(
                "MH - Marshall Islands", "MH - Marshall Islands");
        this.StatesMap.put(
                "MP - Northern Mariana Islands", "MP - Northern Mariana Islands");
        this.StatesMap.put(
                "PW - Palau", "PW - Palau");
        this.StatesMap.put(
                "PR - Puerto Rico", "PR - Puerto Rico");
        this.StatesMap.put(
                "VI - Virgin Islands", "VI - Virgin Islands");
        this.StatesMap.put(
                "AE - Armed Forces Africa", "AE - Armed Forces Africa");
        this.StatesMap.put(
                "AA - Armed Forces Americas", "AA - Armed Forces Americas");
        this.StatesMap.put(
                "AE - Armed Forces Canada", "AE - Armed Forces Canada");
        this.StatesMap.put(
                "AE - Armed Forces Europe", "AE - Armed Forces Europe");
        this.StatesMap.put(
                "AE - Armed Forces Middle East", "AE - Armed Forces Middle East");
        this.StatesMap.put(
                "(AP - Armed Forces Pacific", "AP - Armed Forces Pacific");

        return StatesMap;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.CustomerID + ";");
        buffer.append("CustomerName: " + customerName);
        buffer.append("CustomerContactLastName: " + customerContactLastName);
        buffer.append("CustomerContactFirstName: " + customerContactLastName);
        buffer.append("Phone: " + phone);
        buffer.append("Email: " + email);
        buffer.append("AddressLine1: " + addressLine1);
        buffer.append("AddressLine2: " + addressLine2);
        buffer.append("AddressLine3: " + addressLine3);
        buffer.append("City: " + city);
        buffer.append("State: " + state);
        buffer.append("PostalCode: " + postalCode);
        buffer.append("Country: " + country);
//        buffer.append("SalesRepEmployeeNumber: " + salesRepEmployeeNumber);
        buffer.append("CreditLimit: " + creditLimit);
        return buffer.toString();
    }

}
