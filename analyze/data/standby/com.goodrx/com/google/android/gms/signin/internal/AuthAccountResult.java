package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.zza;

public class AuthAccountResult implements Result, SafeParcelable {
   public static final Creator<AuthAccountResult> CREATOR = new zza();
   final int mVersionCode;
   private int zzbhd;
   private Intent zzbhe;

   public AuthAccountResult() {
      this(0, (Intent)null);
   }

   AuthAccountResult(int var1, int var2, Intent var3) {
      this.mVersionCode = var1;
      this.zzbhd = var2;
      this.zzbhe = var3;
   }

   public AuthAccountResult(int var1, Intent var2) {
      this(2, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return this.zzbhd == 0?Status.zzagC:Status.zzagG;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public int zzFK() {
      return this.zzbhd;
   }

   public Intent zzFL() {
      return this.zzbhe;
   }
}
