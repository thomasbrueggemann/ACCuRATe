package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_709;
import com.google.android.gms.internal.class_714;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
   public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
   public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
   public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
   public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
   public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
   // $FF: renamed from: OE com.google.android.gms.drive.MetadataChangeSet
   public static final MetadataChangeSet field_1610 = new MetadataChangeSet(MetadataBundle.method_2081());
   // $FF: renamed from: OF com.google.android.gms.drive.metadata.internal.MetadataBundle
   private final MetadataBundle field_1611;

   public MetadataChangeSet(MetadataBundle var1) {
      this.field_1611 = MetadataBundle.method_2080(var1);
   }

   public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
      AppVisibleCustomProperties var1 = (AppVisibleCustomProperties)this.field_1611.method_2082(class_714.field_3314);
      return var1 == null?Collections.emptyMap():var1.method_3411();
   }

   public String getDescription() {
      return (String)this.field_1611.method_2082(class_714.field_3315);
   }

   public String getIndexableText() {
      return (String)this.field_1611.method_2082(class_714.field_3320);
   }

   public Date getLastViewedByMeDate() {
      return (Date)this.field_1611.method_2082(class_709.field_3290);
   }

   public String getMimeType() {
      return (String)this.field_1611.method_2082(class_714.field_3296);
   }

   public String getTitle() {
      return (String)this.field_1611.method_2082(class_714.field_3305);
   }

   public Boolean isPinned() {
      return (Boolean)this.field_1611.method_2082(class_714.field_3324);
   }

   public Boolean isStarred() {
      return (Boolean)this.field_1611.method_2082(class_714.field_3303);
   }

   public Boolean isViewed() {
      return (Boolean)this.field_1611.method_2082(class_714.field_3328);
   }

   // $FF: renamed from: iz () com.google.android.gms.drive.metadata.internal.MetadataBundle
   public MetadataBundle method_3001() {
      return this.field_1611;
   }

   public static class Builder {
      // $FF: renamed from: OF com.google.android.gms.drive.metadata.internal.MetadataBundle
      private final MetadataBundle field_1722 = MetadataBundle.method_2081();
      // $FF: renamed from: OG com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a
      private AppVisibleCustomProperties.class_1334 field_1723;

      // $FF: renamed from: bk (java.lang.String) int
      private int method_3032(String var1) {
         return var1 == null?0:var1.getBytes().length;
      }

      // $FF: renamed from: i (java.lang.String, int, int) java.lang.String
      private String method_3033(String var1, int var2, int var3) {
         Object[] var4 = new Object[]{var1, Integer.valueOf(var2), Integer.valueOf(var3)};
         return String.format("%s must be no more than %d bytes, but is %d bytes.", var4);
      }

      // $FF: renamed from: iA () com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a
      private AppVisibleCustomProperties.class_1334 method_3034() {
         if(this.field_1723 == null) {
            this.field_1723 = new AppVisibleCustomProperties.class_1334();
         }

         return this.field_1723;
      }

      // $FF: renamed from: j (java.lang.String, int, int) void
      private void method_3035(String var1, int var2, int var3) {
         boolean var4;
         if(var3 <= var2) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2308(var4, this.method_3033(var1, var2, var3));
      }

      public MetadataChangeSet build() {
         if(this.field_1723 != null) {
            this.field_1722.method_2083(class_714.field_3314, this.field_1723.method_5520());
         }

         return new MetadataChangeSet(this.field_1722);
      }

      public MetadataChangeSet.Builder deleteCustomProperty(CustomPropertyKey var1) {
         class_335.method_2306(var1, "key");
         this.method_3034().method_5519(var1, (String)null);
         return this;
      }

      public MetadataChangeSet.Builder setCustomProperty(CustomPropertyKey var1, String var2) {
         class_335.method_2306(var1, "key");
         class_335.method_2306(var2, "value");
         this.method_3035("The total size of key string and value string of a custom property", 124, this.method_3032(var1.getKey()) + this.method_3032(var2));
         this.method_3034().method_5519(var1, var2);
         return this;
      }

      public MetadataChangeSet.Builder setDescription(String var1) {
         this.field_1722.method_2083(class_714.field_3315, var1);
         return this;
      }

      public MetadataChangeSet.Builder setIndexableText(String var1) {
         this.method_3035("Indexable text size", 131072, this.method_3032(var1));
         this.field_1722.method_2083(class_714.field_3320, var1);
         return this;
      }

      public MetadataChangeSet.Builder setLastViewedByMeDate(Date var1) {
         this.field_1722.method_2083(class_709.field_3290, var1);
         return this;
      }

      public MetadataChangeSet.Builder setMimeType(String var1) {
         this.field_1722.method_2083(class_714.field_3296, var1);
         return this;
      }

      public MetadataChangeSet.Builder setPinned(boolean var1) {
         this.field_1722.method_2083(class_714.field_3324, Boolean.valueOf(var1));
         return this;
      }

      public MetadataChangeSet.Builder setStarred(boolean var1) {
         this.field_1722.method_2083(class_714.field_3303, Boolean.valueOf(var1));
         return this;
      }

      public MetadataChangeSet.Builder setTitle(String var1) {
         this.field_1722.method_2083(class_714.field_3305, var1);
         return this;
      }

      public MetadataChangeSet.Builder setViewed(boolean var1) {
         this.field_1722.method_2083(class_714.field_3328, Boolean.valueOf(var1));
         return this;
      }
   }
}
