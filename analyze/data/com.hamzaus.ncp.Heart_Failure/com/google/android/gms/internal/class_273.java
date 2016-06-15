package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.iu
public class class_273 extends j<DriveId> {
   // $FF: renamed from: Ky com.google.android.gms.internal.iu
   public static final class_273 field_909 = new class_273();

   private class_273() {
      super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1848(var1, var2, var3);
   }

   // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.drive.DriveId
   protected DriveId method_1848(DataHolder var1, int var2, int var3) {
      long var4 = var1.method_4563().getLong("dbInstanceId");
      String var6 = var1.method_4560("resourceId", var2, var3);
      if(var6 != null && var6.startsWith("generated-android-")) {
         var6 = null;
      }

      return new DriveId(var6, Long.valueOf(var1.method_4554("sqlId", var2, var3)).longValue(), var4);
   }
}
