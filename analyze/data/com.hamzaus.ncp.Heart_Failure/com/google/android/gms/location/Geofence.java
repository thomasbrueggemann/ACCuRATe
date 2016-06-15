package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.class_314;

public interface Geofence {
   int GEOFENCE_TRANSITION_DWELL = 4;
   int GEOFENCE_TRANSITION_ENTER = 1;
   int GEOFENCE_TRANSITION_EXIT = 2;
   long NEVER_EXPIRE = -1L;

   String getRequestId();

   public static final class Builder {
      // $FF: renamed from: Oy java.lang.String
      private String field_3600 = null;
      // $FF: renamed from: UX int
      private int field_3601 = 0;
      // $FF: renamed from: UY long
      private long field_3602 = Long.MIN_VALUE;
      // $FF: renamed from: UZ short
      private short field_3603 = -1;
      // $FF: renamed from: Va double
      private double field_3604;
      // $FF: renamed from: Vb double
      private double field_3605;
      // $FF: renamed from: Vc float
      private float field_3606;
      // $FF: renamed from: Vd int
      private int field_3607 = 0;
      // $FF: renamed from: Ve int
      private int field_3608 = -1;

      public Geofence build() {
         if(this.field_3600 == null) {
            throw new IllegalArgumentException("Request ID not set.");
         } else if(this.field_3601 == 0) {
            throw new IllegalArgumentException("Transitions types not set.");
         } else if((4 & this.field_3601) != 0 && this.field_3608 < 0) {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
         } else if(this.field_3602 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Expiration not set.");
         } else if(this.field_3603 == -1) {
            throw new IllegalArgumentException("Geofence region not set.");
         } else if(this.field_3607 < 0) {
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
         } else {
            return new class_314(this.field_3600, this.field_3601, (short)1, this.field_3604, this.field_3605, this.field_3606, this.field_3602, this.field_3607, this.field_3608);
         }
      }

      public Geofence.Builder setCircularRegion(double var1, double var3, float var5) {
         this.field_3603 = 1;
         this.field_3604 = var1;
         this.field_3605 = var3;
         this.field_3606 = var5;
         return this;
      }

      public Geofence.Builder setExpirationDuration(long var1) {
         if(var1 < 0L) {
            this.field_3602 = -1L;
            return this;
         } else {
            this.field_3602 = var1 + SystemClock.elapsedRealtime();
            return this;
         }
      }

      public Geofence.Builder setLoiteringDelay(int var1) {
         this.field_3608 = var1;
         return this;
      }

      public Geofence.Builder setNotificationResponsiveness(int var1) {
         this.field_3607 = var1;
         return this;
      }

      public Geofence.Builder setRequestId(String var1) {
         this.field_3600 = var1;
         return this;
      }

      public Geofence.Builder setTransitionTypes(int var1) {
         this.field_3601 = var1;
         return this;
      }
   }
}
