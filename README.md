# Proyecto de ejemplo: Principios SOLID en Java (Spring Boot)

Descripción
----------
Este repositorio es una aplicación de ejemplo que demuestra los principios SOLID aplicados en una API REST construida con Java 17, Spring Boot y Maven. Cada paquete dentro de `src/main/java/cl/edu/dev/solid` contiene una pequeña muestra enfocada en uno de los principios SOLID.

Propósito
--------
- Servir como referencia didáctica para entender cómo estructurar código siguiendo SOLID.
- Proveer endpoints simples para ver ejemplos prácticos (servicios, controladores, modelos e inyección de dependencias).

Tecnologías
-----------
- Java 17
- Spring Boot
- Maven (incluye `mvnw`/`mvnw.cmd`)
- Lombok (para reducir boilerplate en modelos)
- H2 (mencionado como opción para demos; proyecto usa JPA en `User`)

Estructura relevante
--------------------
- `src/main/java/cl/edu/dev/solid/srp` - Ejemplo SRP (Single Responsibility Principle)
  - `controller/UserController.java` - Endpoints para usuarios
  - `service/UserService.java` - Lógica de negocio
  - `repository/UserRepository.java` - Persistencia
  - `model/User.java` - Entidad JPA

- `src/main/java/cl/edu/dev/solid/ocp` - Ejemplo OCP (Open/Closed Principle)
  - `model/Shape`, `Circle`, `Rectangle` - Interfaz y implementaciones
  - `service/ShapeService.java` - Cálculo de áreas (cerrado para modificación, abierto a nuevas formas)
  - `controller/ShapeController.java` - Endpoint para calcular áreas

- `src/main/java/cl/edu/dev/solid/lsp` - Ejemplo LSP (Liskov Substitution Principle)
  - `model/Bird`, `FlyingBird`, `Penguin` - `Penguin` lanza excepción al volar
  - `service/BirdService.java` - Maneja colección de aves
  - `controller/BirdController.java` - Endpoint para listar aves

- `src/main/java/cl/edu/dev/solid/isp` - Ejemplo ISP (Interface Segregation Principle)
  - `interfaces/Worker`, `Eater` y modelos `Human`, `Robot`
  - `controller/WorkerController.java` - Endpoints demostrativos

- `src/main/java/cl/edu/dev/solid/dip` - Ejemplo DIP (Dependency Inversion Principle)
  - `interfaces/MessageSender` y componentes `EmailSender`, `SMSSender`
  - `service/NotificationService.java` - Inyecta abstracciones
  - `controller/NotificationController.java` - Endpoints para enviar notificaciones

Endpoints (resumen)
-------------------
Nota: documentado tal como está en el código fuente.

- Usuarios (SRP)
  - GET  /users          -> Devuelve lista de usuarios (JSON)
  - POST /users          -> Crea un nuevo usuario (cuerpo JSON con { "name": "...", "email": "..." })

- Notificaciones (DIP)
  - POST /notifications/email?message=hola   -> Envía un email (retorna texto de confirmación)
  - POST /notifications/sms?message=hola     -> Envía un SMS (retorna texto de confirmación)

- Trabajadores (ISP)
  - GET /workers/human  -> Demostración: `human.work()` + `human.eat()`
  - GET /workers/robot  -> Demostración: `robot.work()` (no `eat`)

- Aves (LSP)
  - GET /birds          -> Devuelve la lista interna de aves (la gestión de altas/bajas está en el servicio)

- Formas / Áreas (OCP)
  - GET /shapes/areas   -> Calcula área total a partir de una lista de `Shape` en el cuerpo de la petición
    - Observación: el controlador usa `@GetMapping` con `@RequestBody`, lo habitual sería usar `POST` para peticiones con cuerpo. Está documentado tal cual en el código.

Ejemplos de uso (PowerShell / Windows)
-------------------------------------
Iniciar la aplicación (Windows, usa el wrapper):

```powershell
# Compilar y ejecutar con el wrapper (Windows)
./mvnw.cmd spring-boot:run
```

Ejemplos de llamadas a la API (PowerShell):

```powershell
# Obtener usuarios
curl http://localhost:8080/users

# Crear usuario (JSON)
curl -H "Content-Type: application/json" -X POST -d '{"name":"Juan","email":"juan@example.com"}' http://localhost:8080/users

# Enviar notificación por email
curl -X POST "http://localhost:8080/notifications/email?message=Hola%20mundo"

# Enviar SMS
curl -X POST "http://localhost:8080/notifications/sms?message=Hola%20mundo"

# Llamada a shapes/areas (ejemplo JSON; el endpoint espera un cuerpo con la lista de shapes)
# Nota: como las clases Shape/Circle/Rectangle en Java no se deserializarán automáticamente sin DTOs/serializadores, este endpoint sirve como demostración de OCP en código, y podría necesitar adaptaciones para recibir JSON reales.
```

Pruebas
-------
Para ejecutar tests (si existen) y comprobar el build:

```powershell
./mvnw.cmd test
```

Notas y advertencias
--------------------
- `User` está marcada con `@Entity` y usa Lombok (`@Data`), pero los campos no tienen anotaciones JPA como `@Id`; si deseas persistencia real debes añadir `@Id` y estrategia de generación.
- `ShapeController` usa `@GetMapping` con `@RequestBody`; lo correcto sería `@PostMapping` o cambiar a recibir parámetros por query.
- `BirdService` expone métodos para agregar y manipular aves, pero el `BirdController` actual solo ofrece `GET /birds`. Si deseas endpoints para añadir o eliminar aves, se puede ampliar el controlador.
- `Penguin#fly()` lanza `UnsupportedOperationException` a propósito para ilustrar violaciones potenciales de LSP; el servicio captura esa excepción cuando intenta hacer volar a todas las aves.

Cómo contribuir
---------------
- Añade endpoints faltantes para operaciones CRUD si deseas practicar (por ejemplo, agregar/eliminar aves, endpoints para `Shape` que acepten DTOs, o completar la entidad `User` con `@Id`).
- Mantén las responsabilidades separadas: controladores para entrada/salida, servicios para lógica, repositorios para persistencia.

Mapa rápido de requisitos cubiertos
----------------------------------
- README actualizado con descripción, estructura, endpoints, comandos de ejecución y ejemplos: Hecho
- Notas sobre inconsistencias y cómo mejorarlas: Incluidas

Contacto
--------
Proyecto de ejemplo — úsalo como guía. Para dudas o mejoras, abre issues o solicita cambios.


<!-- Fin del README -->
