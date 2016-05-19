package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.messages.internal.zzr;

public final class RegisterStatusCallbackRequest implements SafeParcelable {
   public static final Creator<RegisterStatusCallbackRequest> CREATOR = new zzr();
   final int versionCode;
   @Deprecated
   public String zzbbF;
   public final zzh zzbcW;
   public boolean zzbcX;
   public final zze zzbcr;
   public final ClientAppContext zzbcs;

   RegisterStatusCallbackRequest(int var1, IBinder var2, IBinder var3, boolean var4, String var5, ClientAppContext var6) {
      this.versionCode = var1;
      this.zzbcr = zze.zza.zzdz(var2);
      this.zzbcW = zzh.zza.zzdC(var3);
      this.zzbcX = var4;
      this.zzbbF = var5;
      if(var6 == null) {
         var6 = new ClientAppContext((String)null, this.zzbbF);
      }

      this.zzbcs = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbcr.asBinder();
   }

   IBinder zzEG() {
      return this.zzbcW.asBinder();
   }
}
