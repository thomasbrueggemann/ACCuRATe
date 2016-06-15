package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.class_709;
import com.google.android.gms.internal.class_710;
import com.google.android.gms.internal.class_714;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.e
public final class class_878 {
   // $FF: renamed from: Rh java.util.Map
   private static Map<String, MetadataField<?>> field_3788 = new HashMap();

   static {
      method_4946(class_714.field_3312);
      method_4946(class_714.field_3305);
      method_4946(class_714.field_3296);
      method_4946(class_714.field_3303);
      method_4946(class_714.field_3306);
      method_4946(class_714.field_3323);
      method_4946(class_714.field_3324);
      method_4946(class_714.field_3321);
      method_4946(class_714.field_3326);
      method_4946(class_714.field_3301);
      method_4946(class_714.field_3313);
      method_4946(class_714.field_3298);
      method_4946(class_714.field_3315);
      method_4946(class_714.field_3322);
      method_4946(class_714.field_3316);
      method_4946(class_714.field_3317);
      method_4946(class_714.field_3318);
      method_4946(class_714.field_3328);
      method_4946(class_714.field_3325);
      method_4946(class_714.field_3297);
      method_4946(class_714.field_3299);
      method_4946(class_714.field_3300);
      method_4946(class_714.field_3302);
      method_4946(class_714.field_3307);
      method_4946(class_714.field_3308);
      method_4946(class_714.field_3320);
      method_4946(class_714.field_3319);
      method_4946(class_714.field_3304);
      method_4946(class_714.field_3327);
      method_4946(class_714.field_3314);
      method_4946(class_714.field_3309);
      method_4946(class_714.field_3310);
      method_4946(class_714.field_3311);
      method_4946(class_709.field_3289);
      method_4946(class_709.field_3291);
      method_4946(class_709.field_3292);
      method_4946(class_709.field_3293);
      method_4946(class_709.field_3290);
      method_4946(class_710.field_3294);
      method_4946(class_710.field_3295);
   }

   // $FF: renamed from: b (com.google.android.gms.drive.metadata.MetadataField) void
   private static void method_4946(MetadataField<?> var0) {
      if(field_3788.containsKey(var0.getName())) {
         throw new IllegalArgumentException("Duplicate field name registered: " + var0.getName());
      } else {
         field_3788.put(var0.getName(), var0);
      }
   }

   // $FF: renamed from: bm (java.lang.String) com.google.android.gms.drive.metadata.MetadataField
   public static MetadataField<?> method_4947(String var0) {
      return (MetadataField)field_3788.get(var0);
   }

   // $FF: renamed from: iY () java.util.Collection
   public static Collection<MetadataField<?>> method_4948() {
      return Collections.unmodifiableCollection(field_3788.values());
   }
}
