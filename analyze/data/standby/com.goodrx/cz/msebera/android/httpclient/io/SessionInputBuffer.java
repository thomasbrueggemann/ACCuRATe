package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

public interface SessionInputBuffer {
   HttpTransportMetrics getMetrics();

   @Deprecated
   boolean isDataAvailable(int var1) throws IOException;

   int read() throws IOException;

   int read(byte[] var1, int var2, int var3) throws IOException;

   int readLine(CharArrayBuffer var1) throws IOException;
}
