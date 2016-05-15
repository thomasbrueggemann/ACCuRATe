package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInButtonConfig implements SafeParcelable {
   public static final Creator<SignInButtonConfig> CREATOR = new zzaa();
   final int mVersionCode;
   private final Scope[] zzafT;
   private final int zzamu;
   private final int zzamv;

   SignInButtonConfig(int var1, int var2, int var3, Scope[] var4) {
      this.mVersionCode = var1;
      this.zzamu = var2;
      this.zzamv = var3;
      this.zzafT = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaa.zza(this, var1, var2);
   }

   public int zzrb() {
      return this.zzamu;
   }

   public int zzrc() {
      return this.zzamv;
   }

   public Scope[] zzrd() {
      return this.zzafT;
   }
}
