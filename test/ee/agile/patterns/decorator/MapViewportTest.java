package ee.agile.patterns.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapViewportTest {
    private static class DummyMap extends AsciiMap {
        public DummyMap() {
            super(new String[] {"1234", "2345", "3456"});
        }
    }

    @Test
    public void addsNiceBorders() throws Exception {
        Map map = new DummyMap();
        map = new MapViewport(map, 2, 0, 2, 2);

        assertEquals(
          "+--+\n" +
          "|34|\n" +
          "|45|\n" +
          "+--+\n",
          new MapVisualizer().toString(map));
    }

}
