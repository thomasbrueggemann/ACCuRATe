package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_696;
import com.google.android.gms.wearable.internal.class_709;
import com.google.android.gms.wearable.internal.v;

// $FF: renamed from: com.google.android.gms.wearable.internal.v
public class class_708 implements SafeParcelable {
   public static final Creator<v> CREATOR = new class_709();
   public final class_696 alL;
   public final int statusCode;
   public final int versionCode;

   class_708(int var1, int var2, class_696 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_709.method_4042(this, var1, var2);
   }
}
