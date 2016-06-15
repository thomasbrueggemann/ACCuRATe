package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.class_709;
import com.google.android.gms.internal.class_714;
import java.util.Date;

public class SortableField {
   public static final SortableMetadataField<Date> CREATED_DATE;
   public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
   public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
   public static final SortableMetadataField<Date> MODIFIED_DATE;
   public static final SortableMetadataField<Long> QUOTA_USED;
   public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
   public static final SortableMetadataField<String> TITLE;

   static {
      TITLE = class_714.field_3305;
      CREATED_DATE = class_709.field_3289;
      MODIFIED_DATE = class_709.field_3291;
      MODIFIED_BY_ME_DATE = class_709.field_3292;
      LAST_VIEWED_BY_ME = class_709.field_3290;
      SHARED_WITH_ME_DATE = class_709.field_3293;
      QUOTA_USED = class_714.field_3302;
   }
}
