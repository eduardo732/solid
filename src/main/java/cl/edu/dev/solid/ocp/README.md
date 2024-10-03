# Open/Closed Principle (OCP)

El principio abierto/cerrado establece que las clases deben estar abiertas para extensión, pero cerradas para modificación. En una API REST, esto se traduce en la capacidad de extender funcionalidades sin modificar el código existente, lo que permite añadir nuevas características de manera segura.

## Ejemplo

- `ShapeController.java`: Expone endpoints para operaciones con formas, permitiendo a los clientes interactuar con el sistema para calcular áreas de diferentes formas.
- `Shape.java`: Interfaz que define el contrato para las formas, asegurando que todas las implementaciones proporcionen un método para calcular el área.
- `Circle.java` y `Rectangle.java`: Implementaciones de `Shape` que permiten calcular el área de un círculo y un rectángulo, respectivamente. Nuevas formas pueden ser añadidas simplemente creando nuevas clases que implementen `Shape`.
- `ShapeService.java`: Calcula el área total de una lista de formas, utilizando el polimorfismo para manejar diferentes tipos de formas sin necesidad de modificar el servicio.

Este diseño permite añadir nuevas formas sin cambiar el código existente, cumpliendo así con el principio OCP.