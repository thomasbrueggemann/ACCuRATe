package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.as;
import com.google.android.gms.wearable.internal.class_765;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.as
public class class_766 implements SafeParcelable {
   public static final Creator<as> CREATOR = new class_765();
   public final long alY;
   public final List<ak> ama;
   public final int statusCode;
   public final int versionCode;

   class_766(int var1, int var2, long var3, List<ak> var5) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alY = var3;
      this.ama = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_765.method_4340(this, var1, var2);
   }
}
