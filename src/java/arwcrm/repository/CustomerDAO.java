package arwcrm.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import arwcrm.objects.Customer;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class CustomerDAO {

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
     * @param customer
     * @return
     */
    public int save(Customer customer) {
        String sql = "INSERT INTO CUSTOMERS (name,contactlastname,contactfirstname,phone,fax,addressline1,addressline2,addressline3,city,state,postalcode,country) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {customer.getName(), customer.getContactLastName(), customer.getContactFirstName(), customer.getPhone(), customer.getFax(), customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry()};
        return template.update(sql, values);
    }

    /**
     *
     * @param customer
     * @return
     */
    public int update(Customer customer) {
        String sql = "UPDATE Customer SET name = ?,contactFirst_name = ?,contactLast_Name = ?, Phone = ?, Fax = ?, addressLine1 = ?, addressLine2 = ?, addressLine3 = ?, city = ?, state = ?, postalcode = ?, country = ? WHERE CustomerId = ?";
        Object[] values = {customer.getName(), customer.getContactFirstName(), customer.getContactLastName(), customer.getPhone(), customer.getFax(), customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry()};
        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int customer_id) {
        String sql = "DELETE FROM Customer WHERE CustomerId = ?";
        Object[] values = {customer_id};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Customer> getCustomersList() {
        return template.query("SELECT * FROM Customer", new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer a = new Customer();
                a.setId(rs.getInt("Customer_Id"));
                a.setName(rs.getString("ContactFirst_Name"));
                a.setName(rs.getString("ContactLast_Name"));
                a.setPhone(rs.getString("Phone"));
                a.setFax(rs.getString("Fax"));
                a.setAddressLine1(rs.getString("AddressLine1"));
                a.setAddressLine1(rs.getString("AddressLine2"));
                a.setAddressLine1(rs.getString("AddressLine3"));
                a.setCity(rs.getString("City"));
                a.setState(rs.getString("State"));
                a.setPostalCode(rs.getString("PostalCode"));
                a.setCountry(rs.getString("Country"));
                a.setSalesRepEmployeeNumber(rs.getString("SalesRepEmployeeNumber"));
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
    public Customer getCustomerById(int Customer_id) {
        String sql = "SELECT * from customer WHERE Customer_Id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> getCustomersByPage(int start, int total) {
        String sql = "SELECT * FROM client LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setContactLastName(rs.getString(2));
                c.setContactFirstName(rs.getString(3));
                c.setPhone(rs.getString(4));
                c.setFax(rs.getString(5));
                c.setAddressLine1(rs.getString(6));
                c.setAddressLine2(rs.getString(7));
                c.setAddressLine3(rs.getString(8));
                c.setCity(rs.getString(9));
                c.setState(rs.getString(10));
                c.setPostalCode(rs.getString(11));
                c.setCountry(rs.getString(12));
                c.setSalesRepEmployeeNumber(rs.getString(13));
                c.setCreditLimit(rs.getString(14));
                return c;
            }

        });

    }

    public int getCustomerCount() {
        String sql = "SELECT COUNT(customer_id) AS rowcount FROM customers";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
