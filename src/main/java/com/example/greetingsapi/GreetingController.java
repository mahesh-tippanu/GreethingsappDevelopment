package com.example.demo.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting.java.Greeting;
import com.example.demo.service.GreetingService.java.GreetingService;

@RestController
public class GreetingController {
	public static final String template = "Hello & Welcome to the greeting app, %s";
    public final AtomicLong counter = new AtomicLong();
	 
    @Autowired
    public GreetingService service;
    
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.greetingMessage();
    }
    
    @GetMapping("/greetingsWithUser")
    public String greetingwithUserName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName){
    	 return service.greetingWithUserName(firstName, lastName);
    }
    @PostMapping("/addGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting){
        return service.saveGreetings(greeting);
    }
    @GetMapping("/greetingById/{id}")
    public Greeting getGreetingById(@PathVariable Integer id){
        return service.findGreetingById(id);
    }
    @GetMapping("/allGreetings")
    public List<Greeting> findAllGreetings() {
        return service.findGreetings();
    }
    @PutMapping("/editGreeting/{id}")
    public Greeting editGreeting(@RequestBody Greeting greeting, @PathVariable Integer id){
        return service.editGreeting(greeting, id);
    }
}
	