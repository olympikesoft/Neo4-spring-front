package com.dashboard.analytics.Dao;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity(label = "Machine")
public class Machine {
	@GraphId
	Long id;

	@Relationship(type = "USES")
	private String mac_addr;

	private Set<Agent> USES = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMacAdress() {
		return mac_addr;
	}

	public void setMacAdress(String macAdress) {
		mac_addr = macAdress;
	}

	public void USES(Agent agent) {
		USES.add(agent);
		agent.getAgents().add(this);
	}

}
