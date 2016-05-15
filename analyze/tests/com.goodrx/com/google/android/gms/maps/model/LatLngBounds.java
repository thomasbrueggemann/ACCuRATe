package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zzd;

public final class LatLngBounds implements SafeParcelable {
   public static final zzd CREATOR = new zzd();
   private final int mVersionCode;
   public final LatLng northeast;
   public final LatLng southwest;

   LatLngBounds(int var1, LatLng var2, LatLng var3) {
      zzx.zzb(var2, "null southwest");
      zzx.zzb(var3, "null northeast");
      boolean var6;
      if(var3.latitude >= var2.latitude) {
         var6 = true;
      } else {
         var6 = false;
      }

      Object[] var7 = new Object[]{Double.valueOf(var2.latitude), Double.valueOf(var3.latitude)};
      zzx.zzb(var6, "southern latitude exceeds northern latitude (%s > %s)", var7);
      this.mVersionCode = var1;
      this.southwest = var2;
      this.northeast = var3;
   }

   public LatLngBounds(LatLng var1, LatLng var2) {
      this(1, var1, var2);
   }

   private static double zzb(double var0, double var2) {
      return (360.0D + (var0 - var2)) % 360.0D;
   }

   private static double zzc(double var0, double var2) {
      return (360.0D + (var2 - var0)) % 360.0D;
   }

   // $FF: synthetic method
   static double zzd(double var0, double var2) {
      return zzb(var0, var2);
   }

   // $FF: synthetic method
   static double zze(double var0, double var2) {
      return zzc(var0, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LatLngBounds)) {
            return false;
         }

         LatLngBounds var2 = (LatLngBounds)var1;
         if(!this.southwest.equals(var2.southwest) || !this.northeast.equals(var2.northeast)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.southwest, this.northeast};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }

   public static final class Builder {
      private double zzaTu = Double.POSITIVE_INFINITY;
      private double zzaTv = Double.NEGATIVE_INFINITY;
      private double zzaTw = Double.NaN;
      private double zzaTx = Double.NaN;

      private boolean zzj(double var1) {
         if(this.zzaTw <= this.zzaTx) {
            return this.zzaTw <= var1 && var1 <= this.zzaTx;
         } else {
            boolean var3;
            if(this.zzaTw > var1) {
               double var5;
               int var4 = (var5 = var1 - this.zzaTx) == 0.0D?0:(var5 < 0.0D?-1:1);
               var3 = false;
               if(var4 > 0) {
                  return var3;
               }
            }

            var3 = true;
            return var3;
         }
      }

      public LatLngBounds build() {
         boolean var1;
         if(!Double.isNaN(this.zzaTw)) {
            var1 = true;
         } else {
            var1 = false;
         }

         zzx.zza(var1, "no included points");
         return new LatLngBounds(new LatLng(this.zzaTu, this.zzaTw), new LatLng(this.zzaTv, this.zzaTx));
      }

      public LatLngBounds.Builder include(LatLng var1) {
         this.zzaTu = Math.min(this.zzaTu, var1.latitude);
         this.zzaTv = Math.max(this.zzaTv, var1.latitude);
         double var2 = var1.longitude;
         if(Double.isNaN(this.zzaTw)) {
            this.zzaTw = var2;
            this.zzaTx = var2;
         } else if(!this.zzj(var2)) {
            if(LatLngBounds.zzd(this.zzaTw, var2) < LatLngBounds.zze(this.zzaTx, var2)) {
               this.zzaTw = var2;
               return this;
            }

            this.zzaTx = var2;
            return this;
         }

         return this;
      }
   }
}
