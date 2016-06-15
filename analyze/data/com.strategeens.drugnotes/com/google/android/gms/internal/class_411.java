package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_36;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_467;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ea
@ey
public final class class_411 implements SafeParcelable {
   public static final class_467 CREATOR = new class_467();
   // $FF: renamed from: md com.google.android.gms.internal.ek
   public final class_415 field_1276;
   // $FF: renamed from: sA android.content.Context
   public final Context field_1277;
   // $FF: renamed from: sB com.google.android.gms.internal.ej
   public final class_36 field_1278;
   // $FF: renamed from: sz com.google.android.gms.internal.em
   public final class_32 field_1279;
   public final int versionCode;

   class_411(int var1, IBinder var2, IBinder var3, IBinder var4, IBinder var5) {
      this.versionCode = var1;
      this.field_1276 = (class_415)class_960.method_5292(class_198.class_1672.method_5291(var2));
      this.field_1279 = (class_32)class_960.method_5292(class_198.class_1672.method_5291(var3));
      this.field_1277 = (Context)class_960.method_5292(class_198.class_1672.method_5291(var4));
      this.field_1278 = (class_36)class_960.method_5292(class_198.class_1672.method_5291(var5));
   }

   public class_411(Context var1, class_415 var2, class_32 var3, class_36 var4) {
      this.versionCode = 2;
      this.field_1277 = var1;
      this.field_1276 = var2;
      this.field_1279 = var3;
      this.field_1278 = var4;
   }

   // $FF: renamed from: a (android.content.Intent, com.google.android.gms.internal.ea) void
   public static void method_2726(Intent var0, class_411 var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var1);
      var0.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var2);
   }

   // $FF: renamed from: c (android.content.Intent) com.google.android.gms.internal.ea
   public static class_411 method_2727(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         var2.setClassLoader(ea.class.getClassLoader());
         class_411 var3 = (class_411)var2.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: renamed from: ct () android.os.IBinder
   IBinder method_2728() {
      return class_960.method_5293(this.field_1278).asBinder();
   }

   // $FF: renamed from: cu () android.os.IBinder
   IBinder method_2729() {
      return class_960.method_5293(this.field_1276).asBinder();
   }

   // $FF: renamed from: cv () android.os.IBinder
   IBinder method_2730() {
      return class_960.method_5293(this.field_1279).asBinder();
   }

   // $FF: renamed from: cw () android.os.IBinder
   IBinder method_2731() {
      return class_960.method_5293(this.field_1277).asBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_467.method_2972(this, var1, var2);
   }
}
