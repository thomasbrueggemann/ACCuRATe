package com.google.android.gms.games.internal.constants;

public final class PlatformType {
    // $FF: renamed from: dH (int) java.lang.String
    public static String method_5978(int var0) {
        switch(var0) {
            case 0:
                return "ANDROID";
            case 1:
                return "IOS";
            case 2:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + var0);
        }
    }
}
