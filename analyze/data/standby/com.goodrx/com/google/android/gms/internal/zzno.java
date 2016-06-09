package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class zzno {
   public static final zzno.zza zzatM = new zzno.zza("created", 4100000);
   public static final zzno.zzb zzatN = new zzno.zzb("lastOpenedTime", 4300000);
   public static final zzno.zzd zzatO = new zzno.zzd("modified", 4100000);
   public static final zzno.zzc zzatP = new zzno.zzc("modifiedByMe", 4100000);
   public static final zzno.zzf zzatQ = new zzno.zzf("sharedWithMe", 4100000);
   public static final zzno.zze zzatR = new zzno.zze("recency", 8000000);

   public static class zza extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
      public zza(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzb extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public zzb(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzc extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
      public zzc(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzd extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public zzd(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zze extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
      public zze(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class zzf extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
      public zzf(String var1, int var2) {
         super(var1, var2);
      }
   }
}
