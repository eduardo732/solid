# Single Responsibility Principle (SRP)

El principio de responsabilidad única establece que una clase debe tener una sola razón para cambiar. En el contexto de una API REST, esto significa que cada componente debe tener una única responsabilidad, lo que facilita el mantenimiento y la escalabilidad del sistema.

## Ejemplo

- `UserController.java`: Este controlador maneja las solicitudes HTTP relacionadas con los usuarios, como obtener todos los usuarios o crear un nuevo usuario. Se encarga exclusivamente de la interacción con el cliente.
- `User.java`: Esta clase representa el modelo de datos de un usuario, definiendo sus atributos y métodos de acceso.
- `UserRepository.java`: Interactúa con la base de datos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los usuarios. Se centra únicamente en la persistencia de datos.
- `UserService.java`: Contiene la lógica de negocio para la gestión de usuarios, como validaciones y transformaciones de datos antes de interactuar con el repositorio.

Esta separación de responsabilidades asegura que cada clase tenga un propósito claro y específico, lo que facilita su comprensión y modificación.
