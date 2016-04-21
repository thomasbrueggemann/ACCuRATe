package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_675;
import crittercism.android.class_686;
import crittercism.android.class_687;
import crittercism.android.class_764;
import crittercism.android.class_773;
import crittercism.android.class_793;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// $FF: renamed from: crittercism.android.s
public final class class_677 extends HttpsURLConnection {
    // $FF: renamed from: a crittercism.android.e
    private class_661 field_3303 = null;
    // $FF: renamed from: b javax.net.ssl.HttpsURLConnection
    private HttpsURLConnection field_3304 = null;
    // $FF: renamed from: c crittercism.android.c
    private class_675 field_3305 = null;
    // $FF: renamed from: d crittercism.android.d
    private class_662 field_3306 = null;
    // $FF: renamed from: e boolean
    private boolean field_3307 = false;
    // $FF: renamed from: f boolean
    private boolean field_3308 = false;

    public class_677(HttpsURLConnection var1, class_661 var2, class_662 var3) {
        super(var1.getURL());
        this.field_3303 = var2;
        this.field_3304 = var1;
        this.field_3306 = var3;
        this.field_3305 = new class_675(var1.getURL());
        SSLSocketFactory var4 = this.field_3304.getSSLSocketFactory();
        if(var4 instanceof class_773) {
            class_773 var5 = (class_773)var4;
            this.field_3304.setSSLSocketFactory(var5.method_4057());
        }

    }

