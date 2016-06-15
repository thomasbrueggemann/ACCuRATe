package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Settings;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface FrameWriter extends Closeable {
   void connectionHeader() throws IOException;

   void data(boolean var1, int var2, byte[] var3) throws IOException;

   void data(boolean var1, int var2, byte[] var3, int var4, int var5) throws IOException;

   void flush() throws IOException;

   void goAway(int var1, ErrorCode var2) throws IOException;

   void headers(int var1, List<String> var2) throws IOException;

   void noop() throws IOException;

   void ping(boolean var1, int var2, int var3) throws IOException;

   void rstStream(int var1, ErrorCode var2) throws IOException;

   void settings(Settings var1) throws IOException;

   void synReply(boolean var1, int var2, List<String> var3) throws IOException;

   void synStream(boolean var1, boolean var2, int var3, int var4, int var5, int var6, List<String> var7) throws IOException;

   void windowUpdate(int var1, int var2) throws IOException;
}
