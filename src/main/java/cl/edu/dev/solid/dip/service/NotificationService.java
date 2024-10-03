package cl.edu.dev.solid.dip.service;

import cl.edu.dev.solid.dip.model.EmailSender;
import cl.edu.dev.solid.dip.model.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private SMSSender smsSender;

    public String sendEmail(String message) {
        return emailSender.sendMessage(message);
    }

    public String sendSMS(String message) {
        return smsSender.sendMessage(message);
    }
}
