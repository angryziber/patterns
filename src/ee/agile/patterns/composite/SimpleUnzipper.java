package ee.agile.patterns.composite;

import java.io.*;

public class SimpleUnzipper implements Unzipper {
    private SecretLookupTable table = new SecretLookupTable();
    private InputStream data;

    public SimpleUnzipper(InputStream data) {
        this.data = data;
    }

    public String unzip() throws IOException {
        StringBuilder buf = new StringBuilder();
        int c;
        while ((c = data.read()) != -1) {
            if (table.isMarker(c)) substituteNextChars(buf, data);
            else buf.append((char)c);
        }
        return buf.toString();
    }

    private void substituteNextChars(StringBuilder buf, InputStream stream) throws IOException {
        int c;
        while ((c = stream.read()) != -1) {
            String sub = table.get((char)c);
            if (sub == null) {
                buf.append((char)c);
                break;
            }
            buf.append(' ').append(sub);
        }
    }
}
