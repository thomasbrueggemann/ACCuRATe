package com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_276;
import com.google.android.gms.internal.class_277;
import java.util.Date;

public final class MetadataChangeSet {
   // $FF: renamed from: HS com.google.android.gms.drive.MetadataChangeSet
   public static final MetadataChangeSet field_1994 = new MetadataChangeSet(MetadataBundle.method_1713());
   // $FF: renamed from: HT com.google.android.gms.drive.metadata.internal.MetadataBundle
   private final MetadataBundle field_1995;

   public MetadataChangeSet(MetadataBundle var1) {
      this.field_1995 = MetadataBundle.method_1712(var1);
   }

   public String getDescription() {
      return (String)this.field_1995.method_1714(class_276.field_915);
   }

   public String getIndexableText() {
      return (String)this.field_1995.method_1714(class_276.field_920);
   }

   public Date getLastViewedByMeDate() {
      return (Date)this.field_1995.method_1714(class_277.field_942);
   }

   public String getMimeType() {
      return (String)this.field_1995.method_1714(class_276.field_929);
   }

   public String getTitle() {
      return (String)this.field_1995.method_1714(class_276.field_936);
   }

   // $FF: renamed from: gh () com.google.android.gms.drive.metadata.internal.MetadataBundle
   public MetadataBundle method_2667() {
      return this.field_1995;
   }

   public Boolean isPinned() {
      return (Boolean)this.field_1995.method_1714(class_276.field_924);
   }

   public Boolean isStarred() {
      return (Boolean)this.field_1995.method_1714(class_276.field_934);
   }

   public Boolean isViewed() {
      return (Boolean)this.field_1995.method_1714(class_276.field_928);
   }

   public static class Builder {
      // $FF: renamed from: HT com.google.android.gms.drive.metadata.internal.MetadataBundle
      private final MetadataBundle field_2047;
      // $FF: renamed from: HU com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a
      private AppVisibleCustomProperties.class_1007 field_2048;
      private final Context mContext;

      public Builder() {
         this((Context)null);
      }

      public Builder(Context var1) {
         this.field_2047 = MetadataBundle.method_1713();
         this.mContext = var1;
      }

      public MetadataChangeSet build() {
         if(this.field_2048 != null) {
            this.field_2047.method_1715(class_276.field_914, this.field_2048.method_4358());
         }

         return new MetadataChangeSet(this.field_2047);
      }

      public MetadataChangeSet.Builder setDescription(String var1) {
         this.field_2047.method_1715(class_276.field_915, var1);
         return this;
      }

      public MetadataChangeSet.Builder setIndexableText(String var1) {
         this.field_2047.method_1715(class_276.field_920, var1);
         return this;
      }

      public MetadataChangeSet.Builder setLastViewedByMeDate(Date var1) {
         this.field_2047.method_1715(class_277.field_942, var1);
         return this;
      }

      public MetadataChangeSet.Builder setMimeType(String var1) {
         this.field_2047.method_1715(class_276.field_929, var1);
         return this;
      }

      public MetadataChangeSet.Builder setPinned(boolean var1) {
         this.field_2047.method_1715(class_276.field_924, Boolean.valueOf(var1));
         return this;
      }

      public MetadataChangeSet.Builder setStarred(boolean var1) {
         this.field_2047.method_1715(class_276.field_934, Boolean.valueOf(var1));
         return this;
      }

      public MetadataChangeSet.Builder setTitle(String var1) {
         this.field_2047.method_1715(class_276.field_936, var1);
         return this;
      }

      public MetadataChangeSet.Builder setViewed(boolean var1) {
         this.field_2047.method_1715(class_276.field_928, Boolean.valueOf(var1));
         return this;
      }
   }
}
