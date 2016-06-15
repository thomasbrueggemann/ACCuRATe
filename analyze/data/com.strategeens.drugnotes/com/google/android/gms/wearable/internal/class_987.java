package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.an;
import com.google.android.gms.wearable.internal.class_982;

// $FF: renamed from: com.google.android.gms.wearable.internal.an
public class class_987 implements SafeParcelable {
   public static final Creator<an> CREATOR = new class_982();
   public final long ayc;
   public final String label;
   public final String packageName;
   public final int versionCode;

   class_987(int var1, String var2, String var3, long var4) {
      this.versionCode = var1;
      this.packageName = var2;
      this.label = var3;
      this.ayc = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_982.method_5473(this, var1, var2);
   }
}
