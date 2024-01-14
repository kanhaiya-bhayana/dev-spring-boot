package com.octocat.springboot.demo.octocatapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "Hello World"

    // Inject the properties from APPLICATION.PROPERTIES file...
    @Value("${db.connectionString}")
    private String dbconnectionString;

    @GetMapping("/")
    public String sayHello(){
        return "<h1>Hello World!</h1>" + "ConnectionString: "+this.dbconnectionString;
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Important for healthy life!";
    }

    // expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your Lucky Day!";
    }


}
