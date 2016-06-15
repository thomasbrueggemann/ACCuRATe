package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.lq
public class class_545 extends j<DriveId> {
   // $FF: renamed from: RV com.google.android.gms.internal.lq
   public static final class_545 field_2522 = new class_545();

   private class_545() {
      super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_3281(DataHolder var1, int var2, int var3) {
      return this.method_3309(var1, var2, var3);
   }

   // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.drive.DriveId
   protected DriveId method_3309(DataHolder var1, int var2, int var3) {
      long var4 = var1.method_5837().getLong("dbInstanceId");
      String var6 = var1.method_5831("resourceId", var2, var3);
      if(var6 != null && var6.startsWith("generated-android-")) {
         var6 = null;
      }

      return new DriveId(var6, Long.valueOf(var1.method_5826("sqlId", var2, var3)).longValue(), var4);
   }
}
