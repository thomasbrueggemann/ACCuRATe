package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.class_408;
import com.google.android.gms.internal.class_439;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.cr;

// $FF: renamed from: com.google.android.gms.internal.cr
public final class class_407 implements SafeParcelable {
   public static final class_408 CREATOR = new class_408();
   // $FF: renamed from: kV com.google.android.gms.internal.dh
   public final class_50 field_1798;
   // $FF: renamed from: kX com.google.android.gms.internal.da
   public final class_439 field_1799;
   // $FF: renamed from: oR com.google.android.gms.internal.dc
   public final class_45 field_1800;
   // $FF: renamed from: oS android.content.Context
   public final Context field_1801;
   public final int versionCode;

   class_407(int var1, IBinder var2, IBinder var3, IBinder var4, IBinder var5) {
      this.versionCode = var1;
      this.field_1798 = (class_50)class_741.method_4177(class_157.class_1317.method_4176(var2));
      this.field_1799 = (class_439)class_741.method_4177(class_157.class_1317.method_4176(var3));
      this.field_1800 = (class_45)class_741.method_4177(class_157.class_1317.method_4176(var4));
      this.field_1801 = (Context)class_741.method_4177(class_157.class_1317.method_4176(var5));
   }

   public class_407(class_45 var1, class_50 var2, class_439 var3, Context var4) {
      this.versionCode = 1;
      this.field_1800 = var1;
      this.field_1798 = var2;
      this.field_1799 = var3;
      this.field_1801 = var4;
   }

   // $FF: renamed from: a (android.content.Intent, com.google.android.gms.internal.cr) void
   public static void method_2508(Intent var0, class_407 var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var1);
      var0.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var2);
   }

   // $FF: renamed from: b (android.content.Intent) com.google.android.gms.internal.cr
   public static class_407 method_2509(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         var2.setClassLoader(cr.class.getClassLoader());
         class_407 var3 = (class_407)var2.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: renamed from: aY () android.os.IBinder
   IBinder method_2510() {
      return class_741.method_4178(this.field_1798).asBinder();
   }

   // $FF: renamed from: aZ () android.os.IBinder
   IBinder method_2511() {
      return class_741.method_4178(this.field_1799).asBinder();
   }

   // $FF: renamed from: ba () android.os.IBinder
   IBinder method_2512() {
      return class_741.method_4178(this.field_1800).asBinder();
   }

   // $FF: renamed from: bb () android.os.IBinder
   IBinder method_2513() {
      return class_741.method_4178(this.field_1801).asBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_408.method_2514(this, var1, var2);
   }
}
