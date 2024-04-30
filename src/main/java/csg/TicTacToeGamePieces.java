package csg;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class TicTacToeGamePieces {
    private final double boardSize;
    private final double boardHeight;
    private final double brickSize;
    private final double holeDepth;
    private final double brickHeight;
    private final double brickWidth;
    private final JavaCSG csg;
    private Cross cross;
    private Circle circle;
    private Board board;




    public TicTacToeGamePieces(double boardSize, double boardHeight, double brickSize, double holeDepth, double brickHeight, double brickWidth, JavaCSG csg) {
        this.boardSize = boardSize;
        this.boardHeight = boardHeight;
        this.brickSize = brickSize;
        this.holeDepth = holeDepth;
        this.brickHeight = brickHeight;
        this.brickWidth = brickWidth;
        this.csg = csg;
        cross = new Cross(brickSize,brickWidth,brickHeight,csg);
        circle = new Circle(brickSize,brickWidth,brickHeight, csg);
        board = new Board(boardSize,boardHeight, brickSize, holeDepth, csg);
    }

    public Geometry3D getGeometry() {
        Geometry3D cross3D = csg.translate3D(boardSize+brickSize/2+10, brickSize/2, 0).transform(cross.getGeometry());
        Geometry3D circle3D = csg.translate3D(boardSize+2*brickSize +10, brickSize/2, 0).transform(circle.getGeometry());
        Geometry3D union = csg.union3D(board.getGeometry(),cross3D,circle3D);
        return union;
    }
}
