package crittercism.android;

import android.os.Build.VERSION;
import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_685;
import crittercism.android.class_689;
import crittercism.android.class_695;
import crittercism.android.class_746;
import crittercism.android.class_747;
import crittercism.android.class_764;
import crittercism.android.class_770;
import crittercism.android.class_771;
import crittercism.android.class_773;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// $FF: renamed from: crittercism.android.i
public final class class_690 {
    // $FF: renamed from: a crittercism.android.v$a
    public static final class_685.class_1199 field_3353;
    // $FF: renamed from: b crittercism.android.i$b
    public static class_690.class_1192 field_3354;
    // $FF: renamed from: c java.util.List
    private static final List field_3355;
    // $FF: renamed from: d crittercism.android.ad
    private class_771 field_3356;
    // $FF: renamed from: e crittercism.android.ab
    private class_773 field_3357;
    // $FF: renamed from: f crittercism.android.ab
    private class_773 field_3358;
    // $FF: renamed from: g crittercism.android.v
    private class_685 field_3359;
    // $FF: renamed from: h crittercism.android.e
    private class_661 field_3360;
    // $FF: renamed from: i crittercism.android.d
    private class_662 field_3361;
    // $FF: renamed from: j crittercism.android.i$b
    private class_690.class_1192 field_3362;
    // $FF: renamed from: k crittercism.android.v$a
    private class_685.class_1199 field_3363;

    static {
        field_3353 = class_685.class_1199.field_4998;
        field_3354 = class_690.class_1192.field_4775;
        field_3355 = new LinkedList();

        try {
            URL var0 = new URL("https://www.google.com");
            if(((URLStreamHandler)class_689.method_3796(class_689.method_3797(URL.class, URLStreamHandler.class), var0)).getClass().getName().contains("okhttp") && VERSION.SDK_INT >= 19) {
                field_3354 = class_690.class_1192.field_4773;
            } else {
                field_3354 = class_690.class_1192.field_4774;
            }
        } catch (Exception var2) {
            field_3354 = class_690.class_1192.field_4775;
        }
    }

    public class_690(class_661 var1, class_662 var2) {
        this.field_3362 = field_3354;
        this.field_3363 = field_3353;
        this.field_3360 = var1;
        this.field_3361 = var2;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.Throwable) void
    private static void method_3799(String var0, Throwable var1) {
        List var2 = field_3355;
        synchronized(var2) {
            field_3355.add(var1);
        }

        class_764.method_4024(var0);
    }

    // $FF: renamed from: a (javax.net.ssl.SSLSocketFactory) void
    private static void method_3800(SSLSocketFactory var0) {
        org.apache.http.conn.ssl.SSLSocketFactory var1 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
        class_689.method_3797(org.apache.http.conn.ssl.SSLSocketFactory.class, SSLSocketFactory.class).set(var1, var0);
    }

    // $FF: renamed from: a (java.net.SocketImplFactory) boolean
    private static boolean method_3801(SocketImplFactory var0) {
        Field var2;
        try {
            var2 = class_689.method_3797(Socket.class, SocketImplFactory.class);
        } catch (class_746 var9) {
            method_3799("Unable to install OPTIMZ for http connections", var9);
            return false;
        }

        try {
            var2.setAccessible(true);
            var2.set((Object)null, var0);
            return true;
        } catch (IllegalArgumentException var6) {
            method_3799("Unable to install OPTIMZ for http connections", var6);
            return true;
        } catch (IllegalAccessException var7) {
            method_3799("Unable to install OPTIMZ for http connections", var7);
            return false;
        } catch (NullPointerException var8) {
            method_3799("Unable to install OPTIMZ for http connections", var8);
            return false;
        }
    }

    // $FF: renamed from: d () void
    public static void method_3802() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: e () boolean
    private boolean method_3803() {
        class_690.class_1191 var1 = new class_690.class_1191(this);
        Thread var2 = new Thread(var1);
        var2.start();

        try {
            var2.join();
        } catch (InterruptedException var4) {
            ;
        }

        return var1.method_5432();
    }

    // $FF: renamed from: f () boolean
    private boolean method_3804() {
        try {
            this.field_3359 = new class_685(this.field_3363, this.field_3360, this.field_3361);
            boolean var2 = this.field_3359.method_3792();
            return var2;
        } catch (ClassNotFoundException var3) {
            return false;
        }
    }

