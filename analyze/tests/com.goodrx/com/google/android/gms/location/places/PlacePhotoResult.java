package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.zzi;

public class PlacePhotoResult implements Result, SafeParcelable {
   public static final Creator<PlacePhotoResult> CREATOR = new zzi();
   private final Bitmap mBitmap;
   final int mVersionCode;
   private final Status zzUX;
   final BitmapTeleporter zzaPG;

   PlacePhotoResult(int var1, Status var2, BitmapTeleporter var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaPG = var3;
      if(this.zzaPG != null) {
         this.mBitmap = var3.zzqa();
      } else {
         this.mBitmap = null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("bitmap", this.mBitmap).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
