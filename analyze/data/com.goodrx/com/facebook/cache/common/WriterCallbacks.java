package com.facebook.cache.common;

import com.facebook.cache.common.WriterCallback;
import com.facebook.common.internal.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriterCallbacks {
   public static WriterCallback from(final InputStream var0) {
      return new WriterCallback() {
         public void write(OutputStream var1) throws IOException {
            ByteStreams.copy(var0, var1);
         }
      };
   }

   public static WriterCallback from(final byte[] var0) {
      return new WriterCallback() {
         public void write(OutputStream var1) throws IOException {
            var1.write(var0);
         }
      };
   }
}
