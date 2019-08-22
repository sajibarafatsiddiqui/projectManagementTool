package com.inferit.projectmanagementtool.repositories;

import com.inferit.projectmanagementtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositories extends CrudRepository<Project,Long> {
    @Override
    Iterable<Project> findAllById(Iterable<Long> id);
}
