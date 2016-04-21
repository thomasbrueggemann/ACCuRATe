package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.class_852;
import com.google.android.gms.internal.class_853;
import com.google.android.gms.internal.class_855;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY;

    // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
    protected abstract <T> T method_1783(MetadataField<T> var1);

    public String getAlternateLink() {
        return (String)this.method_1783(class_855.field_4161);
    }

    public int getContentAvailability() {
        Integer var1 = (Integer)this.method_1783(class_852.field_4154);
        return var1 == null?0:var1.intValue();
    }

    public Date getCreatedDate() {
        return (Date)this.method_1783(class_853.field_4155);
    }

    public String getDescription() {
        return (String)this.method_1783(class_855.field_4163);
    }

    public DriveId getDriveId() {
        return (DriveId)this.method_1783(class_855.field_4160);
    }

    public String getEmbedLink() {
        return (String)this.method_1783(class_855.field_4164);
    }

    public String getFileExtension() {
        return (String)this.method_1783(class_855.field_4165);
    }

    public long getFileSize() {
        return ((Long)this.method_1783(class_855.field_4166)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date)this.method_1783(class_853.field_4156);
    }

    public String getMimeType() {
        return (String)this.method_1783(class_855.field_4177);
    }

    public Date getModifiedByMeDate() {
        return (Date)this.method_1783(class_853.field_4158);
    }

    public Date getModifiedDate() {
        return (Date)this.method_1783(class_853.field_4157);
    }

    public String getOriginalFilename() {
        return (String)this.method_1783(class_855.field_4178);
    }

    public long getQuotaBytesUsed() {
        return ((Long)this.method_1783(class_855.field_4183)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date)this.method_1783(class_853.field_4159);
    }

    public String getTitle() {
        return (String)this.method_1783(class_855.field_4186);
    }

    public String getWebContentLink() {
        return (String)this.method_1783(class_855.field_4188);
    }

    public String getWebViewLink() {
        return (String)this.method_1783(class_855.field_4189);
    }

    public boolean isEditable() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4171);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isFolder() {
        return "application/vnd.google-apps.folder".equals(this.getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4169);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isPinnable() {
        Boolean var1 = (Boolean)this.method_1783(class_852.field_4153);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isPinned() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4172);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isRestricted() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4173);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isShared() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4174);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isStarred() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4184);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isTrashed() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4187);
        return var1 == null?false:var1.booleanValue();
    }

    public boolean isViewed() {
        Boolean var1 = (Boolean)this.method_1783(class_855.field_4176);
        return var1 == null?false:var1.booleanValue();
    }
}
