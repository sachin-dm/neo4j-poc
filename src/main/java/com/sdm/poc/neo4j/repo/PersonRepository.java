package com.sdm.poc.neo4j.repo;

import com.sdm.poc.neo4j.model.PersonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.List;

public interface PersonRepository extends Neo4jRepository<PersonNode, Long> {
    PersonNode findByName(String name);
    List<PersonNode> findByTeammatesName(String name);
}
