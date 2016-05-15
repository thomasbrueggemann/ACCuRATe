package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.zzaa;
import com.google.android.gms.internal.zzow;

public class SessionStartRequest implements SafeParcelable {
   public static final Creator<SessionStartRequest> CREATOR = new zzaa();
   private final int mVersionCode;
   private final zzow zzaAD;
   private final Session zzavX;

   SessionStartRequest(int var1, Session var2, IBinder var3) {
      this.mVersionCode = var1;
      this.zzavX = var2;
      this.zzaAD = zzow.zza.zzbR(var3);
   }

   private boolean zzb(SessionStartRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzavX, var1.zzavX);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof SessionStartRequest && this.zzb((SessionStartRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public Session getSession() {
      return this.zzavX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavX};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("session", this.zzavX).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaa.zza(this, var1, var2);
   }
}
