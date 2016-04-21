package crittercism.android;

import crittercism.android.class_106;
import crittercism.android.class_552;
import crittercism.android.class_558;
import crittercism.android.class_754;
import crittercism.android.class_803;
import crittercism.android.class_98;
import crittercism.android.class_99;
import java.net.URL;

// $FF: renamed from: crittercism.android.dh
final class class_559 extends class_552 {
    // $FF: renamed from: a crittercism.android.bs
    private class_803 field_3026;
    // $FF: renamed from: b crittercism.android.bs
    private class_803 field_3027;
    // $FF: renamed from: c crittercism.android.au
    private class_106 field_3028;
    // $FF: renamed from: d java.net.URL
    private URL field_3029;
    // $FF: renamed from: e crittercism.android.cy
    private class_98 field_3030;
    // $FF: renamed from: f crittercism.android.cx
    private class_99 field_3031;

    class_559(class_803 var1, class_803 var2, class_106 var3, URL var4, class_98 var5, class_99 var6) {
        this.field_3027 = var1;
        this.field_3026 = var2;
        this.field_3028 = var3;
        this.field_3029 = var4;
        this.field_3030 = var5;
        this.field_3031 = var6;
    }

    // $FF: renamed from: a () void
    public final void method_3390() {
        this.field_3026.method_4166(this.field_3027);
        (new class_558(this.field_3031.method_395(this.field_3028).method_396(this.field_3027), new class_754(this.field_3029), true, this.field_3030)).run();
    }
}
