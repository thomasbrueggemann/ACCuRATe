package crittercism.android;

import android.os.Process;
import android.os.Build.VERSION;
import com.crittercism.app.Transaction;
import crittercism.android.class_105;
import crittercism.android.class_552;
import crittercism.android.class_732;
import crittercism.android.class_764;
import crittercism.android.class_765;
import crittercism.android.class_790;
import crittercism.android.class_798;
import crittercism.android.class_807;
import crittercism.android.class_96;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bg
public final class class_795 extends Transaction implements class_96 {
    // $FF: renamed from: b java.util.concurrent.ExecutorService
    private static ExecutorService field_3746 = Executors.newSingleThreadExecutor(new class_765());
    // $FF: renamed from: c java.util.concurrent.ScheduledExecutorService
    private static ScheduledExecutorService field_3747 = Executors.newScheduledThreadPool(1, new class_765());
    // $FF: renamed from: o java.util.List
    private static List field_3748 = new LinkedList();
    // $FF: renamed from: p long
    private static volatile long field_3749 = 0L;
    // $FF: renamed from: q long
    private static volatile long field_3750 = 0L;
    // $FF: renamed from: r int[]
    private static final int[] field_3751 = new int[] {32, 544, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 8224};
    // $FF: renamed from: s crittercism.android.bg
    private static class_795 field_3752 = null;
    // $FF: renamed from: t crittercism.android.bh
    private static class_798 field_3753 = new class_798();
    // $FF: renamed from: d java.lang.String
    private String field_3754;
    // $FF: renamed from: e long
    private long field_3755;
    // $FF: renamed from: f int
    private int field_3756;
    // $FF: renamed from: g long
    private long field_3757;
    // $FF: renamed from: h long
    private long field_3758;
    // $FF: renamed from: i long
    private long field_3759;
    // $FF: renamed from: j crittercism.android.bg$a
    private class_795.class_1378 field_3760;
    // $FF: renamed from: k java.util.Map
    private Map field_3761;
    // $FF: renamed from: l java.lang.String
    private String field_3762;
    // $FF: renamed from: m long
    private long field_3763;
    // $FF: renamed from: n java.util.concurrent.ScheduledFuture
    private ScheduledFuture field_3764;

    public class_795(class_790 var1, String var2) {
        int var3 = -1;
        super();
        this.field_3755 = -1L;
        this.field_3756 = var3;
        this.field_3764 = null;
        if(var2.length() > 255) {
            class_764.method_4024("Transaction name exceeds 255 characters! Truncating to first 255 characters.");
            this.field_3754 = var2.substring(0, 255);
        } else {
            this.field_3754 = var2;
        }

        this.field_3760 = class_795.class_1378.field_4359;
        this.field_3761 = new HashMap();
        this.a = var1;
        this.field_3762 = class_732.field_3484.method_3968();
        this.field_3755 = -1L;
        JSONObject var4 = field_3753.field_3774.optJSONObject(var2);
        if(var4 != null) {
            var3 = var4.optInt("value", var3);
        }

        this.field_3756 = var3;
    }

    private class_795(class_795 var1) {
        this.field_3755 = -1L;
        this.field_3756 = -1;
        this.field_3764 = null;
        this.field_3754 = var1.field_3754;
        this.field_3755 = var1.field_3755;
        this.field_3756 = var1.field_3756;
        this.field_3757 = var1.field_3757;
        this.field_3758 = var1.field_3758;
        this.field_3760 = var1.field_3760;
        this.field_3761 = var1.field_3761;
        this.field_3762 = var1.field_3762;
        this.field_3759 = var1.field_3759;
        this.field_3763 = var1.field_3763;
    }

    public class_795(JSONArray var1) {
        this.field_3755 = -1L;
        this.field_3756 = -1;
        this.field_3764 = null;
        this.field_3754 = var1.getString(0);
        this.field_3760 = class_795.class_1378.values()[var1.getInt(1)];
        this.field_3755 = (long)((int)(1000.0D * var1.getDouble(2)));
        this.field_3756 = var1.optInt(3, -1);
        this.field_3761 = new HashMap();
        JSONObject var2 = var1.getJSONObject(4);
        Iterator var3 = var2.keys();

        while(var3.hasNext()) {
            String var4 = (String)var3.next();
            this.field_3761.put(var4, var2.getString(var4));
        }

        this.field_3757 = class_807.field_3864.method_4193(var1.getString(5));
        this.field_3758 = class_807.field_3864.method_4193(var1.getString(6));
        this.field_3759 = (long)(var1.optDouble(7, 0.0D) * Math.pow(10.0D, 9.0D));
        this.field_3762 = class_732.field_3484.method_3968();
    }

