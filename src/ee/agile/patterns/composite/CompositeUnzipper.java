package ee.agile.patterns.composite;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.*;

import static java.util.Collections.enumeration;

public class CompositeUnzipper implements Unzipper {
    private Queue<InputStream> streams = new LinkedList<InputStream>();

    public CompositeUnzipper add(InputStream volume) {
        streams.add(volume);
        return this;
    }

    public String unzip() throws IOException {
        InputStream combined = new SequenceInputStream(enumeration(streams));
        return new SimpleUnzipper(combined).unzip();
    }
}
