package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.DnsResolver;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemDefaultDnsResolver implements DnsResolver {
   public static final SystemDefaultDnsResolver INSTANCE = new SystemDefaultDnsResolver();

   public InetAddress[] resolve(String var1) throws UnknownHostException {
      return InetAddress.getAllByName(var1);
   }
}
