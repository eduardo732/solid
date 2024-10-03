package cl.edu.dev.solid.dip.controller;

import cl.edu.dev.solid.dip.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/email")
    public String sendEmail(@RequestParam String message) {
        return notificationService.sendEmail(message);
    }

    @PostMapping("/sms")
    public String sendSMS(@RequestParam String message) {
        return notificationService.sendSMS(message);
    }
}
