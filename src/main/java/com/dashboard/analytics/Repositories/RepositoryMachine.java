package com.dashboard.analytics.Repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.dashboard.analytics.Dao.Machine;

@RepositoryRestResource(collectionResourceRel = "machine", path = "machine")
public interface RepositoryMachine extends GraphRepository<Machine> {

	@Query("MATCH (m:Machine)-[d:USES]->(a:Agent) WHERE id(m)={idOfMachine} RETURN m")
	Machine getFromId(@Param("idOfMachine") int idOfMachine);

	// @Query("MATCH (a:Agent)-[d:CONN]->(h:Hardware) RETURN h, d,a ")
	// Collection<Machine> returnStructureRest();

	@Query("MATCH (m:Machine)-[d:USES]->(a:Agent) RETURN m, d,a  ")
	Collection<Machine> getAllMachines();

}
