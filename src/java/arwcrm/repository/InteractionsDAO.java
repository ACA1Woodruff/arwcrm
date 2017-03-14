/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.logging.Logger;

/**
 *
 * @author awood
 */
public class InteractionsDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    private static final Logger logger = Logger.getLogger(InteractionsDAO.class.getName());
    private int id;

    public int save(Interactions interactions) {
        String sql = "INSERT INTO INTERACTIONS (`first_name`, `last_name`, `status`, `method_of_contact`, `email`, `phone`, `notes`, `contact_date`, `CustomerID`) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {interactions.getFirst_name(), interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), interactions.getEmail(), interactions.getPhone(), interactions.getNotes(), interactions.getContact_date(), interactions.getCustomerID()};
        return template.update(sql, values);

    }

    public int update(Interactions interactions) {
        String sql = "UPDATE interactions SET `first_name` = ?, `last_name` = ?, `status` = ?, `method_of_contact` = ?, `email` = ?, `phone` = ?, `notes` = ?, `contact_date` = ?, `customer_id` = ? WHERE interaction_id = ?";
        Object[] values = {interactions.getFirst_name(), interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), interactions.getEmail(), interactions.getPhone(), interactions.getNotes(), interactions.getContact_date(), interactions.getCustomerID()};
        return template.update(sql, values);

    }

    public int delete(int interaction_id) {
        String sql = "DELETE FROM interactions WHERE interaction_id = ?";
        Object[] values = {interaction_id};
        return template.update(sql);

    }

    public List<Interactions> getInteractionsList() {
        return template.query("SELECT * FROM Interactions", new RowMapper<Interactions>() {
            @Override
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteraction_id(rs.getInt("interaction_id"));
                i.setFirst_name(rs.getString("first_name"));
                i.setLast_name(rs.getString("last_name"));
                i.setNotes(rs.getString("notes"));

                return i;

            }
        });
    }

    public Interactions getInteractionsById(int interaction_id) {
        String sql = "SELECT * from interactions WHERE interactionsid = ?";
        return template.queryForObject(sql, new Object[]{interaction_id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    public List<Interactions> getInteractionsByPage(int start, int total) {
        String sql = "SELECT interactions.interactionsid, interactions.CustomerID, interactions.contact_date, interactions.first_name, interactions.last_name, interactions.notes, customer.CustomerID  "
                + "FROM Interactions AS interactions "
                + "INNER JOIN customer AS customer ON customer.customerID = interactions.CustomerID "
                + "ORDER BY customer.customerName, interactions.contact_date "
                + "LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteraction_id(rs.getInt(1));
                i.setFirst_name(rs.getString(2));
                i.setLast_name(rs.getString(3));
                i.setStatus(rs.getString(4));
                i.setMethod_of_contact(rs.getString(5));
                i.setEmail(rs.getString(6));
                i.setPhone(rs.getString(7));
                i.setNotes(rs.getString(8));
                
                i.setContact_date(rs.getString(10));
                i.setCustomerID(rs.getInt(11));

                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));

                return i;

            }

        });
    }

    public int getInteractionsCount() {
        String sql = "SELECT COUNT(interactionsid) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        return 1;
    }
}
