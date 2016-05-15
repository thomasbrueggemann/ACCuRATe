package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpConnection;
import java.net.InetAddress;

public interface HttpInetConnection extends HttpConnection {
   InetAddress getRemoteAddress();

   int getRemotePort();
}
