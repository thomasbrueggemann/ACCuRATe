package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzn;

public class LocationRequestUpdateData implements SafeParcelable {
   public static final zzn CREATOR = new zzn();
   PendingIntent mPendingIntent;
   private final int mVersionCode;
   int zzaOU;
   LocationRequestInternal zzaOV;
   com.google.android.gms.location.zzd zzaOW;
   com.google.android.gms.location.zzc zzaOX;
   zzg zzaOY;

   LocationRequestUpdateData(int var1, int var2, LocationRequestInternal var3, IBinder var4, PendingIntent var5, IBinder var6, IBinder var7) {
      this.mVersionCode = var1;
      this.zzaOU = var2;
      this.zzaOV = var3;
      com.google.android.gms.location.zzd var8;
      if(var4 == null) {
         var8 = null;
      } else {
         var8 = com.google.android.gms.location.zzd.zza.zzcf(var4);
      }

      this.zzaOW = var8;
      this.mPendingIntent = var5;
      com.google.android.gms.location.zzc var9;
      if(var6 == null) {
         var9 = null;
      } else {
         var9 = com.google.android.gms.location.zzc.zza.zzce(var6);
      }

      this.zzaOX = var9;
      zzg var10 = null;
      if(var7 != null) {
         var10 = zzg.zza.zzch(var7);
      }

      this.zzaOY = var10;
   }

   public static LocationRequestUpdateData zza(LocationRequestInternal var0, com.google.android.gms.location.zzd var1, @Nullable zzg var2) {
      IBinder var3 = var1.asBinder();
      IBinder var4;
      if(var2 != null) {
         var4 = var2.asBinder();
      } else {
         var4 = null;
      }

      return new LocationRequestUpdateData(1, 1, var0, var3, (PendingIntent)null, (IBinder)null, var4);
   }

   public static LocationRequestUpdateData zza(com.google.android.gms.location.zzc var0, @Nullable zzg var1) {
      IBinder var2 = var0.asBinder();
      IBinder var3;
      if(var1 != null) {
         var3 = var1.asBinder();
      } else {
         var3 = null;
      }

      return new LocationRequestUpdateData(1, 2, (LocationRequestInternal)null, (IBinder)null, (PendingIntent)null, var2, var3);
   }

   public static LocationRequestUpdateData zza(com.google.android.gms.location.zzd var0, @Nullable zzg var1) {
      IBinder var2 = var0.asBinder();
      IBinder var3;
      if(var1 != null) {
         var3 = var1.asBinder();
      } else {
         var3 = null;
      }

      return new LocationRequestUpdateData(1, 2, (LocationRequestInternal)null, var2, (PendingIntent)null, (IBinder)null, var3);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }

   IBinder zzyQ() {
      return this.zzaOW == null?null:this.zzaOW.asBinder();
   }

   IBinder zzyR() {
      return this.zzaOX == null?null:this.zzaOX.asBinder();
   }

   IBinder zzyS() {
      return this.zzaOY == null?null:this.zzaOY.asBinder();
   }
}
