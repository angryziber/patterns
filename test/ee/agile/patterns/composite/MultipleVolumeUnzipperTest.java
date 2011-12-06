package ee.agile.patterns.composite;

import org.junit.Test;

import java.io.InputStream;

import static ee.agile.patterns.composite.SimpleUnzipperTest.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MultipleVolumeUnzipperTest {
    @Test
    public void splittingDataIntoPeacesIsNotEasy() throws Exception {
        InputStream vol1 = stream("Here~=%. Let~HW$");
        InputStream vol2 = stream("UC!1O! beast, fo");
        InputStream vol3 = stream("r~-=!1OaM: his~1");
        InputStream vol4 = stream("=60&6ty-~6.");

        Unzipper unzipper = new MultipleVolumeUnzipper(vol1, vol2, vol3, vol4);
        String unzipped = unzipper.unzip();

        assertThat(unzipped, is(REVELATION));
    }

}
