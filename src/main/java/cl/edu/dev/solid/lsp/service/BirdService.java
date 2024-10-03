package cl.edu.dev.solid.lsp.service;

import cl.edu.dev.solid.lsp.model.Bird;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdService {

    private List<Bird> birds = new ArrayList<>();

    public List<Bird> getAllBirds() {
        return birds;
    }

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    public Bird getBirdByName(String name) {
        return birds.stream()
                .filter(bird -> bird.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void removeBirdByName(String name) {
        birds.removeIf(bird -> bird.getName().equalsIgnoreCase(name));
    }

    public void makeAllBirdsFly() {
        for (Bird bird : birds) {
            try {
                bird.fly();
            } catch (UnsupportedOperationException e) {
                System.out.println(bird.getName() + " cannot fly.");
            }
        }
    }
}
