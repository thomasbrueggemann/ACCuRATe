package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.at;
import com.google.android.gms.wearable.internal.class_996;

// $FF: renamed from: com.google.android.gms.wearable.internal.at
public class class_993 implements SafeParcelable {
   public static final Creator<at> CREATOR = new class_996();
   public final int ayd;
   public final int statusCode;
   public final int versionCode;

   class_993(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.ayd = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_996.method_5492(this, var1, var2);
   }
}
