package com.dashboard.analytics.Repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.dashboard.analytics.Dao.Websphere;

@RepositoryRestResource(collectionResourceRel = "websphere", path = "websphere")
public interface RepositoryWebsphere extends GraphRepository<Websphere> {

	/*
	 * @Query("Match (w:Websphere) return n") Websphere findWebsphereById()
	 */

}
