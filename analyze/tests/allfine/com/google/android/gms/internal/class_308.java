package com.google.android.gms.internal;

import com.google.android.gms.internal.class_903;
import com.google.android.gms.internal.class_904;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_906;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pn;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.ph
public abstract class class_308<M extends ph<M>> extends pn {
    protected class_904 awJ;

    // $FF: renamed from: a (com.google.android.gms.internal.pi) java.lang.Object
    public final <T> T method_2117(pi<M, T> var1) {
        if(this.awJ != null) {
            class_903 var2 = this.awJ.method_4633(class_905.method_4637(var1.tag));
            if(var2 != null) {
                return var2.method_4626(var1);
            }
        }

        return null;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pg) void
    public void method_2112(class_909 var1) throws IOException {
        if(this.awJ != null) {
            for(int var2 = 0; var2 < this.awJ.size(); ++var2) {
                this.awJ.method_4634(var2).method_4624(var1);
            }
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.pf, int) boolean
    protected final boolean method_2118(class_908 var1, int var2) throws IOException {
        int var3 = var1.getPosition();
        if(!var1.method_4649(var2)) {
            return false;
        } else {
            int var4 = class_905.method_4637(var2);
            class_906 var5 = new class_906(var2, var1.method_4669(var3, var1.getPosition() - var3));
            class_903 var6 = null;
            if(this.awJ == null) {
                this.awJ = new class_904();
            } else {
                var6 = this.awJ.method_4633(var4);
            }

            if(var6 == null) {
                var6 = new class_903();
                this.awJ.method_4632(var4, var6);
            }

            var6.method_4625(var5);
            return true;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ph) boolean
    protected final boolean method_2119(M var1) {
        return this.awJ != null && !this.awJ.isEmpty()?this.awJ.equals(var1.awJ):var1.awJ == null || var1.awJ.isEmpty();
    }

    // $FF: renamed from: c () int
    protected int method_2114() {
        int var1 = 0;
        int var2;
        if(this.awJ != null) {
            for(var2 = 0; var1 < this.awJ.size(); ++var1) {
                var2 += this.awJ.method_4634(var1).method_4627();
            }
        } else {
            var2 = 0;
        }

        return var2;
    }

    // $FF: renamed from: qz () int
    protected final int method_2120() {
        return this.awJ != null && !this.awJ.isEmpty()?this.awJ.hashCode():0;
    }
}
