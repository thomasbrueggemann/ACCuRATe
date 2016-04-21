package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.class_324;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    // $FF: renamed from: Fn java.lang.String[]
    private static final String[] field_5308 = new String[] {null, "String", "int", "double", "ISO-8601 date String"};
    // $FF: renamed from: Fo com.google.android.gms.cast.MediaMetadata$a
    private static final MediaMetadata.class_1782 field_5309 = (new MediaMetadata.class_1782()).method_5254("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).method_5254("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).method_5254("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).method_5254("com.google.android.gms.cast.metadata.TITLE", "title", 1).method_5254("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).method_5254("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).method_5254("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).method_5254("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).method_5254("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).method_5254("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).method_5254("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).method_5254("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).method_5254("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).method_5254("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).method_5254("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).method_5254("com.google.android.gms.cast.metadata.WIDTH", "width", 2).method_5254("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).method_5254("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).method_5254("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).method_5254("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    // $FF: renamed from: EA java.util.List
    private final List<WebImage> field_5310;
    // $FF: renamed from: Fp android.os.Bundle
    private final Bundle field_5311;
    // $FF: renamed from: Fq int
    private int field_5312;

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int var1) {
        this.field_5310 = new ArrayList();
        this.field_5311 = new Bundle();
        this.field_5312 = var1;
    }

    // $FF: renamed from: a (org.json.JSONObject, java.lang.String[]) void
    private void method_5949(JSONObject param1, String... param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.os.Bundle, android.os.Bundle) boolean
    private boolean method_5950(Bundle var1, Bundle var2) {
        if(var1.size() != var2.size()) {
            return false;
        } else {
            Iterator var3 = var1.keySet().iterator();

            String var4;
            Object var6;
            label37:
            do {
                Object var5;
                do {
                    if(!var3.hasNext()) {
                        return true;
                    }

                    var4 = (String)var3.next();
                    var5 = var1.get(var4);
                    var6 = var2.get(var4);
                    if(var5 instanceof Bundle && var6 instanceof Bundle && !this.method_5950((Bundle)var5, (Bundle)var6)) {
                        return false;
                    }

                    if(var5 == null) {
                        continue label37;
                    }
                } while(var5.equals(var6));

                return false;
            } while(var6 == null && var2.containsKey(var4));

            return false;
        }
    }

    // $FF: renamed from: b (org.json.JSONObject, java.lang.String[]) void
    private void method_5951(JSONObject param1, String... param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (java.lang.String, int) void
    private void method_5952(String var1, int var2) throws IllegalArgumentException {
        if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        } else {
            int var3 = field_5309.method_5256(var1);
            if(var3 != var2 && var3 != 0) {
                throw new IllegalArgumentException("Value for " + var1 + " must be a " + field_5308[var2]);
            }
        }
    }

    public void addImage(WebImage var1) {
        this.field_5310.add(var1);
    }

    // $FF: renamed from: bK () org.json.JSONObject
    public JSONObject method_5953() {
        JSONObject var1 = new JSONObject();

        try {
            var1.put("metadataType", this.field_5312);
        } catch (JSONException var3) {
            ;
        }

        class_324.method_2233(var1, this.field_5310);
        switch(this.field_5312) {
            case 0:
                this.method_5949(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                return var1;
            case 1:
                this.method_5949(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                return var1;
            case 2:
                this.method_5949(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
                return var1;
            case 3:
                this.method_5949(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                return var1;
            case 4:
                this.method_5949(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
                return var1;
            default:
                this.method_5949(var1, new String[0]);
                return var1;
        }
    }

    // $FF: renamed from: c (org.json.JSONObject) void
    public void method_5954(JSONObject var1) {
        this.clear();
        this.field_5312 = 0;

        try {
            this.field_5312 = var1.getInt("metadataType");
        } catch (JSONException var3) {
            ;
        }

        class_324.method_2232(this.field_5310, var1);
        switch(this.field_5312) {
            case 0:
                this.method_5951(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                return;
            case 1:
                this.method_5951(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                return;
            case 2:
                this.method_5951(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
                return;
            case 3:
                this.method_5951(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                return;
            case 4:
                this.method_5951(var1, new String[] {"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
                return;
            default:
                this.method_5951(var1, new String[0]);
        }
    }

    public void clear() {
        this.field_5311.clear();
        this.field_5310.clear();
    }

    public void clearImages() {
        this.field_5310.clear();
    }

    public boolean containsKey(String var1) {
        return this.field_5311.containsKey(var1);
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof MediaMetadata)) {
                return false;
            }

            MediaMetadata var2 = (MediaMetadata)var1;
            if(!this.method_5950(this.field_5311, var2.field_5311) || !this.field_5310.equals(var2.field_5310)) {
                return false;
            }
        }

        return true;
    }

    public Calendar getDate(String var1) {
        this.method_5952(var1, 4);
        String var2 = this.field_5311.getString(var1);
        return var2 != null?class_324.method_2234(var2):null;
    }

    public String getDateAsString(String var1) {
        this.method_5952(var1, 4);
        return this.field_5311.getString(var1);
    }

    public double getDouble(String var1) {
        this.method_5952(var1, 3);
        return this.field_5311.getDouble(var1);
    }

    public List<WebImage> getImages() {
        return this.field_5310;
    }

    public int getInt(String var1) {
        this.method_5952(var1, 2);
        return this.field_5311.getInt(var1);
    }

    public int getMediaType() {
        return this.field_5312;
    }

    public String getString(String var1) {
        this.method_5952(var1, 1);
        return this.field_5311.getString(var1);
    }

    public boolean hasImages() {
        return this.field_5310 != null && !this.field_5310.isEmpty();
    }

    public int hashCode() {
        Iterator var1 = this.field_5311.keySet().iterator();

        int var2;
        String var3;
        for(var2 = 17; var1.hasNext(); var2 = var2 * 31 + this.field_5311.get(var3).hashCode()) {
            var3 = (String)var1.next();
        }

        return var2 * 31 + this.field_5310.hashCode();
    }

    public Set<String> keySet() {
        return this.field_5311.keySet();
    }

    public void putDate(String var1, Calendar var2) {
        this.method_5952(var1, 4);
        this.field_5311.putString(var1, class_324.method_2231(var2));
    }

    public void putDouble(String var1, double var2) {
        this.method_5952(var1, 3);
        this.field_5311.putDouble(var1, var2);
    }

    public void putInt(String var1, int var2) {
        this.method_5952(var1, 2);
        this.field_5311.putInt(var1, var2);
    }

    public void putString(String var1, String var2) {
        this.method_5952(var1, 1);
        this.field_5311.putString(var1, var2);
    }

    private static class class_1782 {
        // $FF: renamed from: Fr java.util.Map
        private final Map<String, String> field_4622 = new HashMap();
        // $FF: renamed from: Fs java.util.Map
        private final Map<String, String> field_4623 = new HashMap();
        // $FF: renamed from: Ft java.util.Map
        private final Map<String, Integer> field_4624 = new HashMap();

        // $FF: renamed from: a (java.lang.String, java.lang.String, int) com.google.android.gms.cast.MediaMetadata$a
        public MediaMetadata.class_1782 method_5254(String var1, String var2, int var3) {
            this.field_4622.put(var1, var2);
            this.field_4623.put(var2, var1);
            this.field_4624.put(var1, Integer.valueOf(var3));
            return this;
        }

        // $FF: renamed from: aA (java.lang.String) java.lang.String
        public String method_5255(String var1) {
            return (String)this.field_4623.get(var1);
        }

        // $FF: renamed from: aB (java.lang.String) int
        public int method_5256(String var1) {
            Integer var2 = (Integer)this.field_4624.get(var1);
            return var2 != null?var2.intValue():0;
        }

        // $FF: renamed from: az (java.lang.String) java.lang.String
        public String method_5257(String var1) {
            return (String)this.field_4622.get(var1);
        }
    }
}