    // $FF: renamed from: g () javax.net.ssl.SSLSocketFactory
    private static SSLSocketFactory method_3805() {
        org.apache.http.conn.ssl.SSLSocketFactory var0 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
        return (SSLSocketFactory)class_689.method_3797(org.apache.http.conn.ssl.SSLSocketFactory.class, SSLSocketFactory.class).get(var0);
    }

    // $FF: renamed from: h () boolean
    private boolean method_3806() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a () boolean
    public final boolean method_3807() {
        boolean var1 = false;
        if(!class_770.method_4051()) {
            method_3799("Unable to install OPTMZ", class_770.method_4052());
        } else {
            try {
                class_770.method_4053();
            } catch (class_747 var6) {
                class_764.method_4018(var6.toString(), var6);
                return false;
            }

            boolean var3 = false | this.method_3806();
            boolean var4;
            if(VERSION.SDK_INT >= 19) {
                var4 = var3 | this.method_3803();
            } else {
                var4 = var3 | this.method_3809();
            }

            if(VERSION.SDK_INT >= 17) {
                var1 = var4 | class_695.method_3825(this.field_3360, this.field_3361);
            } else {
                var1 = var4;
            }

            if(this.field_3362 == class_690.class_1192.field_4773) {
                SSLSocketFactory var5 = HttpsURLConnection.getDefaultSSLSocketFactory();
                if(var5 instanceof class_773) {
                    this.field_3357 = (class_773)var5;
                } else {
                    this.field_3357 = new class_773(var5, this.field_3360, this.field_3361);
                    HttpsURLConnection.setDefaultSSLSocketFactory(this.field_3357);
                }

                return var1 | true;
            }

            if(this.field_3362 == class_690.class_1192.field_4774) {
                return var1 | this.method_3804();
            }
        }

        return var1;
    }

    // $FF: renamed from: b () void
    public final void method_3808() {
        try {
            SSLSocketFactory var4 = method_3805();
            if(var4 instanceof class_773) {
                method_3800(((class_773)var4).method_4057());
            }
        } catch (IllegalArgumentException var5) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var5);
            return;
        } catch (IllegalAccessException var6) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var6);
            return;
        } catch (class_746 var7) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var7);
            return;
        }

        this.field_3358 = null;
    }

    // $FF: renamed from: c () boolean
    public final boolean method_3809() {
        SSLSocketFactory var5;
        try {
            var5 = method_3805();
        } catch (IllegalArgumentException var13) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var13);
            return false;
        } catch (IllegalAccessException var14) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var14);
            return false;
        } catch (ClassCastException var15) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var15);
            return false;
        } catch (class_746 var16) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var16);
            return false;
        }

        if(var5 == null) {
            method_3799("Unable to install OPTIMZ for SSL HttpClient connections", new NullPointerException("Delegate factory was null"));
        } else if(!(var5 instanceof class_773)) {
            class_773 var6 = new class_773(var5, this.field_3360, this.field_3361);

            try {
                method_3800(var6);
            } catch (IllegalArgumentException var10) {
                method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var10);
                return false;
            } catch (IllegalAccessException var11) {
                method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var11);
                return false;
            } catch (class_746 var12) {
                method_3799("Unable to install OPTIMZ for SSL HttpClient connections", var12);
                return false;
            }

            this.field_3358 = var6;
            return true;
        }

        return false;
    }

    static final class class_1191 implements Runnable {
        // $FF: renamed from: a boolean
        private boolean field_4770;
        // $FF: renamed from: b boolean
        private boolean field_4771 = false;
        // $FF: renamed from: c crittercism.android.i
        private class_690 field_4772;

        public class_1191(class_690 var1) {
            this.field_4772 = var1;
            this.field_4770 = true;
        }

        // $FF: renamed from: a () boolean
        public final boolean method_5432() {
            return this.field_4771;
        }

        public final void run() {
            if(this.field_4770) {
                this.field_4771 = this.field_4772.method_3809();
            } else {
                this.field_4772.method_3808();
            }
        }
    }

    public static enum class_1192 {
        // $FF: renamed from: a crittercism.android.i$b
        field_4773,
        // $FF: renamed from: b crittercism.android.i$b
        field_4774,
        // $FF: renamed from: c crittercism.android.i$b
        field_4775;

        static {
            class_690.class_1192[] var0 = new class_690.class_1192[]{field_4773, field_4774, field_4775};
        }
    }
}
