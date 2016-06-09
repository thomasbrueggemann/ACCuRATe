package com.google.android.gms.internal;

import com.google.android.gms.drive.DriveId;
import java.util.Arrays;

public class zznp extends com.google.android.gms.drive.metadata.internal.zzk<DriveId> {
   public static final zznp zzatS = new zznp();

   private zznp() {
      super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
   }
}
