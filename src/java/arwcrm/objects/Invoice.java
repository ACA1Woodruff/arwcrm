package arwcrm.objects;

import java.io.Serializable;

/**
 *
 * @author awood
 */
public class Invoice implements Serializable {

    private int id;
    private String customerId;
    private String invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private String billingPhone;
    private String fax;
    private String total;

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
    public String getCustomerId() {
        return customerId;
    }

    /**
     *
     * @param customerId
     */
    public void setCustomerId(String customerId) {
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

    /**
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
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
