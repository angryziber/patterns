package ee.agile.patterns.adapter;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TCPPacket {
    InetAddress ip;
    String data;

    public TCPPacket() {
    }

    public TCPPacket(InetAddress ip, String data) {
        this.ip = ip;
        this.data = data;
    }

    public TCPPacket(String serialized) {
        String[] parts = serialized.split("\\|", 2);
        try {
            ip = InetAddress.getByName(parts[0]);
            data = parts[1];
        }
        catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public String serialize() {
        return ip.getHostAddress() + "|" + data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TCPPacket tcpPacket = (TCPPacket) o;

        if (data != null ? !data.equals(tcpPacket.data) : tcpPacket.data != null) return false;
        if (ip != null ? !ip.equals(tcpPacket.ip) : tcpPacket.ip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TCPPacket{" +
                "ip=" + ip +
                ", data='" + data + '\'' +
                '}';
    }
}
