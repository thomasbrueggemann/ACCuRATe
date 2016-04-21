package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_689;
import crittercism.android.class_747;
import crittercism.android.class_764;
import crittercism.android.class_773;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

// $FF: renamed from: crittercism.android.z
public final class class_693 extends SSLContextSpi {
    // $FF: renamed from: a java.lang.reflect.Method[]
    private static Method[] field_3379 = new Method[7];
    // $FF: renamed from: b boolean
    private static boolean field_3380 = false;
    // $FF: renamed from: c javax.net.ssl.SSLContextSpi
    private SSLContextSpi field_3381;
    // $FF: renamed from: d crittercism.android.e
    private class_661 field_3382;
    // $FF: renamed from: e crittercism.android.d
    private class_662 field_3383;

    static {
        try {
            field_3379[0] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", new Class[0]);
            Method[] var1 = field_3379;
            Class[] var2 = new Class[] {String.class, Integer.TYPE};
            var1[1] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", var2);
            field_3379[2] = SSLContextSpi.class.getDeclaredMethod("engineGetClientSessionContext", new Class[0]);
            field_3379[3] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSessionContext", new Class[0]);
            field_3379[4] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSocketFactory", new Class[0]);
            field_3379[5] = SSLContextSpi.class.getDeclaredMethod("engineGetSocketFactory", new Class[0]);
            field_3379[6] = SSLContextSpi.class.getDeclaredMethod("engineInit", new Class[] {KeyManager[].class, TrustManager[].class, SecureRandom.class});
            class_689.method_3798(field_3379);
            class_693 var3 = new class_693(new class_693(), (class_661)null, (class_662)null);
            var3.engineCreateSSLEngine();
            var3.engineCreateSSLEngine((String)null, 0);
            var3.engineGetClientSessionContext();
            var3.engineGetServerSessionContext();
            var3.engineGetServerSocketFactory();
            var3.engineGetSocketFactory();
            var3.engineInit((KeyManager[])null, (TrustManager[])null, (SecureRandom)null);
            field_3380 = true;
        } catch (Throwable var4) {
            class_764.method_4023();
            field_3380 = false;
        }
    }

    private class_693() {
    }

    private class_693(SSLContextSpi var1, class_661 var2, class_662 var3) {
        this.field_3381 = var1;
        this.field_3382 = var2;
        this.field_3383 = var3;
    }

    // $FF: renamed from: a (javax.net.ssl.SSLContextSpi, crittercism.android.e, crittercism.android.d) crittercism.android.z
    public static class_693 method_3813(SSLContextSpi var0, class_661 var1, class_662 var2) {
        return !field_3380?null:new class_693(var0, var1, var2);
    }

    // $FF: renamed from: a (int, java.lang.Object[]) java.lang.Object
    private Object method_3814(int var1, Object... var2) {
        if(this.field_3381 == null) {
            return null;
        } else {
            try {
                Object var8 = field_3379[var1].invoke(this.field_3381, var2);
                return var8;
            } catch (IllegalArgumentException var9) {
                throw new class_747(var9);
            } catch (IllegalAccessException var10) {
                throw new class_747(var10);
            } catch (InvocationTargetException var11) {
                Throwable var5 = var11.getTargetException();
                if(var5 == null) {
                    throw new class_747(var11);
                } else if(var5 instanceof Exception) {
                    throw (Exception)var5;
                } else if(var5 instanceof Error) {
                    throw (Error)var5;
                } else {
                    throw new class_747(var11);
                }
            } catch (ClassCastException var12) {
                throw new class_747(var12);
            }
        }
    }

    // $FF: renamed from: a (java.lang.Object[]) java.lang.Object
    private Object method_3815(Object... var1) {
        try {
            Object var5 = this.method_3814(6, var1);
            return var5;
        } catch (RuntimeException var6) {
            throw var6;
        } catch (KeyManagementException var7) {
            throw var7;
        } catch (Exception var8) {
            throw new class_747(var8);
        }
    }

    // $FF: renamed from: a () boolean
    public static boolean method_3816() {
        return field_3380;
    }

    // $FF: renamed from: b (int, java.lang.Object[]) java.lang.Object
    private Object method_3817(int var1, Object... var2) {
        try {
            Object var5 = this.method_3814(var1, var2);
            return var5;
        } catch (RuntimeException var6) {
            throw var6;
        } catch (Exception var7) {
            throw new class_747(var7);
        }
    }

    protected final SSLEngine engineCreateSSLEngine() {
        return (SSLEngine)this.method_3817(0, new Object[0]);
    }

    protected final SSLEngine engineCreateSSLEngine(String var1, int var2) {
        Object[] var3 = new Object[] {var1, Integer.valueOf(var2)};
        return (SSLEngine)this.method_3817(1, var3);
    }

    protected final SSLSessionContext engineGetClientSessionContext() {
        return (SSLSessionContext)this.method_3817(2, new Object[0]);
    }

    protected final SSLSessionContext engineGetServerSessionContext() {
        return (SSLSessionContext)this.method_3817(3, new Object[0]);
    }

    protected final SSLServerSocketFactory engineGetServerSocketFactory() {
        return (SSLServerSocketFactory)this.method_3817(4, new Object[0]);
    }

    protected final SSLSocketFactory engineGetSocketFactory() {
        Object var1 = (SSLSocketFactory)this.method_3817(5, new Object[0]);
        if(var1 != null) {
            class_773 var2;
            try {
                var2 = new class_773((SSLSocketFactory)var1, this.field_3382, this.field_3383);
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
                return (SSLSocketFactory)var1;
            }

            var1 = var2;
        }

        return (SSLSocketFactory)var1;
    }

    protected final void engineInit(KeyManager[] var1, TrustManager[] var2, SecureRandom var3) {
        this.method_3815(new Object[] {var1, var2, var3});
    }

    public final boolean equals(Object var1) {
        SSLContextSpi var10000 = this.field_3381;
        return this.field_3381.equals(var1);
    }

    public final int hashCode() {
        SSLContextSpi var10000 = this.field_3381;
        return this.field_3381.hashCode();
    }

    public final String toString() {
        SSLContextSpi var10000 = this.field_3381;
        return this.field_3381.toString();
    }
}
