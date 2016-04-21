package crittercism.android;

import crittercism.android.class_675;
import crittercism.android.class_87;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

// $FF: renamed from: crittercism.android.e
public final class class_661 {
    // $FF: renamed from: a java.util.List
    List field_3222;
    // $FF: renamed from: b java.util.Set
    final Set field_3223;
    // $FF: renamed from: c java.util.Set
    final Set field_3224;
    // $FF: renamed from: d java.util.concurrent.Executor
    private Executor field_3225;

    public class_661(Executor var1) {
        this(var1, new LinkedList(), new LinkedList());
    }

    private class_661(Executor var1, List var2, List var3) {
        this.field_3222 = new LinkedList();
        this.field_3223 = new HashSet();
        this.field_3224 = new HashSet();
        this.field_3225 = var1;
        this.method_3712(var2);
        this.method_3713(var3);
    }

    // $FF: renamed from: a (crittercism.android.c) void
    @Deprecated
    public final void method_3709(class_675 var1) {
        this.method_3710(var1, class_675.class_1233.field_3854);
    }

    // $FF: renamed from: a (crittercism.android.c, crittercism.android.c$a) void
    public final void method_3710(class_675 var1, class_675.class_1233 var2) {
        if(!var1.field_3262) {
            var1.field_3262 = true;
            var1.field_3263 = var2;
            this.field_3225.execute(new class_661.class_1236(var1, (byte)0));
        }
    }

    // $FF: renamed from: a (crittercism.android.f) void
    public final void method_3711(class_87 var1) {
        List var2 = this.field_3222;
        synchronized(var2) {
            this.field_3222.add(var1);
        }
    }

    // $FF: renamed from: a (java.util.List) void
    public final void method_3712(List var1) {
        Set var2 = this.field_3223;
        synchronized(var2) {
            this.field_3223.addAll(var1);
            this.field_3223.remove((Object)null);
        }
    }

    // $FF: renamed from: b (java.util.List) void
    public final void method_3713(List var1) {
        Set var2 = this.field_3224;
        synchronized(var2) {
            this.field_3224.addAll(var1);
            this.field_3224.remove((Object)null);
        }
    }

    final class class_1236 implements Runnable {
        // $FF: renamed from: b crittercism.android.c
        private class_675 field_3181;

        private class_1236(class_675 var2) {
            this.field_3181 = var2;
        }

        // $FF: synthetic method
        class_1236(class_675 var2, byte var3) {
            this();
        }

        // $FF: renamed from: a (crittercism.android.c) boolean
        private boolean method_3640(class_675 var1) {
            String var2 = var1.method_3732();
            Set var3 = class_661.this.field_3223;
            synchronized(var3) {
                Iterator var5 = class_661.this.field_3223.iterator();

                while(var5.hasNext()) {
                    if(var2.contains((String)var5.next())) {
                        return true;
                    }
                }
            }

            return false;
        }

        // $FF: renamed from: a (java.lang.String) boolean
        private boolean method_3641(String var1) {
            Set var2 = class_661.this.field_3224;
            synchronized(var2) {
                Iterator var4 = class_661.this.field_3224.iterator();

                while(var4.hasNext()) {
                    if(var1.contains((String)var4.next())) {
                        return false;
                    }
                }
            }

            return true;
        }

        public final void run() {
            // $FF: Couldn't be decompiled
        }
    }
}
