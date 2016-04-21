package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.class_852;
import com.google.android.gms.internal.class_853;
import com.google.android.gms.internal.class_855;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.e
public final class class_963 {
    // $FF: renamed from: PK java.util.Map
    private static Map<String, MetadataField<?>> field_4529 = new HashMap();

    static {
        method_5095(class_855.field_4160);
        method_5095(class_855.field_4186);
        method_5095(class_855.field_4177);
        method_5095(class_855.field_4184);
        method_5095(class_855.field_4187);
        method_5095(class_855.field_4171);
        method_5095(class_855.field_4172);
        method_5095(class_855.field_4169);
        method_5095(class_855.field_4174);
        method_5095(class_855.field_4182);
        method_5095(class_855.field_4161);
        method_5095(class_855.field_4179);
        method_5095(class_855.field_4163);
        method_5095(class_855.field_4170);
        method_5095(class_855.field_4164);
        method_5095(class_855.field_4165);
        method_5095(class_855.field_4166);
        method_5095(class_855.field_4176);
        method_5095(class_855.field_4173);
        method_5095(class_855.field_4178);
        method_5095(class_855.field_4180);
        method_5095(class_855.field_4181);
        method_5095(class_855.field_4183);
        method_5095(class_855.field_4188);
        method_5095(class_855.field_4189);
        method_5095(class_855.field_4168);
        method_5095(class_855.field_4167);
        method_5095(class_855.field_4185);
        method_5095(class_855.field_4175);
        method_5095(class_855.field_4162);
        method_5095(class_855.field_4190);
        method_5095(class_855.field_4191);
        method_5095(class_855.field_4192);
        method_5095(class_853.field_4155);
        method_5095(class_853.field_4157);
        method_5095(class_853.field_4158);
        method_5095(class_853.field_4159);
        method_5095(class_853.field_4156);
        method_5095(class_852.field_4154);
        method_5095(class_852.field_4153);
    }

    // $FF: renamed from: b (com.google.android.gms.drive.metadata.MetadataField) void
    private static void method_5095(MetadataField<?> var0) {
        if(field_4529.containsKey(var0.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + var0.getName());
        } else {
            field_4529.put(var0.getName(), var0);
        }
    }

    // $FF: renamed from: bj (java.lang.String) com.google.android.gms.drive.metadata.MetadataField
    public static MetadataField<?> method_5096(String var0) {
        return (MetadataField)field_4529.get(var0);
    }

    // $FF: renamed from: in () java.util.Collection
    public static Collection<MetadataField<?>> method_5097() {
        return Collections.unmodifiableCollection(field_4529.values());
    }
}
