package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_352;
import com.google.android.gms.internal.class_353;
import com.google.android.gms.internal.class_355;
import com.google.android.gms.internal.ji;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.jm
public class class_354 implements SafeParcelable {
    public static final class_353 CREATOR = new class_353();
    // $FF: renamed from: BR int
    private final int field_1212;
    // $FF: renamed from: MI java.util.HashMap
    private final HashMap<String, HashMap<String, class_268.class_1299<?, ?>>> field_1213;
    // $FF: renamed from: MJ java.util.ArrayList
    private final ArrayList<class_354.class_1756> field_1214;
    // $FF: renamed from: MK java.lang.String
    private final String field_1215;

    class_354(int var1, ArrayList<class_354.class_1756> var2, String var3) {
        this.field_1212 = var1;
        this.field_1214 = null;
        this.field_1213 = method_2356(var2);
        this.field_1215 = (String)class_1090.method_5685(var3);
        this.method_2360();
    }

    public class_354(Class<? extends ji> var1) {
        this.field_1212 = 1;
        this.field_1214 = null;
        this.field_1213 = new HashMap();
        this.field_1215 = var1.getCanonicalName();
    }

    // $FF: renamed from: c (java.util.ArrayList) java.util.HashMap
    private static HashMap<String, HashMap<String, class_268.class_1299<?, ?>>> method_2356(ArrayList<class_354.class_1756> var0) {
        HashMap var1 = new HashMap();
        int var2 = var0.size();

        for(int var3 = 0; var3 < var2; ++var3) {
            class_354.class_1756 var4 = (class_354.class_1756)var0.get(var3);
            var1.put(var4.className, var4.method_5568());
        }

        return var1;
    }

    // $FF: renamed from: a (java.lang.Class, java.util.HashMap) void
    public void method_2357(Class<? extends ji> var1, HashMap<String, class_268.class_1299<?, ?>> var2) {
        this.field_1213.put(var1.getCanonicalName(), var2);
    }

    // $FF: renamed from: b (java.lang.Class) boolean
    public boolean method_2358(Class<? extends ji> var1) {
        return this.field_1213.containsKey(var1.getCanonicalName());
    }

    // $FF: renamed from: be (java.lang.String) java.util.HashMap
    public HashMap<String, class_268.class_1299<?, ?>> method_2359(String var1) {
        return (HashMap)this.field_1213.get(var1);
    }

    public int describeContents() {
        class_353 var10000 = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.field_1212;
    }

    // $FF: renamed from: hs () void
    public void method_2360() {
        Iterator var1 = this.field_1213.keySet().iterator();

        while(var1.hasNext()) {
            String var2 = (String)var1.next();
            HashMap var3 = (HashMap)this.field_1213.get(var2);
            Iterator var4 = var3.keySet().iterator();

            while(var4.hasNext()) {
                ((class_268.class_1299)var3.get((String)var4.next())).method_3875(this);
            }
        }

    }

    // $FF: renamed from: ht () void
    public void method_2361() {
        Iterator var1 = this.field_1213.keySet().iterator();

        while(var1.hasNext()) {
            String var2 = (String)var1.next();
            HashMap var3 = (HashMap)this.field_1213.get(var2);
            HashMap var4 = new HashMap();
            Iterator var5 = var3.keySet().iterator();

            while(var5.hasNext()) {
                String var7 = (String)var5.next();
                var4.put(var7, ((class_268.class_1299)var3.get(var7)).method_3878());
            }

            this.field_1213.put(var2, var4);
        }

    }

    // $FF: renamed from: hu () java.util.ArrayList
    ArrayList<class_354.class_1756> method_2362() {
        ArrayList var1 = new ArrayList();
        Iterator var2 = this.field_1213.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.add(new class_354.class_1756(var3, (HashMap)this.field_1213.get(var3)));
        }

        return var1;
    }

    // $FF: renamed from: hv () java.lang.String
    public String method_2363() {
        return this.field_1215;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        Iterator var2 = this.field_1213.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.append(var3).append(":\n");
            HashMap var5 = (HashMap)this.field_1213.get(var3);
            Iterator var6 = var5.keySet().iterator();

            while(var6.hasNext()) {
                String var7 = (String)var6.next();
                var1.append("  ").append(var7).append(": ");
                var1.append(var5.get(var7));
            }
        }

        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_353 var10000 = CREATOR;
        class_353.method_2353(this, var1, var2);
    }

    public static class class_1756 implements SafeParcelable {
        public static final class_352 CREATOR = new class_352();
        // $FF: renamed from: ML java.util.ArrayList
        final ArrayList<class_354.class_1757> field_5072;
        final String className;
        final int versionCode;

        class_1756(int var1, String var2, ArrayList<class_354.class_1757> var3) {
            this.versionCode = var1;
            this.className = var2;
            this.field_5072 = var3;
        }

        class_1756(String var1, HashMap<String, class_268.class_1299<?, ?>> var2) {
            this.versionCode = 1;
            this.className = var1;
            this.field_5072 = method_5567(var2);
        }

        // $FF: renamed from: a (java.util.HashMap) java.util.ArrayList
        private static ArrayList<class_354.class_1757> method_5567(HashMap<String, class_268.class_1299<?, ?>> var0) {
            if(var0 == null) {
                return null;
            } else {
                ArrayList var1 = new ArrayList();
                Iterator var2 = var0.keySet().iterator();

                while(var2.hasNext()) {
                    String var3 = (String)var2.next();
                    var1.add(new class_354.class_1757(var3, (class_268.class_1299)var0.get(var3)));
                }

                return var1;
            }
        }

        public int describeContents() {
            class_352 var10000 = CREATOR;
            return 0;
        }

        // $FF: renamed from: hw () java.util.HashMap
        HashMap<String, class_268.class_1299<?, ?>> method_5568() {
            HashMap var1 = new HashMap();
            int var2 = this.field_5072.size();

            for(int var3 = 0; var3 < var2; ++var3) {
                class_354.class_1757 var4 = (class_354.class_1757)this.field_5072.get(var3);
                var1.put(var4.field_5071, var4.field_5070);
            }

            return var1;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_352 var10000 = CREATOR;
            class_352.method_2349(this, var1, var2);
        }
    }

    public static class class_1757 implements SafeParcelable {
        public static final class_355 CREATOR = new class_355();
        // $FF: renamed from: MM com.google.android.gms.internal.ji$a
        final class_268.class_1299<?, ?> field_5070;
        // $FF: renamed from: fv java.lang.String
        final String field_5071;
        final int versionCode;

        class_1757(int var1, String var2, class_268.class_1299<?, ?> var3) {
            this.versionCode = var1;
            this.field_5071 = var2;
            this.field_5070 = var3;
        }

        class_1757(String var1, class_268.class_1299<?, ?> var2) {
            this.versionCode = 1;
            this.field_5071 = var1;
            this.field_5070 = var2;
        }

        public int describeContents() {
            class_355 var10000 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_355 var10000 = CREATOR;
            class_355.method_2368(this, var1, var2);
        }
    }
}
