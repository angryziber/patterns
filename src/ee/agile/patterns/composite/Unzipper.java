package ee.agile.patterns.composite;

import java.io.IOException;
import java.io.InputStream;

public interface Unzipper {
    String unzip() throws IOException;
}
