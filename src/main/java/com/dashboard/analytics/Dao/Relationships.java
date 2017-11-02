package com.dashboard.analytics.Dao;

import java.util.ArrayList;
import java.util.Collection;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "USES")
public class Relationships {

	@GraphId
	Long id;

	@StartNode
	Machine machine;
	@EndNode
	Agent agent;

	private Collection<String> relationships = new ArrayList<>();

	public Relationships() {

	}

	public Relationships(Agent agent, Machine machine) {
		this.agent = agent;
		this.machine = machine;

	}

	public Collection<String> getMachineRelationship() {
		return relationships;
	}

	public Long getId() {
		return id;
	}

	public Agent getAgent() {
		return agent;
	}

	public Machine getMachine() {
		return machine;
	}

	public void addRelationshipName(String name) {
		this.relationships.add(name);
	}

}
