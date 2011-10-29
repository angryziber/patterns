package ee.agile.patterns.observer;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChartTest {
    private Spreadsheet spreadsheet = new Spreadsheet();

    @Test
    public void chartIsUpdatedWhenDataChanges() throws Exception {
        final boolean[] redrawCalled = {false};
        Chart chart = new Chart(spreadsheet, "A1:C4") {
            @Override
            void redraw() {
                redrawCalled[0] = true;
                super.redraw();
            }
        };
        spreadsheet.addObserver(chart);

        spreadsheet.set("A2", 3);
        assertTrue(redrawCalled[0]);
    }
}
