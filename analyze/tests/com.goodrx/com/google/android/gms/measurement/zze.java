package com.google.android.gms.measurement;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public abstract class zze<T extends zze> {
   public static String zzF(Object var0) {
      return zza(var0, 0);
   }

   public static String zzO(Map var0) {
      return zza(var0, 1);
   }

   private static String zza(Object var0, int var1) {
      if(var1 > 10) {
         return "ERROR: Recursive toString calls";
      } else if(var0 == null) {
         return "";
      } else if(var0 instanceof String) {
         return TextUtils.isEmpty((String)var0)?"":var0.toString();
      } else if(var0 instanceof Integer) {
         return ((Integer)var0).intValue() == 0?"":var0.toString();
      } else if(var0 instanceof Long) {
         return ((Long)var0).longValue() == 0L?"":var0.toString();
      } else if(var0 instanceof Double) {
         return ((Double)var0).doubleValue() == 0.0D?"":var0.toString();
      } else if(var0 instanceof Boolean) {
         return !((Boolean)var0).booleanValue()?"":var0.toString();
      } else if(var0 instanceof List) {
         StringBuffer var2 = new StringBuffer();
         if(var1 > 0) {
            var2.append("[");
         }

         List var3 = (List)var0;
         int var4 = var2.length();

         Object var7;
         for(Iterator var5 = var3.iterator(); var5.hasNext(); var2.append(zza(var7, var1 + 1))) {
            var7 = var5.next();
            if(var2.length() > var4) {
               var2.append(", ");
            }
         }

         if(var1 > 0) {
            var2.append("]");
         }

         return var2.toString();
      } else if(var0 instanceof Map) {
         StringBuffer var11 = new StringBuffer();
         Iterator var12 = (new TreeMap((Map)var0)).entrySet().iterator();
         int var13 = 0;
         boolean var14 = false;

         while(var12.hasNext()) {
            Entry var16 = (Entry)var12.next();
            String var17 = zza(var16.getValue(), var1 + 1);
            if(!TextUtils.isEmpty(var17)) {
               if(var1 > 0 && !var14) {
                  var11.append("{");
                  var14 = true;
                  var13 = var11.length();
               }

               if(var11.length() > var13) {
                  var11.append(", ");
               }

               var11.append((String)var16.getKey());
               var11.append('=');
               var11.append(var17);
            }
         }

         if(var14) {
            var11.append("}");
         }

         return var11.toString();
      } else {
         return var0.toString();
      }
   }

   public abstract void zza(T var1);
}
