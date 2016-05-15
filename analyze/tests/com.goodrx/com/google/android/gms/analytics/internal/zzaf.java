package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class zzaf extends zzd {
   private static String zzSW = "3";
   private static String zzSX = "01VDIWEA?";
   private static zzaf zzSY;

   public zzaf(zzf var1) {
      super(var1);
   }

   public static zzaf zzlx() {
      return zzSY;
   }

   public void zza(int var1, String var2, Object var3, Object var4, Object var5) {
      String var6 = (String)zzy.zzRL.get();
      if(Log.isLoggable(var6, var1)) {
         Log.println(var1, var6, zzc(var2, var3, var4, var5));
      }

      if(var1 >= 5) {
         this.zzb(var1, var2, var3, var4, var5);
      }

   }

   public void zza(zzab var1, String var2) {
      if(var2 == null) {
         var2 = "no reason provided";
      }

      String var3;
      if(var1 != null) {
         var3 = var1.toString();
      } else {
         var3 = "no hit data";
      }

      this.zzd("Discarding hit. " + var2, var3);
   }

   public void zzb(int param1, String param2, Object param3, Object param4, Object param5) {
      // $FF: Couldn't be decompiled
   }

   public void zzh(Map<String, String> var1, String var2) {
      if(var2 == null) {
         var2 = "no reason provided";
      }

      String var5;
      if(var1 != null) {
         StringBuilder var3 = new StringBuilder();
         Iterator var4 = var1.entrySet().iterator();

         while(var4.hasNext()) {
            Entry var6 = (Entry)var4.next();
            if(var3.length() > 0) {
               var3.append(',');
            }

            var3.append((String)var6.getKey());
            var3.append('=');
            var3.append((String)var6.getValue());
         }

         var5 = var3.toString();
      } else {
         var5 = "no hit data";
      }

      this.zzd("Discarding hit. " + var2, var5);
   }

   protected void zziJ() {
      // $FF: Couldn't be decompiled
   }

   protected String zzl(Object var1) {
      if(var1 == null) {
         return null;
      } else {
         Object var2;
         if(var1 instanceof Integer) {
            var2 = new Long((long)((Integer)var1).intValue());
         } else {
            var2 = var1;
         }

         if(var2 instanceof Long) {
            if(Math.abs(((Long)var2).longValue()) < 100L) {
               return String.valueOf(var2);
            } else {
               String var3;
               if(String.valueOf(var2).charAt(0) == 45) {
                  var3 = "-";
               } else {
                  var3 = "";
               }

               String var4 = String.valueOf(Math.abs(((Long)var2).longValue()));
               StringBuilder var5 = new StringBuilder();
               var5.append(var3);
               var5.append(Math.round(Math.pow(10.0D, (double)(-1 + var4.length()))));
               var5.append("...");
               var5.append(var3);
               var5.append(Math.round(Math.pow(10.0D, (double)var4.length()) - 1.0D));
               return var5.toString();
            }
         } else {
            return var2 instanceof Boolean?String.valueOf(var2):(var2 instanceof Throwable?var2.getClass().getCanonicalName():"-");
         }
      }
   }
}
