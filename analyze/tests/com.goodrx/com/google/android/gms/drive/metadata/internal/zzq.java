package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.UserMetadata;
import com.google.android.gms.drive.metadata.internal.zzk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzq extends zzk<UserMetadata> {
   public zzq(String var1, int var2) {
      super(var1, zzdg(var1), Collections.emptyList(), var2);
   }

   private static String zzB(String var0, String var1) {
      return var0 + "." + var1;
   }

   private static Collection<String> zzdg(String var0) {
      String[] var1 = new String[]{zzB(var0, "permissionId"), zzB(var0, "displayName"), zzB(var0, "picture"), zzB(var0, "isAuthenticatedUser"), zzB(var0, "emailAddress")};
      return Arrays.asList(var1);
   }
}
