package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzab {
   private final List<Command> zzSJ;
   private final long zzSK;
   private final long zzSL;
   private final int zzSM;
   private final boolean zzSN;
   private final String zzSO;
   private final Map<String, String> zzxA;

   public zzab(zzc var1, Map<String, String> var2, long var3, boolean var5) {
      this(var1, var2, var3, var5, 0L, 0, (List)null);
   }

   public zzab(zzc var1, Map<String, String> var2, long var3, boolean var5, long var6, int var8) {
      this(var1, var2, var3, var5, var6, var8, (List)null);
   }

   public zzab(zzc var1, Map<String, String> var2, long var3, boolean var5, long var6, int var8, List<Command> var9) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      com.google.android.gms.common.internal.zzx.zzz(var2);
      this.zzSL = var3;
      this.zzSN = var5;
      this.zzSK = var6;
      this.zzSM = var8;
      List var12;
      if(var9 != null) {
         var12 = var9;
      } else {
         var12 = Collections.EMPTY_LIST;
      }

      this.zzSJ = var12;
      this.zzSO = zzp(var9);
      HashMap var13 = new HashMap();
      Iterator var14 = var2.entrySet().iterator();

      while(var14.hasNext()) {
         Entry var20 = (Entry)var14.next();
         if(zzk(var20.getKey())) {
            String var21 = zza(var1, var20.getKey());
            if(var21 != null) {
               var13.put(var21, zzb(var1, var20.getValue()));
            }
         }
      }

      Iterator var15 = var2.entrySet().iterator();

      while(var15.hasNext()) {
         Entry var17 = (Entry)var15.next();
         if(!zzk(var17.getKey())) {
            String var18 = zza(var1, var17.getKey());
            if(var18 != null) {
               var13.put(var18, zzb(var1, var17.getValue()));
            }
         }
      }

      if(!TextUtils.isEmpty(this.zzSO)) {
         zzam.zzc(var13, "_v", this.zzSO);
         if(this.zzSO.equals("ma4.0.0") || this.zzSO.equals("ma4.0.1")) {
            var13.remove("adid");
         }
      }

      this.zzxA = Collections.unmodifiableMap(var13);
   }

   public static zzab zza(zzc var0, zzab var1, Map<String, String> var2) {
      return new zzab(var0, var2, var1.zzlr(), var1.zzlt(), var1.zzlq(), var1.zzlp(), var1.zzls());
   }

   private static String zza(zzc var0, Object var1) {
      String var2;
      if(var1 == null) {
         var2 = null;
      } else {
         var2 = var1.toString();
         if(var2.startsWith("&")) {
            var2 = var2.substring(1);
         }

         int var3 = var2.length();
         if(var3 > 256) {
            var2 = var2.substring(0, 256);
            var0.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(var3), var2);
         }

         if(TextUtils.isEmpty(var2)) {
            return null;
         }
      }

      return var2;
   }

   private static String zzb(zzc var0, Object var1) {
      String var2;
      if(var1 == null) {
         var2 = "";
      } else {
         var2 = var1.toString();
      }

      int var3 = var2.length();
      if(var3 > 8192) {
         var2 = var2.substring(0, 8192);
         var0.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(var3), var2);
      }

      return var2;
   }

   private static boolean zzk(Object var0) {
      return var0 == null?false:var0.toString().startsWith("&");
   }

   private String zzm(String var1, String var2) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      boolean var4;
      if(!var1.startsWith("&")) {
         var4 = true;
      } else {
         var4 = false;
      }

      com.google.android.gms.common.internal.zzx.zzb(var4, "Short param name required");
      String var5 = (String)this.zzxA.get(var1);
      return var5 != null?var5:var2;
   }

   private static String zzp(List<Command> var0) {
      String var1;
      if(var0 != null) {
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            Command var3 = (Command)var2.next();
            if("appendVersion".equals(var3.getId())) {
               var1 = var3.getValue();
               return TextUtils.isEmpty(var1)?null:var1;
            }
         }
      }

      var1 = null;
      return TextUtils.isEmpty(var1)?null:var1;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append("ht=").append(this.zzSL);
      if(this.zzSK != 0L) {
         var1.append(", dbId=").append(this.zzSK);
      }

      if((long)this.zzSM != 0L) {
         var1.append(", appUID=").append(this.zzSM);
      }

      ArrayList var3 = new ArrayList(this.zzxA.keySet());
      Collections.sort(var3);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         var1.append(", ");
         var1.append(var5);
         var1.append("=");
         var1.append((String)this.zzxA.get(var5));
      }

      return var1.toString();
   }

   public int zzlp() {
      return this.zzSM;
   }

   public long zzlq() {
      return this.zzSK;
   }

   public long zzlr() {
      return this.zzSL;
   }

   public List<Command> zzls() {
      return this.zzSJ;
   }

   public boolean zzlt() {
      return this.zzSN;
   }

   public long zzlu() {
      return zzam.zzbt(this.zzm("_s", "0"));
   }

   public String zzlv() {
      return this.zzm("_m", "");
   }

   public Map<String, String> zzn() {
      return this.zzxA;
   }
}
