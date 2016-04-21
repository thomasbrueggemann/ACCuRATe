package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.net.ssl.SSLSocket;

public class Platform {
    private static final Platform PLATFORM = findPlatform();
    private Constructor<DeflaterOutputStream> deflaterConstructor;

    private static Platform findPlatform() {
        // $FF: Couldn't be decompiled
    }

    public static Platform get() {
        return PLATFORM;
    }

    public void connectSocket(Socket var1, InetSocketAddress var2, int var3) throws IOException {
        var1.connect(var2, var3);
    }

    public void enableTlsExtensions(SSLSocket var1, String var2) {
    }

    public byte[] getNpnSelectedProtocol(SSLSocket var1) {
        return null;
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public void logW(String var1) {
        System.out.println(var1);
    }

    public OutputStream newDeflaterOutputStream(OutputStream param1, Deflater param2, boolean param3) {
        // $FF: Couldn't be decompiled
    }

    public void setNpnProtocols(SSLSocket var1, byte[] var2) {
    }

    public void supportTlsIntolerantServer(SSLSocket var1) {
        var1.setEnabledProtocols(new String[] {"SSLv3"});
    }

    public void tagSocket(Socket var1) throws SocketException {
    }

    public URI toUriLenient(URL var1) throws URISyntaxException {
        return var1.toURI();
    }

    public void untagSocket(Socket var1) throws SocketException {
    }

    private static class Android23 extends Platform {
        protected final Class<?> openSslSocketClass;
        private final Method setHostname;
        private final Method setUseSessionTickets;

        private Android23(Class<?> var1, Method var2, Method var3) {
            this.openSslSocketClass = var1;
            this.setUseSessionTickets = var2;
            this.setHostname = var3;
        }

        // $FF: synthetic method
        Android23(Class var1, Method var2, Method var3, Object var4) {
            this(var1, var2, var3);
        }

        public void connectSocket(Socket var1, InetSocketAddress var2, int var3) throws IOException {
            try {
                var1.connect(var2, var3);
            } catch (SecurityException var6) {
                IOException var5 = new IOException("Exception in connect");
                var5.initCause(var6);
                throw var5;
            }
        }

        public void enableTlsExtensions(SSLSocket var1, String var2) {
            super.enableTlsExtensions(var1, var2);
            if(this.openSslSocketClass.isInstance(var1)) {
                try {
                    Method var5 = this.setUseSessionTickets;
                    Object[] var6 = new Object[] {Boolean.valueOf(true)};
                    var5.invoke(var1, var6);
                    this.setHostname.invoke(var1, new Object[] {var2});
                } catch (InvocationTargetException var7) {
                    throw new RuntimeException(var7);
                } catch (IllegalAccessException var8) {
                    throw new AssertionError(var8);
                }
            }

        }
    }

    private static class Android41 extends Platform.Android23 {
        private final Method getNpnSelectedProtocol;
        private final Method setNpnProtocols;

        private Android41(Class<?> var1, Method var2, Method var3, Method var4, Method var5) {
            super(var1, var2, var3, null);
            this.setNpnProtocols = var4;
            this.getNpnSelectedProtocol = var5;
        }

        // $FF: synthetic method
        Android41(Class var1, Method var2, Method var3, Method var4, Method var5, Object var6) {
            this(var1, var2, var3, var4, var5);
        }

        public byte[] getNpnSelectedProtocol(SSLSocket var1) {
            if(!this.openSslSocketClass.isInstance(var1)) {
                return null;
            } else {
                try {
                    byte[] var4 = (byte[])((byte[])this.getNpnSelectedProtocol.invoke(var1, new Object[0]));
                    return var4;
                } catch (InvocationTargetException var5) {
                    throw new RuntimeException(var5);
                } catch (IllegalAccessException var6) {
                    throw new AssertionError(var6);
                }
            }
        }

        public void setNpnProtocols(SSLSocket var1, byte[] var2) {
            if(this.openSslSocketClass.isInstance(var1)) {
                try {
                    this.setNpnProtocols.invoke(var1, new Object[] {var2});
                } catch (IllegalAccessException var5) {
                    throw new AssertionError(var5);
                } catch (InvocationTargetException var6) {
                    throw new RuntimeException(var6);
                }
            }
        }
    }

    private static class JdkWithJettyNpnPlatform extends Platform {
        private final Class<?> clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Class<?> serverProviderClass;

        public JdkWithJettyNpnPlatform(Method var1, Method var2, Class<?> var3, Class<?> var4) {
            this.putMethod = var1;
            this.getMethod = var2;
            this.clientProviderClass = var3;
            this.serverProviderClass = var4;
        }

        public byte[] getNpnSelectedProtocol(SSLSocket var1) {
            try {
                Platform.JettyNpnProvider var5 = (Platform.JettyNpnProvider)Proxy.getInvocationHandler(this.getMethod.invoke((Object)null, new Object[] {var1}));
                if(!var5.unsupported && var5.selected == null) {
                    Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
                    return null;
                } else if(!var5.unsupported) {
                    byte[] var6 = var5.selected.getBytes("US-ASCII");
                    return var6;
                } else {
                    return null;
                }
            } catch (UnsupportedEncodingException var7) {
                throw new AssertionError();
            } catch (InvocationTargetException var8) {
                throw new AssertionError();
            } catch (IllegalAccessException var9) {
                throw new AssertionError();
            }
        }

        public void setNpnProtocols(SSLSocket param1, byte[] param2) {
            // $FF: Couldn't be decompiled
        }
    }

    private static class JettyNpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public JettyNpnProvider(List<String> var1) {
            this.protocols = var1;
        }

        public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {
            String var4 = var2.getName();
            Class var5 = var2.getReturnType();
            if(var3 == null) {
                var3 = Util.EMPTY_STRING_ARRAY;
            }

            if(var4.equals("supports") && Boolean.TYPE == var5) {
                return Boolean.valueOf(true);
            } else if(var4.equals("unsupported") && Void.TYPE == var5) {
                this.unsupported = true;
                return null;
            } else if(var4.equals("protocols") && ((Object[])var3).length == 0) {
                return this.protocols;
            } else if(!var4.equals("selectProtocol") || String.class != var5 || ((Object[])var3).length != 1 || ((Object[])var3)[0] != null && !(((Object[])var3)[0] instanceof List)) {
                if(var4.equals("protocolSelected") && ((Object[])var3).length == 1) {
                    this.selected = (String)((Object[])var3)[0];
                    return null;
                } else {
                    return var2.invoke(this, (Object[])var3);
                }
            } else {
                List var10000 = (List)((Object[])var3)[0];
                this.selected = (String)this.protocols.get(0);
                return this.selected;
            }
        }
    }
}
