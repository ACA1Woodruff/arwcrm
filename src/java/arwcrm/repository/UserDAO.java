package arwcrm.repository;

import arwcrm.objects.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import arwcrm.objects.JobProfiles;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class UserDAO {

    JdbcTemplate template;

    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(User user) {
        String sql = "INSERT INTO users (username, password, name) values(?, md5(?), ?)";

        Object[] values = {user.getUsername(), user.getPassword(), user.getName()};

        logger.info("User DAO save values: " + values);

        int r = template.update(sql, values);

        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";

        for (String role : user.getRoles()) {
            Object[] role_values = {user.getUsername(), role};

            logger.info("User DAO add role: " + values);

            template.update(sql, role_values);
        }

        // for this example we are going to return the insert of the user. 
        // we could do some more work here to make sure the roles went in, 
        // but the user is what is important.
        return r;
    }
    private Object Username;

    /**
     *
     * @param template
     */
//    public void setTemplate(JdbcTemplate template) {
//        this.template = template;
//    }

    /**
     *
     * @param users
     * @return
     */
//    public int save(User user) {
//        String sql = "INSERT INTO Users (Username, Password, Roles) values(?,?,?)";
//        Object[] values = {user.getUsername(), user.getPassword(), user.getRoles()};
//        return template.update(sql, values);
//    }

    public int update(User user) {
        String sql = "UPDATE Users SET Users Username = ?,UsersPassword = ?,UsersRoles = ? WHERE UsersUsername = ?";
        Object[] values = {user.getUsername(), user.getPassword(), user.getRoles()};
        return template.update(sql, values);
    }

    public int delete(String Username) {
        String sql = "DELETE FROM User WHERE User Username = ?";
        Object[] values = {Username};
        return template.update(sql, values);
    }

    public List<User> getUsersList() {
        return template.query("SELECT * FROM Users", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User a = new User();
                a.setUsername(rs.getString(1));
                a.setPassword(rs.getString(2));
                a.setName(rs.getString(3));
                return a;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public User getUsersById(String Username) {
        String sql = "SELECT * FROM User WHERE Username = ?";
        return template.queryForObject(sql, new Object[]{Username}, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> getUsersByPage(int start, int total) {
        String sql = "SELECT * FROM Users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User c = new User();
                c.setUsername(rs.getString(1));
                c.setPassword(rs.getString(2));
                c.setName(rs.getString(3));
                return c;

            }

        });

    }

    public int getUsersCount() {
        String sql = "SELECT COUNT(User username) AS rowcount FROM Users";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
