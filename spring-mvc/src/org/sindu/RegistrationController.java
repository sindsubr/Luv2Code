package org.sindu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "form";
	}

	@RequestMapping("/processForm")
	public ModelAndView confirm(@RequestParam("studentName") String reqName, HttpServletRequest request,
			ModelAndView mv) {
//		String name = request.getParameter("studentName");
		String name = reqName.toUpperCase();
		mv.setViewName("uppercase");
		mv.addObject("YourName", name);
//		mv.addAttribute("YourName",name);
		return mv;
	}

}
