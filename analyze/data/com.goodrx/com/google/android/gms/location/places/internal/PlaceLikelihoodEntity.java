package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.zzm;

public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
   public static final Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
   final int mVersionCode;
   final PlaceImpl zzaQM;
   final float zzaQN;

   PlaceLikelihoodEntity(int var1, PlaceImpl var2, float var3) {
      this.mVersionCode = var1;
      this.zzaQM = var2;
      this.zzaQN = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlaceLikelihoodEntity)) {
            return false;
         }

         PlaceLikelihoodEntity var2 = (PlaceLikelihoodEntity)var1;
         if(!this.zzaQM.equals(var2.zzaQM) || this.zzaQN != var2.zzaQN) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzzy();
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaQM, Float.valueOf(this.zzaQN)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("place", this.zzaQM).zzg("likelihood", Float.valueOf(this.zzaQN)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }

   public PlaceLikelihood zzzy() {
      return this;
   }
}
