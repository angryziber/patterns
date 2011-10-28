package ee.agile.patterns.composite;

import org.junit.Test;

import static junit.framework.Assert.*;

public class UnzipperTest {
    private Unzipper unzipper = new Unzipper();

    @Test // Bible, Rev.13:18
    public void revelationCompressesWell() throws Exception {
        String zipped = "Here~=%. Let~HW$UC!1O! beast, for~-=!1OaM: his~1=60&6ty-~6.";
        String unzipped = unzipper.unzip(zipped);

        assertEquals(
            "Here is wisdom. Let him who has understanding calculate " +
            "the number of the beast, for it is the number of a man: " +
            "his number is six hundred and sixty- six.",
            unzipped);

        assertEquals(59, zipped.length());
        assertEquals(153, unzipped.length());
    }
}
