package ee.agile.patterns.adapter;

import org.junit.Test;

import static ee.agile.patterns.adapter.DNSPacket.ADDRESS;
import static junit.framework.Assert.assertEquals;

public class ProperDNSServerTest {
    private ProperDNSServer dns = new ProperDNSServer();

    @Test
    public void ownTLDQueries() throws Exception {
        DNSPacket response = dns.query(new DNSPacket(ADDRESS, "www.agile.ee"));
        assertEquals(ADDRESS, response.getType());
        assertEquals("192.168.13.14", response.getContent());
    }

    @Test
    public void unknownTLD() throws Exception {
        DNSPacket response = dns.query(new DNSPacket(ADDRESS, "www.something.com"));
        assertEquals(ADDRESS, response.getType());
        assertEquals("Unresolved name", response.getContent());
    }
}
