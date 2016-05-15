package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzg;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
   public static final Creator<GiftCardWalletObject> CREATOR = new zzg();
   final int mVersionCode;
   String pin;
   CommonWalletObject zzboB = CommonWalletObject.zzIr().zzIs();
   String zzboC;
   String zzboD;
   long zzboE;
   String zzboF;
   long zzboG;
   String zzboH;

   GiftCardWalletObject() {
      this.mVersionCode = 1;
   }

   GiftCardWalletObject(int var1, CommonWalletObject var2, String var3, String var4, String var5, long var6, String var8, long var9, String var11) {
      this.mVersionCode = var1;
      this.zzboB = var2;
      this.zzboC = var3;
      this.pin = var4;
      this.zzboE = var6;
      this.zzboF = var8;
      this.zzboG = var9;
      this.zzboH = var11;
      this.zzboD = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
