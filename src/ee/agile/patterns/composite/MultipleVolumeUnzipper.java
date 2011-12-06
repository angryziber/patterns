package ee.agile.patterns.composite;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.enumeration;

public class MultipleVolumeUnzipper implements Unzipper {
    private Unzipper unzipper;

    public MultipleVolumeUnzipper(InputStream ... streams) {
        SequenceInputStream input = new SequenceInputStream(enumeration(asList(streams)));
        unzipper = new SimpleUnzipper(input);
    }

    public String unzip() throws IOException {
        return unzipper.unzip();
    }
}
