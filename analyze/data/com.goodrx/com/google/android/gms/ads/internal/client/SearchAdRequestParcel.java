package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.zzam;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class SearchAdRequestParcel implements SafeParcelable {
   public static final zzam CREATOR = new zzam();
   public final int backgroundColor;
   public final int versionCode;
   public final int zzvd;
   public final int zzve;
   public final int zzvf;
   public final int zzvg;
   public final int zzvh;
   public final int zzvi;
   public final int zzvj;
   public final String zzvk;
   public final int zzvl;
   public final String zzvm;
   public final int zzvn;
   public final int zzvo;
   public final String zzvp;

   SearchAdRequestParcel(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, String var10, int var11, String var12, int var13, int var14, String var15) {
      this.versionCode = var1;
      this.zzvd = var2;
      this.backgroundColor = var3;
      this.zzve = var4;
      this.zzvf = var5;
      this.zzvg = var6;
      this.zzvh = var7;
      this.zzvi = var8;
      this.zzvj = var9;
      this.zzvk = var10;
      this.zzvl = var11;
      this.zzvm = var12;
      this.zzvn = var13;
      this.zzvo = var14;
      this.zzvp = var15;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzam.zza(this, var1, var2);
   }
}
