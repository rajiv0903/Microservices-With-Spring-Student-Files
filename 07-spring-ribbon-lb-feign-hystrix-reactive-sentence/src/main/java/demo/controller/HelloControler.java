package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

	 @RequestMapping("/hi")
	  public String sayHi() {
	    return "Hello";
	  }
}
