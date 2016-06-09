package android.support.v7.media;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;

public final class MediaSessionStatus {
   private static final String KEY_EXTRAS = "extras";
   private static final String KEY_QUEUE_PAUSED = "queuePaused";
   private static final String KEY_SESSION_STATE = "sessionState";
   private static final String KEY_TIMESTAMP = "timestamp";
   public static final int SESSION_STATE_ACTIVE = 0;
   public static final int SESSION_STATE_ENDED = 1;
   public static final int SESSION_STATE_INVALIDATED = 2;
   private final Bundle mBundle;

   private MediaSessionStatus(Bundle var1) {
      this.mBundle = var1;
   }

   // $FF: synthetic method
   MediaSessionStatus(Bundle var1, Object var2) {
      this(var1);
   }

   public static MediaSessionStatus fromBundle(Bundle var0) {
      return var0 != null?new MediaSessionStatus(var0):null;
   }

   private static String sessionStateToString(int var0) {
      switch(var0) {
      case 0:
         return "active";
      case 1:
         return "ended";
      case 2:
         return "invalidated";
      default:
         return Integer.toString(var0);
      }
   }

   public Bundle asBundle() {
      return this.mBundle;
   }

   public Bundle getExtras() {
      return this.mBundle.getBundle("extras");
   }

   public int getSessionState() {
      return this.mBundle.getInt("sessionState", 2);
   }

   public long getTimestamp() {
      return this.mBundle.getLong("timestamp");
   }

   public boolean isQueuePaused() {
      return this.mBundle.getBoolean("queuePaused");
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediaSessionStatus{ ");
      var1.append("timestamp=");
      TimeUtils.formatDuration(SystemClock.elapsedRealtime() - this.getTimestamp(), var1);
      var1.append(" ms ago");
      var1.append(", sessionState=").append(sessionStateToString(this.getSessionState()));
      var1.append(", queuePaused=").append(this.isQueuePaused());
      var1.append(", extras=").append(this.getExtras());
      var1.append(" }");
      return var1.toString();
   }

   public static final class Builder {
      private final Bundle mBundle;

      public Builder(int var1) {
         this.mBundle = new Bundle();
         this.setTimestamp(SystemClock.elapsedRealtime());
         this.setSessionState(var1);
      }

      public Builder(MediaSessionStatus var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("status must not be null");
         } else {
            this.mBundle = new Bundle(var1.mBundle);
         }
      }

      public MediaSessionStatus build() {
         return new MediaSessionStatus(this.mBundle);
      }

      public MediaSessionStatus.Builder setExtras(Bundle var1) {
         this.mBundle.putBundle("extras", var1);
         return this;
      }

      public MediaSessionStatus.Builder setQueuePaused(boolean var1) {
         this.mBundle.putBoolean("queuePaused", var1);
         return this;
      }

      public MediaSessionStatus.Builder setSessionState(int var1) {
         this.mBundle.putInt("sessionState", var1);
         return this;
      }

      public MediaSessionStatus.Builder setTimestamp(long var1) {
         this.mBundle.putLong("timestamp", var1);
         return this;
      }
   }
}
