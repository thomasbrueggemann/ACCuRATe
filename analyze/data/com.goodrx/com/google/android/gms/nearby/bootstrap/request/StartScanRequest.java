package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.nearby.bootstrap.request.zzg;

public class StartScanRequest implements SafeParcelable {
   public static final zzg CREATOR = new zzg();
   final int versionCode;
   private final zzqg zzbaV;
   private final zzqi zzbaY;

   StartScanRequest(int var1, IBinder var2, IBinder var3) {
      this.versionCode = var1;
      zzx.zzz(var2);
      this.zzbaY = zzqi.zza.zzdu(var2);
      zzx.zzz(var3);
      this.zzbaV = zzqg.zza.zzds(var3);
   }

   public int describeContents() {
      zzg var10000 = CREATOR;
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzbaV == null?null:this.zzbaV.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg var10000 = CREATOR;
      zzg.zza(this, var1, var2);
   }

   public IBinder zzEi() {
      return this.zzbaY == null?null:this.zzbaY.asBinder();
   }
}
