package ee.agile.patterns.composite;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static ee.agile.patterns.composite.SimpleUnzipperTest.*;
import static org.junit.Assert.*;

public class CompositeUnzipperTest {
    @Test
    public void singleVolume() throws Exception {
        InputStream data = stream("Here~=%. Let~HW$UC!1O! beast, for~-=!1OaM: his~1=60&6ty-~6.");
        Unzipper unzipper = new SimpleUnzipper(data);
        assertUnzipsTo(unzipper, REVELATION);
    }

    @Test
    public void multipleVolumes() throws Exception {
        InputStream vol1 = stream("Here~=%. Let~HW$");
        InputStream vol2 = stream("UC!1O! beast, fo");
        InputStream vol3 = stream("r~-=!1OaM: his~1");
        InputStream vol4 = stream("=60&6ty-~6.");

        Unzipper unzipper = new CompositeUnzipper().
                add(vol1).add(vol2).add(vol3).add(vol4);

        assertUnzipsTo(unzipper, REVELATION);
    }

    private void assertUnzipsTo(Unzipper unzipper, String expected) throws IOException {
        assertEquals(expected, unzipper.unzip());
    }
}
