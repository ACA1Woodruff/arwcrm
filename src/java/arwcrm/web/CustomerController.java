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
import arwcrm.objects.Message;
import arwcrm.repository.CustomerDAO;
import arwcrm.validation.CustomerValidator;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author awood
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerDAO cdao;

    @Autowired
    private CustomerValidator customerValidator;

    private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

    /**
     *
     * @return
     */
    @RequestMapping("/customer/customerform")
    public ModelAndView showform() {
        return new ModelAndView("customerform", "customer", new Customer());
    }

    /**
     *
     * @param customer
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("customerform", "customer", customer);
        }

        int r = cdao.save(customer);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Customer has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New customer creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/customer/viewcustomer");
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/customer/viewcustomer")
    public ModelAndView viewcustomer(HttpServletRequest request) {
        return this.viewcustomer(1, request);
    }

    /**
     *
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/customer/viewcustomer/{pageid}")
    public ModelAndView viewcustomer(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Customer> list = cdao.getCustomersByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = cdao.getCustomersCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewcustomer", context);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/customer/editcustomer/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Customer customer = cdao.getCustomerById(id);
        return new ModelAndView("customereditform", "customer", customer);
    }

    /**
     *
     * @param customer
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/customer/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("customereditform", "customer", customer);
        }

        int r = cdao.update(customer);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Customer has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit customer failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/customer/viewcustomer");
    }

    /**
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/customer/deletecustomer/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = cdao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Customer has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete customer failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/customer/viewcustomer");
    }

    /**
     *
     * @param webDataBinder
     */
    @InitBinder("customer")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(customerValidator);
    }

    /**
     *
     * @return
     */
    public CustomerValidator getCustomerValidator() {
        return customerValidator;
    }

    /**
     *
     * @param customerValidator
     */
    public void setCustomerValidator(CustomerValidator customerValidator) {
        this.customerValidator = customerValidator;
    }
}
