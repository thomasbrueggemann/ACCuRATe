package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_172;
import com.google.android.gms.analytics.class_863;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// $FF: renamed from: com.google.android.gms.analytics.k
class class_843 implements class_172 {
   // $FF: renamed from: xO java.lang.Object
   private static final Object field_3497 = new Object();
   // $FF: renamed from: yD com.google.android.gms.analytics.k
   private static class_843 field_3498;
   private final Context mContext;
   // $FF: renamed from: yE java.lang.String
   private String field_3499;
   // $FF: renamed from: yF boolean
   private boolean field_3500 = false;
   // $FF: renamed from: yG java.lang.Object
   private final Object field_3501 = new Object();

   protected class_843(Context var1) {
      this.mContext = var1;
      this.method_4655();
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.k) java.lang.Object
   // $FF: synthetic method
   static Object method_4649(class_843 var0) {
      return var0.field_3501;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.k, java.lang.String) java.lang.String
   // $FF: synthetic method
   static String method_4650(class_843 var0, String var1) {
      var0.field_3499 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.k, boolean) boolean
   // $FF: synthetic method
   static boolean method_4651(class_843 var0, boolean var1) {
      var0.field_3500 = var1;
      return var1;
   }

   // $FF: renamed from: ae (java.lang.String) boolean
   private boolean method_4652(String var1) {
      try {
         class_863.method_4841("Storing clientId.");
         FileOutputStream var4 = this.mContext.openFileOutput("gaClientId", 0);
         var4.write(var1.getBytes());
         var4.close();
         return true;
      } catch (FileNotFoundException var5) {
         class_863.method_4839("Error creating clientId file.");
         return false;
      } catch (IOException var6) {
         class_863.method_4839("Error writing to clientId file.");
         return false;
      }
   }

   // $FF: renamed from: el () com.google.android.gms.analytics.k
   public static class_843 method_4653() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: en () java.lang.String
   private String method_4654() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ep () void
   private void method_4655() {
      (new Thread("client_id_fetcher") {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      }).start();
   }

   // $FF: renamed from: y (android.content.Context) void
   public static void method_4656(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ac (java.lang.String) boolean
   public boolean method_4657(String var1) {
      return "&cid".equals(var1);
   }

   // $FF: renamed from: em () java.lang.String
   String method_4658() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eo () java.lang.String
   protected String method_4659() {
      String var1 = UUID.randomUUID().toString().toLowerCase();

      try {
         if(this.method_4652(var1)) {
            return var1;
         }
      } catch (Exception var3) {
         return null;
      }

      var1 = "0";
      return var1;
   }

   // $FF: renamed from: eq () java.lang.String
   String method_4660() {
      // $FF: Couldn't be decompiled
   }

   public String getValue(String var1) {
      return "&cid".equals(var1)?this.method_4654():null;
   }
}
