package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_319;
import com.google.android.gms.internal.class_322;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.il
public abstract class class_320 {
   // $FF: renamed from: He com.google.android.gms.internal.is
   protected final class_319 field_793;
   // $FF: renamed from: Hf java.lang.String
   private final String field_794;
   // $FF: renamed from: Hg com.google.android.gms.internal.iu
   private class_12 field_795;

   protected class_320(String var1, String var2, String var3) {
      class_322.method_2263(var1);
      this.field_794 = var1;
      this.field_793 = new class_319(var2);
      if(!TextUtils.isEmpty(var3)) {
         this.field_793.method_2232(var3);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.iu) void
   public final void method_2239(class_12 var1) {
      this.field_795 = var1;
      if(this.field_795 == null) {
         this.method_2244();
      }

   }

   // $FF: renamed from: a (java.lang.String, long, java.lang.String) void
   protected final void method_2240(String var1, long var2, String var4) throws IOException {
      this.field_793.method_2230("Sending text message: %s to: %s", new Object[]{var1, var4});
      this.field_795.method_82(this.field_794, var1, var2, var4);
   }

   // $FF: renamed from: aD (java.lang.String) void
   public void method_2241(String var1) {
   }

   // $FF: renamed from: b (long, int) void
   public void method_2242(long var1, int var3) {
   }

   // $FF: renamed from: fU () long
   protected final long method_2243() {
      return this.field_795.method_83();
   }

   // $FF: renamed from: fV () void
   public void method_2244() {
   }

   public final String getNamespace() {
      return this.field_794;
   }
}
