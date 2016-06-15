package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.class_882;
import com.google.android.gms.maps.model.class_885;

public final class Tile implements SafeParcelable {
   public static final class_882 CREATOR = new class_882();
   // $FF: renamed from: CK int
   private final int field_4403;
   public final byte[] data;
   public final int height;
   public final int width;

   Tile(int var1, int var2, int var3, byte[] var4) {
      this.field_4403 = var1;
      this.width = var2;
      this.height = var3;
      this.data = var4;
   }

   public Tile(int var1, int var2, byte[] var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.field_4403;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_885.method_4979(this, var1, var2);
      } else {
         class_882.method_4970(this, var1, var2);
      }
   }
}
