package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zza;

@Deprecated
public final class Address implements SafeParcelable {
   public static final Creator<Address> CREATOR = new zza();
   private final int mVersionCode;
   String name;
   String phoneNumber;
   String zzJU;
   String zzaMD;
   String zzaME;
   String zzaMF;
   String zzaMK;
   boolean zzaMM;
   String zzaMN;
   String zzbof;
   String zzbog;

   Address() {
      this.mVersionCode = 1;
   }

   Address(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, boolean var11, String var12) {
      this.mVersionCode = var1;
      this.name = var2;
      this.zzaMD = var3;
      this.zzaME = var4;
      this.zzaMF = var5;
      this.zzJU = var6;
      this.zzbof = var7;
      this.zzbog = var8;
      this.zzaMK = var9;
      this.phoneNumber = var10;
      this.zzaMM = var11;
      this.zzaMN = var12;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
