package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import com.google.android.gms.fitness.result.zzj;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
   public static final Creator<SessionReadResult> CREATOR = new zzj();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<Session> zzaAG;
   private final List<SessionDataSet> zzaBO;

   SessionReadResult(int var1, List<Session> var2, List<SessionDataSet> var3, Status var4) {
      this.mVersionCode = var1;
      this.zzaAG = var2;
      this.zzaBO = Collections.unmodifiableList(var3);
      this.zzUX = var4;
   }

   private boolean zzb(SessionReadResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzaAG, var1.zzaAG) && zzw.equal(this.zzaBO, var1.zzaBO);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionReadResult && this.zzb((SessionReadResult)var1);
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
      Object[] var1 = new Object[]{this.zzUX, this.zzaAG, this.zzaBO};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("sessions", this.zzaAG).zzg("sessionDataSets", this.zzaBO).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   public List<SessionDataSet> zzvp() {
      return this.zzaBO;
   }
}
