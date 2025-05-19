package com.me.project_management_api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.project_management_api.dto.ProjectRequestDTO;
import com.me.project_management_api.dto.ProjectResponseDTO;
import com.me.project_management_api.service.interfaces.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<ProjectResponseDTO> createProject(
            @RequestBody @Valid ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO projectCreated = projectService.createProject(projectRequestDTO);

        return ResponseEntity.created(URI.create("/api/admin/" + projectCreated.getId()))
                .body(projectCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id,
            @RequestBody @Valid ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO projectUpdated = projectService.updateProject(id, projectRequestDTO);

        return ResponseEntity.created(URI.create("/api/admin/" + projectUpdated.getId()))
                .body(projectUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);

        return ResponseEntity.noContent().build();
    }

}
