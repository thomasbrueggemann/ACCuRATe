package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;

// $FF: renamed from: com.google.android.gms.common.data.d
public abstract class class_255 {
    // $FF: renamed from: II com.google.android.gms.common.data.DataHolder
    protected final DataHolder field_780;
    // $FF: renamed from: JX int
    protected int field_781;
    // $FF: renamed from: JY int
    private int field_782;

    public class_255(DataHolder var1, int var2) {
        this.field_780 = (DataHolder)class_1090.method_5685(var1);
        this.method_1650(var2);
    }

    // $FF: renamed from: a (java.lang.String, android.database.CharArrayBuffer) void
    protected void method_1646(String var1, CharArrayBuffer var2) {
        this.field_780.method_5985(var1, this.field_781, this.field_782, var2);
    }

    // $FF: renamed from: aQ (java.lang.String) boolean
    public boolean method_1647(String var1) {
        return this.field_780.method_5986(var1);
    }

    // $FF: renamed from: aR (java.lang.String) android.net.Uri
    protected Uri method_1648(String var1) {
        return this.field_780.method_5994(var1, this.field_781, this.field_782);
    }

    // $FF: renamed from: aS (java.lang.String) boolean
    protected boolean method_1649(String var1) {
        return this.field_780.method_5999(var1, this.field_781, this.field_782);
    }

    // $FF: renamed from: ap (int) void
    protected void method_1650(int var1) {
        boolean var2;
        if(var1 >= 0 && var1 < this.field_780.getCount()) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5674(var2);
        this.field_781 = var1;
        this.field_782 = this.field_780.method_5987(this.field_781);
    }

    public boolean equals(Object var1) {
        boolean var2 = var1 instanceof class_255;
        boolean var3 = false;
        if(var2) {
            class_255 var4 = (class_255)var1;
            boolean var5 = class_1089.equal(Integer.valueOf(var4.field_781), Integer.valueOf(this.field_781));
            var3 = false;
            if(var5) {
                boolean var6 = class_1089.equal(Integer.valueOf(var4.field_782), Integer.valueOf(this.field_782));
                var3 = false;
                if(var6) {
                    DataHolder var7 = var4.field_780;
                    DataHolder var8 = this.field_780;
                    var3 = false;
                    if(var7 == var8) {
                        var3 = true;
                    }
                }
            }
        }

        return var3;
    }

    protected boolean getBoolean(String var1) {
        return this.field_780.method_5990(var1, this.field_781, this.field_782);
    }

    protected byte[] getByteArray(String var1) {
        return this.field_780.method_5993(var1, this.field_781, this.field_782);
    }

    protected float getFloat(String var1) {
        return this.field_780.method_5991(var1, this.field_781, this.field_782);
    }

    protected int getInteger(String var1) {
        return this.field_780.method_5988(var1, this.field_781, this.field_782);
    }

    protected long getLong(String var1) {
        return this.field_780.method_5984(var1, this.field_781, this.field_782);
    }

    protected String getString(String var1) {
        return this.field_780.method_5989(var1, this.field_781, this.field_782);
    }

    // $FF: renamed from: gz () int
    protected int method_1651() {
        return this.field_781;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_781), Integer.valueOf(this.field_782), this.field_780};
        return class_1089.hashCode(var1);
    }

    public boolean isDataValid() {
        return !this.field_780.isClosed();
    }
}
