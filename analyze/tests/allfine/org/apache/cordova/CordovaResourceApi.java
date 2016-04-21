package org.apache.cordova;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Looper;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.squareup.okhttp.OkHttpClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import org.apache.cordova.PluginManager;
import org.apache.http.util.EncodingUtils;

public class CordovaResourceApi {
    private static final String[] LOCAL_FILE_PROJECTION = new String[] {"_data"};
    private static final String LOG_TAG = "CordovaResourceApi";
    public static final int URI_TYPE_ASSET = 1;
    public static final int URI_TYPE_CONTENT = 2;
    public static final int URI_TYPE_DATA = 4;
    public static final int URI_TYPE_FILE = 0;
    public static final int URI_TYPE_HTTP = 5;
    public static final int URI_TYPE_HTTPS = 6;
    public static final int URI_TYPE_RESOURCE = 3;
    public static final int URI_TYPE_UNKNOWN = -1;
    private static OkHttpClient httpClient = new OkHttpClient();
    static Thread jsThread;
    private final AssetManager assetManager;
    private final ContentResolver contentResolver;
    private final PluginManager pluginManager;
    private boolean threadCheckingEnabled = true;

    public CordovaResourceApi(Context var1, PluginManager var2) {
        this.contentResolver = var1.getContentResolver();
        this.assetManager = var1.getAssets();
        this.pluginManager = var2;
    }

    private void assertBackgroundThread() {
        if(this.threadCheckingEnabled) {
            Thread var1 = Thread.currentThread();
            if(var1 == Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("Do not perform IO operations on the UI thread. Use CordovaInterface.getThreadPool() instead.");
            }

            if(var1 == jsThread) {
                throw new IllegalStateException("Tried to perform an IO operation on the WebCore thread. Use CordovaInterface.getThreadPool() instead.");
            }
        }

    }

    private static void assertNonRelative(Uri var0) {
        if(!var0.isAbsolute()) {
            throw new IllegalArgumentException("Relative URIs are not supported.");
        }
    }

    private String getDataUriMimeType(Uri var1) {
        String var2 = var1.getSchemeSpecificPart();
        int var3 = var2.indexOf(44);
        if(var3 != -1) {
            String[] var4 = var2.substring(0, var3).split(";");
            if(var4.length > 0) {
                return var4[0];
            }
        }

        return null;
    }

    private String getMimeTypeFromPath(String var1) {
        String var2 = var1;
        int var3 = var1.lastIndexOf(46);
        if(var3 != -1) {
            var2 = var1.substring(var3 + 1);
        }

        String var4 = var2.toLowerCase(Locale.getDefault());
        return var4.equals("3ga")?"audio/3gpp":(var4.equals("js")?"text/javascript":MimeTypeMap.getSingleton().getMimeTypeFromExtension(var4));
    }

    public static int getUriType(Uri var0) {
        assertNonRelative(var0);
        String var1 = var0.getScheme();
        return "content".equals(var1)?2:("android.resource".equals(var1)?3:("file".equals(var1)?(var0.getPath().startsWith("/android_asset/")?1:0):("data".equals(var1)?4:("http".equals(var1)?5:("https".equals(var1)?6:-1)))));
    }

    private CordovaResourceApi.OpenForReadResult readDataUri(Uri var1) {
        String var2 = var1.getSchemeSpecificPart();
        int var3 = var2.indexOf(44);
        if(var3 == -1) {
            return null;
        } else {
            String[] var4 = var2.substring(0, var3).split(";");
            boolean var5 = false;
            int var6 = var4.length;
            String var7 = null;
            if(var6 > 0) {
                var7 = var4[0];
            }

            for(int var8 = 1; var8 < var4.length; ++var8) {
                if("base64".equalsIgnoreCase(var4[var8])) {
                    var5 = true;
                }
            }

            String var9 = var2.substring(var3 + 1);
            byte[] var10;
            if(var5) {
                var10 = Base64.decode(var9, 0);
            } else {
                var10 = EncodingUtils.getBytes(var9, "UTF-8");
            }

            return new CordovaResourceApi.OpenForReadResult(var1, new ByteArrayInputStream(var10), var7, (long)var10.length, (AssetFileDescriptor)null);
        }
    }

    public void copyResource(Uri var1, Uri var2) throws IOException {
        this.copyResource(this.openForRead(var1), this.openOutputStream(var2));
    }

    public void copyResource(Uri var1, OutputStream var2) throws IOException {
        this.copyResource(this.openForRead(var1), var2);
    }

