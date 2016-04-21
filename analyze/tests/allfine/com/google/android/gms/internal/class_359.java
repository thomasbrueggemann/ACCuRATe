package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_357;
import com.google.android.gms.internal.class_358;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.jf
public final class class_359 implements SafeParcelable, class_268.class_1300<String, Integer> {
    public static final class_358 CREATOR = new class_358();
    // $FF: renamed from: BR int
    private final int field_1318;
    // $FF: renamed from: Mt java.util.HashMap
    private final HashMap<String, Integer> field_1319;
    // $FF: renamed from: Mu java.util.HashMap
    private final HashMap<Integer, String> field_1320;
    // $FF: renamed from: Mv java.util.ArrayList
    private final ArrayList<class_359.class_1382> field_1321;

    public class_359() {
        this.field_1318 = 1;
        this.field_1319 = new HashMap();
        this.field_1320 = new HashMap();
        this.field_1321 = null;
    }

    class_359(int var1, ArrayList<class_359.class_1382> var2) {
        this.field_1318 = var1;
        this.field_1319 = new HashMap();
        this.field_1320 = new HashMap();
        this.field_1321 = null;
        this.method_2380(var2);
    }

    // $FF: renamed from: b (java.util.ArrayList) void
    private void method_2380(ArrayList<class_359.class_1382> var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            class_359.class_1382 var3 = (class_359.class_1382)var2.next();
            this.method_2382(var3.field_2960, var3.field_2961);
        }

    }

    // $FF: renamed from: a (java.lang.Integer) java.lang.String
    public String method_2381(Integer var1) {
        String var2 = (String)this.field_1320.get(var1);
        if(var2 == null && this.field_1319.containsKey("gms_unknown")) {
            var2 = "gms_unknown";
        }

        return var2;
    }

    // $FF: synthetic method
    public Object convertBack(Object var1) {
        return this.method_2381((Integer)var1);
    }

    public int describeContents() {
        class_358 var10000 = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.field_1318;
    }

    // $FF: renamed from: h (java.lang.String, int) com.google.android.gms.internal.jf
    public class_359 method_2382(String var1, int var2) {
        this.field_1319.put(var1, Integer.valueOf(var2));
        this.field_1320.put(Integer.valueOf(var2), var1);
        return this;
    }

    // $FF: renamed from: hc () java.util.ArrayList
    ArrayList<class_359.class_1382> method_2383() {
        ArrayList var1 = new ArrayList();
        Iterator var2 = this.field_1319.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.add(new class_359.class_1382(var3, ((Integer)this.field_1319.get(var3)).intValue()));
        }

        return var1;
    }

    // $FF: renamed from: hd () int
    public int method_378() {
        return 7;
    }

    // $FF: renamed from: he () int
    public int method_379() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_358 var10000 = CREATOR;
        class_358.method_2377(this, var1, var2);
    }

    public static final class class_1382 implements SafeParcelable {
        public static final class_357 CREATOR = new class_357();
        // $FF: renamed from: Mw java.lang.String
        final String field_2960;
        // $FF: renamed from: Mx int
        final int field_2961;
        final int versionCode;

        class_1382(int var1, String var2, int var3) {
            this.versionCode = var1;
            this.field_2960 = var2;
            this.field_2961 = var3;
        }

        class_1382(String var1, int var2) {
            this.versionCode = 1;
            this.field_2960 = var1;
            this.field_2961 = var2;
        }

        public int describeContents() {
            class_357 var10000 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_357 var10000 = CREATOR;
            class_357.method_2374(this, var1, var2);
        }
    }
}
