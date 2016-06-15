package com.google.android.gms.tagmanager;

import android.net.Uri;

// $FF: renamed from: com.google.android.gms.tagmanager.ce
class class_619 {
   private static class_619 asm;
   private volatile String aqm;
   private volatile class_619.class_1644 asn;
   private volatile String aso;
   private volatile String asp;

   class_619() {
      this.clear();
   }

   // $FF: renamed from: cK (java.lang.String) java.lang.String
   private String method_3524(String var1) {
      return var1.split("&")[0].split("=")[1];
   }

   // $FF: renamed from: j (android.net.Uri) java.lang.String
   private String method_3525(Uri var1) {
      return var1.getQuery().replace("&gtm_debug=x", "");
   }

   // $FF: renamed from: qa () com.google.android.gms.tagmanager.ce
   static class_619 method_3526() {
      // $FF: Couldn't be decompiled
   }

   void clear() {
      this.asn = class_619.class_1644.asq;
      this.aso = null;
      this.aqm = null;
      this.asp = null;
   }

   String getContainerId() {
      return this.aqm;
   }

   // $FF: renamed from: i (android.net.Uri) boolean
   boolean method_3527(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: qb () com.google.android.gms.tagmanager.ce$a
   class_619.class_1644 method_3528() {
      return this.asn;
   }

   // $FF: renamed from: qc () java.lang.String
   String method_3529() {
      return this.aso;
   }

   static enum class_1644 {
      asq,
      asr,
      ass;

      static {
         class_619.class_1644[] var0 = new class_619.class_1644[]{asq, asr, ass};
      }
   }
}
