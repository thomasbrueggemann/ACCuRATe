package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zze;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
   public static final Creator<LocationResult> CREATOR = new zze();
   static final List<Location> zzaOd = Collections.emptyList();
   private final int mVersionCode;
   private final List<Location> zzaOe;

   LocationResult(int var1, List<Location> var2) {
      this.mVersionCode = var1;
      this.zzaOe = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof LocationResult)) {
         return false;
      } else {
         LocationResult var2 = (LocationResult)var1;
         if(var2.zzaOe.size() != this.zzaOe.size()) {
            return false;
         } else {
            Iterator var3 = var2.zzaOe.iterator();
            Iterator var4 = this.zzaOe.iterator();

            Location var5;
            Location var6;
            do {
               if(!var3.hasNext()) {
                  return true;
               }

               var5 = (Location)var4.next();
               var6 = (Location)var3.next();
            } while(var5.getTime() == var6.getTime());

            return false;
         }
      }
   }

   @NonNull
   public List<Location> getLocations() {
      return this.zzaOe;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Iterator var1 = this.zzaOe.iterator();

      int var2;
      long var3;
      for(var2 = 17; var1.hasNext(); var2 = (int)(var3 ^ var3 >>> 32) + var2 * 31) {
         var3 = ((Location)var1.next()).getTime();
      }

      return var2;
   }

   public String toString() {
      return "LocationResult[locations: " + this.zzaOe + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
