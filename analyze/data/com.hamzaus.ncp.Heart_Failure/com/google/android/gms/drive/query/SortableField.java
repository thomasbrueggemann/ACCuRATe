package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.class_276;
import com.google.android.gms.internal.class_277;
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
      TITLE = class_276.field_936;
      CREATED_DATE = class_277.field_941;
      MODIFIED_DATE = class_277.field_943;
      MODIFIED_BY_ME_DATE = class_277.field_944;
      LAST_VIEWED_BY_ME = class_277.field_942;
      SHARED_WITH_ME_DATE = class_277.field_945;
      QUOTA_USED = class_276.field_933;
   }
}
