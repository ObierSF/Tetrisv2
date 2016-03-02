package Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 01.03.2016.
 */
public class BoardTest {
    Board b;

    @Before
    public void setUp() throws Exception {
        b = new Board(160);
    }

    @Test
    public void canCreate() throws Exception {
        Field f = b.getField(3);
        assertFalse(f.isLocated);
        assertFalse(b.getField(3).isPartOfTile);
    }
}