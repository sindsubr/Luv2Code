package org.springmvcweb.hibernate.customerorder.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springmvcweb.hibernate.customerorder.entity.Customer;
import org.springmvcweb.hibernate.customerorder.entity.CustomerOrder;
import org.springmvcweb.hibernate.customerorder.service.CustomerOrderService;
import org.springmvcweb.hibernate.customerorder.util.DateUtils;

@Controller
@RequestMapping("/customer")
public class CustomerOrderController {

	@Autowired
	private CustomerOrderService CustomerOrderService;
	@Value("#{flavors}")
	public Map<String, String> cakeFlavors;

	byte[] imageBytes;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringEditor);
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("dd-MMMM-yy"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/order")
	public String createOrder(Model customerOrderModel) {
		CustomerOrder order = new CustomerOrder();
		customerOrderModel.addAttribute("customerOrderModel", order);
		customerOrderModel.addAttribute("cakeFlavors", cakeFlavors);
		return "order-form";
	}

	@RequestMapping("/placeOrder")
	public String placeOrder(@Valid @ModelAttribute("customerOrderModel") CustomerOrder order,
			BindingResult bindingResult, HttpServletRequest request, Model customerOrderModel,
			@RequestParam MultipartFile file) throws IOException, SerialException, SQLException {
		customerOrderModel.addAttribute("cakeFlavors", cakeFlavors);
		System.out.println(order.getCakeModel());
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "order-form";
		}

		// Setting Date to CustomerOrder
		String dateString = request.getParameter("dateString");
		if (!dateString.isEmpty()) {
			order.setDob(DateUtils.parse(dateString));
		}
		// Image file check
		System.out.println("filedetails:" + file);
		imageBytes = file.getBytes();
		BufferedImage imageFileCheck = ImageIO.read(new ByteArrayInputStream(imageBytes));
		System.out.println("Image" + imageFileCheck);

		// Setting image file to cake Model
		if (imageFileCheck != null) {
			order.setCakeModel(file.getBytes());
			imageBytes = order.getCakeModel();
		} else {
			String errorString = "Please select your cake model with valid image file and should not exceed image size 500kb..!!";
			customerOrderModel.addAttribute("errorString", errorString);
			return "order-form";
		}

		System.out.println("Cake Model:" + order.getCakeModel());
		Customer customer = new Customer(order.getFirstName(), order.getLastName(), order.getEmail(),
				order.getMobileNo());
		CustomerOrderService.saveCustomerOrder(customer, order);

		return "order-success";
	}

	@RequestMapping(value = "/getCakeModel")
	public void getCakeModel(HttpServletResponse response) throws Exception {
		System.out.println("getCakeModel called");
		response.setContentType("image/jpeg");
		InputStream inputStream = new ByteArrayInputStream(imageBytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping("/processAmount")
	public void processAmount(@ModelAttribute("customerOrderModel") CustomerOrder order) {
		System.out.println("called");
		order.setAmount(order.getKg() * 100);
		
	}
}
