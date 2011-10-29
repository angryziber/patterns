package ee.agile.patterns.adapter;

import java.util.HashMap;
import java.util.Map;

import static ee.agile.patterns.adapter.DNSPacket.ADDRESS;

public class ProperDNSServer implements DNSServer {
    private String ownTLD = "agile.ee";
    private String ownIP = "192.168.13.14";

    private Map<String, DNSServer> serversByTLD = new HashMap<String, DNSServer>();

    public DNSPacket query(DNSPacket query) {
        if (query.is(ADDRESS)) {
            String name = query.getContent();
            String tld = name.substring(name.indexOf('.') + 1);

            if (tld.equals(ownTLD)) {
                return new DNSPacket(ADDRESS, ownIP);
            }

            return queryAnotherServer(tld, query);
        }
        else {
            return new DNSPacket(query.getType(), "Unsupported query");
        }
    }

    private DNSPacket queryAnotherServer(String tld, DNSPacket query) {
        DNSServer anotherServer = serversByTLD.get(tld);
        if (anotherServer != null)
            return anotherServer.query(query);
        else
            return new DNSPacket(query.getType(), "Unresolved name");
    }
}
