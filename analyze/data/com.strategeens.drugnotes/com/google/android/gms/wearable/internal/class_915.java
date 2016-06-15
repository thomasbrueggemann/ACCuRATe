package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.class_962;
import com.google.android.gms.wearable.internal.class_914;
import com.google.android.gms.wearable.internal.t;

// $FF: renamed from: com.google.android.gms.wearable.internal.t
public class class_915 implements SafeParcelable {
   public static final Creator<t> CREATOR = new class_914();
   public final class_962[] axK;
   public final int statusCode;
   public final int versionCode;

   class_915(int var1, int var2, class_962[] var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_914.method_5079(this, var1, var2);
   }
}
