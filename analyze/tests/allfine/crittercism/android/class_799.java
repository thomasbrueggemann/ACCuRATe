package crittercism.android;

import com.crittercism.integrations.PluginException;
import crittercism.android.class_732;
import crittercism.android.class_764;
import crittercism.android.class_795;
import crittercism.android.class_801;
import crittercism.android.class_803;
import crittercism.android.class_805;
import crittercism.android.class_806;
import crittercism.android.class_807;
import crittercism.android.class_96;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bk
public final class class_799 implements class_96 {
    // $FF: renamed from: a long
    public long field_3777;
    // $FF: renamed from: b org.json.JSONArray
    public JSONArray field_3778;
    // $FF: renamed from: c java.lang.String
    public String field_3779;
    // $FF: renamed from: d java.lang.String
    public String field_3780;
    // $FF: renamed from: e org.json.JSONArray
    public JSONArray field_3781;
    // $FF: renamed from: f java.lang.String
    public String field_3782;
    // $FF: renamed from: g org.json.JSONObject
    public JSONObject field_3783;
    // $FF: renamed from: h org.json.JSONObject
    private JSONObject field_3784;
    // $FF: renamed from: i org.json.JSONArray
    private JSONArray field_3785;
    // $FF: renamed from: j org.json.JSONArray
    private JSONArray field_3786;
    // $FF: renamed from: k java.lang.String
    private String field_3787;
    // $FF: renamed from: l org.json.JSONArray
    private JSONArray field_3788;
    // $FF: renamed from: m java.lang.String
    private String field_3789;
    // $FF: renamed from: n int
    private int field_3790;
    // $FF: renamed from: o boolean
    private boolean field_3791;
    // $FF: renamed from: p java.lang.String
    private String field_3792;

    public class_799(Throwable var1, long var2) {
        int var4 = 0;
        super();
        this.field_3780 = "";
        this.field_3790 = -1;
        this.field_3791 = false;
        this.field_3791 = var1 instanceof PluginException;
        this.field_3792 = class_732.field_3484.method_3968();
        this.field_3782 = "uhe";
        class_805 var5 = new class_805();
        var5.method_4178(new class_806.class_1426()).method_4178(new class_806.class_1429()).method_4178(new class_806.class_1428()).method_4178(new class_806.class_1430()).method_4178(new class_806.class_1431()).method_4178(new class_806.class_1432()).method_4178(new class_806.class_1441()).method_4178(new class_806.class_1442()).method_4178(new class_806.class_1435()).method_4178(new class_806.class_1436()).method_4178(new class_806.class_1434()).method_4178(new class_806.class_1452()).method_4178(new class_806.class_1427()).method_4178(new class_806.class_1437()).method_4178(new class_806.class_1438()).method_4178(new class_806.class_1440()).method_4178(new class_806.class_1439()).method_4178(new class_806.class_1443()).method_4178(new class_806.class_1444()).method_4178(new class_806.class_1445()).method_4178(new class_806.class_1446()).method_4178(new class_806.class_1447()).method_4178(new class_806.class_1448()).method_4178(new class_806.class_1449()).method_4178(new class_806.class_1450()).method_4178(new class_806.class_1451());
        this.field_3783 = var5.method_4179();
        this.field_3784 = new JSONObject();
        this.field_3777 = var2;
        this.field_3779 = this.method_4149(var1);
        if(var1.getMessage() != null) {
            this.field_3780 = var1.getMessage();
        }

        if(!this.field_3791) {
            this.field_3790 = method_4151(var1);
        }

        this.field_3787 = "android";
        this.field_3789 = class_807.field_3864.method_4194();
        this.field_3788 = new JSONArray();
        String[] var7 = method_4150(var1);

        for(int var8 = var7.length; var4 < var8; ++var4) {
            String var9 = var7[var4];
            this.field_3788.put(var9);
        }

    }

    // $FF: renamed from: a (java.lang.Throwable) java.lang.String
    private String method_4149(Throwable var1) {
        if(this.field_3791) {
            return ((PluginException)var1).getExceptionName();
        } else {
            while(true) {
                String var2 = var1.getClass().getName();
                Throwable var3 = var1.getCause();
                if(var3 == null || var3 == var1) {
                    return var2;
                }

                var1 = var3;
            }
        }
    }

