package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;
import com.google.android.gms.drive.internal.class_1008;

public class OnStorageStatsResponse implements SafeParcelable {
   public static final Creator<OnStorageStatsResponse> CREATOR = new class_1008();
   // $FF: renamed from: CK int
   final int field_4468;
   // $FF: renamed from: QS com.google.android.gms.drive.StorageStats
   StorageStats field_4469;

   OnStorageStatsResponse(int var1, StorageStats var2) {
      this.field_4468 = var1;
      this.field_4469 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1008.method_5573(this, var1, var2);
   }
}
