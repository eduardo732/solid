package cl.edu.dev.solid.lsp.model;

public class FlyingBird extends Bird {

    public FlyingBird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }
}
