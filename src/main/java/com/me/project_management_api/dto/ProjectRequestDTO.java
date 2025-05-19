package com.me.project_management_api.dto;

import com.me.project_management_api.entity.enums.ProjectStateEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 255, message = "El nombre no debe superar los 255 caracteres.")
    private String name;

    @NotBlank(message = "La descripción es obligatoria.")
    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres.")
    private String description;

    @NotBlank(message = "La URL del proyecto es obligatoria.")
    @Pattern(regexp = "^(https?:\\/\\/)?(www\\.)?github\\.com\\/[A-Za-z0-9_.-]+\\/[A-Za-z0-9_.-]+$", message = "La URL debe ser un enlace válido de un repositorio en GitHub.")
    private String urlProject;

    @NotNull(message = "El estado del proyecto es obligatorio.")
    private ProjectStateEnum state;
}
