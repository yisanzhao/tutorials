package com.vmware.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


@Controller
public class DemoController {

    @RequestMapping(value="/helloworld", method=RequestMethod.GET)
    public String helloworld(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}

