package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_908;
import com.google.android.gms.wearable.internal.class_919;
import com.google.android.gms.wearable.internal.x;

// $FF: renamed from: com.google.android.gms.wearable.internal.x
public class class_918 implements SafeParcelable {
   public static final Creator<x> CREATOR = new class_919();
   public final class_908 axM;
   public final int statusCode;
   public final int versionCode;

   class_918(int var1, int var2, class_908 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_919.method_5085(this, var1, var2);
   }
}
