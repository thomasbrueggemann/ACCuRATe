package com.goodrx.model;

import android.location.Location;
import com.goodrx.utils.Utils;

public class LocationEntity {
   private String city;
   private LocationEntity.Coords coords;
   private Integer distance;
   private String full_state;
   private String state;
   private String zip;

   public double distanceTo(Location var1) {
      Location var2 = new Location("current");
      var2.setLatitude(this.getLatitude());
      var2.setLongitude(this.getLongitude());
      return (double)var2.distanceTo(var1);
   }

   public double distanceTo(LocationEntity var1) {
      if(var1 == null) {
         return -1.0D;
      } else {
         Location var2 = new Location("other");
         var2.setLatitude(var1.getLatitude());
         var2.setLongitude(var1.getLongitude());
         return this.distanceTo(var2);
      }
   }

   public String getCity() {
      return this.city;
   }

   public String getDisplay() {
      StringBuilder var1 = new StringBuilder();
      String[] var2 = new String[]{this.city};
      if(Utils.isValidString(var2)) {
         var1.append(this.city).append(", ");
         var1.append(this.state);
      } else {
         var1.append(this.full_state);
      }

      return var1.toString();
   }

   public Integer getDistance() {
      return this.distance;
   }

   public String getFullDisplay() {
      StringBuilder var1 = new StringBuilder(this.getDisplay());
      String[] var2 = new String[]{this.zip};
      if(Utils.isValidString(var2)) {
         var1.append(" (").append(this.zip).append(")");
      }

      return var1.toString();
   }

   public double getLatitude() {
      return this.coords.getLatitude();
   }

   public double getLongitude() {
      return this.coords.getLongitude();
   }

   public String getState() {
      return this.state;
   }

   public boolean isValid() {
      String[] var1 = new String[]{this.state};
      return Utils.isValidString(var1);
   }

   public void setLatitude(double var1) {
      this.coords.setLatitude(var1);
   }

   public void setLongitude(double var1) {
      this.coords.setLongitude(var1);
   }

   public class Coords {
      private double latitude;
      private double longitude;

      public double getLatitude() {
         return this.latitude;
      }

      public double getLongitude() {
         return this.longitude;
      }

      public void setLatitude(double var1) {
         this.latitude = var1;
      }

      public void setLongitude(double var1) {
         this.longitude = var1;
      }
   }
}
