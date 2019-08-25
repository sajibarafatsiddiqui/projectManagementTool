package com.inferit.projectmanagementtool.services;

import com.inferit.projectmanagementtool.domain.Project;
import com.inferit.projectmanagementtool.exceptions.ProjectIdException;
import com.inferit.projectmanagementtool.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProjectService {

    @Autowired
    ProjectRepositories projectRepositories;

    public Project saveOrUpdate(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepositories.save(project);
        } catch(Exception e){
            throw new ProjectIdException("ProjectIdentifier '"+project.getProjectIdentifier().toUpperCase()+"' is aleady exist");
        }
    }

    public Map<String,String> errorMap(BindingResult result){
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return errorMap;
        }
        return null;
    }
    public Project findByProjectIdentifier(String projectIdentifier){

        return projectRepositories.findByProjectIdentifier(projectIdentifier);
    }

    public Iterable<Project> findAll(){
        return projectRepositories.findAll();
    }

    public void deleteByIdentifier(String projectIdentifier){
        projectIdentifier.toUpperCase();
        Project project=projectRepositories.findByProjectIdentifier(projectIdentifier);
        if(project==null){
            throw new ProjectIdException("Project with id '"+ projectIdentifier+"' doesn't exist");
        }
        projectRepositories.deleteById(projectIdentifier);


    }

}
