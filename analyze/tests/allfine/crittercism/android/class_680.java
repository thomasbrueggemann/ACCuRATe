package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_678;
import crittercism.android.class_679;
import crittercism.android.class_764;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

// $FF: renamed from: crittercism.android.o
public final class class_680 extends class_679 {
    // $FF: renamed from: f java.lang.String[]
    private static final String[] field_3329 = new String[] {"libcore.net.http.HttpURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.http.HttpURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.http.HttpURLConnection"};

    public class_680(class_661 var1, class_662 var2) {
        super(var1, var2, field_3329);
    }

    // $FF: renamed from: a () java.lang.String
    protected final String method_3780() {
        return "http";
    }

    protected final int getDefaultPort() {
        return 80;
    }

    protected final URLConnection openConnection(URL var1) {
        HttpURLConnection var2 = (HttpURLConnection)super.openConnection(var1);

        try {
            class_678 var3 = new class_678(var2, super.field_3324, super.field_3325);
            return var3;
        } catch (ThreadDeath var6) {
            throw var6;
        } catch (Throwable var7) {
            class_764.method_4019(var7);
            return var2;
        }
    }

    protected final URLConnection openConnection(URL var1, Proxy var2) {
        HttpURLConnection var3 = (HttpURLConnection)super.openConnection(var1, var2);

        try {
            class_678 var4 = new class_678(var3, super.field_3324, super.field_3325);
            return var4;
        } catch (ThreadDeath var7) {
            throw var7;
        } catch (Throwable var8) {
            class_764.method_4019(var8);
            return var3;
        }
    }
}
