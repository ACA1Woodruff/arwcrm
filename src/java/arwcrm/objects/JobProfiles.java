package arwcrm.objects;

import java.io.Serializable;

/**
 *
 * @author awood
 */
public class JobProfiles implements Serializable {

    private String jobCode;
    private String jobTitle;
    private String jobDescription;
    private String jobRates;

    /**
     *
     * @return
     */
    public String getJobCode() {
        return jobCode;
    }

    /**
     *
     * @param jobCode
     */
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    /**
     *
     * @return
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     *
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     *
     * @return
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     *
     * @param jobDescription
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     *
     * @return
     */
    public String getJobRates() {
        return jobRates;
    }

    /**
     *
     * @param jobRates
     */
    public void setJobRates(String jobRates) {
        this.jobRates = jobRates;
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
