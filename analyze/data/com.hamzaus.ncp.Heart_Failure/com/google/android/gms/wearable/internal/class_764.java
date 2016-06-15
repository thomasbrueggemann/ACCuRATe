package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.am;
import com.google.android.gms.wearable.internal.class_696;
import com.google.android.gms.wearable.internal.class_763;

// $FF: renamed from: com.google.android.gms.wearable.internal.am
public class class_764 implements SafeParcelable {
   public static final Creator<am> CREATOR = new class_763();
   public final class_696 alL;
   public final int statusCode;
   public final int versionCode;

   class_764(int var1, int var2, class_696 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_763.method_4337(this, var1, var2);
   }
}
