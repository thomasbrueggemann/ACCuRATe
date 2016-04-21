package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_692;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

// $FF: renamed from: crittercism.android.m
public abstract class class_679 extends URLStreamHandler {
    // $FF: renamed from: a java.lang.String[]
    public static final String[] field_3322 = new String[] {"java.net.URL", "int", "java.net.Proxy"};
    // $FF: renamed from: b java.lang.String[]
    public static final String[] field_3323 = new String[] {"java.net.URL", "int"};
    // $FF: renamed from: c crittercism.android.e
    class_661 field_3324;
    // $FF: renamed from: d crittercism.android.d
    class_662 field_3325;
    // $FF: renamed from: e boolean
    boolean field_3326;
    // $FF: renamed from: f java.lang.reflect.Constructor
    private Constructor field_3327;
    // $FF: renamed from: g java.lang.reflect.Constructor
    private Constructor field_3328;

    public class_679(class_661 var1, class_662 var2, String[] var3) {
        this(var1, var2, var3, field_3322, field_3323);
    }

    private class_679(class_661 var1, class_662 var2, String[] var3, String[] var4, String[] var5) {
        this.field_3327 = null;
        this.field_3328 = null;
        this.field_3324 = var1;
        this.field_3325 = var2;
        this.field_3326 = true;
        int var6 = 0;

        while(var6 < var3.length) {
            try {
                this.field_3327 = class_692.method_3812(var3[var6], var5);
                this.field_3328 = class_692.method_3812(var3[var6], var4);
                this.field_3327.setAccessible(true);
                this.field_3328.setAccessible(true);
                break;
            } catch (ClassNotFoundException var8) {
                this.field_3327 = null;
                this.field_3327 = null;
                ++var6;
            }
        }

        if(this.field_3327 != null && this.field_3328 != null) {
            if(!this.method_3779()) {
                throw new ClassNotFoundException("Unable to open test connections");
            }
        } else {
            throw new ClassNotFoundException("Couldn\'t find suitable connection implementations");
        }
    }

    // $FF: renamed from: a (java.net.URL, java.net.Proxy) java.net.URLConnection
    private URLConnection method_3778(URL param1, Proxy param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () boolean
    private boolean method_3779() {
        this.field_3326 = false;

        try {
            this.openConnection(new URL("http://www.google.com"));
            return true;
        } catch (IOException var5) {
            ;
        } finally {
            this.field_3326 = true;
        }

        return false;
    }

    // $FF: renamed from: a () java.lang.String
    protected abstract String method_3780();

    protected abstract int getDefaultPort();

    protected URLConnection openConnection(URL var1) {
        return this.method_3778(var1, (Proxy)null);
    }

    protected URLConnection openConnection(URL var1, Proxy var2) {
        if(var1 != null && var2 != null) {
            return this.method_3778(var1, var2);
        } else {
            throw new IllegalArgumentException("url == null || proxy == null");
        }
    }
}
