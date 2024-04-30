package csg;

import org.abstractica.javacsg.*;

import java.io.IOException;
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

        double boardSize = 150;
        double boardHeight = 17;
        double brickSize = 42;
        double holeDepth = 12;
        double brickHeight = 17;
        double brickWidth = 7;
        TicTacToeGamePieces game = new TicTacToeGamePieces(boardSize,boardHeight,brickSize,holeDepth,brickHeight,brickWidth,csg);
        csg.view(game.getGeometry());


    }
}
