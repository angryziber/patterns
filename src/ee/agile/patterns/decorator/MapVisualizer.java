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
        System.out.println(new MapVisualizer().toString(new WorldMap()));
    }
}
