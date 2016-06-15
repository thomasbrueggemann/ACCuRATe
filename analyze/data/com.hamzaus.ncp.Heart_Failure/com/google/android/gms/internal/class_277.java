package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.d;
import java.util.Date;

// $FF: renamed from: com.google.android.gms.internal.it
public class class_277 {
   // $FF: renamed from: Kt com.google.android.gms.internal.it$a
   public static final class_277.class_837 field_941 = new class_277.class_837("created", 4100000);
   // $FF: renamed from: Ku com.google.android.gms.internal.it$b
   public static final class_277.class_836 field_942 = new class_277.class_836("lastOpenedTime", 4300000);
   // $FF: renamed from: Kv com.google.android.gms.internal.it$d
   public static final class_277.class_834 field_943 = new class_277.class_834("modified", 4100000);
   // $FF: renamed from: Kw com.google.android.gms.internal.it$c
   public static final class_277.class_835 field_944 = new class_277.class_835("modifiedByMe", 4100000);
   // $FF: renamed from: Kx com.google.android.gms.internal.it$e
   public static final class_277.class_838 field_945 = new class_277.class_838("sharedWithMe", 4100000);

   public static class class_837 extends d implements SortableMetadataField<Date> {
      public class_837(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_836 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public class_836(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_835 extends d implements SortableMetadataField<Date> {
      public class_835(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_834 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public class_834(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_838 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public class_838(String var1, int var2) {
         super(var1, var2);
      }
   }
}
