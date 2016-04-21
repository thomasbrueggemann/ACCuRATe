package com.squareup.okhttp.internal.http;

import android.annotation.SuppressLint;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpsEngine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SecureCacheResponse;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class HttpsURLConnectionImpl extends HttpsURLConnection {
    private final HttpsURLConnectionImpl.HttpUrlConnectionDelegate delegate;

    public HttpsURLConnectionImpl(URL var1, OkHttpClient var2) {
        super(var1);
        this.delegate = new HttpsURLConnectionImpl.HttpUrlConnectionDelegate(var1, var2);
    }

    private SSLSocket getSslSocket() {
        if(this.delegate.httpEngine != null && this.delegate.httpEngine.connected) {
            return this.delegate.httpEngine instanceof HttpsEngine?((HttpsEngine)this.delegate.httpEngine).getSslSocket():null;
        } else {
            throw new IllegalStateException("Connection has not yet been established");
        }
    }

    public void addRequestProperty(String var1, String var2) {
        this.delegate.addRequestProperty(var1, var2);
    }

    public void connect() throws IOException {
        this.connected = true;
        this.delegate.connect();
    }

    public void disconnect() {
        this.delegate.disconnect();
    }

    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    public String getCipherSuite() {
        SecureCacheResponse var1 = this.delegate.getSecureCacheResponse();
        if(var1 != null) {
            return var1.getCipherSuite();
        } else {
            SSLSocket var2 = this.getSslSocket();
            return var2 != null?var2.getSession().getCipherSuite():null;
        }
    }

    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        return this.delegate.getContent();
    }

    public Object getContent(Class[] var1) throws IOException {
        return this.delegate.getContent(var1);
    }

    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    public String getContentType() {
        return this.delegate.getContentType();
    }

    public long getDate() {
        return this.delegate.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    public String getHeaderField(int var1) {
        return this.delegate.getHeaderField(var1);
    }

    public String getHeaderField(String var1) {
        return this.delegate.getHeaderField(var1);
    }

    public long getHeaderFieldDate(String var1, long var2) {
        return this.delegate.getHeaderFieldDate(var1, var2);
    }

    public int getHeaderFieldInt(String var1, int var2) {
        return this.delegate.getHeaderFieldInt(var1, var2);
    }

    public String getHeaderFieldKey(int var1) {
        return this.delegate.getHeaderFieldKey(var1);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.delegate.client.getHostnameVerifier();
    }

    public HttpEngine getHttpEngine() {
        return this.delegate.getHttpEngine();
    }

    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    public Certificate[] getLocalCertificates() {
        SecureCacheResponse var1 = this.delegate.getSecureCacheResponse();
        Certificate[] var3;
        if(var1 != null) {
            List var4 = var1.getLocalCertificateChain();
            var3 = null;
            if(var4 != null) {
                var3 = (Certificate[])var4.toArray(new Certificate[var4.size()]);
            }
        } else {
            SSLSocket var2 = this.getSslSocket();
            var3 = null;
            if(var2 != null) {
                return var2.getSession().getLocalCertificates();
            }
        }

        return var3;
    }

    public Principal getLocalPrincipal() {
        SecureCacheResponse var1 = this.delegate.getSecureCacheResponse();
        if(var1 != null) {
            return var1.getLocalPrincipal();
        } else {
            SSLSocket var2 = this.getSslSocket();
            return var2 != null?var2.getSession().getLocalPrincipal():null;
        }
    }

    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        SecureCacheResponse var1 = this.delegate.getSecureCacheResponse();
        if(var1 != null) {
            return var1.getPeerPrincipal();
        } else {
            SSLSocket var2 = this.getSslSocket();
            return var2 != null?var2.getSession().getPeerPrincipal():null;
        }
    }

    public Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }

    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    public String getRequestProperty(String var1) {
        return this.delegate.getRequestProperty(var1);
    }

    public int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.delegate.client.getSslSocketFactory();
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        SecureCacheResponse var1 = this.delegate.getSecureCacheResponse();
        Certificate[] var3;
        if(var1 != null) {
            List var4 = var1.getServerCertificateChain();
            var3 = null;
            if(var4 != null) {
                var3 = (Certificate[])var4.toArray(new Certificate[var4.size()]);
            }
        } else {
            SSLSocket var2 = this.getSslSocket();
            var3 = null;
            if(var2 != null) {
                return var2.getSession().getPeerCertificates();
            }
        }

        return var3;
    }

    public URL getURL() {
        return this.delegate.getURL();
    }

    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    public void setAllowUserInteraction(boolean var1) {
        this.delegate.setAllowUserInteraction(var1);
    }

    public void setChunkedStreamingMode(int var1) {
        this.delegate.setChunkedStreamingMode(var1);
    }

    public void setConnectTimeout(int var1) {
        this.delegate.setConnectTimeout(var1);
    }

    public void setDefaultUseCaches(boolean var1) {
        this.delegate.setDefaultUseCaches(var1);
    }

    public void setDoInput(boolean var1) {
        this.delegate.setDoInput(var1);
    }

    public void setDoOutput(boolean var1) {
        this.delegate.setDoOutput(var1);
    }

    public void setFixedLengthStreamingMode(int var1) {
        this.delegate.setFixedLengthStreamingMode(var1);
    }

    @SuppressLint({"NewApi"})
    public void setFixedLengthStreamingMode(long var1) {
        this.delegate.setFixedLengthStreamingMode(var1);
    }

    public void setHostnameVerifier(HostnameVerifier var1) {
        this.delegate.client.setHostnameVerifier(var1);
    }

    public void setIfModifiedSince(long var1) {
        this.delegate.setIfModifiedSince(var1);
    }

    public void setInstanceFollowRedirects(boolean var1) {
        this.delegate.setInstanceFollowRedirects(var1);
    }

    public void setReadTimeout(int var1) {
        this.delegate.setReadTimeout(var1);
    }

    public void setRequestMethod(String var1) throws ProtocolException {
        this.delegate.setRequestMethod(var1);
    }

    public void setRequestProperty(String var1, String var2) {
        this.delegate.setRequestProperty(var1, var2);
    }

    public void setSSLSocketFactory(SSLSocketFactory var1) {
        this.delegate.client.setSslSocketFactory(var1);
    }

    public void setUseCaches(boolean var1) {
        this.delegate.setUseCaches(var1);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }

    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        private HttpUrlConnectionDelegate(URL var2, OkHttpClient var3) {
            super(var2, var3);
        }

        // $FF: synthetic method
        HttpUrlConnectionDelegate(URL var2, OkHttpClient var3, Object var4) {
            this();
        }

        public HttpURLConnection getHttpConnectionToCache() {
            return HttpsURLConnectionImpl.this;
        }

        public SecureCacheResponse getSecureCacheResponse() {
            return this.httpEngine instanceof HttpsEngine?(SecureCacheResponse)this.httpEngine.getCacheResponse():null;
        }
    }
}
