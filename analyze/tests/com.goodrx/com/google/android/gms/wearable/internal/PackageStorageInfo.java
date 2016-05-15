package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzbe;

public class PackageStorageInfo implements SafeParcelable {
   public static final Creator<PackageStorageInfo> CREATOR = new zzbe();
   public final String label;
   public final String packageName;
   public final int versionCode;
   public final long zzbta;

   PackageStorageInfo(int var1, String var2, String var3, long var4) {
      this.versionCode = var1;
      this.packageName = var2;
      this.label = var3;
      this.zzbta = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbe.zza(this, var1, var2);
   }
}
