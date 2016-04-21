package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.ez;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.bg
@ez
public final class class_236 {
    public static final String DEVICE_ID_EMULATOR = class_377.method_2448("emulator");
    // $FF: renamed from: d java.util.Date
    private final Date field_598;
    // $FF: renamed from: f java.util.Set
    private final Set<String> field_599;
    // $FF: renamed from: h android.location.Location
    private final Location field_600;
    // $FF: renamed from: ol java.lang.String
    private final String field_601;
    // $FF: renamed from: om int
    private final int field_602;
    // $FF: renamed from: on boolean
    private final boolean field_603;
    // $FF: renamed from: oo android.os.Bundle
    private final Bundle field_604;
    // $FF: renamed from: op java.util.Map
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> field_605;
    // $FF: renamed from: oq java.lang.String
    private final String field_606;
    // $FF: renamed from: or com.google.android.gms.ads.search.SearchAdRequest
    private final SearchAdRequest field_607;
    // $FF: renamed from: os int
    private final int field_608;
    // $FF: renamed from: ot java.util.Set
    private final Set<String> field_609;

    public class_236(class_236.class_1167 var1) {
        this(var1, (SearchAdRequest)null);
    }

    public class_236(class_236.class_1167 var1, SearchAdRequest var2) {
        this.field_598 = var1.field_845;
        this.field_601 = var1.field_847;
        this.field_602 = var1.field_848;
        this.field_599 = Collections.unmodifiableSet(var1.field_853);
        this.field_600 = var1.field_846;
        this.field_603 = var1.field_849;
        this.field_604 = var1.field_850;
        this.field_605 = Collections.unmodifiableMap(var1.field_854);
        this.field_606 = var1.field_851;
        this.field_607 = var2;
        this.field_608 = var1.field_852;
        this.field_609 = Collections.unmodifiableSet(var1.field_855);
    }

    // $FF: renamed from: bd () com.google.android.gms.ads.search.SearchAdRequest
    public SearchAdRequest method_1575() {
        return this.field_607;
    }

    // $FF: renamed from: be () java.util.Map
    public Map<Class<? extends NetworkExtras>, NetworkExtras> method_1576() {
        return this.field_605;
    }

    // $FF: renamed from: bf () android.os.Bundle
    public Bundle method_1577() {
        return this.field_604;
    }

    // $FF: renamed from: bg () int
    public int method_1578() {
        return this.field_608;
    }

    public Date getBirthday() {
        return this.field_598;
    }

    public String getContentUrl() {
        return this.field_601;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> var1) {
        Bundle var2 = this.field_604.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return var2 != null?var2.getBundle(var1.getClass().getName()):null;
    }

    public int getGender() {
        return this.field_602;
    }

    public Set<String> getKeywords() {
        return this.field_599;
    }

    public Location getLocation() {
        return this.field_600;
    }

    public boolean getManualImpressionsEnabled() {
        return this.field_603;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
        return (NetworkExtras)this.field_605.get(var1);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> var1) {
        return this.field_604.getBundle(var1.getName());
    }

    public String getPublisherProvidedId() {
        return this.field_606;
    }

    public boolean isTestDevice(Context var1) {
        return this.field_609.contains(class_377.method_2456(var1));
    }

    public static final class class_1167 {
        // $FF: renamed from: d java.util.Date
        private Date field_845;
        // $FF: renamed from: h android.location.Location
        private Location field_846;
        // $FF: renamed from: ol java.lang.String
        private String field_847;
        // $FF: renamed from: om int
        private int field_848 = -1;
        // $FF: renamed from: on boolean
        private boolean field_849 = false;
        // $FF: renamed from: oo android.os.Bundle
        private final Bundle field_850 = new Bundle();
        // $FF: renamed from: oq java.lang.String
        private String field_851;
        // $FF: renamed from: os int
        private int field_852 = -1;
        // $FF: renamed from: ou java.util.HashSet
        private final HashSet<String> field_853 = new HashSet();
        // $FF: renamed from: ov java.util.HashMap
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> field_854 = new HashMap();
        // $FF: renamed from: ow java.util.HashSet
        private final HashSet<String> field_855 = new HashSet();

        // $FF: renamed from: a (android.location.Location) void
        public void method_1749(Location var1) {
            this.field_846 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.ads.mediation.NetworkExtras) void
        @Deprecated
        public void method_1750(NetworkExtras var1) {
            if(var1 instanceof AdMobExtras) {
                this.method_1751(AdMobAdapter.class, ((AdMobExtras)var1).getExtras());
            } else {
                this.field_854.put(var1.getClass(), var1);
            }
        }

        // $FF: renamed from: a (java.lang.Class, android.os.Bundle) void
        public void method_1751(Class<? extends MediationAdapter> var1, Bundle var2) {
            this.field_850.putBundle(var1.getName(), var2);
        }

        // $FF: renamed from: a (java.util.Date) void
        public void method_1752(Date var1) {
            this.field_845 = var1;
        }

        // $FF: renamed from: b (java.lang.Class, android.os.Bundle) void
        public void method_1753(Class<? extends CustomEvent> var1, Bundle var2) {
            if(this.field_850.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.field_850.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }

            this.field_850.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(var1.getName(), var2);
        }

        // $FF: renamed from: g (int) void
        public void method_1754(int var1) {
            this.field_848 = var1;
        }

        // $FF: renamed from: g (boolean) void
        public void method_1755(boolean var1) {
            this.field_849 = var1;
        }

        // $FF: renamed from: h (boolean) void
        public void method_1756(boolean var1) {
            byte var2;
            if(var1) {
                var2 = 1;
            } else {
                var2 = 0;
            }

            this.field_852 = var2;
        }

        // $FF: renamed from: r (java.lang.String) void
        public void method_1757(String var1) {
            this.field_853.add(var1);
        }

        // $FF: renamed from: s (java.lang.String) void
        public void method_1758(String var1) {
            this.field_855.add(var1);
        }

        // $FF: renamed from: t (java.lang.String) void
        public void method_1759(String var1) {
            this.field_847 = var1;
        }

        // $FF: renamed from: u (java.lang.String) void
        public void method_1760(String var1) {
            this.field_851 = var1;
        }
    }
}
