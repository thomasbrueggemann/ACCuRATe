package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.d;
import java.util.Date;

// $FF: renamed from: com.google.android.gms.internal.lp
public class class_709 {
   // $FF: renamed from: RQ com.google.android.gms.internal.lp$a
   public static final class_709.class_1296 field_3289 = new class_709.class_1296("created", 4100000);
   // $FF: renamed from: RR com.google.android.gms.internal.lp$b
   public static final class_709.class_1297 field_3290 = new class_709.class_1297("lastOpenedTime", 4300000);
   // $FF: renamed from: RS com.google.android.gms.internal.lp$d
   public static final class_709.class_1299 field_3291 = new class_709.class_1299("modified", 4100000);
   // $FF: renamed from: RT com.google.android.gms.internal.lp$c
   public static final class_709.class_1298 field_3292 = new class_709.class_1298("modifiedByMe", 4100000);
   // $FF: renamed from: RU com.google.android.gms.internal.lp$e
   public static final class_709.class_1300 field_3293 = new class_709.class_1300("sharedWithMe", 4100000);

   public static class class_1296 extends d implements SortableMetadataField<Date> {
      public class_1296(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1297 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public class_1297(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1298 extends d implements SortableMetadataField<Date> {
      public class_1298(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1299 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public class_1299(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1300 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public class_1300(String var1, int var2) {
         super(var1, var2);
      }
   }
}
