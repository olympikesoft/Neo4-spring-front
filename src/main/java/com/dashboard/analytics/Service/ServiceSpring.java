package com.dashboard.analytics.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.analytics.Dao.ErrorNodejs;
import com.dashboard.analytics.Dao.ErrorWebsphere;
import com.dashboard.analytics.Dao.Hardware;
import com.dashboard.analytics.Dao.Machine;
import com.dashboard.analytics.Repositories.RepositoryErrorNodejs;
import com.dashboard.analytics.Repositories.RepositoryErrorWebsphere;
import com.dashboard.analytics.Repositories.RepositoryHardware;
import com.dashboard.analytics.Repositories.RepositoryMachine;

@Service
public class ServiceSpring {

	@Autowired
	RepositoryErrorNodejs repositoryerrorsNodejs;

	@Autowired
	RepositoryErrorWebsphere repositoryerrorsWebsphere;

	@Autowired
	RepositoryMachine repositorymachine;

	@Autowired
	RepositoryHardware repositoryhardware;

	private Map<String, Object> toD3FormatErrorsNodejs(
			Collection<ErrorNodejs> errorsNodejs) {
		List<Map<String, Object>> nodes = new ArrayList<>();

		Iterator<ErrorNodejs> result = errorsNodejs.iterator();
		while (result.hasNext()) {
			ErrorNodejs errorNodejs = result.next();
			nodes.add(map(errorNodejs.getId().toString(), errorNodejs));

		}
		return map("nodes", nodes);
	}

	private Map<String, Object> toD3FormatAgentConnHardware(
			Collection<Hardware> hardwares) {
		List<Map<String, Object>> nodes = new ArrayList<>();

		Iterator<Hardware> result = hardwares.iterator();
		while (result.hasNext()) {
			Hardware hardware = result.next();
			nodes.add(map("hardware", hardware));

		}
		return map("nodes", nodes);
	}

	public Map<String, Object> toD3FormatErrorsWebsphere(
			Collection<ErrorWebsphere> errorsWebsphere) {
		List<Map<String, Object>> nodes = new ArrayList<>();

		Iterator<ErrorWebsphere> result = errorsWebsphere.iterator();

		while (result.hasNext()) {
			ErrorWebsphere errorWebsphere = result.next();
			nodes.add(map(errorWebsphere.getId().toString(), errorWebsphere));

		}

		return map("nodes", nodes);

	}

	private Map<String, Object> map(String key1, Object value1) {
		Map<String, Object> result = new HashMap<String, Object>(1);
		result.put(key1, value1);

		return result;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> graph(int limit) {
		Collection<ErrorNodejs> result = repositoryerrorsNodejs.graph(limit);
		return toD3FormatErrorsNodejs(result);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getCallsMachine() {
		Collection<Machine> result = repositorymachine.getAllMachines();
		return toD3FormatCallMachinesUSESAgent(result);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getCallHardware() {
		Collection<Hardware> result = repositoryhardware
				.returnStructureAgentConnHardware();
		return toD3FormatAgentConnHardware(result);
	}

	private Map<String, Object> toD3FormatCallMachinesUSESAgent(
			Collection<Machine> result2) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();

		Iterator<Machine> result = result2.iterator();
		while (result.hasNext()) {
			Machine machine = result.next();
			nodes.add(map("machine", machine));

		}
		return map("nodes", nodes);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> machine(String errorType) {

		if (errorType.matches("Nodejs")) {
			Collection<ErrorNodejs> result = repositoryerrorsNodejs
					.returnErrorsNodejs();
			return toD3FormatErrorsNodejs(result);
		}
		if (errorType.matches("Websphere")) {
			Collection<ErrorWebsphere> resultados = repositoryerrorsWebsphere
					.getErrorWebsphere();
			return toD3FormatErrorsWebsphere(resultados);
		}
		return null;
	}
}