package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.zzd;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;

public class DataDeleteRequest implements SafeParcelable {
   public static final Creator<DataDeleteRequest> CREATOR = new zzd();
   private final int mVersionCode;
   private final long zzRD;
   private final zzow zzaAD;
   private final List<DataSource> zzaAF;
   private final List<Session> zzaAG;
   private final boolean zzaAH;
   private final boolean zzaAI;
   private final long zzavV;
   private final List<DataType> zzawe;

   DataDeleteRequest(int var1, long var2, long var4, List<DataSource> var6, List<DataType> var7, List<Session> var8, boolean var9, boolean var10, IBinder var11) {
      this.mVersionCode = var1;
      this.zzRD = var2;
      this.zzavV = var4;
      this.zzaAF = Collections.unmodifiableList(var6);
      this.zzawe = Collections.unmodifiableList(var7);
      this.zzaAG = var8;
      this.zzaAH = var9;
      this.zzaAI = var10;
      this.zzaAD = zzow.zza.zzbR(var11);
   }

   private boolean zzb(DataDeleteRequest var1) {
      return this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && com.google.android.gms.common.internal.zzw.equal(this.zzaAF, var1.zzaAF) && com.google.android.gms.common.internal.zzw.equal(this.zzawe, var1.zzawe) && com.google.android.gms.common.internal.zzw.equal(this.zzaAG, var1.zzaAG) && this.zzaAH == var1.zzaAH && this.zzaAI == var1.zzaAI;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataDeleteRequest && this.zzb((DataDeleteRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public List<DataSource> getDataSources() {
      return this.zzaAF;
   }

   public List<DataType> getDataTypes() {
      return this.zzawe;
   }

   public List<Session> getSessions() {
      return this.zzaAG;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzavV)};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSources", this.zzaAF).zzg("dateTypes", this.zzawe).zzg("sessions", this.zzaAG).zzg("deleteAllData", Boolean.valueOf(this.zzaAH)).zzg("deleteAllSessions", Boolean.valueOf(this.zzaAI)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }

   public long zzlO() {
      return this.zzRD;
   }

   public boolean zzuL() {
      return this.zzaAH;
   }

   public boolean zzuM() {
      return this.zzaAI;
   }

   public long zzud() {
      return this.zzavV;
   }
}
