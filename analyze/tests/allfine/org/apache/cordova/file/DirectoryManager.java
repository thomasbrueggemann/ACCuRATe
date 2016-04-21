package org.apache.cordova.file;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class DirectoryManager {
    private static final String LOG_TAG = "DirectoryManager";

    private static File constructFilePaths(String var0, String var1) {
        return var1.startsWith(var0)?new File(var1):new File(var0 + "/" + var1);
    }

    private static long freeSpaceCalculation(String var0) {
        StatFs var1 = new StatFs(var0);
        return (long)var1.getBlockSize() * (long)var1.getAvailableBlocks() / 1024L;
    }

    public static long getFreeDiskSpace(boolean var0) {
        long var1;
        if(Environment.getExternalStorageState().equals("mounted")) {
            var1 = freeSpaceCalculation(Environment.getExternalStorageDirectory().getPath());
        } else {
            if(!var0) {
                return -1L;
            }

            var1 = freeSpaceCalculation("/");
        }

        return var1;
    }

    public static boolean testFileExists(String var0) {
        return testSaveLocationExists() && !var0.equals("")?constructFilePaths(Environment.getExternalStorageDirectory().toString(), var0).exists():false;
    }

    public static boolean testSaveLocationExists() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
