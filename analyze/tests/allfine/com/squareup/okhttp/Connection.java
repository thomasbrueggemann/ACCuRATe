package com.squareup.okhttp;

import com.squareup.okhttp.Route;
import com.squareup.okhttp.TunnelRequest;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

public final class Connection implements Closeable {
    private static final byte[] HTTP_11 = new byte[] {(byte)104, (byte)116, (byte)116, (byte)112, (byte)47, (byte)49, (byte)46, (byte)49};
    private static final byte[] NPN_PROTOCOLS = new byte[] {(byte)6, (byte)115, (byte)112, (byte)100, (byte)121, (byte)47, (byte)51, (byte)8, (byte)104, (byte)116, (byte)116, (byte)112, (byte)47, (byte)49, (byte)46, (byte)49};
    private static final byte[] SPDY3 = new byte[] {(byte)115, (byte)112, (byte)100, (byte)121, (byte)47, (byte)51};
    private boolean connected = false;
    private int httpMinorVersion = 1;
    private long idleStartTimeNs;
    // $FF: renamed from: in java.io.InputStream
    private InputStream field_3444;
    private OutputStream out;
    private final Route route;
    private Socket socket;
    private SpdyConnection spdyConnection;

    public Connection(Route var1) {
        this.route = var1;
    }

    private void makeTunnel(TunnelRequest var1) throws IOException {
        RawHeaders var2 = var1.getRequestHeaders();

        while(true) {
            this.out.write(var2.toBytes());
            RawHeaders var3 = RawHeaders.fromBytes(this.field_3444);
            switch(var3.getResponseCode()) {
                case 200:
                    return;
                case 407:
                    RawHeaders var4 = new RawHeaders(var2);
                    URL var5 = new URL("https", var1.host, var1.port, "/");
                    if(!HttpAuthenticator.processAuthHeader(this.route.address.authenticator, 407, var3, var4, this.route.proxy, var5)) {
                        throw new IOException("Failed to authenticate with proxy");
                    }

                    var2 = var4;
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + var3.getResponseCode());
            }
        }
    }

    private void streamWrapper() throws IOException {
        this.field_3444 = new BufferedInputStream(this.field_3444, 4096);
        this.out = new BufferedOutputStream(this.out, 256);
    }

    private void upgradeToTls(TunnelRequest var1) throws IOException {
        Platform var2 = Platform.get();
        if(this.requiresTunnel()) {
            this.makeTunnel(var1);
        }

        this.socket = this.route.address.sslSocketFactory.createSocket(this.socket, this.route.address.uriHost, this.route.address.uriPort, true);
        SSLSocket var3 = (SSLSocket)this.socket;
        if(this.route.modernTls) {
            var2.enableTlsExtensions(var3, this.route.address.uriHost);
        } else {
            var2.supportTlsIntolerantServer(var3);
        }

        boolean var4;
        if(this.route.modernTls && this.route.address.transports.contains("spdy/3")) {
            var4 = true;
        } else {
            var4 = false;
        }

        if(var4) {
            var2.setNpnProtocols(var3, NPN_PROTOCOLS);
        }

        var3.startHandshake();
        if(!this.route.address.hostnameVerifier.verify(this.route.address.uriHost, var3.getSession())) {
            throw new IOException("Hostname \'" + this.route.address.uriHost + "\' was not verified");
        } else {
            this.out = var3.getOutputStream();
            this.field_3444 = var3.getInputStream();
            this.streamWrapper();
            if(var4) {
                byte[] var5 = var2.getNpnSelectedProtocol(var3);
                if(var5 != null) {
                    if(Arrays.equals(var5, SPDY3)) {
                        var3.setSoTimeout(0);
                        this.spdyConnection = (new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.field_3444, this.out)).build();
                        this.spdyConnection.sendConnectionHeader();
                    } else if(!Arrays.equals(var5, HTTP_11)) {
                        throw new IOException("Unexpected NPN transport " + new String(var5, "ISO-8859-1"));
                    }
                }
            }

        }
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public void connect(int var1, int var2, TunnelRequest var3) throws IOException {
        if(this.connected) {
            throw new IllegalStateException("already connected");
        } else {
            Socket var4;
            if(this.route.proxy.type() != Type.HTTP) {
                var4 = new Socket(this.route.proxy);
            } else {
                var4 = new Socket();
            }

            this.socket = var4;
            Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, var1);
            this.socket.setSoTimeout(var2);
            this.field_3444 = this.socket.getInputStream();
            this.out = this.socket.getOutputStream();
            if(this.route.address.sslSocketFactory != null) {
                this.upgradeToTls(var3);
            } else {
                this.streamWrapper();
            }

            this.connected = true;
        }
    }

    public int getHttpMinorVersion() {
        return this.httpMinorVersion;
    }

    public long getIdleStartTimeNs() {
        return this.spdyConnection == null?this.idleStartTimeNs:this.spdyConnection.getIdleStartTimeNs();
    }

    public Route getRoute() {
        return this.route;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public SpdyConnection getSpdyConnection() {
        return this.spdyConnection;
    }

    public boolean isAlive() {
        return !this.socket.isClosed() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean isExpired(long var1) {
        return this.getIdleStartTimeNs() < System.nanoTime() - var1;
    }

    public boolean isIdle() {
        return this.spdyConnection == null || this.spdyConnection.isIdle();
    }

    public boolean isReadable() {
        // $FF: Couldn't be decompiled
    }

    public boolean isSpdy() {
        return this.spdyConnection != null;
    }

    public Object newTransport(HttpEngine var1) throws IOException {
        return this.spdyConnection != null?new SpdyTransport(var1, this.spdyConnection):new HttpTransport(var1, this.out, this.field_3444);
    }

    public boolean requiresTunnel() {
        return this.route.address.sslSocketFactory != null && this.route.proxy.type() == Type.HTTP;
    }

    public void resetIdleStartTime() {
        if(this.spdyConnection != null) {
            throw new IllegalStateException("spdyConnection != null");
        } else {
            this.idleStartTimeNs = System.nanoTime();
        }
    }

    public void setHttpMinorVersion(int var1) {
        this.httpMinorVersion = var1;
    }

    public void updateReadTimeout(int var1) throws IOException {
        if(!this.connected) {
            throw new IllegalStateException("updateReadTimeout - not connected");
        } else {
            this.socket.setSoTimeout(var1);
        }
    }
}
