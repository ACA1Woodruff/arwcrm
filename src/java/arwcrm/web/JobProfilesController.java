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
@Controller
public class JobProfilesController {

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

    private static final Logger logger = Logger.getLogger(JobProfiles.class.getName());
    private String jobCode;

    @RequestMapping("/jobProfiles/jobProfilesform")
    public ModelAndView showform() {
        JobProfiles jobProfiles = new JobProfiles();
        jobProfiles.setJobCategorys(jcdao.getJobCategorysMap());

        return new ModelAndView("jobProfilesform", "command", jobProfiles);
    }

    @RequestMapping("/jobProfiles/jobProfilesform/{id}")
    public ModelAndView showformWithJobCategory(@PathVariable int id) {
        JobCategory jobCategory = jcdao.getJobCategoryById(id);

        JobProfiles jobProfiles = new JobProfiles();
        jobProfiles.setJobCode(jobCode);
        jobProfiles.setJobCategory(jobCategory);
        jobProfiles.setJobCategorys(jcdao.getJobCategorysMap());

        return new ModelAndView("jobProfilesform", "command", jobProfiles);
    }

    @RequestMapping(value = "/jobProfiles/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("jobProfiles") JobProfiles jobProfiles, HttpServletRequest request) {
        int r = jpdao.save(jobProfiles);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "JobProfiles has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New jobProfiles creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/jobProfiles/viewjobProfiles");
    }

    @RequestMapping("/jobProfiles/viewjobProfiles")
    public ModelAndView viewjobProfiles(HttpServletRequest request) {
        //List<JobProfiles> list = jpdao.getJobProfilesList();
        //return new ModelAndView("viewjobProfiles","list",list);

        return this.viewjobProfiles(1, request);
    }

    @RequestMapping("/jobProfiles/viewjobProfiles/{pageid}")
    public ModelAndView viewjobProfiles(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<JobProfiles> list = jpdao.getJobProfilesByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = jpdao.getProfileCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewjobProfiles", context);
    }

    @RequestMapping(value = "/jobProfiles/editjobProfiles/{id}")
    public ModelAndView edit(@PathVariable int id) {
        JobProfiles jobProfiles = jpdao.getJobProfilesById(id);

        jobProfiles.setJobCategorys(jcdao.getJobCategorysMap());

        return new ModelAndView("jobProfileseditform", "command", jobProfiles);
    }

    @RequestMapping(value = "/jobProfiles/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("jobProfiles") JobProfiles jobProfiles, HttpServletRequest request) {
        int r = jpdao.update(jobProfiles);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "JobProfiles has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit jobProfiles failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/jobProfile/viewjobProfiles");
    }

    @RequestMapping(value = "/jobProfiles/deletejobProfiles/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = jpdao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "JobProfiles has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete jobProfiles failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/jobProfiles/viewjobProfiles");
    }
}
