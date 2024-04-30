package csg;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Circle {
    private final JavaCSG csg;
    private final double diameter;
    private final double width;
    private final double height;

    public Circle(double diameter, double width, double height, JavaCSG csg) {
        this.csg = csg;
        this.diameter = diameter;
        this.width = width;
        this.height = height;
    }
    public Geometry3D getGeometry() {
        Geometry2D ring = getRing();
        return csg.linearExtrude(height, false, ring);
    }

    private Geometry2D getOuterCircle() {
        Geometry2D circle = csg.circle2D(diameter, 64);
        return circle;
    }
    private Geometry2D getInnerCircle() {
        Geometry2D circle = csg.circle2D(diameter-2*width, 64);
        return circle;
    }
    private Geometry2D getCircle() {
        Geometry2D outerCircle = getOuterCircle();
        Geometry2D  innerCircle = getInnerCircle();
        outerCircle = csg.difference2D(outerCircle, innerCircle);
        return outerCircle;
    }
    private Geometry2D getRing() {
        Geometry2D ring = csg.ring2D(diameter-2*width, diameter, 64);
        return ring;
    }

}
