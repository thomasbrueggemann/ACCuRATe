package com.google.android.gms.internal;

import com.google.android.gms.internal.class_229;
import com.google.android.gms.internal.ez;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ak
@ez
public class class_232 {
    // $FF: renamed from: mw java.lang.Object
    private final Object field_583 = new Object();
    // $FF: renamed from: nf int
    private final int field_584;
    // $FF: renamed from: ng int
    private final int field_585;
    // $FF: renamed from: nh int
    private final int field_586;
    // $FF: renamed from: ni com.google.android.gms.internal.ap
    private final class_229 field_587;
    // $FF: renamed from: nj java.util.ArrayList
    private ArrayList<String> field_588 = new ArrayList();
    // $FF: renamed from: nk int
    private int field_589 = 0;
    // $FF: renamed from: nl int
    private int field_590 = 0;
    // $FF: renamed from: nm int
    private int field_591 = 0;
    // $FF: renamed from: nn int
    private int field_592;
    // $FF: renamed from: no java.lang.String
    private String field_593 = "";

    public class_232(int var1, int var2, int var3, int var4) {
        this.field_584 = var1;
        this.field_585 = var2;
        this.field_586 = var3;
        this.field_587 = new class_229(var4);
    }

    // $FF: renamed from: a (java.util.ArrayList, int) java.lang.String
    private String method_1555(ArrayList<String> var1, int var2) {
        String var6;
        if(var1.isEmpty()) {
            var6 = "";
        } else {
            StringBuffer var3 = new StringBuffer();
            Iterator var4 = var1.iterator();

            while(var4.hasNext()) {
                var3.append((String)var4.next());
                var3.append(' ');
                if(var3.length() > var2) {
                    break;
                }
            }

            var3.deleteCharAt(-1 + var3.length());
            var6 = var3.toString();
            if(var6.length() >= var2) {
                return var6.substring(0, var2);
            }
        }

        return var6;
    }

    // $FF: renamed from: j (java.lang.String) void
    private void method_1556(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (int, int) int
    int method_1557(int var1, int var2) {
        return var1 * this.field_584 + var2 * this.field_585;
    }

    // $FF: renamed from: aN () boolean
    public boolean method_1558() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aO () java.lang.String
    public String method_1559() {
        return this.field_593;
    }

    // $FF: renamed from: aP () void
    public void method_1560() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aQ () void
    public void method_1561() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aR () void
    public void method_1562() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aS () void
    public void method_1563() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aT () int
    int method_1564() {
        return this.field_589;
    }

    // $FF: renamed from: c (int) void
    public void method_1565(int var1) {
        this.field_590 = var1;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_232) {
            if(var1 == this) {
                return true;
            }

            class_232 var2 = (class_232)var1;
            if(var2.method_1559() != null && var2.method_1559().equals(this.method_1559())) {
                return true;
            }
        }

        return false;
    }

    public int getScore() {
        return this.field_592;
    }

    // $FF: renamed from: h (java.lang.String) void
    public void method_1566(String param1) {
        // $FF: Couldn't be decompiled
    }

    public int hashCode() {
        return this.method_1559().hashCode();
    }

    // $FF: renamed from: i (java.lang.String) void
    public void method_1567(String var1) {
        this.method_1556(var1);
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.field_590 + " score:" + this.field_592 + " total_length:" + this.field_589 + "\n text: " + this.method_1555(this.field_588, 200) + "\n signture: " + this.field_593;
    }
}
