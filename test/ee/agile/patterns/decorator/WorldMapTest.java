package ee.agile.patterns.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldMapTest {
    private Map world = new WorldMap();

    @Test
    public void dimensions() throws Exception {
        assertEquals(71, world.width());
        assertEquals(23, world.height());
    }

    @Test
    public void estonia() throws Exception {
        assertEquals('(', world.get(40, 3));
    }
}
