package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.TileCreator;
import com.google.android.gms.maps.model.class_689;

public final class Tile implements SafeParcelable {
   public static final TileCreator CREATOR = new TileCreator();
   public final byte[] data;
   public final int height;
   public final int width;
   // $FF: renamed from: xJ int
   private final int field_4241;

   Tile(int var1, int var2, int var3, byte[] var4) {
      this.field_4241 = var1;
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
      return this.field_4241;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_689.method_4005(this, var1, var2);
      } else {
         TileCreator.method_2685(this, var1, var2);
      }
   }
}