    public void copyResource(CordovaResourceApi.OpenForReadResult param1, OutputStream param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public HttpURLConnection createHttpConnection(Uri var1) throws IOException {
        this.assertBackgroundThread();
        return httpClient.open(new URL(var1.toString()));
    }

    public String getMimeType(Uri var1) {
        switch(getUriType(var1)) {
            case 0:
            case 1:
                return this.getMimeTypeFromPath(var1.getPath());
            case 2:
            case 3:
                return this.contentResolver.getType(var1);
            case 4:
                return this.getDataUriMimeType(var1);
            case 5:
            case 6:
                try {
                    HttpURLConnection var3 = httpClient.open(new URL(var1.toString()));
                    var3.setDoInput(false);
                    var3.setRequestMethod("HEAD");
                    String var4 = var3.getHeaderField("Content-Type");
                    return var4;
                } catch (IOException var5) {
                    ;
                }
            default:
                return null;
        }
    }

    public boolean isThreadCheckingEnabled() {
        return this.threadCheckingEnabled;
    }

    public File mapUriToFile(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    public CordovaResourceApi.OpenForReadResult openForRead(Uri var1) throws IOException {
        return this.openForRead(var1, false);
    }

    public CordovaResourceApi.OpenForReadResult openForRead(Uri var1, boolean var2) throws IOException {
        if(!var2) {
            this.assertBackgroundThread();
        }

        switch(getUriType(var1)) {
            case 0:
                FileInputStream var17 = new FileInputStream(var1.getPath());
                return new CordovaResourceApi.OpenForReadResult(var1, var17, this.getMimeTypeFromPath(var1.getPath()), var17.getChannel().size(), (AssetFileDescriptor)null);
            case 1:
                String var9 = var1.getPath().substring(15);
                AssetFileDescriptor var10 = null;
                long var11 = -1L;

                Object var14;
                long var15;
                try {
                    var10 = this.assetManager.openFd(var9);
                    var14 = var10.createInputStream();
                    var15 = var10.getLength();
                } catch (FileNotFoundException var18) {
                    var14 = this.assetManager.open(var9);
                    return new CordovaResourceApi.OpenForReadResult(var1, (InputStream)var14, this.getMimeTypeFromPath(var9), var11, var10);
                }

                var11 = var15;
                return new CordovaResourceApi.OpenForReadResult(var1, (InputStream)var14, this.getMimeTypeFromPath(var9), var11, var10);
            case 2:
            case 3:
                String var7 = this.contentResolver.getType(var1);
                AssetFileDescriptor var8 = this.contentResolver.openAssetFileDescriptor(var1, "r");
                return new CordovaResourceApi.OpenForReadResult(var1, var8.createInputStream(), var7, var8.getLength(), var8);
            case 4:
                CordovaResourceApi.OpenForReadResult var6 = this.readDataUri(var1);
                if(var6 != null) {
                    return var6;
                }
            default:
                throw new FileNotFoundException("URI not supported by CordovaResourceApi: " + var1);
            case 5:
            case 6:
                HttpURLConnection var3 = httpClient.open(new URL(var1.toString()));
                var3.setDoInput(true);
                String var4 = var3.getHeaderField("Content-Type");
                int var5 = var3.getContentLength();
                return new CordovaResourceApi.OpenForReadResult(var1, var3.getInputStream(), var4, (long)var5, (AssetFileDescriptor)null);
        }
    }

    public OutputStream openOutputStream(Uri var1) throws IOException {
        return this.openOutputStream(var1, false);
    }

    public OutputStream openOutputStream(Uri var1, boolean var2) throws IOException {
        this.assertBackgroundThread();
        switch(getUriType(var1)) {
            case 0:
                File var5 = new File(var1.getPath());
                File var6 = var5.getParentFile();
                if(var6 != null) {
                    var6.mkdirs();
                }

                return new FileOutputStream(var5, var2);
            case 1:
            default:
                throw new FileNotFoundException("URI not supported by CordovaResourceApi: " + var1);
            case 2:
            case 3:
                ContentResolver var3 = this.contentResolver;
                String var4;
                if(var2) {
                    var4 = "wa";
                } else {
                    var4 = "w";
                }

                return var3.openAssetFileDescriptor(var1, var4).createOutputStream();
        }
    }

    public String remapPath(String var1) {
        return this.remapUri(Uri.fromFile(new File(var1))).getPath();
    }

    public Uri remapUri(Uri var1) {
        assertNonRelative(var1);
        Uri var2 = this.pluginManager.remapUri(var1);
        return var2 != null?var2:var1;
    }

    public void setThreadCheckingEnabled(boolean var1) {
        this.threadCheckingEnabled = var1;
    }

    public static final class OpenForReadResult {
        public final AssetFileDescriptor assetFd;
        public final InputStream inputStream;
        public final long length;
        public final String mimeType;
        public final Uri uri;

        OpenForReadResult(Uri var1, InputStream var2, String var3, long var4, AssetFileDescriptor var6) {
            this.uri = var1;
            this.inputStream = var2;
            this.mimeType = var3;
            this.length = var4;
            this.assetFd = var6;
        }
    }
}
