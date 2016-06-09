package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.android.gms.wallet.zzm;
import java.util.ArrayList;

public final class MaskedWalletRequest implements SafeParcelable {
   public static final Creator<MaskedWalletRequest> CREATOR = new zzm();
   private final int mVersionCode;
   String zzboi;
   String zzbop;
   Cart zzboz;
   boolean zzbpl;
   boolean zzbpm;
   boolean zzbpn;
   String zzbpo;
   String zzbpp;
   boolean zzbpq;
   boolean zzbpr;
   CountrySpecification[] zzbps;
   boolean zzbpt;
   boolean zzbpu;
   ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> zzbpv;
   PaymentMethodTokenizationParameters zzbpw;
   ArrayList<Integer> zzbpx;

   MaskedWalletRequest() {
      this.mVersionCode = 3;
      this.zzbpt = true;
      this.zzbpu = true;
   }

   MaskedWalletRequest(int var1, String var2, boolean var3, boolean var4, boolean var5, String var6, String var7, String var8, Cart var9, boolean var10, boolean var11, CountrySpecification[] var12, boolean var13, boolean var14, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> var15, PaymentMethodTokenizationParameters var16, ArrayList<Integer> var17) {
      this.mVersionCode = var1;
      this.zzbop = var2;
      this.zzbpl = var3;
      this.zzbpm = var4;
      this.zzbpn = var5;
      this.zzbpo = var6;
      this.zzboi = var7;
      this.zzbpp = var8;
      this.zzboz = var9;
      this.zzbpq = var10;
      this.zzbpr = var11;
      this.zzbps = var12;
      this.zzbpt = var13;
      this.zzbpu = var14;
      this.zzbpv = var15;
      this.zzbpw = var16;
      this.zzbpx = var17;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }
}
