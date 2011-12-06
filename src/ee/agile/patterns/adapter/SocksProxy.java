package ee.agile.patterns.adapter;

/**
 * Adapter that converts TCP packets to DNS and back
 */
public class SocksProxy {
    private DNSServer dns;

    public SocksProxy(DNSServer dns) {
        this.dns = dns;
    }

    public TCPPacket send(TCPPacket packet) {
        return unwrap(dns.query(wrap(packet)));
    }

    private TCPPacket unwrap(DNSPacket packet) {
        return new TCPPacket(packet.getContent());
    }

    private DNSPacket wrap(TCPPacket packet) {
        return new DNSPacket("DNS2TCP", packet.serialize());
    }
}
