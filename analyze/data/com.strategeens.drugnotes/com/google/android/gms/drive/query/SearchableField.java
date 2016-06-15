package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.class_709;
import com.google.android.gms.internal.class_714;
import java.util.Date;

public class SearchableField {
   public static final SearchableMetadataField<Boolean> IS_PINNED;
   public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
   public static final SearchableMetadataField<String> MIME_TYPE;
   public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
   public static final SearchableCollectionMetadataField<DriveId> PARENTS;
   public static final SearchableMetadataField<Boolean> STARRED;
   // $FF: renamed from: Sd com.google.android.gms.drive.metadata.SearchableOrderedMetadataField
   public static final SearchableOrderedMetadataField<Date> field_2771;
   // $FF: renamed from: Se com.google.android.gms.drive.metadata.SearchableMetadataField
   public static final SearchableMetadataField<AppVisibleCustomProperties> field_2772;
   public static final SearchableMetadataField<String> TITLE;
   public static final SearchableMetadataField<Boolean> TRASHED;

   static {
      TITLE = class_714.field_3305;
      MIME_TYPE = class_714.field_3296;
      TRASHED = class_714.field_3306;
      PARENTS = class_714.field_3301;
      field_2771 = class_709.field_3293;
      STARRED = class_714.field_3303;
      MODIFIED_DATE = class_709.field_3291;
      LAST_VIEWED_BY_ME = class_709.field_3290;
      IS_PINNED = class_714.field_3324;
      field_2772 = class_714.field_3314;
   }
}
