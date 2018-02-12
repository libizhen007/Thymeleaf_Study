package cn.haihihi.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day01 {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World1!";
	}
}
