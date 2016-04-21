package crittercism.android;

// $FF: renamed from: crittercism.android.cq
public enum class_741 {
    // $FF: renamed from: a crittercism.android.cq
    field_3499("com.crittercism.apploads", "appLoadFiles"),
    // $FF: renamed from: b crittercism.android.cq
    field_3500("com.crittercism.exceptions", "handledExceptionFiles"),
    // $FF: renamed from: c crittercism.android.cq
    field_3501("com.crittercism.sdkcrashes", "sdkCrashFiles"),
    // $FF: renamed from: d crittercism.android.cq
    field_3502("com.crittercism.ndkcrashes", "ndkCrashFiles"),
    // $FF: renamed from: e crittercism.android.cq
    field_3503("com.crittercism.breadcrumbs", "currentBreadcrumbFiles"),
    // $FF: renamed from: f crittercism.android.cq
    field_3504("com.crittercism.breadcrumbs", "previousBreadcrumbFiles"),
    // $FF: renamed from: g crittercism.android.cq
    field_3505("com.crittercism.breadcrumbs", "networkBreadcrumbFiles"),
    // $FF: renamed from: h crittercism.android.cq
    field_3506("com.crittercism.usersettings", "crashedOnLastLoad"),
    // $FF: renamed from: i crittercism.android.cq
    field_3507("com.crittercism.usersettings", "optOutStatusSettings"),
    // $FF: renamed from: j crittercism.android.cq
    field_3508("com.crittercism.usersettings", "sessionIDSetting"),
    // $FF: renamed from: k crittercism.android.cq
    field_3509("com.crittercism.prefs", "com.crittercism.prefs.sessid"),
    // $FF: renamed from: l crittercism.android.cq
    field_3510("com.crittercism.prefs", "optOutStatus");

    // $FF: renamed from: m java.lang.String
    private String field_3512;
    // $FF: renamed from: n java.lang.String
    private String field_3513;

    static {
        class_741[] var0 = new class_741[]{field_3499, field_3500, field_3501, field_3502, field_3503, field_3504, field_3505, field_3506, field_3507, field_3508, field_3509, field_3510};
    }

    private class_741(String var3, String var4) {
        this.field_3512 = var3;
        this.field_3513 = var4;
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_3988() {
        return this.field_3512;
    }

    // $FF: renamed from: b () java.lang.String
    public final String method_3989() {
        return this.field_3513;
    }
}
