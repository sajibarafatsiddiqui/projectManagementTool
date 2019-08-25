package com.inferit.projectmanagementtool.repositories;

import com.inferit.projectmanagementtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepositories extends CrudRepository<Project,Long> {
    @Override
    Iterable<Project> findAll();


    default void deleteById(String id) {

    }

    Project findByProjectIdentifier(String id);


}
