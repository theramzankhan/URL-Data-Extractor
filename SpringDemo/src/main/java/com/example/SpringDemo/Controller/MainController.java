package com.example.SpringDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
//	This maps the root URL (/) to the home method. When users visit the root of the application, this method is triggered.
//	Return Type: The method returns a String, representing the name of the view to be rendered. Here, it returns "home", meaning Spring MVC will look for a view named home.jsp, home.html, or another template based on the view resolver configuration.
	@RequestMapping("/")
	public String home() {
//		Logging: System.out.println("This is home page"); logs a message to the console each time the method is called.
		System.out.println("This is home page");
		return "home";
	}
	
//	Maps the /contact URL to the contact method. When users visit http://<your-domain>/contact, this method will be invoked.
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("This is contact page");
		return "contact";
	}
	
}

//Summary - This MainController class serves as a simple routing mechanism in a Spring MVC application, handling two specific URLs.