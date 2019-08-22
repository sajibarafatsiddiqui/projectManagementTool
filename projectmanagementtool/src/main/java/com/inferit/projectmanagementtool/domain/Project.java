package com.inferit.projectmanagementtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Project {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message="Project Name Should not be blank")
    private String projectName;
    @NotBlank(message="Project Identifier Should not be blank")
    @Size(min=4,max=10,message="Project Identifier should be between 4 to20 charecters")
    @Column(updatable=false,unique=true)
    private String projectIdentifier;
    @NotBlank(message="Project Description Should not be blank")
    private String projectDescription;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date start_at;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date created_at;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date updated_at;

    @PrePersist
    protected void onCreate(){
        this.created_at=new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }
    }

