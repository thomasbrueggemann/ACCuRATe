package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.class_274;
import com.google.android.gms.internal.class_276;
import com.google.android.gms.internal.class_277;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.e
public final class class_681 {
   // $FF: renamed from: JO java.util.Map
   private static Map<String, MetadataField<?>> field_3663 = new HashMap();

   static {
      method_3962(class_276.field_912);
      method_3962(class_276.field_936);
      method_3962(class_276.field_929);
      method_3962(class_276.field_934);
      method_3962(class_276.field_937);
      method_3962(class_276.field_923);
      method_3962(class_276.field_924);
      method_3962(class_276.field_921);
      method_3962(class_276.field_926);
      method_3962(class_276.field_932);
      method_3962(class_276.field_913);
      method_3962(class_276.field_931);
      method_3962(class_276.field_915);
      method_3962(class_276.field_922);
      method_3962(class_276.field_916);
      method_3962(class_276.field_917);
      method_3962(class_276.field_918);
      method_3962(class_276.field_928);
      method_3962(class_276.field_925);
      method_3962(class_276.field_930);
      method_3962(class_276.field_933);
      method_3962(class_276.field_938);
      method_3962(class_276.field_939);
      method_3962(class_276.field_920);
      method_3962(class_276.field_919);
      method_3962(class_276.field_935);
      method_3962(class_276.field_927);
      method_3962(class_276.field_914);
      method_3962(class_276.field_940);
      method_3962(class_277.field_941);
      method_3962(class_277.field_943);
      method_3962(class_277.field_944);
      method_3962(class_277.field_945);
      method_3962(class_277.field_942);
      method_3962(class_274.field_911);
      method_3962(class_274.field_910);
   }

   // $FF: renamed from: aN (java.lang.String) com.google.android.gms.drive.metadata.MetadataField
   public static MetadataField<?> method_3961(String var0) {
      return (MetadataField)field_3663.get(var0);
   }

   // $FF: renamed from: b (com.google.android.gms.drive.metadata.MetadataField) void
   private static void method_3962(MetadataField<?> var0) {
      if(field_3663.containsKey(var0.getName())) {
         throw new IllegalArgumentException("Duplicate field name registered: " + var0.getName());
      } else {
         field_3663.put(var0.getName(), var0);
      }
   }

   // $FF: renamed from: gz () java.util.Collection
   public static Collection<MetadataField<?>> method_3963() {
      return Collections.unmodifiableCollection(field_3663.values());
   }
}
