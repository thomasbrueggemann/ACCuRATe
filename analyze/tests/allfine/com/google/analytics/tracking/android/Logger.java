package com.google.analytics.tracking.android;

public interface Logger {
    void error(Exception var1);

    void error(String var1);

    Logger.LogLevel getLogLevel();

    void info(String var1);

    void setLogLevel(Logger.LogLevel var1);

    void verbose(String var1);

    void warn(String var1);

    public static enum LogLevel {
        ERROR,
        INFO,
        VERBOSE,
        WARNING;

        static {
            Logger.LogLevel[] var0 = new Logger.LogLevel[]{VERBOSE, INFO, WARNING, ERROR};
        }
    }
}
