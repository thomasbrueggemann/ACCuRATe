package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.zzg;

public class DataSourceQueryParams implements SafeParcelable {
   public static final Creator<DataSourceQueryParams> CREATOR = new zzg();
   final int mVersionCode;
   public final long zzUZ;
   public final int zzaAO;
   public final long zzaAT;
   public final int zzaAU;
   public final DataSource zzavU;
   public final long zzawk;

   DataSourceQueryParams(int var1, DataSource var2, long var3, long var5, long var7, int var9, int var10) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzUZ = var3;
      this.zzawk = var5;
      this.zzaAT = var7;
      this.zzaAO = var9;
      this.zzaAU = var10;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
