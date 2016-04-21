package crittercism.android;

import crittercism.android.class_102;
import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_675;
import crittercism.android.class_684;
import crittercism.android.class_688;
import crittercism.android.class_694;
import crittercism.android.class_764;
import crittercism.android.class_793;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.Queue;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

// $FF: renamed from: crittercism.android.aa
public final class class_772 extends SSLSocket implements class_102 {
    // $FF: renamed from: a javax.net.ssl.SSLSocket
    private SSLSocket field_3643;
    // $FF: renamed from: b crittercism.android.e
    private class_661 field_3644;
    // $FF: renamed from: c crittercism.android.d
    private class_662 field_3645;
    // $FF: renamed from: d java.util.Queue
    private final Queue field_3646 = new LinkedList();
    // $FF: renamed from: e crittercism.android.w
    private class_684 field_3647;
    // $FF: renamed from: f crittercism.android.x
    private class_694 field_3648;

    public class_772(SSLSocket var1, class_661 var2, class_662 var3) {
        if(var1 == null) {
            throw new NullPointerException("delegate was null");
        } else if(var2 == null) {
            throw new NullPointerException("dispatch was null");
        } else {
            this.field_3643 = var1;
            this.field_3644 = var2;
            this.field_3645 = var3;
        }
    }

    // $FF: renamed from: a (boolean) crittercism.android.c
    private class_675 method_4055(boolean var1) {
        class_675 var2 = new class_675();
        InetAddress var3 = this.field_3643.getInetAddress();
        if(var3 != null) {
            var2.method_3739(var3);
        }

        if(var1) {
            var2.method_3733(this.getPort());
        }

        var2.method_3736(class_688.class_1196.field_4525);
        if(this.field_3645 != null) {
            var2.field_3270 = this.field_3645.method_3714();
        }

        if(class_793.method_4112()) {
            var2.method_3735(class_793.method_4110());
        }

        return var2;
    }

    // $FF: renamed from: a () crittercism.android.c
    public final class_675 method_399() {
        return this.method_4055(false);
    }

    // $FF: renamed from: a (crittercism.android.c) void
    public final void method_400(class_675 var1) {
        if(var1 != null) {
            Queue var2 = this.field_3646;
            synchronized(var2) {
                this.field_3646.add(var1);
            }
        }

    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener var1) {
        this.field_3643.addHandshakeCompletedListener(var1);
    }

    // $FF: renamed from: b () crittercism.android.c
    public final class_675 method_401() {
        Queue var1 = this.field_3646;
        synchronized(var1) {
            class_675 var3 = (class_675)this.field_3646.poll();
            return var3;
        }
    }

    public final void bind(SocketAddress var1) {
        this.field_3643.bind(var1);
    }

    public final void close() {
        this.field_3643.close();

        try {
            if(this.field_3648 != null) {
                this.field_3648.method_3822();
            }

        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }
    }

    public final void connect(SocketAddress var1) {
        this.field_3643.connect(var1);
    }

    public final void connect(SocketAddress var1, int var2) {
        this.field_3643.connect(var1, var2);
    }

    public final boolean equals(Object var1) {
        return this.field_3643.equals(var1);
    }

    public final SocketChannel getChannel() {
        return this.field_3643.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.field_3643.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.field_3643.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.field_3643.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.field_3643.getInetAddress();
    }

    public final InputStream getInputStream() {
        InputStream var1 = this.field_3643.getInputStream();
        if(var1 != null) {
            try {
                if(this.field_3648 != null && this.field_3648.method_3821(var1)) {
                    return this.field_3648;
                }

                this.field_3648 = new class_694(this, var1, this.field_3644);
                class_694 var4 = this.field_3648;
                return var4;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }
        }

        return var1;
    }

    public final boolean getKeepAlive() {
        return this.field_3643.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.field_3643.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.field_3643.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.field_3643.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.field_3643.getNeedClientAuth();
    }

    public final boolean getOOBInline() {
        return this.field_3643.getOOBInline();
    }

