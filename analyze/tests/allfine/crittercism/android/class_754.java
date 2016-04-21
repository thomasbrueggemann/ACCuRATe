package crittercism.android;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

// $FF: renamed from: crittercism.android.dc
public final class class_754 {
    // $FF: renamed from: a javax.net.ssl.SSLSocketFactory
    private static SSLSocketFactory field_3574 = null;
    // $FF: renamed from: b java.net.URL
    private URL field_3575;
    // $FF: renamed from: c java.util.Map
    private Map field_3576 = new HashMap();
    // $FF: renamed from: d int
    private int field_3577 = 0;
    // $FF: renamed from: e boolean
    private boolean field_3578 = true;
    // $FF: renamed from: f boolean
    private boolean field_3579 = true;
    // $FF: renamed from: g java.lang.String
    private String field_3580 = "POST";
    // $FF: renamed from: h boolean
    private boolean field_3581 = false;
    // $FF: renamed from: i int
    private int field_3582 = 2500;

    static {
        try {
            SSLContext var1 = SSLContext.getInstance("TLS");
            var1.init((KeyManager[])null, (TrustManager[])null, (SecureRandom)null);
            field_3574 = var1.getSocketFactory();
        } catch (GeneralSecurityException var2) {
            field_3574 = null;
        }
    }

    public class_754(URL var1) {
        this.field_3575 = var1;
        this.field_3576.put("User-Agent", Arrays.asList(new String[] {"5.1.4"}));
        this.field_3576.put("Content-Type", Arrays.asList(new String[] {"application/json"}));
        this.field_3576.put("Accept", Arrays.asList(new String[] {"text/plain", "application/json"}));
    }

    // $FF: renamed from: a () java.net.HttpURLConnection
    public final HttpURLConnection method_4000() {
        HttpURLConnection var1 = (HttpURLConnection)this.field_3575.openConnection();
        Iterator var2 = this.field_3576.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var4 = (Entry)var2.next();
            Iterator var5 = ((List)var4.getValue()).iterator();

            while(var5.hasNext()) {
                String var6 = (String)var5.next();
                var1.addRequestProperty((String)var4.getKey(), var6);
            }
        }

        var1.setConnectTimeout(this.field_3582);
        var1.setReadTimeout(this.field_3582);
        var1.setDoInput(this.field_3578);
        var1.setDoOutput(this.field_3579);
        if(this.field_3581) {
            var1.setChunkedStreamingMode(this.field_3577);
        }

        var1.setRequestMethod(this.field_3580);
        if(var1 instanceof HttpsURLConnection) {
            HttpsURLConnection var3 = (HttpsURLConnection)var1;
            if(field_3574 == null) {
                throw new GeneralSecurityException();
            }

            var3.setSSLSocketFactory(field_3574);
        }

        return var1;
    }
}
