package arwcrm.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author awood
 */
public class JobProfiles implements Serializable {

    private String jobCode;
    private String jobTitle;
    private String jobDescription;
    private String jobRates;
    
    private JobCategory jobCategory;
    private Map<Integer, String> jobCategorys;

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRates() {
        return jobRates;
    }

    public void setJobRates(String jobRates) {
        this.jobRates = jobRates;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Map<Integer, String> getJobCategorys() {
        return jobCategorys;
    }

    public void setJobCategorys(Map<Integer, String> jobCategorys) {
        this.jobCategorys = jobCategorys;
    }

    

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("JobCode: " + this.jobCode + ";");
        buffer.append("JobTitle: " + jobTitle);
        buffer.append("JobDescription: " + jobDescription);
        buffer.append("JobRates: " + jobRates);
        return buffer.toString();

    }
}
