# Liskov Substitution Principle (LSP)

El principio de sustitución de Liskov establece que los objetos de una clase derivada deben ser sustituibles por objetos de su clase base. En una API REST, esto asegura que las subclases puedan ser utilizadas en lugar de sus clases base sin problemas, manteniendo la integridad del sistema.

## Ejemplo

- `BirdController.java`: Expone endpoints para operaciones con aves, permitiendo a los clientes interactuar con diferentes tipos de aves.
- `Bird.java`: Clase base abstracta para todas las aves, definiendo un método abstracto `fly` que debe ser implementado por las subclases.
- `FlyingBird.java` y `Penguin.java`: Subclases de `Bird`. `FlyingBird` implementa el método `fly`, mientras que `Penguin` lanza una excepción, demostrando que no todas las aves pueden volar.
- `BirdService.java`: Maneja operaciones con aves, asegurando que las subclases pueden sustituir a la clase base. Incluye métodos para añadir, obtener y hacer volar a las aves, manejando adecuadamente las excepciones para las aves que no pueden volar.

Este diseño permite que las subclases sean intercambiables con la clase base, cumpliendo con el principio LSP.