package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_138;
import com.google.android.gms.analytics.class_669;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// $FF: renamed from: com.google.android.gms.analytics.h
class class_643 implements class_138 {
   // $FF: renamed from: tE com.google.android.gms.analytics.h
   private static class_643 field_3386;
   // $FF: renamed from: tn java.lang.Object
   private static final Object field_3387 = new Object();
   private final Context mContext;
   // $FF: renamed from: tF java.lang.String
   private String field_3388;
   // $FF: renamed from: tG boolean
   private boolean field_3389 = false;
   // $FF: renamed from: tH java.lang.Object
   private final Object field_3390 = new Object();

   protected class_643(Context var1) {
      this.mContext = var1;
      this.method_3689();
   }

   // $FF: renamed from: K (java.lang.String) boolean
   private boolean method_3683(String var1) {
      try {
         class_669.method_3890("Storing clientId.");
         FileOutputStream var4 = this.mContext.openFileOutput("gaClientId", 0);
         var4.write(var1.getBytes());
         var4.close();
         return true;
      } catch (FileNotFoundException var5) {
         class_669.method_3888("Error creating clientId file.");
         return false;
      } catch (IOException var6) {
         class_669.method_3888("Error writing to clientId file.");
         return false;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.h) java.lang.Object
   // $FF: synthetic method
   static Object method_3684(class_643 var0) {
      return var0.field_3390;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.h, java.lang.String) java.lang.String
   // $FF: synthetic method
   static String method_3685(class_643 var0, String var1) {
      var0.field_3388 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.h, boolean) boolean
   // $FF: synthetic method
   static boolean method_3686(class_643 var0, boolean var1) {
      var0.field_3389 = var1;
      return var1;
   }

   // $FF: renamed from: cq () com.google.android.gms.analytics.h
   public static class_643 method_3687() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cs () java.lang.String
   private String method_3688() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cu () void
   private void method_3689() {
      (new Thread("client_id_fetcher") {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      }).start();
   }

   // $FF: renamed from: r (android.content.Context) void
   public static void method_3690(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: J (java.lang.String) boolean
   public boolean method_3691(String var1) {
      return "&cid".equals(var1);
   }

   // $FF: renamed from: cr () java.lang.String
   String method_3692() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ct () java.lang.String
   protected String method_3693() {
      String var1 = UUID.randomUUID().toString().toLowerCase();

      try {
         if(this.method_3683(var1)) {
            return var1;
         }
      } catch (Exception var3) {
         return null;
      }

      var1 = "0";
      return var1;
   }

   // $FF: renamed from: cv () java.lang.String
   String method_3694() {
      // $FF: Couldn't be decompiled
   }

   public String getValue(String var1) {
      return "&cid".equals(var1)?this.method_3688():null;
   }
}
