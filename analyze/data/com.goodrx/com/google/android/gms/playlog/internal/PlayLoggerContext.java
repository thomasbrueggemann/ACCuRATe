package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.playlog.internal.zze;

public class PlayLoggerContext implements SafeParcelable {
   public static final zze CREATOR = new zze();
   public final String packageName;
   public final int versionCode;
   public final int zzbdL;
   public final int zzbdM;
   public final String zzbdN;
   public final String zzbdO;
   public final boolean zzbdP;
   public final String zzbdQ;
   public final boolean zzbdR;
   public final int zzbdS;

   public PlayLoggerContext(int var1, String var2, int var3, int var4, String var5, String var6, boolean var7, String var8, boolean var9, int var10) {
      this.versionCode = var1;
      this.packageName = var2;
      this.zzbdL = var3;
      this.zzbdM = var4;
      this.zzbdN = var5;
      this.zzbdO = var6;
      this.zzbdP = var7;
      this.zzbdQ = var8;
      this.zzbdR = var9;
      this.zzbdS = var10;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlayLoggerContext)) {
            return false;
         }

         PlayLoggerContext var2 = (PlayLoggerContext)var1;
         if(this.versionCode != var2.versionCode || !this.packageName.equals(var2.packageName) || this.zzbdL != var2.zzbdL || this.zzbdM != var2.zzbdM || !zzw.equal(this.zzbdQ, var2.zzbdQ) || !zzw.equal(this.zzbdN, var2.zzbdN) || !zzw.equal(this.zzbdO, var2.zzbdO) || this.zzbdP != var2.zzbdP || this.zzbdR != var2.zzbdR || this.zzbdS != var2.zzbdS) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzbdL), Integer.valueOf(this.zzbdM), this.zzbdQ, this.zzbdN, this.zzbdO, Boolean.valueOf(this.zzbdP), Boolean.valueOf(this.zzbdR), Integer.valueOf(this.zzbdS)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("PlayLoggerContext[");
      var1.append("versionCode=").append(this.versionCode).append(',');
      var1.append("package=").append(this.packageName).append(',');
      var1.append("packageVersionCode=").append(this.zzbdL).append(',');
      var1.append("logSource=").append(this.zzbdM).append(',');
      var1.append("logSourceName=").append(this.zzbdQ).append(',');
      var1.append("uploadAccount=").append(this.zzbdN).append(',');
      var1.append("loggingId=").append(this.zzbdO).append(',');
      var1.append("logAndroidId=").append(this.zzbdP).append(',');
      var1.append("isAnonymous=").append(this.zzbdR).append(',');
      var1.append("qosTier=").append(this.zzbdS);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
