package ee.agile.patterns.observer;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

public class Chart implements Observer {
    private Spreadsheet spreadsheet;
    private String from, to;
    PrintStream out = System.out;

    public Chart(Spreadsheet spreadsheet, String from, String to) {
        this.spreadsheet = spreadsheet;
        this.from = from;
        this.to = to;
        spreadsheet.addObserver(this);
    }

    public void draw() {
        out.print("" + spreadsheet.get(from) + spreadsheet.get(to));
    }

    public void update(Observable o, Object arg) {
        draw();
    }
}
