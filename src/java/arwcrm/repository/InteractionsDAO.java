/**
 *
 * @author awood
 */
package arwcrm.repository;

import arwcrm.objects.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.RowMapper;
import arwcrm.objects.Interactions;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author awood
 */
public class InteractionsDAO {

    JdbcTemplate template;
//    private String interactions_id;
private static final Logger logger = Logger.getLogger(InteractionsDAO.class.getName());
    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    
//    private int id;

    /**
     *
     * @param interactions
     * @return
     */
    public int save(Interactions interactions) {
        String sql = "INSERT INTO INTERACTIONS (interactions_id,first_name, last_name, "
                + "status, method_of_contact, email, phone, notes, contact_date, Customer_ID) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {interactions.getInteractions_id(), interactions.getFirst_name(), 
            interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), 
            interactions.getEmail(), interactions.getPhone(), interactions.getNotes(), 
            interactions.getContact_date(), interactions.getCustomer_ID()};
        
        logger.info("interactionsDAO save value: " + values);
        
        return template.update(sql, values);

    }

    /**
     *
     * @param interactions
     * @return
     */
    public int update(Interactions interactions) {
        String sql = "UPDATE interactions SET first_name = ?, last_name = ?, status = ?,"
                + " method_of_contact = ?, email = ?, phone = ?, notes = ?, contact_date = ?, "
                + "Customer_ID = ? WHERE interactions_id = ?";
        Object[] values = {interactions.getInteractions_id(), interactions.getFirst_name(), 
            interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), 
            interactions.getEmail(), interactions.getPhone(), interactions.getNotes(), 
            interactions.getContact_date(), interactions.getCustomer_ID()};
        return template.update(sql, values);
    }

    /**
     *
     * @param interactions_id
     * @return
     */
    public int delete(int interactions_id) {
        String sql = "DELETE FROM interactions WHERE interactions_id=?";
        Object[] values = {interactions_id};
        return template.update(sql, values);
    }

    /**
     *
     * @param interactions_id
     * @return
     */
    public List<Interactions> getInteractionsList() {
        return template.query("SELECT * FROM Interactions " , new RowMapper<Interactions>() {
            
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractions_id(rs.getInt("Interactions ID"));
                i.setFirst_name(rs.getString("First Name"));
                i.setLast_name(rs.getString("Last Name"));
                i.setStatus(rs.getString("Status"));
                i.setMethod_of_contact(rs.getString("Method of Contact"));
                i.setEmail(rs.getString("Email"));
                i.setPhone(rs.getString("Phone"));
                i.setNotes(rs.getString("Notes"));
                i.setContact_date(rs.getDate("Contact Date"));
                i.setCustomer_ID(rs.getInt("Customer ID"));

                return i;

            }
        });
    }

    /**
     *
     * @param interactions_id
     * @return
     */
    public Interactions getInteractionsById(int interactions_id) {
        String sql = "SELECT * from interactions WHERE interactions_id = ?";
        return template.queryForObject(sql, new Object[]{interactions_id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    /**
     *
     * @param start
     * @param total
     * @return
     */
    public List<Interactions> getInteractionsByPage(int start, int total) {
        String sql = "SELECT interactions.interactions_id, interactions.first_name, "
                + "interactions.last_name, interactions.status, interactions.method_of_contact, "
                + "interactions.email, interactions.phone, interactions.notes, interactions.contact_date, "
                + "interactions.Customer_ID, customer.CustomerID  "
                + "FROM Interactions AS interactions "
                + "INNER JOIN Customer AS customer ON customer.CustomerID = interactions.Customer_ID "
                + "ORDER BY customer.CustomerID, interactions.contact_date "
                + "LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractions_id(rs.getInt(1));
                i.setFirst_name(rs.getString(2));
                i.setLast_name(rs.getString(3));
                i.setStatus(rs.getString(4));
                i.setMethod_of_contact(rs.getString(5));
                i.setEmail(rs.getString(6));
                i.setPhone(rs.getString(7));
                i.setNotes(rs.getString(8));
                i.setContact_date(rs.getDate(9));
                i.setCustomer_ID(rs.getInt(10));

                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));

                return i;

            }

        });
    }

    /**
     *
     * @return
     */
    public int getInteractionsCount() {
        String sql = "SELECT COUNT(interactions_id) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        return 1;
    }

    /**
     *
     * @return
     */
    public Map<Integer, String> getCustomersMap() {
        Map<Integer, String> Customer = new LinkedHashMap<Integer, String>();
        String sql = "SELECT CustomerID, customerName FROM Customer ORDER BY customerName";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            Customer.put(rs.getInt(1), rs.getString(2));
        }

        return Customer;
    }

    /**
     * List<Interactions> getLastInteractions and SQL Query
     *
     * @return
     */
    public List<Interactions> getLastInteractions() {
        String sql = "SELECT * From interactions Order by interactions_id Desc Limit 5";
        return template.query(sql, (ResultSet rs, int row) -> {
            Interactions i = new Interactions();
            i.setInteractions_id(rs.getInt(1));
            i.setCustomer_ID(rs.getInt(2));
            i.setContact_date(rs.getDate(3));
            i.setFirst_name(rs.getString(4));
            i.setLast_name(rs.getString(4));
            i.setMethod_of_contact(rs.getString(5));
            i.setNotes(rs.getString(6));
            return i;
        });
    }
}
