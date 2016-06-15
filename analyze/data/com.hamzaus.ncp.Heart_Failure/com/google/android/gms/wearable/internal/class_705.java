package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.class_743;
import com.google.android.gms.wearable.internal.class_704;
import com.google.android.gms.wearable.internal.r;

// $FF: renamed from: com.google.android.gms.wearable.internal.r
public class class_705 implements SafeParcelable {
   public static final Creator<r> CREATOR = new class_704();
   public final class_743 alJ;
   public final int statusCode;
   public final int versionCode;

   class_705(int var1, int var2, class_743 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.alJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_704.method_4036(this, var1, var2);
   }
}
