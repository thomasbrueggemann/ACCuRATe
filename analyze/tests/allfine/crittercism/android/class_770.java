package crittercism.android;

import crittercism.android.class_102;
import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_675;
import crittercism.android.class_684;
import crittercism.android.class_688;
import crittercism.android.class_694;
import crittercism.android.class_747;
import crittercism.android.class_764;
import crittercism.android.class_793;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

// $FF: renamed from: crittercism.android.ac
public final class class_770 extends SocketImpl implements class_102 {
    // $FF: renamed from: a java.lang.reflect.Field
    private static Field field_3626;
    // $FF: renamed from: b java.lang.reflect.Field
    private static Field field_3627;
    // $FF: renamed from: c java.lang.reflect.Field
    private static Field field_3628;
    // $FF: renamed from: d java.lang.reflect.Field
    private static Field field_3629;
    // $FF: renamed from: e java.lang.reflect.Method[]
    private static Method[] field_3630;
    // $FF: renamed from: f boolean
    private static boolean field_3631;
    // $FF: renamed from: g java.lang.Throwable
    private static Throwable field_3632;
    // $FF: renamed from: h java.util.Queue
    private final Queue field_3633 = new LinkedList();
    // $FF: renamed from: i crittercism.android.e
    private class_661 field_3634;
    // $FF: renamed from: j crittercism.android.d
    private class_662 field_3635;
    // $FF: renamed from: k java.net.SocketImpl
    private SocketImpl field_3636;
    // $FF: renamed from: l crittercism.android.w
    private class_684 field_3637;
    // $FF: renamed from: m crittercism.android.x
    private class_694 field_3638;

    static {
        // $FF: Couldn't be decompiled
    }

    public class_770(class_661 var1, class_662 var2, SocketImpl var3) {
        if(var1 == null) {
            throw new NullPointerException("dispatch was null");
        } else if(var3 == null) {
            throw new NullPointerException("delegate was null");
        } else {
            this.field_3634 = var1;
            this.field_3635 = var2;
            this.field_3636 = var3;
            this.method_4054();
        }
    }

    // $FF: renamed from: a (boolean) crittercism.android.c
    private class_675 method_4047(boolean var1) {
        class_675 var2 = new class_675();
        InetAddress var3 = this.getInetAddress();
        if(var3 != null) {
            var2.method_3739(var3);
        }

        int var4 = this.getPort();
        if(var4 > 0) {
            var2.method_3733(var4);
        }

        if(var1) {
            var2.method_3736(class_688.class_1196.field_4524);
        }

        if(this.field_3635 != null) {
            var2.field_3270 = this.field_3635.method_3714();
        }

        if(class_793.method_4112()) {
            var2.method_3735(class_793.method_4110());
        }

        return var2;
    }

