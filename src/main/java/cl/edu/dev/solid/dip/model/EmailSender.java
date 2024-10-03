package cl.edu.dev.solid.dip.model;

import cl.edu.dev.solid.dip.interfaces.MessageSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {

    @Override
    public String sendMessage(String message) {
        return "Email sent: " + message;
    }
}
