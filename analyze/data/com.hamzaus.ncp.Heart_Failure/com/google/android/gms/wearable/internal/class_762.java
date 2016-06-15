package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.class_761;

// $FF: renamed from: com.google.android.gms.wearable.internal.ak
public class class_762 implements SafeParcelable {
   public static final Creator<ak> CREATOR = new class_761();
   public final long alY;
   public final String label;
   public final String packageName;
   public final int versionCode;

   class_762(int var1, String var2, String var3, long var4) {
      this.versionCode = var1;
      this.packageName = var2;
      this.label = var3;
      this.alY = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_761.method_4334(this, var1, var2);
   }
}
