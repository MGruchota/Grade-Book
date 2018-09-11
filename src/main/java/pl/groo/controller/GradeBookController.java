package pl.groo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GradeBookController {

    @RequestMapping({"/", "/home"})
    String homepage(){
        return "home";
    }

    @RequestMapping("loginpage")
    String loginpage(){
        return "loginpage";
    }

    @RequestMapping("logged")
    String loggedin(){
        return "logged";
    }

}
