package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ap;
import com.google.android.gms.wearable.internal.class_908;
import com.google.android.gms.wearable.internal.class_984;

// $FF: renamed from: com.google.android.gms.wearable.internal.ap
public class class_981 implements SafeParcelable {
   public static final Creator<ap> CREATOR = new class_984();
   public final class_908 axM;
   public final int statusCode;
   public final int versionCode;

   class_981(int var1, int var2, class_908 var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_984.method_5477(this, var1, var2);
   }
}
