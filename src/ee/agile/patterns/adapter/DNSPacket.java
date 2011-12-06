package ee.agile.patterns.adapter;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DNSPacket dnsPacket = (DNSPacket) o;

        if (content != null ? !content.equals(dnsPacket.content) : dnsPacket.content != null) return false;
        if (type != null ? !type.equals(dnsPacket.type) : dnsPacket.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
