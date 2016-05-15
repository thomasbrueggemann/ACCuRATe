package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzhb;
import java.util.Map;

@zzhb
public abstract class zzby {
   @zzhb
   public static final zzby zzxs = new zzby() {
      public String zzb(@Nullable String var1, String var2) {
         return var2;
      }
   };
   @zzhb
   public static final zzby zzxt = new zzby() {
      public String zzb(@Nullable String var1, String var2) {
         return var1 != null?var1:var2;
      }
   };
   @zzhb
   public static final zzby zzxu = new zzby() {
      @Nullable
      private String zzM(@Nullable String var1) {
         if(!TextUtils.isEmpty(var1)) {
            int var2 = 0;

            int var3;
            for(var3 = var1.length(); var2 < var1.length() && var1.charAt(var2) == 44; ++var2) {
               ;
            }

            while(var3 > 0 && var1.charAt(var3 - 1) == 44) {
               --var3;
            }

            if(var2 != 0 || var3 != var1.length()) {
               return var1.substring(var2, var3);
            }
         }

         return var1;
      }

      public String zzb(@Nullable String var1, String var2) {
         String var3 = this.zzM(var1);
         String var4 = this.zzM(var2);
         return TextUtils.isEmpty(var3)?var4:(TextUtils.isEmpty(var4)?var3:var3 + "," + var4);
      }
   };

   public final void zza(Map<String, String> var1, String var2, String var3) {
      var1.put(var2, this.zzb((String)var1.get(var2), var3));
   }

   public abstract String zzb(@Nullable String var1, String var2);
}
