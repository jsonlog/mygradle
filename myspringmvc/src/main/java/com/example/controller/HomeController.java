package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jsonlog
 * @date 2019-08-05
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String index(){
        return "home";
    }


    @RequestMapping("/hello")
    public String hello(){
        return "helloform";
    }

    // @RequestMapping("jsp/{url}")
    // public String fileupload(@PathVariable String url){
    //     System.out.println("HomeController:jsp/"+url);
    //     return "jsp/"+url;
    // }
}
