package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.Header;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface HttpEntity {
   @Deprecated
   void consumeContent() throws IOException;

   InputStream getContent() throws IOException, IllegalStateException;

   Header getContentEncoding();

   long getContentLength();

   Header getContentType();

   boolean isChunked();

   boolean isRepeatable();

   boolean isStreaming();

   void writeTo(OutputStream var1) throws IOException;
}
