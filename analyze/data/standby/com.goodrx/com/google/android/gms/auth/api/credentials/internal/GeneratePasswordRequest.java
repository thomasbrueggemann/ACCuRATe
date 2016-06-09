package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzh;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GeneratePasswordRequest implements SafeParcelable {
   public static final Creator<GeneratePasswordRequest> CREATOR = new zzh();
   final int mVersionCode;
   private final PasswordSpecification zzVM;

   GeneratePasswordRequest(int var1, PasswordSpecification var2) {
      this.mVersionCode = var1;
      this.zzVM = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public PasswordSpecification zzmr() {
      return this.zzVM;
   }
}
