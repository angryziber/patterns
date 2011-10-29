package ee.agile.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class Chart implements Observer {
    private Spreadsheet spreadsheet;
    private String range;

    public Chart(Spreadsheet spreadsheet, String range) {
        this.spreadsheet = spreadsheet;
        this.range = range;
    }

    public void update(Observable o, Object arg) {
        redraw();
    }

    void redraw() {
        System.out.println("Redrawing " + range);
    }
}
