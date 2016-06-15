package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.internal.is
public class class_272 extends j<AppVisibleCustomProperties> {
   public class_272(int var1) {
      super("customFileProperties", Collections.emptyList(), Arrays.asList(new String[]{"customPropertiesExtra"}), var1);
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1847(var1, var2, var3);
   }

   // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
   protected AppVisibleCustomProperties method_1847(DataHolder var1, int var2, int var3) {
      return (AppVisibleCustomProperties)var1.method_4563().getSparseParcelableArray("customPropertiesExtra").get(var2, AppVisibleCustomProperties.field_2785);
   }
}
