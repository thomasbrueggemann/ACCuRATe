package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzb;
import com.google.android.gms.nearby.messages.internal.zze;

public class GetPermissionStatusRequest implements SafeParcelable {
   public static final Creator<GetPermissionStatusRequest> CREATOR = new zzb();
   final int mVersionCode;
   @Deprecated
   public final String zzbbF;
   public final zze zzbcr;
   public final ClientAppContext zzbcs;

   GetPermissionStatusRequest(int var1, IBinder var2, String var3, ClientAppContext var4) {
      this.mVersionCode = var1;
      this.zzbcr = zze.zza.zzdz(var2);
      this.zzbbF = var3;
      if(var4 == null) {
         var4 = new ClientAppContext((String)null, this.zzbbF);
      }

      this.zzbcs = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbcr.asBinder();
   }
}
