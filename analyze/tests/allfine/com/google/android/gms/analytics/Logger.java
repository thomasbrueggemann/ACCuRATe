package com.google.android.gms.analytics;

public interface Logger {
    void error(Exception var1);

    void error(String var1);

    int getLogLevel();

    void info(String var1);

    void setLogLevel(int var1);

    void verbose(String var1);

    void warn(String var1);

    public static class LogLevel {
        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;
    }
}
