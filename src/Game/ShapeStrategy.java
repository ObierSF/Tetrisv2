package Game;

import java.util.List;

/**
 * Created by User on 01.03.2016.
 */
interface ShapeStrategy {
    Tile getTileShape(Board board);
}

class iShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new iShapeTile(board);
    }
}

class oShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new oShapeTile(board);
    }
}

class tShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new tShapeTile(board);
    }
}

class lShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new lShapeTile(board);
    }
}

class jShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new jShapeTile(board);
    }
}

class sShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new sShapeTile(board);
    }
}

class zShapeStrategy implements ShapeStrategy {
    @Override
    public Tile getTileShape(Board board) {
        return new zShapeTile(board);
    }
}