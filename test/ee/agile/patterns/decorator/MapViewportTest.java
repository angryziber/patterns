package ee.agile.patterns.decorator;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class MapViewportTest {
    private static class DummyMap extends AsciiMap {
        public DummyMap() {
            super(new String[] {"1234", "5678", "9012"});
        }
    }

    @Test
    public void viewportConstrantsTheMap() throws Exception {
        Map original = new DummyMap();
        Map viewport = new MapViewport(original, new Rectangle(1, 0, 2, 2));
        assertEquals("+--+\n" +
                     "|23|\n" +
                     "|67|\n" +
                     "+--+\n",
                new MapVisualizer().toString(viewport));
    }
}
