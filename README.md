# Project Management API

API RESTful para la gestión de proyectos, construida con **Spring Boot 3.4,5**, enfocada en una arquitectura limpia por capas, uso de DTOs, mapeo con MapStruct y manejo centralizado de excepciones. No incluye frontend, está pensada como servicio backend puro.

---

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Web
- Spring Validation
- Spring Data JPA
- Lombok
- Spring Security 6
- MapStruct
- MySQL

---

## 📁 Estructura del proyecto

```bash
src
└── main
    └── java
        └── com.me.project_management_api
            ├── config           # Configuraciones generales
            ├── controller       # Controladores REST
            ├── dto              # DTO de petición y respuesta
            ├── entity           # Entidades JPA
            ├── exception        # Excepciones personalizadas
            ├── repository       # Repositorios JPA
            ├── service          # Interfaces y clases de lógica de negocio            
            └── ProjectManagementApiApplication.java
```

---

🔧 Funcionalidades

  - CRUD de proyectos.

  - Validación de datos con @Valid y mensajes claros.
  
  - Manejo global de errores con @ControllerAdvice y @ExceptionHandler.

  - Mapeo automático entre entidades y DTOs usando MapStruct.

  - Arquitectura desacoplada: controller ↔ service ↔ repository.

---

🧪 Ejemplo de respuesta de error

Cuando buscas un trabajo que no existe:

```JSON
{
  "status": 404,
  "error": "No encontrado",
  "message": "El proyecto con el ID: 1 no ha sido encontrado.",
  "timestamp": "2025-05-19T00:53:24.436859502"
}
```

---

🛠️ Requisitos

  - Java 21

  - MySQL

---

▶️ Cómo ejecutar el proyecto

git clone https://github.com/tuusuario/project-management-api.git
cd project-management-api
./mvn spring-boot:run

Para usar MySQL, asegúrate de configurar tu application.properties.

---
## URL del servidor http://www.localhost:8080/api/projects

🔄 Endpoints principales sin autenticación
- GET	Listar todos los proyectos
- GET	/{id}	Obtener un proyecto por ID

🔄 Endpoints principales con autenticación
- POST	Crear nuevo proyecto
- PUT	/{id}	Actualizar un proyecto
- DELETE	/{id}	Eliminar un proyecto
---
