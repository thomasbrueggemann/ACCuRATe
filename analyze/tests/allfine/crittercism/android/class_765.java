package crittercism.android;

import crittercism.android.class_763;
import java.util.concurrent.ThreadFactory;

// $FF: renamed from: crittercism.android.dz
public final class class_765 implements ThreadFactory {
    public final Thread newThread(Runnable var1) {
        return new class_763(var1);
    }
}