    // $FF: renamed from: b (java.lang.Throwable) java.lang.String[]
    private static String[] method_4150(Throwable var0) {
        StringWriter var1 = new StringWriter();
        PrintWriter var2 = new PrintWriter(var1);

        while(true) {
            var0.printStackTrace(var2);
            Throwable var3 = var0.getCause();
            if(var3 == null || var3 == var0) {
                return var1.toString().split("\n");
            }

            var0 = var3;
        }
    }

    // $FF: renamed from: c (java.lang.Throwable) int
    private static int method_4151(Throwable var0) {
        StackTraceElement[] var1 = var0.getStackTrace();

        for(int var2 = 0; var2 < var1.length; ++var2) {
            StackTraceElement var3 = var1[var2];

            Class var5;
            try {
                var5 = Class.forName(var3.getClassName());
            } catch (ClassNotFoundException var8) {
                continue;
            }

            ClassLoader var6 = ClassLoader.getSystemClassLoader();

            boolean var7;
            while(true) {
                if(var6 == null) {
                    var7 = false;
                    break;
                }

                if(var5.getClassLoader() == var6) {
                    var7 = true;
                    break;
                }

                var6 = var6.getParent();
            }

            if(!var7) {
                return var2 + 1;
            }
        }

        return -1;
    }

    // $FF: renamed from: a () void
    public final void method_4152() {
        this.field_3781 = new JSONArray();
        Iterator var1 = Thread.getAllStackTraces().entrySet().iterator();

        while(var1.hasNext()) {
            Entry var2 = (Entry)var1.next();
            HashMap var3 = new HashMap();
            Thread var4 = (Thread)var2.getKey();
            if(var4.getId() != this.field_3777) {
                var3.put("name", var4.getName());
                var3.put("id", Long.valueOf(var4.getId()));
                var3.put("state", var4.getState().name());
                var3.put("stacktrace", new JSONArray(Arrays.asList((Object[])var2.getValue())));
                this.field_3781.put(new JSONObject(var3));
            }
        }

    }

    // $FF: renamed from: a (crittercism.android.bs) void
    public final void method_4153(class_803 var1) {
        this.field_3785 = (new class_801(var1)).field_3795;
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        var1.write(this.method_4156().toString().getBytes());
    }

    // $FF: renamed from: a (java.lang.String, crittercism.android.bs) void
    public final void method_4154(String var1, class_803 var2) {
        JSONArray var3 = (new class_801(var2)).field_3795;

        try {
            this.field_3784.put(var1, var3);
        } catch (JSONException var5) {
            ;
        }
    }

    // $FF: renamed from: a (java.util.List) void
    public final void method_4155(List var1) {
        this.field_3786 = new JSONArray();
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            class_795 var3 = (class_795)var2.next();

            try {
                this.field_3786.put(var3.method_4144());
            } catch (JSONException var5) {
                class_764.method_4019(var5);
            }
        }

    }

    // $FF: renamed from: b () org.json.JSONObject
    public final JSONObject method_4156() {
        HashMap var1 = new HashMap();
        var1.put("app_state", this.field_3783);
        var1.put("breadcrumbs", this.field_3784);
        var1.put("current_thread_id", Long.valueOf(this.field_3777));
        if(this.field_3785 != null) {
            var1.put("endpoints", this.field_3785);
        }

        if(this.field_3778 != null) {
            var1.put("systemBreadcrumbs", this.field_3778);
        }

        if(this.field_3786 != null && this.field_3786.length() > 0) {
            var1.put("transactions", this.field_3786);
        }

        var1.put("exception_name", this.field_3779);
        var1.put("exception_reason", this.field_3780);
        var1.put("platform", this.field_3787);
        if(this.field_3781 != null) {
            var1.put("threads", this.field_3781);
        }

        var1.put("ts", this.field_3789);
        String var9 = this.field_3782;
        if(this.field_3777 != 1L) {
            var9 = var9 + "-bg";
        }

        var1.put("type", var9);
        var1.put("unsymbolized_stacktrace", this.field_3788);
        if(!this.field_3791) {
            var1.put("suspect_line_index", Integer.valueOf(this.field_3790));
        }

        return new JSONObject(var1);
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3792;
    }
}
