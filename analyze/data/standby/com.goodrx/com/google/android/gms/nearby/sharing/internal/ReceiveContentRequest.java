package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza;
import com.google.android.gms.nearby.sharing.internal.zzc;
import com.google.android.gms.nearby.sharing.internal.zzg;

public final class ReceiveContentRequest implements SafeParcelable {
   public static final Creator<ReceiveContentRequest> CREATOR = new zzg();
   public String packageName;
   final int versionCode;
   public IBinder zzbdk;
   public zzc zzbdo;
   public zza zzbdp;

   ReceiveContentRequest() {
      this.versionCode = 1;
   }

   ReceiveContentRequest(int var1, IBinder var2, IBinder var3, String var4, IBinder var5) {
      this.versionCode = var1;
      this.zzbdk = var2;
      this.zzbdp = zza.zza.zzdF(var3);
      this.packageName = var4;
      this.zzbdo = zzc.zza.zzdH(var5);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbdo.asBinder();
   }

   IBinder zzEQ() {
      return this.zzbdp == null?null:this.zzbdp.asBinder();
   }
}
