package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;
import com.google.android.gms.nearby.bootstrap.request.zzf;

public class SendDataRequest implements SafeParcelable {
   public static final zzf CREATOR = new zzf();
   private final byte[] data;
   final int versionCode;
   private final Device zzbaS;
   private final zzqg zzbaV;

   SendDataRequest(int var1, Device var2, byte[] var3, IBinder var4) {
      this.versionCode = var1;
      this.zzbaS = (Device)zzx.zzz(var2);
      this.data = (byte[])zzx.zzz(var3);
      zzx.zzz(var4);
      this.zzbaV = zzqg.zza.zzds(var4);
   }

   public int describeContents() {
      zzf var10000 = CREATOR;
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzbaV == null?null:this.zzbaV.asBinder();
   }

   public byte[] getData() {
      return this.data;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf var10000 = CREATOR;
      zzf.zza(this, var1, var2);
   }

   public Device zzEd() {
      return this.zzbaS;
   }
}
