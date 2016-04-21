package com.google.android.gms.internal;

import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.df
@ez
public class class_482 {
    // $FF: renamed from: rb boolean
    private final boolean field_1918;
    // $FF: renamed from: rc boolean
    private final boolean field_1919;
    // $FF: renamed from: rd boolean
    private final boolean field_1920;
    // $FF: renamed from: re boolean
    private final boolean field_1921;
    // $FF: renamed from: rf boolean
    private final boolean field_1922;

    private class_482(class_482.class_1661 var1) {
        this.field_1918 = var1.field_5269;
        this.field_1919 = var1.field_5270;
        this.field_1920 = var1.field_5271;
        this.field_1921 = var1.field_5272;
        this.field_1922 = var1.field_5273;
    }

    // $FF: synthetic method
    class_482(class_482.class_1661 var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: bK () org.json.JSONObject
    public JSONObject method_2955() {
        try {
            JSONObject var2 = (new JSONObject()).put("sms", this.field_1918).put("tel", this.field_1919).put("calendar", this.field_1920).put("storePicture", this.field_1921).put("inlineVideo", this.field_1922);
            return var2;
        } catch (JSONException var3) {
            class_378.method_2463("Error occured while obtaining the MRAID capabilities.", var3);
            return null;
        }
    }

    public static final class class_1661 {
        // $FF: renamed from: rb boolean
        private boolean field_5269;
        // $FF: renamed from: rc boolean
        private boolean field_5270;
        // $FF: renamed from: rd boolean
        private boolean field_5271;
        // $FF: renamed from: re boolean
        private boolean field_5272;
        // $FF: renamed from: rf boolean
        private boolean field_5273;

        // $FF: renamed from: bL () com.google.android.gms.internal.df
        public class_482 method_5926() {
            return new class_482(this);
        }

        // $FF: renamed from: i (boolean) com.google.android.gms.internal.df$a
        public class_482.class_1661 method_5927(boolean var1) {
            this.field_5269 = var1;
            return this;
        }

        // $FF: renamed from: j (boolean) com.google.android.gms.internal.df$a
        public class_482.class_1661 method_5928(boolean var1) {
            this.field_5270 = var1;
            return this;
        }

        // $FF: renamed from: k (boolean) com.google.android.gms.internal.df$a
        public class_482.class_1661 method_5929(boolean var1) {
            this.field_5271 = var1;
            return this;
        }

        // $FF: renamed from: l (boolean) com.google.android.gms.internal.df$a
        public class_482.class_1661 method_5930(boolean var1) {
            this.field_5272 = var1;
            return this;
        }

        // $FF: renamed from: m (boolean) com.google.android.gms.internal.df$a
        public class_482.class_1661 method_5931(boolean var1) {
            this.field_5273 = var1;
            return this;
        }
    }
}
