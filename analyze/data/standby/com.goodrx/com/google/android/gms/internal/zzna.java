package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.IOException;

public final class zzna {
   public static void zzb(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            return;
         }
      }

   }
}
