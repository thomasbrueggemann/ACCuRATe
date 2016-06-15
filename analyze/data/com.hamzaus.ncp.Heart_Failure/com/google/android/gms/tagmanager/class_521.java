package com.google.android.gms.tagmanager;

import android.net.Uri;

// $FF: renamed from: com.google.android.gms.tagmanager.cd
class class_521 {
   private static class_521 agu;
   private volatile String aeq;
   private volatile class_521.class_1311 agv;
   private volatile String agw;
   private volatile String agx;

   class_521() {
      this.clear();
   }

   // $FF: renamed from: ca (java.lang.String) java.lang.String
   private String method_2946(String var1) {
      return var1.split("&")[0].split("=")[1];
   }

   // $FF: renamed from: i (android.net.Uri) java.lang.String
   private String method_2947(Uri var1) {
      return var1.getQuery().replace("&gtm_debug=x", "");
   }

   // $FF: renamed from: lY () com.google.android.gms.tagmanager.cd
   static class_521 method_2948() {
      // $FF: Couldn't be decompiled
   }

   void clear() {
      this.agv = class_521.class_1311.agy;
      this.agw = null;
      this.aeq = null;
      this.agx = null;
   }

   String getContainerId() {
      return this.aeq;
   }

   // $FF: renamed from: h (android.net.Uri) boolean
   boolean method_2949(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: lZ () com.google.android.gms.tagmanager.cd$a
   class_521.class_1311 method_2950() {
      return this.agv;
   }

   // $FF: renamed from: ma () java.lang.String
   String method_2951() {
      return this.agw;
   }

   static enum class_1311 {
      agA,
      agy,
      agz;

      static {
         class_521.class_1311[] var0 = new class_521.class_1311[]{agy, agz, agA};
      }
   }
}
