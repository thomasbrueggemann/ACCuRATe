package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_699;
import com.google.android.gms.wearable.internal.p;

// $FF: renamed from: com.google.android.gms.wearable.internal.p
public class class_700 implements SafeParcelable {
   public static final Creator<p> CREATOR = new class_699();
   public final int alI;
   public final int statusCode;
   public final int versionCode;

   class_700(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alI = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_699.method_4027(this, var1, var2);
   }
}
