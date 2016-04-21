package crittercism.android;

import android.content.Context;
import crittercism.android.class_106;
import crittercism.android.class_552;
import crittercism.android.class_555;
import crittercism.android.class_559;
import crittercism.android.class_753;
import crittercism.android.class_803;
import crittercism.android.class_97;
import crittercism.android.class_98;
import crittercism.android.class_99;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

// $FF: renamed from: crittercism.android.df
public final class class_756 {
    // $FF: renamed from: a android.content.Context
    private Context field_3587;
    // $FF: renamed from: b java.util.List
    private List field_3588;

    public class_756(Context var1) {
        this.field_3587 = var1;
        this.field_3588 = new ArrayList();
    }

    // $FF: renamed from: a () void
    public final void method_4003() {
        ArrayList var1 = new ArrayList();
        Iterator var2 = this.field_3588.iterator();

        while(var2.hasNext()) {
            var1.add(new Thread((class_552)var2.next()));
        }

        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            ((Thread)var3.next()).start();
        }

        Iterator var4 = var1.iterator();

        while(var4.hasNext()) {
            ((Thread)var4.next()).join();
        }

    }

    // $FF: renamed from: a (crittercism.android.bs, crittercism.android.cz, java.lang.String, java.lang.String, java.lang.String, crittercism.android.au, crittercism.android.cx) void
    public final void method_4004(class_803 var1, class_97 var2, String var3, String var4, String var5, class_106 var6, class_99 var7) {
        synchronized(this) {}

        try {
            if(var1.method_4169() > 0) {
                class_803 var9 = var1.method_4164(this.field_3587);
                class_98 var10 = var2.method_393(var9, var1, var5, this.field_3587, var6);
                class_559 var11 = new class_559(var9, var1, var6, (new class_753(var3, var4)).method_3999(), var10, var7);
                this.field_3588.add(var11);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (crittercism.android.dg, java.util.concurrent.ExecutorService) void
    public final void method_4005(class_555 var1, ExecutorService var2) {
        Iterator var3 = this.field_3588.iterator();

        while(var3.hasNext()) {
            class_552 var4 = (class_552)var3.next();
            if(!var1.method_3405(var4)) {
                var2.execute(var4);
            }
        }

    }
}
