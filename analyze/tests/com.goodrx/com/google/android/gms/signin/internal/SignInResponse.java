package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.zzj;

public class SignInResponse implements SafeParcelable {
   public static final Creator<SignInResponse> CREATOR = new zzj();
   final int mVersionCode;
   private final ConnectionResult zzams;
   private final ResolveAccountResponse zzbhk;

   public SignInResponse(int var1) {
      this(new ConnectionResult(var1, (PendingIntent)null), (ResolveAccountResponse)null);
   }

   SignInResponse(int var1, ConnectionResult var2, ResolveAccountResponse var3) {
      this.mVersionCode = var1;
      this.zzams = var2;
      this.zzbhk = var3;
   }

   public SignInResponse(ConnectionResult var1, ResolveAccountResponse var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   public ResolveAccountResponse zzFP() {
      return this.zzbhk;
   }

   public ConnectionResult zzqY() {
      return this.zzams;
   }
}
