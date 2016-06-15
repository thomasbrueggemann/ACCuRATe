package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.drive.query.internal.e
class class_953 {
   // $FF: renamed from: b (com.google.android.gms.drive.metadata.internal.MetadataBundle) com.google.android.gms.drive.metadata.MetadataField
   static MetadataField<?> method_5258(MetadataBundle var0) {
      Set var1 = var0.method_2084();
      if(var1.size() != 1) {
         throw new IllegalArgumentException("bundle should have exactly 1 populated field");
      } else {
         return (MetadataField)var1.iterator().next();
      }
   }
}
