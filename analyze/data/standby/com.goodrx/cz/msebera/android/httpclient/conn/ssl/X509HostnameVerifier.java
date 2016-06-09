package cz.msebera.android.httpclient.conn.ssl;

import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

public interface X509HostnameVerifier extends HostnameVerifier {
   void verify(String var1, SSLSocket var2) throws IOException;

   void verify(String var1, String[] var2, String[] var3) throws SSLException;
}
