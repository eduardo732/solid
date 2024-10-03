package cl.edu.dev.solid.lsp.model;

import lombok.Data;

@Data
public abstract class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

  public abstract void fly();
}
