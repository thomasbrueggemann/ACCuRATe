package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.internal.il
public final class class_284 {
   // $FF: renamed from: a (java.io.InputStream, boolean) byte[]
   public static byte[] method_1875(InputStream param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String, android.database.CharArrayBuffer) void
   public static void method_1876(String var0, CharArrayBuffer var1) {
      if(var1.data != null && var1.data.length >= var0.length()) {
         var0.getChars(0, var0.length(), var1.data, 0);
      } else {
         var1.data = var0.toCharArray();
      }

      var1.sizeCopied = var0.length();
   }
}
