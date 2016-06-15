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
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_298;
import com.google.android.gms.internal.class_321;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
   public static final int RESUME_STATE_PAUSE = 2;
   public static final int RESUME_STATE_PLAY = 1;
   public static final int RESUME_STATE_UNCHANGED = 0;
   public static final int STATUS_CANCELED = 2101;
   public static final int STATUS_FAILED = 2100;
   public static final int STATUS_REPLACED = 2103;
   public static final int STATUS_SUCCEEDED = 0;
   public static final int STATUS_TIMED_OUT = 2102;
   // $FF: renamed from: Gw com.google.android.gms.internal.it
   private final class_321 field_3680 = new class_321() {
      protected void onMetadataUpdated() {
         RemoteMediaPlayer.this.onMetadataUpdated();
      }

      protected void onStatusUpdated() {
         RemoteMediaPlayer.this.onStatusUpdated();
      }
   };
   // $FF: renamed from: Gx com.google.android.gms.cast.RemoteMediaPlayer$a
   private final RemoteMediaPlayer.class_1285 field_3681 = new RemoteMediaPlayer.class_1285();
   // $FF: renamed from: Gy com.google.android.gms.cast.RemoteMediaPlayer$OnMetadataUpdatedListener
   private RemoteMediaPlayer.OnMetadataUpdatedListener field_3682;
   // $FF: renamed from: Gz com.google.android.gms.cast.RemoteMediaPlayer$OnStatusUpdatedListener
   private RemoteMediaPlayer.OnStatusUpdatedListener field_3683;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_3684 = new Object();

   public RemoteMediaPlayer() {
      this.field_3680.a(this.field_3681);
   }

   // $FF: renamed from: c (com.google.android.gms.cast.RemoteMediaPlayer) java.lang.Object
   // $FF: synthetic method
   static Object method_4833(RemoteMediaPlayer var0) {
      return var0.field_3684;
   }

   // $FF: renamed from: d (com.google.android.gms.cast.RemoteMediaPlayer) com.google.android.gms.cast.RemoteMediaPlayer$a
   // $FF: synthetic method
   static RemoteMediaPlayer.class_1285 method_4834(RemoteMediaPlayer var0) {
      return var0.field_3681;
   }

   private void onMetadataUpdated() {
      if(this.field_3682 != null) {
         this.field_3682.onMetadataUpdated();
      }

   }

   private void onStatusUpdated() {
      if(this.field_3683 != null) {
         this.field_3683.onStatusUpdated();
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
      return this.field_3680.getNamespace();
   }

   public long getStreamDuration() {
      // $FF: Couldn't be decompiled
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2) {
      return this.load(var1, var2, true, 0L, (long[])null, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2, boolean var3) {
      return this.load(var1, var2, var3, 0L, (long[])null, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2, boolean var3, long var4) {
      return this.load(var1, var2, var3, var4, (long[])null, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient var1, MediaInfo var2, boolean var3, long var4, JSONObject var6) {
      return this.load(var1, var2, var3, var4, (long[])null, var6);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(final GoogleApiClient var1, final MediaInfo var2, final boolean var3, final long var4, final long[] var6, final JSONObject var7) {
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1254(class_298 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public void onMessageReceived(CastDevice var1, String var2, String var3) {
      this.field_3680.method_2241(var3);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(GoogleApiClient var1) {
      return this.pause(var1, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(final GoogleApiClient var1, final JSONObject var2) {
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1251(class_298 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(GoogleApiClient var1) {
      return this.play(var1, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(final GoogleApiClient var1, final JSONObject var2) {
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1256(class_298 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> requestStatus(final GoogleApiClient var1) {
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1249(class_298 param1) {
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
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1257(class_298 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setActiveMediaTracks(final GoogleApiClient var1, final long[] var2) {
      if(var2 != null && var2.length != 0) {
         return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1250(class_298 param1) {
               // $FF: Couldn't be decompiled
            }
         });
      } else {
         throw new IllegalArgumentException("trackIds cannot be null or empty");
      }
   }

   public void setOnMetadataUpdatedListener(RemoteMediaPlayer.OnMetadataUpdatedListener var1) {
      this.field_3682 = var1;
   }

   public void setOnStatusUpdatedListener(RemoteMediaPlayer.OnStatusUpdatedListener var1) {
      this.field_3683 = var1;
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(GoogleApiClient var1, boolean var2) {
      return this.setStreamMute(var1, var2, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(final GoogleApiClient var1, final boolean var2, final JSONObject var3) {
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1248(class_298 param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(GoogleApiClient var1, double var2) throws IllegalArgumentException {
      return this.setStreamVolume(var1, var2, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(final GoogleApiClient var1, final double var2, final JSONObject var4) throws IllegalArgumentException {
      if(!Double.isInfinite(var2) && !Double.isNaN(var2)) {
         return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1255(class_298 param1) {
               // $FF: Couldn't be decompiled
            }
         });
      } else {
         throw new IllegalArgumentException("Volume cannot be " + var2);
      }
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> setTextTrackStyle(final GoogleApiClient var1, final TextTrackStyle var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("trackStyle cannot be null");
      } else {
         return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1253(class_298 param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(GoogleApiClient var1) {
      return this.stop(var1, (JSONObject)null);
   }

   public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(final GoogleApiClient var1, final JSONObject var2) {
      return var1.method_944(new RemoteMediaPlayer.class_1131(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.im) void
         protected void method_1252(class_298 param1) {
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

   private class class_1285 implements class_12 {
      // $FF: renamed from: GN com.google.android.gms.common.api.GoogleApiClient
      private GoogleApiClient field_2491;
      // $FF: renamed from: GO long
      private long field_2492 = 0L;

      // $FF: renamed from: a (java.lang.String, java.lang.String, long, java.lang.String) void
      public void method_82(String var1, String var2, long var3, String var5) throws IOException {
         if(this.field_2491 == null) {
            throw new IOException("No GoogleApiClient available");
         } else {
            Cast.CastApi.sendMessage(this.field_2491, var1, var2).setResultCallback(new RemoteMediaPlayer.class_1286(var3));
         }
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient) void
      public void method_3257(GoogleApiClient var1) {
         this.field_2491 = var1;
      }

      // $FF: renamed from: fS () long
      public long method_83() {
         long var1 = 1L + this.field_2492;
         this.field_2492 = var1;
         return var1;
      }
   }

   private final class class_1286 implements ResultCallback<Status> {
      // $FF: renamed from: GP long
      private final long field_2588;

      class_1286(long var2) {
         this.field_2588 = var2;
      }

      // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
      public void method_3403(Status var1) {
         if(!var1.isSuccess()) {
            RemoteMediaPlayer.super.field_2490.field_3680.method_2242(this.field_2588, var1.getStatusCode());
         }

      }

      // $FF: synthetic method
      public void onResult(Result var1) {
         this.method_3403((Status)var1);
      }
   }

   private abstract static class class_1131 extends Cast.class_1579<RemoteMediaPlayer.MediaChannelResult> {
      // $FF: renamed from: GR com.google.android.gms.internal.iv
      class_13 field_123 = new class_13() {
         // $FF: renamed from: a (long, int, org.json.JSONObject) void
         public void method_84(long var1, int var3, JSONObject var4) {
            class_1131.this.b(new RemoteMediaPlayer.class_1284(new Status(var3), var4));
         }

         // $FF: renamed from: n (long) void
         public void method_85(long var1) {
            class_1131.this.b(class_1131.this.method_1247(new Status(2103)));
         }
      };

      class_1131(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1247(var1);
      }

      // $FF: renamed from: k (com.google.android.gms.common.api.Status) com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult
      public RemoteMediaPlayer.MediaChannelResult method_1247(final Status var1) {
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

   private static final class class_1284 implements RemoteMediaPlayer.MediaChannelResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_2488;
      // $FF: renamed from: Ga org.json.JSONObject
      private final JSONObject field_2489;

      class_1284(Status var1, JSONObject var2) {
         this.field_2488 = var1;
         this.field_2489 = var2;
      }

      public JSONObject getCustomData() {
         return this.field_2489;
      }

      public Status getStatus() {
         return this.field_2488;
      }
   }
}
