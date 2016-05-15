package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable implements Parcelable {
   private transient volatile boolean zzapw = false;

   public void writeToParcel(Parcel var1, int var2) {
      boolean var3;
      if(!this.zzsT()) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzx.zzab(var3);
      this.zzapw = true;
      this.zzJ(var1, var2);
   }

   protected abstract void zzJ(Parcel var1, int var2);

   public final boolean zzsT() {
      return this.zzapw;
   }
}
