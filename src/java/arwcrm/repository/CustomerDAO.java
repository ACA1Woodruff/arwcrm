package arwcrm.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import arwcrm.objects.Customer;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class CustomerDAO {

    JdbcTemplate template;
//    private Object id;

    private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());
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
     * @param customer
     * @return
     */
    public int save(Customer customer) {
        String sql = "INSERT INTO customer (`customerName`,`Contactlastname`,`Contactfirstname`,`customerphone`,`customeremail`,`customeraddress1`,`customeraddress2`,`customeraddress3`,`customercity`,`customerstate`,`customerpostalCode`,`customercountry`, `customercreditLimit`)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?, ?)";
        Object[] values = {customer.getCustomerName(), customer.getCustomerContactLastName(), customer.getCustomerContactFirstName(), customer.getPhone(), customer.getEmail(), customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry(), customer.getCreditLimit()};
        return template.update(sql, values);
    }

    /**
     *
     * @param customer
     * @return
     */
    public int update(Customer customer) {
        String sql = "UPDATE Customer SET `customerName` = ?,`contactLastName` = ?,`contactFirstName` = ?, `customerPhone` = ?, `customerEmail` = ?, `customerAddress1` = ?, `customerAddress2` = ?, `customerAddress3` = ?, `customerCity` = ?, `customerState` = ?, `customerPostalCode` = ?, `customerCountry` = ?, `customerCreditLimit` = ?"
                + "         WHERE CustomerID = ?";
        Object[] values = {customer.getCustomerName(), customer.getCustomerContactLastName(), customer.getCustomerContactFirstName(), customer.getPhone(), customer.getEmail(), customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry(),customer.getCreditLimit(), customer.getCustomerID()};
        return template.update(sql, values);
    }

    /**
     *
     * @param CustomerID
     * @return
     */
    public int delete(int CustomerID) {
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";
        Object[] values = {CustomerID};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Customer> getCustomerList() {
        return template.query("SELECT * FROM Customer", new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer a = new Customer();
                a.setCustomerID(rs.getInt("CustomerID"));
                a.setCustomerName(rs.getString("customerName"));
                a.setCustomerContactLastName(rs.getString("CustomerContactLast_Name"));
                a.setCustomerContactFirstName(rs.getString("CustomerContactFirst_Name"));
                a.setPhone(rs.getString("Phone"));
                a.setEmail(rs.getString("Email"));
                a.setAddressLine1(rs.getString("AddressLine1"));
                a.setAddressLine1(rs.getString("AddressLine2"));
                a.setAddressLine1(rs.getString("AddressLine3"));
                a.setCity(rs.getString("City"));
                a.setState(rs.getString("State"));
                a.setPostalCode(rs.getString("PostalCode"));
                a.setCountry(rs.getString("Country"));
//                a.setSalesRepEmployeeNumber(rs.getString("SalesRepEmployeeNumber"));
                a.setCreditLimit(rs.getString("CreditLimit"));
                return a;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public Customer getCustomerById(int CustomerID) {
//        logger.info("Get Customer by ID: " + id);
//        String sql = "SELECT CustomerID AS ID, Customer Name FROM Customer WHERE CustomerID = ?";
        String sql = "SELECT * from customer WHERE CustomerID = ?";
        return template.queryForObject(sql, new Object[]{CustomerID}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> getCustomerByPage(int start, int total) {
        String sql = "SELECT * FROM customer LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer c = new Customer();
                c.setCustomerID(rs.getInt(1));
                c.setCustomerName(rs.getString(2));
                c.setCustomerContactLastName(rs.getString(3));
                c.setCustomerContactFirstName(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setAddressLine1(rs.getString(7));
                c.setAddressLine2(rs.getString(8));
                c.setAddressLine3(rs.getString(9));
                c.setCity(rs.getString(10));
                c.setState(rs.getString(11));
                c.setPostalCode(rs.getString(12));
                c.setCountry(rs.getString(13));
//              c.setSalesRepEmployeeNumber(rs.getString(13));
                c.setCreditLimit(rs.getString(14));
                return c;
            }

        });

    }

    public int getCustomerCount() {
        String sql = "SELECT COUNT(CustomerID) AS rowcount FROM customer";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    public Map<Integer, String> getCustomerMap() {
        Map<Integer, String> customer = new LinkedHashMap<Integer, String>();
        String sql = "SELECT CustomerID Customer Name FROM Customer ORDER BY Customer Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            customer.put(rs.getInt(1), rs.getString(2));
        }
        return customer;
    }
}
