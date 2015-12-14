package ecp.spring.web;

import ecp.spring.service.PersonManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import ecp.spring.service.PersonManagerDWRImpl;

@Controller
public class PersonDWRController {

    @Autowired
    PersonManagerDWRImpl personDWR;

    @RequestMapping(value="/test/dwr/add", method=RequestMethod.GET)
    public String add(){
        return "add";
    }

}

