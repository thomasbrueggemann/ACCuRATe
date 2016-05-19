package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzy;
import com.google.android.gms.internal.zzou;
import java.util.List;

public class SessionReadRequest implements SafeParcelable {
   public static final Creator<SessionReadRequest> CREATOR = new zzy();
   private final int mVersionCode;
   private final String zzLq;
   private final long zzRD;
   private final List<DataSource> zzaAF;
   private final boolean zzaAQ;
   private final String zzaBu;
   private boolean zzaBv;
   private final List<String> zzaBw;
   private final zzou zzaBx;
   private final long zzavV;
   private final List<DataType> zzawe;

   SessionReadRequest(int var1, String var2, String var3, long var4, long var6, List<DataType> var8, List<DataSource> var9, boolean var10, boolean var11, List<String> var12, IBinder var13) {
      this.mVersionCode = var1;
      this.zzaBu = var2;
      this.zzLq = var3;
      this.zzRD = var4;
      this.zzavV = var6;
      this.zzawe = var8;
      this.zzaAF = var9;
      this.zzaBv = var10;
      this.zzaAQ = var11;
      this.zzaBw = var12;
      this.zzaBx = zzou.zza.zzbP(var13);
   }

   private boolean zzb(SessionReadRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzaBu, var1.zzaBu) && this.zzLq.equals(var1.zzLq) && this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && com.google.android.gms.common.internal.zzw.equal(this.zzawe, var1.zzawe) && com.google.android.gms.common.internal.zzw.equal(this.zzaAF, var1.zzaAF) && this.zzaBv == var1.zzaBv && this.zzaBw.equals(var1.zzaBw) && this.zzaAQ == var1.zzaAQ;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionReadRequest && this.zzb((SessionReadRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaBx == null?null:this.zzaBx.asBinder();
   }

   public List<DataSource> getDataSources() {
      return this.zzaAF;
   }

   public List<DataType> getDataTypes() {
      return this.zzawe;
   }

   public List<String> getExcludedPackages() {
      return this.zzaBw;
   }

   public String getSessionId() {
      return this.zzLq;
   }

   public String getSessionName() {
      return this.zzaBu;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaBu, this.zzLq, Long.valueOf(this.zzRD), Long.valueOf(this.zzavV)};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("sessionName", this.zzaBu).zzg("sessionId", this.zzLq).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataTypes", this.zzawe).zzg("dataSources", this.zzaAF).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzaBv)).zzg("excludedPackages", this.zzaBw).zzg("useServer", Boolean.valueOf(this.zzaAQ)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzy.zza(this, var1, var2);
   }

   public long zzlO() {
      return this.zzRD;
   }

   public boolean zzuP() {
      return this.zzaAQ;
   }

   public long zzud() {
      return this.zzavV;
   }

   public boolean zzve() {
      return this.zzaBv;
   }
}
