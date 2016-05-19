package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzab;
import com.google.android.gms.internal.zzov;

public class SessionStopRequest implements SafeParcelable {
   public static final Creator<SessionStopRequest> CREATOR = new zzab();
   private final String mName;
   private final int mVersionCode;
   private final zzov zzaBz;
   private final String zzaxk;

   SessionStopRequest(int var1, String var2, String var3, IBinder var4) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.zzaxk = var3;
      this.zzaBz = zzov.zza.zzbQ(var4);
   }

   private boolean zzb(SessionStopRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.mName, var1.mName) && com.google.android.gms.common.internal.zzw.equal(this.zzaxk, var1.zzaxk);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof SessionStopRequest && this.zzb((SessionStopRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaBz == null?null:this.zzaBz.asBinder();
   }

   public String getIdentifier() {
      return this.zzaxk;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName, this.zzaxk};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).zzg("identifier", this.zzaxk).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzab.zza(this, var1, var2);
   }
}
