package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public interface LayeredSchemeSocketFactory extends SchemeSocketFactory {
   Socket createLayeredSocket(Socket var1, String var2, int var3, boolean var4) throws IOException, UnknownHostException;
}
