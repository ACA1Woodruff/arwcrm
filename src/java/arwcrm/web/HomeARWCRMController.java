package arwcrm.web;

import arwcrm.objects.Customer;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeARWCRMController{
    
    @RequestMapping("/")
    public ModelAndView viewcustomer(){
        return new ModelAndView("index");
    }
}
