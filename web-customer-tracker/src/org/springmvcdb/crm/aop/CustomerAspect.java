package org.springmvcdb.crm.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import io.github.cdimascio.dotenv.Dotenv;

@Aspect
@Component
public class CustomerAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	Dotenv dotenv = Dotenv.configure()
//			.directory("/assets")
			.filename(".env")
			.load(); // instead of '.env', use 'env'

	public final String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
	public final String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
	public final String TWILIO_TO_WHATSAPP_NUMBER = dotenv.get("TWILIO_TO_WHATSAPP_NUMBER");
	public final String TWILIO_FROM_WHATSAPP_NUMBER = dotenv.get("TWILIO_FROM_WHATSAPP_NUMBER");

	@Before("execution(* org.springmvcdb.crm.service.CustomerServiceImpl.deleteCustomer(int))")
	public void deleteCustomerAdvice(JoinPoint joinPoint) {
		logger.info("<----@Before invoked---->");
	}

	@AfterReturning("execution(* org.springmvcdb.crm.service.CustomerServiceImpl.deleteCustomer(int))")
	public void deleteCustomerAfterAdvice(JoinPoint joinPoint) {
		logger.info("<----@After Returning invoked---->");
		String sendMessage = "Deleted Customer Id: ";
		Object[] args = joinPoint.getArgs();
		for (Object tmpArg : args) {
			sendMessage = sendMessage + tmpArg.toString();
		}
		System.out.println(ACCOUNT_SID);
		System.out.println(AUTH_TOKEN);
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber(TWILIO_TO_WHATSAPP_NUMBER),
						new com.twilio.type.PhoneNumber(TWILIO_FROM_WHATSAPP_NUMBER), "" + sendMessage)
				.create();

		System.out.println(message.getSid());
	}
}
