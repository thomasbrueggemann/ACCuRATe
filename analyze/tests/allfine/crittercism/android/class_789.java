package crittercism.android;

import crittercism.android.class_764;
import crittercism.android.class_790;
import java.lang.Thread.UncaughtExceptionHandler;

// $FF: renamed from: crittercism.android.ay
public final class class_789 implements UncaughtExceptionHandler {
    // $FF: renamed from: a java.lang.Thread.UncaughtExceptionHandler
    private UncaughtExceptionHandler field_3685;
    // $FF: renamed from: b crittercism.android.az
    private final class_790 field_3686;

    public class_789(class_790 var1, UncaughtExceptionHandler var2) {
        this.field_3686 = var1;
        this.field_3685 = var2;
    }

    public final void uncaughtException(Thread var1, Throwable var2) {
        try {
            this.field_3686.method_4092(var2);
            return;
        } catch (ThreadDeath var9) {
            throw var9;
        } catch (Throwable var10) {
            class_764.method_4018("Unable to send crash", var10);
        } finally {
            if(this.field_3685 != null && !(this.field_3685 instanceof class_789)) {
                this.field_3685.uncaughtException(Thread.currentThread(), var2);
            }

        }

    }
}
