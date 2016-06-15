package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_887;
import com.google.android.gms.maps.model.class_892;

public final class LatLngBounds implements SafeParcelable {
   public static final class_887 CREATOR = new class_887();
   // $FF: renamed from: CK int
   private final int field_2907;
   public final LatLng northeast;
   public final LatLng southwest;

   LatLngBounds(int var1, LatLng var2, LatLng var3) {
      class_335.method_2306(var2, "null southwest");
      class_335.method_2306(var3, "null northeast");
      boolean var6;
      if(var3.latitude >= var2.latitude) {
         var6 = true;
      } else {
         var6 = false;
      }

      Object[] var7 = new Object[]{Double.valueOf(var2.latitude), Double.valueOf(var3.latitude)};
      class_335.method_2309(var6, "southern latitude exceeds northern latitude (%s > %s)", var7);
      this.field_2907 = var1;
      this.southwest = var2;
      this.northeast = var3;
   }

   public LatLngBounds(LatLng var1, LatLng var2) {
      this(1, var1, var2);
   }

   // $FF: renamed from: b (double, double) double
   private static double method_3814(double var0, double var2) {
      return (360.0D + (var0 - var2)) % 360.0D;
   }

   public static LatLngBounds.Builder builder() {
      return new LatLngBounds.Builder();
   }

   // $FF: renamed from: c (double, double) double
   private static double method_3815(double var0, double var2) {
      return (360.0D + (var2 - var0)) % 360.0D;
   }

   // $FF: renamed from: c (double) boolean
   private boolean method_3816(double var1) {
      return this.southwest.latitude <= var1 && var1 <= this.northeast.latitude;
   }

   // $FF: renamed from: d (double, double) double
   // $FF: synthetic method
   static double method_3817(double var0, double var2) {
      return method_3814(var0, var2);
   }

   // $FF: renamed from: d (double) boolean
   private boolean method_3818(double var1) {
      if(this.southwest.longitude <= this.northeast.longitude) {
         return this.southwest.longitude <= var1 && var1 <= this.northeast.longitude;
      } else {
         boolean var3;
         if(this.southwest.longitude > var1) {
            double var5;
            int var4 = (var5 = var1 - this.northeast.longitude) == 0.0D?0:(var5 < 0.0D?-1:1);
            var3 = false;
            if(var4 > 0) {
               return var3;
            }
         }

         var3 = true;
         return var3;
      }
   }

   // $FF: renamed from: e (double, double) double
   // $FF: synthetic method
   static double method_3819(double var0, double var2) {
      return method_3815(var0, var2);
   }

   public boolean contains(LatLng var1) {
      return this.method_3816(var1.latitude) && this.method_3818(var1.longitude);
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

   public LatLng getCenter() {
      double var1 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
      double var3 = this.northeast.longitude;
      double var5 = this.southwest.longitude;
      double var7;
      if(var5 <= var3) {
         var7 = (var3 + var5) / 2.0D;
      } else {
         var7 = (var5 + var3 + 360.0D) / 2.0D;
      }

      return new LatLng(var1, var7);
   }

   int getVersionCode() {
      return this.field_2907;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.southwest, this.northeast};
      return class_336.hashCode(var1);
   }

   public LatLngBounds including(LatLng var1) {
      double var2 = Math.min(this.southwest.latitude, var1.latitude);
      double var4 = Math.max(this.northeast.latitude, var1.latitude);
      double var6 = this.northeast.longitude;
      double var8 = this.southwest.longitude;
      double var10 = var1.longitude;
      double var12;
      if(!this.method_3818(var10)) {
         if(method_3814(var8, var10) < method_3815(var6, var10)) {
            var12 = var6;
         } else {
            var12 = var10;
            var10 = var8;
         }
      } else {
         var10 = var8;
         var12 = var6;
      }

      return new LatLngBounds(new LatLng(var2, var10), new LatLng(var4, var12));
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("southwest", this.southwest).method_3424("northeast", this.northeast).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_892.method_5010(this, var1, var2);
      } else {
         class_887.method_4999(this, var1, var2);
      }
   }

   public static final class Builder {
      private double amk = Double.POSITIVE_INFINITY;
      private double aml = Double.NEGATIVE_INFINITY;
      private double amm = Double.NaN;
      private double amn = Double.NaN;

      // $FF: renamed from: d (double) boolean
      private boolean method_3561(double var1) {
         if(this.amm <= this.amn) {
            return this.amm <= var1 && var1 <= this.amn;
         } else {
            boolean var3;
            if(this.amm > var1) {
               double var5;
               int var4 = (var5 = var1 - this.amn) == 0.0D?0:(var5 < 0.0D?-1:1);
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
         if(!Double.isNaN(this.amm)) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2302(var1, "no included points");
         return new LatLngBounds(new LatLng(this.amk, this.amm), new LatLng(this.aml, this.amn));
      }

      public LatLngBounds.Builder include(LatLng var1) {
         this.amk = Math.min(this.amk, var1.latitude);
         this.aml = Math.max(this.aml, var1.latitude);
         double var2 = var1.longitude;
         if(Double.isNaN(this.amm)) {
            this.amm = var2;
            this.amn = var2;
         } else if(!this.method_3561(var2)) {
            if(LatLngBounds.method_3817(this.amm, var2) < LatLngBounds.method_3819(this.amn, var2)) {
               this.amm = var2;
               return this;
            }

            this.amn = var2;
            return this;
         }

         return this;
      }
   }
}
