package com.octocat.springboot.demo.octocatapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    expose "/" that return "Hello World"
    @Value("${db.connectionString}")
    private String dbconnectionString;
    @GetMapping("/")
    public String sayHello(){
        return "<h1>Hello World!</h1>" + "ConnectionString: "+this.dbconnectionString;
    }


}
