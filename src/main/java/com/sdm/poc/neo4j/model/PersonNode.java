package com.sdm.poc.neo4j.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Node
@Data
public class PersonNode {
    @Id
    private Long id;
    private String name;

    @Relationship(type = "TEAMMATE")
    public Set<PersonNode> teammates;

    public PersonNode(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void worksWith(PersonNode person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                        Collections.emptySet()).stream()
                .map(PersonNode::getName)
                .collect(Collectors.toList());
    }
}
