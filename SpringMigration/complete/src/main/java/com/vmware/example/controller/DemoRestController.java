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

    @Autowired
    public Account account;

    private ApplicationContext applicationContext;

    @Autowired
    private JavaConfiguration config;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @RequestMapping(value="/beans/{name}", method=RequestMethod.GET)
    @ResponseBody
    public String getBean( @PathVariable String name) {
        String result = "";
        Object bean = applicationContext.getBean(name);
        result = bean.toString();

        if (bean.getClass() == Account.class ){
            result = "The user from Autowired accountBean is " + account.getUser();
        }

        if (bean.getClass() == JavaConfiguration.class ){
            result = "The value from Autowired java annotation bean javaStringBean1 is " + config.javaStringBean1();
        }

        return result;
    }
}
