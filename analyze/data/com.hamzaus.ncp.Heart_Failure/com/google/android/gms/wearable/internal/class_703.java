package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.class_702;
import com.google.android.gms.wearable.internal.t;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.t
public class class_703 implements SafeParcelable {
   public static final Creator<t> CREATOR = new class_702();
   public final List<ai> alK;
   public final int statusCode;
   public final int versionCode;

   class_703(int var1, int var2, List<ai> var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_702.method_4033(this, var1, var2);
   }
}
