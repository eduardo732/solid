package cl.edu.dev.solid.isp.model;

import cl.edu.dev.solid.isp.interfaces.Eater;
import cl.edu.dev.solid.isp.interfaces.Worker;

public class Human implements Worker, Eater {

    @Override
    public String work() {
        return "Human is working";
    }

    @Override
    public String eat() {
        return "Human is eating";
    }
}
