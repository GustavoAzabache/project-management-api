package com.me.project_management_api.config;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.me.project_management_api.dto.ProjectRequestDTO;
import com.me.project_management_api.dto.ProjectResponseDTO;
import com.me.project_management_api.entity.ProjectEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    ProjectEntity requestDtoToEntity(ProjectRequestDTO projectRequestDTO);

    ProjectResponseDTO entityToResponseDto(ProjectEntity projectEntity);

    void updateEntityFromDTO(ProjectRequestDTO projectRequestDTO, @MappingTarget ProjectEntity projectEntity);

}
