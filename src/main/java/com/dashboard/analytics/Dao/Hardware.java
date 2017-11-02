package com.dashboard.analytics.Dao;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity(label = "HARDWARE")
public class Hardware {
	@GraphId
	Long id;

	public String name;
	@Relationship(type = "CONN", direction = Relationship.INCOMING)
	public String mac_addr;

	public Hardware() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMacadress() {
		return mac_addr;
	}

}
