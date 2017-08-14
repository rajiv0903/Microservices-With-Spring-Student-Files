package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

	/*@Value("${eureka.instance.metadataMap.instanceId}") 
	String EinstanceId;
	
	@Value("${spring.application.instance_id}")
    private String SinstanceId;*/
	
	/*@RequestMapping("/hi")
	public String sayHi() {
		return "Hello!" +", EureKa :"+ EinstanceId +", Spring :"+ SinstanceId;
	}*/
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hello!";
	}
}
