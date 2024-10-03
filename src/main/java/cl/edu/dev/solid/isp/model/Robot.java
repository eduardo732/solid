package cl.edu.dev.solid.isp.model;

import cl.edu.dev.solid.isp.interfaces.Worker;

public class Robot implements Worker {

    @Override
    public String work() {
        return "Robot is working";
    }
}
