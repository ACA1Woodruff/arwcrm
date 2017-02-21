package arwcrm.repository;

import arwcrm.objects.Employee;
import arwcrm.objects.JobCategory;
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
public class JobProfilesDAO {

    JdbcTemplate template;
    private Object id;
    
    private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());

    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     *
     * @param jobProfiles
     * @return
     */
    public int save(JobProfiles jobProfiles) {
        String sql = "INSERT INTO JobProfiles (jobCode,jobTitle, jobDescription, jobRates) values(?,?,?,?)";
        Object[] values = {jobProfiles.getJobCode(), jobProfiles.getJobTitle(), jobProfiles.getJobDescription(), jobProfiles.getJobRates()};
        return template.update(sql, values);
    }

    /**
     *
     * @param jobProfiles
     * @return
     */
    public int update(JobProfiles jobProfiles) {
        String sql = "UPDATE JobProfiles SET JobProfilesJobCode = ?,JobProfilesJobTitle = ?,JobProfilesJobTitle = ?,JobProfilesJobRate = ? WHERE JobProfilesJobCode = ?";
        Object[] values = {jobProfiles.getJobCode(), jobProfiles.getJobTitle(), jobProfiles.getJobDescription(), jobProfiles.getJobRates()};
        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int jobCode) {
        String sql = "DELETE FROM JobProfiles WHERE JobProfilesJobCode = ?";
        Object[] values = {jobCode};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<JobProfiles> getJobProfilesList() {
        return template.query("SELECT * FROM JobProfiles", new RowMapper<JobProfiles>() {
            public JobProfiles mapRow(ResultSet rs, int row) throws SQLException {
                JobProfiles a = new JobProfiles();
                a.setJobCode(rs.getString("JobProfilesJobCode"));
                a.setJobTitle(rs.getString("JobProfilesTitle"));
                a.setJobDescription(rs.getString("JobDescription"));
                a.setJobRates(rs.getString("JobRates"));
                return a;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public JobProfiles getJobProfilesById(int jobCode) {
        String sql = "SELECT * FROM JobProfiles WHERE JobCode = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<JobProfiles>(JobProfiles.class));
    }

    public List<JobProfiles> getJobProfilesByPage(int start, int total) {
//        String sql = "SELECT * FROM jobProfiles LIMIT " + (start - 1) + "," + total;
                String sql = "SELECT jobProfiles.jobCode, jobProfiles.jobTitle, jobProfile.jobDescription, jobDescription, jobProfiles.jobRates"
                + "FROM JobProfiles AS JobProfiles "
                + "INNER JOIN JobProfiles AS jobProfiles ON jobProfiles.jobCode = jobProfiles.JobCode "
                + "ORDER BY jobProfiles.jobCode, jobProfiles.JobTitle, "
                + "LIMIT " + (start - 1) + "," + total;
                
        return template.query(sql, new RowMapper<JobProfiles>() {
            public JobProfiles mapRow(ResultSet rs, int row) throws SQLException {
                JobProfiles c = new JobProfiles();
                c.setJobCode(rs.getString(1));
                c.setJobTitle(rs.getString(2));
                c.setJobDescription(rs.getString(3));
                c.setJobRates(rs.getString(4));
                
                JobCategory jobCategory = new JobCategory();
                jobCategory.setId(rs.getInt(5));
                jobCategory.setJobCategoryNames(rs.getString(6));
                jobCategory.setTextDescription(rs.getString(7));

                c.setJobCategory(jobCategory);
                return c;

            }

        });

    }

    public int getProfileCount() {
        String sql = "SELECT COUNT(JobProfiles_code) AS rowcount FROM jobProfiles";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
