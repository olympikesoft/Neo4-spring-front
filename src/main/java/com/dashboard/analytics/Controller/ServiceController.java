package com.dashboard.analytics.Controller;

import com.dashboard.analytics.Service.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	final ServiceSpring services;

	@Autowired
	public ServiceController(ServiceSpring services) {
		this.services = services;
	}

	@RequestMapping("/graph")
	public Map<String, Object> graph(
			@RequestParam(value = "limit", required = false) Integer limit) {
		return services.graph(limit == null ? 100 : limit);
	}

	@RequestMapping("/machine")
	public Map<String, Object> getErrors(
			@RequestParam(value = "errorType", required = true) String errorType) {
		return services.machine(errorType);

	}

	@RequestMapping("/structure")
	public Map<String, Object> getStructure() {
		return services.getCallsMachine();
	}

	@RequestMapping("/connection")
	public Map<String, Object> getHardwareConn() {
		return services.getCallHardware();
	}

}
