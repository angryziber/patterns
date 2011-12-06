package ee.agile.patterns.decorator;

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
        System.out.println(visualizer.toString(world));

        Map europe = new MapViewport(world, 30, 2, 12, 5);
        System.out.println(visualizer.toString(europe));
    }
}
