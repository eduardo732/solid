package cl.edu.dev.solid.lsp.controller;

import cl.edu.dev.solid.lsp.model.Bird;
import cl.edu.dev.solid.lsp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping
    public List<Bird> getAllBirds() {
        return birdService.getAllBirds();
    }
}
