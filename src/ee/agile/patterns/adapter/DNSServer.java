package ee.agile.patterns.adapter;

public interface DNSServer {
    DNSPacket query(DNSPacket query);
}
