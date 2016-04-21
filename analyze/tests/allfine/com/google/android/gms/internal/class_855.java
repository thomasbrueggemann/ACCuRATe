package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.data.class_1056;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.class_648;
import com.google.android.gms.drive.metadata.internal.class_650;
import com.google.android.gms.drive.metadata.internal.class_651;
import com.google.android.gms.drive.metadata.internal.class_652;
import com.google.android.gms.drive.metadata.internal.class_653;
import com.google.android.gms.drive.metadata.internal.class_654;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.l;
import com.google.android.gms.internal.class_655;
import com.google.android.gms.internal.ke;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.internal.kd
public class class_855 {
    // $FF: renamed from: PM com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<DriveId> field_4160;
    // $FF: renamed from: PN com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4161;
    // $FF: renamed from: PO com.google.android.gms.internal.kd$a
    public static final class_855.class_1700 field_4162;
    // $FF: renamed from: PP com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4163;
    // $FF: renamed from: PQ com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4164;
    // $FF: renamed from: PR com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4165;
    // $FF: renamed from: PS com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Long> field_4166;
    // $FF: renamed from: PT com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4167;
    // $FF: renamed from: PU com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4168;
    // $FF: renamed from: PV com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4169;
    // $FF: renamed from: PW com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4170;
    // $FF: renamed from: PX com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4171;
    // $FF: renamed from: PY com.google.android.gms.internal.kd$b
    public static final class_855.class_1701 field_4172;
    // $FF: renamed from: PZ com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4173;
    // $FF: renamed from: Qa com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4174;
    // $FF: renamed from: Qb com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4175;
    // $FF: renamed from: Qc com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<Boolean> field_4176;
    // $FF: renamed from: Qd com.google.android.gms.internal.kd$c
    public static final class_855.class_1716 field_4177;
    // $FF: renamed from: Qe com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4178;
    // $FF: renamed from: Qf com.google.android.gms.drive.metadata.b
    public static final b<String> field_4179;
    // $FF: renamed from: Qg com.google.android.gms.drive.metadata.internal.m
    public static final class_654 field_4180;
    // $FF: renamed from: Qh com.google.android.gms.drive.metadata.internal.m
    public static final class_654 field_4181;
    // $FF: renamed from: Qi com.google.android.gms.internal.kd$d
    public static final class_855.class_1717 field_4182;
    // $FF: renamed from: Qj com.google.android.gms.internal.kd$e
    public static final class_855.class_1714 field_4183;
    // $FF: renamed from: Qk com.google.android.gms.internal.kd$f
    public static final class_855.class_1715 field_4184;
    // $FF: renamed from: Ql com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<a> field_4185;
    // $FF: renamed from: Qm com.google.android.gms.internal.kd$g
    public static final class_855.class_1712 field_4186;
    // $FF: renamed from: Qn com.google.android.gms.internal.kd$h
    public static final class_855.class_1713 field_4187;
    // $FF: renamed from: Qo com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4188;
    // $FF: renamed from: Qp com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4189;
    // $FF: renamed from: Qq com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4190;
    // $FF: renamed from: Qr com.google.android.gms.drive.metadata.internal.b
    public static final class_652 field_4191;
    // $FF: renamed from: Qs com.google.android.gms.drive.metadata.MetadataField
    public static final MetadataField<String> field_4192;

    static {
        field_4160 = class_655.field_3192;
        field_4161 = new class_651("alternateLink", 4300000);
        field_4162 = new class_855.class_1700(5000000);
        field_4163 = new class_651("description", 4300000);
        field_4164 = new class_651("embedLink", 4300000);
        field_4165 = new class_651("fileExtension", 4300000);
        field_4166 = new class_650("fileSize", 4300000);
        field_4167 = new class_652("hasThumbnail", 4300000);
        field_4168 = new class_651("indexableText", 4300000);
        field_4169 = new class_652("isAppData", 4300000);
        field_4170 = new class_652("isCopyable", 4300000);
        field_4171 = new class_652("isEditable", 4100000);
        field_4172 = new class_855.class_1701("isPinned", 4100000);
        field_4173 = new class_652("isRestricted", 4300000);
        field_4174 = new class_652("isShared", 4300000);
        field_4175 = new class_652("isTrashable", 4400000);
        field_4176 = new class_652("isViewed", 4300000);
        field_4177 = new class_855.class_1716("mimeType", 4100000);
        field_4178 = new class_651("originalFilename", 4300000);
        field_4179 = new class_648("ownerNames", 4300000);
        field_4180 = new class_654("lastModifyingUser", 6000000);
        field_4181 = new class_654("sharingUser", 6000000);
        field_4182 = new class_855.class_1717("parents", 4100000);
        field_4183 = new class_855.class_1714("quotaBytesUsed", 4300000);
        field_4184 = new class_855.class_1715("starred", 4100000);
        field_4185 = new class_653("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
            // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
            // $FF: synthetic method
            protected Object method_3645(DataHolder var1, int var2, int var3) {
                return this.method_3673(var1, var2, var3);
            }

            // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.common.data.a
            protected class_1056 method_3673(DataHolder var1, int var2, int var3) {
                throw new IllegalStateException("Thumbnail field is write only");
            }
        };
        field_4186 = new class_855.class_1712("title", 4100000);
        field_4187 = new class_855.class_1713("trashed", 4100000);
        field_4188 = new class_651("webContentLink", 4300000);
        field_4189 = new class_651("webViewLink", 4300000);
        field_4190 = new class_651("uniqueIdentifier", 5000000);
        field_4191 = new class_652("writersCanShare", 6000000);
        field_4192 = new class_651("role", 6000000);
    }

    public static class class_1700 extends ke implements SearchableMetadataField<AppVisibleCustomProperties> {
        public class_1700(int var1) {
            super(var1);
        }
    }

    public static class class_1701 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
        public class_1701(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1716 extends l implements SearchableMetadataField<String> {
        public class_1716(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1717 extends i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public class_1717(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1714 extends g implements SortableMetadataField<Long> {
        public class_1714(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1715 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
        public class_1715(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1712 extends l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public class_1712(String var1, int var2) {
            super(var1, var2);
        }
    }

    public static class class_1713 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
        public class_1713(String var1, int var2) {
            super(var1, var2);
        }

        // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
        // $FF: synthetic method
        protected Object method_3645(DataHolder var1, int var2, int var3) {
            return this.method_3663(var1, var2, var3);
        }

        // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Boolean
        protected Boolean method_3663(DataHolder var1, int var2, int var3) {
            boolean var4;
            if(var1.method_5988(this.getName(), var2, var3) != 0) {
                var4 = true;
            } else {
                var4 = false;
            }

            return Boolean.valueOf(var4);
        }
    }
}
