package com.easybytes.eazyschool.Controller;

import com.easybytes.eazyschool.model.Contact;
import com.easybytes.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class  ContactController {
    private static final Logger log = getLogger(ContactController.class);
    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService){
        this.contactService= contactService;
    }
    @RequestMapping(value={ "/contact"})
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }
    /* @RequestMapping(value = "/saveMsg",method = POST)
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message) {

         log.info("Name : " + name);
        log.info("Mobile Number : " + mobileNum);
        log.info("Email Address : " + email);
        log.info("Subject : " + subject);
        log.info("Message : " + message);
        return new ModelAndView("redirect:/contact");
    }*/


        @RequestMapping(value = "/saveMsg",method = POST)
        public String saveMessage(@Valid @ModelAttribute("contract") Contact contact, Errors errors ){
            if(errors.hasErrors()){
                log.error("Contact Form Validation Failed due to :" + errors.toString());
                return "contact.html";
            }
         contactService.saveMessageDetails(contact);
         return "redirect:/contact";
    }}

