package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.MessageWrapper;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzg;
import com.google.android.gms.nearby.messages.internal.zzq;

public final class PublishRequest implements SafeParcelable {
   public static final Creator<PublishRequest> CREATOR = new zzq();
   final int mVersionCode;
   @Deprecated
   public final String zzbbF;
   public final boolean zzbbG;
   @Deprecated
   public final boolean zzbbH;
   public final MessageWrapper zzbcT;
   public final Strategy zzbcU;
   public final zzg zzbcV;
   @Deprecated
   public final String zzbco;
   public final zze zzbcr;
   public final ClientAppContext zzbcs;

   PublishRequest(int var1, MessageWrapper var2, Strategy var3, IBinder var4, String var5, String var6, boolean var7, IBinder var8, boolean var9, ClientAppContext var10) {
      this.mVersionCode = var1;
      this.zzbcT = var2;
      this.zzbcU = var3;
      this.zzbcr = zze.zza.zzdz(var4);
      this.zzbbF = var5;
      this.zzbco = var6;
      this.zzbbG = var7;
      zzg var11;
      if(var8 == null) {
         var11 = null;
      } else {
         var11 = zzg.zza.zzdB(var8);
      }

      this.zzbcV = var11;
      this.zzbbH = var9;
      if(var10 == null) {
         var10 = new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH);
      }

      this.zzbcs = var10;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzq.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbcr.asBinder();
   }

   IBinder zzEF() {
      return this.zzbcV == null?null:this.zzbcV.asBinder();
   }
}
