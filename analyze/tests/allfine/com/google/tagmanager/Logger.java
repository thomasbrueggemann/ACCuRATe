package com.google.tagmanager;

public interface Logger {
    // $FF: renamed from: d (java.lang.String) void
    void method_67(String var1);

    // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
    void method_68(String var1, Throwable var2);

    // $FF: renamed from: e (java.lang.String) void
    void method_69(String var1);

    // $FF: renamed from: e (java.lang.String, java.lang.Throwable) void
    void method_70(String var1, Throwable var2);

    Logger.LogLevel getLogLevel();

    // $FF: renamed from: i (java.lang.String) void
    void method_71(String var1);

    // $FF: renamed from: i (java.lang.String, java.lang.Throwable) void
    void method_72(String var1, Throwable var2);

    void setLogLevel(Logger.LogLevel var1);

    // $FF: renamed from: v (java.lang.String) void
    void method_73(String var1);

    // $FF: renamed from: v (java.lang.String, java.lang.Throwable) void
    void method_74(String var1, Throwable var2);

    // $FF: renamed from: w (java.lang.String) void
    void method_75(String var1);

    // $FF: renamed from: w (java.lang.String, java.lang.Throwable) void
    void method_76(String var1, Throwable var2);

    public static enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        NONE,
        VERBOSE,
        WARNING;

        static {
            Logger.LogLevel[] var0 = new Logger.LogLevel[]{VERBOSE, DEBUG, INFO, WARNING, ERROR, NONE};
        }
    }
}
