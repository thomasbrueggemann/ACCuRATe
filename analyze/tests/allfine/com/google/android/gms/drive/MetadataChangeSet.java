package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_853;
import com.google.android.gms.internal.class_855;
import java.util.Date;

public final class MetadataChangeSet {
    // $FF: renamed from: Nt com.google.android.gms.drive.MetadataChangeSet
    public static final MetadataChangeSet field_1908 = new MetadataChangeSet(MetadataBundle.method_2099());
    // $FF: renamed from: Nu com.google.android.gms.drive.metadata.internal.MetadataBundle
    private final MetadataBundle field_1909;

    public MetadataChangeSet(MetadataBundle var1) {
        this.field_1909 = MetadataBundle.method_2098(var1);
    }

    public String getDescription() {
        return (String)this.field_1909.method_2100(class_855.field_4163);
    }

    public String getIndexableText() {
        return (String)this.field_1909.method_2100(class_855.field_4168);
    }

    public Date getLastViewedByMeDate() {
        return (Date)this.field_1909.method_2100(class_853.field_4156);
    }

    public String getMimeType() {
        return (String)this.field_1909.method_2100(class_855.field_4177);
    }

    public String getTitle() {
        return (String)this.field_1909.method_2100(class_855.field_4186);
    }

    // $FF: renamed from: hS () com.google.android.gms.drive.metadata.internal.MetadataBundle
    public MetadataBundle method_2945() {
        return this.field_1909;
    }

    public Boolean isPinned() {
        return (Boolean)this.field_1909.method_2100(class_855.field_4172);
    }

    public Boolean isStarred() {
        return (Boolean)this.field_1909.method_2100(class_855.field_4184);
    }

    public Boolean isViewed() {
        return (Boolean)this.field_1909.method_2100(class_855.field_4176);
    }

    public static class Builder {
        // $FF: renamed from: Nu com.google.android.gms.drive.metadata.internal.MetadataBundle
        private final MetadataBundle field_2048 = MetadataBundle.method_2099();
        // $FF: renamed from: Nv com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a
        private AppVisibleCustomProperties.class_1375 field_2049;

        public MetadataChangeSet build() {
            if(this.field_2049 != null) {
                this.field_2048.method_2101(class_855.field_4162, this.field_2049.method_5629());
            }

            return new MetadataChangeSet(this.field_2048);
        }

        public MetadataChangeSet.Builder setDescription(String var1) {
            this.field_2048.method_2101(class_855.field_4163, var1);
            return this;
        }

        public MetadataChangeSet.Builder setIndexableText(String var1) {
            this.field_2048.method_2101(class_855.field_4168, var1);
            return this;
        }

        public MetadataChangeSet.Builder setLastViewedByMeDate(Date var1) {
            this.field_2048.method_2101(class_853.field_4156, var1);
            return this;
        }

        public MetadataChangeSet.Builder setMimeType(String var1) {
            this.field_2048.method_2101(class_855.field_4177, var1);
            return this;
        }

        public MetadataChangeSet.Builder setPinned(boolean var1) {
            this.field_2048.method_2101(class_855.field_4172, Boolean.valueOf(var1));
            return this;
        }

        public MetadataChangeSet.Builder setStarred(boolean var1) {
            this.field_2048.method_2101(class_855.field_4184, Boolean.valueOf(var1));
            return this;
        }

        public MetadataChangeSet.Builder setTitle(String var1) {
            this.field_2048.method_2101(class_855.field_4186, var1);
            return this;
        }

        public MetadataChangeSet.Builder setViewed(boolean var1) {
            this.field_2048.method_2101(class_855.field_4176, Boolean.valueOf(var1));
            return this;
        }
    }
}
