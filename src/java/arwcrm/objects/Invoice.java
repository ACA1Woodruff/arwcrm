package arwcrm.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author awood
 */
public class Invoice implements Serializable {

    private String InvoiceID;
    private int customerId;
    private String invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private String billingPhone;
    private String fax;
    private String total;
    private Customer customer;
    private Map<Integer, String> customers;
    private Map<String, String> StatesMap;

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
    public String getInvoiceID() {
        return InvoiceID;
    }

    /**
     *
     * @param InvoiceID
     */
    public void setInvoiceID(String InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    /**
     *
     * @return
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     *
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     *
     * @return
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     *
     * @param invoiceDate
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     *
     * @return
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     *
     * @param billingAddress
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     *
     * @return
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     *
     * @param billingCity
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     *
     * @return
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     *
     * @param billingState
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    /**
     *
     * @return
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     *
     * @param billingCountry
     */
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     *
     * @return
     */
    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    /**
     *
     * @param billingPostalCode
     */
    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    /**
     *
     * @return
     */
    public String getBillingPhone() {
        return billingPhone;
    }

    /**
     *
     * @param billingPhone
     */
    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
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
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *
     * @return
     */
    public String getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(String total) {
        this.total = total;
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
        buffer.append("ID: " + this.InvoiceID + ";");
        buffer.append("CustomerId: " + customerId);
        buffer.append("InvoiceDate: " + invoiceDate);
        buffer.append("BillingAddress: " + billingAddress);
        buffer.append("BillingCity: " + billingCity);
        buffer.append("BillingState: " + billingState);
        buffer.append("BillingCountry: " + billingCountry);
        buffer.append("BillingPhone: " + billingPhone);
        buffer.append("Fax: " + fax);
        buffer.append("Total: " + total);
        return buffer.toString();
    }
}
