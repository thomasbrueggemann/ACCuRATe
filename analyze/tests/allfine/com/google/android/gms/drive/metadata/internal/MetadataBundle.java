package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.class_1056;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_266;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.class_962;
import com.google.android.gms.drive.metadata.internal.class_963;
import com.google.android.gms.internal.class_855;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new class_962();
    // $FF: renamed from: BR int
    final int field_947;
    // $FF: renamed from: PL android.os.Bundle
    final Bundle field_948;

    MetadataBundle(int var1, Bundle var2) {
        this.field_947 = var1;
        this.field_948 = (Bundle)class_1090.method_5685(var2);
        this.field_948.setClassLoader(this.getClass().getClassLoader());
        ArrayList var3 = new ArrayList();
        Iterator var4 = this.field_948.keySet().iterator();

        while(var4.hasNext()) {
            String var7 = (String)var4.next();
            if(class_963.method_5096(var7) == null) {
                var3.add(var7);
                class_266.method_1686("MetadataBundle", "Ignored unknown metadata field in bundle: " + var7);
            }
        }

        Iterator var5 = var3.iterator();

        while(var5.hasNext()) {
            String var6 = (String)var5.next();
            this.field_948.remove(var6);
        }

    }

    private MetadataBundle(Bundle var1) {
        this(1, var1);
    }

    // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) com.google.android.gms.drive.metadata.internal.MetadataBundle
    public static <T> MetadataBundle method_2097(MetadataField<T> var0, T var1) {
        MetadataBundle var2 = method_2099();
        var2.method_2101(var0, var1);
        return var2;
    }

    // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.MetadataBundle) com.google.android.gms.drive.metadata.internal.MetadataBundle
    public static MetadataBundle method_2098(MetadataBundle var0) {
        return new MetadataBundle(new Bundle(var0.field_948));
    }

    // $FF: renamed from: io () com.google.android.gms.drive.metadata.internal.MetadataBundle
    public static MetadataBundle method_2099() {
        return new MetadataBundle(new Bundle());
    }

    // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
    public <T> T method_2100(MetadataField<T> var1) {
        return var1.method_190(this.field_948);
    }

    // $FF: renamed from: b (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) void
    public <T> void method_2101(MetadataField<T> var1, T var2) {
        if(class_963.method_5096(var1.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + var1.getName());
        } else {
            var1.method_189(var2, this.field_948);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this == var1) {
            return true;
        } else if(!(var1 instanceof MetadataBundle)) {
            return false;
        } else {
            MetadataBundle var2 = (MetadataBundle)var1;
            Set var3 = this.field_948.keySet();
            if(!var3.equals(var2.field_948.keySet())) {
                return false;
            } else {
                Iterator var4 = var3.iterator();

                String var5;
                do {
                    if(!var4.hasNext()) {
                        return true;
                    }

                    var5 = (String)var4.next();
                } while(class_1089.equal(this.field_948.get(var5), var2.field_948.get(var5)));

                return false;
            }
        }
    }

    public int hashCode() {
        Iterator var1 = this.field_948.keySet().iterator();

        int var2;
        String var3;
        for(var2 = 1; var1.hasNext(); var2 = var2 * 31 + this.field_948.get(var3).hashCode()) {
            var3 = (String)var1.next();
        }

        return var2;
    }

    // $FF: renamed from: ip () java.util.Set
    public Set<MetadataField<?>> method_2102() {
        HashSet var1 = new HashSet();
        Iterator var2 = this.field_948.keySet().iterator();

        while(var2.hasNext()) {
            var1.add(class_963.method_5096((String)var2.next()));
        }

        return var1;
    }

    public void setContext(Context var1) {
        class_1056 var2 = (class_1056)this.method_2100(class_855.field_4185);
        if(var2 != null) {
            var2.method_5525(var1.getCacheDir());
        }

    }

    public String toString() {
        return "MetadataBundle [values=" + this.field_948 + "]";
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_962.method_5092(this, var1, var2);
    }
}
