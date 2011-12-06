package ee.agile.patterns.observer;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ChartTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Spreadsheet sheet = new Spreadsheet();

    @Test
    public void chartDrawsSpecifiedRange() throws Exception {
        Chart chart = new Chart(sheet, "A1", "A2");
        chart.out = new PrintStream(out);

        chart.draw();
        assertDrawn("00");
    }

    @Test
    public void chartRedrawsWhenDataIsChanged() throws Exception {
        Chart chart = new Chart(sheet, "A1", "A2");
        chart.out = new PrintStream(out);

        sheet.set("A1", 4);
        sheet.set("A2", 2);

        assertDrawn("4042");
    }

    private void assertDrawn(String expected) {
        assertEquals(expected, out.toString());
    }
}