    // $FF: renamed from: a (crittercism.android.bg) crittercism.android.bg$a
    // $FF: synthetic method
    static class_795.class_1378 method_4119(class_795 var0) {
        return var0.field_3760;
    }

    // $FF: renamed from: a (crittercism.android.az, boolean) java.util.List
    public static List method_4120(class_790 param0, boolean param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (long) void
    private void method_4121(long var1) {
        if(method_4134()) {
            this.field_3764 = field_3747.schedule(new class_552() {
                // $FF: renamed from: a () void
                public final void method_3390() {
                    class_795.this.method_4141();
                }
            }, var1, TimeUnit.MILLISECONDS);
        }

    }

    // $FF: renamed from: a (crittercism.android.aw) void
    public static void method_4122(class_105 param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (crittercism.android.az) void
    public static void method_4123(class_790 param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (crittercism.android.bg$a) void
    private void method_4124(class_795.class_1378 var1) {
        if(var1 != class_795.class_1378.field_4361 && var1 != class_795.class_1378.field_4363) {
            class_795.class_1378 var10000 = class_795.class_1378.field_4367;
        }

        if(this.field_3760 == class_795.class_1378.field_4360) {
            this.method_4140();
            this.method_4128(var1);
        } else if(this.field_3760 != class_795.class_1378.field_4364) {
            class_764.method_4022("Transaction " + this.field_3754 + " is not running. Either it has not been started or it has been stopped.", new IllegalStateException("Transaction is not running"));
            return;
        }

    }

    // $FF: renamed from: a (crittercism.android.bh) void
    public static void method_4125(class_798 var0) {
        field_3753 = var0;
    }

    // $FF: renamed from: b (int) void
    private void method_4126(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (crittercism.android.az) void
    public static void method_4127(class_790 param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (crittercism.android.bg$a) void
    private void method_4128(class_795.class_1378 var1) {
        this.field_3760 = var1;
        this.field_3758 = System.currentTimeMillis();
        long var2 = System.nanoTime();
        if(method_4134()) {
            long var10 = Math.max(field_3749, this.field_3763);
            this.field_3759 += var2 - var10;
        }

        List var4 = field_3748;
        synchronized(var4) {
            field_3748.remove(this);
        }

        class_552 var7 = new class_552() {
            // $FF: renamed from: a crittercism.android.bg
            // $FF: synthetic field
            final class_795 field_2975;

            {
                this.field_2975 = var2;
            }

            // $FF: renamed from: a () void
            public final void method_3390() {
                class_795.this.a.field_3713.field_3006.block();
                class_795.this.a.field_3710.method_4167(class_795.this.field_3762);
                class_795.this.a.field_3711.method_4168(this.field_2975);
            }
        };
        ExecutorService var8 = field_3746;
        synchronized(var8) {
            field_3746.execute(var7);
        }
    }

    // $FF: renamed from: f () void
    public static void method_4131() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: g () void
    public static void method_4132() {
        try {
            if(field_3752 != null) {
                field_3752.method_4116();
            }

        } catch (ThreadDeath var2) {
            throw var2;
        } catch (Throwable var3) {
            class_764.method_4019(var3);
        }
    }

    // $FF: renamed from: i () void
    public static void method_4133() {
        LinkedList var0 = new LinkedList();
        List var1 = field_3748;
        synchronized(var1) {
            var0.addAll(field_3748);
        }

        Iterator var4 = var0.iterator();

        while(var4.hasNext()) {
            class_795 var5 = (class_795)var4.next();
            synchronized(var5) {
                if(var5.field_3760 == class_795.class_1378.field_4360) {
                    var5.field_3755 = field_3753.method_4148(var5.field_3754);
                    var5.method_4140();
                    var5.method_4121(var5.field_3755);
                }
            }
        }

    }

    // $FF: renamed from: l () boolean
    private static boolean method_4134() {
        return field_3749 > field_3750;
    }

    // $FF: renamed from: m () long
    private static long method_4135() {
        long[] var0 = new long[1];
        int var1 = Process.myPid();
        String var2 = "/proc/" + var1 + "/stat";

        boolean var9;
        try {
            Method var7 = Process.class.getDeclaredMethod("readProcFile", new Class[] {String.class, int[].class, String[].class, long[].class, float[].class});
            Object[] var8 = new Object[] {var2, field_3751, null, var0, null};
            var9 = ((Boolean)var7.invoke((Object)null, var8)).booleanValue();
        } catch (NoSuchMethodException var10) {
            class_764.method_4019(var10);
            return -1L;
        } catch (IllegalArgumentException var11) {
            class_764.method_4019(var11);
            return -1L;
        } catch (IllegalAccessException var12) {
            class_764.method_4019(var12);
            return -1L;
        } catch (InvocationTargetException var13) {
            class_764.method_4019(var13);
            return -1L;
        }

        return !var9?-1L:10L * var0[0];
    }

    // $FF: renamed from: n () void
    private void method_4136() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: o () void
    private void method_4137() {
        synchronized(this) {}

        try {
            this.method_4124(class_795.class_1378.field_4361);
        } finally {
            ;
        }

    }

    // $FF: renamed from: p () void
    private void method_4138() {
        synchronized(this) {}

        try {
            this.method_4124(class_795.class_1378.field_4363);
        } finally {
            ;
        }

    }

    // $FF: renamed from: q () void
    private void method_4139() {
        synchronized(this) {}

        try {
            this.method_4124(class_795.class_1378.field_4367);
        } finally {
            ;
        }

    }

    // $FF: renamed from: r () void
    private void method_4140() {
        synchronized(this) {}

        try {
            if(this.field_3764 != null) {
                this.field_3764.cancel(false);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: s () void
    private void method_4141() {
        synchronized(this) {}

        try {
            if(this.field_3760 == class_795.class_1378.field_4360) {
                this.method_4128(class_795.class_1378.field_4364);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: t () int
    private int method_4142() {
        synchronized(this) {}

        int var2;
        try {
            var2 = this.field_3756;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: a () void
    public final void method_4114() {
        try {
            this.method_4136();
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    // $FF: renamed from: a (int) void
    public final void method_4115(int var1) {
        try {
            this.method_4126(var1);
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
        }
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        JSONArray var3;
        label16: {
            JSONArray var4;
            try {
                var4 = this.method_4144();
            } catch (JSONException var5) {
                var3 = null;
                break label16;
            }

            var3 = var4;
        }

        if(var3 != null) {
            var1.write(var3.toString().getBytes());
        }

    }

    // $FF: renamed from: b () void
    public final void method_4116() {
        try {
            this.method_4137();
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    // $FF: renamed from: c () void
    public final void method_4117() {
        try {
            this.method_4138();
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    // $FF: renamed from: d () int
    public final int method_4118() {
        try {
            int var3 = this.method_4142();
            return var3;
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
            return -1;
        }
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3762;
    }

    // $FF: renamed from: h () void
    public final void method_4143() {
        try {
            this.method_4139();
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    // $FF: renamed from: j () org.json.JSONArray
    public final JSONArray method_4144() {
        JSONArray var1 = (new JSONArray()).put(this.field_3754).put(this.field_3760.ordinal()).put((double)this.field_3755 / 1000.0D);
        Object var2;
        if(this.field_3756 == -1) {
            var2 = JSONObject.NULL;
        } else {
            var2 = Integer.valueOf(this.field_3756);
        }

        JSONArray var3 = var1.put(var2).put(new JSONObject(this.field_3761)).put(class_807.field_3864.method_4195(new Date(this.field_3757))).put(class_807.field_3864.method_4195(new Date(this.field_3758)));
        if(VERSION.SDK_INT >= 14) {
            var3.put((double)Math.round(1000.0D * ((double)this.field_3759 / Math.pow(10.0D, 9.0D))) / 1000.0D);
            return var3;
        } else {
            var3.put(JSONObject.NULL);
            return var3;
        }
    }

    // $FF: renamed from: k () crittercism.android.bg$a
    public final class_795.class_1378 method_4145() {
        return this.field_3760;
    }

    static enum class_1378 {
        // $FF: renamed from: a crittercism.android.bg$a
        field_4359,
        // $FF: renamed from: b crittercism.android.bg$a
        field_4360,
        // $FF: renamed from: c crittercism.android.bg$a
        field_4361,
        // $FF: renamed from: d crittercism.android.bg$a
        field_4362,
        // $FF: renamed from: e crittercism.android.bg$a
        field_4363,
        // $FF: renamed from: f crittercism.android.bg$a
        field_4364,
        // $FF: renamed from: g crittercism.android.bg$a
        field_4365,
        // $FF: renamed from: h crittercism.android.bg$a
        field_4366,
        // $FF: renamed from: i crittercism.android.bg$a
        field_4367;

        static {
            class_795.class_1378[] var0 = new class_795.class_1378[]{field_4359, field_4360, field_4361, field_4362, field_4363, field_4364, field_4365, field_4366, field_4367};
        }
    }
}
