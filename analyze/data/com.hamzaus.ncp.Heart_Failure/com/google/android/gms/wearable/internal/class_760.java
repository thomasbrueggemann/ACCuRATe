package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.aq;
import com.google.android.gms.wearable.internal.class_759;

// $FF: renamed from: com.google.android.gms.wearable.internal.aq
public class class_760 implements SafeParcelable {
   public static final Creator<aq> CREATOR = new class_759();
   public final int alZ;
   public final int statusCode;
   public final int versionCode;

   class_760(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alZ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_759.method_4331(this, var1, var2);
   }
}
