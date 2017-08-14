package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

	 @RequestMapping("/hi")
	  public String sayHi() {
		 System.out.println("Word - Being Up");
	    return "Hello";
	  }
}
