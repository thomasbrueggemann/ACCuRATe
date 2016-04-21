package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_677;
import crittercism.android.class_679;
import crittercism.android.class_764;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

// $FF: renamed from: crittercism.android.q
public final class class_681 extends class_679 {
    // $FF: renamed from: f java.lang.String[]
    private static final String[] field_3330 = new String[] {"libcore.net.http.HttpsURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.https.HttpsURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.https.HttpsURLConnection"};

    public class_681(class_661 var1, class_662 var2) {
        super(var1, var2, field_3330);
    }

    // $FF: renamed from: a () java.lang.String
    protected final String method_3780() {
        return "https";
    }

    protected final int getDefaultPort() {
        return 443;
    }

    protected final URLConnection openConnection(URL var1) {
        HttpsURLConnection var2 = (HttpsURLConnection)super.openConnection(var1);

        try {
            class_677 var3 = new class_677(var2, super.field_3324, super.field_3325);
            return var3;
        } catch (ThreadDeath var6) {
            throw var6;
        } catch (Throwable var7) {
            class_764.method_4019(var7);
            return var2;
        }
    }

    protected final URLConnection openConnection(URL var1, Proxy var2) {
        HttpsURLConnection var3 = (HttpsURLConnection)super.openConnection(var1, var2);

        try {
            class_677 var4 = new class_677(var3, super.field_3324, super.field_3325);
            return var4;
        } catch (ThreadDeath var7) {
            throw var7;
        } catch (Throwable var8) {
            class_764.method_4019(var8);
            return var3;
        }
    }
}
