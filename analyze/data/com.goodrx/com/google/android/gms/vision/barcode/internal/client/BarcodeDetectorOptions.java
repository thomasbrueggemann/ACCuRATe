package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.barcode.internal.client.zza;

public class BarcodeDetectorOptions implements SafeParcelable {
   public static final zza CREATOR = new zza();
   final int versionCode;
   public int zzbnw;

   public BarcodeDetectorOptions() {
      this.versionCode = 1;
   }

   public BarcodeDetectorOptions(int var1, int var2) {
      this.versionCode = var1;
      this.zzbnw = var2;
   }

   public int describeContents() {
      zza var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza var10000 = CREATOR;
      zza.zza(this, var1, var2);
   }
}
