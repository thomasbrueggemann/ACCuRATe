package com.google.ads.conversiontracking;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.ads.conversiontracking.DoubleClickConversionReporter;
import com.google.ads.conversiontracking.GoogleConversionReporter;
import com.google.ads.conversiontracking.class_79;

public class AdWordsConversionReporter extends GoogleConversionReporter {
   // $FF: renamed from: a android.content.Context
   private final Context field_6;
   // $FF: renamed from: b java.lang.String
   private final String field_7;
   // $FF: renamed from: c java.lang.String
   private final String field_8;
   // $FF: renamed from: d com.google.ads.conversiontracking.g$d
   private final class_79.class_97 field_9;
   // $FF: renamed from: e java.lang.String
   private final String field_10;
   // $FF: renamed from: f java.lang.String
   private final String field_11;
   // $FF: renamed from: g boolean
   private final boolean field_12;

   public AdWordsConversionReporter(Context var1, String var2, String var3, String var4, String var5, boolean var6) {
      this.field_6 = var1;
      this.field_7 = var2;
      this.field_8 = var3;
      this.field_10 = var4;
      this.field_11 = var5;
      this.field_12 = var6;
      class_79.class_97 var7;
      if(this instanceof DoubleClickConversionReporter) {
         var7 = class_79.class_97.field_100;
      } else {
         var7 = class_79.class_97.field_101;
      }

      this.field_9 = var7;
   }

   public AdWordsConversionReporter(Context var1, String var2, String var3, String var4, boolean var5) {
      this(var1, var2, var3, var4, (String)null, var5);
   }

   public static boolean registerReferrer(Context var0, Uri var1) {
      if(var1 == null) {
         Log.e("GoogleConversionReporter", "Failed to register referrer from a null click url");
         return false;
      } else {
         String var2 = String.valueOf(var1);
         Log.i("GoogleConversionReporter", (new StringBuilder(13 + String.valueOf(var2).length())).append("Registering: ").append(var2).toString());
         class_79.class_96 var4 = class_79.method_525(var1);
         if(var4 == null) {
            String var10 = String.valueOf(var1);
            Log.w("GoogleConversionReporter", (new StringBuilder(31 + String.valueOf(var10).length())).append("Failed to parse referrer from: ").append(var10).toString());
            return false;
         } else {
            boolean var5 = class_79.method_539(var0, var4);
            if(var5) {
               String var8 = String.valueOf(var1);
               Log.i("GoogleConversionReporter", (new StringBuilder(25 + String.valueOf(var8).length())).append("Successfully registered: ").append(var8).toString());
               return var5;
            } else {
               String var6 = String.valueOf(var1);
               Log.w("GoogleConversionReporter", (new StringBuilder(20 + String.valueOf(var6).length())).append("Failed to register: ").append(var6).toString());
               return var5;
            }
         }
      }
   }

   public static void reportWithConversionId(Context var0, String var1, String var2, String var3, boolean var4) {
      (new AdWordsConversionReporter(var0, var1, var2, var3, var4)).report();
   }

   public void report() {
      // $FF: Couldn't be decompiled
   }
}
