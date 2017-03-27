package arwcrm.web;

import arwcrm.validation.InteractionsValidator;
import arwcrm.objects.Message;
import arwcrm.objects.Interactions;
import arwcrm.repository.InteractionsDAO;
import arwcrm.repository.CustomerDAO;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author awood
 */
@Controller
public class InteractionsController {

    @Autowired
    InteractionsDAO dao;

    @Autowired
    private InteractionsValidator interactionsValidator;

//    private static final Logger logger = Logger.getLogger(InteractionsController.class.getName());
    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        return new ModelAndView("interactionsform", "interactions", new Interactions());
    }

    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") Interactions interactions, HttpServletRequest request) {
        
        int r = dao.save(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New interaction creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(HttpServletRequest request) {
        return this.viewinteractions(1, request);
    }

    @RequestMapping("/interactions/viewinteractions/{pageid}")
    public ModelAndView viewinteractions(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Interactions> list = dao.getInteractionsByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getInteractionsCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");

        }

        return new ModelAndView("viewinteractions", context);
    }

    @RequestMapping(value = "/interactions/editinteractions/{interactions_id}")
    public ModelAndView edit(@PathVariable int interactions_id) {
        Interactions interactions = dao.getInteractionsById(interactions_id);
        return new ModelAndView("interactionseditform", "interactions", interactions);
    }

    @RequestMapping(value = "/interactions/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") Interactions interactions, HttpServletRequest request) {
//        if (result.hasErrors()) {
//            return new ModelAndView("interactionseditform", "interactions", interactions);
//        }
        int r = dao.update(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Interaction edit failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping(value = "/interactions/deleteinteractions/{interactions_id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int interactions_id, HttpServletRequest request) {
        int r = dao.delete(interactions_id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Interaction deletion failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @InitBinder("interactions")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(interactionsValidator);
    }

    public InteractionsValidator getInteractionsValidation() {
        return interactionsValidator;
    }

    public void setInteractionsValidation(InteractionsValidator interactionsValidation) {
        this.interactionsValidator = interactionsValidator;
    }

}
