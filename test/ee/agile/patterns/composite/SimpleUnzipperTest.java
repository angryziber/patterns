package ee.agile.patterns.composite;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class SimpleUnzipperTest {
    public static final String REVELATION = // Bible, Rev.13:18
            "Here is wisdom. Let him who has understanding calculate " +
            "the number of the beast, for it is the number of a man: " +
            "his number is six hundred and sixty- six.";

    @Test
    public void revelationCompressesWell() throws Exception {
        String zipped = "Here~=%. Let~HW$UC!1O! beast, for~-=!1OaM: his~1=60&6ty-~6.";
        String unzipped = unzip(stream(zipped));

        assertThat(unzipped, is(REVELATION));
        assertThat(zipped.length(), is(59));
        assertThat(unzipped.length(), is(153));
    }

    @Test
    public void splittingDataIntoPeacesIsNotEasy() throws Exception {
        InputStream vol1 = stream("Here~=%. Let~HW$");
        InputStream vol2 = stream("UC!1O! beast, fo");
        InputStream vol3 = stream("r~-=!1OaM: his~1");
        InputStream vol4 = stream("=60&6ty-~6.");

        String corrupted = unzip(vol1) + unzip(vol2) +
                           unzip(vol3) + unzip(vol4);

        System.out.println(corrupted);
        assertThat(corrupted, is(not(REVELATION)));
    }

    private String unzip(InputStream data) throws IOException {
        return new SimpleUnzipper(data).unzip();
    }

    static InputStream stream(String text) throws IOException {
        return new ByteArrayInputStream(text.getBytes());
    }
}
