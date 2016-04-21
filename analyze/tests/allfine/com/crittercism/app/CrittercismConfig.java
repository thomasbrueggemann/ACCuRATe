package com.crittercism.app;

import android.os.Build.VERSION;
import crittercism.android.class_764;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class CrittercismConfig {
    public static final String API_VERSION = "5.1.4";
    // $FF: renamed from: a java.lang.String
    protected String field_3725 = "com.crittercism/dumps";
    // $FF: renamed from: b java.lang.String
    private String field_3726 = null;
    // $FF: renamed from: c boolean
    private boolean field_3727 = false;
    // $FF: renamed from: d boolean
    private boolean field_3728 = false;
    // $FF: renamed from: e boolean
    private boolean field_3729 = true;
    // $FF: renamed from: f boolean
    private boolean field_3730 = false;
    // $FF: renamed from: g boolean
    private boolean field_3731 = method_4100();
    // $FF: renamed from: h java.lang.String
    private String field_3732 = "Developer Reply";
    // $FF: renamed from: i java.lang.String
    private String field_3733 = null;
    // $FF: renamed from: j java.util.List
    private List field_3734 = new LinkedList();
    // $FF: renamed from: k java.util.List
    private List field_3735 = new LinkedList();

    public CrittercismConfig() {
    }

    public CrittercismConfig(CrittercismConfig var1) {
        this.field_3726 = var1.field_3726;
        this.field_3727 = var1.field_3727;
        this.field_3728 = var1.field_3728;
        this.field_3729 = var1.field_3729;
        this.field_3730 = var1.field_3730;
        this.field_3731 = var1.field_3731;
        this.field_3725 = var1.field_3725;
        this.field_3732 = var1.field_3732;
        this.setURLBlacklistPatterns(var1.field_3734);
        this.setPreserveQueryStringPatterns(var1.field_3735);
        this.field_3733 = var1.field_3733;
    }

    @Deprecated
    public CrittercismConfig(JSONObject var1) {
        this.field_3726 = method_4097(var1, "customVersionName", this.field_3726);
        this.field_3728 = method_4099(var1, "includeVersionCode", this.field_3728);
        this.field_3729 = method_4099(var1, "installNdk", this.field_3729);
        this.field_3727 = method_4099(var1, "delaySendingAppLoad", this.field_3727);
        this.field_3730 = method_4099(var1, "shouldCollectLogcat", this.field_3730);
        this.field_3725 = method_4097(var1, "nativeDumpPath", this.field_3725);
        this.field_3732 = method_4097(var1, "notificationTitle", this.field_3732);
        this.field_3731 = method_4099(var1, "installApm", this.field_3731);
    }

    // $FF: renamed from: a (java.lang.String) int
    private static int method_4096(String var0) {
        int var1 = 0;
        if(var0 != null) {
            var1 = var0.hashCode();
        }

        return var1;
    }

    // $FF: renamed from: a (org.json.JSONObject, java.lang.String, java.lang.String) java.lang.String
    private static String method_4097(JSONObject var0, String var1, String var2) {
        if(var0.has(var1)) {
            String var4;
            try {
                var4 = var0.getString(var1);
            } catch (Exception var5) {
                return var2;
            }

            var2 = var4;
        }

        return var2;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) boolean
    protected static boolean method_4098(String var0, String var1) {
        return var0 == null?var1 == null:var0.equals(var1);
    }

    // $FF: renamed from: a (org.json.JSONObject, java.lang.String, boolean) boolean
    private static boolean method_4099(JSONObject var0, String var1, boolean var2) {
        if(var0.has(var1)) {
            boolean var4;
            try {
                var4 = var0.getBoolean(var1);
            } catch (Exception var5) {
                return var2;
            }

            var2 = var4;
        }

        return var2;
    }

    // $FF: renamed from: b () boolean
    private static final boolean method_4100() {
        return VERSION.SDK_INT >= 10 && VERSION.SDK_INT <= 19;
    }

    // $FF: renamed from: a () java.util.List
    public List method_4101() {
        return this.getURLBlacklistPatterns();
    }

    public final boolean delaySendingAppLoad() {
        return this.field_3727;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof CrittercismConfig) {
            CrittercismConfig var2 = (CrittercismConfig)var1;
            if(this.field_3727 == var2.field_3727 && this.field_3730 == var2.field_3730 && this.isNdkCrashReportingEnabled() == var2.isNdkCrashReportingEnabled() && this.isOptmzEnabled() == var2.isOptmzEnabled() && this.isVersionCodeToBeIncludedInVersionString() == var2.isVersionCodeToBeIncludedInVersionString() && method_4098(this.field_3726, var2.field_3726) && method_4098(this.field_3732, var2.field_3732) && method_4098(this.field_3725, var2.field_3725) && this.field_3734.equals(var2.field_3734) && this.field_3735.equals(var2.field_3735) && method_4098(this.field_3733, var2.field_3733)) {
                return true;
            }
        }

        return false;
    }

    public final String getCustomVersionName() {
        return this.field_3726;
    }

    public List getPreserveQueryStringPatterns() {
        return new LinkedList(this.field_3735);
    }

    public final String getRateMyAppTestTarget() {
        return this.field_3733;
    }

    public List getURLBlacklistPatterns() {
        return new LinkedList(this.field_3734);
    }

    public int hashCode() {
        byte var1 = 1;
        int var2 = 31 * (31 * (31 * (31 * (31 * (0 + method_4096(this.field_3726)) + method_4096(this.field_3732)) + method_4096(this.field_3725)) + method_4096(this.field_3733)) + this.field_3734.hashCode()) + this.field_3735.hashCode();
        byte var3;
        if(this.field_3727) {
            var3 = var1;
        } else {
            var3 = 0;
        }

        int var4 = var3 + 0 << 1;
        byte var5;
        if(this.field_3730) {
            var5 = var1;
        } else {
            var5 = 0;
        }

        int var6 = var5 + var4 << 1;
        byte var7;
        if(this.isNdkCrashReportingEnabled()) {
            var7 = var1;
        } else {
            var7 = 0;
        }

        int var8 = var7 + var6 << 1;
        byte var9;
        if(this.isOptmzEnabled()) {
            var9 = var1;
        } else {
            var9 = 0;
        }

        int var10 = var9 + var8 << 1;
        if(!this.isVersionCodeToBeIncludedInVersionString()) {
            var1 = 0;
        }

        int var11 = var10 + var1;
        return var2 * 31 + Integer.valueOf(var11).hashCode();
    }

    public final boolean isLogcatReportingEnabled() {
        return this.field_3730;
    }

    public final boolean isNdkCrashReportingEnabled() {
        return this.field_3729;
    }

    @Deprecated
    public final boolean isOptmzEnabled() {
        return this.field_3731;
    }

    public final boolean isServiceMonitoringEnabled() {
        return this.isOptmzEnabled();
    }

    public final boolean isVersionCodeToBeIncludedInVersionString() {
        return this.field_3728;
    }

    public final void setCustomVersionName(String var1) {
        this.field_3726 = var1;
    }

    public final void setDelaySendingAppLoad(boolean var1) {
        this.field_3727 = var1;
    }

    public final void setLogcatReportingEnabled(boolean var1) {
        this.field_3730 = var1;
    }

    public final void setNdkCrashReportingEnabled(boolean var1) {
        this.field_3729 = var1;
    }

    @Deprecated
    public final void setOptmzEnabled(boolean var1) {
        if(!method_4100() && var1) {
            class_764.method_4017("OPTMZ is currently only allowed for api levels 10 to 19.  APM will not be installed");
        } else {
            this.field_3731 = var1;
        }
    }

    public void setPreserveQueryStringPatterns(List var1) {
        this.field_3735.clear();
        if(var1 != null) {
            this.field_3735.addAll(var1);
        }

    }

    public final void setRateMyAppTestTarget(String var1) {
        this.field_3733 = var1;
    }

    public final void setServiceMonitoringEnabled(boolean var1) {
        this.setOptmzEnabled(var1);
    }

    public void setURLBlacklistPatterns(List var1) {
        this.field_3734.clear();
        if(var1 != null) {
            this.field_3734.addAll(var1);
        }

    }

    public final void setVersionCodeToBeIncludedInVersionString(boolean var1) {
        this.field_3728 = var1;
    }
}
