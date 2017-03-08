package arwcrm.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import arwcrm.objects.Invoice;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class InvoiceDAO {

    JdbcTemplate template;
//    private Object id;

    private static final Logger logger = Logger.getLogger(InvoiceDAO.class.getName());
    private int id;

    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     *
     * @param invoice
     * @return
     */
    public int save(Invoice invoice) {
        String sql = "INSERT INTO INVOICE (`invoiceId`,`PurchaseOrder`,`CustomerID`,`InvoiceDate`,`BillingAddress`,`BillingCity`,`BillingState`,`BillingCountry`,`BillingPostalCode`,`BillingPhone`,`Fax`,`Total`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {invoice.getInvoiceID(), invoice.getPurchaseOrder(), invoice.getCustomerId(), invoice.getInvoiceDate(), invoice.getBillingAddress(), invoice.getBillingCity(), invoice.getBillingState(), invoice.getBillingCountry(), invoice.getBillingPostalCode(), invoice.getBillingPhone(), invoice.getFax(), invoice.getTotal()};
        return template.update(sql, values);
    }

    /**
     *
     * @param invoice
     * @return
     */
    public int update(Invoice invoice) {
        String sql = "UPDATE Invoice SET `invoiceId` = ?,`PurchaseOrder` = ?,`CustomerID` = ?,`InvoiceDate` = ?,`BillingAddress` = ?,`BillingCity` = ?,`BillingState` = ?,`BillingCountry` = ?,`BillingPostalCode` = ?,`BillingPhone` = ?,`Fax` = ?,`Total` = ?"
                + " WHERE InvoiceID = ?";
        Object[] values = {invoice.getInvoiceID(), invoice.getPurchaseOrder(), invoice.getCustomerId(), invoice.getInvoiceDate(), invoice.getBillingAddress(), invoice.getBillingCity(), invoice.getBillingState(), invoice.getBillingCountry(), invoice.getBillingPostalCode(), invoice.getBillingPhone(), invoice.getFax(), invoice.getTotal()};
        return template.update(sql, values);
    }

    /**
     *
     * @param InvoiceID
     * @return
     */
    public int delete(int InvoiceID) {
        String sql = "DELETE FROM Invoice WHERE InvoiceID = ?";
        Object[] values = {InvoiceID};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Invoice> getInvoiceList() {
        return template.query("SELECT * FROM Invoice", new RowMapper<Invoice>() {
            public Invoice mapRow(ResultSet rs, int row) throws SQLException {
                Invoice a = new Invoice();
                a.setInvoiceID(rs.getInt("InvoiceID"));
                a.setPurchaseOrder(rs.getString("PurchaseOrder"));
                a.setCustomerId(rs.getInt("CustomerID"));
                a.setInvoiceDate(rs.getString("Invoice Date"));
                a.setBillingAddress(rs.getString("Billing Address"));
                a.setBillingCity(rs.getString("Billing City"));
                a.setBillingState(rs.getString("Billing State"));
                a.setBillingCountry(rs.getString("Billing Country"));
                a.setBillingPostalCode(rs.getString("BillingPostalCode"));
                a.setBillingPhone(rs.getString("BillingPhone"));
                a.setFax(rs.getString("Fax"));
                a.setTotal(rs.getString("Total"));
                return a;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public Invoice getInvoiceById(int InvoiceID) {
        String sql = "SELECT * from invoice WHERE InvoiceID = ?";
        return template.queryForObject(sql, new Object[]{InvoiceID}, new BeanPropertyRowMapper<Invoice>(Invoice.class));
    }

    public List<Invoice> getInvoiceByPage(int start, int total) {
        String sql = "SELECT * FROM invoice LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Invoice>() {
            public Invoice mapRow(ResultSet rs, int row) throws SQLException {
                Invoice c = new Invoice();
                c.setInvoiceID(rs.getInt(1));
                c.setPurchaseOrder(rs.getString(2));
                c.setCustomerId(rs.getInt(3));
                c.setInvoiceDate(rs.getString(4));
                c.setBillingAddress(rs.getString(5));
                c.setBillingCity(rs.getString(6));
                c.setBillingState(rs.getString(7));
                c.setBillingCountry(rs.getString(8));
                c.setBillingPostalCode(rs.getString(9));
                c.setBillingPhone(rs.getString(10));
                c.setFax(rs.getString(11));
                c.setTotal(rs.getString(12));
                return c;
            }

        });

    }

    public int getInvoiceCount() {
        String sql = "SELECT COUNT(InvoiceID) AS rowcount FROM invoice";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    public Map<Integer, String> getCustomerMap() {
        Map<Integer, String> customer = new LinkedHashMap<Integer, String>();
        String sql = "SELECT CustomerID, Name FROM Customer ORDER BY Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            customer.put(rs.getInt(1), rs.getString(2));
        }
        return customer;
    }
}
