package com.dashboard.analytics.Dao;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity(label = "Agent")
public class Agent {

	@GraphId
	Long id;

	@Relationship(type = "USES", direction = Relationship.INCOMING)
	private Set<Machine> machines = new HashSet<>();
	@Relationship(type = "CONN")
	public Set<Machine> getAgents() {
		return machines;
	}
	private Long getId() {
		return id;
	}

}
