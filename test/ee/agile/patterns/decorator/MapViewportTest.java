package ee.agile.patterns.decorator;

import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertEquals;

public class MapViewportTest {
    private static class DummyMap extends AsciiMap {
        public DummyMap() {
            super(new String[] {"0123", "4567", "8901"});
        }
    }

    @Test
    public void dimensions() throws Exception {
        Map map = new MapViewport(new DummyMap(), new Rectangle(1, 0, 2, 1));
        assertEquals(2, map.width());
        assertEquals(1, map.height());
    }

    @Test
    public void boundedMap() throws Exception {
        Map map = new MapViewport(new DummyMap(), new Rectangle(1, 1, 2, 2));
        assertEquals("56", map.line(0));
        assertEquals("90", map.line(1));
    }
}
