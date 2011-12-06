package ee.agile.patterns.decorator;

public class MapViewport implements Map {
    private Map original;
    private int x;
    private int y;
    private int width;
    private int height;

    public MapViewport(Map map, int x, int y, int width, int height) {
        this.original = map;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public char get(int x, int y) {
        return line(y).charAt(x);
    }

    public String line(int y) {
        return original.line(y + this.y).substring(x, x + width);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
