package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznp;
import java.util.Arrays;
import java.util.Collections;

public class zznm {
   public static final MetadataField<DriveId> zzasU;
   public static final MetadataField<String> zzasV;
   public static final zznm.zza zzasW;
   public static final MetadataField<String> zzasX;
   public static final MetadataField<String> zzasY;
   public static final MetadataField<String> zzasZ;
   public static final zznm.zzg zzatA;
   public static final zznm.zzh zzatB;
   public static final MetadataField<String> zzatC;
   public static final MetadataField<String> zzatD;
   public static final MetadataField<String> zzatE;
   public static final com.google.android.gms.drive.metadata.internal.zzb zzatF;
   public static final MetadataField<String> zzatG;
   public static final MetadataField<String> zzatH;
   public static final zznm.zze zzatI;
   public static final MetadataField<String> zzatJ;
   public static final MetadataField<Boolean> zzatK;
   public static final MetadataField<Long> zzata;
   public static final MetadataField<String> zzatb;
   public static final MetadataField<Boolean> zzatc;
   public static final MetadataField<String> zzatd;
   public static final MetadataField<Boolean> zzate;
   public static final MetadataField<Boolean> zzatf;
   public static final MetadataField<Boolean> zzatg;
   public static final MetadataField<Boolean> zzath;
   public static final MetadataField<Boolean> zzati;
   public static final zznm.zzb zzatj;
   public static final MetadataField<Boolean> zzatk;
   public static final MetadataField<Boolean> zzatl;
   public static final MetadataField<Boolean> zzatm;
   public static final MetadataField<Boolean> zzatn;
   public static final MetadataField<Boolean> zzato;
   public static final MetadataField<Boolean> zzatp;
   public static final MetadataField<Boolean> zzatq;
   public static final zznm.zzc zzatr;
   public static final MetadataField<String> zzats;
   public static final com.google.android.gms.drive.metadata.zzb<String> zzatt;
   public static final com.google.android.gms.drive.metadata.internal.zzq zzatu;
   public static final com.google.android.gms.drive.metadata.internal.zzq zzatv;
   public static final com.google.android.gms.drive.metadata.internal.zzm zzatw;
   public static final zznm.zzd zzatx;
   public static final zznm.zzf zzaty;
   public static final MetadataField<BitmapTeleporter> zzatz;

   static {
      zzasU = zznp.zzatS;
      zzasV = new com.google.android.gms.drive.metadata.internal.zzp("alternateLink", 4300000);
      zzasW = new zznm.zza(5000000);
      zzasX = new com.google.android.gms.drive.metadata.internal.zzp("description", 4300000);
      zzasY = new com.google.android.gms.drive.metadata.internal.zzp("embedLink", 4300000);
      zzasZ = new com.google.android.gms.drive.metadata.internal.zzp("fileExtension", 4300000);
      zzata = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
      zzatb = new com.google.android.gms.drive.metadata.internal.zzp("folderColorRgb", 7500000);
      zzatc = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
      zzatd = new com.google.android.gms.drive.metadata.internal.zzp("indexableText", 4300000);
      zzate = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
      zzatf = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
      zzatg = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
      zzath = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000) {
      };
      zzati = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
      zzatj = new zznm.zzb("isPinned", 4100000);
      zzatk = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
      zzatl = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
      zzatm = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
      zzatn = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
      zzato = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
      zzatp = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
      zzatq = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
      zzatr = new zznm.zzc(4100000);
      zzats = new com.google.android.gms.drive.metadata.internal.zzp("originalFilename", 4300000);
      zzatt = new com.google.android.gms.drive.metadata.internal.zzo("ownerNames", 4300000);
      zzatu = new com.google.android.gms.drive.metadata.internal.zzq("lastModifyingUser", 6000000);
      zzatv = new com.google.android.gms.drive.metadata.internal.zzq("sharingUser", 6000000);
      zzatw = new com.google.android.gms.drive.metadata.internal.zzm(4100000);
      zzatx = new zznm.zzd("quotaBytesUsed", 4300000);
      zzaty = new zznm.zzf("starred", 4100000);
      zzatz = new com.google.android.gms.drive.metadata.internal.zzk("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
      };
      zzatA = new zznm.zzg("title", 4100000);
      zzatB = new zznm.zzh("trashed", 4100000);
      zzatC = new com.google.android.gms.drive.metadata.internal.zzp("webContentLink", 4300000);
      zzatD = new com.google.android.gms.drive.metadata.internal.zzp("webViewLink", 4300000);
      zzatE = new com.google.android.gms.drive.metadata.internal.zzp("uniqueIdentifier", 5000000);
      zzatF = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
      zzatG = new com.google.android.gms.drive.metadata.internal.zzp("role", 6000000);
      zzatH = new com.google.android.gms.drive.metadata.internal.zzp("md5Checksum", 7000000);
      zzatI = new zznm.zze(7000000);
      zzatJ = new com.google.android.gms.drive.metadata.internal.zzp("recencyReason", 8000000);
      zzatK = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);
   }

   public static class zza extends zznn implements SearchableMetadataField<AppVisibleCustomProperties> {
      public zza(int var1) {
         super(var1);
      }
   }

   public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
      public zzb(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzc extends com.google.android.gms.drive.metadata.internal.zzp implements SearchableMetadataField<String> {
      public zzc(int var1) {
         super("mimeType", var1);
      }
   }

   public static class zzd extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField<Long> {
      public zzd(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zze extends com.google.android.gms.drive.metadata.internal.zzj<DriveSpace> {
      public zze(int var1) {
         super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), var1);
      }
   }

   public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
      public zzf(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzg extends com.google.android.gms.drive.metadata.internal.zzp implements SearchableMetadataField<String>, SortableMetadataField<String> {
      public zzg(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
      public zzh(String var1, int var2) {
         super(var1, var2);
      }
   }
}
