package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_184;
import com.google.android.gms.internal.class_362;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.ey;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bc
public final class class_186 {
   // $FF: renamed from: mR com.google.android.gms.internal.bd
   public static final class_10 field_592 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey var1, Map<String, String> var2) {
      }
   };
   // $FF: renamed from: mS com.google.android.gms.internal.bd
   public static final class_10 field_593 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey var1, Map<String, String> var2) {
         String var3 = (String)var2.get("urls");
         if(TextUtils.isEmpty(var3)) {
            class_370.method_2358("URLs missing in canOpenURLs GMSG.");
         } else {
            String[] var4 = var3.split(",");
            HashMap var5 = new HashMap();
            PackageManager var6 = var1.getContext().getPackageManager();
            int var7 = var4.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               String var9 = var4[var8];
               String[] var10 = var9.split(";", 2);
               String var11 = var10[0].trim();
               String var12;
               if(var10.length > 1) {
                  var12 = var10[1].trim();
               } else {
                  var12 = "android.intent.action.VIEW";
               }

               boolean var13;
               if(var6.resolveActivity(new Intent(var12, Uri.parse(var11)), 65536) != null) {
                  var13 = true;
               } else {
                  var13 = false;
               }

               var5.put(var9, Boolean.valueOf(var13));
            }

            var1.method_2342("openableURLs", var5);
         }
      }
   };
   // $FF: renamed from: mT com.google.android.gms.internal.bd
   public static final class_10 field_594 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   // $FF: renamed from: mU com.google.android.gms.internal.bd
   public static final class_10 field_595 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey var1, Map<String, String> var2) {
         class_422 var3 = var1.method_2348();
         if(var3 == null) {
            class_370.method_2358("A GMSG tried to close something that wasn\'t an overlay.");
         } else {
            var3.close();
         }
      }
   };
   // $FF: renamed from: mV com.google.android.gms.internal.bd
   public static final class_10 field_596 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey var1, Map<String, String> var2) {
         class_422 var3 = var1.method_2348();
         if(var3 == null) {
            class_370.method_2358("A GMSG tried to use a custom close button on something that wasn\'t an overlay.");
         } else {
            var3.method_2565("1".equals(var2.get("custom_close")));
         }
      }
   };
   // $FF: renamed from: mW com.google.android.gms.internal.bd
   public static final class_10 field_597 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey var1, Map<String, String> var2) {
         String var3 = (String)var2.get("u");
         if(var3 == null) {
            class_370.method_2358("URL missing from httpTrack GMSG.");
         } else {
            (new class_362(var1.getContext(), var1.method_2351().field_1607, var3)).start();
         }
      }
   };
   // $FF: renamed from: mX com.google.android.gms.internal.bd
   public static final class_10 field_598 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey var1, Map<String, String> var2) {
         class_370.method_2356("Received log message: " + (String)var2.get("string"));
      }
   };
   // $FF: renamed from: mY com.google.android.gms.internal.bd
   public static final class_10 field_599 = new class_10() {
      // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
      public void method_19(ey param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   // $FF: renamed from: mZ com.google.android.gms.internal.bd
   public static final class_10 field_600 = new class_184();
}
