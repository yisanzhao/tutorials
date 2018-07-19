package com.vmware.example.controller;

import com.vmware.example.config.JavaConfiguration;
import com.vmware.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class DemoRestController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private static final String PRODUCES_JSON = "application/json,application/x-spring-data-compact+json";
    private static final String PRODUCES_TEXT = "text/plain";

    @Autowired
    private JavaConfiguration config;

    @Autowired
    public Account account;


    @RequestMapping(value="/hellobeans", method=RequestMethod.GET)
    @ResponseBody
    public String getConfig() {
        String result = "The user from Autowired accountBean is " + account.getUser() + System.lineSeparator() ;
//        String result = "Autowired java annotation bean from javaStringBean1 is " + config.javaStringBean1();
        return result;

    }

    @RequestMapping(value="/helloworld", method=RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value="/beans/{name}", method=RequestMethod.GET)
    @ResponseBody
    public String getBean( @PathVariable String name) {
        String bean = applicationContext.getBean(name).toString();
        return bean;
    }
}
