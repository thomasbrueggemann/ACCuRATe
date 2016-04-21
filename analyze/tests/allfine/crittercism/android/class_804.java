package crittercism.android;

import crittercism.android.class_725;
import crittercism.android.class_726;
import crittercism.android.class_731;
import crittercism.android.class_803;

// $FF: renamed from: crittercism.android.br
public enum class_804 {
    // $FF: renamed from: a crittercism.android.br
    field_3807("app_loads_2", 10, Integer.MAX_VALUE, new class_803.class_1425(0), new class_726.class_1240(), (String)null),
    // $FF: renamed from: b crittercism.android.br
    field_3808("exceptions", 5, 50, new class_803.class_1425(0), new class_726.class_1240(), "exceptions"),
    // $FF: renamed from: c crittercism.android.br
    field_3809("internal_excs", 3, 3, new class_803.class_1425(0), new class_726.class_1240(), "exceptions"),
    // $FF: renamed from: d crittercism.android.br
    field_3810("ndk_crashes", 5, Integer.MAX_VALUE, new class_803.class_1425(0), new class_726.class_1240(), "crashes"),
    // $FF: renamed from: e crittercism.android.br
    field_3811("sdk_crashes", 5, Integer.MAX_VALUE, new class_803.class_1425(0), new class_726.class_1240(), "crashes"),
    // $FF: renamed from: f crittercism.android.br
    field_3812("current_bcs", 50, Integer.MAX_VALUE, new class_803.class_1425(1), new class_725.class_1239(), (String)null),
    // $FF: renamed from: g crittercism.android.br
    field_3813("network_bcs", 10, Integer.MAX_VALUE, new class_803.class_1425(0), new class_725.class_1239(), (String)null),
    // $FF: renamed from: h crittercism.android.br
    field_3814("previous_bcs", 50, Integer.MAX_VALUE, new class_803.class_1425(0), new class_725.class_1239(), (String)null),
    // $FF: renamed from: i crittercism.android.br
    field_3815("started_txns", 50, Integer.MAX_VALUE, new class_803.class_1425(0), new class_725.class_1239(), (String)null),
    // $FF: renamed from: j crittercism.android.br
    field_3816("finished_txns", Integer.MAX_VALUE, Integer.MAX_VALUE, new class_803.class_1425(0), new class_725.class_1239(), (String)null),
    // $FF: renamed from: k crittercism.android.br
    field_3817("system_bcs", 100, Integer.MAX_VALUE, new class_803.class_1425(0), new class_725.class_1239(), (String)null);

    // $FF: renamed from: l java.lang.String
    private String field_3819;
    // $FF: renamed from: m int
    private int field_3820;
    // $FF: renamed from: n int
    private int field_3821;
    // $FF: renamed from: o crittercism.android.bs$a
    private class_803.class_1425 field_3822;
    // $FF: renamed from: p crittercism.android.cj
    private class_731 field_3823;
    // $FF: renamed from: q java.lang.String
    private String field_3824;

    static {
        class_804[] var0 = new class_804[]{field_3807, field_3808, field_3809, field_3810, field_3811, field_3812, field_3813, field_3814, field_3815, field_3816, field_3817};
    }

    private class_804(String var3, int var4, int var5, class_803.class_1425 var6, class_731 var7, String var8) {
        this.field_3819 = var3;
        this.field_3820 = var4;
        this.field_3821 = var5;
        this.field_3822 = var6;
        this.field_3823 = var7;
        this.field_3824 = var8;
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_4172() {
        return this.field_3819;
    }

    // $FF: renamed from: b () int
    public final int method_4173() {
        return this.field_3820;
    }

    // $FF: renamed from: c () crittercism.android.bs$a
    public final class_803.class_1425 method_4174() {
        return this.field_3822;
    }

    // $FF: renamed from: d () crittercism.android.cj
    public final class_731 method_4175() {
        return this.field_3823;
    }

    // $FF: renamed from: e () int
    public final int method_4176() {
        return this.field_3821;
    }

    // $FF: renamed from: f () java.lang.String
    public final String method_4177() {
        return this.field_3824;
    }
}
