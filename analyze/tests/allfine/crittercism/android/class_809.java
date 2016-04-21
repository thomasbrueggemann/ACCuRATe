package crittercism.android;

import java.io.File;

// $FF: renamed from: crittercism.android.eb
public final class class_809 {
    // $FF: renamed from: a (java.io.File) void
    public static void method_4197(File var0) {
        if(var0.getAbsolutePath().contains("com.crittercism")) {
            if(var0.isDirectory()) {
                File[] var2 = var0.listFiles();
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    method_4197(var2[var4]);
                }
            }

            var0.delete();
        }
    }

    // $FF: renamed from: b (java.io.File) java.lang.String
    public static String method_4198(File param0) {
        // $FF: Couldn't be decompiled
    }
}
