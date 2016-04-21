package crittercism.android;

import com.crittercism.error.CRXMLHttpRequestException;

// $FF: renamed from: crittercism.android.co
public enum class_743 {
    // $FF: renamed from: a crittercism.android.co
    field_3514,
    // $FF: renamed from: b crittercism.android.co
    field_3515,
    // $FF: renamed from: c crittercism.android.co
    field_3516,
    // $FF: renamed from: d crittercism.android.co
    field_3517,
    // $FF: renamed from: e crittercism.android.co
    field_3518;

    static {
        class_743[] var0 = new class_743[]{field_3514, field_3515, field_3516, field_3517, field_3518};
    }

    // $FF: renamed from: a (java.lang.Throwable) int
    public static int method_3990(Throwable var0) {
        int var1 = field_3517.ordinal();
        if(var0 instanceof CRXMLHttpRequestException) {
            var1 = field_3518.ordinal();
        }

        return var1;
    }
}
