package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.zza;

public class FavaDiagnosticsEntity implements SafeParcelable {
   public static final zza CREATOR = new zza();
   final int mVersionCode;
   public final String zzamD;
   public final int zzamE;

   public FavaDiagnosticsEntity(int var1, String var2, int var3) {
      this.mVersionCode = var1;
      this.zzamD = var2;
      this.zzamE = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
