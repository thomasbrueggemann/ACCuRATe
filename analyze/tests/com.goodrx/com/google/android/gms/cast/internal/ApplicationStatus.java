package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ApplicationStatus implements SafeParcelable {
   public static final Creator<ApplicationStatus> CREATOR = new zza();
   private final int mVersionCode;
   private String zzadp;

   public ApplicationStatus() {
      this(1, (String)null);
   }

   ApplicationStatus(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzadp = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ApplicationStatus)) {
         return false;
      } else {
         ApplicationStatus var2 = (ApplicationStatus)var1;
         return zzf.zza(this.zzadp, var2.zzadp);
      }
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzadp};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public String zzoe() {
      return this.zzadp;
   }
}
