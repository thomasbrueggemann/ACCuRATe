package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.request.zzf;
import com.google.android.gms.internal.zzoh;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadRequest implements SafeParcelable {
   public static final Creator<DataReadRequest> CREATOR = new zzf();
   private final int mVersionCode;
   private final long zzRD;
   private final List<DataSource> zzaAF;
   private final List<DataType> zzaAK;
   private final List<DataSource> zzaAL;
   private final long zzaAM;
   private final DataSource zzaAN;
   private final int zzaAO;
   private final boolean zzaAP;
   private final boolean zzaAQ;
   private final zzoh zzaAR;
   private final List<Device> zzaAS;
   private final long zzavV;
   private final List<DataType> zzawe;
   private final int zzawh;

   DataReadRequest(int var1, List<DataType> var2, List<DataSource> var3, long var4, long var6, List<DataType> var8, List<DataSource> var9, int var10, long var11, DataSource var13, int var14, boolean var15, boolean var16, IBinder var17, List<Device> var18) {
      this.mVersionCode = var1;
      this.zzawe = var2;
      this.zzaAF = var3;
      this.zzRD = var4;
      this.zzavV = var6;
      this.zzaAK = var8;
      this.zzaAL = var9;
      this.zzawh = var10;
      this.zzaAM = var11;
      this.zzaAN = var13;
      this.zzaAO = var14;
      this.zzaAP = var15;
      this.zzaAQ = var16;
      zzoh var19;
      if(var17 == null) {
         var19 = null;
      } else {
         var19 = zzoh.zza.zzbC(var17);
      }

      this.zzaAR = var19;
      if(var18 == null) {
         var18 = Collections.emptyList();
      }

      this.zzaAS = var18;
   }

   private boolean zzb(DataReadRequest var1) {
      return this.zzawe.equals(var1.zzawe) && this.zzaAF.equals(var1.zzaAF) && this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && this.zzawh == var1.zzawh && this.zzaAL.equals(var1.zzaAL) && this.zzaAK.equals(var1.zzaAK) && com.google.android.gms.common.internal.zzw.equal(this.zzaAN, var1.zzaAN) && this.zzaAM == var1.zzaAM && this.zzaAQ == var1.zzaAQ;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataReadRequest && this.zzb((DataReadRequest)var1);
   }

   public DataSource getActivityDataSource() {
      return this.zzaAN;
   }

   public List<DataSource> getAggregatedDataSources() {
      return this.zzaAL;
   }

   public List<DataType> getAggregatedDataTypes() {
      return this.zzaAK;
   }

   public int getBucketType() {
      return this.zzawh;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAR == null?null:this.zzaAR.asBinder();
   }

   public List<DataSource> getDataSources() {
      return this.zzaAF;
   }

   public List<DataType> getDataTypes() {
      return this.zzawe;
   }

   public int getLimit() {
      return this.zzaAO;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzawh), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV)};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataReadRequest{");
      if(!this.zzawe.isEmpty()) {
         Iterator var17 = this.zzawe.iterator();

         while(var17.hasNext()) {
            var1.append(((DataType)var17.next()).zzuo()).append(" ");
         }
      }

      if(!this.zzaAF.isEmpty()) {
         Iterator var15 = this.zzaAF.iterator();

         while(var15.hasNext()) {
            var1.append(((DataSource)var15.next()).toDebugString()).append(" ");
         }
      }

      if(this.zzawh != 0) {
         var1.append("bucket by ").append(Bucket.zzeM(this.zzawh));
         if(this.zzaAM > 0L) {
            var1.append(" >").append(this.zzaAM).append("ms");
         }

         var1.append(": ");
      }

      if(!this.zzaAK.isEmpty()) {
         Iterator var10 = this.zzaAK.iterator();

         while(var10.hasNext()) {
            var1.append(((DataType)var10.next()).zzuo()).append(" ");
         }
      }

      if(!this.zzaAL.isEmpty()) {
         Iterator var8 = this.zzaAL.iterator();

         while(var8.hasNext()) {
            var1.append(((DataSource)var8.next()).toDebugString()).append(" ");
         }
      }

      Object[] var3 = new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Long.valueOf(this.zzavV)};
      var1.append(String.format("(%tF %tT - %tF %tT)", var3));
      if(this.zzaAN != null) {
         var1.append("activities: ").append(this.zzaAN.toDebugString());
      }

      if(this.zzaAQ) {
         var1.append(" +server");
      }

      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public long zzlO() {
      return this.zzRD;
   }

   public boolean zzuP() {
      return this.zzaAQ;
   }

   public boolean zzuQ() {
      return this.zzaAP;
   }

   public long zzuR() {
      return this.zzaAM;
   }

   public List<Device> zzuS() {
      return this.zzaAS;
   }

   public long zzud() {
      return this.zzavV;
   }
}
