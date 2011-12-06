package ee.agile.patterns.adapter;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;

import static org.junit.Assert.assertEquals;

public class TCPPacketTest {
    @Test
    public void canDeserializeSerializedPackets() throws Exception {
        TCPPacket original = new TCPPacket(InetAddress.getByName("192.168.0.1"), "hello");
        assertEquals(original, new TCPPacket(original.serialize()));
    }
}
