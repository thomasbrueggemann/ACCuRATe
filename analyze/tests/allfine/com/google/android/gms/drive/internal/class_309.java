package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.internal.ah;
import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_899;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.drive.internal.ah
public final class class_309 extends ph<ah> {
    // $FF: renamed from: Pl java.lang.String
    public String field_949;
    // $FF: renamed from: Pm long
    public long field_950;
    // $FF: renamed from: Pn long
    public long field_951;
    public int versionCode;

    public class_309() {
        this.method_2122();
    }

    // $FF: renamed from: g (byte[]) com.google.android.gms.drive.internal.ah
    public static class_309 method_2121(byte[] var0) throws class_899 {
        return (class_309)class_307.method_2108(new class_309(), var0);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pg) void
    public void method_2112(class_909 var1) throws IOException {
        var1.method_4727(1, this.versionCode);
        var1.method_4710(2, this.field_949);
        var1.method_4713(3, this.field_950);
        var1.method_4713(4, this.field_951);
        super.method_2112(var1);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
    // $FF: synthetic method
    public class_307 method_2113(class_908 var1) throws IOException {
        return this.method_2123(var1);
    }

    // $FF: renamed from: c () int
    protected int method_2114() {
        return super.method_2114() + class_909.method_4697(1, this.versionCode) + class_909.method_4694(2, this.field_949) + class_909.method_4686(3, this.field_950) + class_909.method_4686(4, this.field_951);
    }

    public boolean equals(Object var1) {
        boolean var3;
        if(var1 == this) {
            var3 = true;
        } else {
            boolean var2 = var1 instanceof class_309;
            var3 = false;
            if(var2) {
                class_309 var4 = (class_309)var1;
                int var5 = this.versionCode;
                int var6 = var4.versionCode;
                var3 = false;
                if(var5 == var6) {
                    if(this.field_949 == null) {
                        String var9 = var4.field_949;
                        var3 = false;
                        if(var9 != null) {
                            return var3;
                        }
                    } else if(!this.field_949.equals(var4.field_949)) {
                        return false;
                    }

                    long var10;
                    int var7 = (var10 = this.field_950 - var4.field_950) == 0L?0:(var10 < 0L?-1:1);
                    var3 = false;
                    if(var7 == 0) {
                        long var11;
                        int var8 = (var11 = this.field_951 - var4.field_951) == 0L?0:(var11 < 0L?-1:1);
                        var3 = false;
                        if(var8 == 0) {
                            return this.a(var4);
                        }
                    }
                }
            }
        }

        return var3;
    }

    public int hashCode() {
        int var1 = 31 * (527 + this.versionCode);
        int var2;
        if(this.field_949 == null) {
            var2 = 0;
        } else {
            var2 = this.field_949.hashCode();
        }

        return 31 * (31 * (31 * (var2 + var1) + (int)(this.field_950 ^ this.field_950 >>> 32)) + (int)(this.field_951 ^ this.field_951 >>> 32)) + this.qz();
    }

    // $FF: renamed from: ic () com.google.android.gms.drive.internal.ah
    public class_309 method_2122() {
        this.versionCode = 1;
        this.field_949 = "";
        this.field_950 = -1L;
        this.field_951 = -1L;
        this.awJ = null;
        this.awU = -1;
        return this;
    }

    // $FF: renamed from: m (com.google.android.gms.internal.pf) com.google.android.gms.drive.internal.ah
    public class_309 method_2123(class_908 var1) throws IOException {
        while(true) {
            int var2 = var1.method_4655();
            switch(var2) {
                case 8:
                    this.versionCode = var1.method_4658();
                    break;
                case 18:
                    this.field_949 = var1.readString();
                    break;
                case 24:
                    this.field_950 = var1.method_4661();
                    break;
                case 32:
                    this.field_951 = var1.method_4661();
                    break;
                default:
                    if(this.a(var1, var2)) {
                        break;
                    }
                case 0:
                    return this;
            }
        }
    }
}
