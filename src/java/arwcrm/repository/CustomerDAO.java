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
        String sql = "INSERT INTO CUSTOMER (customerName,customercontactlastname,customercontactfirstname,phone,email,addressline1,addressline2,addressline3,city,state,postalcode,country) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {customer.getName(), customer.getCustomerContactLastName(), customer.getCustomerContactFirstName(), customer.getPhone(), customer.getEmail(), customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry()};
        return template.update(sql, values);
    }

    /**
     *
     * @param customer
     * @return
     */
    public int update(Customer customer) {
        String sql = "UPDATE Customer SET customerName = ? Where CustomerID = ?,customercontactLast_Name = ?,customercontactFirst_Name = ?, Phone = ?, Email = ?, addressLine1 = ?, addressLine2 = ?, addressLine3 = ?, city = ?, state = ?, postalcode = ?, country = ? WHERE CustomerID = ?";
        Object[] values = {customer.getName(), customer.getCustomerContactLastName(), customer.getCustomerContactFirstName(), customer.getPhone(), customer.getEmail(), customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry()};
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
                a.setCustomerID(rs.getString("CustomerID"));
                a.setName(rs.getString("CustomerContactLast_Name"));
                a.setName(rs.getString("CustomerContactFirst_Name"));
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
        logger.info("Get Customer by ID: " + id);
        String sql = "SELECT CustomerID AS ID, Name FROM Customer WHERE CustomerID = ?";
//        String sql = "SELECT * from customer WHERE CustomerID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> getCustomerByPage(int start, int total) {
        String sql = "SELECT * FROM customer LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer c = new Customer();
                c.setCustomerID(rs.getString(1));
                c.setCustomerContactLastName(rs.getString(2));
                c.setCustomerContactFirstName(rs.getString(3));
                c.setPhone(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setAddressLine1(rs.getString(6));
                c.setAddressLine2(rs.getString(7));
                c.setAddressLine3(rs.getString(8));
                c.setCity(rs.getString(9));
                c.setState(rs.getString(10));
                c.setPostalCode(rs.getString(11));
                c.setCountry(rs.getString(12));
//              c.setSalesRepEmployeeNumber(rs.getString(13));
                c.setCreditLimit(rs.getString(13));
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
        String sql = "SELECT CustomerID, Name FROM Customer ORDER BY Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            customer.put(rs.getInt(1), rs.getString(2));
        }
        return customer;
    }
}
