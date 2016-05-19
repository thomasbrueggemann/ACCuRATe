package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.zzi;

public class SignInRequest implements SafeParcelable {
   public static final Creator<SignInRequest> CREATOR = new zzi();
   final int mVersionCode;
   final ResolveAccountRequest zzbhj;

   SignInRequest(int var1, ResolveAccountRequest var2) {
      this.mVersionCode = var1;
      this.zzbhj = var2;
   }

   public SignInRequest(ResolveAccountRequest var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }

   public ResolveAccountRequest zzFO() {
      return this.zzbhj;
   }
}
