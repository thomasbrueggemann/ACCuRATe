package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.zzk;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
   public static final Creator<SessionStopResult> CREATOR = new zzk();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<Session> zzaAG;

   SessionStopResult(int var1, Status var2, List<Session> var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaAG = Collections.unmodifiableList(var3);
   }

   private boolean zzb(SessionStopResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzaAG, var1.zzaAG);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionStopResult && this.zzb((SessionStopResult)var1);
   }

   public List<Session> getSessions() {
      return this.zzaAG;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzaAG};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("sessions", this.zzaAG).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
