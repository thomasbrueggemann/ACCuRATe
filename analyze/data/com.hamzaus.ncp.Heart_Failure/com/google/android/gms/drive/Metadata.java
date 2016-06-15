package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.class_274;
import com.google.android.gms.internal.class_276;
import com.google.android.gms.internal.class_277;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
   public static final int CONTENT_AVAILABLE_LOCALLY = 1;
   public static final int CONTENT_NOT_AVAILABLE_LOCALLY;

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   protected abstract <T> T method_1415(MetadataField<T> var1);

   public String getAlternateLink() {
      return (String)this.method_1415(class_276.field_913);
   }

   public int getContentAvailability() {
      Integer var1 = (Integer)this.method_1415(class_274.field_911);
      return var1 == null?0:var1.intValue();
   }

   public Date getCreatedDate() {
      return (Date)this.method_1415(class_277.field_941);
   }

   public String getDescription() {
      return (String)this.method_1415(class_276.field_915);
   }

   public DriveId getDriveId() {
      return (DriveId)this.method_1415(class_276.field_912);
   }

   public String getEmbedLink() {
      return (String)this.method_1415(class_276.field_916);
   }

   public String getFileExtension() {
      return (String)this.method_1415(class_276.field_917);
   }

   public long getFileSize() {
      return ((Long)this.method_1415(class_276.field_918)).longValue();
   }

   public Date getLastViewedByMeDate() {
      return (Date)this.method_1415(class_277.field_942);
   }

   public String getMimeType() {
      return (String)this.method_1415(class_276.field_929);
   }

   public Date getModifiedByMeDate() {
      return (Date)this.method_1415(class_277.field_944);
   }

   public Date getModifiedDate() {
      return (Date)this.method_1415(class_277.field_943);
   }

   public String getOriginalFilename() {
      return (String)this.method_1415(class_276.field_930);
   }

   public long getQuotaBytesUsed() {
      return ((Long)this.method_1415(class_276.field_933)).longValue();
   }

   public Date getSharedWithMeDate() {
      return (Date)this.method_1415(class_277.field_945);
   }

   public String getTitle() {
      return (String)this.method_1415(class_276.field_936);
   }

   public String getWebContentLink() {
      return (String)this.method_1415(class_276.field_938);
   }

   public String getWebViewLink() {
      return (String)this.method_1415(class_276.field_939);
   }

   public boolean isEditable() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_923);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isFolder() {
      return "application/vnd.google-apps.folder".equals(this.getMimeType());
   }

   public boolean isInAppFolder() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_921);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isPinnable() {
      Boolean var1 = (Boolean)this.method_1415(class_274.field_910);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isPinned() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_924);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isRestricted() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_925);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isShared() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_926);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isStarred() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_934);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isTrashed() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_937);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isViewed() {
      Boolean var1 = (Boolean)this.method_1415(class_276.field_928);
      return var1 == null?false:var1.booleanValue();
   }
}
