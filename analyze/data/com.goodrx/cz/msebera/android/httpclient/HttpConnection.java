package cz.msebera.android.httpclient;

import java.io.Closeable;
import java.io.IOException;

public interface HttpConnection extends Closeable {
   void close() throws IOException;

   boolean isOpen();

   boolean isStale();

   void setSocketTimeout(int var1);

   void shutdown() throws IOException;
}
