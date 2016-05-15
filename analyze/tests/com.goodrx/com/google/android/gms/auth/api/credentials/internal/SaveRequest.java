package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SaveRequest implements SafeParcelable {
   public static final Creator<SaveRequest> CREATOR = new zzk();
   final int mVersionCode;
   private final Credential zzWu;

   SaveRequest(int var1, Credential var2) {
      this.mVersionCode = var1;
      this.zzWu = var2;
   }

   public int describeContents() {
      return 0;
   }

   public Credential getCredential() {
      return this.zzWu;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
