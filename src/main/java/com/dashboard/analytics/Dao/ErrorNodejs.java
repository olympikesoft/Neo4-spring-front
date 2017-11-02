package com.dashboard.analytics.Dao;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "ERROR_NODEJS")
public class ErrorNodejs {

	@GraphId
	Long id;

	@Relationship(type = "HAS_ERROR", direction = Relationship.INCOMING)
	private String level;

	private String message;

	private String datetime;

	public ErrorNodejs() {

	}

	// private Database db = new Database();

	public String getLevel() {
		return level;
	}

	public String getMessage() {
		return message;
	}

	public Long getId() {
		return id;
	}

	public String getTimestamp() {
		return datetime;
	}

}