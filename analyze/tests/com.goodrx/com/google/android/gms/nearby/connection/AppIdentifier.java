package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.zza;

public final class AppIdentifier implements SafeParcelable {
   public static final Creator<AppIdentifier> CREATOR = new zza();
   private final int mVersionCode;
   private final String zzaxk;

   AppIdentifier(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzaxk = zzx.zzh(var2, "Missing application identifier value");
   }

   public int describeContents() {
      return 0;
   }

   public String getIdentifier() {
      return this.zzaxk;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
