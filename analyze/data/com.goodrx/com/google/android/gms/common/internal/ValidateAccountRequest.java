package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest implements SafeParcelable {
   public static final Creator<ValidateAccountRequest> CREATOR = new zzae();
   final int mVersionCode;
   private final String zzVO;
   private final Scope[] zzafT;
   final IBinder zzakA;
   private final int zzamy;
   private final Bundle zzamz;

   ValidateAccountRequest(int var1, int var2, IBinder var3, Scope[] var4, Bundle var5, String var6) {
      this.mVersionCode = var1;
      this.zzamy = var2;
      this.zzakA = var3;
      this.zzafT = var4;
      this.zzamz = var5;
      this.zzVO = var6;
   }

   public int describeContents() {
      return 0;
   }

   public String getCallingPackage() {
      return this.zzVO;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzae.zza(this, var1, var2);
   }

   public Scope[] zzrd() {
      return this.zzafT;
   }

   public int zzre() {
      return this.zzamy;
   }

   public Bundle zzrf() {
      return this.zzamz;
   }
}
