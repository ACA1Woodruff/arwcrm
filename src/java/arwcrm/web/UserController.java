package arwcrm.web;

import arwcrm.objects.Message;
import arwcrm.objects.User;
import arwcrm.repository.UserDAO;
import arwcrm.validation.UserValidator;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import arwcrm.objects.Customer;
//import arwcrm.objects.Employee;
//import arwcrm.objects.Message;
//import arwcrm.repository.CustomerDAO;
//import arwcrm.repository.EmployeeDAO;
//import arwcrm.repository.InvoiceDAO;
//import arwcrm.repository.JobCategoryDAO;
//import arwcrm.repository.JobProfilesDAO;
//import java.util.HashMap;
//import java.util.logging.Logger;
//import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author awood
 */
@Controller
public class UserController {

    @Autowired
    UserDAO dao;

    @Autowired
    private UserValidator userValidator;

    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @RequestMapping("/user/userform")
    public ModelAndView showform() {
        User user = new User();

        return new ModelAndView("userform", "user", user);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("userform", "user", user);
        }

        int r = dao.save(user);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }

        request.getSession().setAttribute("message", msg);

        // this needs to go to the user list view, but i am not providing one.
        return new ModelAndView("redirect:/");
    }

    @InitBinder("user")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(userValidator);
    }

    public UserValidator getUserValidator() {
        return userValidator;
    }

    public void setArtistValidator(UserValidator artistValidator) {
        this.userValidator = artistValidator;
    }
//    @Autowired
//    CustomerDAO cdao = new CustomerDAO();
//
//    @Autowired
//    InvoiceDAO idao = new InvoiceDAO();
//
//    @Autowired
//    JobCategoryDAO jcdao = new JobCategoryDAO();
//
//    @Autowired
//    JobProfilesDAO jpdao = new JobProfilesDAO();
//    
//    private static final Logger logger = Logger.getLogger(UserController.class.getName());
//
//    @RequestMapping("/Users/Userform")
//    public ModelAndView showform() {
//        Employee employee = new Employee();
//        employee.setCustomers(cdao.getCustomersMap());
//
//        return new ModelAndView("employeeform", "command", employee);
//    }
//
//    @RequestMapping("/employee/employeeform/{id}")
//    public ModelAndView showformWithCustomer(@PathVariable int id) {
//        Customer customer = cdao.getCustomerById(id);
//
//        Employee employee = new Employee();
//        employee.setCustomerID(id);
//        employee.setCustomer(customer);
//        employee.setCustomers(cdao.getCustomersMap());
//
//        return new ModelAndView("employeeform", "command", employee);
//    }
//
//    @RequestMapping(value = "/employee/save", method = RequestMethod.POST)
//    public ModelAndView save(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
//        int r = edao.save(employee);
//
//        Message msg = null;
//        if (r == 1) {
//            msg = new Message(Message.Level.INFO, "Employee has been successfully created");
//        } else {
//            msg = new Message(Message.Level.ERROR, "New employee creation failed");
//        }
//
//        request.getSession().setAttribute("message", msg);
//
//        return new ModelAndView("redirect:/employee/viewemployee");
//    }
//
//    @RequestMapping("/employee/viewemployee")
//    public ModelAndView viewemployee(HttpServletRequest request) {
//        //List<Employee> list = dao.getEmployeesList();
//        //return new ModelAndView("viewemployee","list",list);
//
//        return this.viewemployee(1, request);
//    }
//
//    @RequestMapping("/employee/viewemployee/{pageid}")
//    public ModelAndView viewemployee(@PathVariable int pageid, HttpServletRequest request) {
//        int total = 25;
//        int start = 1;
//
//        if (pageid != 1) {
//            start = (pageid - 1) * total + 1;
//        }
//
//        List<Employee> list = edao.getEmployeesByPage(start, total);
//
//        HashMap<String, Object> context = new HashMap<String, Object>();
//        context.put("list", list);
//
//        int count = edao.getEmployeesCount();
//        context.put("pages", Math.ceil((float) count / (float) total));
//
//        context.put("page", pageid);
//
//        Message msg = (Message) request.getSession().getAttribute("message");
//
//        if (msg != null) {
//            context.put("message", msg);
//            request.getSession().removeAttribute("message");
//        }
//
//        return new ModelAndView("viewemployee", context);
//    }
//
//    @RequestMapping(value = "/employee/editemployee/{id}")
//    public ModelAndView edit(@PathVariable int id) {
//        Employee employee = edao.getEmployeeById(id);
//
//        employee.setCustomers(edao.getCustomersMap());
//
//        return new ModelAndView("employeeeditform", "command", employee);
//    }
//
//    @RequestMapping(value = "/employee/editsave", method = RequestMethod.POST)
//    public ModelAndView editsave(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
//        int r = edao.update(employee);
//
//        Message msg = null;
//        if (r == 1) {
//            msg = new Message(Message.Level.INFO, "Employee has been successfully saved");
//        } else {
//            msg = new Message(Message.Level.ERROR, "Edit employee failed");
//        }
//
//        request.getSession().setAttribute("message", msg);
//
//        return new ModelAndView("redirect:/employee/viewemployee");
//    }
//
//    @RequestMapping(value = "/employee/deleteemployee/{id}", method = RequestMethod.GET)
//    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
//        int r = edao.delete(id);
//
//        Message msg = null;
//        if (r == 1) {
//            msg = new Message(Message.Level.INFO, "Employee has been successfully deleted");
//        } else {
//            msg = new Message(Message.Level.ERROR, "Delete employee failed");
//        }
//
//        request.getSession().setAttribute("message", msg);
//
//        return new ModelAndView("redirect:/employee/viewemployee");
//    }
}
