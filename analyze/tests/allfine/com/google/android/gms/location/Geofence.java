package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.class_828;

public interface Geofence {
    int GEOFENCE_TRANSITION_DWELL = 4;
    int GEOFENCE_TRANSITION_ENTER = 1;
    int GEOFENCE_TRANSITION_EXIT = 2;
    long NEVER_EXPIRE = -1L;

    String getRequestId();

    public static final class Builder {
        // $FF: renamed from: XC java.lang.String
        private String field_4486 = null;
        private int aeh = 0;
        private long aei = Long.MIN_VALUE;
        private short aej = -1;
        private double aek;
        private double ael;
        private float aem;
        private int aen = 0;
        private int aeo = -1;

        public Geofence build() {
            if(this.field_4486 == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if(this.aeh == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if((4 & this.aeh) != 0 && this.aeo < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if(this.aei == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if(this.aej == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if(this.aen < 0) {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            } else {
                return new class_828(this.field_4486, this.aeh, (short)1, this.aek, this.ael, this.aem, this.aei, this.aen, this.aeo);
            }
        }

        public Geofence.Builder setCircularRegion(double var1, double var3, float var5) {
            this.aej = 1;
            this.aek = var1;
            this.ael = var3;
            this.aem = var5;
            return this;
        }

        public Geofence.Builder setExpirationDuration(long var1) {
            if(var1 < 0L) {
                this.aei = -1L;
                return this;
            } else {
                this.aei = var1 + SystemClock.elapsedRealtime();
                return this;
            }
        }

        public Geofence.Builder setLoiteringDelay(int var1) {
            this.aeo = var1;
            return this;
        }

        public Geofence.Builder setNotificationResponsiveness(int var1) {
            this.aen = var1;
            return this;
        }

        public Geofence.Builder setRequestId(String var1) {
            this.field_4486 = var1;
            return this;
        }

        public Geofence.Builder setTransitionTypes(int var1) {
            this.aeh = var1;
            return this;
        }
    }
}
