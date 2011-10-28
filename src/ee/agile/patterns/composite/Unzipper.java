package ee.agile.patterns.composite;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Unzipper {
    private Map<Character, String> table = new HashMap<Character, String>() {{
        put('1', "number");
        put('6', "six");
        put('0', "hundred");
        put('a', "a");
        put('&', "and");
        put('-', "it");
        put('=', "is");
        put('O', "of");
        put('!', "the");
        put('$', "has");
        put('H', "him");
        put('M', "man");
        put('W', "who");
        put('%', "wisdom");
        put('U', "understanding");
        put('C', "calculate");
    }};

    public String unzip(InputStream stream) throws IOException {
        StringBuilder buf = new StringBuilder();
        int c;
        while ((c = stream.read()) != -1) {
            if (c == '~') substituteNextChars(buf, stream);
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
