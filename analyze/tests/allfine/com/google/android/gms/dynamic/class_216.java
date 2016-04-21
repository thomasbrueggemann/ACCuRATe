package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.class_1090;

// $FF: renamed from: com.google.android.gms.dynamic.g
public abstract class class_216<T> {
    // $FF: renamed from: Sl java.lang.String
    private final String field_544;
    // $FF: renamed from: Sm java.lang.Object
    private T field_545;

    protected class_216(String var1) {
        this.field_544 = var1;
    }

    // $FF: renamed from: L (android.content.Context) java.lang.Object
    protected final T method_1505(Context var1) throws class_216.class_1677 {
        if(this.field_545 == null) {
            class_1090.method_5685(var1);
            Context var3 = GooglePlayServicesUtil.getRemoteContext(var1);
            if(var3 == null) {
                throw new class_216.class_1677("Could not get remote context.");
            }

            ClassLoader var4 = var3.getClassLoader();

            try {
                this.field_545 = this.method_1506((IBinder)var4.loadClass(this.field_544).newInstance());
            } catch (ClassNotFoundException var8) {
                throw new class_216.class_1677("Could not load creator class.", var8);
            } catch (InstantiationException var9) {
                throw new class_216.class_1677("Could not instantiate creator.", var9);
            } catch (IllegalAccessException var10) {
                throw new class_216.class_1677("Could not access creator.", var10);
            }
        }

        return this.field_545;
    }

    // $FF: renamed from: d (android.os.IBinder) java.lang.Object
    protected abstract T method_1506(IBinder var1);

    public static class class_1677 extends Exception {
        public class_1677(String var1) {
            super(var1);
        }

        public class_1677(String var1, Throwable var2) {
            super(var1, var2);
        }
    }
}
