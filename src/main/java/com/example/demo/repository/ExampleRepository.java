package com.example.demo.repository;

import com.example.demo.model.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ExampleRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Integer save() {

        Example example = new Example();
        example.setName("Example 323232");

        entityManager.persist(example);

        return example.getId();
    }

    public List<Example> getAll() {

        Query query = entityManager.createNativeQuery("SELECT * FROM Example", Example.class);

        return (List<Example>) query.getResultList();
    }

    public Example getById(Integer id) {

        Query query = entityManager.createNativeQuery("SELECT * FROM Example WHERE id = ?1", Example.class);
        query.setParameter(1, id);

        return (Example) query.getSingleResult();
    }
}