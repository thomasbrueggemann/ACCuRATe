package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.zzx;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;

public class SessionInsertRequest implements SafeParcelable {
   public static final Creator<SessionInsertRequest> CREATOR = new zzx();
   private final int mVersionCode;
   private final zzow zzaAD;
   private final List<DataPoint> zzaBs;
   private final Session zzavX;
   private final List<DataSet> zzawg;

   SessionInsertRequest(int var1, Session var2, List<DataSet> var3, List<DataPoint> var4, IBinder var5) {
      this.mVersionCode = var1;
      this.zzavX = var2;
      this.zzawg = Collections.unmodifiableList(var3);
      this.zzaBs = Collections.unmodifiableList(var4);
      this.zzaAD = zzow.zza.zzbR(var5);
   }

   private boolean zzb(SessionInsertRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzavX, var1.zzavX) && com.google.android.gms.common.internal.zzw.equal(this.zzawg, var1.zzawg) && com.google.android.gms.common.internal.zzw.equal(this.zzaBs, var1.zzaBs);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof SessionInsertRequest && this.zzb((SessionInsertRequest)var1);
   }

   public List<DataPoint> getAggregateDataPoints() {
      return this.zzaBs;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public List<DataSet> getDataSets() {
      return this.zzawg;
   }

   public Session getSession() {
      return this.zzavX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavX, this.zzawg, this.zzaBs};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("session", this.zzavX).zzg("dataSets", this.zzawg).zzg("aggregateDataPoints", this.zzaBs).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzx.zza(this, var1, var2);
   }
}
