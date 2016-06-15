package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.class_819;

// $FF: renamed from: com.google.android.gms.internal.oo
public class class_820 implements class_819.class_1659 {
   private final class_819 amS;
   private boolean amT;

   public class_820(Context var1, int var2) {
      this(var1, var2, (String)null);
   }

   public class_820(Context var1, int var2, String var3) {
      this(var1, var2, var3, (String)null, true);
   }

   public class_820(Context var1, int var2, String var3, String var4, boolean var5) {
      this.amS = new class_819(var1, var2, var3, var4, this, var5);
      this.amT = true;
   }

   // $FF: renamed from: om () void
   private void method_4476() {
      if(!this.amT) {
         throw new IllegalStateException("Cannot reuse one-time logger after sending.");
      }
   }

   // $FF: renamed from: a (java.lang.String, byte[], java.lang.String[]) void
   public void method_4477(String var1, byte[] var2, String... var3) {
      this.method_4476();
      this.amS.method_4475(var1, var2, var3);
   }

   // $FF: renamed from: d (android.app.PendingIntent) void
   public void method_921(PendingIntent var1) {
      Log.w("OneTimePlayLogger", "logger connection failed: " + var1);
   }

   // $FF: renamed from: on () void
   public void method_922() {
      this.amS.stop();
   }

   // $FF: renamed from: oo () void
   public void method_923() {
      Log.w("OneTimePlayLogger", "logger connection failed");
   }

   public void send() {
      this.method_4476();
      this.amS.start();
      this.amT = false;
   }
}