    // $FF: renamed from: a (int, java.lang.Object[]) java.lang.Object
    private Object method_4048(int param1, Object... param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (int, java.lang.Object[]) java.lang.Object
    private Object method_4049(int var1, Object... var2) {
        try {
            Object var5 = this.method_4048(var1, var2);
            return var5;
        } catch (RuntimeException var6) {
            throw var6;
        } catch (Exception var7) {
            throw new class_747(var7);
        }
    }

    // $FF: renamed from: c (int, java.lang.Object[]) java.lang.Object
    private Object method_4050(int var1, Object... var2) {
        try {
            Object var6 = this.method_4048(var1, var2);
            return var6;
        } catch (IOException var7) {
            throw var7;
        } catch (RuntimeException var8) {
            throw var8;
        } catch (Exception var9) {
            throw new class_747(var9);
        }
    }

    // $FF: renamed from: c () boolean
    public static boolean method_4051() {
        return field_3631;
    }

    // $FF: renamed from: d () java.lang.Throwable
    public static Throwable method_4052() {
        return field_3632;
    }

    // $FF: renamed from: e () void
    public static void method_4053() {
        if(!field_3631) {
            throw new class_747(field_3632);
        } else {
            SocketImpl var0 = new SocketImpl() {
                protected final void accept(SocketImpl var1) {
                }

                protected final int available() {
                    return 0;
                }

                protected final void bind(InetAddress var1, int var2) {
                }

                protected final void close() {
                }

                protected final void connect(String var1, int var2) {
                }

                protected final void connect(InetAddress var1, int var2) {
                }

                protected final void connect(SocketAddress var1, int var2) {
                }

                protected final void create(boolean var1) {
                }

                protected final FileDescriptor getFileDescriptor() {
                    return null;
                }

                protected final InetAddress getInetAddress() {
                    return null;
                }

                protected final InputStream getInputStream() {
                    return null;
                }

                protected final int getLocalPort() {
                    return 0;
                }

                public final Object getOption(int var1) {
                    return null;
                }

                protected final OutputStream getOutputStream() {
                    return null;
                }

                protected final int getPort() {
                    return 0;
                }

                protected final void listen(int var1) {
                }

                protected final void sendUrgentData(int var1) {
                }

                public final void setOption(int var1, Object var2) {
                }

                protected final void setPerformancePreferences(int var1, int var2, int var3) {
                }

                protected final void shutdownInput() {
                }

                protected final void shutdownOutput() {
                }

                protected final boolean supportsUrgentData() {
                    return false;
                }

                public final String toString() {
                    return null;
                }
            };
            class_770 var1 = new class_770(new class_661(new Executor() {
                public final void execute(Runnable var1) {
                }
            }), (class_662)null, var0);
            Object var2 = new Object();

            try {
                var1.setOption(0, var2);
                var1.getOption(0);
                var1.sendUrgentData(0);
                var1.listen(0);
                var1.getOutputStream();
                var1.getInputStream();
                var1.create(false);
                var1.connect((SocketAddress)null, 0);
                var1.connect((InetAddress)null, 0);
                var1.connect((String)null, 0);
                var1.close();
                var1.bind((InetAddress)null, 0);
                var1.available();
                var1.accept(var1);
                var1.getFileDescriptor();
                var1.getInetAddress();
                var1.getLocalPort();
                var1.getPort();
                var1.setPerformancePreferences(0, 0, 0);
                var1.shutdownInput();
                var1.shutdownOutput();
                var1.supportsUrgentData();
            } catch (IOException var6) {
                ;
            } catch (class_747 var7) {
                throw var7;
            } catch (Throwable var8) {
                throw new class_747(var8);
            }
        }
    }

    // $FF: renamed from: f () void
    private void method_4054() {
        try {
            this.address = (InetAddress)field_3626.get(this.field_3636);
            this.fd = (FileDescriptor)field_3627.get(this.field_3636);
            this.localport = field_3628.getInt(this.field_3636);
            this.port = field_3629.getInt(this.field_3636);
        } catch (IllegalArgumentException var3) {
            throw new class_747(var3);
        } catch (IllegalAccessException var4) {
            throw new class_747(var4);
        }
    }

    // $FF: renamed from: a () crittercism.android.c
    public final class_675 method_399() {
        return this.method_4047(true);
    }

    // $FF: renamed from: a (crittercism.android.c) void
    public final void method_400(class_675 var1) {
        Queue var2 = this.field_3633;
        synchronized(var2) {
            this.field_3633.add(var1);
        }
    }

    public final void accept(SocketImpl var1) {
        this.method_4050(0, new Object[] {var1});
    }

    public final int available() {
        Integer var1 = (Integer)this.method_4050(1, new Object[0]);
        if(var1 == null) {
            throw new class_747("Received a null Integer");
        } else {
            return var1.intValue();
        }
    }

    // $FF: renamed from: b () crittercism.android.c
    public final class_675 method_401() {
        Queue var1 = this.field_3633;
        synchronized(var1) {
            class_675 var3 = (class_675)this.field_3633.poll();
            return var3;
        }
    }

    public final void bind(InetAddress var1, int var2) {
        Object[] var3 = new Object[] {var1, Integer.valueOf(var2)};
        this.method_4050(2, var3);
    }

    public final void close() {
        this.method_4050(3, new Object[0]);

        try {
            if(this.field_3638 != null) {
                this.field_3638.method_3822();
            }

        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
        }
    }

    public final void connect(String var1, int var2) {
        try {
            Object[] var7 = new Object[] {var1, Integer.valueOf(var2)};
            this.method_4050(6, var7);
        } catch (IOException var10) {
            IOException var3 = var10;
            if(var1 != null) {
                try {
                    class_675 var6 = this.method_4047(false);
                    var6.method_3740();
                    var6.method_3743();
                    var6.method_3748();
                    var6.method_3742(var1);
                    var6.method_3733(var2);
                    var6.method_3738(var3);
                    this.field_3634.method_3710(var6, class_675.class_1233.field_3858);
                } catch (ThreadDeath var8) {
                    throw var8;
                } catch (Throwable var9) {
                    class_764.method_4019(var9);
                }
            }

            throw var10;
        }
    }

    public final void connect(InetAddress var1, int var2) {
        try {
            Object[] var7 = new Object[] {var1, Integer.valueOf(var2)};
            this.method_4050(4, var7);
        } catch (IOException var10) {
            IOException var3 = var10;
            if(var1 != null) {
                try {
                    class_675 var6 = this.method_4047(false);
                    var6.method_3740();
                    var6.method_3743();
                    var6.method_3748();
                    var6.method_3739(var1);
                    var6.method_3733(var2);
                    var6.method_3738(var3);
                    this.field_3634.method_3710(var6, class_675.class_1233.field_3858);
                } catch (ThreadDeath var8) {
                    throw var8;
                } catch (Throwable var9) {
                    class_764.method_4019(var9);
                }
            }

            throw var10;
        }
    }

    public final void connect(SocketAddress var1, int var2) {
        try {
            Object[] var8 = new Object[] {var1, Integer.valueOf(var2)};
            this.method_4050(5, var8);
        } catch (IOException var11) {
            IOException var3 = var11;
            if(var1 != null) {
                try {
                    if(var1 instanceof InetSocketAddress) {
                        class_675 var6 = this.method_4047(false);
                        InetSocketAddress var7 = (InetSocketAddress)var1;
                        var6.method_3740();
                        var6.method_3743();
                        var6.method_3748();
                        var6.method_3739(var7.getAddress());
                        var6.method_3733(var7.getPort());
                        var6.method_3738(var3);
                        this.field_3634.method_3710(var6, class_675.class_1233.field_3858);
                    }
                } catch (ThreadDeath var9) {
                    throw var9;
                } catch (Throwable var10) {
                    class_764.method_4019(var10);
                }
            }

            throw var11;
        }
    }

    public final void create(boolean var1) {
        Object[] var2 = new Object[] {Boolean.valueOf(var1)};
        this.method_4050(7, var2);
    }

    public final FileDescriptor getFileDescriptor() {
        return (FileDescriptor)this.method_4049(8, new Object[0]);
    }

    public final InetAddress getInetAddress() {
        return (InetAddress)this.method_4049(9, new Object[0]);
    }

    public final InputStream getInputStream() {
        InputStream var1 = (InputStream)this.method_4050(10, new Object[0]);
        if(var1 != null) {
            try {
                if(this.field_3638 != null && this.field_3638.method_3821(var1)) {
                    return this.field_3638;
                }

                this.field_3638 = new class_694(this, var1, this.field_3634);
                class_694 var4 = this.field_3638;
                return var4;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }
        }

        return var1;
    }

    public final int getLocalPort() {
        return ((Integer)this.method_4049(11, new Object[0])).intValue();
    }

    public final Object getOption(int var1) {
        return this.field_3636.getOption(var1);
    }

    public final OutputStream getOutputStream() {
        OutputStream var1 = (OutputStream)this.method_4050(12, new Object[0]);
        if(var1 != null) {
            try {
                if(this.field_3637 != null && this.field_3637.method_3786(var1)) {
                    return this.field_3637;
                }

                this.field_3637 = new class_684(this, var1);
                class_684 var4 = this.field_3637;
                return var4;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
            }
        }

        return var1;
    }

    public final int getPort() {
        return ((Integer)this.method_4049(13, new Object[0])).intValue();
    }

    public final void listen(int var1) {
        Object[] var2 = new Object[] {Integer.valueOf(var1)};
        this.method_4050(14, var2);
    }

    public final void sendUrgentData(int var1) {
        Object[] var2 = new Object[] {Integer.valueOf(var1)};
        this.method_4050(15, var2);
    }

    public final void setOption(int var1, Object var2) {
        this.field_3636.setOption(var1, var2);
    }

    public final void setPerformancePreferences(int var1, int var2, int var3) {
        Object[] var4 = new Object[] {Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3)};
        this.method_4049(16, var4);
    }

    public final void shutdownInput() {
        this.method_4050(17, new Object[0]);
    }

    public final void shutdownOutput() {
        this.method_4050(18, new Object[0]);
    }

    public final boolean supportsUrgentData() {
        return ((Boolean)this.method_4049(19, new Object[0])).booleanValue();
    }

    public final String toString() {
        return this.field_3636.toString();
    }
}
