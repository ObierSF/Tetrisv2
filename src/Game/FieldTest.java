package Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 25.02.2016.
 */
public class FieldTest {
    private Field f;
    Board b;

    @Before
    public void setUp() throws Exception {
        b = new Board(160);
        f = b.board.get(4);
    }

    @Test
    public void canCreate() throws Exception {
        Field field = new Field(b, 4);
        assertFalse(field.isPartOfTile);
    }

    @Test
    public void fieldStateAtCreate() throws Exception {
        assertFalse(f.isPartOfTile);
        assertFalse(f.isLocated);
    }

    @Test
    public void canMakePartOfTile() throws Exception {
        f.makePartOfTile("RED");
        assertTrue(f.isPartOfTile);
        assertFalse(f.isLocated);
        assertEquals(f.color, "RED");
    }

    @Test
    public void canLocate() throws Exception {
        f.locate();
        assertFalse(f.isPartOfTile);
        assertTrue(f.isLocated);
    }

    @Test
    public void canEmpty() throws Exception {
        f.empty();
        assertFalse(f.isPartOfTile);
        assertFalse(f.isLocated);
    }

    @Test
    public void isLeftSideEmpty() throws Exception {
        assertTrue(f.isLeftSideFieldEmpty());
        b.getField(3).isLocated = true;
        assertFalse(f.isAbleToMoveLeft());
        assertFalse(f.isLeftSideFieldEmpty());
    }

    @Test
    public void isFieldAtBorder() throws Exception {
        Field field = b.getField(30);
        assertFalse(f.isFieldAtLeftBorder());
        assertFalse(field.isAbleToMoveLeft());
        assertTrue(field.isFieldAtLeftBorder());
    }

    @Test
    public void canFieldMoveLeftFrom0() throws Exception {
        Field field = b.getField(0);
        assertFalse(field.isAbleToMoveLeft());
        assertTrue(field.isFieldAtLeftBorder());
    }

    @Test
    public void isRightSideEmpty() throws Exception {
        assertTrue(f.isRightSideFieldEmpty());
        b.getField(5).isLocated = true;
        assertFalse(f.isAbleToMoveRight());
        assertFalse(f.isRightSideFieldEmpty());
    }

    @Test
    public void isFieldAtRightBorder() throws Exception {
        Field field = b.getField(29);
        assertFalse(f.isFieldAtRightBorder());
        assertFalse(field.isAbleToMoveRight());
        assertTrue(field.isFieldAtRightBorder());
    }

    @Test
    public void moveRightAtEndOfBoard() throws Exception {
        Field field = b.getField(159);
        assertFalse(field.isAbleToMoveRight());
        assertTrue(field.isFieldAtRightBorder());
    }

    @Test
    public void canMoveFieldToChoosenPosition() throws Exception {
        f.moveToPosition(10);
        assertTrue(b.getField(10).isPartOfTile);
    }

    @Test
    public void canFieldFall() throws Exception {
        assertTrue(f.isFallPossible());
        f.fall();
        assertTrue(b.getField(14).isPartOfTile);
    }

    @Test
    public void cantFallUnderBoard() throws Exception {
        Field field = new Field(b, 150);
        assertFalse(field.isFallPossible());
    }

    @Test
    public void cantFallOnNotEmptyField() throws Exception {
        Field field = b.getField(14);
        field.locate();
        assertFalse(f.isFallPossible());
    }

    @Test
    public void canMoveField() throws Exception {
        assertTrue(f.isPositionEmpty(10));
        f.moveToPosition(10);
        b.getField(10).locate();
        assertFalse(f.isPositionEmpty(10));
    }
}