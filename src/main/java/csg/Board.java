package csg;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final double boardSize;
    private final double boardHeight;
    private final double brickSize;
    private final double holeDepth;
    private final JavaCSG csg;

    public Board(double boardSize, double boardHeight, double brickSize, double holeDepth, JavaCSG csg) {
        this.boardSize = boardSize;
        this.boardHeight = boardHeight;
        this.brickSize = Math.min(brickSize,(boardSize-4)/3)+0.6;
        this.holeDepth = holeDepth;
        this.csg = csg;
    }

    private double gap() {
        return (boardSize-3*brickSize)/4;
    }

    private Geometry2D getBoard() {
        Geometry2D board = csg.rectangle2D(boardSize,boardSize);
        board = csg.translate2D(boardSize/2,boardSize/2).transform(board);
        return board;
    }

    private Geometry2D getRoundedBoard() {
        double diameter = Math.sqrt(2)*boardSize;
        Geometry2D outerRing = csg.ring2D(diameter-3,diameter+10, 128);
        outerRing = csg.translate2D(boardSize/2,boardSize/2).transform(outerRing);
        Geometry2D board = csg.difference2D(getBoard(), outerRing);
        return board;
    }

    private Geometry2D getBrick() {
        Geometry2D brick = csg.rectangle2D(brickSize,brickSize);
        brick = csg.translate2D(brickSize/2,brickSize/2).transform(brick);
        return brick;
    }

    private Geometry2D getHoles() {
        List<Geometry2D> holes = new ArrayList<>();
        Geometry2D brick = getBrick();
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++) {
                Geometry2D movedBrick = csg.translate2D(gap()+x*(brickSize+gap()),gap()+y*(brickSize+gap())).transform(brick);
                holes.add( movedBrick );
            }
        }
        return csg.union2D(holes);
    }



    public Geometry3D getGeometry() {
        Geometry3D board = csg.linearExtrude(boardHeight, false, getRoundedBoard());
        Geometry3D bricks = csg.linearExtrude(holeDepth, false, getHoles());
        bricks = csg.translate3DZ(boardHeight- holeDepth).transform(bricks);
        return csg.difference3D(board,bricks);
        //return bricks;
    }



}
