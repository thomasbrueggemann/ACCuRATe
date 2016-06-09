package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class zzm extends zzj<DriveId> implements SearchableCollectionMetadataField<DriveId> {
   public static final zze.zza zzasT = new zze.zza() {
      public String zztD() {
         return "parentsExtraHolder";
      }
   };

   public zzm(int var1) {
      super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), var1);
   }

   // $FF: synthetic method
   protected Object zzn(Bundle var1) {
      return this.zzs(var1);
   }

   protected Collection<DriveId> zzs(Bundle var1) {
      Collection var2 = super.zzs(var1);
      return var2 == null?null:new HashSet(var2);
   }
}
