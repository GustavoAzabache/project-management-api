package com.me.project_management_api.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.project_management_api.config.ProjectMapper;
import com.me.project_management_api.dto.ProjectRequestDTO;
import com.me.project_management_api.dto.ProjectResponseDTO;
import com.me.project_management_api.entity.ProjectEntity;
import com.me.project_management_api.exception.ProjectNotFoundException;
import com.me.project_management_api.exception.UrlProjectAlreadyUsedException;
import com.me.project_management_api.repository.ProjectRepository;
import com.me.project_management_api.service.interfaces.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectResponseDTO> findAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::entityToResponseDto)
                .toList();
    }

    @Override
    public ProjectResponseDTO findProjectById(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id)
                .orElseThrow(
                        () -> new ProjectNotFoundException("El proyecto con el ID: " + id + " no ha sido encontrado."));

        return projectMapper.entityToResponseDto(projectEntity);
    }

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {
        if (projectRepository.existsByUrlProject(projectRequestDTO.getUrlProject())) {
            throw new UrlProjectAlreadyUsedException("La URL que has ingresado ya está en uso.");
        }

        ProjectEntity projectEntity = projectMapper.requestDtoToEntity(projectRequestDTO);
        ProjectEntity projectSaved = projectRepository.save(projectEntity);

        return projectMapper.entityToResponseDto(projectSaved);
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO projectRequestDTO) {
        ProjectEntity projectEntity = projectRepository.findById(id)
                .orElseThrow(
                        () -> new ProjectNotFoundException("El proyecto con el ID: " + id + " no ha sido encontrado."));

        // Existe un proyecto con esta URL?? y La URL que estoy enviando es diferente al
        // proyecto encontrado
        if (projectRepository.existsByUrlProject(projectRequestDTO.getUrlProject())
                && !projectEntity.getUrlProject().equals(projectRequestDTO.getUrlProject())) {
            throw new UrlProjectAlreadyUsedException("La URL que has ingresado ya está en uso.");
        }

        projectMapper.updateEntityFromDTO(projectRequestDTO, projectEntity);
        ProjectEntity projectUpdated = projectRepository.save(projectEntity);

        return projectMapper.entityToResponseDto(projectUpdated);
    }

    @Override
    public void deleteProject(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id)
                .orElseThrow(
                        () -> new ProjectNotFoundException("El proyecto con el ID: " + id + " no ha sido encontrado."));

        projectRepository.delete(projectEntity);
    }

}
