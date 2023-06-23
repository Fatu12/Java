package com.fatuma.hooper.sreceipt.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//  @Controller 
@Controller
public class Controllers {
	@RequestMapping("/")
	
	// is to use it as a container to store data and pass that data it the view engine 
	// data can be any type and  when  the framework gets a request mapped to that function 
	// it will automatically create that Model instance container
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
        model.addAttribute("name",name);
         model.addAttribute("item",itemName);
         model.addAttribute("itemPrice",price);
         model.addAttribute("itemDescription",description);
         model.addAttribute("vendorChore",vendor);
         
        
    
        return "index.jsp";
    }
    

}
