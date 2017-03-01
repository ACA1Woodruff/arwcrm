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
    private Object id;

    private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Employee employee) {
        String sql = "INSERT INTO Employee (employeeLastName,employeeFirstName,addressLine1,addressLine2,homephone,extension,email,deptnumber,title) values(?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {employee.getEmployeeFirstName(), employee.getEmployeeLastName(), employee.getAddressLine1(), employee.getAddressLine2(), employee.getHomephone(), employee.getExtension(), employee.getEmail(), employee.getDeptNumber(), employee.getTitle()};

        return template.update(sql, values);
    }

    /**
     *
     * @param employee
     * @return
     */
    public int update(Employee employee) {
        String sql = "UPDATE Employee SET EmployeeLastName = ?,EmployeeFirstName = ?,addressLine1 = ?,addressLine2 = ?,homePhone = ?,extension = ?,mail = ?, deptNumber = ?,title = ? WHERE EmployeeId = ?";
        Object[] values = {employee.getEmployeeLastName(), employee.getEmployeeID(), employee.getEmployeeLastName(), employee.getEmployeeFirstName(), employee.getAddressLine1(), employee.getAddressLine2(), employee.getHomephone(), employee.getExtension(), employee.getEmail(), employee.getDeptNumber(), employee.getTitle()};
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
    public List<Employee> getEmployeesList() {
        return template.query("SELECT * FROM Employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee a = new Employee();
                a.setEmployeeID(rs.getString("EmployeeID"));
                a.setEmployeeLastName(rs.getString("EmployeeLastName"));
                a.setEmployeeFirstName(rs.getString("EmployeeFirstName"));
                a.setAddressLine1(rs.getString("AddressLine1"));
                a.setAddressLine2(rs.getString("AddressLine2"));
                a.setHomephone(rs.getString("homePhone"));
                a.setExtension(rs.getString("extension"));
                a.setEmail(rs.getString("email"));
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
        String sql = "SELECT employee.EmployeeID, employee.employeeFirstName, employee.employeeLastName, employee.addressLine1, employee.addressLine2, employee.homephone, employee.extension, employee.email, employee.deptNumber, employee.title WHERE EmployeeID = ?";
        return template.queryForObject(sql, new Object[]{EmployeeID}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Employee> getEmployeesByPage(int start, int total) {
        String sql = "SELECT employee.EmployeeID, employee.employeeFirstName, employee.employeeLastName, employee.addressLine1, employee.addressLine2, employee.homephone, employee.extension, employee.email, employee.deptNumber, employee.title "
                + "FROM Employee AS employee "
                + "INNER JOIN Employee AS employee ON employee.EmployeeID = employee.EmployeeID "
                + //                "ORDER BY employee.employeeLastName, employee.Title " + 
                "LIMIT " + (start - 1) + "," + total;

//        String sql = "SELECT * FROM employee LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee c = new Employee();
                c.setEmployeeID(rs.getString(1));
                c.setEmployeeLastName(rs.getString(2));
                c.setEmployeeFirstName(rs.getString(3));
                c.setAddressLine1(rs.getString(4));
                c.setAddressLine2(rs.getString(5));
                c.setHomephone(rs.getString(6));
                c.setExtension(rs.getString(7));
                c.setEmail(rs.getString(8));
                c.setDeptNumber(rs.getString(9));
                c.setTitle(rs.getString(10));

                Customer customer = new Customer();
                customer.setCustomerID(rs.getString(11));
                customer.setCustomerName(rs.getString(12));
                return c;
            }

        });

    }

    public int getEmployeesCount() {
        String sql = "SELECT COUNT(EmployeeID) AS rowcount FROM Employee";
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

    public Map<Integer, String> getEmployeesMap() {
        Map<Integer, String> employees = new LinkedHashMap<Integer, String>();
        String sql = "SELECT EmployeeID, Name FROM Employee ORDER BY employeeLastName, employeeFirstName";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            employees.put(rs.getInt(1), rs.getString(2));
        }
        return employees;
    }
}
