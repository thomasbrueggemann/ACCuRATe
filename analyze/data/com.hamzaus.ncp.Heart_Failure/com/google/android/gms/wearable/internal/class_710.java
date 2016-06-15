package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_767;
import com.google.android.gms.wearable.internal.class_770;
import com.google.android.gms.wearable.internal.z;

// $FF: renamed from: com.google.android.gms.wearable.internal.z
public class class_710 implements SafeParcelable {
   public static final Creator<z> CREATOR = new class_767();
   public final class_770 alN;
   public final int statusCode;
   public final int versionCode;

   class_710(int var1, int var2, class_770 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alN = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_767.method_4343(this, var1, var2);
   }
}
