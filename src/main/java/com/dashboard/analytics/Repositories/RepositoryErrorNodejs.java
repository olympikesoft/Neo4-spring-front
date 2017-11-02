package com.dashboard.analytics.Repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.dashboard.analytics.Dao.*;

import org.springframework.data.repository.query.Param;

@RepositoryRestResource(collectionResourceRel = "errorsnodejs", path = "errorsnodejs")
public interface RepositoryErrorNodejs extends GraphRepository<ErrorNodejs> {

	@Query("MATCH (n:NODEJS)-[d:HAS_ERROR]->(e:ERROR_NODEJS) WHERE id(e)={idOfErrorNodejs} RETURN e")
	ErrorNodejs getErrorNodejsFromId(
			@Param("idOfErrorNodejs") int idOfErrorNodejs);

	Collection<ErrorNodejs> findByMessageLike(@Param("message") String message);

	// Execute Query with parameters
	@Query("MATCH (n:NODEJS)-[d:HAS_ERROR]->(e:ERROR_NODEJS) RETURN n,d,e LIMIT {limit}")
	// Use graph method from Service
	Collection<ErrorNodejs> graph(@Param("limit") int limit);

	@Query("MATCH (n:NODEJS)-[d:HAS_ERROR]->(e:ERROR_NODEJS) RETURN n,d,e")
	Collection<ErrorNodejs> returnErrorsNodejs();

	@Query("Match (e:ERROR_NODEJS) RETURN e Order by id(e) desc Limit 1")
	Collection<ErrorNodejs> LastError();

}