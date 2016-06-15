package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.class_559;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
   public static final Creator<CommonWalletObject> CREATOR = new class_559();
   String ajg;
   String ajj;
   String ajk;
   String ajl;
   String ajm;
   String ajn;
   ArrayList<p> ajo;
   class_566 ajp;
   ArrayList<LatLng> ajq;
   String ajr;
   String ajs;
   ArrayList<d> ajt;
   boolean aju;
   ArrayList<n> ajv;
   ArrayList<j> ajw;
   ArrayList<n> ajx;
   // $FF: renamed from: eC java.lang.String
   String field_4279;
   String name;
   int state;
   // $FF: renamed from: xJ int
   private final int field_4280;

   CommonWalletObject() {
      this.field_4280 = 1;
      this.ajo = class_291.method_1966();
      this.ajq = class_291.method_1966();
      this.ajt = class_291.method_1966();
      this.ajv = class_291.method_1966();
      this.ajw = class_291.method_1966();
      this.ajx = class_291.method_1966();
   }

   CommonWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, ArrayList<p> var11, l var12, ArrayList<LatLng> var13, String var14, String var15, ArrayList<d> var16, boolean var17, ArrayList<n> var18, ArrayList<j> var19, ArrayList<n> var20) {
      this.field_4280 = var1;
      this.field_4279 = var2;
      this.ajn = var3;
      this.name = var4;
      this.ajg = var5;
      this.ajj = var6;
      this.ajk = var7;
      this.ajl = var8;
      this.ajm = var9;
      this.state = var10;
      this.ajo = var11;
      this.ajp = var12;
      this.ajq = var13;
      this.ajr = var14;
      this.ajs = var15;
      this.ajt = var16;
      this.aju = var17;
      this.ajv = var18;
      this.ajw = var19;
      this.ajx = var20;
   }

   // $FF: renamed from: nf () com.google.android.gms.wallet.wobs.CommonWalletObject$a
   public static CommonWalletObject.class_962 method_4510() {
      CommonWalletObject var0 = new CommonWalletObject();
      return var0.new class_962();
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.field_4279;
   }

   public int getVersionCode() {
      return this.field_4280;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_559.method_3148(this, var1, var2);
   }

   public final class class_962 {
      private class_962() {
      }

      // $FF: synthetic method
      class_962(Object var2) {
         this();
      }

      // $FF: renamed from: cw (java.lang.String) com.google.android.gms.wallet.wobs.CommonWalletObject$a
      public CommonWalletObject.class_962 method_2744(String var1) {
         CommonWalletObject.this.field_4279 = var1;
         return this;
      }

      // $FF: renamed from: ng () com.google.android.gms.wallet.wobs.CommonWalletObject
      public CommonWalletObject method_2745() {
         return CommonWalletObject.this;
      }
   }
}
