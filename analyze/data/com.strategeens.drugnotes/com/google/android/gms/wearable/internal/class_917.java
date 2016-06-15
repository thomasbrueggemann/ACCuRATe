package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.class_962;
import com.google.android.gms.wearable.internal.class_916;
import com.google.android.gms.wearable.internal.r;

// $FF: renamed from: com.google.android.gms.wearable.internal.r
@Deprecated
public class class_917 implements SafeParcelable {
   public static final Creator<r> CREATOR = new class_916();
   public final class_962 axJ;
   public final int statusCode;
   public final int versionCode;

   class_917(int var1, int var2, class_962 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_916.method_5082(this, var1, var2);
   }
}
