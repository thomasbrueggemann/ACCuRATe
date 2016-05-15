package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationAvailabilityCreator;

public final class LocationAvailability implements SafeParcelable {
   public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
   private final int mVersionCode;
   int zzaNU;
   int zzaNV;
   long zzaNW;
   int zzaNX;

   LocationAvailability(int var1, int var2, int var3, int var4, long var5) {
      this.mVersionCode = var1;
      this.zzaNX = var2;
      this.zzaNU = var3;
      this.zzaNV = var4;
      this.zzaNW = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof LocationAvailability) {
         LocationAvailability var2 = (LocationAvailability)var1;
         if(this.zzaNX == var2.zzaNX && this.zzaNU == var2.zzaNU && this.zzaNV == var2.zzaNV && this.zzaNW == var2.zzaNW) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaNX), Integer.valueOf(this.zzaNU), Integer.valueOf(this.zzaNV), Long.valueOf(this.zzaNW)};
      return zzw.hashCode(var1);
   }

   public boolean isLocationAvailable() {
      return this.zzaNX < 1000;
   }

   public String toString() {
      return "LocationAvailability[isLocationAvailable: " + this.isLocationAvailable() + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      LocationAvailabilityCreator.zza(this, var1, var2);
   }
}
