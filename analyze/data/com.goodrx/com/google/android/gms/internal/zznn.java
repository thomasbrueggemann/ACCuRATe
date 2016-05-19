package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import java.util.Arrays;

public class zznn extends com.google.android.gms.drive.metadata.internal.zzk<AppVisibleCustomProperties> {
   public static final com.google.android.gms.drive.metadata.internal.zze.zza zzatL = new com.google.android.gms.drive.metadata.internal.zze.zza() {
      public String zztD() {
         return "customPropertiesExtraHolder";
      }
   };

   public zznn(int var1) {
      super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), var1);
   }
}
