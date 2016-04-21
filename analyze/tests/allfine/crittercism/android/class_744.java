package crittercism.android;

import crittercism.android.class_743;
import crittercism.android.class_745;

// $FF: renamed from: crittercism.android.cn
public final class class_744 {
    // $FF: renamed from: a int
    public int field_3520;
    // $FF: renamed from: b int
    public int field_3521;

    public class_744(Throwable var1) {
        this.field_3520 = class_743.field_3517.ordinal();
        this.field_3521 = class_745.field_3526.ordinal();
        if(var1 != null) {
            this.field_3520 = class_743.method_3990(var1);
            if(this.field_3520 != class_743.field_3517.ordinal()) {
                this.field_3521 = Integer.parseInt(var1.getMessage());
                return;
            }

            this.field_3521 = class_745.method_3991(var1).method_3993();
        }

    }
}
