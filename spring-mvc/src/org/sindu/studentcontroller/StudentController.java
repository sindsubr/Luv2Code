package org.sindu.studentcontroller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Map;

import javax.validation.Valid;

import org.sindu.customvalidation.ImageFileCheckConstraintValidator;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/student")
public class StudentController {

	// For Trimming whitespaces in all requests
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
		System.out.println(dataBinder.getTarget());
	}

	@Value("#{yearsOfExpOptions}")
	private Map<String, String> yearsOfExpPropertiesMap;
	@Value("#{userPath}")
	private Map<String, String> pathMap;

	@RequestMapping("/getForm")
	public String getDetails(Model model) {
		Student student = new Student();
		model.addAttribute("studentModel", student);
		model.addAttribute("yearsOfExpMap", yearsOfExpPropertiesMap);
		return "studentform";
	}

	@RequestMapping("/submitForm")
	public String submitDetails(@Valid @ModelAttribute("studentModel") Student studentObj, BindingResult bindResult,
			Model model) {
		// file upload functionality
		String location = pathMap.get("location");
		CommonsMultipartFile file = studentObj.getProfilePic();
		String filename = file.getOriginalFilename();
		System.out.println(location + filename);
		System.out.println(filename);
		model.addAttribute("profilePicPath", pathMap.get("jsplocation") + filename);
		System.out.println("model attribute:" + model.getAttribute("profilePicPath"));
		System.out.println(file.getContentType().contains("image"));
		if (file.getContentType().contains("image"))
			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(location + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				System.out.println(e);
			}
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
