package com.me.project_management_api.service.interfaces;

import java.util.List;

import com.me.project_management_api.dto.ProjectRequestDTO;
import com.me.project_management_api.dto.ProjectResponseDTO;

public interface ProjectService {

    List<ProjectResponseDTO> findAllProjects();

    ProjectResponseDTO findProjectById(Long id);

    ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO);

    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO projectRequestDTO);

    void deleteProject(Long id);

}
