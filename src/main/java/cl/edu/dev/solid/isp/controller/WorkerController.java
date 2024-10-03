package cl.edu.dev.solid.isp.controller;

import cl.edu.dev.solid.isp.model.Human;
import cl.edu.dev.solid.isp.model.Robot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @GetMapping("/human")
    public String humanWork() {
        Human human = new Human();
        return human.work() + " and " + human.eat();
    }

    @GetMapping("/robot")
    public String robotWork() {
        Robot robot = new Robot();
        return robot.work();
    }
}
