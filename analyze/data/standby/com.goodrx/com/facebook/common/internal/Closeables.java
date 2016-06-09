package com.facebook.common.internal;

import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Closeables {
   @VisibleForTesting
   static final Logger logger = Logger.getLogger(Closeables.class.getName());

   public static void close(@Nullable Closeable var0, boolean var1) throws IOException {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var3) {
            if(var1) {
               logger.log(Level.WARNING, "IOException thrown while closing Closeable.", var3);
            } else {
               throw var3;
            }
         }
      }
   }

   public static void closeQuietly(@Nullable InputStream var0) {
      try {
         close(var0, true);
      } catch (IOException var2) {
         throw new AssertionError(var2);
      }
   }

   public static void closeQuietly(@Nullable Reader var0) {
      try {
         close(var0, true);
      } catch (IOException var2) {
         throw new AssertionError(var2);
      }
   }
}
