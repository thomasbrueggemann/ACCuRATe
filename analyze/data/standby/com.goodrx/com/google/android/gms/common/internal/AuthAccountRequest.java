package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest implements SafeParcelable {
   public static final Creator<AuthAccountRequest> CREATOR = new zzc();
   final int mVersionCode;
   final Scope[] zzafT;
   final IBinder zzakA;
   Integer zzakB;
   Integer zzakC;

   AuthAccountRequest(int var1, IBinder var2, Scope[] var3, Integer var4, Integer var5) {
      this.mVersionCode = var1;
      this.zzakA = var2;
      this.zzafT = var3;
      this.zzakB = var4;
      this.zzakC = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
