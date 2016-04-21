package com.google.android.gms.internal;

import com.google.android.gms.internal.class_902;
import com.google.android.gms.internal.class_906;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.pk
class class_903 {
    private pi<?, ?> awQ;
    private Object awR;
    private List<pp> awS = new ArrayList();

    private byte[] toByteArray() throws IOException {
        byte[] var1 = new byte[this.method_4627()];
        this.method_4624(class_909.method_4695(var1));
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pg) void
    void method_4624(class_909 var1) throws IOException {
        if(this.awR != null) {
            this.awQ.method_4619(this.awR, var1);
        } else {
            Iterator var2 = this.awS.iterator();

            while(var2.hasNext()) {
                ((class_906)var2.next()).method_4639(var1);
            }
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.pp) void
    void method_4625(class_906 var1) {
        this.awS.add(var1);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.pi) java.lang.Object
    <T> T method_4626(pi<?, T> var1) {
        if(this.awR != null) {
            if(this.awQ != var1) {
                throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
            }
        } else {
            this.awQ = var1;
            this.awR = var1.method_4622(this.awS);
            this.awS = null;
        }

        return this.awR;
    }

    // $FF: renamed from: c () int
    int method_4627() {
        int var2;
        if(this.awR != null) {
            var2 = this.awQ.method_4615(this.awR);
        } else {
            Iterator var1 = this.awS.iterator();

            for(var2 = 0; var1.hasNext(); var2 += ((class_906)var1.next()).method_4640()) {
                ;
            }
        }

        return var2;
    }

    public boolean equals(Object var1) {
        boolean var3;
        if(var1 == this) {
            var3 = true;
        } else {
            boolean var2 = var1 instanceof class_903;
            var3 = false;
            if(var2) {
                class_903 var4 = (class_903)var1;
                if(this.awR == null || var4.awR == null) {
                    if(this.awS != null && var4.awS != null) {
                        return this.awS.equals(var4.awS);
                    } else {
                        try {
                            boolean var6 = Arrays.equals(this.toByteArray(), var4.toByteArray());
                            return var6;
                        } catch (IOException var9) {
                            throw new IllegalStateException(var9);
                        }
                    }
                }

                class_902 var7 = this.awQ;
                class_902 var8 = var4.awQ;
                var3 = false;
                if(var7 == var8) {
                    if(!this.awQ.awK.isArray()) {
                        return this.awR.equals(var4.awR);
                    }

                    if(this.awR instanceof byte[]) {
                        return Arrays.equals((byte[])((byte[])this.awR), (byte[])((byte[])var4.awR));
                    }

                    if(this.awR instanceof int[]) {
                        return Arrays.equals((int[])((int[])this.awR), (int[])((int[])var4.awR));
                    }

                    if(this.awR instanceof long[]) {
                        return Arrays.equals((long[])((long[])this.awR), (long[])((long[])var4.awR));
                    }

                    if(this.awR instanceof float[]) {
                        return Arrays.equals((float[])((float[])this.awR), (float[])((float[])var4.awR));
                    }

                    if(this.awR instanceof double[]) {
                        return Arrays.equals((double[])((double[])this.awR), (double[])((double[])var4.awR));
                    }

                    if(this.awR instanceof boolean[]) {
                        return Arrays.equals((boolean[])((boolean[])this.awR), (boolean[])((boolean[])var4.awR));
                    }

                    return Arrays.deepEquals((Object[])((Object[])this.awR), (Object[])((Object[])var4.awR));
                }
            }
        }

        return var3;
    }

    public int hashCode() {
        int var2;
        try {
            var2 = Arrays.hashCode(this.toByteArray());
        } catch (IOException var3) {
            throw new IllegalStateException(var3);
        }

        return var2 + 527;
    }
}
