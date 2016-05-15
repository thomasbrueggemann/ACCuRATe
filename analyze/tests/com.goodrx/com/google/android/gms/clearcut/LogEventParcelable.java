package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.clearcut.zzd;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
   public static final zzd CREATOR = new zzd();
   public final int versionCode;
   public PlayLoggerContext zzafh;
   public byte[] zzafi;
   public int[] zzafj;
   public final zzsz.zzd zzafk;
   public final zzb.zzb zzafl;
   public final zzb.zzb zzafm;

   LogEventParcelable(int var1, PlayLoggerContext var2, byte[] var3, int[] var4) {
      this.versionCode = var1;
      this.zzafh = var2;
      this.zzafi = var3;
      this.zzafj = var4;
      this.zzafk = null;
      this.zzafl = null;
      this.zzafm = null;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LogEventParcelable)) {
            return false;
         }

         LogEventParcelable var2 = (LogEventParcelable)var1;
         if(this.versionCode != var2.versionCode || !zzw.equal(this.zzafh, var2.zzafh) || !Arrays.equals(this.zzafi, var2.zzafi) || !Arrays.equals(this.zzafj, var2.zzafj) || !zzw.equal(this.zzafk, var2.zzafk) || !zzw.equal(this.zzafl, var2.zzafl) || !zzw.equal(this.zzafm, var2.zzafm)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.versionCode), this.zzafh, this.zzafi, this.zzafj, this.zzafk, this.zzafl, this.zzafm};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LogEventParcelable[");
      var1.append(this.versionCode);
      var1.append(", ");
      var1.append(this.zzafh);
      var1.append(", ");
      String var6;
      if(this.zzafi == null) {
         var6 = null;
      } else {
         var6 = new String(this.zzafi);
      }

      var1.append(var6);
      var1.append(", ");
      String var11;
      if(this.zzafj == null) {
         var11 = (String)null;
      } else {
         zzv var9 = zzv.zzcL(", ");
         int[][] var10 = new int[][]{this.zzafj};
         var11 = var9.zza(Arrays.asList(var10));
      }

      var1.append(var11);
      var1.append(", ");
      var1.append(this.zzafk);
      var1.append(", ");
      var1.append(this.zzafl);
      var1.append(", ");
      var1.append(this.zzafm);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
