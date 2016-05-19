package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.PackageStorageInfo;
import com.google.android.gms.wearable.internal.zzbl;
import java.util.List;

public class StorageInfoResponse implements SafeParcelable {
   public static final Creator<StorageInfoResponse> CREATOR = new zzbl();
   public final int statusCode;
   public final int versionCode;
   public final long zzbta;
   public final List<PackageStorageInfo> zzbtc;

   StorageInfoResponse(int var1, int var2, long var3, List<PackageStorageInfo> var5) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbta = var3;
      this.zzbtc = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbl.zza(this, var1, var2);
   }
}
