package ee.agile.patterns.adapter;

import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SocksProxyTest {

    @Test
    public void canSendTCPOverDNS() throws Exception {
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DNSServer dns = mock(DNSServer.class);

        when(dns.query(new DNSPacket("DNS2TCP", "127.0.0.1|GET / HTTP/1.0\r\n")))
                .thenReturn(new DNSPacket("DNS2TCP", "127.0.0.1|<html>"));

        SocksProxy adapter = new SocksProxy(dns);
        TCPPacket html = adapter.send(new TCPPacket(ip, "GET / HTTP/1.0\r\n"));
        assertEquals(ip, html.ip);
        assertEquals("<html>", html.data);
    }
}
