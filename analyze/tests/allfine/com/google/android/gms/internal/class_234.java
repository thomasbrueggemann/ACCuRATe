package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_235;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gt;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.ai
@ez
public class class_234 {
    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gt, com.google.android.gms.internal.gk) com.google.android.gms.internal.ah
    protected ah method_1572(Context var1, gt var2, final gk<ah> var3) {
        final class_235 var4 = new class_235(var1, var2);
        var4.method_0(new class_0.class_1657() {
            // $FF: renamed from: aM () void
            public void method_719() {
                var3.method_2538(var4);
            }
        });
        return var4;
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gt, java.lang.String) java.util.concurrent.Future
    public Future<ah> method_1573(final Context var1, final gt var2, final String var3) {
        final class_386 var4 = new class_386();
        class_377.field_1386.post(new Runnable() {
            public void run() {
                class_234.this.method_1572(var1, var2, var4).method_4(var3);
            }
        });
        return var4;
    }
}
