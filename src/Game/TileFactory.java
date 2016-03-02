package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 29.02.2016.
 */
public class TileFactory {
    Random rand;
    List<ShapeStrategy> shapes;
    Board board;

    TileFactory(Board board) {
        this.board = board;
        rand = new Random();
        shapes = new ArrayList<>(7);
        shapes.add(new iShapeStrategy());
        shapes.add(new oShapeStrategy());
        shapes.add(new tShapeStrategy());
        shapes.add(new lShapeStrategy());
        shapes.add(new jShapeStrategy());
        shapes.add(new sShapeStrategy());
        shapes.add(new zShapeStrategy());
    }

    Tile getRandomTile() {
        int n = rand.nextInt(7);
        ShapeStrategy shape = shapes.get(n);
        Tile tile = shape.getTileShape(board);
        tile.setFields();
        return tile;
    }
}