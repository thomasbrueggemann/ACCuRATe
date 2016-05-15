package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.zzd;

public class DataSourceStatsResult implements SafeParcelable {
   public static final Creator<DataSourceStatsResult> CREATOR = new zzd();
   final int mVersionCode;
   public final long zzUZ;
   public final boolean zzaBI;
   public final long zzaBJ;
   public final long zzaBK;
   public final DataSource zzavU;

   DataSourceStatsResult(int var1, DataSource var2, long var3, boolean var5, long var6, long var8) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzUZ = var3;
      this.zzaBI = var5;
      this.zzaBJ = var6;
      this.zzaBK = var8;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
