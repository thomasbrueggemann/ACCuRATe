package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_675;
import crittercism.android.class_686;
import crittercism.android.class_687;
import crittercism.android.class_764;
import crittercism.android.class_793;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.Map;

// $FF: renamed from: crittercism.android.r
public final class class_678 extends HttpURLConnection {
    // $FF: renamed from: a crittercism.android.e
    private class_661 field_3316;
    // $FF: renamed from: b java.net.HttpURLConnection
    private HttpURLConnection field_3317;
    // $FF: renamed from: c crittercism.android.c
    private class_675 field_3318;
    // $FF: renamed from: d crittercism.android.d
    private class_662 field_3319;
    // $FF: renamed from: e boolean
    private boolean field_3320 = false;
    // $FF: renamed from: f boolean
    private boolean field_3321 = false;

    public class_678(HttpURLConnection var1, class_661 var2, class_662 var3) {
        super(var1.getURL());
        this.field_3317 = var1;
        this.field_3316 = var2;
        this.field_3319 = var3;
        this.field_3318 = new class_675(var1.getURL());
    }

    // $FF: renamed from: a () void
    private void method_3775() {
        try {
            if(!this.field_3321) {
                this.field_3321 = true;
                this.field_3318.field_3266 = this.field_3317.getRequestMethod();
                this.field_3318.method_3740();
                this.field_3318.field_3270 = this.field_3319.method_3714();
                if(class_793.method_4112()) {
                    this.field_3318.method_3735(class_793.method_4110());
                }
            }

        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    private void method_3776(Throwable var1) {
        try {
            if(!this.field_3320) {
                this.field_3320 = true;
                this.field_3318.method_3743();
                this.field_3318.method_3738(var1);
                this.field_3316.method_3709(this.field_3318);
            }
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var1);
        }
    }

    // $FF: renamed from: b () void
    private void method_3777() {
        // $FF: Couldn't be decompiled
    }

    public final void addRequestProperty(String var1, String var2) {
        this.field_3317.addRequestProperty(var1, var2);
    }

    public final void connect() {
        this.field_3317.connect();
    }

    public final void disconnect() {
        this.field_3317.disconnect();

        try {
            if(this.field_3320 && !this.field_3318.field_3262) {
                this.field_3316.method_3709(this.field_3318);
            }

        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    public final boolean equals(Object var1) {
        return this.field_3317.equals(var1);
    }

    public final boolean getAllowUserInteraction() {
        return this.field_3317.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.field_3317.getConnectTimeout();
    }

    public final Object getContent() {
        this.method_3775();

        try {
            Object var2 = this.field_3317.getContent();
            this.method_3777();
            return var2;
        } catch (IOException var3) {
            this.method_3776(var3);
            throw var3;
        }
    }

    public final Object getContent(Class[] var1) {
        this.method_3775();

        try {
            Object var3 = this.field_3317.getContent(var1);
            this.method_3777();
            return var3;
        } catch (IOException var4) {
            this.method_3776(var4);
            throw var4;
        }
    }

    public final String getContentEncoding() {
        this.method_3775();
        String var1 = this.field_3317.getContentEncoding();
        this.method_3777();
        return var1;
    }

    public final int getContentLength() {
        return this.field_3317.getContentLength();
    }

    public final String getContentType() {
        this.method_3775();
        String var1 = this.field_3317.getContentType();
        this.method_3777();
        return var1;
    }

    public final long getDate() {
        return this.field_3317.getDate();
    }

    public final boolean getDefaultUseCaches() {
        return this.field_3317.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.field_3317.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.field_3317.getDoOutput();
    }

    public final InputStream getErrorStream() {
        this.method_3775();
        InputStream var1 = this.field_3317.getErrorStream();
        this.method_3777();
        if(var1 != null) {
            try {
                class_687 var2 = new class_687(var1, this.field_3316, this.field_3318);
                return var2;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }
        }

        return var1;
    }

    public final long getExpiration() {
        return this.field_3317.getExpiration();
    }

    public final String getHeaderField(int var1) {
        this.method_3775();
        String var2 = this.field_3317.getHeaderField(var1);
        this.method_3777();
        return var2;
    }

    public final String getHeaderField(String var1) {
        this.method_3775();
        String var2 = this.field_3317.getHeaderField(var1);
        this.method_3777();
        return var2;
    }

    public final long getHeaderFieldDate(String var1, long var2) {
        this.method_3775();
        long var4 = this.field_3317.getHeaderFieldDate(var1, var2);
        this.method_3777();
        return var4;
    }

    public final int getHeaderFieldInt(String var1, int var2) {
        this.method_3775();
        int var3 = this.field_3317.getHeaderFieldInt(var1, var2);
        this.method_3777();
        return var3;
    }

    public final String getHeaderFieldKey(int var1) {
        this.method_3775();
        String var2 = this.field_3317.getHeaderFieldKey(var1);
        this.method_3777();
        return var2;
    }

    public final Map getHeaderFields() {
        this.method_3775();
        Map var1 = this.field_3317.getHeaderFields();
        this.method_3777();
        return var1;
    }

    public final long getIfModifiedSince() {
        return this.field_3317.getIfModifiedSince();
    }

    public final InputStream getInputStream() {
        this.method_3775();

        InputStream var2;
        try {
            var2 = this.field_3317.getInputStream();
            this.method_3777();
        } catch (IOException var6) {
            this.method_3776(var6);
            throw var6;
        }

        if(var2 != null) {
            try {
                class_687 var3 = new class_687(var2, this.field_3316, this.field_3318);
                return var3;
            } catch (ThreadDeath var7) {
                throw var7;
            } catch (Throwable var8) {
                class_764.method_4019(var8);
            }
        }

        return var2;
    }

    public final boolean getInstanceFollowRedirects() {
        return this.field_3317.getInstanceFollowRedirects();
    }

    public final long getLastModified() {
        return this.field_3317.getLastModified();
    }

    public final OutputStream getOutputStream() {
        OutputStream var1 = this.field_3317.getOutputStream();
        if(var1 != null) {
            try {
                class_686 var2 = new class_686(var1, this.field_3318);
                return var2;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }
        }

        return var1;
    }

    public final Permission getPermission() {
        return this.field_3317.getPermission();
    }

    public final int getReadTimeout() {
        return this.field_3317.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.field_3317.getRequestMethod();
    }

    public final Map getRequestProperties() {
        return this.field_3317.getRequestProperties();
    }

    public final String getRequestProperty(String var1) {
        return this.field_3317.getRequestProperty(var1);
    }

    public final int getResponseCode() {
        this.method_3775();

        try {
            int var2 = this.field_3317.getResponseCode();
            this.method_3777();
            return var2;
        } catch (IOException var3) {
            this.method_3776(var3);
            throw var3;
        }
    }

    public final String getResponseMessage() {
        this.method_3775();

        try {
            String var2 = this.field_3317.getResponseMessage();
            this.method_3777();
            return var2;
        } catch (IOException var3) {
            this.method_3776(var3);
            throw var3;
        }
    }

    public final URL getURL() {
        return this.field_3317.getURL();
    }

    public final boolean getUseCaches() {
        return this.field_3317.getUseCaches();
    }

    public final int hashCode() {
        return this.field_3317.hashCode();
    }

    public final void setAllowUserInteraction(boolean var1) {
        this.field_3317.setAllowUserInteraction(var1);
    }

    public final void setChunkedStreamingMode(int var1) {
        this.field_3317.setChunkedStreamingMode(var1);
    }

    public final void setConnectTimeout(int var1) {
        this.field_3317.setConnectTimeout(var1);
    }

    public final void setDefaultUseCaches(boolean var1) {
        this.field_3317.setDefaultUseCaches(var1);
    }

    public final void setDoInput(boolean var1) {
        this.field_3317.setDoInput(var1);
    }

    public final void setDoOutput(boolean var1) {
        this.field_3317.setDoOutput(var1);
    }

    public final void setFixedLengthStreamingMode(int var1) {
        this.field_3317.setFixedLengthStreamingMode(var1);
    }

    public final void setIfModifiedSince(long var1) {
        this.field_3317.setIfModifiedSince(var1);
    }

    public final void setInstanceFollowRedirects(boolean var1) {
        this.field_3317.setInstanceFollowRedirects(var1);
    }

    public final void setReadTimeout(int var1) {
        this.field_3317.setReadTimeout(var1);
    }

    public final void setRequestMethod(String var1) {
        this.field_3317.setRequestMethod(var1);
    }

    public final void setRequestProperty(String var1, String var2) {
        this.field_3317.setRequestProperty(var1, var2);
    }

    public final void setUseCaches(boolean var1) {
        this.field_3317.setUseCaches(var1);
    }

    public final String toString() {
        return this.field_3317.toString();
    }

    public final boolean usingProxy() {
        return this.field_3317.usingProxy();
    }
}
