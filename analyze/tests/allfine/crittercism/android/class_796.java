package crittercism.android;

import com.crittercism.app.Transaction;
import crittercism.android.class_764;

// $FF: renamed from: crittercism.android.be
public final class class_796 extends Transaction {
    public class_796() {
        class_764.method_4024("Creating no-op transaction");
    }

    // $FF: renamed from: a () void
    public final void method_4114() {
        class_764.method_4022("No-op transaction. Ignoring Transaction.start() call.", new IllegalStateException("No-op transaction"));
    }

    // $FF: renamed from: a (int) void
    public final void method_4115(int var1) {
        class_764.method_4022("No-op transaction. Ignoring Transaction.setValue(double) call.", new IllegalStateException("No-op transaction"));
    }

    // $FF: renamed from: b () void
    public final void method_4116() {
        class_764.method_4022("No-op transaction. Ignoring Transaction.stop() call.", new IllegalStateException("No-op transaction"));
    }

    // $FF: renamed from: c () void
    public final void method_4117() {
        class_764.method_4022("No-op transaction. Ignoring Transaction.fail() call.", new IllegalStateException("No-op transaction"));
    }

    // $FF: renamed from: d () int
    public final int method_4118() {
        class_764.method_4022("No-op transaction. Ignoring Transaction.getValue() call.", new IllegalStateException("No-op transaction"));
        return -1;
    }
}
