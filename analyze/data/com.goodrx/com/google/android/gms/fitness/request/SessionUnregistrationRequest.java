package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzac;
import com.google.android.gms.internal.zzow;

public class SessionUnregistrationRequest implements SafeParcelable {
   public static final Creator<SessionUnregistrationRequest> CREATOR = new zzac();
   private final PendingIntent mPendingIntent;
   private final int mVersionCode;
   private final zzow zzaAD;

   SessionUnregistrationRequest(int var1, PendingIntent var2, IBinder var3) {
      this.mVersionCode = var1;
      this.mPendingIntent = var2;
      this.zzaAD = zzow.zza.zzbR(var3);
   }

   private boolean zzb(SessionUnregistrationRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, var1.mPendingIntent);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionUnregistrationRequest && this.zzb((SessionUnregistrationRequest)var1);
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

   public int hashCode() {
      Object[] var1 = new Object[]{this.mPendingIntent};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("pendingIntent", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzac.zza(this, var1, var2);
   }
}
