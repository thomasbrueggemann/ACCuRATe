package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.internal.lo
public class class_544 extends j<AppVisibleCustomProperties> {
   public class_544(int var1) {
      super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[]{"customPropertiesExtra"}), var1);
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_3281(DataHolder var1, int var2, int var3) {
      return this.method_3308(var1, var2, var3);
   }

   // $FF: renamed from: l (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
   protected AppVisibleCustomProperties method_3308(DataHolder var1, int var2, int var3) {
      return (AppVisibleCustomProperties)var1.method_5837().getSparseParcelableArray("customPropertiesExtra").get(var2, AppVisibleCustomProperties.field_2602);
   }
}
