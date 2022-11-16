package org.aspect_tutorial.spring_aop.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class MyAppService {

	private String serviceId;
	private String serviceName;

	private Logger myLogger = Logger.getLogger(getClass().getName());

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "MyAppService [serviceId=" + serviceId + ", serviceName=" + serviceName + "]";
	}

	public Object myBusinessLogic(boolean boolValue) {
		myLogger.info("service Business Logic called");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (boolValue)
			throw new RuntimeException("Run time Exception Occurs..!");
		return boolValue;
	}

	public void myBusinessLogicWithNoArg() {
		myLogger.info("service Business Logic with no args called");
	}

	public void myBusinessLogicForAfter() {
		myLogger.info("service Business Logic with no args for After called");
	}
}
