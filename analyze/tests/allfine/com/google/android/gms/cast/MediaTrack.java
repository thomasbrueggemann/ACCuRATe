package com.google.android.gms.cast;

import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.class_342;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    // $FF: renamed from: Dj long
    private long field_3141;
    // $FF: renamed from: FD int
    private int field_3142;
    // $FF: renamed from: FE int
    private int field_3143;
    // $FF: renamed from: Fc java.lang.String
    private String field_3144;
    // $FF: renamed from: Fe java.lang.String
    private String field_3145;
    // $FF: renamed from: Fg java.lang.String
    private String field_3146;
    // $FF: renamed from: Fl org.json.JSONObject
    private JSONObject field_3147;
    private String mName;

    MediaTrack(long var1, int var3) throws IllegalArgumentException {
        this.clear();
        this.field_3141 = var1;
        if(var3 > 0 && var3 <= 3) {
            this.field_3142 = var3;
        } else {
            throw new IllegalArgumentException("invalid type " + var3);
        }
    }

    MediaTrack(JSONObject var1) throws JSONException {
        this.method_3517(var1);
    }

    // $FF: renamed from: c (org.json.JSONObject) void
    private void method_3517(JSONObject var1) throws JSONException {
        this.clear();
        this.field_3141 = var1.getLong("trackId");
        String var2 = var1.getString("type");
        if("TEXT".equals(var2)) {
            this.field_3142 = 1;
        } else if("AUDIO".equals(var2)) {
            this.field_3142 = 2;
        } else {
            if(!"VIDEO".equals(var2)) {
                throw new JSONException("invalid type: " + var2);
            }

            this.field_3142 = 3;
        }

        this.field_3145 = var1.optString("trackContentId", (String)null);
        this.field_3146 = var1.optString("trackContentType", (String)null);
        this.mName = var1.optString("name", (String)null);
        this.field_3144 = var1.optString("language", (String)null);
        if(var1.has("subtype")) {
            String var3 = var1.getString("subtype");
            if("SUBTITLES".equals(var3)) {
                this.field_3143 = 1;
            } else if("CAPTIONS".equals(var3)) {
                this.field_3143 = 2;
            } else if("DESCRIPTIONS".equals(var3)) {
                this.field_3143 = 3;
            } else if("CHAPTERS".equals(var3)) {
                this.field_3143 = 4;
            } else {
                if(!"METADATA".equals(var3)) {
                    throw new JSONException("invalid subtype: " + var3);
                }

                this.field_3143 = 5;
            }
        } else {
            this.field_3143 = 0;
        }

        this.field_3147 = var1.optJSONObject("customData");
    }

    private void clear() {
        this.field_3141 = 0L;
        this.field_3142 = 0;
        this.field_3145 = null;
        this.mName = null;
        this.field_3144 = null;
        this.field_3143 = -1;
        this.field_3147 = null;
    }

    // $FF: renamed from: aa (int) void
    void method_3518(int var1) throws IllegalArgumentException {
        if(var1 > -1 && var1 <= 5) {
            if(var1 != 0 && this.field_3142 != 1) {
                throw new IllegalArgumentException("subtypes are only valid for text tracks");
            } else {
                this.field_3143 = var1;
            }
        } else {
            throw new IllegalArgumentException("invalid subtype " + var1);
        }
    }

    // $FF: renamed from: bK () org.json.JSONObject
    public JSONObject method_3519() {
        // $FF: Couldn't be decompiled
    }

    public boolean equals(Object var1) {
        boolean var2 = true;
        boolean var4;
        if(this == var1) {
            var4 = var2;
        } else {
            boolean var3 = var1 instanceof MediaTrack;
            var4 = false;
            if(var3) {
                MediaTrack var5 = (MediaTrack)var1;
                boolean var6;
                if(this.field_3147 == null) {
                    var6 = var2;
                } else {
                    var6 = false;
                }

                boolean var7;
                if(var5.field_3147 == null) {
                    var7 = var2;
                } else {
                    var7 = false;
                }

                var4 = false;
                if(var6 == var7) {
                    if(this.field_3147 != null && var5.field_3147 != null) {
                        boolean var8 = class_342.method_2317(this.field_3147, var5.field_3147);
                        var4 = false;
                        if(!var8) {
                            return var4;
                        }
                    }

                    if(this.field_3141 != var5.field_3141 || this.field_3142 != var5.field_3142 || !class_334.method_2300(this.field_3145, var5.field_3145) || !class_334.method_2300(this.field_3146, var5.field_3146) || !class_334.method_2300(this.mName, var5.mName) || !class_334.method_2300(this.field_3144, var5.field_3144) || this.field_3143 != var5.field_3143) {
                        var2 = false;
                    }

                    return var2;
                }
            }
        }

        return var4;
    }

    public String getContentId() {
        return this.field_3145;
    }

    public String getContentType() {
        return this.field_3146;
    }

    public JSONObject getCustomData() {
        return this.field_3147;
    }

    public long getId() {
        return this.field_3141;
    }

    public String getLanguage() {
        return this.field_3144;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.field_3143;
    }

    public int getType() {
        return this.field_3142;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_3141), Integer.valueOf(this.field_3142), this.field_3145, this.field_3146, this.mName, this.field_3144, Integer.valueOf(this.field_3143), this.field_3147};
        return class_1089.hashCode(var1);
    }

    public void setContentId(String var1) {
        this.field_3145 = var1;
    }

    public void setContentType(String var1) {
        this.field_3146 = var1;
    }

    void setCustomData(JSONObject var1) {
        this.field_3147 = var1;
    }

    void setLanguage(String var1) {
        this.field_3144 = var1;
    }

    void setName(String var1) {
        this.mName = var1;
    }

    public static class Builder {
        // $FF: renamed from: FF com.google.android.gms.cast.MediaTrack
        private final MediaTrack field_4592;

        public Builder(long var1, int var3) throws IllegalArgumentException {
            this.field_4592 = new MediaTrack(var1, var3);
        }

        public MediaTrack build() {
            return this.field_4592;
        }

        public MediaTrack.Builder setContentId(String var1) {
            this.field_4592.setContentId(var1);
            return this;
        }

        public MediaTrack.Builder setContentType(String var1) {
            this.field_4592.setContentType(var1);
            return this;
        }

        public MediaTrack.Builder setCustomData(JSONObject var1) {
            this.field_4592.setCustomData(var1);
            return this;
        }

        public MediaTrack.Builder setLanguage(String var1) {
            this.field_4592.setLanguage(var1);
            return this;
        }

        public MediaTrack.Builder setLanguage(Locale var1) {
            this.field_4592.setLanguage(class_334.method_2304(var1));
            return this;
        }

        public MediaTrack.Builder setName(String var1) {
            this.field_4592.setName(var1);
            return this;
        }

        public MediaTrack.Builder setSubtype(int var1) throws IllegalArgumentException {
            this.field_4592.method_3518(var1);
            return this;
        }
    }
}
