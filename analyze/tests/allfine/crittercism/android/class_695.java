package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_693;
import crittercism.android.class_764;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Provider.Service;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLContextSpi;

// $FF: renamed from: crittercism.android.y
public final class class_695 extends Service {
    // $FF: renamed from: a java.lang.String[]
    public static final String[] field_3389 = new String[] {"Default", "SSL", "TLSv1.1", "TLSv1.2", "SSLv3", "TLSv1", "TLS"};
    // $FF: renamed from: b crittercism.android.e
    private class_661 field_3390;
    // $FF: renamed from: c crittercism.android.d
    private class_662 field_3391;
    // $FF: renamed from: d java.security.Provider.Service
    private Service field_3392;

    private class_695(Service var1, class_661 var2, class_662 var3) {
        super(var1.getProvider(), var1.getType(), var1.getAlgorithm(), var1.getClassName(), (List)null, (Map)null);
        this.field_3390 = var2;
        this.field_3391 = var3;
        this.field_3392 = var1;
    }

    // $FF: renamed from: a (java.security.Provider.Service, crittercism.android.e, crittercism.android.d) crittercism.android.y
    private static class_695 method_3823(Service param0, class_661 param1, class_662 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a () java.security.Provider
    private static Provider method_3824() {
        SSLContext var1;
        try {
            var1 = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException var3) {
            return null;
        }

        Provider var2 = null;
        if(var1 != null) {
            var2 = var1.getProvider();
        }

        return var2;
    }

    // $FF: renamed from: a (crittercism.android.e, crittercism.android.d) boolean
    public static boolean method_3825(class_661 var0, class_662 var1) {
        int var2 = 0;
        if(class_693.method_3816()) {
            Provider var3 = method_3824();
            if(var3 != null) {
                boolean var4;
                for(var4 = false; var2 < field_3389.length; ++var2) {
                    Service var5 = var3.getService("SSLContext", field_3389[var2]);
                    if(var5 != null && !(var5 instanceof class_695)) {
                        class_695 var6 = method_3823(var5, var0, var1);
                        if(var6 != null) {
                            var4 |= var6.method_3826();
                        }
                    }
                }

                return var4;
            }
        }

        return false;
    }

    // $FF: renamed from: b () boolean
    private boolean method_3826() {
        Provider var1 = this.getProvider();
        if(var1 == null) {
            return false;
        } else {
            try {
                Method var3 = Provider.class.getDeclaredMethod("putService", new Class[] {Service.class});
                var3.setAccessible(true);
                var3.invoke(var1, new Object[] {this});
                var1.put("SSLContext.DummySSLAlgorithm", this.getClassName());
                var1.remove(this.getType() + "." + this.getAlgorithm());
                var1.remove("SSLContext.DummySSLAlgorithm");
                return true;
            } catch (Exception var4) {
                return false;
            }
        }
    }

    public final Object newInstance(Object var1) {
        Object var2 = super.newInstance(var1);

        class_693 var5;
        try {
            if(!(var2 instanceof SSLContextSpi)) {
                return var2;
            }

            var5 = class_693.method_3813((SSLContextSpi)var2, this.field_3390, this.field_3391);
        } catch (ThreadDeath var6) {
            throw var6;
        } catch (Throwable var7) {
            class_764.method_4019(var7);
            return var2;
        }

        if(var5 != null) {
            var2 = var5;
        }

        return var2;
    }
}
