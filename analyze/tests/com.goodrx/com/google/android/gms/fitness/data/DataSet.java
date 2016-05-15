package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DataSet implements SafeParcelable {
   public static final Creator<DataSet> CREATOR = new zze();
   private final int mVersionCode;
   private final DataType zzavT;
   private final DataSource zzavU;
   private boolean zzawi = false;
   private final List<DataPoint> zzawp;
   private final List<DataSource> zzawq;

   DataSet(int var1, DataSource var2, DataType var3, List<RawDataPoint> var4, List<DataSource> var5, boolean var6) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzavT = var2.getDataType();
      this.zzawi = var6;
      this.zzawp = new ArrayList(var4.size());
      if(var1 < 2) {
         var5 = Collections.singletonList(var2);
      }

      this.zzawq = var5;
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         RawDataPoint var8 = (RawDataPoint)var7.next();
         this.zzawp.add(new DataPoint(this.zzawq, var8));
      }

   }

   public DataSet(RawDataSet var1, List<DataSource> var2) {
      this.mVersionCode = 3;
      this.zzavU = (DataSource)zzb(var2, var1.zzaxg);
      this.zzavT = this.zzavU.getDataType();
      this.zzawq = var2;
      this.zzawi = var1.zzawi;
      List var3 = var1.zzaxj;
      this.zzawp = new ArrayList(var3.size());
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         RawDataPoint var5 = (RawDataPoint)var4.next();
         this.zzawp.add(new DataPoint(this.zzawq, var5));
      }

   }

   private boolean zza(DataSet var1) {
      return zzw.equal(this.getDataType(), var1.getDataType()) && zzw.equal(this.zzavU, var1.zzavU) && zzw.equal(this.zzawp, var1.zzawp) && this.zzawi == var1.zzawi;
   }

   private static <T> T zzb(List<T> var0, int var1) {
      return var1 >= 0 && var1 < var0.size()?var0.get(var1):null;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataSet && this.zza((DataSet)var1);
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   public DataType getDataType() {
      return this.zzavU.getDataType();
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object var1 = this.zzuk();
      Object[] var2 = new Object[]{this.zzavU.toDebugString(), null};
      if(this.zzawp.size() >= 10) {
         Object[] var3 = new Object[]{Integer.valueOf(this.zzawp.size()), ((List)var1).subList(0, 5)};
         var1 = String.format("%d data points, first 5: %s", var3);
      }

      var2[1] = var1;
      return String.format("DataSet{%s %s}", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   public boolean zzuc() {
      return this.zzawi;
   }

   List<RawDataPoint> zzuk() {
      return this.zzv(this.zzawq);
   }

   List<DataSource> zzul() {
      return this.zzawq;
   }

   List<RawDataPoint> zzv(List<DataSource> var1) {
      ArrayList var2 = new ArrayList(this.zzawp.size());
      Iterator var3 = this.zzawp.iterator();

      while(var3.hasNext()) {
         var2.add(new RawDataPoint((DataPoint)var3.next(), var1));
      }

      return var2;
   }
}
