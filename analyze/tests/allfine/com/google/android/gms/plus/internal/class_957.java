package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_959;
import java.util.ArrayList;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.plus.internal.i
public class class_957 {
    // $FF: renamed from: Dd java.lang.String
    private String field_4495;
    private String[] alF;
    private String alG;
    private String alH;
    private String alI;
    private PlusCommonExtras alK;
    private final ArrayList<String> alL = new ArrayList();
    private String[] alM;

    public class_957(Context var1) {
        this.alH = var1.getPackageName();
        this.alG = var1.getPackageName();
        this.alK = new PlusCommonExtras();
        this.alL.add("https://www.googleapis.com/auth/plus.login");
    }

    // $FF: renamed from: ch (java.lang.String) com.google.android.gms.plus.internal.i
    public class_957 method_5054(String var1) {
        this.field_4495 = var1;
        return this;
    }

    // $FF: renamed from: g (java.lang.String[]) com.google.android.gms.plus.internal.i
    public class_957 method_5055(String... var1) {
        this.alL.clear();
        this.alL.addAll(Arrays.asList(var1));
        return this;
    }

    // $FF: renamed from: h (java.lang.String[]) com.google.android.gms.plus.internal.i
    public class_957 method_5056(String... var1) {
        this.alM = var1;
        return this;
    }

    // $FF: renamed from: np () com.google.android.gms.plus.internal.i
    public class_957 method_5057() {
        this.alL.clear();
        return this;
    }

    // $FF: renamed from: nq () com.google.android.gms.plus.internal.h
    public class_959 method_5058() {
        if(this.field_4495 == null) {
            this.field_4495 = "<<default account>>";
        }

        String[] var1 = (String[])this.alL.toArray(new String[this.alL.size()]);
        return new class_959(this.field_4495, var1, this.alM, this.alF, this.alG, this.alH, this.alI, this.alK);
    }
}
