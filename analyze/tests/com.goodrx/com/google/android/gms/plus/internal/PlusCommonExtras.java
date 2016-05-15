package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.internal.zzf;

@KeepName
public class PlusCommonExtras implements SafeParcelable {
   public static final zzf CREATOR = new zzf();
   private final int mVersionCode;
   private String zzbeo;
   private String zzbep;

   public PlusCommonExtras() {
      this.mVersionCode = 1;
      this.zzbeo = "";
      this.zzbep = "";
   }

   PlusCommonExtras(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzbeo = var2;
      this.zzbep = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof PlusCommonExtras) {
         PlusCommonExtras var2 = (PlusCommonExtras)var1;
         if(this.mVersionCode == var2.mVersionCode && zzw.equal(this.zzbeo, var2.zzbeo) && zzw.equal(this.zzbep, var2.zzbep)) {
            return true;
         }
      }

      return false;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersionCode), this.zzbeo, this.zzbep};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzbeo).zzg("ClientCallingPackage", this.zzbep).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public String zzFb() {
      return this.zzbeo;
   }

   public String zzFc() {
      return this.zzbep;
   }
}
