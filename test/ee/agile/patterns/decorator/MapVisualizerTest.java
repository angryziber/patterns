package ee.agile.patterns.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapVisualizerTest {
    private static class DummyMap extends AsciiMap {
        public DummyMap() {
            super(new String[] {"ooii", "iiio"});
        }
    }

    @Test
    public void addsNiceBorders() throws Exception {
        assertEquals(
          "+----+\n" +
          "|ooii|\n" +
          "|iiio|\n" +
          "+----+\n",
          new MapVisualizer().toString(new DummyMap()));
    }
}
