package android.support.v7.media;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;

public final class MediaItemStatus {
   public static final String EXTRA_HTTP_RESPONSE_HEADERS = "android.media.status.extra.HTTP_RESPONSE_HEADERS";
   public static final String EXTRA_HTTP_STATUS_CODE = "android.media.status.extra.HTTP_STATUS_CODE";
   private static final String KEY_CONTENT_DURATION = "contentDuration";
   private static final String KEY_CONTENT_POSITION = "contentPosition";
   private static final String KEY_EXTRAS = "extras";
   private static final String KEY_PLAYBACK_STATE = "playbackState";
   private static final String KEY_TIMESTAMP = "timestamp";
   public static final int PLAYBACK_STATE_BUFFERING = 3;
   public static final int PLAYBACK_STATE_CANCELED = 5;
   public static final int PLAYBACK_STATE_ERROR = 7;
   public static final int PLAYBACK_STATE_FINISHED = 4;
   public static final int PLAYBACK_STATE_INVALIDATED = 6;
   public static final int PLAYBACK_STATE_PAUSED = 2;
   public static final int PLAYBACK_STATE_PENDING = 0;
   public static final int PLAYBACK_STATE_PLAYING = 1;
   private final Bundle mBundle;

   private MediaItemStatus(Bundle var1) {
      this.mBundle = var1;
   }

   // $FF: synthetic method
   MediaItemStatus(Bundle var1, Object var2) {
      this(var1);
   }

   public static MediaItemStatus fromBundle(Bundle var0) {
      return var0 != null?new MediaItemStatus(var0):null;
   }

   private static String playbackStateToString(int var0) {
      switch(var0) {
      case 0:
         return "pending";
      case 1:
         return "playing";
      case 2:
         return "paused";
      case 3:
         return "buffering";
      case 4:
         return "finished";
      case 5:
         return "canceled";
      case 6:
         return "invalidated";
      case 7:
         return "error";
      default:
         return Integer.toString(var0);
      }
   }

   public Bundle asBundle() {
      return this.mBundle;
   }

   public long getContentDuration() {
      return this.mBundle.getLong("contentDuration", -1L);
   }

   public long getContentPosition() {
      return this.mBundle.getLong("contentPosition", -1L);
   }

   public Bundle getExtras() {
      return this.mBundle.getBundle("extras");
   }

   public int getPlaybackState() {
      return this.mBundle.getInt("playbackState", 7);
   }

   public long getTimestamp() {
      return this.mBundle.getLong("timestamp");
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediaItemStatus{ ");
      var1.append("timestamp=");
      TimeUtils.formatDuration(SystemClock.elapsedRealtime() - this.getTimestamp(), var1);
      var1.append(" ms ago");
      var1.append(", playbackState=").append(playbackStateToString(this.getPlaybackState()));
      var1.append(", contentPosition=").append(this.getContentPosition());
      var1.append(", contentDuration=").append(this.getContentDuration());
      var1.append(", extras=").append(this.getExtras());
      var1.append(" }");
      return var1.toString();
   }

   public static final class Builder {
      private final Bundle mBundle;

      public Builder(int var1) {
         this.mBundle = new Bundle();
         this.setTimestamp(SystemClock.elapsedRealtime());
         this.setPlaybackState(var1);
      }

      public Builder(MediaItemStatus var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("status must not be null");
         } else {
            this.mBundle = new Bundle(var1.mBundle);
         }
      }

      public MediaItemStatus build() {
         return new MediaItemStatus(this.mBundle);
      }

      public MediaItemStatus.Builder setContentDuration(long var1) {
         this.mBundle.putLong("contentDuration", var1);
         return this;
      }

      public MediaItemStatus.Builder setContentPosition(long var1) {
         this.mBundle.putLong("contentPosition", var1);
         return this;
      }

      public MediaItemStatus.Builder setExtras(Bundle var1) {
         this.mBundle.putBundle("extras", var1);
         return this;
      }

      public MediaItemStatus.Builder setPlaybackState(int var1) {
         this.mBundle.putInt("playbackState", var1);
         return this;
      }

      public MediaItemStatus.Builder setTimestamp(long var1) {
         this.mBundle.putLong("timestamp", var1);
         return this;
      }
   }
}
