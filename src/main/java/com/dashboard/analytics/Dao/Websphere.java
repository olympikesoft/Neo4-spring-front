package com.dashboard.analytics.Dao;

import java.util.Iterator;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Websphere")
public class Websphere {

	@GraphId
	private long id;
	@Relationship(type = "HAS_ERROR")
	private String MacAdress;
	private long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	private String getMacAdress() {
		return MacAdress;
	}
	private void setMacAdress(String macAdress) {
		MacAdress = macAdress;
	}
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private String name;
	
}
