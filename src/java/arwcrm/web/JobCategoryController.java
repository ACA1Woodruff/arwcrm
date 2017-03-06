package arwcrm.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import arwcrm.objects.Customer;
import arwcrm.objects.Employee;
import arwcrm.objects.Invoice;
import arwcrm.objects.JobCategory;
import arwcrm.objects.JobProfiles;
import arwcrm.objects.Message;
import arwcrm.repository.CustomerDAO;
import arwcrm.repository.EmployeeDAO;
import arwcrm.repository.InvoiceDAO;
import arwcrm.repository.JobCategoryDAO;
import arwcrm.repository.JobProfilesDAO;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author awood
 */
public class JobCategoryController {

    @Autowired
    EmployeeDAO edao;

    @Autowired
    CustomerDAO cdao = new CustomerDAO();

    @Autowired
    InvoiceDAO idao = new InvoiceDAO();

    @Autowired
    JobCategoryDAO jcdao = new JobCategoryDAO();

    @Autowired
    JobProfilesDAO jpdao = new JobProfilesDAO();

    private static final Logger logger = Logger.getLogger(JobCategory.class.getName());

    @RequestMapping("/jobCategory/jobCategoryform")
    public ModelAndView showform() {
        JobCategory jobCategory = new JobCategory();
        jobCategory.setEmployees(edao.getEmployeeMap());

        return new ModelAndView("jobCategoryform", "command", jobCategory);
    }

    @RequestMapping("/jobCategory/jobCategoryform/{id}")
    public ModelAndView showformWithEmployee(@PathVariable int id) {
        Employee employee = edao.getEmployeeById(id);

        JobCategory jobCategory = new JobCategory();
        jobCategory.setId(id);
        jobCategory.setEmployee(employee);

        jobCategory.setEmployees(edao.getEmployeeMap());

//        jobCategoryController.setCustomerID(id);
//        jobCategoryController.setCustomer(customer);
        return new ModelAndView("jobCategoryform", "command", jobCategory);
    }

    @RequestMapping(value = "/jobCategory/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("jobCategory") JobCategory jobCategory, HttpServletRequest request) {
        int r = jcdao.save(jobCategory);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Job Category has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New Job Category creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/jobCategoryController/viewjobCategoryController");
    }

    @RequestMapping("/jobCategory/viewjobCategory")
    public ModelAndView viewjobCategory(HttpServletRequest request) {
        //List<Job Category> list = jcdao.getJobCategoryControllerList();
        //return new ModelAndView("viewinvoice","list",list);

        return this.viewjobCategory(1, request);
    }

    @RequestMapping("/jobCategory/viewjobCategory/{pageid}")
    public ModelAndView viewjobCategory(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<JobCategory> list = jcdao.getJobCategorysByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = jcdao.getJobCategoryCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewjobCategory", context);
    }

    @RequestMapping(value = "/jobCategory/editjobCategory/{id}")
    public ModelAndView edit(@PathVariable int id) {
        JobCategory jobCategory = jcdao.getJobCategoryById(id);
        jobCategory.setEmployees(edao.getEmployeeMap());

        return new ModelAndView("jobCategoryeditform", "command", jobCategory);
    }

    @RequestMapping(value = "/jobCategoryController/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("jobCategory") JobCategory jobCategory, HttpServletRequest request) {
        int r = jcdao.update(jobCategory);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "JobCategory has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit jobCategory failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/jobCategory/viewjobCategory");
    }

    @RequestMapping(value = "/jobCategory/deletejobCategory/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = jcdao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "JobCategory has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete jobCategory failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/jobCategory/viewjobCategory");
    }
}
