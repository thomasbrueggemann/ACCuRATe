package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.zzh;
import java.util.Arrays;

public class PlusSession implements SafeParcelable {
   public static final zzh CREATOR = new zzh();
   private final int mVersionCode;
   private final String zzVa;
   private final String zzada;
   private final String[] zzber;
   private final String[] zzbes;
   private final String[] zzbet;
   private final String zzbeu;
   private final String zzbev;
   private final String zzbew;
   private final PlusCommonExtras zzbex;

   PlusSession(int var1, String var2, String[] var3, String[] var4, String[] var5, String var6, String var7, String var8, String var9, PlusCommonExtras var10) {
      this.mVersionCode = var1;
      this.zzVa = var2;
      this.zzber = var3;
      this.zzbes = var4;
      this.zzbet = var5;
      this.zzbeu = var6;
      this.zzbev = var7;
      this.zzada = var8;
      this.zzbew = var9;
      this.zzbex = var10;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof PlusSession) {
         PlusSession var2 = (PlusSession)var1;
         if(this.mVersionCode == var2.mVersionCode && zzw.equal(this.zzVa, var2.zzVa) && Arrays.equals(this.zzber, var2.zzber) && Arrays.equals(this.zzbes, var2.zzbes) && Arrays.equals(this.zzbet, var2.zzbet) && zzw.equal(this.zzbeu, var2.zzbeu) && zzw.equal(this.zzbev, var2.zzbev) && zzw.equal(this.zzada, var2.zzada) && zzw.equal(this.zzbew, var2.zzbew) && zzw.equal(this.zzbex, var2.zzbex)) {
            return true;
         }
      }

      return false;
   }

   public String getAccountName() {
      return this.zzVa;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersionCode), this.zzVa, this.zzber, this.zzbes, this.zzbet, this.zzbeu, this.zzbev, this.zzada, this.zzbew, this.zzbex};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("accountName", this.zzVa).zzg("requestedScopes", this.zzber).zzg("visibleActivities", this.zzbes).zzg("requiredFeatures", this.zzbet).zzg("packageNameForAuth", this.zzbeu).zzg("callingPackageName", this.zzbev).zzg("applicationName", this.zzada).zzg("extra", this.zzbex.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public String[] zzFd() {
      return this.zzber;
   }

   public String[] zzFe() {
      return this.zzbes;
   }

   public String[] zzFf() {
      return this.zzbet;
   }

   public String zzFg() {
      return this.zzbeu;
   }

   public String zzFh() {
      return this.zzbev;
   }

   public String zzFi() {
      return this.zzbew;
   }

   public PlusCommonExtras zzFj() {
      return this.zzbex;
   }

   public String zznX() {
      return this.zzada;
   }
}
