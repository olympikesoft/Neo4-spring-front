package com.dashboard.analytics.Repositories;

import java.util.Collection;

import com.dashboard.analytics.Dao.*;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(collectionResourceRel = "errorswebsphere", path = "errorswebsphere")
public interface RepositoryErrorWebsphere extends
GraphRepository<ErrorWebsphere> {

	@Query("Match(w:WEBSPHERE)-[d:HAS_ERROR]->(e:ERROR_WEBSPHERE) WHERE id(e)={idOfErrorWebsphere} RETURN e")
	ErrorWebsphere getErrorWebsphereFromId(
			@Param("idOfErrorWebsphere") int idOfWebsphere);

	ErrorWebsphere findById(@Param("id") int id);

	@Query("Match(w:WEBSPHERE)-[d:HAS_ERROR]->(e:ERROR_WEBSPHERE) Return w,d,e")
	Collection<ErrorWebsphere> getErrorWebsphere();

	@Query("Match (e:ERROR_WEBSPHERE) RETURN e Order by id(e) desc Limit 1")
	Collection<ErrorWebsphere> LastError();

}
