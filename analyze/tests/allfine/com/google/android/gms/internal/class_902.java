package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_906;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pn;
import com.google.android.gms.internal.pp;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.pi
public class class_902<M extends ph<M>, T> {
    protected final Class<T> awK;
    protected final boolean awL;
    protected final int tag;
    protected final int type;

    private class_902(int var1, Class<T> var2, int var3, boolean var4) {
        this.type = var1;
        this.awK = var2;
        this.tag = var3;
        this.awL = var4;
    }

    // $FF: renamed from: a (int, java.lang.Class, int) com.google.android.gms.internal.pi
    public static <M extends ph<M>, T extends pn> pi<M, T> method_4612(int var0, Class<T> var1, int var2) {
        return new class_902(var0, var1, var2, false);
    }

    // $FF: renamed from: m (java.util.List) java.lang.Object
    private T method_4613(List<pp> var1) {
        int var2 = 0;
        ArrayList var3 = new ArrayList();

        for(int var4 = 0; var4 < var1.size(); ++var4) {
            class_906 var7 = (class_906)var1.get(var4);
            if(var7.awV.length != 0) {
                this.method_4618(var7, var3);
            }
        }

        int var5 = var3.size();
        Object var6;
        if(var5 == 0) {
            var6 = null;
        } else {
            for(var6 = this.awK.cast(Array.newInstance(this.awK.getComponentType(), var5)); var2 < var5; ++var2) {
                Array.set(var6, var2, var3.get(var2));
            }
        }

        return var6;
    }

    // $FF: renamed from: n (java.util.List) java.lang.Object
    private T method_4614(List<pp> var1) {
        if(var1.isEmpty()) {
            return null;
        } else {
            class_906 var2 = (class_906)var1.get(-1 + var1.size());
            return this.awK.cast(this.method_4623(class_908.method_4644(var2.awV)));
        }
    }

    // $FF: renamed from: A (java.lang.Object) int
    int method_4615(Object var1) {
        return this.awL?this.method_4616(var1):this.method_4617(var1);
    }

    // $FF: renamed from: B (java.lang.Object) int
    protected int method_4616(Object var1) {
        int var2 = 0;
        int var3 = Array.getLength(var1);

        for(int var4 = 0; var4 < var3; ++var4) {
            if(Array.get(var1, var4) != null) {
                var2 += this.method_4617(Array.get(var1, var4));
            }
        }

        return var2;
    }

    // $FF: renamed from: C (java.lang.Object) int
    protected int method_4617(Object var1) {
        int var2 = class_905.method_4637(this.tag);
        switch(this.type) {
            case 10:
                return class_909.method_4676(var2, (class_307)var1);
            case 11:
                return class_909.method_4680(var2, (class_307)var1);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pp, java.util.List) void
    protected void method_4618(pp var1, List<Object> var2) {
        var2.add(this.method_4623(class_908.method_4644(var1.awV)));
    }

    // $FF: renamed from: a (java.lang.Object, com.google.android.gms.internal.pg) void
    void method_4619(Object var1, class_909 var2) throws IOException {
        if(this.awL) {
            this.method_4621(var1, var2);
        } else {
            this.method_4620(var1, var2);
        }
    }

    // $FF: renamed from: b (java.lang.Object, com.google.android.gms.internal.pg) void
    protected void method_4620(Object var1, class_909 var2) {
        try {
            var2.method_4719(this.tag);
            switch(this.type) {
                case 10:
                    class_307 var4 = (class_307)var1;
                    int var5 = class_905.method_4637(this.tag);
                    var2.method_4712(var4);
                    var2.method_4730(var5, 4);
                    return;
                case 11:
                    var2.method_4714((class_307)var1);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException var6) {
            throw new IllegalStateException(var6);
        }
    }

    // $FF: renamed from: c (java.lang.Object, com.google.android.gms.internal.pg) void
    protected void method_4621(Object var1, class_909 var2) {
        int var3 = Array.getLength(var1);

        for(int var4 = 0; var4 < var3; ++var4) {
            Object var5 = Array.get(var1, var4);
            if(var5 != null) {
                this.method_4620(var5, var2);
            }
        }

    }

    // $FF: renamed from: l (java.util.List) java.lang.Object
    final T method_4622(List<pp> var1) {
        return var1 == null?null:(this.awL?this.method_4613(var1):this.method_4614(var1));
    }

    // $FF: renamed from: u (com.google.android.gms.internal.pf) java.lang.Object
    protected Object method_4623(class_908 var1) {
        Class var2;
        if(this.awL) {
            var2 = this.awK.getComponentType();
        } else {
            var2 = this.awK;
        }

        try {
            switch(this.type) {
                case 10:
                    class_307 var7 = (class_307)var2.newInstance();
                    var1.method_4647(var7, class_905.method_4637(this.tag));
                    return var7;
                case 11:
                    class_307 var6 = (class_307)var2.newInstance();
                    var1.method_4646(var6);
                    return var6;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException var8) {
            throw new IllegalArgumentException("Error creating instance of class " + var2, var8);
        } catch (IllegalAccessException var9) {
            throw new IllegalArgumentException("Error creating instance of class " + var2, var9);
        } catch (IOException var10) {
            throw new IllegalArgumentException("Error reading extension field", var10);
        }
    }
}
