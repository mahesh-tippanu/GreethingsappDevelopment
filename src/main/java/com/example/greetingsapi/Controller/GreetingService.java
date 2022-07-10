package com.example.demo.service.GreetingService.java;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	 public String greetingMessage(){
	        return "Hello World!";
	    }
	    public String greetingWithUserName(String firstName, String lastName) {
	        if(firstName.isEmpty() && lastName.isEmpty())
	            return greetingMessage();
	        else if (!(firstName.equals("")) && (lastName.equals(""))) {
	            return "Hello & Welcome to the greeting app, "+firstName;
	        }
	        else if (!(lastName.equals("")) && (firstName.equals(""))) {
	            return "Hello & Welcome to the greeting app, "+lastName;
	        }
	        else
	            return "Hello & Welcome to the greeting app, "+firstName+" "+lastName+"!";
	    }
}
