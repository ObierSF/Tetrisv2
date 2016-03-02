package Game;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 01.03.2016.
 */
public class TileFactoryTest {
    TileFactory tileFactory;

    @Test
    public void getRandomTile() throws Exception {
        Board b = new Board(160);
        tileFactory = new TileFactory(b);
        Tile tile  = tileFactory.getRandomTile();
    }
}