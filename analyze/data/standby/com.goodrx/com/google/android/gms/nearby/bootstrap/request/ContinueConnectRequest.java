package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.request.zzb;

public class ContinueConnectRequest implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   final int versionCode;
   private final zzqg zzbaV;
   private final String zzbaW;

   ContinueConnectRequest(int var1, String var2, IBinder var3) {
      this.versionCode = var1;
      this.zzbaW = (String)zzx.zzz(var2);
      this.zzbaV = zzqg.zza.zzds(var3);
   }

   public int describeContents() {
      zzb var10000 = CREATOR;
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzbaV == null?null:this.zzbaV.asBinder();
   }

   public String getToken() {
      return this.zzbaW;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb var10000 = CREATOR;
      zzb.zza(this, var1, var2);
   }
}
