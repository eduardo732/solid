package cl.edu.dev.solid.ocp.service;

import cl.edu.dev.solid.ocp.model.Shape;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {

    public double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::calculateArea).sum();
    }
}
