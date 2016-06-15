package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.class_709;
import com.google.android.gms.internal.class_710;
import com.google.android.gms.internal.class_714;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
   public static final int CONTENT_AVAILABLE_LOCALLY = 1;
   public static final int CONTENT_NOT_AVAILABLE_LOCALLY;

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   protected abstract <T> T method_1759(MetadataField<T> var1);

   public String getAlternateLink() {
      return (String)this.method_1759(class_714.field_3313);
   }

   public int getContentAvailability() {
      Integer var1 = (Integer)this.method_1759(class_710.field_3294);
      return var1 == null?0:var1.intValue();
   }

   public Date getCreatedDate() {
      return (Date)this.method_1759(class_709.field_3289);
   }

   public Map<CustomPropertyKey, String> getCustomProperties() {
      AppVisibleCustomProperties var1 = (AppVisibleCustomProperties)this.method_1759(class_714.field_3314);
      return var1 == null?Collections.emptyMap():var1.method_3411();
   }

   public String getDescription() {
      return (String)this.method_1759(class_714.field_3315);
   }

   public DriveId getDriveId() {
      return (DriveId)this.method_1759(class_714.field_3312);
   }

   public String getEmbedLink() {
      return (String)this.method_1759(class_714.field_3316);
   }

   public String getFileExtension() {
      return (String)this.method_1759(class_714.field_3317);
   }

   public long getFileSize() {
      return ((Long)this.method_1759(class_714.field_3318)).longValue();
   }

   public Date getLastViewedByMeDate() {
      return (Date)this.method_1759(class_709.field_3290);
   }

   public String getMimeType() {
      return (String)this.method_1759(class_714.field_3296);
   }

   public Date getModifiedByMeDate() {
      return (Date)this.method_1759(class_709.field_3292);
   }

   public Date getModifiedDate() {
      return (Date)this.method_1759(class_709.field_3291);
   }

   public String getOriginalFilename() {
      return (String)this.method_1759(class_714.field_3297);
   }

   public long getQuotaBytesUsed() {
      return ((Long)this.method_1759(class_714.field_3302)).longValue();
   }

   public Date getSharedWithMeDate() {
      return (Date)this.method_1759(class_709.field_3293);
   }

   public String getTitle() {
      return (String)this.method_1759(class_714.field_3305);
   }

   public String getWebContentLink() {
      return (String)this.method_1759(class_714.field_3307);
   }

   public String getWebViewLink() {
      return (String)this.method_1759(class_714.field_3308);
   }

   public boolean isEditable() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3323);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isFolder() {
      return "application/vnd.google-apps.folder".equals(this.getMimeType());
   }

   public boolean isInAppFolder() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3321);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isPinnable() {
      Boolean var1 = (Boolean)this.method_1759(class_710.field_3295);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isPinned() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3324);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isRestricted() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3325);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isShared() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3326);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isStarred() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3303);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isTrashed() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3306);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isViewed() {
      Boolean var1 = (Boolean)this.method_1759(class_714.field_3328);
      return var1 == null?false:var1.booleanValue();
   }
}
