package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.zzh;

public class PlacePhotoMetadataResult implements Result, SafeParcelable {
   public static final Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
   final int mVersionCode;
   private final Status zzUX;
   final DataHolder zzaPE;
   private final PlacePhotoMetadataBuffer zzaPF;

   PlacePhotoMetadataResult(int var1, Status var2, DataHolder var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaPE = var3;
      if(var3 == null) {
         this.zzaPF = null;
      } else {
         this.zzaPF = new PlacePhotoMetadataBuffer(this.zzaPE);
      }
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
