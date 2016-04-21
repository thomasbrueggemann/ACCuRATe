package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.d;
import java.util.Date;

// $FF: renamed from: com.google.android.gms.internal.kf
public class class_853 {
    // $FF: renamed from: Qt com.google.android.gms.internal.kf$a
    public static final class_853.class_1465 field_4155 = new class_853.class_1465("created", 4100000);
    // $FF: renamed from: Qu com.google.android.gms.internal.kf$b
    public static final class_853.class_1464 field_4156 = new class_853.class_1464("lastOpenedTime", 4300000);
    // $FF: renamed from: Qv com.google.android.gms.internal.kf$d
    public static final class_853.class_1460 field_4157 = new class_853.class_1460("modified", 4100000);
    // $FF: renamed from: Qw com.google.android.gms.internal.kf$c
    public static final class_853.class_1461 field_4158 = new class_853.class_1461("modifiedByMe", 4100000);
    // $FF: renamed from: Qx com.google.android.gms.internal.kf$e
    public static final class_853.class_1459 field_4159 = new class_853.class_1459("sharedWithMe", 4100000);

    public static class class_1465 extends d implements SortableMetadataField<Date> {
        public class_1465(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1464 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public class_1464(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1461 extends d implements SortableMetadataField<Date> {
        public class_1461(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1460 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public class_1460(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1459 extends d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public class_1459(String var1, int var2) {
            super(var1, var2);
        }
    }
}
