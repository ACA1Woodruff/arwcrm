package arwcrm.repository;

import arwcrm.objects.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import arwcrm.objects.JobCategory;
import arwcrm.objects.Employee;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class JobCategoryDAO {

    JdbcTemplate template;
    private Object id;

    private static final Logger logger = Logger.getLogger(JobCategoryDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(JobCategory jobCategory) {
        String sql = "INSERT INTO JobCategory (jobCategoryNames,textDescription) values(?,?,?)";
        Object[] values = {jobCategory.getJobCategoryNames(), jobCategory.getTextDescription()};
//        logger.info("JobCategory DAO save values: " + values);

        return template.update(sql, values);
    }

    public int update(JobCategory jobCategory) {
        String sql = "UPDATE JobCategory SET JobCategoryNames = ?,JobDescription = ?, WHERE JobCategoryId = ?";
        Object[] values = {jobCategory.getJobCategoryNames(), jobCategory.getTextDescription()};
        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM JobCategory WHERE JobCategoryID = ?";
        Object[] values = {id};
        return template.update(sql, values);
    }

    public List<JobCategory> getJobCategoryNamesList() {
        return template.query("SELECT * FROM JobCategory", new RowMapper<JobCategory>() {
            public JobCategory mapRow(ResultSet rs, int row) throws SQLException {
                JobCategory a = new JobCategory();
                a.setId(rs.getInt("JobCategoryID"));
                a.setJobCategoryNames(rs.getString("JobCategoryNames"));
                a.setTextDescription(rs.getString("TextDescription"));
                return a;
            }
        });
    }

    public JobCategory getJobCategoryById(int id) {
        String sql = "SELECT JobCategoryID AS id, JobCategoryNames, textDescription FROM Employee WHERE JobCategoryID = ?";
//        String sql = "SELECT * FROM JobCategory WHERE JobCategory_Id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<JobCategory>(JobCategory.class));
    }

    public List<JobCategory> getJobCategorysByPage(int start, int total) {
        String sql = "SELECT jobCategory.id, jobCategory.JobCategoryNames, jobCategory.textDescription"
                + "FROM JobCategory AS JobCategory "
                + "INNER JOIN JobCategory AS jobCategory ON jobCategory.id = jobCategory.JobCategoryID "
                + "ORDER BY jobCategory.id, jobCategory.JobCategoryNames "
                + "LIMIT " + (start - 1) + "," + total;
//        String sql = "SELECT * FROM jobCatergory LIMIT " + (start - 1) + "," + total;

        return template.query(sql, new RowMapper<JobCategory>() {
            public JobCategory mapRow(ResultSet rs, int row) throws SQLException {
                JobCategory a = new JobCategory();
                a.setId(rs.getInt(1));
                a.setJobCategoryNames(rs.getString(2));
                a.setTextDescription(rs.getString(3));

                Employee employee = new Employee();
                employee.setEmployeeID(rs.getString(4));
                employee.setEmployeeLastName(rs.getString(5));
                employee.setEmployeeFirstName(rs.getString(6));

                a.setEmployee(employee);
                return a;
            }

        });

    }

    public int getJobCategoryCount() {
        String sql = "SELECT COUNT(JobCategoryID) AS rowcount FROM jobCategory";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    public Map<Integer, String> getJobCategorysMap() {
        Map<Integer, String> jobCategorys = new LinkedHashMap<Integer, String>();
        String sql = "SELECT JobCategoryID, Name FROM JobCategory ORDER BY Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            jobCategorys.put(rs.getInt(1), rs.getString(2));
        }
        return jobCategorys;
    }
}
