package cl.edu.dev.solid.lsp.model;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly.");
    }
}
