package com.google.android.gms.cast;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.internal.class_334;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1L;
    public static final long COMMAND_SEEK = 2L;
    public static final long COMMAND_SET_VOLUME = 4L;
    public static final long COMMAND_SKIP_BACKWARD = 32L;
    public static final long COMMAND_SKIP_FORWARD = 16L;
    public static final long COMMAND_TOGGLE_MUTE = 8L;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN;
    // $FF: renamed from: FA double
    private double field_3994;
    // $FF: renamed from: FB boolean
    private boolean field_3995;
    // $FF: renamed from: FC long[]
    private long[] field_3996;
    // $FF: renamed from: Fl org.json.JSONObject
    private JSONObject field_3997;
    // $FF: renamed from: Fm com.google.android.gms.cast.MediaInfo
    private MediaInfo field_3998;
    // $FF: renamed from: Fu long
    private long field_3999;
    // $FF: renamed from: Fv double
    private double field_4000;
    // $FF: renamed from: Fw int
    private int field_4001;
    // $FF: renamed from: Fx int
    private int field_4002;
    // $FF: renamed from: Fy long
    private long field_4003;
    // $FF: renamed from: Fz long
    private long field_4004;

    public MediaStatus(JSONObject var1) throws JSONException {
        this.method_4389(var1, 0);
    }

    // $FF: renamed from: a (org.json.JSONObject, int) int
    public int method_4389(JSONObject var1, int var2) throws JSONException {
        byte var3 = 2;
        byte var4 = 1;
        long var5 = var1.getLong("mediaSessionId");
        int var7;
        if(var5 != this.field_3999) {
            this.field_3999 = var5;
            var7 = var4;
        } else {
            var7 = 0;
        }

        if(var1.has("playerState")) {
            String var26 = var1.getString("playerState");
            byte var27;
            if(var26.equals("IDLE")) {
                var27 = var4;
            } else if(var26.equals("PLAYING")) {
                var27 = var3;
            } else if(var26.equals("PAUSED")) {
                var27 = 3;
            } else if(var26.equals("BUFFERING")) {
                var27 = 4;
            } else {
                var27 = 0;
            }

            if(var27 != this.field_4001) {
                this.field_4001 = var27;
                var7 |= 2;
            }

            if(var27 == var4 && var1.has("idleReason")) {
                String var28 = var1.getString("idleReason");
                if(!var28.equals("CANCELLED")) {
                    if(var28.equals("INTERRUPTED")) {
                        var3 = 3;
                    } else if(var28.equals("FINISHED")) {
                        var3 = var4;
                    } else if(var28.equals("ERROR")) {
                        var3 = 4;
                    } else {
                        var3 = 0;
                    }
                }

                if(var3 != this.field_4002) {
                    this.field_4002 = var3;
                    var7 |= 2;
                }
            }
        }

        if(var1.has("playbackRate")) {
            double var24 = var1.getDouble("playbackRate");
            if(this.field_4000 != var24) {
                this.field_4000 = var24;
                var7 |= 2;
            }
        }

        if(var1.has("currentTime") && (var2 & 2) == 0) {
            long var22 = class_334.method_2303(var1.getDouble("currentTime"));
            if(var22 != this.field_4003) {
                this.field_4003 = var22;
                var7 |= 2;
            }
        }

        if(var1.has("supportedMediaCommands")) {
            long var20 = var1.getLong("supportedMediaCommands");
            if(var20 != this.field_4004) {
                this.field_4004 = var20;
                var7 |= 2;
            }
        }

        if(var1.has("volume") && (var2 & 1) == 0) {
            JSONObject var16 = var1.getJSONObject("volume");
            double var17 = var16.getDouble("level");
            if(var17 != this.field_3994) {
                this.field_3994 = var17;
                var7 |= 2;
            }

            boolean var19 = var16.getBoolean("muted");
            if(var19 != this.field_3995) {
                this.field_3995 = var19;
                var7 |= 2;
            }
        }

        long[] var8;
        byte var9;
        if(var1.has("activeTrackIds")) {
            JSONArray var11 = var1.getJSONArray("activeTrackIds");
            int var12 = var11.length();
            long[] var13 = new long[var12];

            for(int var14 = 0; var14 < var12; ++var14) {
                var13[var14] = var11.getLong(var14);
            }

            if(this.field_3996 != null && this.field_3996.length == var12) {
                int var15 = 0;

                while(true) {
                    if(var15 >= var12) {
                        var4 = 0;
                        break;
                    }

                    if(this.field_3996[var15] != var13[var15]) {
                        break;
                    }

                    ++var15;
                }
            }

            if(var4 != 0) {
                this.field_3996 = var13;
            }

            var9 = var4;
            var8 = var13;
        } else if(this.field_3996 != null) {
            var9 = var4;
            var8 = null;
        } else {
            var8 = null;
            var9 = 0;
        }

        if(var9 != 0) {
            this.field_3996 = var8;
            var7 |= 2;
        }

        if(var1.has("customData")) {
            this.field_3997 = var1.getJSONObject("customData");
            var7 |= 2;
        }

        if(var1.has("media")) {
            JSONObject var10 = var1.getJSONObject("media");
            this.field_3998 = new MediaInfo(var10);
            var7 |= 2;
            if(var10.has("metadata")) {
                var7 |= 4;
            }
        }

        return var7;
    }

    // $FF: renamed from: fw () long
    public long method_4390() {
        return this.field_3999;
    }

    public long[] getActiveTrackIds() {
        return this.field_3996;
    }

    public JSONObject getCustomData() {
        return this.field_3997;
    }

    public int getIdleReason() {
        return this.field_4002;
    }

    public MediaInfo getMediaInfo() {
        return this.field_3998;
    }

    public double getPlaybackRate() {
        return this.field_4000;
    }

    public int getPlayerState() {
        return this.field_4001;
    }

    public long getStreamPosition() {
        return this.field_4003;
    }

    public double getStreamVolume() {
        return this.field_3994;
    }

    public boolean isMediaCommandSupported(long var1) {
        return (var1 & this.field_4004) != 0L;
    }

    public boolean isMute() {
        return this.field_3995;
    }
}
