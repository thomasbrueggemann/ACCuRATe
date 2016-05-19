package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzh;

public class DataUpdateNotification implements SafeParcelable {
   public static final Creator<DataUpdateNotification> CREATOR = new zzh();
   final int mVersionCode;
   private final DataType zzavT;
   private final DataSource zzavU;
   private final long zzawF;
   private final long zzawG;
   private final int zzawH;

   DataUpdateNotification(int var1, long var2, long var4, int var6, DataSource var7, DataType var8) {
      this.mVersionCode = var1;
      this.zzawF = var2;
      this.zzawG = var4;
      this.zzawH = var6;
      this.zzavU = var7;
      this.zzavT = var8;
   }

   private boolean zza(DataUpdateNotification var1) {
      return this.zzawF == var1.zzawF && this.zzawG == var1.zzawG && this.zzawH == var1.zzawH && zzw.equal(this.zzavU, var1.zzavU) && zzw.equal(this.zzavT, var1.zzavT);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataUpdateNotification && this.zza((DataUpdateNotification)var1);
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   public int getOperationType() {
      return this.zzawH;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzawF), Long.valueOf(this.zzawG), Integer.valueOf(this.zzawH), this.zzavU, this.zzavT};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("updateStartTimeNanos", Long.valueOf(this.zzawF)).zzg("updateEndTimeNanos", Long.valueOf(this.zzawG)).zzg("operationType", Integer.valueOf(this.zzawH)).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public long zzup() {
      return this.zzawF;
   }

   public long zzuq() {
      return this.zzawG;
   }
}
