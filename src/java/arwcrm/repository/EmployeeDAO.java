package arwcrm.repository;

import arwcrm.objects.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import arwcrm.objects.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class EmployeeDAO {

    JdbcTemplate template;
    
    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     *
     * @param employee
     * @return
     */
    public int save(Employee employee) {
        String sql = "INSERT INTO Employee (employeeLastName,employeeFirstName,address1,address2,homephone,extension,email,deptnumber,title) values(?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {employee.getEmployeeFirstName(), employee.getEmployeeLastName(), employee.getAddress1(), employee.getAddress2(), employee.getHomephone(), employee.getExtension(), employee.getEmail(), employee.getDeptNumber(), employee.getTitle()};
        return template.update(sql, values);
    }

    /**
     *
     * @param employee
     * @return
     */
    public int update(Employee employee) {
        String sql = "UPDATE Employee SET EmployeeLastName = ?,EmployeeFirstName = ?,address1 = ?,address2 = ?,homePhone = ?,extension = ?,mail = ?, deptNumber = ?,title = ? WHERE EmployeeId = ?";
        Object[] values = {employee.getEmployeeLastName(), employee.getEmployeeID()};
        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int employee_id) {
        String sql = "DELETE FROM Employee WHERE EmployeeID = ?";
        Object[] values = {employee_id};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Employee> getEmployeesList() {
        return template.query("SELECT * FROM Employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee a = new Employee();
                a.setEmployeeID(rs.getInt("EmployeeID"));
                a.setEmployeeLastName(rs.getString("EmployeeLastName"));
                a.setEmployeeFirstName(rs.getString("EmployeeFirstName"));
                a.setAddress1(rs.getString("Address1"));
                a.setAddress2(rs.getString("Address2"));
                a.setHomephone(rs.getString("homePhone"));
                a.setExtension(rs.getString("extension"));
                a.setTitle(rs.getString("title"));
                return a;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public Employee getEmployeeById(int EmployeeID) {
        String sql = "SELECT * from employee WHERE EmployeeID = ?";
        return template.queryForObject(sql, new Object[]{EmployeeID}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Employee> getEmployeesByPage(int start, int total) {
        String sql = "SELECT * FROM employee LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee c = new Employee();
                c.setEmployeeID(rs.getInt(1));
                c.setEmployeeLastName(rs.getString(2));
                c.setEmployeeFirstName(rs.getString(3));
                c.setAddress1(rs.getString(4));
                c.setAddress2(rs.getString(5));
                c.setHomephone(rs.getString(6));
                c.setExtension(rs.getString(7));
                c.setEmail(rs.getString(8));
                c.setDeptNumber(rs.getString(9));
                c.setTitle(rs.getString(10));
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
