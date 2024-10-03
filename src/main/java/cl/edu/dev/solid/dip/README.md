# Dependency Inversion Principle (DIP)

El principio de inversión de dependencias establece que las clases deben depender de abstracciones, no de concreciones. En una API REST, esto se traduce en la inyección de dependencias para servicios, permitiendo un diseño más flexible y desacoplado.

## Ejemplo

- `NotificationController.java`: Expone endpoints para enviar notificaciones, permitiendo a los clientes enviar mensajes a través de diferentes medios.
- `MessageSender.java`: Interfaz que define el contrato para enviar mensajes, asegurando que todas las implementaciones proporcionen un método para enviar un mensaje.
- `EmailSender.java` y `SMSSender.java`: Implementaciones de `MessageSender` que permiten enviar mensajes por correo electrónico y SMS, respectivamente.
- `NotificationService.java`: Utiliza `MessageSender` para enviar notificaciones, permitiendo cambiar la implementación sin modificar el servicio.

Este diseño permite cambiar las implementaciones de envío de mensajes sin afectar al resto del sistema, cumpliendo con el principio DIP.