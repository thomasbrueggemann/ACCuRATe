package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import java.io.IOException;

@Deprecated
public interface AbortableHttpRequest {
   void setConnectionRequest(ClientConnectionRequest var1) throws IOException;

   void setReleaseTrigger(ConnectionReleaseTrigger var1) throws IOException;
}
