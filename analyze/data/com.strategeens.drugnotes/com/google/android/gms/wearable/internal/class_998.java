package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ab;
import com.google.android.gms.wearable.internal.class_1002;
import com.google.android.gms.wearable.internal.class_985;

// $FF: renamed from: com.google.android.gms.wearable.internal.ab
public class class_998 implements SafeParcelable {
   public static final Creator<ab> CREATOR = new class_1002();
   public final class_985 axO;
   public final int statusCode;
   public final int versionCode;

   class_998(int var1, int var2, class_985 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axO = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1002.method_5502(this, var1, var2);
   }
}
