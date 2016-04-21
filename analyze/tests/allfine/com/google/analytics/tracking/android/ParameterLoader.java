package com.google.analytics.tracking.android;

interface ParameterLoader {
    boolean getBoolean(String var1);

    Double getDoubleFromString(String var1);

    int getInt(String var1, int var2);

    String getString(String var1);

    boolean isBooleanKeyPresent(String var1);

    void setResourcePackageName(String var1);
}
