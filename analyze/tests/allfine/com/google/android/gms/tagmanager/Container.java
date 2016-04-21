package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_563;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_618;
import com.google.android.gms.tagmanager.class_626;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_638;
import com.google.android.gms.tagmanager.class_639;
import com.google.android.gms.tagmanager.class_83;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private final String aoc;
    private final DataLayer aod;
    private class_639 aoe;
    private Map<String, Container.FunctionCallMacroCallback> aof = new HashMap();
    private Map<String, Container.FunctionCallTagCallback> aog = new HashMap();
    private volatile long aoh;
    private volatile String aoi = "";
    private final Context mContext;

    Container(Context var1, DataLayer var2, String var3, long var4, class_51.class_1320 var6) {
        this.mContext = var1;
        this.aod = var2;
        this.aoc = var3;
        this.aoh = var4;
        this.method_5959(var6.field_1008);
        if(var6.field_1007 != null) {
            this.method_5962(var6.field_1007);
        }

    }

    Container(Context var1, DataLayer var2, String var3, long var4, class_638.class_1807 var6) {
        this.mContext = var1;
        this.aod = var2;
        this.aoc = var3;
        this.aoh = var4;
        this.method_5960(var6);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.c$f) void
    private void method_5959(class_51.class_1327 var1) {
        if(var1 == null) {
            throw new NullPointerException();
        } else {
            class_638.class_1807 var3;
            try {
                var3 = class_638.method_3592(var1);
            } catch (class_638.class_1811 var4) {
                class_612.method_3456("Not loading resource: " + var1 + " because it is invalid: " + var4.toString());
                return;
            }

            this.method_5960(var3);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$c) void
    private void method_5960(class_638.class_1807 var1) {
        this.aoi = var1.getVersion();
        class_83 var2 = this.method_5967(this.aoi);
        this.method_5961(new class_639(this.mContext, var1, this.aod, new Container.class_1527(), new Container.class_1524(), var2));
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.ct) void
    private void method_5961(class_639 var1) {
        synchronized(this) {}

        try {
            this.aoe = var1;
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.c$i[]) void
    private void method_5962(class_51.class_1319[] var1) {
        ArrayList var2 = new ArrayList();
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            var2.add(var1[var4]);
        }

        this.method_5963().method_3617(var2);
    }

    // $FF: renamed from: nT () com.google.android.gms.tagmanager.ct
    private class_639 method_5963() {
        synchronized(this) {}

        class_639 var2;
        try {
            var2 = this.aoe;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: cn (java.lang.String) com.google.android.gms.tagmanager.Container$FunctionCallMacroCallback
    Container.FunctionCallMacroCallback method_5964(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: co (java.lang.String) com.google.android.gms.tagmanager.Container$FunctionCallTagCallback
    Container.FunctionCallTagCallback method_5965(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cp (java.lang.String) void
    void method_5966(String var1) {
        this.method_5963().method_3616(var1);
    }

    // $FF: renamed from: cq (java.lang.String) com.google.android.gms.tagmanager.ag
    class_83 method_5967(String var1) {
        if(class_618.method_3490().method_3492().equals(class_618.class_1772.aqj)) {
            ;
        }

        return new class_626();
    }

    public boolean getBoolean(String var1) {
        class_639 var2 = this.method_5963();
        if(var2 == null) {
            class_612.method_3456("getBoolean called for closed container.");
            return class_634.method_3553().booleanValue();
        } else {
            try {
                boolean var4 = class_634.method_3547((class_53.class_1172)var2.method_3614(var1).getObject()).booleanValue();
                return var4;
            } catch (Exception var5) {
                class_612.method_3456("Calling getBoolean() threw an exception: " + var5.getMessage() + " Returning default value.");
                return class_634.method_3553().booleanValue();
            }
        }
    }

    public String getContainerId() {
        return this.aoc;
    }

    public double getDouble(String var1) {
        class_639 var2 = this.method_5963();
        if(var2 == null) {
            class_612.method_3456("getDouble called for closed container.");
            return class_634.method_3552().doubleValue();
        } else {
            try {
                double var4 = class_634.method_3546((class_53.class_1172)var2.method_3614(var1).getObject()).doubleValue();
                return var4;
            } catch (Exception var6) {
                class_612.method_3456("Calling getDouble() threw an exception: " + var6.getMessage() + " Returning default value.");
                return class_634.method_3552().doubleValue();
            }
        }
    }

    public long getLastRefreshTime() {
        return this.aoh;
    }

    public long getLong(String var1) {
        class_639 var2 = this.method_5963();
        if(var2 == null) {
            class_612.method_3456("getLong called for closed container.");
            return class_634.method_3551().longValue();
        } else {
            try {
                long var4 = class_634.method_3545((class_53.class_1172)var2.method_3614(var1).getObject()).longValue();
                return var4;
            } catch (Exception var6) {
                class_612.method_3456("Calling getLong() threw an exception: " + var6.getMessage() + " Returning default value.");
                return class_634.method_3551().longValue();
            }
        }
    }

    public String getString(String var1) {
        class_639 var2 = this.method_5963();
        if(var2 == null) {
            class_612.method_3456("getString called for closed container.");
            return class_634.method_3555();
        } else {
            try {
                String var4 = class_634.method_3543((class_53.class_1172)var2.method_3614(var1).getObject());
                return var4;
            } catch (Exception var5) {
                class_612.method_3456("Calling getString() threw an exception: " + var5.getMessage() + " Returning default value.");
                return class_634.method_3555();
            }
        }
    }

    public boolean isDefault() {
        return this.getLastRefreshTime() == 0L;
    }

    // $FF: renamed from: nS () java.lang.String
    String method_5968() {
        return this.aoi;
    }

    public void registerFunctionCallMacroCallback(String param1, Container.FunctionCallMacroCallback param2) {
        // $FF: Couldn't be decompiled
    }

    public void registerFunctionCallTagCallback(String param1, Container.FunctionCallTagCallback param2) {
        // $FF: Couldn't be decompiled
    }

    void release() {
        this.aoe = null;
    }

    public void unregisterFunctionCallMacroCallback(String param1) {
        // $FF: Couldn't be decompiled
    }

    public void unregisterFunctionCallTagCallback(String param1) {
        // $FF: Couldn't be decompiled
    }

    public interface FunctionCallMacroCallback {
        Object getValue(String var1, Map<String, Object> var2);
    }

    public interface FunctionCallTagCallback {
        void execute(String var1, Map<String, Object> var2);
    }

    private class class_1527 implements class_563.class_1783 {
        private class_1527() {
        }

        // $FF: synthetic method
        class_1527(Object var2) {
            this();
        }

        // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
        public Object method_1057(String var1, Map<String, Object> var2) {
            Container.FunctionCallMacroCallback var3 = Container.this.method_5964(var1);
            return var3 == null?null:var3.getValue(var1, var2);
        }
    }

    private class class_1524 implements class_563.class_1783 {
        private class_1524() {
        }

        // $FF: synthetic method
        class_1524(Object var2) {
            this();
        }

        // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
        public Object method_1057(String var1, Map<String, Object> var2) {
            Container.FunctionCallTagCallback var3 = Container.this.method_5965(var1);
            if(var3 != null) {
                var3.execute(var1, var2);
            }

            return class_634.method_3555();
        }
    }
}
