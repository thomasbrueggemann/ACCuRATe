package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.internal.zzow;

public class SensorUnregistrationRequest implements SafeParcelable {
   public static final Creator<SensorUnregistrationRequest> CREATOR = new zzw();
   private final PendingIntent mPendingIntent;
   private final int mVersionCode;
   private final zzow zzaAD;
   private final com.google.android.gms.fitness.data.zzk zzaBh;

   SensorUnregistrationRequest(int var1, IBinder var2, PendingIntent var3, IBinder var4) {
      this.mVersionCode = var1;
      com.google.android.gms.fitness.data.zzk var5;
      if(var2 == null) {
         var5 = null;
      } else {
         var5 = com.google.android.gms.fitness.data.zzk.zza.zzbt(var2);
      }

      this.zzaBh = var5;
      this.mPendingIntent = var3;
      this.zzaAD = zzow.zza.zzbR(var4);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public PendingIntent getIntent() {
      return this.mPendingIntent;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzaBh};
      return String.format("SensorUnregistrationRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzw.zza(this, var1, var2);
   }

   IBinder zzvb() {
      return this.zzaBh == null?null:this.zzaBh.asBinder();
   }
}
