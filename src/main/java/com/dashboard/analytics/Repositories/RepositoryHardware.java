package com.dashboard.analytics.Repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.dashboard.analytics.Dao.Hardware;

@RepositoryRestResource(collectionResourceRel = "hardwares", path = "hardwares")
public interface RepositoryHardware extends GraphRepository<Hardware> {

	@Query("MATCH (a:Agent)-[d:CONN]->(h:HARDWARE) RETURN h")
	Collection<Hardware> returnStructureAgentConnHardware();
}
