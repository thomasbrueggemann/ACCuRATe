package crittercism.android;

import android.util.SparseArray;

// $FF: renamed from: crittercism.android.b
public enum class_676 {
    // $FF: renamed from: a crittercism.android.b
    field_3279(0),
    // $FF: renamed from: b crittercism.android.b
    field_3280(1),
    // $FF: renamed from: c crittercism.android.b
    field_3281(2),
    // $FF: renamed from: d crittercism.android.b
    field_3282(3);

    // $FF: renamed from: e android.util.SparseArray
    private static SparseArray field_3283;
    // $FF: renamed from: f int
    private int field_3285;

    static {
        class_676[] var0 = new class_676[]{field_3279, field_3280, field_3281, field_3282};
        SparseArray var1 = new SparseArray();
        field_3283 = var1;
        var1.put(0, field_3279);
        field_3283.put(1, field_3280);
    }

    private class_676(int var3) {
        this.field_3285 = var3;
    }

    // $FF: renamed from: a (int) crittercism.android.b
    public static class_676 method_3750(int var0) {
        class_676 var1 = (class_676)field_3283.get(var0);
        if(var1 == null) {
            var1 = field_3281;
        }

        return var1;
    }

    // $FF: renamed from: a () int
    public final int method_3751() {
        return this.field_3285;
    }
}
