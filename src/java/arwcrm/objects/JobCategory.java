package arwcrm.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author awood
 */
public class JobCategory implements Serializable {

    private int id;
    private String jobCategoryNames;
    private String textDescription;

    private Employee employee;

    /**
     *
     * @return
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     *
     * @return
     */
    public Map<Integer, String> getEmployees() {
        return employees;
    }

    /**
     *
     * @param employees
     */
    public void setEmployees(Map<Integer, String> employees) {
        this.employees = employees;
    }
    private Map<Integer, String> employees;

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
        buffer.append("Job Category: " + jobCategoryNames + ";");
        buffer.append("Text Description: " + textDescription);
        return buffer.toString();

    }

}
