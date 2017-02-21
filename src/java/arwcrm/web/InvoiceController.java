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
public class InvoiceController {

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

    private static final Logger logger = Logger.getLogger(InvoiceController.class.getName());

    @RequestMapping("/invoice/invoiceform")
    public ModelAndView showform() {
        Invoice invoice = new Invoice();
        invoice.setCustomers(idao.getCustomersMap());

        return new ModelAndView("invoiceform", "command", invoice);
    }

    @RequestMapping("/invoice/invoiceform/{id}")
    public ModelAndView showformWithCustomer(@PathVariable int id) {
        Customer customer = cdao.getCustomerById(id);
        
        Invoice invoice = new Invoice();
        invoice.setCustomerId(id);
        invoice.setCustomer(customer);
        invoice.setCustomers(cdao.getCustomersMap());

        return new ModelAndView("invoiceform", "command", invoice);
    }

    @RequestMapping(value = "/invoice/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("invoice") Invoice invoice, HttpServletRequest request) {
        int r = idao.save(invoice);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Invoice has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New invoice creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/invoice/viewinvoice");
    }

    @RequestMapping("/invoice/viewinvoice")
    public ModelAndView viewinvoice(HttpServletRequest request) {
        //List<Invoice> list = idao.getInvoicesList();
        //return new ModelAndView("viewinvoice","list",list);

        return this.viewinvoice(1, request);
    }

    @RequestMapping("/invoice/viewinvoice/{pageid}")
    public ModelAndView viewinvoice(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Invoice> list = idao.getInvoicesByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = idao.getInvoiceCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewinvoice", context);
    }

    @RequestMapping(value = "/invoice/editinvoice/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Invoice invoice = idao.getInvoiceById(id);
        invoice.setCustomers(idao.getCustomersMap());
        return new ModelAndView("invoiceeditform", "command", invoice);
    }

    @RequestMapping(value = "/invoice/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("invoice") Invoice invoice, HttpServletRequest request) {
        int r = idao.update(invoice);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Invoice has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit invoice failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/invoice/viewinvoice");
    }

    @RequestMapping(value = "/invoice/deleteinvoice/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = idao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Invoice has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete invoice failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/invoice/viewinvoice");
    }
}
