package com.me.project_management_api.dto;

import java.time.LocalDate;

import com.me.project_management_api.entity.enums.ProjectStateEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String urlProject;
    private ProjectStateEnum state;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
