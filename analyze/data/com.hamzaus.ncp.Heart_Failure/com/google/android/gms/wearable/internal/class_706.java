package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_707;
import com.google.android.gms.wearable.internal.x;

// $FF: renamed from: com.google.android.gms.wearable.internal.x
public class class_706 implements SafeParcelable {
   public static final Creator<x> CREATOR = new class_707();
   public final ParcelFileDescriptor alM;
   public final int statusCode;
   public final int versionCode;

   class_706(int var1, int var2, ParcelFileDescriptor var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_707.method_4039(this, var1, var2 | 1);
   }
}
