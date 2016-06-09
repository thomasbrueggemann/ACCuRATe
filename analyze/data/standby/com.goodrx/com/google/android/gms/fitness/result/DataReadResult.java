package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.result.zzc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
   public static final Creator<DataReadResult> CREATOR = new zzc();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<Bucket> zzaBF;
   private int zzaBG;
   private final List<DataType> zzaBH;
   private final List<DataSet> zzawg;
   private final List<DataSource> zzawq;

   DataReadResult(int var1, List<RawDataSet> var2, Status var3, List<RawBucket> var4, int var5, List<DataSource> var6, List<DataType> var7) {
      this.mVersionCode = var1;
      this.zzUX = var3;
      this.zzaBG = var5;
      this.zzawq = var6;
      this.zzaBH = var7;
      this.zzawg = new ArrayList(var2.size());
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         RawDataSet var12 = (RawDataSet)var8.next();
         this.zzawg.add(new DataSet(var12, var6));
      }

      this.zzaBF = new ArrayList(var4.size());
      Iterator var9 = var4.iterator();

      while(var9.hasNext()) {
         RawBucket var10 = (RawBucket)var9.next();
         this.zzaBF.add(new Bucket(var10, var6));
      }

   }

   private boolean zzc(DataReadResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzawg, var1.zzawg) && zzw.equal(this.zzaBF, var1.zzaBF);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataReadResult && this.zzc((DataReadResult)var1);
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzawg, this.zzaBF};
      return zzw.hashCode(var1);
   }

   public String toString() {
      zzw.zza var1 = zzw.zzy(this).zzg("status", this.zzUX);
      Object var2;
      if(this.zzawg.size() > 5) {
         var2 = this.zzawg.size() + " data sets";
      } else {
         var2 = this.zzawg;
      }

      zzw.zza var3 = var1.zzg("dataSets", var2);
      Object var4;
      if(this.zzaBF.size() > 5) {
         var4 = this.zzaBF.size() + " buckets";
      } else {
         var4 = this.zzaBF;
      }

      return var3.zzg("buckets", var4).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   List<DataSource> zzul() {
      return this.zzawq;
   }

   public int zzvj() {
      return this.zzaBG;
   }

   List<RawBucket> zzvk() {
      ArrayList var1 = new ArrayList(this.zzaBF.size());
      Iterator var2 = this.zzaBF.iterator();

      while(var2.hasNext()) {
         var1.add(new RawBucket((Bucket)var2.next(), this.zzawq, this.zzaBH));
      }

      return var1;
   }

   List<RawDataSet> zzvl() {
      ArrayList var1 = new ArrayList(this.zzawg.size());
      Iterator var2 = this.zzawg.iterator();

      while(var2.hasNext()) {
         var1.add(new RawDataSet((DataSet)var2.next(), this.zzawq, this.zzaBH));
      }

      return var1;
   }

   List<DataType> zzvm() {
      return this.zzaBH;
   }
}
