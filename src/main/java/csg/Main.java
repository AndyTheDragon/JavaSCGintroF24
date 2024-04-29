package csg;

import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createNoCaching();
        List<Vector2D> vertices = new ArrayList<Vector2D>();
        vertices.add(csg.vector2D(0,0));
        vertices.add(csg.vector2D(2,0));
        vertices.add(csg.vector2D(2,3));
        vertices.add(csg.vector2D(1,2));
        vertices.add(csg.vector2D(0,3));
        Geometry2D thing = csg.polygon2D(vertices);
        thing = csg.scale2D(10,10).transform(thing);
        thing = csg.translate2DX(10).transform(thing);
        Geometry3D thing3d = csg.linearExtrude(5,false,thing);
        Geometry3D thingRotated = csg.rotateExtrude(csg.rotations(0.25), 16 ,thing);

        Cross cross = new Cross(30,5,3);
        Geometry3D res = cross.getGeometry(csg);

        csg.view(res);
    }
}
