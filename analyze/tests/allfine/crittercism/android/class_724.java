package crittercism.android;

import crittercism.android.class_809;
import java.io.File;
import java.io.IOException;

// $FF: renamed from: crittercism.android.bq
public class class_724 {
    // $FF: renamed from: a java.io.File
    protected File field_3483;

    public class_724(File var1) {
        this.field_3483 = var1;
    }

    // $FF: renamed from: a () java.lang.Object
    public Object method_3953() {
        try {
            String var2 = class_809.method_4198(this.field_3483);
            return var2;
        } catch (IOException var3) {
            return "";
        }
    }
}
