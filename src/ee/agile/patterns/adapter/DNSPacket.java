package ee.agile.patterns.adapter;

import com.sun.deploy.net.proxy.StaticProxyManager;

public class DNSPacket {
    public static final String ADDRESS = "A";
    public static final String ADDRESS_IPV6 = "AAAA";
    public static final String COMMON_NAME = "CNAME";
    public static final String MAIL_EXCHANGE = "MX";

    private String type;
    private String content;

    public DNSPacket(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public boolean is(String type) {
        return type.equals(this.type);
    }
}
