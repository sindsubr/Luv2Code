package org.springmvcjavaconfig.bakery.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Map;

import javax.validation.Valid;

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
import org.springmvcjavaconfig.bakery.entity.CustomerOrder;

@Controller
public class OrderController {

	@Value("#{countryCode}")
	public Map<String, String> countryCodeMap;
	@Value("#{paymentMode}")
	private Map<String, String> modeOfPayment;
	@Value("#{flavours}")
	private Map<String, String> flavourMap;
	@Value("#{userPath}")
	private Map<String, String> cakeFlavourPathMap;

	@InitBinder
	public void intitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}

	@RequestMapping("/")
	public String getOrderForm(Model modelObj) {
		CustomerOrder orderObj = new CustomerOrder();
		modelObj.addAttribute("customerModel", orderObj);
		modelObj.addAttribute("countryCodeMap", countryCodeMap);
		modelObj.addAttribute("modeOfPayment", modeOfPayment);
		modelObj.addAttribute("flavourMap", flavourMap);
		System.out.println(countryCodeMap);
		return "order-form";
	}

	@RequestMapping("/order")
	public String order(@Valid @ModelAttribute("customerModel") CustomerOrder customerObj, BindingResult result,
			Model modelObj) {

		String location = cakeFlavourPathMap.get("location");
		CommonsMultipartFile file = customerObj.getCakeTheme();
		String filename = file.getOriginalFilename();
		if (file.getContentType().contains("image"))
		try {
			byte[] fileByte = file.getBytes();
			System.out.println(location + filename);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(location + filename));
			bufferedOutputStream.write(fileByte);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		modelObj.addAttribute("cakeThemePath", cakeFlavourPathMap.get("jsplocation") + filename);
		if (result.hasErrors()) {
			System.out.println(result);
			modelObj.addAttribute("customerModel", customerObj);
			modelObj.addAttribute("countryCodeMap", countryCodeMap);
			modelObj.addAttribute("modeOfPayment", modeOfPayment);
			modelObj.addAttribute("flavourMap", flavourMap);

			return "order-form";
		} else {
			System.out.println(customerObj.getFirstName());
			System.out.println(customerObj.getLastName());
			System.out.println(customerObj.getEmail());
			return "order-confirmation";
		}
	}
}
