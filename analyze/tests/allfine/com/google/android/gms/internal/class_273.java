package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_270;
import com.google.android.gms.internal.class_271;
import com.google.android.gms.internal.class_863;
import com.google.android.gms.internal.nu;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.nw
public final class class_273 extends class_270 implements Moment {
    public static final class_863 CREATOR = new class_863();
    private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
    // $FF: renamed from: BL java.lang.String
    String field_819;
    // $FF: renamed from: BR int
    final int field_820;
    String amP;
    class_271 amX;
    class_271 amY;
    final Set<Integer> amc;
    // $FF: renamed from: uO java.lang.String
    String field_821;

    static {
        amb.put("id", class_268.class_1299.method_3873("id", 2));
        amb.put("result", class_268.class_1299.method_3867("result", 4, nu.class));
        amb.put("startDate", class_268.class_1299.method_3873("startDate", 5));
        amb.put("target", class_268.class_1299.method_3867("target", 6, nu.class));
        amb.put("type", class_268.class_1299.method_3873("type", 7));
    }

    public class_273() {
        this.field_820 = 1;
        this.amc = new HashSet();
    }

    class_273(Set<Integer> var1, int var2, String var3, nu var4, String var5, nu var6, String var7) {
        this.amc = var1;
        this.field_820 = var2;
        this.field_819 = var3;
        this.amX = var4;
        this.amP = var5;
        this.amY = var6;
        this.field_821 = var7;
    }

    public class_273(Set<Integer> var1, String var2, nu var3, String var4, nu var5, String var6) {
        this.amc = var1;
        this.field_820 = 1;
        this.field_819 = var2;
        this.amX = var3;
        this.amP = var4;
        this.amY = var5;
        this.field_821 = var6;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
    protected boolean method_1691(class_268.class_1299 var1) {
        return this.amc.contains(Integer.valueOf(var1.method_3882()));
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
    protected Object method_1692(class_268.class_1299 var1) {
        switch(var1.method_3882()) {
            case 2:
                return this.field_819;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            case 4:
                return this.amX;
            case 5:
                return this.amP;
            case 6:
                return this.amY;
            case 7:
                return this.field_821;
        }
    }

    public int describeContents() {
        class_863 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof class_273)) {
            return false;
        } else if(this == var1) {
            return true;
        } else {
            class_273 var2 = (class_273)var1;
            Iterator var3 = amb.values().iterator();

            while(var3.hasNext()) {
                class_268.class_1299 var4 = (class_268.class_1299)var3.next();
                if(this.method_1691(var4)) {
                    if(!var2.method_1691(var4)) {
                        return false;
                    }

                    if(!this.method_1692(var4).equals(var2.method_1692(var4))) {
                        return false;
                    }
                } else if(var2.method_1691(var4)) {
                    return false;
                }
            }

            return true;
        }
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1725();
    }

    public String getId() {
        return this.field_819;
    }

    public ItemScope getResult() {
        return this.amX;
    }

    public String getStartDate() {
        return this.amP;
    }

    public ItemScope getTarget() {
        return this.amY;
    }

    public String getType() {
        return this.field_821;
    }

    public boolean hasId() {
        return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.amc.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.amc.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.amc.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.amc.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        Iterator var1 = amb.values().iterator();

        int var2;
        int var4;
        for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_268.class_1299 var3 = (class_268.class_1299)var1.next();
            if(this.method_1691(var3)) {
                var4 = var2 + var3.method_3882() + this.method_1692(var3).hashCode();
            } else {
                var4 = var2;
            }
        }

        return var2;
    }

    // $FF: renamed from: hf () java.util.HashMap
    public HashMap<String, class_268.class_1299<?, ?>> method_1697() {
        return amb;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: ns () com.google.android.gms.internal.nw
    public class_273 method_1725() {
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_863 var10000 = CREATOR;
        class_863.method_4522(this, var1, var2);
    }
}
