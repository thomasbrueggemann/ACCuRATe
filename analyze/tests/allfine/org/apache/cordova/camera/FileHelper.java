package org.apache.cordova.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.MimeTypeMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.cordova.CordovaInterface;

public class FileHelper {
    private static final String LOG_TAG = "FileUtils";
    private static final String _DATA = "_data";

    public static InputStream getInputStreamFromUriString(String var0, CordovaInterface var1) throws IOException {
        InputStream var4;
        if(var0.startsWith("content")) {
            Uri var7 = Uri.parse(var0);
            var4 = var1.getActivity().getContentResolver().openInputStream(var7);
        } else {
            if(!var0.startsWith("file://")) {
                return new FileInputStream(var0);
            }

            int var2 = var0.indexOf("?");
            if(var2 > -1) {
                var0 = var0.substring(0, var2);
            }

            if(var0.startsWith("file:///android_asset/")) {
                String var6 = Uri.parse(var0).getPath().substring(15);
                return var1.getActivity().getAssets().open(var6);
            }

            label24: {
                InputStream var5;
                try {
                    var5 = var1.getActivity().getContentResolver().openInputStream(Uri.parse(var0));
                } catch (Exception var8) {
                    var4 = null;
                    break label24;
                }

                var4 = var5;
            }

            if(var4 == null) {
                return new FileInputStream(getRealPath(var0, var1));
            }
        }

        return var4;
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
        return VERSION.SDK_INT < 11?getRealPathFromURI_BelowAPI11(var1.getActivity(), var0):(VERSION.SDK_INT < 19?getRealPathFromURI_API11to18(var1.getActivity(), var0):getRealPathFromURI_API19(var1.getActivity(), var0));
    }

    public static String getRealPath(String var0, CordovaInterface var1) {
        return getRealPath(Uri.parse(var0), var1);
    }

    @SuppressLint({"NewApi"})
    public static String getRealPathFromURI_API11to18(Context param0, Uri param1) {
        // $FF: Couldn't be decompiled
    }

    @SuppressLint({"NewApi"})
    public static String getRealPathFromURI_API19(Context param0, Uri param1) {
        // $FF: Couldn't be decompiled
    }

    public static String getRealPathFromURI_BelowAPI11(Context var0, Uri var1) {
        String[] var2 = new String[] {"_data"};

        try {
            Cursor var4 = var0.getContentResolver().query(var1, var2, (String)null, (String[])null, (String)null);
            int var5 = var4.getColumnIndexOrThrow("_data");
            var4.moveToFirst();
            String var7 = var4.getString(var5);
            return var7;
        } catch (Exception var8) {
            return null;
        }
    }

    public static String stripFileProtocol(String var0) {
        if(var0.startsWith("file://")) {
            var0 = var0.substring(7);
        }

        return var0;
    }
}
