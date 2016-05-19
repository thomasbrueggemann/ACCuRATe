package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.List;

@zzhb
public final class AdRequestParcel implements SafeParcelable {
   public static final zzg CREATOR = new zzg();
   public final Bundle extras;
   public final int versionCode;
   public final long zztC;
   public final int zztD;
   public final List<String> zztE;
   public final boolean zztF;
   public final int zztG;
   public final boolean zztH;
   public final String zztI;
   public final SearchAdRequestParcel zztJ;
   public final Location zztK;
   public final String zztL;
   public final Bundle zztM;
   public final Bundle zztN;
   public final List<String> zztO;
   public final String zztP;
   public final String zztQ;
   public final boolean zztR;

   public AdRequestParcel(int var1, long var2, Bundle var4, int var5, List<String> var6, boolean var7, int var8, boolean var9, String var10, SearchAdRequestParcel var11, Location var12, String var13, Bundle var14, Bundle var15, List<String> var16, String var17, String var18, boolean var19) {
      this.versionCode = var1;
      this.zztC = var2;
      if(var4 == null) {
         var4 = new Bundle();
      }

      this.extras = var4;
      this.zztD = var5;
      this.zztE = var6;
      this.zztF = var7;
      this.zztG = var8;
      this.zztH = var9;
      this.zztI = var10;
      this.zztJ = var11;
      this.zztK = var12;
      this.zztL = var13;
      this.zztM = var14;
      this.zztN = var15;
      this.zztO = var16;
      this.zztP = var17;
      this.zztQ = var18;
      this.zztR = var19;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof AdRequestParcel) {
         AdRequestParcel var2 = (AdRequestParcel)var1;
         if(this.versionCode == var2.versionCode && this.zztC == var2.zztC && com.google.android.gms.common.internal.zzw.equal(this.extras, var2.extras) && this.zztD == var2.zztD && com.google.android.gms.common.internal.zzw.equal(this.zztE, var2.zztE) && this.zztF == var2.zztF && this.zztG == var2.zztG && this.zztH == var2.zztH && com.google.android.gms.common.internal.zzw.equal(this.zztI, var2.zztI) && com.google.android.gms.common.internal.zzw.equal(this.zztJ, var2.zztJ) && com.google.android.gms.common.internal.zzw.equal(this.zztK, var2.zztK) && com.google.android.gms.common.internal.zzw.equal(this.zztL, var2.zztL) && com.google.android.gms.common.internal.zzw.equal(this.zztM, var2.zztM) && com.google.android.gms.common.internal.zzw.equal(this.zztN, var2.zztN) && com.google.android.gms.common.internal.zzw.equal(this.zztO, var2.zztO) && com.google.android.gms.common.internal.zzw.equal(this.zztP, var2.zztP) && com.google.android.gms.common.internal.zzw.equal(this.zztQ, var2.zztQ) && this.zztR == var2.zztR) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.versionCode), Long.valueOf(this.zztC), this.extras, Integer.valueOf(this.zztD), this.zztE, Boolean.valueOf(this.zztF), Integer.valueOf(this.zztG), Boolean.valueOf(this.zztH), this.zztI, this.zztJ, this.zztK, this.zztL, this.zztM, this.zztN, this.zztO, this.zztP, this.zztQ, Boolean.valueOf(this.zztR)};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
