package arwcrm.repository;

import arwcrm.objects.Invoice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class InvoiceDAO {

    JdbcTemplate template;
    private Object id;

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
        String sql = "INSERT INTO INVOICES (customerId,invoiceDate,billingAddress,billingCity,billingState,billingCountry,billingPostalCode,billingPhone,fax,total) values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {invoice.getCustomerId(), invoice.getInvoiceDate(), invoice.getBillingAddress(), invoice.getBillingCity(), invoice.getBillingState(), invoice.getBillingCountry(), invoice.getBillingPostalCode(), invoice.getBillingPhone(), invoice.getFax(), invoice.getTotal()};
        return template.update(sql, values);
    }

    /**
     *
     * @param invoice
     * @return
     */
    public int update(Invoice invoice) {
        String sql = "UPDATE Invoice SET InvoiceID = ?,invoiceDate = ?,billingAddress = ?, billingCity = ?, billingState = ?, billingCountry = ?, billingPostalCode = ?, billingPhone = ?, fax = ?, total = ?, WHERE InvoiceID = ?";
        Object[] values = {invoice.getCustomerId(), invoice.getInvoiceDate(), invoice.getBillingAddress(), invoice.getBillingCity(), invoice.getBillingState(), invoice.getBillingCountry(), invoice.getBillingPostalCode(), invoice.getBillingPhone(), invoice.getFax(), invoice.getFax(), invoice.getTotal()};
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
    public List<Invoice> getInvoicesList() {
        return template.query("SELECT * FROM Invoice", new RowMapper<Invoice>() {
            public Invoice mapRow(ResultSet rs, int row) throws SQLException {
                Invoice a = new Invoice();
                a.setInvoiceID(rs.getString("InvoiceID"));
                a.setCustomerId(rs.getInt("CustomerId"));
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
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Invoice>(Invoice.class));
    }

    public List<Invoice> getInvoicesByPage(int start, int total) {
        String sql = "SELECT * FROM invoice LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Invoice>() {
            public Invoice mapRow(ResultSet rs, int row) throws SQLException {
                Invoice c = new Invoice();
                c.setInvoiceID(rs.getString(1));
                c.setCustomerId(rs.getInt(2));
                c.setBillingAddress(rs.getString(3));
                c.setBillingCity(rs.getString(4));
                c.setBillingState(rs.getString(5));
                c.setBillingCountry(rs.getString(6));
                c.setBillingPostalCode(rs.getString(7));
                c.setBillingPhone(rs.getString(8));
                c.setFax(rs.getString(9));
                c.setTotal(rs.getString(10));
                return c;
            }

        });

    }

    public int getInvoiceCount() {
        String sql = "SELECT COUNT(InvoiceID) AS rowcount FROM invoices";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    public Map<Integer, String> getCustomersMap() {
        Map<Integer, String> customers = new LinkedHashMap<Integer, String>();
        String sql = "SELECT CustomerID, Name FROM Customer ORDER BY Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            customers.put(rs.getInt(1), rs.getString(2));
        }
        return customers;
    }
}
