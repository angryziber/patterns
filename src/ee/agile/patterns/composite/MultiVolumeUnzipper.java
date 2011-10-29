package ee.agile.patterns.composite;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

import static java.util.Arrays.asList;
import static java.util.Collections.enumeration;

public class MultiVolumeUnzipper implements Unzipper {
    private Unzipper unzipper;

    public MultiVolumeUnzipper(InputStream ... streams) {
        SequenceInputStream stream = new SequenceInputStream(enumeration(asList(streams)));
        unzipper = new SimpleUnzipper(stream);
    }

    public String unzip() throws IOException {
        return unzipper.unzip();
    }
}
