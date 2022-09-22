package org.sindu.studentcontroller;

import java.util.Map;

import javax.validation.Valid;

import org.sindu.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//For Trimming whitespaces in all requests
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
		System.out.println(dataBinder.getTarget());
	}

	@Value("#{yearsOfExpOptions}")
	private Map<String, String> yearsOfExpPropertiesMap;

	@RequestMapping("/getForm")
	public String getDetails(Model model) {
		Student student = new Student();
		model.addAttribute("studentModel", student);
		model.addAttribute("yearsOfExpMap", yearsOfExpPropertiesMap);
		return "studentform";
	}

	@RequestMapping("/submitForm")
	public String submitDetails(@Valid@ModelAttribute("studentModel") Student studentObj, BindingResult bindResult) {
		System.out.println(studentObj.getFirstName());
		System.out.println(bindResult.getAllErrors());
		if (bindResult.hasErrors()) {
			return "studentform";
		} else {
			String[] array = studentObj.getSkills();
			for (int i = 0; i < array.length; i++)
				System.out.println(array[i]);
			System.out.println(studentObj.getLastName());
			return "confirmpage";
		}
	}
}
