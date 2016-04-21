package org.apache.cordova;

import android.util.Log;

public class LOG {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static int LOGLEVEL = 6;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    // $FF: renamed from: d (java.lang.String, java.lang.String) void
    public static void method_4279(String var0, String var1) {
        if(3 >= LOGLEVEL) {
            Log.d(var0, var1);
        }

    }

    // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Throwable) void
    public static void method_4280(String var0, String var1, Throwable var2) {
        if(3 >= LOGLEVEL) {
            Log.d(var0, var1, var2);
        }

    }

    // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Object[]) void
    public static void method_4281(String var0, String var1, Object... var2) {
        if(3 >= LOGLEVEL) {
            Log.d(var0, String.format(var1, var2));
        }

    }

    // $FF: renamed from: e (java.lang.String, java.lang.String) void
    public static void method_4282(String var0, String var1) {
        if(6 >= LOGLEVEL) {
            Log.e(var0, var1);
        }

    }

    // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Throwable) void
    public static void method_4283(String var0, String var1, Throwable var2) {
        if(6 >= LOGLEVEL) {
            Log.e(var0, var1, var2);
        }

    }

    // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Object[]) void
    public static void method_4284(String var0, String var1, Object... var2) {
        if(6 >= LOGLEVEL) {
            Log.e(var0, String.format(var1, var2));
        }

    }

    // $FF: renamed from: i (java.lang.String, java.lang.String) void
    public static void method_4285(String var0, String var1) {
        if(4 >= LOGLEVEL) {
            Log.i(var0, var1);
        }

    }

    // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Throwable) void
    public static void method_4286(String var0, String var1, Throwable var2) {
        if(4 >= LOGLEVEL) {
            Log.i(var0, var1, var2);
        }

    }

    // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Object[]) void
    public static void method_4287(String var0, String var1, Object... var2) {
        if(4 >= LOGLEVEL) {
            Log.i(var0, String.format(var1, var2));
        }

    }

    public static boolean isLoggable(int var0) {
        return var0 >= LOGLEVEL;
    }

    public static void setLogLevel(int var0) {
        LOGLEVEL = var0;
        Log.i("CordovaLog", "Changing log level to " + var0);
    }

    public static void setLogLevel(String var0) {
        if("VERBOSE".equals(var0)) {
            LOGLEVEL = 2;
        } else if("DEBUG".equals(var0)) {
            LOGLEVEL = 3;
        } else if("INFO".equals(var0)) {
            LOGLEVEL = 4;
        } else if("WARN".equals(var0)) {
            LOGLEVEL = 5;
        } else if("ERROR".equals(var0)) {
            LOGLEVEL = 6;
        }

        Log.i("CordovaLog", "Changing log level to " + var0 + "(" + LOGLEVEL + ")");
    }

    // $FF: renamed from: v (java.lang.String, java.lang.String) void
    public static void method_4288(String var0, String var1) {
        if(2 >= LOGLEVEL) {
            Log.v(var0, var1);
        }

    }

    // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Throwable) void
    public static void method_4289(String var0, String var1, Throwable var2) {
        if(2 >= LOGLEVEL) {
            Log.v(var0, var1, var2);
        }

    }

    // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Object[]) void
    public static void method_4290(String var0, String var1, Object... var2) {
        if(2 >= LOGLEVEL) {
            Log.v(var0, String.format(var1, var2));
        }

    }

    // $FF: renamed from: w (java.lang.String, java.lang.String) void
    public static void method_4291(String var0, String var1) {
        if(5 >= LOGLEVEL) {
            Log.w(var0, var1);
        }

    }

    // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Throwable) void
    public static void method_4292(String var0, String var1, Throwable var2) {
        if(5 >= LOGLEVEL) {
            Log.w(var0, var1, var2);
        }

    }

    // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Object[]) void
    public static void method_4293(String var0, String var1, Object... var2) {
        if(5 >= LOGLEVEL) {
            Log.w(var0, String.format(var1, var2));
        }

    }
}
