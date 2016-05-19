package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
   public static final Creator<Bucket> CREATOR = new zzc();
   private final int mVersionCode;
   private final long zzRD;
   private final long zzavV;
   private final Session zzavX;
   private final int zzawf;
   private final List<DataSet> zzawg;
   private final int zzawh;
   private boolean zzawi;

   Bucket(int var1, long var2, long var4, Session var6, int var7, List<DataSet> var8, int var9, boolean var10) {
      this.zzawi = false;
      this.mVersionCode = var1;
      this.zzRD = var2;
      this.zzavV = var4;
      this.zzavX = var6;
      this.zzawf = var7;
      this.zzawg = var8;
      this.zzawh = var9;
      this.zzawi = var10;
   }

   public Bucket(RawBucket var1, List<DataSource> var2) {
      this(2, var1.zzRD, var1.zzavV, var1.zzavX, var1.zzaxf, zza(var1.zzawg, var2), var1.zzawh, var1.zzawi);
   }

   private static List<DataSet> zza(Collection<RawDataSet> var0, List<DataSource> var1) {
      ArrayList var2 = new ArrayList(var0.size());
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         var2.add(new DataSet((RawDataSet)var3.next(), var1));
      }

      return var2;
   }

   private boolean zza(Bucket var1) {
      return this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && this.zzawf == var1.zzawf && zzw.equal(this.zzawg, var1.zzawg) && this.zzawh == var1.zzawh && this.zzawi == var1.zzawi;
   }

   public static String zzeM(int var0) {
      switch(var0) {
      case 0:
         return "unknown";
      case 1:
         return "time";
      case 2:
         return "session";
      case 3:
         return "type";
      case 4:
         return "segment";
      default:
         return "bug";
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof Bucket && this.zza((Bucket)var1);
   }

   public int getBucketType() {
      return this.zzawh;
   }

   public List<DataSet> getDataSets() {
      return this.zzawg;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.zzavV, TimeUnit.MILLISECONDS);
   }

   public Session getSession() {
      return this.zzavX;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.zzRD, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Integer.valueOf(this.zzawf), Integer.valueOf(this.zzawh)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("activity", Integer.valueOf(this.zzawf)).zzg("dataSets", this.zzawg).zzg("bucketType", zzeM(this.zzawh)).zzg("serverHasMoreData", Boolean.valueOf(this.zzawi)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   public long zzlO() {
      return this.zzRD;
   }

   public int zzub() {
      return this.zzawf;
   }

   public boolean zzuc() {
      if(this.zzawi) {
         return true;
      } else {
         Iterator var1 = this.zzawg.iterator();

         do {
            if(!var1.hasNext()) {
               return false;
            }
         } while(!((DataSet)var1.next()).zzuc());

         return true;
      }
   }

   public long zzud() {
      return this.zzavV;
   }
}
