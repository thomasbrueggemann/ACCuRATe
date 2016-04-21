package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.class_853;
import com.google.android.gms.internal.class_855;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField<String> MIME_TYPE;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS;
    // $FF: renamed from: QG com.google.android.gms.drive.metadata.SearchableOrderedMetadataField
    public static final SearchableOrderedMetadataField<Date> field_3182;
    // $FF: renamed from: QH com.google.android.gms.drive.metadata.SearchableMetadataField
    public static final SearchableMetadataField<AppVisibleCustomProperties> field_3183;
    public static final SearchableMetadataField<Boolean> STARRED;
    public static final SearchableMetadataField<String> TITLE;
    public static final SearchableMetadataField<Boolean> TRASHED;

    static {
        TITLE = class_855.field_4186;
        MIME_TYPE = class_855.field_4177;
        TRASHED = class_855.field_4187;
        PARENTS = class_855.field_4182;
        field_3182 = class_853.field_4159;
        STARRED = class_855.field_4184;
        MODIFIED_DATE = class_853.field_4157;
        LAST_VIEWED_BY_ME = class_853.field_4156;
        IS_PINNED = class_855.field_4172;
        field_3183 = class_855.field_4162;
    }
}
