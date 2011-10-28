package ee.agile.patterns.decorator;

import java.awt.*;

public class MapVisualizer {
    public String toString(Map map) {
        StringBuilder buf = new StringBuilder();
        appendLine(buf, map.width());
        for (int y = 0; y < map.height(); y++)
            buf.append('|').append(map.line(y)).append("|\n");
        appendLine(buf, map.width());
        return buf.toString();
    }

    private StringBuilder appendLine(StringBuilder buf, int length) {
        buf.append('+');
        for (int i = 0; i < length; i++) buf.append("-");
        return buf.append("+\n");
    }

    public static void main(String[] args) {
        MapVisualizer visualizer = new MapVisualizer();
        Map world = new WorldMap();
        Map europe = new MapViewport(world, new Rectangle(30, 1, 20, 6));

        System.out.println(visualizer.toString(world));
        System.out.println(visualizer.toString(europe));
    }
}
