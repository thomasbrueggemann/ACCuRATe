package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken implements SafeParcelable {
   public static final Creator<IdToken> CREATOR = new zze();
   final int mVersionCode;
   private final String zzVY;
   private final String zzWk;

   IdToken(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzVY = var2;
      this.zzWk = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountType() {
      return this.zzVY;
   }

   public String getIdToken() {
      return this.zzWk;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
