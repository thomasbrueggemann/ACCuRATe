package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzz;
import com.google.android.gms.internal.zzow;

public class SessionRegistrationRequest implements SafeParcelable {
   public static final Creator<SessionRegistrationRequest> CREATOR = new zzz();
   private final PendingIntent mPendingIntent;
   private final int mVersionCode;
   private final zzow zzaAD;
   private final int zzaBy;

   SessionRegistrationRequest(int var1, PendingIntent var2, IBinder var3, int var4) {
      this.mVersionCode = var1;
      this.mPendingIntent = var2;
      zzow var5;
      if(var3 == null) {
         var5 = null;
      } else {
         var5 = zzow.zza.zzbR(var3);
      }

      this.zzaAD = var5;
      this.zzaBy = var4;
   }

   private boolean zzb(SessionRegistrationRequest var1) {
      return this.zzaBy == var1.zzaBy && com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, var1.mPendingIntent);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionRegistrationRequest && this.zzb((SessionRegistrationRequest)var1);
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
      Object[] var1 = new Object[]{this.mPendingIntent, Integer.valueOf(this.zzaBy)};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaBy)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzz.zza(this, var1, var2);
   }

   public int zzvf() {
      return this.zzaBy;
   }
}
