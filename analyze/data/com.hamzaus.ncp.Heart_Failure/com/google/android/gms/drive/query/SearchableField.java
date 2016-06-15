package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.class_276;
import com.google.android.gms.internal.class_277;
import java.util.Date;

public class SearchableField {
   public static final SearchableMetadataField<Boolean> IS_PINNED;
   // $FF: renamed from: KF com.google.android.gms.drive.metadata.SearchableOrderedMetadataField
   public static final SearchableOrderedMetadataField<Date> field_2914;
   // $FF: renamed from: KG com.google.android.gms.drive.metadata.SearchableMetadataField
   public static final SearchableMetadataField<AppVisibleCustomProperties> field_2915;
   public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
   public static final SearchableMetadataField<String> MIME_TYPE;
   public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
   public static final SearchableCollectionMetadataField<DriveId> PARENTS;
   public static final SearchableMetadataField<Boolean> STARRED;
   public static final SearchableMetadataField<String> TITLE;
   public static final SearchableMetadataField<Boolean> TRASHED;

   static {
      TITLE = class_276.field_936;
      MIME_TYPE = class_276.field_929;
      TRASHED = class_276.field_937;
      PARENTS = class_276.field_932;
      field_2914 = class_277.field_945;
      STARRED = class_276.field_934;
      MODIFIED_DATE = class_277.field_943;
      LAST_VIEWED_BY_ME = class_277.field_942;
      IS_PINNED = class_276.field_924;
      field_2915 = class_276.field_914;
   }
}
