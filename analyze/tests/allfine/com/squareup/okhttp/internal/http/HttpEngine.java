package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.ResponseSource;
import com.squareup.okhttp.TunnelRequest;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.Policy;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.RequestHeaders;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import com.squareup.okhttp.internal.http.RouteSelector;
import com.squareup.okhttp.internal.http.Transport;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.Proxy.Type;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class HttpEngine {
    private static final CacheResponse GATEWAY_TIMEOUT_RESPONSE = new CacheResponse() {
        public InputStream getBody() throws IOException {
            return new ByteArrayInputStream(Util.EMPTY_BYTE_ARRAY);
        }

        public Map<String, List<String>> getHeaders() throws IOException {
            HashMap var1 = new HashMap();
            var1.put((Object)null, Collections.singletonList("HTTP/1.1 504 Gateway Timeout"));
            return var1;
        }
    };
    public static final int HTTP_CONTINUE = 100;
    private boolean automaticallyReleaseConnectionToPool;
    private CacheRequest cacheRequest;
    private CacheResponse cacheResponse;
    private InputStream cachedResponseBody;
    private ResponseHeaders cachedResponseHeaders;
    protected final OkHttpClient client;
    boolean connected;
    protected Connection connection;
    private boolean connectionReleased;
    protected final String method;
    protected final Policy policy;
    private OutputStream requestBodyOut;
    final RequestHeaders requestHeaders;
    private InputStream responseBodyIn;
    ResponseHeaders responseHeaders;
    private ResponseSource responseSource;
    private InputStream responseTransferIn;
    protected RouteSelector routeSelector;
    long sentRequestMillis = -1L;
    private boolean transparentGzip;
    private Transport transport;
    final URI uri;

    public HttpEngine(OkHttpClient var1, Policy var2, String var3, RawHeaders var4, Connection var5, RetryableOutputStream var6) throws IOException {
        this.client = var1;
        this.policy = var2;
        this.method = var3;
        this.connection = var5;
        this.requestBodyOut = var6;

        try {
            this.uri = Platform.get().toUriLenient(var2.getURL());
        } catch (URISyntaxException var8) {
            throw new IOException(var8.getMessage());
        }

        this.requestHeaders = new RequestHeaders(this.uri, new RawHeaders(var4));
    }

    public static String getDefaultUserAgent() {
        String var0 = System.getProperty("http.agent");
        return var0 != null?var0:"Java" + System.getProperty("java.version");
    }

    public static String getOriginAddress(URL var0) {
        int var1 = var0.getPort();
        String var2 = var0.getHost();
        if(var1 > 0 && var1 != Util.getDefaultPort(var0.getProtocol())) {
            var2 = var2 + ":" + var1;
        }

        return var2;
    }

    private void initContentStream(InputStream var1) throws IOException {
        this.responseTransferIn = var1;
        if(this.transparentGzip && this.responseHeaders.isContentEncodingGzip()) {
            this.responseHeaders.stripContentEncoding();
            this.responseHeaders.stripContentLength();
            this.responseBodyIn = new GZIPInputStream(var1);
        } else {
            this.responseBodyIn = var1;
        }
    }

    private void initResponseSource() throws IOException {
        this.responseSource = ResponseSource.NETWORK;
        if(this.policy.getUseCaches()) {
            OkResponseCache var1 = this.client.getOkResponseCache();
            if(var1 != null) {
                CacheResponse var2 = var1.get(this.uri, this.method, this.requestHeaders.getHeaders().toMultimap(false));
                if(var2 != null) {
                    Map var3 = var2.getHeaders();
                    this.cachedResponseBody = var2.getBody();
                    if(this.acceptCacheResponseType(var2) && var3 != null && this.cachedResponseBody != null) {
                        RawHeaders var4 = RawHeaders.fromMultimap(var3, true);
                        this.cachedResponseHeaders = new ResponseHeaders(this.uri, var4);
                        long var5 = System.currentTimeMillis();
                        this.responseSource = this.cachedResponseHeaders.chooseResponseSource(var5, this.requestHeaders);
                        if(this.responseSource == ResponseSource.CACHE) {
                            this.cacheResponse = var2;
                            this.setResponse(this.cachedResponseHeaders, this.cachedResponseBody);
                            return;
                        }

                        if(this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                            this.cacheResponse = var2;
                            return;
                        }

                        if(this.responseSource == ResponseSource.NETWORK) {
                            Util.closeQuietly((Closeable)this.cachedResponseBody);
                            return;
                        }

                        throw new AssertionError();
                    }

                    Util.closeQuietly((Closeable)this.cachedResponseBody);
                    return;
                }
            }
        }

    }

    private void maybeCache() throws IOException {
        if(this.policy.getUseCaches()) {
            OkResponseCache var1 = this.client.getOkResponseCache();
            if(var1 != null) {
                HttpURLConnection var2 = this.policy.getHttpConnectionToCache();
                if(!this.responseHeaders.isCacheable(this.requestHeaders)) {
                    var1.maybeRemove(var2.getRequestMethod(), this.uri);
                    return;
                }

                this.cacheRequest = var1.put(this.uri, var2);
                return;
            }
        }

    }

    private void prepareRawRequestHeaders() throws IOException {
        this.requestHeaders.getHeaders().setRequestLine(this.getRequestLine());
        if(this.requestHeaders.getUserAgent() == null) {
            this.requestHeaders.setUserAgent(getDefaultUserAgent());
        }

        if(this.requestHeaders.getHost() == null) {
            this.requestHeaders.setHost(getOriginAddress(this.policy.getURL()));
        }

        if((this.connection == null || this.connection.getHttpMinorVersion() != 0) && this.requestHeaders.getConnection() == null) {
            this.requestHeaders.setConnection("Keep-Alive");
        }

        if(this.requestHeaders.getAcceptEncoding() == null) {
            this.transparentGzip = true;
            this.requestHeaders.setAcceptEncoding("gzip");
        }

        if(this.hasRequestBody() && this.requestHeaders.getContentType() == null) {
            this.requestHeaders.setContentType("application/x-www-form-urlencoded");
        }

        long var1 = this.policy.getIfModifiedSince();
        if(var1 != 0L) {
            this.requestHeaders.setIfModifiedSince(new Date(var1));
        }

        CookieHandler var3 = this.client.getCookieHandler();
        if(var3 != null) {
            this.requestHeaders.addCookies(var3.get(this.uri, this.requestHeaders.getHeaders().toMultimap(false)));
        }

    }

    public static String requestPath(URL var0) {
        String var1 = var0.getFile();
        if(var1 == null) {
            var1 = "/";
        } else if(!var1.startsWith("/")) {
            return "/" + var1;
        }

        return var1;
    }

    private String requestString() {
        URL var1 = this.policy.getURL();
        return this.includeAuthorityInRequestLine()?var1.toString():requestPath(var1);
    }

    private void sendSocketRequest() throws IOException {
        if(this.connection == null) {
            this.connect();
        }

        if(this.transport != null) {
            throw new IllegalStateException();
        } else {
            this.transport = (Transport)this.connection.newTransport(this);
            if(this.hasRequestBody() && this.requestBodyOut == null) {
                this.requestBodyOut = this.transport.createRequestBody();
            }

        }
    }

    private void setResponse(ResponseHeaders var1, InputStream var2) throws IOException {
        if(this.responseBodyIn != null) {
            throw new IllegalStateException();
        } else {
            this.responseHeaders = var1;
            if(var2 != null) {
                this.initContentStream(var2);
            }

        }
    }

    protected boolean acceptCacheResponseType(CacheResponse var1) {
        return true;
    }

    public final void automaticallyReleaseConnectionToPool() {
        this.automaticallyReleaseConnectionToPool = true;
        if(this.connection != null && this.connectionReleased) {
            this.client.getConnectionPool().recycle(this.connection);
            this.connection = null;
        }

    }

    protected final void connect() throws IOException {
        if(this.connection == null) {
            if(this.routeSelector == null) {
                String var1 = this.uri.getHost();
                if(var1 == null) {
                    throw new UnknownHostException(this.uri.toString());
                }

                boolean var2 = this.uri.getScheme().equalsIgnoreCase("https");
                SSLSocketFactory var3 = null;
                HostnameVerifier var4 = null;
                if(var2) {
                    var3 = this.client.getSslSocketFactory();
                    var4 = this.client.getHostnameVerifier();
                }

                this.routeSelector = new RouteSelector(new Address(var1, Util.getEffectivePort(this.uri), var3, var4, this.client.getAuthenticator(), this.client.getProxy(), this.client.getTransports()), this.uri, this.client.getProxySelector(), this.client.getConnectionPool(), Dns.DEFAULT, this.client.getRoutesDatabase());
            }

            this.connection = this.routeSelector.next(this.method);
            if(!this.connection.isConnected()) {
                this.connection.connect(this.client.getConnectTimeout(), this.client.getReadTimeout(), this.getTunnelConfig());
                this.client.getConnectionPool().maybeShare(this.connection);
                this.client.getRoutesDatabase().connected(this.connection.getRoute());
            } else if(!this.connection.isSpdy()) {
                this.connection.updateReadTimeout(this.client.getReadTimeout());
            }

            this.connected(this.connection);
            if(this.connection.getRoute().getProxy() != this.client.getProxy()) {
                this.requestHeaders.getHeaders().setRequestLine(this.getRequestLine());
                return;
            }
        }

    }

    protected void connected(Connection var1) {
        this.policy.setSelectedProxy(var1.getRoute().getProxy());
        this.connected = true;
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }

    public final Connection getConnection() {
        return this.connection;
    }

    public final OutputStream getRequestBody() {
        if(this.responseSource == null) {
            throw new IllegalStateException();
        } else {
            return this.requestBodyOut;
        }
    }

    public final RequestHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    String getRequestLine() {
        String var1;
        if(this.connection != null && this.connection.getHttpMinorVersion() == 0) {
            var1 = "HTTP/1.0";
        } else {
            var1 = "HTTP/1.1";
        }

        return this.method + " " + this.requestString() + " " + var1;
    }

    public final InputStream getResponseBody() {
        if(this.responseHeaders == null) {
            throw new IllegalStateException();
        } else {
            return this.responseBodyIn;
        }
    }

    public final int getResponseCode() {
        if(this.responseHeaders == null) {
            throw new IllegalStateException();
        } else {
            return this.responseHeaders.getHeaders().getResponseCode();
        }
    }

    public final ResponseHeaders getResponseHeaders() {
        if(this.responseHeaders == null) {
            throw new IllegalStateException();
        } else {
            return this.responseHeaders;
        }
    }

    protected TunnelRequest getTunnelConfig() {
        return null;
    }

    public URI getUri() {
        return this.uri;
    }

    boolean hasRequestBody() {
        return this.method.equals("POST") || this.method.equals("PUT") || this.method.equals("PATCH");
    }

    public final boolean hasResponse() {
        return this.responseHeaders != null;
    }

    public final boolean hasResponseBody() {
        int var1 = this.responseHeaders.getHeaders().getResponseCode();
        if(!this.method.equals("HEAD")) {
            if((var1 < 100 || var1 >= 200) && var1 != 204 && var1 != 304) {
                return true;
            }

            if(this.responseHeaders.getContentLength() != -1L || this.responseHeaders.isChunked()) {
                return true;
            }
        }

        return false;
    }

    protected boolean includeAuthorityInRequestLine() {
        return this.connection == null?this.policy.usingProxy():this.connection.getRoute().getProxy().type() == Type.HTTP;
    }

    public final void readResponse() throws IOException {
        if(this.hasResponse()) {
            this.responseHeaders.setResponseSource(this.responseSource);
        } else {
            if(this.responseSource == null) {
                throw new IllegalStateException("readResponse() without sendRequest()");
            }

            if(this.responseSource.requiresConnection()) {
                if(this.sentRequestMillis == -1L) {
                    if(this.requestBodyOut instanceof RetryableOutputStream) {
                        int var2 = ((RetryableOutputStream)this.requestBodyOut).contentLength();
                        this.requestHeaders.setContentLength((long)var2);
                    }

                    this.transport.writeRequestHeaders();
                }

                if(this.requestBodyOut != null) {
                    this.requestBodyOut.close();
                    if(this.requestBodyOut instanceof RetryableOutputStream) {
                        this.transport.writeRequestBody((RetryableOutputStream)this.requestBodyOut);
                    }
                }

                this.transport.flushRequest();
                this.responseHeaders = this.transport.readResponseHeaders();
                this.responseHeaders.setLocalTimestamps(this.sentRequestMillis, System.currentTimeMillis());
                this.responseHeaders.setResponseSource(this.responseSource);
                if(this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                    if(this.cachedResponseHeaders.validate(this.responseHeaders)) {
                        this.release(false);
                        this.responseHeaders = this.cachedResponseHeaders.combine(this.responseHeaders);
                        OkResponseCache var1 = this.client.getOkResponseCache();
                        var1.trackConditionalCacheHit();
                        var1.update(this.cacheResponse, this.policy.getHttpConnectionToCache());
                        this.initContentStream(this.cachedResponseBody);
                        return;
                    }

                    Util.closeQuietly((Closeable)this.cachedResponseBody);
                }

                if(this.hasResponseBody()) {
                    this.maybeCache();
                }

                this.initContentStream(this.transport.getTransferStream(this.cacheRequest));
                return;
            }
        }

    }

    public void receiveHeaders(RawHeaders var1) throws IOException {
        CookieHandler var2 = this.client.getCookieHandler();
        if(var2 != null) {
            var2.put(this.uri, var1.toMultimap(true));
        }

    }

    public final void release(boolean var1) {
        if(this.responseBodyIn == this.cachedResponseBody) {
            Util.closeQuietly((Closeable)this.responseBodyIn);
        }

        if(!this.connectionReleased && this.connection != null) {
            this.connectionReleased = true;
            if(this.transport != null && this.transport.makeReusable(var1, this.requestBodyOut, this.responseTransferIn)) {
                if(this.automaticallyReleaseConnectionToPool) {
                    this.client.getConnectionPool().recycle(this.connection);
                    this.connection = null;
                    return;
                }
            } else {
                Util.closeQuietly((Closeable)this.connection);
                this.connection = null;
            }
        }

    }

    public final void sendRequest() throws IOException {
        if(this.responseSource == null) {
            this.prepareRawRequestHeaders();
            this.initResponseSource();
            OkResponseCache var1 = this.client.getOkResponseCache();
            if(var1 != null) {
                var1.trackResponse(this.responseSource);
            }

            if(this.requestHeaders.isOnlyIfCached() && this.responseSource.requiresConnection()) {
                if(this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                    Util.closeQuietly((Closeable)this.cachedResponseBody);
                }

                this.responseSource = ResponseSource.CACHE;
                this.cacheResponse = GATEWAY_TIMEOUT_RESPONSE;
                RawHeaders var2 = RawHeaders.fromMultimap(this.cacheResponse.getHeaders(), true);
                this.setResponse(new ResponseHeaders(this.uri, var2), this.cacheResponse.getBody());
            }

            if(this.responseSource.requiresConnection()) {
                this.sendSocketRequest();
                return;
            }

            if(this.connection != null) {
                this.client.getConnectionPool().recycle(this.connection);
                this.connection = null;
                return;
            }
        }

    }

    public void writingRequestHeaders() {
        if(this.sentRequestMillis != -1L) {
            throw new IllegalStateException();
        } else {
            this.sentRequestMillis = System.currentTimeMillis();
        }
    }
}
