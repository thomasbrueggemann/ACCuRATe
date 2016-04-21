package com.google.android.gms.internal;

import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_164;
import com.google.android.gms.internal.class_872;
import com.google.android.gms.internal.class_876;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.nj
public class class_873 {
    private final ArrayList<class_873.class_1323> akK;
    private int akL;

    public class_873() {
        this(100);
    }

    public class_873(int var1) {
        this.akK = new ArrayList();
        this.akL = var1;
    }

    // $FF: renamed from: mX () void
    private void method_4534() {
        while(this.getSize() > this.getCapacity()) {
            this.akK.remove(0);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.nm, com.google.android.gms.internal.ni) void
    public void method_4535(class_876 var1, class_872 var2) {
        this.akK.add(new class_873.class_1323(var1, var2));
        this.method_4534();
    }

    public void clear() {
        this.akK.clear();
    }

    public int getCapacity() {
        return this.akL;
    }

    public int getSize() {
        return this.akK.size();
    }

    public boolean isEmpty() {
        return this.akK.isEmpty();
    }

    // $FF: renamed from: mW () java.util.ArrayList
    public ArrayList<class_873.class_1323> method_4536() {
        return this.akK;
    }

    public static class class_1323 {
        public final class_876 akM;
        public final class_872 akN;
        public final class_164.class_1509 akO;

        private class_1323(class_876 var1, class_872 var2) {
            this.akM = (class_876)class_1090.method_5685(var1);
            this.akN = (class_872)class_1090.method_5685(var2);
            this.akO = null;
        }

        // $FF: synthetic method
        class_1323(class_876 var1, class_872 var2, Object var3) {
            this(var1, var2);
        }
    }
}
