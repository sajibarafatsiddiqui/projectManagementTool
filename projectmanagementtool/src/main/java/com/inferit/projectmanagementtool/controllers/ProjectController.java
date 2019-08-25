package com.inferit.projectmanagementtool.controllers;

import com.inferit.projectmanagementtool.domain.Project;
import com.inferit.projectmanagementtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project/")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @PostMapping("")
    public ResponseEntity<?> post(@Valid @RequestBody Project project, BindingResult result){
        Map<String,String> errorMap=projectService.errorMap(result);
         if(errorMap!=null){
             return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
         }

        Project project1= projectService.saveOrUpdate(project);
        System.out.println(project1.toString());
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier){
        Project project=projectService.findByProjectIdentifier(projectIdentifier);
        if(project!=null) {
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("Project Does Not Exist",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")

    public ResponseEntity<?> findAll(){

        Iterable<Project> projects= projectService.findAll();
        if (projects !=null){
            return new ResponseEntity<Iterable<Project>>(projects,HttpStatus.OK);
        }
        else{
           return new ResponseEntity<String>("Project List is empty",HttpStatus.OK);
        }
    }

    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<String> deleteByProjectIdentifier(@PathVariable String projectIdentifier){
        projectService.deleteByIdentifier(projectIdentifier);
        return new ResponseEntity<String>("Project with Identifier '"+projectIdentifier+"' has been deleted",HttpStatus.OK);
    }


}
