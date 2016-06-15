package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.al;
import com.google.android.gms.wearable.internal.class_921;
import com.google.android.gms.wearable.internal.v;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.v
public class class_920 implements SafeParcelable {
   public static final Creator<v> CREATOR = new class_921();
   public final List<al> axL;
   public final int statusCode;
   public final int versionCode;

   class_920(int var1, int var2, List<al> var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_921.method_5088(this, var1, var2);
   }
}
