# SOLID Principles API
## Descripción
Este proyecto tiene como objetivo demostrar la aplicación de los principios SOLID en el desarrollo de una API REST utilizando Java 17, Spring Boot y Maven. Los principios SOLID son fundamentales para crear código limpio, mantenible y escalable.

## Principios SOLID
- Single Responsibility Principle (SRP): Una clase debe tener una sola razón para cambiar.
- Open/Closed Principle (OCP): Las clases deben estar abiertas para extensión, pero cerradas para modificación.
- Liskov Substitution Principle (LSP): Los objetos de una clase derivada deben ser sustituibles por objetos de su clase base.
- Interface Segregation Principle (ISP): Los clientes no deberían estar obligados a depender de interfaces que no utilizan.
- Dependency Inversion Principle (DIP): Las clases deben depender de abstracciones, no de concreciones.

## Tecnologías Utilizadas
- Java 17
- Spring Boot
- Maven
- H2 Database (Base de datos en memoria para fines de demostración)

## Endpoints
Persona
GET /user: Obtiene todos las personas.
GET /user/{id}: Obtiene una persona por ID.
POST /user: Registra una persona.

## Principios SOLID en la API
### Single Responsibility Principle (SRP)
Cada clase en el proyecto tiene una única responsabilidad. Por ejemplo, las clases en el paquete model son responsables de representar los datos, mientras que las clases en repository manejan la persistencia.

### Open/Closed Principle (OCP)
Las clases y métodos están diseñados para ser extensibles sin necesidad de modificar el código existente. Por ejemplo, puedes añadir nuevas validaciones en los servicios sin cambiar la lógica actual.

### Liskov Substitution Principle (LSP)
Las clases que implementan interfaces pueden ser intercambiadas sin romper la funcionalidad del código. Por ejemplo, puedes sustituir una implementación de Notificador por otra sin afectar el comportamiento.

### Interface Segregation Principle (ISP)
Las interfaces están diseñadas para tener métodos específicos, evitando que las clases implementen métodos que no necesitan. Por ejemplo, Trabajador y Comedor son interfaces separadas.

### Dependency Inversion Principle (DIP)
Las clases dependen de abstracciones en lugar de implementaciones concretas. Esto se logra mediante el uso de interfaces y la inyección de dependencias en Spring Boot.
