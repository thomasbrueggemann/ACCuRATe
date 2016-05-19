package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.zzg;

public class DataTypeResult implements Result, SafeParcelable {
   public static final Creator<DataTypeResult> CREATOR = new zzg();
   private final int mVersionCode;
   private final Status zzUX;
   private final DataType zzavT;

   DataTypeResult(int var1, Status var2, DataType var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzavT = var3;
   }

   private boolean zzb(DataTypeResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzavT, var1.zzavT);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataTypeResult && this.zzb((DataTypeResult)var1);
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzavT};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataType", this.zzavT).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
