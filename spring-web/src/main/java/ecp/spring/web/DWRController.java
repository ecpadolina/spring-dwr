package ecp.spring.web;

import ecp.spring.service.PersonManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import ecp.spring.service.DWRService;

@Controller
public class DWRController {

    @Autowired
    DWRService dwrService;

    @RequestMapping(value="/person/dwr/index", method=RequestMethod.GET)
    public String add(){
        return "add";
    }


}

