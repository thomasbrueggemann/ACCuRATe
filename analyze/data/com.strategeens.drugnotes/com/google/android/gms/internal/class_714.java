package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.data.class_970;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.class_536;
import com.google.android.gms.drive.metadata.internal.class_537;
import com.google.android.gms.drive.metadata.internal.class_538;
import com.google.android.gms.drive.metadata.internal.class_541;
import com.google.android.gms.drive.metadata.internal.class_542;
import com.google.android.gms.drive.metadata.internal.class_543;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.l;
import com.google.android.gms.internal.class_545;
import com.google.android.gms.internal.lo;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.internal.ln
public class class_714 {
   // $FF: renamed from: RA com.google.android.gms.internal.ln$c
   public static final class_714.class_1713 field_3296;
   // $FF: renamed from: RB com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3297;
   // $FF: renamed from: RC com.google.android.gms.drive.metadata.b
   public static final b<String> field_3298;
   // $FF: renamed from: RD com.google.android.gms.drive.metadata.internal.m
   public static final class_543 field_3299;
   // $FF: renamed from: RE com.google.android.gms.drive.metadata.internal.m
   public static final class_543 field_3300;
   // $FF: renamed from: RF com.google.android.gms.internal.ln$d
   public static final class_714.class_1714 field_3301;
   // $FF: renamed from: RG com.google.android.gms.internal.ln$e
   public static final class_714.class_1715 field_3302;
   // $FF: renamed from: RH com.google.android.gms.internal.ln$f
   public static final class_714.class_1716 field_3303;
   // $FF: renamed from: RI com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<a> field_3304;
   // $FF: renamed from: RJ com.google.android.gms.internal.ln$g
   public static final class_714.class_1717 field_3305;
   // $FF: renamed from: RK com.google.android.gms.internal.ln$h
   public static final class_714.class_1718 field_3306;
   // $FF: renamed from: RL com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3307;
   // $FF: renamed from: RM com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3308;
   // $FF: renamed from: RN com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3309;
   // $FF: renamed from: RO com.google.android.gms.drive.metadata.internal.b
   public static final class_537 field_3310;
   // $FF: renamed from: RP com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3311;
   // $FF: renamed from: Rj com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<DriveId> field_3312;
   // $FF: renamed from: Rk com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3313;
   // $FF: renamed from: Rl com.google.android.gms.internal.ln$a
   public static final class_714.class_1711 field_3314;
   // $FF: renamed from: Rm com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3315;
   // $FF: renamed from: Rn com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3316;
   // $FF: renamed from: Ro com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3317;
   // $FF: renamed from: Rp com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Long> field_3318;
   // $FF: renamed from: Rq com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3319;
   // $FF: renamed from: Rr com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<String> field_3320;
   // $FF: renamed from: Rs com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3321;
   // $FF: renamed from: Rt com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3322;
   // $FF: renamed from: Ru com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3323;
   // $FF: renamed from: Rv com.google.android.gms.internal.ln$b
   public static final class_714.class_1712 field_3324;
   // $FF: renamed from: Rw com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3325;
   // $FF: renamed from: Rx com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3326;
   // $FF: renamed from: Ry com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3327;
   // $FF: renamed from: Rz com.google.android.gms.drive.metadata.MetadataField
   public static final MetadataField<Boolean> field_3328;

   static {
      field_3312 = class_545.field_2522;
      field_3313 = new class_538("alternateLink", 4300000);
      field_3314 = new class_714.class_1711(5000000);
      field_3315 = new class_538("description", 4300000);
      field_3316 = new class_538("embedLink", 4300000);
      field_3317 = new class_538("fileExtension", 4300000);
      field_3318 = new class_536("fileSize", 4300000);
      field_3319 = new class_537("hasThumbnail", 4300000);
      field_3320 = new class_538("indexableText", 4300000);
      field_3321 = new class_537("isAppData", 4300000);
      field_3322 = new class_537("isCopyable", 4300000);
      field_3323 = new class_537("isEditable", 4100000);
      field_3324 = new class_714.class_1712("isPinned", 4100000);
      field_3325 = new class_537("isRestricted", 4300000);
      field_3326 = new class_537("isShared", 4300000);
      field_3327 = new class_537("isTrashable", 4400000);
      field_3328 = new class_537("isViewed", 4300000);
      field_3296 = new class_714.class_1713("mimeType", 4100000);
      field_3297 = new class_538("originalFilename", 4300000);
      field_3298 = new class_541("ownerNames", 4300000);
      field_3299 = new class_543("lastModifyingUser", 6000000);
      field_3300 = new class_543("sharingUser", 6000000);
      field_3301 = new class_714.class_1714("parents", 4100000);
      field_3302 = new class_714.class_1715("quotaBytesUsed", 4300000);
      field_3303 = new class_714.class_1716("starred", 4100000);
      field_3304 = new class_542("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
         // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
         // $FF: synthetic method
         protected Object method_3281(DataHolder var1, int var2, int var3) {
            return this.method_3303(var1, var2, var3);
         }

         // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.common.data.a
         protected class_970 method_3303(DataHolder var1, int var2, int var3) {
            throw new IllegalStateException("Thumbnail field is write only");
         }
      };
      field_3305 = new class_714.class_1717("title", 4100000);
      field_3306 = new class_714.class_1718("trashed", 4100000);
      field_3307 = new class_538("webContentLink", 4300000);
      field_3308 = new class_538("webViewLink", 4300000);
      field_3309 = new class_538("uniqueIdentifier", 5000000);
      field_3310 = new class_537("writersCanShare", 6000000);
      field_3311 = new class_538("role", 6000000);
   }

   public static class class_1711 extends lo implements SearchableMetadataField<AppVisibleCustomProperties> {
      public class_1711(int var1) {
         super(var1);
      }
   }

   public static class class_1712 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
      public class_1712(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1713 extends l implements SearchableMetadataField<String> {
      public class_1713(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1714 extends i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
      public class_1714(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1715 extends g implements SortableMetadataField<Long> {
      public class_1715(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1716 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
      public class_1716(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1717 extends l implements SearchableMetadataField<String>, SortableMetadataField<String> {
      public class_1717(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_1718 extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
      public class_1718(String var1, int var2) {
         super(var1, var2);
      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
      // $FF: synthetic method
      protected Object method_3281(DataHolder var1, int var2, int var3) {
         return this.method_3290(var1, var2, var3);
      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Boolean
      protected Boolean method_3290(DataHolder var1, int var2, int var3) {
         boolean var4;
         if(var1.method_5830(this.getName(), var2, var3) != 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         return Boolean.valueOf(var4);
      }
   }
}
