package Game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 01.03.2016.
 */
public class ShapeStrategyTest {
    List<ShapeStrategy> shapes;
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(160);
        shapes = new ArrayList<>(7);
        shapes.add(new iShapeStrategy());
        shapes.add(new oShapeStrategy());
        shapes.add(new tShapeStrategy());
        shapes.add(new lShapeStrategy());
        shapes.add(new jShapeStrategy());
        shapes.add(new sShapeStrategy());
        shapes.add(new zShapeStrategy());
    }

    @Test
    public void setIShape() throws Exception{
        ShapeStrategy shape = shapes.get(0);
        shape.getTileShape(board);
    }

    @Test
    public void setOShape() throws Exception{
        ShapeStrategy shape = shapes.get(1);
        shape.getTileShape(board);
    }

    @Test
    public void setTShape() throws Exception{
        ShapeStrategy shape = shapes.get(2);
        shape.getTileShape(board);
    }

    @Test
    public void setLShape() throws Exception{
        ShapeStrategy shape = shapes.get(3);
        shape.getTileShape(board);
    }

    @Test
    public void setJShape() throws Exception{
        ShapeStrategy shape = shapes.get(4);
        shape.getTileShape(board);
    }

    @Test
    public void setSShape() throws Exception{
        ShapeStrategy shape = shapes.get(5);
        shape.getTileShape(board);
    }

    @Test
    public void setZShape() throws Exception{
        ShapeStrategy shape = shapes.get(6);
        shape.getTileShape(board);
    }
}