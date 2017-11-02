package com.dashboard.analytics.Repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.dashboard.analytics.Dao.Agent;
import com.dashboard.analytics.Dao.ErrorWebsphere;

@RepositoryRestResource(collectionResourceRel = "agent", path = "agent")
public interface RepositoryAgent extends GraphRepository<Agent> {

	@Query("Match(a:Agent)  WHERE id(a)={idOfAgent} RETURN a")
	ErrorWebsphere getErrorWebsphereFromId(
			@Param("idOfErrorWebsphere") int idOfAgent);
}
