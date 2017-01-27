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
import arwcrm.objects.JobCategory;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author awood
 */

public class JobCategoryDAO {
  JdbcTemplate template;
    private Object id;

    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    /**
     *
     * @param jobCategory
     * @return
     */
    public int save(JobCategory jobCategory){
        String sql = "INSERT INTO JobCategory (jobCategoryNames,textDescription) values(?,?,?)";
        Object[] values = {jobCategory.getJobCategoryNames(),jobCategory.getTextDescription()};
        return template.update(sql, values);
    }

    /**
     *
     * @param jobCategory
     * @return
     */
    public int update(JobCategory jobCategory){
        String sql = "UPDATE JobCategory SET JobCategoryNames = ?,JobDescription + ?, WHERE JobCategoryId = ?";
        Object[] values = {jobCategory.getJobCategoryNames(), jobCategory.getTextDescription()};
        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int JobCategory_id){
        String sql = "DELETE FROM JobCategory WHERE JobCategoryId = ?";
        Object[] values = {JobCategory_id};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<JobCategory> getJobCategoryNamesList(){
        return template.query("SELECT * FROM JobCategory",new RowMapper<JobCategory>(){
            public JobCategory mapRow(ResultSet rs,int row) throws SQLException{
                JobCategory a = new JobCategory();
                a.setId(rs.getInt("CustomerId"));
                a.setJobCategoryNames(rs.getString("JobCategoryNames"));
                a.setTextDescription(rs.getString("TextDescription"));
                return a;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public JobCategory getJobCategoryById(int JobCategory_id){
        String sql = "SELECT * FROM JobCategory WHERE JobCategory_Id = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<JobCategory>(JobCategory.class));
    }
    
    public List<JobCategory> getJobCategoriesByPage(int start, int total) {
        String sql = "SELECT * FROM jobCatergory LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<JobCategory>() {
            public JobCategory mapRow(ResultSet rs, int row) throws SQLException {
                JobCategory c = new JobCategory();
                c.setId(rs.getInt(1));
                c.setJobCategoryNames(rs.getString(2));
                c.setTextDescription(rs.getString(3));
                return c;

            }

        });

    }

    public int getJobDescriptionCount() {
        String sql = "SELECT COUNT(JobDecsription_id) AS rowcount FROM jobdescriptions";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
  

