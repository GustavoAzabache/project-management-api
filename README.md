# Project Management API

API RESTful para la gestión de proyectos, construida con Spring Boot, enfocada en una arquitectura limpia por capas, uso de DTOs, mapeo con MapStruct y manejo centralizado de excepciones. No incluye frontend, está pensada como servicio backend puro.

---

## 🧩 Características

- Autenticación con Basic Auth
- Validación de datos con Jakarta Validation
- Manejo global de errores (`@ControllerAdvice`)
- Seguridad con Spring Security
- CRUD para Usuarios y Publicaciones
- Asociación de publicaciones a un usuario

---

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Security 6
- JPA / Hibernate
- Lombok
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


## ⚙️ Instalación

```bash
git clone https://github.com/GustavoAzabache/project-management-api.git
cd project-management-api
./mvn spring-boot:run
```

---

## 🔗 Endpoints

### 📃 Proyectos (Projects)
| Método | Ruta                  | Descripción                   | Autenticación  |
|--------|-----------------------|-------------------------------|----------------|
| GET    | `/api/projects`       | Listar todos los projects     | ❌ No          |
| GET    | `/api/projects/{id}`  | Obtener project por ID        | ❌ No          |
| POST   | `/api/admin`          | Crear nuevo project           | ✅ Sí          |
| PUT    | `/api/admin/{id}`     | Actualizar project            | ✅ Sí          |
| DELETE | `/api/admin/{id}`     | Eliminar project              | ✅ Sí          |

---

## 🔐 Credenciales de prueba

| Usuario  | Contraseña  |
|----------|-------------|
|  `admin` | `admin` |

---

## ⚠️ Manejo de errores

- `404 NOT FOUND`: Project no existe
- `409 CONFLICT`: URL de project ya en uso
- `400 BAD REQUEST`: Datos inválidos en la solicitud

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
