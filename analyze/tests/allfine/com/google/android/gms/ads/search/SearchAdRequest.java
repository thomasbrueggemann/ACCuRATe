package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_236;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    // $FF: renamed from: ld com.google.android.gms.internal.bg
    private final class_236 field_2055;
    // $FF: renamed from: xl int
    private final int field_2056;
    // $FF: renamed from: xm int
    private final int field_2057;
    // $FF: renamed from: xn int
    private final int field_2058;
    // $FF: renamed from: xo int
    private final int field_2059;
    // $FF: renamed from: xp int
    private final int field_2060;
    // $FF: renamed from: xq int
    private final int field_2061;
    // $FF: renamed from: xr int
    private final int field_2062;
    // $FF: renamed from: xs int
    private final int field_2063;
    // $FF: renamed from: xt java.lang.String
    private final String field_2064;
    // $FF: renamed from: xu int
    private final int field_2065;
    // $FF: renamed from: xv java.lang.String
    private final String field_2066;
    // $FF: renamed from: xw int
    private final int field_2067;
    // $FF: renamed from: xx int
    private final int field_2068;
    // $FF: renamed from: xy java.lang.String
    private final String field_2069;

    static {
        DEVICE_ID_EMULATOR = class_236.DEVICE_ID_EMULATOR;
    }

    private SearchAdRequest(SearchAdRequest.Builder var1) {
        this.field_2056 = var1.field_4830;
        this.field_2057 = var1.field_4831;
        this.field_2058 = var1.field_4832;
        this.field_2059 = var1.field_4833;
        this.field_2060 = var1.field_4834;
        this.field_2061 = var1.field_4835;
        this.field_2062 = var1.field_4836;
        this.field_2063 = var1.field_4837;
        this.field_2064 = var1.field_4838;
        this.field_2065 = var1.field_4839;
        this.field_2066 = var1.field_4840;
        this.field_2067 = var1.field_4841;
        this.field_2068 = var1.field_4842;
        this.field_2069 = var1.field_4843;
        this.field_2055 = new class_236(var1.field_4829, this);
    }

    // $FF: synthetic method
    SearchAdRequest(SearchAdRequest.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: V () com.google.android.gms.internal.bg
    class_236 method_3008() {
        return this.field_2055;
    }

    public int getAnchorTextColor() {
        return this.field_2056;
    }

    public int getBackgroundColor() {
        return this.field_2057;
    }

    public int getBackgroundGradientBottom() {
        return this.field_2058;
    }

    public int getBackgroundGradientTop() {
        return this.field_2059;
    }

    public int getBorderColor() {
        return this.field_2060;
    }

    public int getBorderThickness() {
        return this.field_2061;
    }

    public int getBorderType() {
        return this.field_2062;
    }

    public int getCallButtonColor() {
        return this.field_2063;
    }

    public String getCustomChannels() {
        return this.field_2064;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> var1) {
        return this.field_2055.getCustomEventExtrasBundle(var1);
    }

    public int getDescriptionTextColor() {
        return this.field_2065;
    }

    public String getFontFace() {
        return this.field_2066;
    }

    public int getHeaderTextColor() {
        return this.field_2067;
    }

    public int getHeaderTextSize() {
        return this.field_2068;
    }

    public Location getLocation() {
        return this.field_2055.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
        return this.field_2055.getNetworkExtras(var1);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> var1) {
        return this.field_2055.getNetworkExtrasBundle(var1);
    }

    public String getQuery() {
        return this.field_2069;
    }

    public boolean isTestDevice(Context var1) {
        return this.field_2055.isTestDevice(var1);
    }

    public static final class Builder {
        // $FF: renamed from: le com.google.android.gms.internal.bg$a
        private final class_236.class_1167 field_4829 = new class_236.class_1167();
        // $FF: renamed from: xl int
        private int field_4830;
        // $FF: renamed from: xm int
        private int field_4831;
        // $FF: renamed from: xn int
        private int field_4832;
        // $FF: renamed from: xo int
        private int field_4833;
        // $FF: renamed from: xp int
        private int field_4834;
        // $FF: renamed from: xq int
        private int field_4835;
        // $FF: renamed from: xr int
        private int field_4836 = 0;
        // $FF: renamed from: xs int
        private int field_4837;
        // $FF: renamed from: xt java.lang.String
        private String field_4838;
        // $FF: renamed from: xu int
        private int field_4839;
        // $FF: renamed from: xv java.lang.String
        private String field_4840;
        // $FF: renamed from: xw int
        private int field_4841;
        // $FF: renamed from: xx int
        private int field_4842;
        // $FF: renamed from: xy java.lang.String
        private String field_4843;

        public SearchAdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> var1, Bundle var2) {
            this.field_4829.method_1753(var1, var2);
            return this;
        }

        public SearchAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
            this.field_4829.method_1750(var1);
            return this;
        }

        public SearchAdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> var1, Bundle var2) {
            this.field_4829.method_1751(var1, var2);
            return this;
        }

        public SearchAdRequest.Builder addTestDevice(String var1) {
            this.field_4829.method_1758(var1);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public SearchAdRequest.Builder setAnchorTextColor(int var1) {
            this.field_4830 = var1;
            return this;
        }

        public SearchAdRequest.Builder setBackgroundColor(int var1) {
            this.field_4831 = var1;
            this.field_4832 = Color.argb(0, 0, 0, 0);
            this.field_4833 = Color.argb(0, 0, 0, 0);
            return this;
        }

        public SearchAdRequest.Builder setBackgroundGradient(int var1, int var2) {
            this.field_4831 = Color.argb(0, 0, 0, 0);
            this.field_4832 = var2;
            this.field_4833 = var1;
            return this;
        }

        public SearchAdRequest.Builder setBorderColor(int var1) {
            this.field_4834 = var1;
            return this;
        }

        public SearchAdRequest.Builder setBorderThickness(int var1) {
            this.field_4835 = var1;
            return this;
        }

        public SearchAdRequest.Builder setBorderType(int var1) {
            this.field_4836 = var1;
            return this;
        }

        public SearchAdRequest.Builder setCallButtonColor(int var1) {
            this.field_4837 = var1;
            return this;
        }

        public SearchAdRequest.Builder setCustomChannels(String var1) {
            this.field_4838 = var1;
            return this;
        }

        public SearchAdRequest.Builder setDescriptionTextColor(int var1) {
            this.field_4839 = var1;
            return this;
        }

        public SearchAdRequest.Builder setFontFace(String var1) {
            this.field_4840 = var1;
            return this;
        }

        public SearchAdRequest.Builder setHeaderTextColor(int var1) {
            this.field_4841 = var1;
            return this;
        }

        public SearchAdRequest.Builder setHeaderTextSize(int var1) {
            this.field_4842 = var1;
            return this;
        }

        public SearchAdRequest.Builder setLocation(Location var1) {
            this.field_4829.method_1749(var1);
            return this;
        }

        public SearchAdRequest.Builder setQuery(String var1) {
            this.field_4843 = var1;
            return this;
        }

        public SearchAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
            this.field_4829.method_1756(var1);
            return this;
        }
    }
}
