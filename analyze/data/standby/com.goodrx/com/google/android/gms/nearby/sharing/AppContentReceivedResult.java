package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.zza;

public class AppContentReceivedResult implements SafeParcelable {
   public static final Creator<AppContentReceivedResult> CREATOR = new zza();
   private int statusCode;
   private final int versionCode;
   private Uri zzbde;

   private AppContentReceivedResult() {
      this.versionCode = 1;
   }

   AppContentReceivedResult(int var1, Uri var2, int var3) {
      this.versionCode = var1;
      this.zzbde = var2;
      this.statusCode = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AppContentReceivedResult)) {
            return false;
         }

         AppContentReceivedResult var2 = (AppContentReceivedResult)var1;
         if(!zzw.equal(this.zzbde, var2.zzbde) || !zzw.equal(Integer.valueOf(this.statusCode), Integer.valueOf(var2.statusCode))) {
            return false;
         }
      }

      return true;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbde, Integer.valueOf(this.statusCode)};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public Uri zzEJ() {
      return this.zzbde;
   }
}
