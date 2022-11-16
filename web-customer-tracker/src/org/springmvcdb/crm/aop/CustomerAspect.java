package org.springmvcdb.crm.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Aspect
@Component
public class CustomerAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	public final String ACCOUNT_SID = "";
	public final String AUTH_TOKEN = "";

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
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber("whatsapp:+971545677338"),
						new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), "user deleted" + sendMessage)
				.create();

		System.out.println(message.getSid());
	}
}
