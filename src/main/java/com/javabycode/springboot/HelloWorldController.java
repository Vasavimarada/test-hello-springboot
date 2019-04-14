package com.javabycode.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
               String message="You just create Spring Boot Example successfully";
        model.addAttribute("name", name);
        model.addAttribute("message", message);
        
        return "hello";
    }
    
    @RequestMapping(method= {RequestMethod.GET},value="/customer")@ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<Customer> printCustomer(@RequestParam(value="name", required=false) String name,
    		@RequestParam(value="id", required=false) int id,@RequestParam(value="ssn", required=false) String ssn ){
    	CustomerDetailsImpl c1= new CustomerDetailsImpl();
    	Customer vasavi= c1.printCustomer(id, name, ssn);
    	
				return new ResponseEntity<Customer>(vasavi,HttpStatus.OK);
    	
    }
    
    /*@RequestMapping(method= {RequestMethod.POST},value="/customer")@ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<Customer> storeCustomer( @RequestBody){
    	CustomerDetailsImpl c1= new CustomerDetailsImpl();
    	Customer vasavi= c1.printCustomer(id, name, ssn);
    	
				return new ResponseEntity<Customer>(vasavi,HttpStatus.OK);
    	
    }*/
    
}

