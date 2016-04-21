package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.class_647;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.f;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.query.c
public class class_947 implements f<String> {
    // $FF: renamed from: a (com.google.android.gms.drive.metadata.b, java.lang.Object) java.lang.String
    public <T> String method_4945(b<T> var1, T var2) {
        Object[] var3 = new Object[] {var1.getName(), var2};
        return String.format("contains(%s,%s)", var3);
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.Operator, com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.String
    public <T> String method_4946(Operator var1, MetadataField<T> var2, T var3) {
        Object[] var4 = new Object[] {var1.getTag(), var2.getName(), var3};
        return String.format("cmp(%s,%s,%s)", var4);
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.Operator, java.util.List) java.lang.String
    public String method_4947(Operator var1, List<String> var2) {
        StringBuilder var3 = new StringBuilder(var1.getTag() + "(");
        Iterator var4 = var2.iterator();

        for(String var5 = ""; var4.hasNext(); var5 = ",") {
            String var6 = (String)var4.next();
            var3.append(var5);
            var3.append(var6);
        }

        return var3.append(")").toString();
    }

    // $FF: renamed from: b (com.google.android.gms.drive.metadata.b, java.lang.Object) java.lang.Object
    // $FF: synthetic method
    public Object method_881(class_647 var1, Object var2) {
        return this.method_4945(var1, var2);
    }

    // $FF: renamed from: b (com.google.android.gms.drive.query.internal.Operator, com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.Object
    // $FF: synthetic method
    public Object method_882(Operator var1, MetadataField var2, Object var3) {
        return this.method_4946(var1, var2, var3);
    }

    // $FF: renamed from: b (com.google.android.gms.drive.query.internal.Operator, java.util.List) java.lang.Object
    // $FF: synthetic method
    public Object method_883(Operator var1, List var2) {
        return this.method_4947(var1, var2);
    }

    // $FF: renamed from: bn (java.lang.String) java.lang.String
    public String method_4948(String var1) {
        return String.format("not(%s)", new Object[] {var1});
    }

    // $FF: renamed from: c (com.google.android.gms.drive.metadata.MetadataField) java.lang.String
    public String method_4949(MetadataField<?> var1) {
        Object[] var2 = new Object[] {var1.getName()};
        return String.format("fieldOnly(%s)", var2);
    }

    // $FF: renamed from: c (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.String
    public <T> String method_4950(MetadataField<T> var1, T var2) {
        Object[] var3 = new Object[] {var1.getName(), var2};
        return String.format("has(%s,%s)", var3);
    }

    // $FF: renamed from: d (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
    // $FF: synthetic method
    public Object method_884(MetadataField var1) {
        return this.method_4949(var1);
    }

    // $FF: renamed from: d (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.Object
    // $FF: synthetic method
    public Object method_885(MetadataField var1, Object var2) {
        return this.method_4950(var1, var2);
    }

    // $FF: renamed from: ir () java.lang.String
    public String method_4951() {
        return "all()";
    }

    // $FF: renamed from: is () java.lang.Object
    // $FF: synthetic method
    public Object method_886() {
        return this.method_4951();
    }

    // $FF: renamed from: j (java.lang.Object) java.lang.Object
    // $FF: synthetic method
    public Object method_887(Object var1) {
        return this.method_4948((String)var1);
    }
}
