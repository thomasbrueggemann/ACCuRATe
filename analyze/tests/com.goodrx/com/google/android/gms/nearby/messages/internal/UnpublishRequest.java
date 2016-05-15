package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.MessageWrapper;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzt;

public final class UnpublishRequest implements SafeParcelable {
   public static final Creator<UnpublishRequest> CREATOR = new zzt();
   final int mVersionCode;
   @Deprecated
   public final String zzbbF;
   @Deprecated
   public final boolean zzbbH;
   public final MessageWrapper zzbcT;
   @Deprecated
   public final String zzbco;
   public final zze zzbcr;
   public final ClientAppContext zzbcs;

   UnpublishRequest(int var1, MessageWrapper var2, IBinder var3, String var4, String var5, boolean var6, ClientAppContext var7) {
      this.mVersionCode = var1;
      this.zzbcT = var2;
      this.zzbcr = zze.zza.zzdz(var3);
      this.zzbbF = var4;
      this.zzbco = var5;
      this.zzbbH = var6;
      if(var7 == null) {
         var7 = new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH);
      }

      this.zzbcs = var7;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzt.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbcr.asBinder();
   }
}
