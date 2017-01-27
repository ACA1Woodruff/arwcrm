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
import arwcrm.repository.CustomerDAO;

/**
 *
 * @author awood
 */

@Controller
public class CustomerController{
    @Autowired
    CustomerDAO dao;

    /**
     *
     * @return
     */
    @RequestMapping("/customer/customerform")
    public ModelAndView showform(){
        return new ModelAndView("customerform","command",new Customer());
    }

    /**
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/customer/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("customer") Customer customer){
        dao.save(customer);
        return new ModelAndView("redirect:/customer/viewcustomer");
    }

    /**
     *
     * @return
     */
    @RequestMapping("/customer/viewcustomer")
    public ModelAndView viewcustomer(){
        List<Customer> list = dao.getCustomersList();
        return new ModelAndView("viewcustomer","list",list);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/customer/editcustomer/{id}")
    public ModelAndView edit(@PathVariable int id){
        Customer customer = dao.getCustomerById(id);
        return new ModelAndView("customereditform","command",customer);
    }
    
    /**
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/customer/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("customer") Customer customer){
        dao.update(customer);
        return new ModelAndView("redirect:/customer/viewcustomer");
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/customer/deletecustomer/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        dao.delete(id);
        return new ModelAndView("redirect:/customer/viewcustomer");
    }
}


 

