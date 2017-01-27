package arwcrm.objects;

import java.io.Serializable;

/**
 *
 * @author awood
 */
public class JobCategory implements Serializable {

    private int id;
    private String jobCategoryNames;
    private String textDescription;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getJobCategoryNames() {
        return jobCategoryNames;
    }

    /**
     *
     * @param jobCategoryNames
     */
    public void setJobCategoryNames(String jobCategoryNames) {
        this.jobCategoryNames = jobCategoryNames;
    }

    /**
     *
     * @return
     */
    public String getTextDescription() {
        return textDescription;
    }

    /**
     *
     * @param textDescription
     */
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("ID: " + this.id + ";");
        buffer.append("JobCategories: " + jobCategoryNames + ";");
        buffer.append("TextDescription: " + textDescription);
        return buffer.toString();

    }

    public Object getJobCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
