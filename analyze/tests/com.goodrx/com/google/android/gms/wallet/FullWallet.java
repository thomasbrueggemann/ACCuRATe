package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.PaymentMethodToken;
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.zze;

public final class FullWallet implements SafeParcelable {
   public static final Creator<FullWallet> CREATOR = new zze();
   private final int mVersionCode;
   String zzboo;
   String zzbop;
   ProxyCard zzboq;
   String zzbor;
   Address zzbos;
   Address zzbot;
   String[] zzbou;
   UserAddress zzbov;
   UserAddress zzbow;
   InstrumentInfo[] zzbox;
   PaymentMethodToken zzboy;

   private FullWallet() {
      this.mVersionCode = 1;
   }

   FullWallet(int var1, String var2, String var3, ProxyCard var4, String var5, Address var6, Address var7, String[] var8, UserAddress var9, UserAddress var10, InstrumentInfo[] var11, PaymentMethodToken var12) {
      this.mVersionCode = var1;
      this.zzboo = var2;
      this.zzbop = var3;
      this.zzboq = var4;
      this.zzbor = var5;
      this.zzbos = var6;
      this.zzbot = var7;
      this.zzbou = var8;
      this.zzbov = var9;
      this.zzbow = var10;
      this.zzbox = var11;
      this.zzboy = var12;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
