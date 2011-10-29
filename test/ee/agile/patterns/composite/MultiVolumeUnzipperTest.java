package ee.agile.patterns.composite;

import org.junit.Test;

import java.io.InputStream;

import static ee.agile.patterns.composite.SimpleUnzipperTest.*;
import static org.junit.Assert.assertEquals;

public class MultiVolumeUnzipperTest {
    @Test
    public void singleVolume() throws Exception {
        InputStream in = stream("Here~=%. Let~HW$UC!1O! beast, for~-=!1OaM: his~1=60&6ty-~6.");
        Unzipper unzipper = new SimpleUnzipper(in);
        assertEquals(REVELATION, unzipper.unzip());
    }

    @Test
    public void unzipMultipleVolumes() throws Exception {
        InputStream vol1 = stream("Here~=%. Let~HW$");
        InputStream vol2 = stream("UC!1O! beast, fo");
        InputStream vol3 = stream("r~-=!1OaM: his~1");
        InputStream vol4 = stream("=60&6ty-~6.");

        Unzipper unzipper = new MultiVolumeUnzipper(vol1, vol2, vol3, vol4);
        assertEquals(REVELATION, unzipper.unzip());
    }
}
