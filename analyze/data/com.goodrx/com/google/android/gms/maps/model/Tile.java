package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.zzn;

public final class Tile implements SafeParcelable {
   public static final zzn CREATOR = new zzn();
   public final byte[] data;
   public final int height;
   private final int mVersionCode;
   public final int width;

   Tile(int var1, int var2, int var3, byte[] var4) {
      this.mVersionCode = var1;
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
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
