package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzv;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class SensorRegistrationRequest implements SafeParcelable {
   public static final Creator<SensorRegistrationRequest> CREATOR = new zzv();
   private final PendingIntent mPendingIntent;
   private final int mVersionCode;
   private final zzow zzaAD;
   private com.google.android.gms.fitness.data.zzk zzaBh;
   int zzaBi;
   int zzaBj;
   private final long zzaBk;
   private final long zzaBl;
   private final List<LocationRequest> zzaBm;
   private final long zzaBn;
   private final List<Object> zzaBo;
   private DataType zzavT;
   private DataSource zzavU;
   private final long zzaxo;
   private final int zzaxp;

   SensorRegistrationRequest(int var1, DataSource var2, DataType var3, IBinder var4, int var5, int var6, long var7, long var9, PendingIntent var11, long var12, int var14, List<LocationRequest> var15, long var16, IBinder var18) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzavT = var3;
      com.google.android.gms.fitness.data.zzk var19;
      if(var4 == null) {
         var19 = null;
      } else {
         var19 = com.google.android.gms.fitness.data.zzk.zza.zzbt(var4);
      }

      this.zzaBh = var19;
      if(var7 == 0L) {
         var7 = (long)var5;
      }

      this.zzaxo = var7;
      this.zzaBl = var12;
      if(var9 == 0L) {
         var9 = (long)var6;
      }

      this.zzaBk = var9;
      this.zzaBm = var15;
      this.mPendingIntent = var11;
      this.zzaxp = var14;
      this.zzaBo = Collections.emptyList();
      this.zzaBn = var16;
      this.zzaAD = zzow.zza.zzbR(var18);
   }

   private boolean zzb(SensorRegistrationRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzavU, var1.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, var1.zzavT) && this.zzaxo == var1.zzaxo && this.zzaBl == var1.zzaBl && this.zzaBk == var1.zzaBk && this.zzaxp == var1.zzaxp && com.google.android.gms.common.internal.zzw.equal(this.zzaBm, var1.zzaBm);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SensorRegistrationRequest && this.zzb((SensorRegistrationRequest)var1);
   }

   public int getAccuracyMode() {
      return this.zzaxp;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   public PendingIntent getIntent() {
      return this.mPendingIntent;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU, this.zzavT, this.zzaBh, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk), Integer.valueOf(this.zzaxp), this.zzaBm};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzavT, this.zzavU, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk)};
      return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzv.zza(this, var1, var2);
   }

   public long zzuX() {
      return this.zzaBl;
   }

   public long zzuY() {
      return this.zzaBk;
   }

   public List<LocationRequest> zzuZ() {
      return this.zzaBm;
   }

   public long zzux() {
      return this.zzaxo;
   }

   public long zzva() {
      return this.zzaBn;
   }

   IBinder zzvb() {
      return this.zzaBh == null?null:this.zzaBh.asBinder();
   }
}
