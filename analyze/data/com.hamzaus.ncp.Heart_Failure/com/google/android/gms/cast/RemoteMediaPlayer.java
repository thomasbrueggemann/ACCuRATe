package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_24;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_25;
import com.google.android.gms.internal.class_326;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
   public static final int RESUME_STATE_PAUSE = 2;
   public static final int RESUME_STATE_PLAY = 1;
   public static final int RESUME_STATE_UNCHANGED = 0;
   public static final int STATUS_CANCELED = 2;
   public static final int STATUS_FAILED = 1;
   public static final int STATUS_REPLACED = 4;
   public static final int STATUS_SUCCEEDED = 0;
   public static final int STATUS_TIMED_OUT = 3;
   // $FF: renamed from: AT com.google.android.gms.internal.gp
   private final class_326 field_3529 = new class_326() {
      protected void onMetadataUpdated() {
         RemoteMediaPlayer.this.onMetadataUpdated();
      }

      protected void onStatusUpdated() {
         RemoteMediaPlayer.this.onStatusUpdated();
      }
   };
   // $FF: renamed from: AU com.google.android.gms.cast.RemoteMediaPlayer$a
   private final RemoteMediaPlayer.class_979 field_3530 = new RemoteMediaPlayer.class_979();
   // $FF: renamed from: AV com.google.android.gms.cast.RemoteMediaPlayer$OnMetadataUpdatedListener
   private RemoteMediaPlayer.OnMetadataUpdatedListener field_3531;
   // $FF: renamed from: AW com.google.android.gms.cast.RemoteMediaPlayer$OnStatusUpdatedListener
   private RemoteMediaPlayer.OnStatusUpdatedListener field_3532;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_3533 = new Object();

   public RemoteMediaPlayer() {
      this.field_3529.a(this.field_3530);
   }

   // $FF: renamed from: c (com.google.android.gms.cast.RemoteMediaPlayer) java.lang.Object
   // $FF: synthetic method
   static Object method_3859(RemoteMediaPlayer var0) {
      return var0.field_3533;
   }

   // $FF: renamed from: d (com.google.android.gms.cast.RemoteMediaPlayer) com.google.android.gms.cast.RemoteMediaPlayer$a
   // $FF: synthetic method
   static RemoteMediaPlayer.class_979 method_3860(RemoteMediaPlayer var0) {
      return var0.field_3530;
   }

   private void onMetadataUpdated() {
      if(this.field_3531 != null) {
         this.field_3531.onMetadataUpdated();
      }

   }

   private void onStatusUpdated() {
      if(this.field_3532 != null) {
         this.field_3532.onStatusUpdated();
      }

   }

   public long getApproximateStreamPosition() {
      // $FF: Couldn't be decompiled
   }

   public MediaInfo getMediaInfo() {
      // $FF: Couldn't be decompiled
   }

   public MediaStatus getMediaStatus() {
      // $FF: Couldn't be decompiled
   }

   public String getNamespace() {
      return this.field_3529.getNamespace();
   }

   public long getStreamDuration() {
      // $FF: Couldn't be decompiled
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2) {
      return this.load(var1, var2, true, 0L, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2, boolean var3) {
      return this.load(var1, var2, var3, 0L, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2, boolean var3, long var4) {
      return this.load(var1, var2, var3, var4, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(final GoogleApiClient var1, final MediaInfo var2, final boolean var3, final long var4, final JSONObject var6) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1027(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public void onMessageReceived(CastDevice var1, String var2, String var3) {
      this.field_3529.method_2074(var3);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(GoogleApiClient var1) {
      return this.pause(var1, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(final GoogleApiClient var1, final JSONObject var2) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1024(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(GoogleApiClient var1) {
      return this.play(var1, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(final GoogleApiClient var1, final JSONObject var2) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1029(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> requestStatus(final GoogleApiClient var1) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1022(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(GoogleApiClient var1, long var2) {
      return this.seek(var1, var2, 0, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(GoogleApiClient var1, long var2, int var4) {
      return this.seek(var1, var2, var4, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(final GoogleApiClient var1, final long var2, final int var4, final JSONObject var5) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1030(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setActiveMediaTracks(final GoogleApiClient var1, final long[] var2) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1023(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public void setOnMetadataUpdatedListener(RemoteMediaPlayer.OnMetadataUpdatedListener var1) {
      this.field_3531 = var1;
   }

   public void setOnStatusUpdatedListener(RemoteMediaPlayer.OnStatusUpdatedListener var1) {
      this.field_3532 = var1;
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(GoogleApiClient var1, boolean var2) {
      return this.setStreamMute(var1, var2, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(final GoogleApiClient var1, final boolean var2, final JSONObject var3) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1021(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(GoogleApiClient var1, double var2) throws IllegalArgumentException {
      return this.setStreamVolume(var1, var2, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(final GoogleApiClient var1, final double var2, final JSONObject var4) throws IllegalArgumentException {
      if(!Double.isInfinite(var2) && !Double.isNaN(var2)) {
         return var1.method_773(new RemoteMediaPlayer.class_839() {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1028(class_242 param1) {
               // $FF: Couldn't be decompiled
            }
         });
      } else {
         throw new IllegalArgumentException("Volume cannot be " + var2);
      }
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setTextTrackStyle(final GoogleApiClient var1, final TextTrackStyle var2) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1026(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(GoogleApiClient var1) {
      return this.stop(var1, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(final GoogleApiClient var1, final JSONObject var2) {
      return var1.method_773(new RemoteMediaPlayer.class_839() {
         // $FF: renamed from: a (com.google.android.gms.internal.gi) void
         protected void method_1025(class_242 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public interface MediaChannelResult extends Result {
      JSONObject getCustomData();
   }

   public interface OnMetadataUpdatedListener {
      void onMetadataUpdated();
   }

   public interface OnStatusUpdatedListener {
      void onStatusUpdated();
   }

   private class class_979 implements class_24 {
      // $FF: renamed from: Bj com.google.android.gms.common.api.GoogleApiClient
      private GoogleApiClient field_2689;
      // $FF: renamed from: Bk long
      private long field_2690 = 0L;

      // $FF: renamed from: a (java.lang.String, java.lang.String, long, java.lang.String) void
      public void method_106(String var1, String var2, long var3, String var5) throws IOException {
         if(this.field_2689 == null) {
            throw new IOException("No GoogleApiClient available");
         } else {
            Cast.CastApi.sendMessage(this.field_2689, var1, var2).setResultCallback(new RemoteMediaPlayer.class_980(var3));
         }
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient) void
      public void method_2756(GoogleApiClient var1) {
         this.field_2689 = var1;
      }

      // $FF: renamed from: dW () long
      public long method_107() {
         long var1 = 1L + this.field_2690;
         this.field_2690 = var1;
         return var1;
      }
   }

   private final class class_980 implements ResultCallback<Status> {
      // $FF: renamed from: Bl long
      private final long field_2769;

      class_980(long var2) {
         this.field_2769 = var2;
      }

      // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
      public void method_2855(Status var1) {
         if(!var1.isSuccess()) {
            RemoteMediaPlayer.super.field_2688.field_3529.method_2071(this.field_2769, var1.getStatusCode());
         }

      }

      // $FF: synthetic method
      public void onResult(Result var1) {
         this.method_2855((Status)var1);
      }
   }

   private abstract static class class_839 extends Cast.class_1214<RemoteMediaPlayer.MediaChannelResult> {
      // $FF: renamed from: Bn com.google.android.gms.internal.gr
      class_25 field_122 = new class_25() {
         // $FF: renamed from: a (long, int, org.json.JSONObject) void
         public void method_108(long var1, int var3, JSONObject var4) {
            class_839.this.b(new RemoteMediaPlayer.class_978(new Status(var3), var4));
         }

         // $FF: renamed from: n (long) void
         public void method_109(long var1) {
            class_839.this.b(class_839.this.method_1020(new Status(4)));
         }
      };

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1020(var1);
      }

      // $FF: renamed from: l (com.google.android.gms.common.api.Status) com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult
      public RemoteMediaPlayer.MediaChannelResult method_1020(final Status var1) {
         return new RemoteMediaPlayer.MediaChannelResult() {
            public JSONObject getCustomData() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }
   }

   private static final class class_978 implements RemoteMediaPlayer.MediaChannelResult {
      // $FF: renamed from: Ax org.json.JSONObject
      private final JSONObject field_2685;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_2686;

      class_978(Status var1, JSONObject var2) {
         this.field_2686 = var1;
         this.field_2685 = var2;
      }

      public JSONObject getCustomData() {
         return this.field_2685;
      }

      public Status getStatus() {
         return this.field_2686;
      }
   }
}
