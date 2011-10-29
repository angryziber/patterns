package ee.agile.patterns.decorator;

import java.awt.*;

public class MapViewport implements Map {
    private Map map;
    private Rectangle viewport;

    public MapViewport(Map map, Rectangle viewport) {
        this.map = map;
        this.viewport = viewport;
    }

    public char get(int x, int y) {
        return line(y).charAt(x);
    }

    public String line(int y) {
        return map.line(y + viewport.y).substring(viewport.x, viewport.x + viewport.width);
    }

    public int width() {
        return viewport.width;
    }

    public int height() {
        return viewport.height;
    }
}
