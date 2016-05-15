package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzs;

public class Subscription implements SafeParcelable {
   public static final Creator<Subscription> CREATOR = new zzs();
   private final int mVersionCode;
   private final DataType zzavT;
   private final DataSource zzavU;
   private final long zzaxo;
   private final int zzaxp;

   Subscription(int var1, DataSource var2, DataType var3, long var4, int var6) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzavT = var3;
      this.zzaxo = var4;
      this.zzaxp = var6;
   }

   private boolean zza(Subscription var1) {
      return zzw.equal(this.zzavU, var1.zzavU) && zzw.equal(this.zzavT, var1.zzavT) && this.zzaxo == var1.zzaxo && this.zzaxp == var1.zzaxp;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Subscription && this.zza((Subscription)var1);
   }

   public int getAccuracyMode() {
      return this.zzaxp;
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU, this.zzavU, Long.valueOf(this.zzaxo), Integer.valueOf(this.zzaxp)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("samplingIntervalMicros", Long.valueOf(this.zzaxo)).zzg("accuracyMode", Integer.valueOf(this.zzaxp)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzs.zza(this, var1, var2);
   }

   public long zzux() {
      return this.zzaxo;
   }
}
