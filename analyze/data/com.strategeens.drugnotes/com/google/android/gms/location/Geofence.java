package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.class_757;

public interface Geofence {
   int GEOFENCE_TRANSITION_DWELL = 4;
   int GEOFENCE_TRANSITION_ENTER = 1;
   int GEOFENCE_TRANSITION_EXIT = 2;
   long NEVER_EXPIRE = -1L;

   String getRequestId();

   public static final class Builder {
      // $FF: renamed from: Zt java.lang.String
      private String field_3744 = null;
      private int agd = 0;
      private long age = Long.MIN_VALUE;
      private short agf = -1;
      private double agg;
      private double agh;
      private float agi;
      private int agj = 0;
      private int agk = -1;

      public Geofence build() {
         if(this.field_3744 == null) {
            throw new IllegalArgumentException("Request ID not set.");
         } else if(this.agd == 0) {
            throw new IllegalArgumentException("Transitions types not set.");
         } else if((4 & this.agd) != 0 && this.agk < 0) {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
         } else if(this.age == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Expiration not set.");
         } else if(this.agf == -1) {
            throw new IllegalArgumentException("Geofence region not set.");
         } else if(this.agj < 0) {
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
         } else {
            return new class_757(this.field_3744, this.agd, (short)1, this.agg, this.agh, this.agi, this.age, this.agj, this.agk);
         }
      }

      public Geofence.Builder setCircularRegion(double var1, double var3, float var5) {
         this.agf = 1;
         this.agg = var1;
         this.agh = var3;
         this.agi = var5;
         return this;
      }

      public Geofence.Builder setExpirationDuration(long var1) {
         if(var1 < 0L) {
            this.age = -1L;
            return this;
         } else {
            this.age = var1 + SystemClock.elapsedRealtime();
            return this;
         }
      }

      public Geofence.Builder setLoiteringDelay(int var1) {
         this.agk = var1;
         return this;
      }

      public Geofence.Builder setNotificationResponsiveness(int var1) {
         this.agj = var1;
         return this;
      }

      public Geofence.Builder setRequestId(String var1) {
         this.field_3744 = var1;
         return this;
      }

      public Geofence.Builder setTransitionTypes(int var1) {
         this.agd = var1;
         return this;
      }
   }
}
