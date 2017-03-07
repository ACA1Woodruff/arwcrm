package arwcrm.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import arwcrm.objects.Employee;
import arwcrm.objects.Customer;
import arwcrm.objects.JobCategory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class EmployeeDAO {

    JdbcTemplate template;
//    private Object id;

    private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
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
     * @param employee
     * @return
     */
    public int save(Employee employee) {
        String sql = "INSERT INTO Employee (`employeeLastName`,`employeeFirstName`,`address`,`homePhone`,`extension`,`email`,`departmentNumber`,`title`,`startDate`)"
                + "values(?,?,?,?,?,?,?,?,?)";
        Object[] values = {employee.getEmployeeLastName(), employee.getEmployeeFirstName(), employee.getAddress(), employee.getHomePhone(), employee.getExtension(), employee.getEmail(), employee.getDeptNumber(), employee.getTitle(), employee.getStartDate()};

        return template.update(sql, values);
    }

    /**
     *
     * @param employee
     * @return
     */
    public int update(Employee employee) {
        String sql = "UPDATE Employee SET `employeeLastName` = ?,`employeeFirstName` = ?,`address` = ?,`homePhone` = ?,`extension` = ?,"
                + "`email` = ?,`departmentNumber` = ?,`title` = ?, `startDate` = ?"
                + "WHERE EmployeeID = ?";
        Object[] values = {employee.getEmployeeLastName(), employee.getEmployeeFirstName(), employee.getAddress(), employee.getHomePhone(),
            employee.getExtension(), employee.getEmail(), employee.getDeptNumber(), employee.getTitle(), employee.getStartDate(), employee.getEmployeeID()};
        return template.update(sql, values);
    }

    /**
     *
     * @param EmployeeID
     * @return
     */
    public int delete(int EmployeeID) {
        String sql = "DELETE FROM Employee WHERE EmployeeID = ?";
        Object[] values = {EmployeeID};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Employee> getEmployeeList() {
        return template.query("SELECT * FROM Employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee a = new Employee();
                a.setEmployeeID(rs.getInt("EmployeeID"));
                a.setEmployeeLastName(rs.getString("EmployeeLastName"));
                a.setEmployeeFirstName(rs.getString("EmployeeFirstName"));
                a.setAddress(rs.getString("Address"));
                a.setHomePhone(rs.getString("homePhone"));
                a.setExtension(rs.getString("extension"));
                a.setEmail(rs.getString("email"));
                a.setTitle(rs.getString("title"));
                a.setStartDate(rs.getString("startDate"));
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
//        String sql = "SELECT employee.EmployeeID, employee.employeeLastName, employee.employeeFirstName, "
//                + "employee.address, employee.homePhone, employee.extension, employee.email, employee.departmentNumber, "
//                + "employee.title, employee.startDate WHERE EmployeeID = ?";
        String sql = "SELECT * from employee WHERE EmployeeID = ?";
        return template.queryForObject(sql, new Object[]{EmployeeID}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Employee> getEmployeeByPage(int start, int total) {
//        String sql = "SELECT employee.ID, employee.employeeLastName, employee.employeeFirstName,"
//                + " employee.address, employee.homePhone, employee.extension,"
//                + " employee.email, employee.deptNumber, employee.title, employee.startDate"
//                + "FROM Employee AS employee "
//                + "INNER JOIN Employee AS employee ON employee.ID = employee.EmployeeID "
//                + //"ORDER BY employee.employeeLastName, employee.Title " + 
//                "LIMIT " + (start - 1) + "," + total;

        String sql = "SELECT * FROM employee LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee c = new Employee();
                c.setEmployeeID(rs.getInt(1));
                c.setEmployeeLastName(rs.getString(2));
                c.setEmployeeFirstName(rs.getString(3));
                c.setAddress(rs.getString(4));
                c.setHomePhone(rs.getString(5));
                c.setExtension(rs.getString(6));
                c.setEmail(rs.getString(7));
                c.setDeptNumber(rs.getString(8));
                c.setTitle(rs.getString(9));
                c.setStartDate(rs.getString(10));

                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));
                return c;
            }

        });

    }

    public int getEmployeeCount() {
        String sql = "SELECT COUNT(EmployeeID) AS rowcount FROM Employee";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    public Map<Integer, String> getEmployeeMap() {
        Map<Integer, String> employee = new LinkedHashMap<Integer, String>();
        String sql = "SELECT EmployeeID, Name FROM Employee ORDER BY Employee Last Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            employee.put(rs.getInt(1), rs.getString(2));
        }
        return employee;
    }

    public Map<Integer, String> getCustomerMap() {
        Map<Integer, String> customer = new LinkedHashMap<Integer, String>();
        String sql = "SELECT CustomerID, Name FROM Customer ORDER BY Customer Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            customer.put(rs.getInt(1), rs.getString(2));
        }
        return customer;
    }

//    public Map<Integer, String> getEmployeeMap() {
//        Map<Integer, String> employee = new LinkedHashMap<Integer, String>();
//        String sql = "SELECT EmployeeID, Name FROM Employee ORDER BY Employee Last Name, Employee First Name";
//
//        SqlRowSet rs = template.queryForRowSet(sql);
//
//        while (rs.next()) {
//            employee.put(rs.getInt(1), rs.getString(2));
//        }
//        return employee;
}
