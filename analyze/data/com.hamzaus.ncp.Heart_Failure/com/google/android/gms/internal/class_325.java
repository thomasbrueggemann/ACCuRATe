package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.class_24;
import com.google.android.gms.internal.class_324;
import com.google.android.gms.internal.class_332;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.gh
public abstract class class_325 {
   // $FF: renamed from: BA com.google.android.gms.internal.go
   protected final class_324 field_1307;
   // $FF: renamed from: BB java.lang.String
   private final String field_1308;
   // $FF: renamed from: BC com.google.android.gms.internal.gq
   private class_24 field_1309;

   protected class_325(String var1, String var2, String var3) {
      class_332.method_2118(var1);
      this.field_1308 = var1;
      this.field_1307 = new class_324(var2);
      if(!TextUtils.isEmpty(var3)) {
         this.field_1307.method_2065(var3);
      }

   }

   // $FF: renamed from: a (long, int) void
   public void method_2071(long var1, int var3) {
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gq) void
   public final void method_2072(class_24 var1) {
      this.field_1309 = var1;
      if(this.field_1309 == null) {
         this.method_2076();
      }

   }

   // $FF: renamed from: a (java.lang.String, long, java.lang.String) void
   protected final void method_2073(String var1, long var2, String var4) throws IOException {
      this.field_1307.method_2063("Sending text message: %s to: %s", new Object[]{var1, var4});
      this.field_1309.method_106(this.field_1308, var1, var2, var4);
   }

   // $FF: renamed from: ai (java.lang.String) void
   public void method_2074(String var1) {
   }

   // $FF: renamed from: dY () long
   protected final long method_2075() {
      return this.field_1309.method_107();
   }

   // $FF: renamed from: dZ () void
   public void method_2076() {
   }

   public final String getNamespace() {
      return this.field_1308;
   }
}
