package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.zzb;

public final class UserAddress implements SafeParcelable {
   public static final Creator<UserAddress> CREATOR = new zzb();
   private final int mVersionCode;
   String name;
   String phoneNumber;
   String zzJU;
   String zzaMD;
   String zzaME;
   String zzaMF;
   String zzaMG;
   String zzaMH;
   String zzaMI;
   String zzaMJ;
   String zzaMK;
   String zzaML;
   boolean zzaMM;
   String zzaMN;
   String zzaMO;

   UserAddress() {
      this.mVersionCode = 1;
   }

   UserAddress(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, boolean var14, String var15, String var16) {
      this.mVersionCode = var1;
      this.name = var2;
      this.zzaMD = var3;
      this.zzaME = var4;
      this.zzaMF = var5;
      this.zzaMG = var6;
      this.zzaMH = var7;
      this.zzaMI = var8;
      this.zzaMJ = var9;
      this.zzJU = var10;
      this.zzaMK = var11;
      this.zzaML = var12;
      this.phoneNumber = var13;
      this.zzaMM = var14;
      this.zzaMN = var15;
      this.zzaMO = var16;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
