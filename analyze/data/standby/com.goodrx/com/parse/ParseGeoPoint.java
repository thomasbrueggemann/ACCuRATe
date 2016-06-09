package com.parse;

import android.location.Criteria;
import android.location.Location;
import bolts.Continuation;
import bolts.Task;
import com.parse.LocationCallback;
import com.parse.LocationNotifier;
import com.parse.Parse;
import com.parse.ParseCallback2;
import com.parse.ParseTaskUtils;
import java.util.Locale;

public class ParseGeoPoint {
   static double EARTH_MEAN_RADIUS_KM = 6371.0D;
   static double EARTH_MEAN_RADIUS_MILE = 3958.8D;
   private double latitude;
   private double longitude;

   public ParseGeoPoint() {
      this.latitude = 0.0D;
      this.longitude = 0.0D;
   }

   public ParseGeoPoint(double var1, double var3) {
      this.latitude = 0.0D;
      this.longitude = 0.0D;
      this.setLatitude(var1);
      this.setLongitude(var3);
   }

   public ParseGeoPoint(ParseGeoPoint var1) {
      this(var1.getLatitude(), var1.getLongitude());
   }

   public static Task<ParseGeoPoint> getCurrentLocationInBackground(long var0) {
      Criteria var2 = new Criteria();
      var2.setAccuracy(0);
      var2.setPowerRequirement(0);
      return LocationNotifier.getCurrentLocationAsync(Parse.getApplicationContext(), var0, var2).onSuccess(new Continuation() {
         public ParseGeoPoint then(Task<Location> var1) throws Exception {
            Location var2 = (Location)var1.getResult();
            return new ParseGeoPoint(var2.getLatitude(), var2.getLongitude());
         }
      });
   }

   public static Task<ParseGeoPoint> getCurrentLocationInBackground(long var0, Criteria var2) {
      return LocationNotifier.getCurrentLocationAsync(Parse.getApplicationContext(), var0, var2).onSuccess(new Continuation() {
         public ParseGeoPoint then(Task<Location> var1) throws Exception {
            Location var2 = (Location)var1.getResult();
            return new ParseGeoPoint(var2.getLatitude(), var2.getLongitude());
         }
      });
   }

   public static void getCurrentLocationInBackground(long var0, Criteria var2, LocationCallback var3) {
      ParseTaskUtils.callbackOnMainThreadAsync(getCurrentLocationInBackground(var0, var2), (ParseCallback2)var3);
   }

   public static void getCurrentLocationInBackground(long var0, LocationCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(getCurrentLocationInBackground(var0), (ParseCallback2)var2);
   }

   public double distanceInKilometersTo(ParseGeoPoint var1) {
      return this.distanceInRadiansTo(var1) * EARTH_MEAN_RADIUS_KM;
   }

   public double distanceInMilesTo(ParseGeoPoint var1) {
      return this.distanceInRadiansTo(var1) * EARTH_MEAN_RADIUS_MILE;
   }

   public double distanceInRadiansTo(ParseGeoPoint var1) {
      double var2 = 0.017453292519943295D * this.latitude;
      double var4 = 0.017453292519943295D * this.longitude;
      double var6 = 0.017453292519943295D * var1.getLatitude();
      double var8 = 0.017453292519943295D * var1.getLongitude();
      double var10 = var2 - var6;
      double var12 = var4 - var8;
      double var14 = Math.sin(var10 / 2.0D);
      double var16 = Math.sin(var12 / 2.0D);
      return 2.0D * Math.asin(Math.sqrt(Math.min(1.0D, var14 * var14 + var16 * var16 * Math.cos(var2) * Math.cos(var6))));
   }

   public double getLatitude() {
      return this.latitude;
   }

   public double getLongitude() {
      return this.longitude;
   }

   public void setLatitude(double var1) {
      if(var1 <= 90.0D && var1 >= -90.0D) {
         this.latitude = var1;
      } else {
         throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
      }
   }

   public void setLongitude(double var1) {
      if(var1 <= 180.0D && var1 >= -180.0D) {
         this.longitude = var1;
      } else {
         throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
      }
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{Double.valueOf(this.latitude), Double.valueOf(this.longitude)};
      return String.format(var1, "ParseGeoPoint[%.6f,%.6f]", var2);
   }
}
