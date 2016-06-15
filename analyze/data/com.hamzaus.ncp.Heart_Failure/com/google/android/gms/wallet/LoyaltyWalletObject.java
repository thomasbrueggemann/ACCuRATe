package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.class_718;
import com.google.android.gms.wallet.wobs.class_552;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
   public static final Creator<LoyaltyWalletObject> CREATOR = new class_718();
   String ajf;
   String ajg;
   String ajh;
   String aji;
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
   class_552 ajy;
   // $FF: renamed from: eC java.lang.String
   String field_2925;
   int state;
   // $FF: renamed from: xJ int
   private final int field_2926;

   LoyaltyWalletObject() {
      this.field_2926 = 4;
      this.ajo = class_291.method_1966();
      this.ajq = class_291.method_1966();
      this.ajt = class_291.method_1966();
      this.ajv = class_291.method_1966();
      this.ajw = class_291.method_1966();
      this.ajx = class_291.method_1966();
   }

   LoyaltyWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, ArrayList<p> var13, l var14, ArrayList<LatLng> var15, String var16, String var17, ArrayList<d> var18, boolean var19, ArrayList<n> var20, ArrayList<j> var21, ArrayList<n> var22, f var23) {
      this.field_2926 = var1;
      this.field_2925 = var2;
      this.ajf = var3;
      this.ajg = var4;
      this.ajh = var5;
      this.aji = var6;
      this.ajj = var7;
      this.ajk = var8;
      this.ajl = var9;
      this.ajm = var10;
      this.ajn = var11;
      this.state = var12;
      this.ajo = var13;
      this.ajp = var14;
      this.ajq = var15;
      this.ajr = var16;
      this.ajs = var17;
      this.ajt = var18;
      this.aju = var19;
      this.ajv = var20;
      this.ajw = var21;
      this.ajx = var22;
      this.ajy = var23;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountId() {
      return this.ajf;
   }

   public String getAccountName() {
      return this.aji;
   }

   public String getBarcodeAlternateText() {
      return this.ajj;
   }

   public String getBarcodeType() {
      return this.ajk;
   }

   public String getBarcodeValue() {
      return this.ajl;
   }

   public String getId() {
      return this.field_2925;
   }

   public String getIssuerName() {
      return this.ajg;
   }

   public String getProgramName() {
      return this.ajh;
   }

   public int getVersionCode() {
      return this.field_2926;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_718.method_4084(this, var1, var2);
   }
}
