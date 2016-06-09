package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.zzd;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
   public static final Creator<LaunchOptions> CREATOR = new zzd();
   private final int mVersionCode;
   private boolean zzaaK;
   private String zzaaL;

   public LaunchOptions() {
      this(1, false, zzf.zzb(Locale.getDefault()));
   }

   LaunchOptions(int var1, boolean var2, String var3) {
      this.mVersionCode = var1;
      this.zzaaK = var2;
      this.zzaaL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof LaunchOptions)) {
            return false;
         }

         LaunchOptions var2 = (LaunchOptions)var1;
         if(this.zzaaK != var2.zzaaK || !zzf.zza(this.zzaaL, var2.zzaaL)) {
            return false;
         }
      }

      return true;
   }

   public String getLanguage() {
      return this.zzaaL;
   }

   public boolean getRelaunchIfRunning() {
      return this.zzaaK;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.zzaaK), this.zzaaL};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.zzaaK), this.zzaaL};
      return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
