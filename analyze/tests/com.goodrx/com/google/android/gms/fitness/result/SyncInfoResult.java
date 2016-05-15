package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.result.zzl;

public class SyncInfoResult implements Result, SafeParcelable {
   public static final Creator<SyncInfoResult> CREATOR = new zzl();
   private final int mVersionCode;
   private final Status zzUX;
   private final long zzaez;

   SyncInfoResult(int var1, Status var2, long var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaez = var3;
   }

   private boolean zzb(SyncInfoResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(Long.valueOf(this.zzaez), Long.valueOf(var1.zzaez));
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SyncInfoResult && this.zzb((SyncInfoResult)var1);
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, Long.valueOf(this.zzaez)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("timestamp", Long.valueOf(this.zzaez)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }

   public long zzvq() {
      return this.zzaez;
   }
}
