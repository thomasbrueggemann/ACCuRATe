package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;
import com.google.android.gms.drive.internal.class_784;

public class OnStorageStatsResponse implements SafeParcelable {
   public static final Creator<OnStorageStatsResponse> CREATOR = new class_784();
   // $FF: renamed from: JA com.google.android.gms.drive.StorageStats
   StorageStats field_4318;
   // $FF: renamed from: xJ int
   final int field_4319;

   OnStorageStatsResponse(int var1, StorageStats var2) {
      this.field_4319 = var1;
      this.field_4318 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_784.method_4389(this, var1, var2);
   }
}
