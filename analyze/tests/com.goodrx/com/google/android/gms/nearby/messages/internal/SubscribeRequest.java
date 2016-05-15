package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzd;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzi;
import com.google.android.gms.nearby.messages.internal.zzs;

public final class SubscribeRequest implements SafeParcelable {
   public static final Creator<SubscribeRequest> CREATOR = new zzs();
   final int mVersionCode;
   @Deprecated
   public final String zzbbF;
   public final boolean zzbbG;
   @Deprecated
   public final boolean zzbbH;
   public final Strategy zzbcU;
   public final zzd zzbcY;
   public final MessageFilter zzbcZ;
   @Deprecated
   public final String zzbco;
   public final zze zzbcr;
   public final ClientAppContext zzbcs;
   public final PendingIntent zzbda;
   public final int zzbdb;
   public final byte[] zzbdc;
   public final zzi zzbdd;

   SubscribeRequest(int var1, IBinder var2, Strategy var3, IBinder var4, MessageFilter var5, PendingIntent var6, int var7, String var8, String var9, byte[] var10, boolean var11, IBinder var12, boolean var13, ClientAppContext var14) {
      this.mVersionCode = var1;
      this.zzbcY = zzd.zza.zzdy(var2);
      this.zzbcU = var3;
      this.zzbcr = zze.zza.zzdz(var4);
      this.zzbcZ = var5;
      this.zzbda = var6;
      this.zzbdb = var7;
      this.zzbbF = var8;
      this.zzbco = var9;
      this.zzbdc = var10;
      this.zzbbG = var11;
      zzi var15;
      if(var12 == null) {
         var15 = null;
      } else {
         var15 = zzi.zza.zzdD(var12);
      }

      this.zzbdd = var15;
      this.zzbbH = var13;
      if(var14 == null) {
         String var16 = this.zzbco;
         String var17 = this.zzbbF;
         boolean var18 = this.zzbbH;
         var14 = new ClientAppContext(var16, var17, var18);
      }

      this.zzbcs = var14;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzs.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbcr == null?null:this.zzbcr.asBinder();
   }

   IBinder zzEH() {
      return this.zzbcY == null?null:this.zzbcY.asBinder();
   }

   IBinder zzEI() {
      return this.zzbdd == null?null:this.zzbdd.asBinder();
   }
}
