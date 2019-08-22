package com.inferit.projectmanagementtool.services;

import com.inferit.projectmanagementtool.domain.Project;
import com.inferit.projectmanagementtool.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepositories projectRepositories;

    public Project saveOrUpdate(Project project){
        return projectRepositories.save(project);
    }
}
