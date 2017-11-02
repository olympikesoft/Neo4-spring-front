package com.dashboard.analytics.Dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity(label = "Nodejs")
public class Nodejs {

	@GraphId
	Long id;

	@Relationship(type = "HAS_ERROR")
	// direction = Relationship.INCOMING)
	public Long getId() {
		return id;
	}

	private List<ErrorNodejs> errorsNodejs = new ArrayList<>();

	public List<ErrorNodejs> getMovies() {
		return errorsNodejs;
	}

}
