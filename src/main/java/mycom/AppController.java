package mycom;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Donar;
import com.service.DonarService;
import com.service.MailService;

@Controller
@RequestMapping("/")
@ComponentScan("com")
public class AppController {
	
	@Autowired
	DonarService service;
	@Autowired
	MessageSource messageSource;
	
	public DonarService getService() {
		return service;
	}

	public void setService(DonarService service) {
		this.service = service;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}	
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
	@RequestMapping(value = {"/list" }, method = RequestMethod.POST)
	public String listDonars(@RequestParam String bg, ModelMap model) {
		System.out.println(bg);
	    List<Donar> donars = service.service1(bg);
	    System.out.println(donars);
	    model.addAttribute("donars", donars);
	    return "home";
    }
	
	@RequestMapping(value = {"/display" }, method = RequestMethod.POST)
	public String displayDonar(@RequestParam String id, ModelMap model) {
	    List<Donar> donars = new ArrayList<>();
	    if(service.service2(id)) donars.add(service.service4(id));
	    System.out.println(donars);
	    model.addAttribute("donars", donars);
	    return "home";
    }
	
	@RequestMapping(value = {"/mail" }, method = RequestMethod.POST)
	public String sendDonars(@RequestParam String bg, ModelMap model) {
		System.out.println(bg);
	    List<String> donars = service.service7(bg);
	    System.out.println(donars);
	    
	    MailService obj = new MailService();
	    obj.Notification(donars,bg);
	    
	    model.addAttribute("success", "Mail sent successfully");
        return "success";
    }
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newDonar(ModelMap model) {
        Donar donar = new Donar();
        model.addAttribute("donar", donar);
        model.addAttribute("edit", false);
        
        return "registration";
    }
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveDonar(@Valid Donar donar, BindingResult result, ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }

        if(service.service2(donar.getDonarid())){
            FieldError error =new FieldError("donar","donarid",messageSource.getMessage("non.unique.donar", new String[]{donar.getDonarid()}, Locale.getDefault()));
            result.addError(error);
            return "registration";
        }
 
        service.service3(donar);
 
        model.addAttribute("success", "Donar " + donar.getName() + " registered successfully");
        return "success";
    }
	
	@RequestMapping(value = { "/edit-{donarid}-donar" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String donarid, ModelMap model) {
        Donar donar = service.service4(donarid);
        System.out.println(donar);
        model.addAttribute("donar", donar);
        model.addAttribute("edit", true);
        return "registration";
    }
	
	@RequestMapping(value = { "/edit-{donarid}-donar" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Donar donar, BindingResult result, ModelMap model, @PathVariable String donarid) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.service2(donar.getDonarid())){
            FieldError error = new FieldError("donar","donarid",messageSource.getMessage("unique.donar", new String[]{donar.getDonarid()}, Locale.getDefault()));
            result.addError(error);
            return "registration";
        }
 
        service.service5(donar);
 
        model.addAttribute("success", "Donar " + donar.getName()  + " updated successfully");
        return "success";
    }
	
	@RequestMapping(value = { "/delete-{donarid}-donar" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String donarid) {
	    service.service6(donarid);
	    return "home";
	}
}