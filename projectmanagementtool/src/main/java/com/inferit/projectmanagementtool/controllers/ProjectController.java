package com.inferit.projectmanagementtool.controllers;

import com.inferit.projectmanagementtool.domain.Project;
import com.inferit.projectmanagementtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/project/")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @PostMapping("")
    public ResponseEntity<?> post(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<String>("Invalid project object",HttpStatus.BAD_REQUEST);
        }
        Project project1= projectService.saveOrUpdate(project);
        System.out.println(project1.toString());
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
}
