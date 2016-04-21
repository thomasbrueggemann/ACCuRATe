package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.class_342;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE;
    // $FF: renamed from: Fe java.lang.String
    private final String field_5084;
    // $FF: renamed from: Ff int
    private int field_5085;
    // $FF: renamed from: Fg java.lang.String
    private String field_5086;
    // $FF: renamed from: Fh com.google.android.gms.cast.MediaMetadata
    private MediaMetadata field_5087;
    // $FF: renamed from: Fi long
    private long field_5088;
    // $FF: renamed from: Fj java.util.List
    private List<MediaTrack> field_5089;
    // $FF: renamed from: Fk com.google.android.gms.cast.TextTrackStyle
    private TextTrackStyle field_5090;
    // $FF: renamed from: Fl org.json.JSONObject
    private JSONObject field_5091;

    MediaInfo(String var1) throws IllegalArgumentException {
        if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else {
            this.field_5084 = var1;
            this.field_5085 = -1;
        }
    }

    MediaInfo(JSONObject var1) throws JSONException {
        int var2 = 0;
        super();
        this.field_5084 = var1.getString("contentId");
        String var3 = var1.getString("streamType");
        if("NONE".equals(var3)) {
            this.field_5085 = 0;
        } else if("BUFFERED".equals(var3)) {
            this.field_5085 = 1;
        } else if("LIVE".equals(var3)) {
            this.field_5085 = 2;
        } else {
            this.field_5085 = -1;
        }

        this.field_5086 = var1.getString("contentType");
        if(var1.has("metadata")) {
            JSONObject var9 = var1.getJSONObject("metadata");
            this.field_5087 = new MediaMetadata(var9.getInt("metadataType"));
            this.field_5087.method_5954(var9);
        }

        this.field_5088 = class_334.method_2303(var1.optDouble("duration", 0.0D));
        if(var1.has("tracks")) {
            this.field_5089 = new ArrayList();

            for(JSONArray var6 = var1.getJSONArray("tracks"); var2 < var6.length(); ++var2) {
                MediaTrack var7 = new MediaTrack(var6.getJSONObject(var2));
                this.field_5089.add(var7);
            }
        } else {
            this.field_5089 = null;
        }

        if(var1.has("textTrackStyle")) {
            JSONObject var4 = var1.getJSONObject("textTrackStyle");
            TextTrackStyle var5 = new TextTrackStyle();
            var5.method_4417(var4);
            this.field_5090 = var5;
        } else {
            this.field_5090 = null;
        }

        this.field_5091 = var1.optJSONObject("customData");
    }

    // $FF: renamed from: a (com.google.android.gms.cast.MediaMetadata) void
    void method_5577(MediaMetadata var1) {
        this.field_5087 = var1;
    }

    // $FF: renamed from: bK () org.json.JSONObject
    public JSONObject method_5578() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c (java.util.List) void
    void method_5579(List<MediaTrack> var1) {
        this.field_5089 = var1;
    }

    public boolean equals(Object var1) {
        boolean var2;
        MediaInfo var5;
        label46: {
            var2 = true;
            boolean var4;
            if(this == var1) {
                var4 = var2;
            } else {
                boolean var3 = var1 instanceof MediaInfo;
                var4 = false;
                if(var3) {
                    var5 = (MediaInfo)var1;
                    boolean var6;
                    if(this.field_5091 == null) {
                        var6 = var2;
                    } else {
                        var6 = false;
                    }

                    boolean var7;
                    if(var5.field_5091 == null) {
                        var7 = var2;
                    } else {
                        var7 = false;
                    }

                    var4 = false;
                    if(var6 == var7) {
                        if(this.field_5091 == null || var5.field_5091 == null) {
                            break label46;
                        }

                        boolean var8 = class_342.method_2317(this.field_5091, var5.field_5091);
                        var4 = false;
                        if(var8) {
                            break label46;
                        }
                    }
                }
            }

            return var4;
        }

        if(!class_334.method_2300(this.field_5084, var5.field_5084) || this.field_5085 != var5.field_5085 || !class_334.method_2300(this.field_5086, var5.field_5086) || !class_334.method_2300(this.field_5087, var5.field_5087) || this.field_5088 != var5.field_5088) {
            var2 = false;
        }

        return var2;
    }

    // $FF: renamed from: fv () void
    void method_5580() throws IllegalArgumentException {
        if(TextUtils.isEmpty(this.field_5084)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if(TextUtils.isEmpty(this.field_5086)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if(this.field_5085 == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public String getContentId() {
        return this.field_5084;
    }

    public String getContentType() {
        return this.field_5086;
    }

    public JSONObject getCustomData() {
        return this.field_5091;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.field_5089;
    }

    public MediaMetadata getMetadata() {
        return this.field_5087;
    }

    public long getStreamDuration() {
        return this.field_5088;
    }

    public int getStreamType() {
        return this.field_5085;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.field_5090;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_5084, Integer.valueOf(this.field_5085), this.field_5086, this.field_5087, Long.valueOf(this.field_5088), String.valueOf(this.field_5091)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: m (long) void
    void method_5581(long var1) throws IllegalArgumentException {
        if(var1 < 0L) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        } else {
            this.field_5088 = var1;
        }
    }

    void setContentType(String var1) throws IllegalArgumentException {
        if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else {
            this.field_5086 = var1;
        }
    }

    void setCustomData(JSONObject var1) {
        this.field_5091 = var1;
    }

    void setStreamType(int var1) throws IllegalArgumentException {
        if(var1 >= -1 && var1 <= 2) {
            this.field_5085 = var1;
        } else {
            throw new IllegalArgumentException("invalid stream type");
        }
    }

    public void setTextTrackStyle(TextTrackStyle var1) {
        this.field_5090 = var1;
    }

    public static class Builder {
        // $FF: renamed from: Fm com.google.android.gms.cast.MediaInfo
        private final MediaInfo field_1545;

        public Builder(String var1) throws IllegalArgumentException {
            if(TextUtils.isEmpty(var1)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            } else {
                this.field_1545 = new MediaInfo(var1);
            }
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.field_1545.method_5580();
            return this.field_1545;
        }

        public MediaInfo.Builder setContentType(String var1) throws IllegalArgumentException {
            this.field_1545.setContentType(var1);
            return this;
        }

        public MediaInfo.Builder setCustomData(JSONObject var1) {
            this.field_1545.setCustomData(var1);
            return this;
        }

        public MediaInfo.Builder setMediaTracks(List<MediaTrack> var1) {
            this.field_1545.method_5579(var1);
            return this;
        }

        public MediaInfo.Builder setMetadata(MediaMetadata var1) {
            this.field_1545.method_5577(var1);
            return this;
        }

        public MediaInfo.Builder setStreamDuration(long var1) throws IllegalArgumentException {
            this.field_1545.method_5581(var1);
            return this;
        }

        public MediaInfo.Builder setStreamType(int var1) throws IllegalArgumentException {
            this.field_1545.setStreamType(var1);
            return this;
        }

        public MediaInfo.Builder setTextTrackStyle(TextTrackStyle var1) {
            this.field_1545.setTextTrackStyle(var1);
            return this;
        }
    }
}
