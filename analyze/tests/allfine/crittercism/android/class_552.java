package crittercism.android;

import crittercism.android.class_764;

// $FF: renamed from: crittercism.android.di
public abstract class class_552 implements Runnable {
    // $FF: renamed from: a () void
    public abstract void method_3390();

    public final void run() {
        try {
            this.method_3390();
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }
}
