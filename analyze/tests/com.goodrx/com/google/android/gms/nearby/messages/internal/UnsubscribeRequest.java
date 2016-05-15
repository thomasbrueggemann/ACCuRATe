package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzd;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzu;

public final class UnsubscribeRequest implements SafeParcelable {
   public static final Creator<UnsubscribeRequest> CREATOR = new zzu();
   final int mVersionCode;
   @Deprecated
   public final String zzbbF;
   @Deprecated
   public final boolean zzbbH;
   public final zzd zzbcY;
   @Deprecated
   public final String zzbco;
   public final zze zzbcr;
   public final ClientAppContext zzbcs;
   public final PendingIntent zzbda;
   public final int zzbdb;

   UnsubscribeRequest(int var1, IBinder var2, IBinder var3, PendingIntent var4, int var5, String var6, String var7, boolean var8, ClientAppContext var9) {
      this.mVersionCode = var1;
      this.zzbcY = zzd.zza.zzdy(var2);
      this.zzbcr = zze.zza.zzdz(var3);
      this.zzbda = var4;
      this.zzbdb = var5;
      this.zzbbF = var6;
      this.zzbco = var7;
      this.zzbbH = var8;
      if(var9 == null) {
         var9 = new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH);
      }

      this.zzbcs = var9;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzu.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbcr.asBinder();
   }

   IBinder zzEH() {
      return this.zzbcY == null?null:this.zzbcY.asBinder();
   }
}
