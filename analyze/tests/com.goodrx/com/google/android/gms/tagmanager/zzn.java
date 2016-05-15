package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import java.util.Map;

class zzn extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_62;
   private static final String VALUE;

   static {
      field_62 = com.google.android.gms.internal.zzad.zzbx.toString();
      VALUE = com.google.android.gms.internal.zzae.zzih.toString();
   }

   public zzn() {
      String var1 = field_62;
      String[] var2 = new String[]{VALUE};
      super(var1, var2);
   }

   public static String zzFZ() {
      return field_62;
   }

   public static String zzGa() {
      return VALUE;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      return (com.google.android.gms.internal.zzag.zza)var1.get(VALUE);
   }
}
