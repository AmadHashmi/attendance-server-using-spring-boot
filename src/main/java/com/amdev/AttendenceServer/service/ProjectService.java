package com.amdev.AttendenceServer.service;

import com.amdev.AttendenceServer.dto.ProjectDTO;
import com.amdev.AttendenceServer.entities.Project;
import com.amdev.AttendenceServer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectDTO addProject(ProjectDTO dto){
        Project project = new Project();
        project.setName(dto.getName());
        project.setDuration(dto.getDuration());
        project.setStartDate(dto.getStartDate());

        return projectRepository.save(project).getDto();
    }



    public List<ProjectDTO> getAllProjects(){
        return projectRepository.findAll().stream().map(Project::getDto).collect(Collectors.toList());
    }
}
