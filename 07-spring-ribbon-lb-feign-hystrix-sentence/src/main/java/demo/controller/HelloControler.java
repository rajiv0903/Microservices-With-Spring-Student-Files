package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

	 @RequestMapping("/hi")
	  public String sayHi() {
		 System.out.println("I am being called!");
	    return "Hello";
	  }
}
