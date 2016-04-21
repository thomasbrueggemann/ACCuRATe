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
import com.google.android.gms.internal.class_14;
import com.google.android.gms.internal.class_15;
import com.google.android.gms.internal.class_304;
import com.google.android.gms.internal.class_329;
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
    // $FF: renamed from: FG com.google.android.gms.internal.iq
    private final class_329 field_4440 = new class_329() {
        protected void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };
    // $FF: renamed from: FH com.google.android.gms.cast.RemoteMediaPlayer$a
    private final RemoteMediaPlayer.class_1347 field_4441 = new RemoteMediaPlayer.class_1347();
    // $FF: renamed from: FI com.google.android.gms.cast.RemoteMediaPlayer$OnMetadataUpdatedListener
    private RemoteMediaPlayer.OnMetadataUpdatedListener field_4442;
    // $FF: renamed from: FJ com.google.android.gms.cast.RemoteMediaPlayer$OnStatusUpdatedListener
    private RemoteMediaPlayer.OnStatusUpdatedListener field_4443;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_4444 = new Object();

    public RemoteMediaPlayer() {
        this.field_4440.a(this.field_4441);
    }

    // $FF: renamed from: c (com.google.android.gms.cast.RemoteMediaPlayer) java.lang.Object
    // $FF: synthetic method
    static Object method_4991(RemoteMediaPlayer var0) {
        return var0.field_4444;
    }

    // $FF: renamed from: d (com.google.android.gms.cast.RemoteMediaPlayer) com.google.android.gms.cast.RemoteMediaPlayer$a
    // $FF: synthetic method
    static RemoteMediaPlayer.class_1347 method_4992(RemoteMediaPlayer var0) {
        return var0.field_4441;
    }

    private void onMetadataUpdated() {
        if(this.field_4442 != null) {
            this.field_4442.onMetadataUpdated();
        }

    }

    private void onStatusUpdated() {
        if(this.field_4443 != null) {
            this.field_4443.onStatusUpdated();
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
        return this.field_4440.getNamespace();
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
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1282(class_304 param1) {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public void onMessageReceived(CastDevice var1, String var2, String var3) {
        this.field_4440.method_2248(var3);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(GoogleApiClient var1) {
        return this.pause(var1, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(final GoogleApiClient var1, final JSONObject var2) {
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1279(class_304 param1) {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(GoogleApiClient var1) {
        return this.play(var1, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(final GoogleApiClient var1, final JSONObject var2) {
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1284(class_304 param1) {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> requestStatus(final GoogleApiClient var1) {
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1277(class_304 param1) {
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
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1285(class_304 param1) {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setActiveMediaTracks(final GoogleApiClient var1, final long[] var2) {
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1278(class_304 param1) {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public void setOnMetadataUpdatedListener(RemoteMediaPlayer.OnMetadataUpdatedListener var1) {
        this.field_4442 = var1;
    }

    public void setOnStatusUpdatedListener(RemoteMediaPlayer.OnStatusUpdatedListener var1) {
        this.field_4443 = var1;
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(GoogleApiClient var1, boolean var2) {
        return this.setStreamMute(var1, var2, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(final GoogleApiClient var1, final boolean var2, final JSONObject var3) {
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1276(class_304 param1) {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(GoogleApiClient var1, double var2) throws IllegalArgumentException {
        return this.setStreamVolume(var1, var2, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(final GoogleApiClient var1, final double var2, final JSONObject var4) throws IllegalArgumentException {
        if(!Double.isInfinite(var2) && !Double.isNaN(var2)) {
            return var1.method_899(new RemoteMediaPlayer.class_1210() {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1283(class_304 param1) {
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
            return var1.method_899(new RemoteMediaPlayer.class_1210() {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1281(class_304 param1) {
                    // $FF: Couldn't be decompiled
                }
            });
        }
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(GoogleApiClient var1) {
        return this.stop(var1, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(final GoogleApiClient var1, final JSONObject var2) {
        return var1.method_899(new RemoteMediaPlayer.class_1210() {
            // $FF: renamed from: a (com.google.android.gms.internal.ij) void
            protected void method_1280(class_304 param1) {
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

    private class class_1347 implements class_14 {
        // $FF: renamed from: FX com.google.android.gms.common.api.GoogleApiClient
        private GoogleApiClient field_2851;
        // $FF: renamed from: FY long
        private long field_2852 = 0L;

        // $FF: renamed from: a (java.lang.String, java.lang.String, long, java.lang.String) void
        public void method_92(String var1, String var2, long var3, String var5) throws IOException {
            if(this.field_2851 == null) {
                throw new IOException("No GoogleApiClient available");
            } else {
                Cast.CastApi.sendMessage(this.field_2851, var1, var2).setResultCallback(new RemoteMediaPlayer.class_1348(var3));
            }
        }

        // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient) void
        public void method_3256(GoogleApiClient var1) {
            this.field_2851 = var1;
        }

        // $FF: renamed from: fx () long
        public long method_93() {
            long var1 = 1L + this.field_2852;
            this.field_2852 = var1;
            return var1;
        }
    }

    private final class class_1348 implements ResultCallback<Status> {
        // $FF: renamed from: FZ long
        private final long field_2936;

        class_1348(long var2) {
            this.field_2936 = var2;
        }

        // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
        public void method_3360(Status var1) {
            if(!var1.isSuccess()) {
                RemoteMediaPlayer.super.field_2850.field_4440.method_2249(this.field_2936, var1.getStatusCode());
            }

        }

        // $FF: synthetic method
        public void onResult(Result var1) {
            this.method_3360((Status)var1);
        }
    }

    private abstract static class class_1210 extends Cast.class_1684<RemoteMediaPlayer.MediaChannelResult> {
        // $FF: renamed from: Gb com.google.android.gms.internal.is
        class_15 field_157 = new class_15() {
            // $FF: renamed from: a (long, int, org.json.JSONObject) void
            public void method_94(long var1, int var3, JSONObject var4) {
                class_1210.this.b(new RemoteMediaPlayer.class_1346(new Status(var3), var4));
            }

            // $FF: renamed from: n (long) void
            public void method_95(long var1) {
                class_1210.this.b(class_1210.this.method_1275(new Status(2103)));
            }
        };

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1275(var1);
        }

        // $FF: renamed from: l (com.google.android.gms.common.api.Status) com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult
        public RemoteMediaPlayer.MediaChannelResult method_1275(final Status var1) {
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

    private static final class class_1346 implements RemoteMediaPlayer.MediaChannelResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_2848;
        // $FF: renamed from: Fl org.json.JSONObject
        private final JSONObject field_2849;

        class_1346(Status var1, JSONObject var2) {
            this.field_2848 = var1;
            this.field_2849 = var2;
        }

        public JSONObject getCustomData() {
            return this.field_2849;
        }

        public Status getStatus() {
            return this.field_2848;
        }
    }
}
