package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_997;
import com.google.android.gms.wearable.internal.z;

// $FF: renamed from: com.google.android.gms.wearable.internal.z
public class class_922 implements SafeParcelable {
   public static final Creator<z> CREATOR = new class_997();
   public final ParcelFileDescriptor axN;
   public final int statusCode;
   public final int versionCode;

   class_922(int var1, int var2, ParcelFileDescriptor var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axN = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_997.method_5495(this, var1, var2 | 1);
   }
}
