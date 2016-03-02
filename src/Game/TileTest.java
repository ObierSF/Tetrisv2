package Game;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 29.02.2016.
 */
public class TileTest {
    Board board;
    Tile t;

    void setTile() {
        t = new iShapeTile(board);
        t.setFields();
    }

    @Before
    public void setUp() throws Exception {
        board = new Board(160);
    }

    @Test
    public void rotateIShapeRight() throws Exception {
        t = new iShapeTile(board);
        t.setFields();
        t.rotateRight();
        assertEquals(15, t.fields[0]);
        assertEquals(14, t.fields[1]);
        assertEquals(13, t.fields[2]);
        assertEquals(12, t.fields[3]);
        t.fall();
        t.rotateRight();
        assertEquals(34, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(14, t.fields[2]);
        assertEquals(4, t.fields[3]);
        t.rotateRight();
        assertEquals(23, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(25, t.fields[2]);
        assertEquals(26, t.fields[3]);
        t.rotateRight();
        assertEquals(14, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(34, t.fields[2]);
        assertEquals(44, t.fields[3]);
    }

    @Test
    public void rotateIShapeLeft() throws Exception {
        t = new iShapeTile(board);
        t.setFields();
        t.rotateLeft();
        assertEquals(13, t.fields[0]);
        assertEquals(14, t.fields[1]);
        assertEquals(15, t.fields[2]);
        assertEquals(16, t.fields[3]);
        t.fall();
        t.rotateLeft();
        assertEquals(34, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(14, t.fields[2]);
        assertEquals(4, t.fields[3]);
        t.rotateLeft();
        assertEquals(25, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(23, t.fields[2]);
        assertEquals(22, t.fields[3]);
        t.rotateLeft();
        assertEquals(14, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(34, t.fields[2]);
        assertEquals(44, t.fields[3]);
    }

    @Test
    public void setOShape() throws Exception {
        t = new oShapeTile(board);
        t.setFields();
    }

    @Test
    public void rotateTShapeRight() throws Exception {
        t = new tShapeTile(board);
        t.setFields();
        t.fall();
        t.rotateRight();
        assertEquals(5, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(25, t.fields[2]);
        assertEquals(14, t.fields[3]);
        t.rotateRight();
        assertEquals(16, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(14, t.fields[2]);
        assertEquals(5, t.fields[3]);
        t.rotateRight();
        assertEquals(25, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(5, t.fields[2]);
        assertEquals(16, t.fields[3]);
        t.rotateRight();
        assertEquals(14, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(16, t.fields[2]);
        assertEquals(25, t.fields[3]);
    }

    @Test
    public void rotateTShapeLeft() throws Exception {
        t = new tShapeTile(board);
        t.setFields();
        t.fall();
        t.rotateLeft();
        assertEquals(25, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(5, t.fields[2]);
        assertEquals(16, t.fields[3]);
        t.rotateLeft();
        assertEquals(16, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(14, t.fields[2]);
        assertEquals(5, t.fields[3]);
        t.rotateLeft();
        assertEquals(5, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(25, t.fields[2]);
        assertEquals(14, t.fields[3]);
        t.rotateLeft();
        assertEquals(14, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(16, t.fields[2]);
        assertEquals(25, t.fields[3]);
    }

    @Test
    public void setLShape() throws Exception {
        t = new lShapeTile(board);
        t.setFields();
    }

    @Test
    public void setJShape() throws Exception {
        t = new jShapeTile(board);
        t.setFields();
    }

    @Test
    public void setSShape() throws Exception {
        t = new sShapeTile(board);
        t.setFields();
    }

    @Test
    public void setZShape() throws Exception {
        t = new zShapeTile(board);
        t.setFields();
    }

    @Test
    public void moveTileLeft() throws Exception {
        setTile();
        t.moveLeft();
        assertEquals(3, t.fields[0]);
        assertEquals(13, t.fields[1]);
        assertEquals(23, t.fields[2]);
        assertEquals(33, t.fields[3]);
    }

    @Test
    public void cantMoveTileLeft() throws Exception {
        setTile();
        board.getField(3).locate();
        t.moveLeft();
        assertEquals(4, t.fields[0]);
        assertEquals(14, t.fields[1]);
        assertEquals(24, t.fields[2]);
        assertEquals(34, t.fields[3]);
    }

    @Test
    public void cantMoveTileLeftOverBorder() throws Exception {
        setTile();
        t.moveLeft();
        t.moveLeft();
        t.moveLeft();
        assertEquals(1, t.fields[0]);
        assertEquals(11, t.fields[1]);
        assertEquals(21, t.fields[2]);
        assertEquals(31, t.fields[3]);
        t.moveLeft();
        assertEquals(0, t.fields[0]);
        assertEquals(10, t.fields[1]);
        assertEquals(20, t.fields[2]);
        assertEquals(30, t.fields[3]);
        t.moveLeft();
        assertEquals(0, t.fields[0]);
        assertEquals(10, t.fields[1]);
        assertEquals(20, t.fields[2]);
        assertEquals(30, t.fields[3]);
    }

    @Test
    public void moveTileRight() throws Exception {
        setTile();
        t.moveRight();
        assertEquals(5, t.fields[0]);
        assertEquals(15, t.fields[1]);
        assertEquals(25, t.fields[2]);
        assertEquals(35, t.fields[3]);
    }

    @Test
    public void cantMoveTileRight() throws Exception {
        setTile();
        board.getField(5).locate();
        t.moveRight();
        assertEquals(4, t.fields[0]);
        assertEquals(14, t.fields[1]);
        assertEquals(24, t.fields[2]);
        assertEquals(34, t.fields[3]);
    }

    @Test
    public void cantMoveTileRightOverBorder() throws Exception {
        setTile();
        t.moveRight();
        t.moveRight();
        t.moveRight();
        t.moveRight();
        assertEquals(8, t.fields[0]);
        assertEquals(18, t.fields[1]);
        assertEquals(28, t.fields[2]);
        assertEquals(38, t.fields[3]);
        t.moveRight();
        assertEquals(9, t.fields[0]);
        assertEquals(19, t.fields[1]);
        assertEquals(29, t.fields[2]);
        assertEquals(39, t.fields[3]);
        t.moveRight();
        assertEquals(9, t.fields[0]);
        assertEquals(19, t.fields[1]);
        assertEquals(29, t.fields[2]);
        assertEquals(39, t.fields[3]);
    }

    @Test
    public void canFall() throws Exception {
        setTile();
        t.fall();
        assertEquals(14, t.fields[0]);
        assertEquals(24, t.fields[1]);
        assertEquals(34, t.fields[2]);
        assertEquals(44, t.fields[3]);
    }

    @Test
    public void cantFall() throws Exception {
        setTile();
        board.getField(44).locate();
        t.fall();
        assertEquals(4, t.fields[0]);
        assertEquals(14, t.fields[1]);
        assertEquals(24, t.fields[2]);
        assertEquals(34, t.fields[3]);
    }

    @Test
    public void cantFallBelowBottom() throws Exception {
        setTile();
        for (int i=0; i<11; i++)
            t.fall();
        assertEquals(114, t.fields[0]);
        assertEquals(124, t.fields[1]);
        assertEquals(134, t.fields[2]);
        assertEquals(144, t.fields[3]);
        t.fall();
        assertEquals(124, t.fields[0]);
        assertEquals(134, t.fields[1]);
        assertEquals(144, t.fields[2]);
        assertEquals(154, t.fields[3]);
        t.fall();
        assertEquals(124, t.fields[0]);
        assertEquals(134, t.fields[1]);
        assertEquals(144, t.fields[2]);
        assertEquals(154, t.fields[3]);
    }
}