    // $FF: renamed from: a () void
    private void method_3761() {
        try {
            if(!this.field_3308) {
                this.field_3308 = true;
                this.field_3305.field_3266 = this.field_3304.getRequestMethod();
                this.field_3305.method_3740();
                this.field_3305.field_3270 = this.field_3306.method_3714();
                if(class_793.method_4112()) {
                    this.field_3305.method_3735(class_793.method_4110());
                }
            }

        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    private void method_3762(Throwable var1) {
        try {
            if(!this.field_3307) {
                this.field_3307 = true;
                this.field_3305.method_3743();
                this.field_3305.method_3738(var1);
                this.field_3303.method_3709(this.field_3305);
            }
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
        }
    }

    // $FF: renamed from: b () void
    private void method_3763() {
        // $FF: Couldn't be decompiled
    }

    public final void addRequestProperty(String var1, String var2) {
        this.field_3304.addRequestProperty(var1, var2);
    }

    public final void connect() {
        this.field_3304.connect();
    }

    public final void disconnect() {
        this.field_3304.disconnect();

        try {
            if(this.field_3307 && !this.field_3305.field_3262) {
                this.field_3303.method_3709(this.field_3305);
            }

        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    public final boolean equals(Object var1) {
        return this.field_3304.equals(var1);
    }

    public final boolean getAllowUserInteraction() {
        return this.field_3304.getAllowUserInteraction();
    }

    public final String getCipherSuite() {
        return this.field_3304.getCipherSuite();
    }

    public final int getConnectTimeout() {
        return this.field_3304.getConnectTimeout();
    }

    public final Object getContent() {
        this.method_3761();

        try {
            Object var2 = this.field_3304.getContent();
            this.method_3763();
            return var2;
        } catch (IOException var3) {
            this.method_3762(var3);
            throw var3;
        }
    }

    public final Object getContent(Class[] var1) {
        this.method_3761();

        try {
            Object var3 = this.field_3304.getContent(var1);
            this.method_3763();
            return var3;
        } catch (IOException var4) {
            this.method_3762(var4);
            throw var4;
        }
    }

    public final String getContentEncoding() {
        this.method_3761();
        String var1 = this.field_3304.getContentEncoding();
        this.method_3763();
        return var1;
    }

    public final int getContentLength() {
        return this.field_3304.getContentLength();
    }

    public final String getContentType() {
        this.method_3761();
        String var1 = this.field_3304.getContentType();
        this.method_3763();
        return var1;
    }

    public final long getDate() {
        return this.field_3304.getDate();
    }

    public final boolean getDefaultUseCaches() {
        return this.field_3304.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.field_3304.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.field_3304.getDoOutput();
    }

    public final InputStream getErrorStream() {
        this.method_3761();
        InputStream var1 = this.field_3304.getErrorStream();
        this.method_3763();
        if(var1 != null) {
            try {
                class_687 var2 = new class_687(var1, this.field_3303, this.field_3305);
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
        return this.field_3304.getExpiration();
    }

    public final String getHeaderField(int var1) {
        this.method_3761();
        String var2 = this.field_3304.getHeaderField(var1);
        this.method_3763();
        return var2;
    }

    public final String getHeaderField(String var1) {
        this.method_3761();
        String var2 = this.field_3304.getHeaderField(var1);
        this.method_3763();
        return var2;
    }

    public final long getHeaderFieldDate(String var1, long var2) {
        this.method_3761();
        long var4 = this.field_3304.getHeaderFieldDate(var1, var2);
        this.method_3763();
        return var4;
    }

    public final int getHeaderFieldInt(String var1, int var2) {
        this.method_3761();
        int var3 = this.field_3304.getHeaderFieldInt(var1, var2);
        this.method_3763();
        return var3;
    }

    public final String getHeaderFieldKey(int var1) {
        this.method_3761();
        String var2 = this.field_3304.getHeaderFieldKey(var1);
        this.method_3763();
        return var2;
    }

    public final Map getHeaderFields() {
        this.method_3761();
        Map var1 = this.field_3304.getHeaderFields();
        this.method_3763();
        return var1;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.field_3304.getHostnameVerifier();
    }

    public final long getIfModifiedSince() {
        return this.field_3304.getIfModifiedSince();
    }

    public final InputStream getInputStream() {
        this.method_3761();

        InputStream var2;
        try {
            var2 = this.field_3304.getInputStream();
            this.method_3763();
        } catch (IOException var6) {
            this.method_3762(var6);
            throw var6;
        }

        if(var2 != null) {
            try {
                class_687 var3 = new class_687(var2, this.field_3303, this.field_3305);
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
        return this.field_3304.getInstanceFollowRedirects();
    }

    public final long getLastModified() {
        return this.field_3304.getLastModified();
    }

    public final Certificate[] getLocalCertificates() {
        return this.field_3304.getLocalCertificates();
    }

    public final Principal getLocalPrincipal() {
        return this.field_3304.getLocalPrincipal();
    }

    public final OutputStream getOutputStream() {
        OutputStream var1 = this.field_3304.getOutputStream();
        if(var1 != null) {
            try {
                class_686 var2 = new class_686(var1, this.field_3305);
                return var2;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }
        }

        return var1;
    }

    public final Principal getPeerPrincipal() {
        return this.field_3304.getPeerPrincipal();
    }

    public final Permission getPermission() {
        return this.field_3304.getPermission();
    }

    public final int getReadTimeout() {
        return this.field_3304.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.field_3304.getRequestMethod();
    }

    public final Map getRequestProperties() {
        return this.field_3304.getRequestProperties();
    }

    public final String getRequestProperty(String var1) {
        return this.field_3304.getRequestProperty(var1);
    }

    public final int getResponseCode() {
        this.method_3761();

        try {
            int var2 = this.field_3304.getResponseCode();
            this.method_3763();
            return var2;
        } catch (IOException var3) {
            this.method_3762(var3);
            throw var3;
        }
    }

    public final String getResponseMessage() {
        this.method_3761();

        try {
            String var2 = this.field_3304.getResponseMessage();
            this.method_3763();
            return var2;
        } catch (IOException var3) {
            this.method_3762(var3);
            throw var3;
        }
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        return this.field_3304.getSSLSocketFactory();
    }

    public final Certificate[] getServerCertificates() {
        return this.field_3304.getServerCertificates();
    }

    public final URL getURL() {
        return this.field_3304.getURL();
    }

    public final boolean getUseCaches() {
        return this.field_3304.getUseCaches();
    }

    public final int hashCode() {
        return this.field_3304.hashCode();
    }

    public final void setAllowUserInteraction(boolean var1) {
        this.field_3304.setAllowUserInteraction(var1);
    }

    public final void setChunkedStreamingMode(int var1) {
        this.field_3304.setChunkedStreamingMode(var1);
    }

    public final void setConnectTimeout(int var1) {
        this.field_3304.setConnectTimeout(var1);
    }

    public final void setDefaultUseCaches(boolean var1) {
        this.field_3304.setDefaultUseCaches(var1);
    }

    public final void setDoInput(boolean var1) {
        this.field_3304.setDoInput(var1);
    }

    public final void setDoOutput(boolean var1) {
        this.field_3304.setDoOutput(var1);
    }

    public final void setFixedLengthStreamingMode(int var1) {
        this.field_3304.setFixedLengthStreamingMode(var1);
    }

    public final void setHostnameVerifier(HostnameVerifier var1) {
        this.field_3304.setHostnameVerifier(var1);
    }

    public final void setIfModifiedSince(long var1) {
        this.field_3304.setIfModifiedSince(var1);
    }

    public final void setInstanceFollowRedirects(boolean var1) {
        this.field_3304.setInstanceFollowRedirects(var1);
    }

    public final void setReadTimeout(int var1) {
        this.field_3304.setReadTimeout(var1);
    }

    public final void setRequestMethod(String var1) {
        this.field_3304.setRequestMethod(var1);
    }

    public final void setRequestProperty(String var1, String var2) {
        this.field_3304.setRequestProperty(var1, var2);
    }

    public final void setSSLSocketFactory(SSLSocketFactory var1) {
        label17: {
            SSLSocketFactory var4;
            try {
                if(!(var1 instanceof class_773)) {
                    break label17;
                }

                var4 = ((class_773)var1).method_4057();
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
                break label17;
            }

            var1 = var4;
        }

        this.field_3304.setSSLSocketFactory(var1);
    }

    public final void setUseCaches(boolean var1) {
        this.field_3304.setUseCaches(var1);
    }

    public final String toString() {
        return this.field_3304.toString();
    }

    public final boolean usingProxy() {
        return this.field_3304.usingProxy();
    }
}
