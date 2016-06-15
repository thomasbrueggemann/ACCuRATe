package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_390;

// $FF: renamed from: com.google.android.gms.internal.fn
public class class_391 implements SafeParcelable {
   public static final class_390 CREATOR = new class_390();
   // $FF: renamed from: id int
   public final int field_1757;
   // $FF: renamed from: xJ int
   final int field_1758;
   // $FF: renamed from: xV android.os.Bundle
   final Bundle field_1759;

   class_391(int var1, int var2, Bundle var3) {
      this.field_1758 = var1;
      this.field_1757 = var2;
      this.field_1759 = var3;
   }

   public int describeContents() {
      class_390 var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_390 var10000 = CREATOR;
      class_390.method_2470(this, var1, var2);
   }
}
