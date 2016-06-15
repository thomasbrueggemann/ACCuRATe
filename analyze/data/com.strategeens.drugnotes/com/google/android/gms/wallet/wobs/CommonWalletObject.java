package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_724;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.class_661;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
   public static final Creator<CommonWalletObject> CREATOR = new class_661();
   // $FF: renamed from: CK int
   private final int field_4430;
   String ave;
   String avg;
   String avh;
   String avi;
   String avj;
   String avk;
   ArrayList<p> avl;
   class_668 avm;
   ArrayList<LatLng> avn;
   String avo;
   String avp;
   ArrayList<d> avq;
   boolean avr;
   ArrayList<n> avs;
   ArrayList<j> avt;
   ArrayList<n> avu;
   // $FF: renamed from: fl java.lang.String
   String field_4431;
   String name;
   int state;

   CommonWalletObject() {
      this.field_4430 = 1;
      this.avl = class_724.method_4217();
      this.avn = class_724.method_4217();
      this.avq = class_724.method_4217();
      this.avs = class_724.method_4217();
      this.avt = class_724.method_4217();
      this.avu = class_724.method_4217();
   }

   CommonWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, ArrayList<p> var11, l var12, ArrayList<LatLng> var13, String var14, String var15, ArrayList<d> var16, boolean var17, ArrayList<n> var18, ArrayList<j> var19, ArrayList<n> var20) {
      this.field_4430 = var1;
      this.field_4431 = var2;
      this.avk = var3;
      this.name = var4;
      this.ave = var5;
      this.avg = var6;
      this.avh = var7;
      this.avi = var8;
      this.avj = var9;
      this.state = var10;
      this.avl = var11;
      this.avm = var12;
      this.avn = var13;
      this.avo = var14;
      this.avp = var15;
      this.avq = var16;
      this.avr = var17;
      this.avs = var18;
      this.avt = var19;
      this.avu = var20;
   }

   // $FF: renamed from: rh () com.google.android.gms.wallet.wobs.CommonWalletObject$a
   public static CommonWalletObject.class_1266 method_5770() {
      CommonWalletObject var0 = new CommonWalletObject();
      return var0.new class_1266();
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.field_4431;
   }

   public int getVersionCode() {
      return this.field_4430;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_661.method_3781(this, var1, var2);
   }

   public final class class_1266 {
      private class_1266() {
      }

      // $FF: synthetic method
      class_1266(Object var2) {
         this();
      }

      // $FF: renamed from: dh (java.lang.String) com.google.android.gms.wallet.wobs.CommonWalletObject$a
      public CommonWalletObject.class_1266 method_3222(String var1) {
         CommonWalletObject.this.field_4431 = var1;
         return this;
      }

      // $FF: renamed from: ri () com.google.android.gms.wallet.wobs.CommonWalletObject
      public CommonWalletObject method_3223() {
         return CommonWalletObject.this;
      }
   }
}
