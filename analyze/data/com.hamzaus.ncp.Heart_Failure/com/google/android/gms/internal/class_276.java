package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.data.class_749;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.class_263;
import com.google.android.gms.drive.metadata.internal.class_264;
import com.google.android.gms.drive.metadata.internal.class_265;
import com.google.android.gms.drive.metadata.internal.class_268;
import com.google.android.gms.drive.metadata.internal.class_271;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.l;
import com.google.android.gms.internal.class_273;
import com.google.android.gms.internal.is;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.internal.ir
public class class_276 {
   // $FF: renamed from: JQ com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<DriveId> field_912;
   // $FF: renamed from: JR com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_913;
   // $FF: renamed from: JS com.google.android.gms.internal.ir$a
   public static final class_276.class_934 field_914;
   // $FF: renamed from: JT com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_915;
   // $FF: renamed from: JU com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_916;
   // $FF: renamed from: JV com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_917;
   // $FF: renamed from: JW com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Long> field_918;
   // $FF: renamed from: JX com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_919;
   // $FF: renamed from: JY com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_920;
   // $FF: renamed from: JZ com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_921;
   // $FF: renamed from: Ka com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_922;
   // $FF: renamed from: Kb com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_923;
   // $FF: renamed from: Kc com.google.android.gms.internal.ir$b
   public static final class_276.class_935 field_924;
   // $FF: renamed from: Kd com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_925;
   // $FF: renamed from: Ke com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_926;
   // $FF: renamed from: Kf com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_927;
   // $FF: renamed from: Kg com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_928;
   // $FF: renamed from: Kh com.google.android.gms.internal.ir$c
   public static final class_276.class_936 field_929;
   // $FF: renamed from: Ki com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_930;
   // $FF: renamed from: Kj com.google.android.gms.drive.metadata.b
   public static final b<String> field_931;
   // $FF: renamed from: Kk com.google.android.gms.internal.ir$d
   public static final class_276.class_937 field_932;
   // $FF: renamed from: Kl com.google.android.gms.internal.ir$e
   public static final class_276.class_938 field_933;
   // $FF: renamed from: Km com.google.android.gms.internal.ir$f
   public static final class_276.class_939 field_934;
   // $FF: renamed from: Kn com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<a> field_935;
   // $FF: renamed from: Ko com.google.android.gms.internal.ir$g
   public static final class_276.class_940 field_936;
   // $FF: renamed from: Kp com.google.android.gms.internal.ir$h
   public static final class_276.class_941 field_937;
   // $FF: renamed from: Kq com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_938;
   // $FF: renamed from: Kr com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_939;
   // $FF: renamed from: Ks com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_940;

   static {
      field_912 = class_273.field_909;
      field_913 = new class_265("alternateLink", 4300000);
      field_914 = new class_276.class_934(5000000);
      field_915 = new class_265("description", 4300000);
      field_916 = new class_265("embedLink", 4300000);
      field_917 = new class_265("fileExtension", 4300000);
      field_918 = new class_263("fileSize", 4300000);
      field_919 = new class_264("hasThumbnail", 4300000);
      field_920 = new class_265("indexableText", 4300000);
      field_921 = new class_264("isAppData", 4300000);
      field_922 = new class_264("isCopyable", 4300000);
      field_923 = new class_264("isEditable", 4100000);
      field_924 = new class_276.class_935("isPinned", 4100000);
      field_925 = new class_264("isRestricted", 4300000);
      field_926 = new class_264("isShared", 4300000);
      field_927 = new class_264("isTrashable", 4400000);
      field_928 = new class_264("isViewed", 4300000);
      field_929 = new class_276.class_936("mimeType", 4100000);
      field_930 = new class_265("originalFilename", 4300000);
      field_931 = new class_268("ownerNames", 4300000);
      field_932 = new class_276.class_937("parents", 4100000);
      field_933 = new class_276.class_938("quotaBytesUsed", 4300000);
      field_934 = new class_276.class_939("starred", 4100000);
      field_935 = new class_271("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
         // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
         // $FF: synthetic method
         protected Object method_1821(DataHolder var1, int var2, int var3) {
            return this.method_1846(var1, var2, var3);
         }

         // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.common.data.a
         protected class_749 method_1846(DataHolder var1, int var2, int var3) {
            throw new IllegalStateException("Thumbnail field is write only");
         }
      };
      field_936 = new class_276.class_940("title", 4100000);
      field_937 = new class_276.class_941("trashed", 4100000);
      field_938 = new class_265("webContentLink", 4300000);
      field_939 = new class_265("webViewLink", 4300000);
      field_940 = new class_265("uniqueIdentifier", 5000000);
   }

   public static class class_934 extends is implements SearchableMetadataField<AppVisibleCustomProperties> {
      public class_934(int var1) {
         super(var1);
      }
   }

   public static class class_935 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
      public class_935(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_936 extends l implements SearchableMetadataField<String> {
      public class_936(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_937 extends i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
      public class_937(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_938 extends g implements SortableMetadataField<Long> {
      public class_938(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_939 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
      public class_939(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_940 extends l implements SearchableMetadataField<String>, SortableMetadataField<String> {
      public class_940(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_941 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
      public class_941(String var1, int var2) {
         super(var1, var2);
      }

      // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
      // $FF: synthetic method
      protected Object method_1821(DataHolder var1, int var2, int var3) {
         return this.method_1830(var1, var2, var3);
      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Boolean
      protected Boolean method_1830(DataHolder var1, int var2, int var3) {
         boolean var4;
         if(var1.method_4558(this.getName(), var2, var3) != 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         return Boolean.valueOf(var4);
      }
   }
}
