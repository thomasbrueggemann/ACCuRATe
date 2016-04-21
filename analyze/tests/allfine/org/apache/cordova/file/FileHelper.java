package org.apache.cordova.file;

import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.LOG;

public class FileHelper {
    private static final String LOG_TAG = "FileUtils";
    private static final String _DATA = "_data";

    public static InputStream getInputStreamFromUriString(String var0, CordovaInterface var1) throws IOException {
        if(var0.startsWith("content")) {
            Uri var4 = Uri.parse(var0);
            return var1.getActivity().getContentResolver().openInputStream(var4);
        } else if(var0.startsWith("file://")) {
            int var2 = var0.indexOf("?");
            if(var2 > -1) {
                var0 = var0.substring(0, var2);
            }

            if(var0.startsWith("file:///android_asset/")) {
                String var3 = Uri.parse(var0).getPath().substring(15);
                return var1.getActivity().getAssets().open(var3);
            } else {
                return new FileInputStream(getRealPath(var0, var1));
            }
        } else {
            return new FileInputStream(getRealPath(var0, var1));
        }
    }

    public static String getMimeType(String var0, CordovaInterface var1) {
        Uri var2 = Uri.parse(var0);
        return var0.startsWith("content://")?var1.getActivity().getContentResolver().getType(var2):getMimeTypeForExtension(var2.getPath());
    }

    public static String getMimeTypeForExtension(String var0) {
        String var1 = var0;
        int var2 = var0.lastIndexOf(46);
        if(var2 != -1) {
            var1 = var0.substring(var2 + 1);
        }

        String var3 = var1.toLowerCase(Locale.getDefault());
        return var3.equals("3ga")?"audio/3gpp":MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3);
    }

    public static String getRealPath(Uri var0, CordovaInterface var1) {
        return getRealPath(var0.toString(), var1);
    }

    public static String getRealPath(String var0, CordovaInterface var1) {
        String var6;
        if(var0.startsWith("content://")) {
            String[] var2 = new String[] {"_data"};
            Cursor var3 = var1.getActivity().managedQuery(Uri.parse(var0), var2, (String)null, (String[])null, (String)null);
            int var4 = var3.getColumnIndexOrThrow("_data");
            var3.moveToFirst();
            var6 = var3.getString(var4);
            if(var6 == null) {
                LOG.method_4284("FileUtils", "Could get real path for URI string %s", new Object[] {var0});
            }
        } else {
            if(!var0.startsWith("file://")) {
                return var0;
            }

            var6 = var0.substring(7);
            if(var6.startsWith("/android_asset/")) {
                LOG.method_4284("FileUtils", "Cannot get real path for URI string %s because it is a file:///android_asset/ URI.", new Object[] {var0});
                return null;
            }
        }

        return var6;
    }

    public static String stripFileProtocol(String var0) {
        if(var0.startsWith("file://")) {
            var0 = var0.substring(7);
        }

        return var0;
    }
}
