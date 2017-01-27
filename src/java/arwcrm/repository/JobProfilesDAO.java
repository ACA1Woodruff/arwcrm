package arwcrm.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import arwcrm.objects.JobProfiles;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */
public class JobProfilesDAO {

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
     * @param jobProfiles
     * @return
     */
    public int save(JobProfiles jobProfiles) {
        String sql = "INSERT INTO JobProfiles (jobCode,jobTitle, jobDescription) values(?,?,?,?)";
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
    public int delete(int JobProfiles_id) {
        String sql = "DELETE FROM JobProfiles WHERE JobProfilesJobCode = ?";
        Object[] values = {JobProfiles_id};
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
    public JobProfiles getJobProfilesById(int JobProfiles_id) {
        String sql = "SELECT * FROM JobProfiles WHERE JobProfiles_Id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<JobProfiles>(JobProfiles.class));
    }

    public List<JobProfiles> getJobProfilesByPage(int start, int total) {
        String sql = "SELECT * FROM jobProfiles LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<JobProfiles>() {
            public JobProfiles mapRow(ResultSet rs, int row) throws SQLException {
                JobProfiles c = new JobProfiles();
                c.setJobCode(rs.getString(1));
                c.setJobTitle(rs.getString(2));
                c.setJobDescription(rs.getString(3));
                c.setJobRates(rs.getString(4));
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
