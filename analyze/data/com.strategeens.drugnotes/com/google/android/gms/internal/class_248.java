package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.bm
@ey
public final class class_248 {
   // $FF: renamed from: pd java.lang.String
   private String field_504 = null;
   // $FF: renamed from: pe java.lang.String
   private String field_505 = null;
   // $FF: renamed from: pf java.lang.String
   private String field_506 = null;
   // $FF: renamed from: pg java.lang.String
   private String field_507 = null;

   public class_248() {
      this.field_504 = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
      this.field_505 = null;
      this.field_506 = null;
      this.field_507 = null;
   }

   public class_248(String var1, String var2, String var3, String var4) {
      if(TextUtils.isEmpty(var1)) {
         this.field_504 = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
      } else {
         this.field_504 = var1;
      }

      this.field_505 = var2;
      this.field_506 = var3;
      this.field_507 = var4;
   }

   // $FF: renamed from: bu () java.lang.String
   public String method_1627() {
      return this.field_504;
   }

   // $FF: renamed from: bv () java.lang.String
   public String method_1628() {
      return this.field_505;
   }

   // $FF: renamed from: bw () java.lang.String
   public String method_1629() {
      return this.field_506;
   }

   // $FF: renamed from: bx () java.lang.String
   public String method_1630() {
      return this.field_507;
   }
}
