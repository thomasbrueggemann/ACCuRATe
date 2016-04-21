package com.crittercism.app;

import android.content.Context;
import crittercism.android.class_764;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CrittercismNDK {
    private static final String LEGACY_SO_FILE_NAME = "libcrittercism-ndk.so";
    private static final String LIBRARY_NAME = "crittercism-v3";
    private static final String SO_FILE_NAME = "libcrittercism-v3.so";
    private static boolean isNdkInstalled = false;

    public static boolean copyLibFromAssets(Context param0, File param1) {
        // $FF: Couldn't be decompiled
    }

    public static boolean doNdkSharedLibrariesExist(Context var0) {
        try {
            getJarredLibFileStream(var0);
            return true;
        } catch (IOException var2) {
            return false;
        }
    }

    public static File getInstalledLibraryFile(Context var0) {
        String var1 = var0.getFilesDir().getAbsolutePath() + "/com.crittercism/lib/";
        return new File(var1 + "libcrittercism-v3.so");
    }

    public static InputStream getJarredLibFileStream(Context var0) {
        String var1 = "armeabi";
        if(System.getProperty("os.arch").contains("v7")) {
            var1 = var1 + "-v7a";
        }

        return var0.getAssets().open(var1 + "/libcrittercism-v3.so");
    }

    public static native boolean installNdk(String var0);

    public static void installNdkLib(Context var0, String var1) {
        boolean var2 = true;
        String var3 = var0.getFilesDir().getAbsolutePath() + "/" + var1;
        if(doNdkSharedLibrariesExist(var0)) {
            var2 = loadLibraryFromAssets(var0);
        } else {
            try {
                System.loadLibrary("crittercism-v3");
            } catch (Throwable var7) {
                var2 = false;
            }
        }

        if(var2) {
            try {
                if(installNdk(var3)) {
                    (new File(var3)).mkdirs();
                    isNdkInstalled = true;
                } else {
                    class_764.method_4024("Unable to initialize NDK crash reporting.");
                }
            } catch (Throwable var6) {
                ;
            }
        }
    }

    public static boolean isNdkCrashReportingInstalled() {
        return isNdkInstalled;
    }

    public static boolean loadLibraryFromAssets(Context var0) {
        File var1 = new File(var0.getFilesDir(), "/com.crittercism/lib/");
        File var2 = new File(var1, "libcrittercism-v3.so");
        File var3 = new File(var1, "libcrittercism-ndk.so");
        if(!var2.exists()) {
            if(!copyLibFromAssets(var0, var2)) {
                var2.delete();
                return false;
            }

            var3.delete();
        }

        try {
            System.load(var2.getAbsolutePath());
            return true;
        } catch (Throwable var5) {
            class_764.method_4018("Unable to install NDK library", var5);
            var2.delete();
            return false;
        }
    }
}