    public final OutputStream getOutputStream() {
        OutputStream var1 = this.field_3643.getOutputStream();
        if(var1 != null) {
            try {
                if(this.field_3647 != null && this.field_3647.method_3786(var1)) {
                    return this.field_3647;
                }

                class_684 var10000 = this.field_3647;
                this.field_3647 = new class_684(this, var1);
                class_684 var5 = this.field_3647;
                return var5;
            } catch (ThreadDeath var6) {
                throw var6;
            } catch (Throwable var7) {
                class_764.method_4019(var7);
            }
        }

        return var1;
    }

    public final int getPort() {
        return this.field_3643.getPort();
    }

    public final int getReceiveBufferSize() {
        return this.field_3643.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.field_3643.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() {
        return this.field_3643.getReuseAddress();
    }

    public final int getSendBufferSize() {
        return this.field_3643.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.field_3643.getSession();
    }

    public final int getSoLinger() {
        return this.field_3643.getSoLinger();
    }

    public final int getSoTimeout() {
        return this.field_3643.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.field_3643.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.field_3643.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() {
        return this.field_3643.getTcpNoDelay();
    }

    public final int getTrafficClass() {
        return this.field_3643.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.field_3643.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.field_3643.getWantClientAuth();
    }

    public final int hashCode() {
        return this.field_3643.hashCode();
    }

    public final boolean isBound() {
        return this.field_3643.isBound();
    }

    public final boolean isClosed() {
        return this.field_3643.isClosed();
    }

    public final boolean isConnected() {
        return this.field_3643.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.field_3643.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.field_3643.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener var1) {
        this.field_3643.removeHandshakeCompletedListener(var1);
    }

    public final void sendUrgentData(int var1) {
        this.field_3643.sendUrgentData(var1);
    }

    public final void setEnableSessionCreation(boolean var1) {
        this.field_3643.setEnableSessionCreation(var1);
    }

    public final void setEnabledCipherSuites(String[] var1) {
        this.field_3643.setEnabledCipherSuites(var1);
    }

    public final void setEnabledProtocols(String[] var1) {
        this.field_3643.setEnabledProtocols(var1);
    }

    public final void setKeepAlive(boolean var1) {
        this.field_3643.setKeepAlive(var1);
    }

    public final void setNeedClientAuth(boolean var1) {
        this.field_3643.setNeedClientAuth(var1);
    }

    public final void setOOBInline(boolean var1) {
        this.field_3643.setOOBInline(var1);
    }

    public final void setPerformancePreferences(int var1, int var2, int var3) {
        this.field_3643.setPerformancePreferences(var1, var2, var3);
    }

    public final void setReceiveBufferSize(int var1) {
        this.field_3643.setReceiveBufferSize(var1);
    }

    public final void setReuseAddress(boolean var1) {
        this.field_3643.setReuseAddress(var1);
    }

    public final void setSendBufferSize(int var1) {
        this.field_3643.setSendBufferSize(var1);
    }

    public final void setSoLinger(boolean var1, int var2) {
        this.field_3643.setSoLinger(var1, var2);
    }

    public final void setSoTimeout(int var1) {
        this.field_3643.setSoTimeout(var1);
    }

    public final void setTcpNoDelay(boolean var1) {
        this.field_3643.setTcpNoDelay(var1);
    }

    public final void setTrafficClass(int var1) {
        this.field_3643.setTrafficClass(var1);
    }

    public final void setUseClientMode(boolean var1) {
        this.field_3643.setUseClientMode(var1);
    }

    public final void setWantClientAuth(boolean var1) {
        this.field_3643.setWantClientAuth(var1);
    }

    public final void shutdownInput() {
        this.field_3643.shutdownInput();
    }

    public final void shutdownOutput() {
        this.field_3643.shutdownOutput();
    }

    public final void startHandshake() {
        try {
            this.field_3643.startHandshake();
        } catch (IOException var7) {
            IOException var1 = var7;

            try {
                class_675 var4 = this.method_4055(true);
                var4.method_3740();
                var4.method_3743();
                var4.method_3748();
                var4.method_3738(var1);
                this.field_3644.method_3710(var4, class_675.class_1233.field_3859);
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }

            throw var7;
        }
    }

    public final String toString() {
        return this.field_3643.toString();
    }
}
