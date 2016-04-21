package crittercism.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import crittercism.android.class_672;
import crittercism.android.class_673;
import crittercism.android.class_764;
import crittercism.android.class_790;
import crittercism.android.class_794;
import crittercism.android.class_795;

// $FF: renamed from: crittercism.android.av
public final class class_788 implements ActivityLifecycleCallbacks {
    // $FF: renamed from: a int
    private int field_3678 = 0;
    // $FF: renamed from: b boolean
    private boolean field_3679 = false;
    // $FF: renamed from: c boolean
    private boolean field_3680 = false;
    // $FF: renamed from: d boolean
    private boolean field_3681 = false;
    // $FF: renamed from: e android.content.Context
    private Context field_3682;
    // $FF: renamed from: f crittercism.android.az
    private class_790 field_3683;
    // $FF: renamed from: g crittercism.android.bd
    private class_794 field_3684;

    public class_788(Context var1, class_790 var2) {
        this.field_3682 = var1;
        this.field_3683 = var2;
        this.field_3684 = new class_794(var1, var2);
    }

    public final void onActivityCreated(Activity var1, Bundle var2) {
    }

    public final void onActivityDestroyed(Activity var1) {
    }

    public final void onActivityPaused(Activity var1) {
        if(var1 != null) {
            try {
                if(this.field_3680) {
                    var1.unregisterReceiver(this.field_3684);
                    this.field_3680 = false;
                }
            } catch (ThreadDeath var4) {
                throw var4;
            } catch (Throwable var5) {
                class_764.method_4019(var5);
                return;
            }
        }

    }

    public final void onActivityResumed(Activity param1) {
        // $FF: Couldn't be decompiled
    }

    public final void onActivitySaveInstanceState(Activity var1, Bundle var2) {
    }

    public final void onActivityStarted(Activity var1) {
    }

    public final void onActivityStopped(Activity var1) {
        if(var1 != null) {
            try {
                this.field_3678 += -1;
                if(var1.isChangingConfigurations()) {
                    class_764.method_4020();
                    this.field_3679 = true;
                    return;
                }

                if(this.field_3678 == 0) {
                    this.field_3683.method_4088(new class_672(class_672.class_1232.field_3177));
                    class_795.method_4123(this.field_3683);
                    return;
                }

                this.field_3683.method_4088(new class_673(class_673.class_1231.field_4221, var1.getClass().getName()));
                return;
            } catch (ThreadDeath var4) {
                throw var4;
            } catch (Throwable var5) {
                class_764.method_4019(var5);
            }
        }

    }
}
