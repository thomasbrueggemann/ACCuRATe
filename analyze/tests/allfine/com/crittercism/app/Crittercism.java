package com.crittercism.app;

import android.app.AlertDialog;
import android.content.Context;
import android.location.Location;
import com.crittercism.app.CritterRateMyAppButtons;
import com.crittercism.app.CrittercismConfig;
import crittercism.android.class_557;
import crittercism.android.class_757;
import crittercism.android.class_764;
import crittercism.android.class_790;
import crittercism.android.class_793;
import java.lang.reflect.Array;
import java.net.URL;
import org.json.JSONObject;

public class Crittercism {
    public static void _logCrashException(String param0, String param1) {
        // $FF: Couldn't be decompiled
    }

    public static void _logCrashException(String param0, String param1, String[] param2, String[] param3, String[] param4, int[] param5) {
        // $FF: Couldn't be decompiled
    }

    @Deprecated
    public static void _logCrashException(Throwable var0) {
        try {
            (new StringBuilder("_logCrashException(Throwable) called with throwable: ")).append(var0.getMessage());
            class_764.method_4020();
            if(!class_790.method_4077().field_3698) {
                method_4221("_logCrashException");
            } else {
                class_790.method_4077().method_4092(var0);
            }
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    public static void _logHandledException(String param0, String param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    public static void _logHandledException(String param0, String param1, String[] param2, String[] param3, String[] param4, int[] param5) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String) void
    private static void method_4219(String var0) {
        class_764.method_4022("Crittercism cannot be initialized", new NullPointerException(var0 + " was null"));
    }

    // $FF: renamed from: a (java.lang.Object[]) boolean
    private static boolean method_4220(Object... var0) {
        byte var1 = 1;
        if(var0.length > 0 && var0[0] != null) {
            int var2 = Array.getLength(var0[0]);

            for(int var3 = var1; var3 < var0.length; ++var3) {
                if(var0[var3] == null) {
                    return false;
                }

                if(Array.getLength(var0[var3]) != var2) {
                    return false;
                }
            }
        } else {
            var1 = 0;
        }

        return (boolean)var1;
    }

    // $FF: renamed from: b (java.lang.String) void
    private static void method_4221(String var0) {
        class_764.method_4022("Must initialize Crittercism before calling " + Crittercism.class.getName() + "." + var0 + "().  Request is being ignored...", new IllegalStateException());
    }

    public static void beginTransaction(String param0) {
        // $FF: Couldn't be decompiled
    }

    public static boolean didCrashOnLastLoad() {
        try {
            class_790 var2 = class_790.method_4077();
            if(!var2.field_3698) {
                method_4221("didCrashOnLoad");
                return false;
            }

            if(!var2.method_4081()) {
                var2.field_3701.block();
                boolean var3 = class_757.field_3589;
                return var3;
            }
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
        }

        return false;
    }

    public static void endTransaction(String param0) {
        // $FF: Couldn't be decompiled
    }

    public static void failTransaction(String param0) {
        // $FF: Couldn't be decompiled
    }

    public static AlertDialog generateRateMyAppAlertDialog(Context param0) {
        // $FF: Couldn't be decompiled
    }

    public static AlertDialog generateRateMyAppAlertDialog(Context var0, String var1, String var2) {
        try {
            AlertDialog var5 = class_790.method_4077().method_4085(var0, var1, var2);
            return var5;
        } catch (ThreadDeath var6) {
            throw var6;
        } catch (Throwable var7) {
            class_764.method_4019(var7);
            return null;
        }
    }

    public static boolean getOptOutStatus() {
        try {
            class_790 var2 = class_790.method_4077();
            if(!var2.field_3698) {
                method_4221("getOptOutStatus");
                return false;
            } else {
                boolean var3 = var2.method_4081();
                return var3;
            }
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
            return false;
        }
    }

    public static int getTransactionValue(String var0) {
        try {
            int var3 = class_790.method_4077().method_4094(var0);
            return var3;
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
            return -1;
        }
    }

    public static void initialize(Context var0, String var1) {
        synchronized(Crittercism.class) {}

        try {
            initialize(var0, var1, new CrittercismConfig());
        } finally {
            ;
        }

    }

    public static void initialize(Context param0, String param1, CrittercismConfig param2) {
        // $FF: Couldn't be decompiled
    }

    public static void leaveBreadcrumb(String param0) {
        // $FF: Couldn't be decompiled
    }

    public static void logHandledException(Throwable var0) {
        try {
            if(!class_790.method_4077().field_3698) {
                method_4221("logHandledException");
                return;
            }

            if(!class_790.method_4077().field_3702.method_4040()) {
                class_790.method_4077().method_4095(var0);
                return;
            }
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }

    }

    public static void logNetworkRequest(String var0, URL var1, long var2, long var4, long var6, int var8, Exception var9) {
        try {
            long var12 = System.currentTimeMillis() - var2;
            if(!class_790.method_4077().field_3698) {
                method_4221("logEndpoint");
                return;
            }

            if(!class_790.method_4077().field_3702.method_4040()) {
                class_790.method_4077().method_4091(var0, var1, var2, var4, var6, var8, var9, var12);
                return;
            }
        } catch (ThreadDeath var14) {
            throw var14;
        } catch (Throwable var15) {
            class_764.method_4019(var15);
        }

    }

    public static void performRateMyAppButtonAction(CritterRateMyAppButtons param0) {
        // $FF: Couldn't be decompiled
    }

    public static void sendAppLoadData() {
        // $FF: Couldn't be decompiled
    }

    public static void setMetadata(JSONObject var0) {
        try {
            if(!class_790.method_4077().field_3698) {
                method_4221("setMetadata");
            } else {
                class_790.method_4077().method_4093(var0);
            }
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    public static void setOptOutStatus(boolean var0) {
        try {
            if(!class_790.method_4077().field_3698) {
                method_4221("setOptOutStatus");
                return;
            }

            class_790 var3 = class_790.method_4077();
            class_557 var4 = new class_557(var3.field_3699, var3, var0);
            if(!var3.field_3713.method_3405(var4)) {
                var3.field_3715.execute(var4);
                return;
            }
        } catch (ThreadDeath var5) {
            throw var5;
        } catch (Throwable var6) {
            class_764.method_4019(var6);
        }

    }

    public static void setTransactionValue(String param0, int param1) {
        // $FF: Couldn't be decompiled
    }

    public static void setUsername(String param0) {
        // $FF: Couldn't be decompiled
    }

    public static void updateLocation(Location var0) {
        if(!class_790.method_4077().field_3698) {
            method_4221("updateLocation");
        } else if(var0 == null) {
            class_764.method_4022("Cannot leave null location", new NullPointerException());
        } else {
            class_793.method_4111(var0);
        }
    }
}
