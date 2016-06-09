package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.zzc;
import java.util.List;

public class CheckServerAuthResult implements SafeParcelable {
   public static final Creator<CheckServerAuthResult> CREATOR = new zzc();
   final int mVersionCode;
   final boolean zzbhf;
   final List<Scope> zzbhg;

   CheckServerAuthResult(int var1, boolean var2, List<Scope> var3) {
      this.mVersionCode = var1;
      this.zzbhf = var2;
      this.zzbhg = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
