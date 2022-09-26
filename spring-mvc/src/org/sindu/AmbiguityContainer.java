package org.sindu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class AmbiguityContainer {

	@ResponseBody
	@RequestMapping("/index")
	public String display() {
		return "Just a String";
	}
}
