package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.class_853;
import com.google.android.gms.internal.class_855;
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
        TITLE = class_855.field_4186;
        CREATED_DATE = class_853.field_4155;
        MODIFIED_DATE = class_853.field_4157;
        MODIFIED_BY_ME_DATE = class_853.field_4158;
        LAST_VIEWED_BY_ME = class_853.field_4156;
        SHARED_WITH_ME_DATE = class_853.field_4159;
        QUOTA_USED = class_855.field_4183;
    }
}
