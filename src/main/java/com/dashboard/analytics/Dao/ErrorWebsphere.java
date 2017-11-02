package com.dashboard.analytics.Dao;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "ERROR_WEBSPHERE")
public class ErrorWebsphere {

	@GraphId
	Long id;

	@Relationship(type = "HAS_ERROR", direction = Relationship.INCOMING)
	private String datetime;
	private String where;
	private String message;

	public ErrorWebsphere() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ErrorWebsphere(Long id, String datetime, String where, String message) {
		super();

		this.datetime = datetime;
		this.where = where;
		this.message = message;
	}

	public String getTime_occurred() {
		return datetime;
	}

	public void setTime_occurred(String datetime) {
		this.datetime = datetime;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}