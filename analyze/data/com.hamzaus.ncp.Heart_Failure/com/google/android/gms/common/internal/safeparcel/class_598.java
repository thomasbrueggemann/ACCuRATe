package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.common.internal.safeparcel.c
public final class class_598 {
   // $FF: renamed from: a (com.google.android.gms.common.internal.safeparcel.SafeParcelable) byte[]
   public static <T extends SafeParcelable> byte[] method_3353(T var0) {
      Parcel var1 = Parcel.obtain();
      var0.writeToParcel(var1, 0);
      byte[] var2 = var1.marshall();
      var1.recycle();
      return var2;
   }
}
