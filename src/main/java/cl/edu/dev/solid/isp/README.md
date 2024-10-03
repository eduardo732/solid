# Interface Segregation Principle (ISP)

El principio de segregación de interfaces establece que los clientes no deberían estar obligados a depender de interfaces que no utilizan. En una API REST, esto significa definir interfaces específicas para cada funcionalidad, evitando la implementación de métodos innecesarios.

## Ejemplo

- `WorkerController.java`: Expone endpoints para operaciones con trabajadores, permitiendo a los clientes interactuar con diferentes tipos de trabajadores.
- `Worker.java` y `Eater.java`: Interfaces específicas que definen métodos para trabajar y comer, respectivamente.
- `Robot.java`: Implementa `Worker`, ya que un robot solo necesita trabajar.
- `Human.java`: Implementa tanto `Worker` como `Eater`, ya que un humano puede trabajar y comer.

Este diseño asegura que las clases solo implementen los métodos que realmente necesitan, cumpliendo con el principio ISP.