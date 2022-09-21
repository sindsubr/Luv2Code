package org.springmvc.studentcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmvc.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{yearsOfExpOptions}")
	private Map<String,String> yearsOfExpPropertiesMap; 
	
	@RequestMapping("/getForm")
	public String getDetails(Model model) {
		Student student = new Student();
		model.addAttribute("studentModel",student);
		model.addAttribute("yearsOfExpMap",yearsOfExpPropertiesMap);
		return "studentform";
	}
	
	@RequestMapping("/submitForm")
	public String submitDetails(@ModelAttribute("studentModel") Student studentObj) {
		String[] array = studentObj.getSkills();
		for(int i =0;i<array.length;i++)
		System.out.println(array[i]);
		System.out.println(studentObj.getLastName());
		return "confirmpage";
	}
}
