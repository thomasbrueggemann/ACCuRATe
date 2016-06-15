package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.HeadersMode;
import com.squareup.okhttp.internal.spdy.Settings;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface FrameReader extends Closeable {
   boolean nextFrame(FrameReader.Handler var1) throws IOException;

   void readConnectionHeader() throws IOException;

   public interface Handler {
      void data(boolean var1, int var2, InputStream var3, int var4) throws IOException;

      void goAway(int var1, ErrorCode var2);

      void headers(boolean var1, boolean var2, int var3, int var4, int var5, List<String> var6, HeadersMode var7);

      void noop();

      void ping(boolean var1, int var2, int var3);

      void priority(int var1, int var2);

      void rstStream(int var1, ErrorCode var2);

      void settings(boolean var1, Settings var2);

      void windowUpdate(int var1, int var2, boolean var3);
   }
}
