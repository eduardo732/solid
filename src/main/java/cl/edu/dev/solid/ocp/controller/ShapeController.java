package cl.edu.dev.solid.ocp.controller;

import cl.edu.dev.solid.ocp.model.Shape;
import cl.edu.dev.solid.ocp.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

    @Autowired
    private ShapeService shapeService;

    @GetMapping("/areas")
    public double calculateTotalArea(@RequestBody List<Shape> shapes) {
        return shapeService.calculateTotalArea(shapes);
    }
}
