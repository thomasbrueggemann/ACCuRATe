package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzsu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzkj {
   private static DocumentSection zza(String var0, zzpm.zzc var1) {
      RegisterSectionInfo var2 = (new RegisterSectionInfo.zza(var0)).zzM(true).zzbC(var0).zzbB("blob").zzmh();
      return new DocumentSection(zzsu.toByteArray(var1), var2);
   }

   public static UsageInfo zza(Action var0, long var1, String var3, int var4) {
      Bundle var5 = new Bundle();
      var5.putAll(var0.zzmk());
      Bundle var6 = var5.getBundle("object");
      Uri var7;
      if(var6.containsKey("id")) {
         var7 = Uri.parse(var6.getString("id"));
      } else {
         var7 = null;
      }

      String var8 = var6.getString("name");
      String var9 = var6.getString("type");
      Intent var10 = zzkk.zza(var3, Uri.parse(var6.getString("url")));
      DocumentContents.zza var11 = UsageInfo.zza(var10, var8, var7, var9, (List)null);
      if(var5.containsKey(".private:ssbContext")) {
         var11.zza(DocumentSection.zzh(var5.getByteArray(".private:ssbContext")));
         var5.remove(".private:ssbContext");
      }

      if(var5.containsKey(".private:accountName")) {
         var11.zzb(new Account(var5.getString(".private:accountName"), "com.google"));
         var5.remove(".private:accountName");
      }

      byte var12;
      if(var5.containsKey(".private:isContextOnly") && var5.getBoolean(".private:isContextOnly")) {
         var12 = 4;
         var5.remove(".private:isContextOnly");
      } else {
         var12 = 0;
      }

      boolean var13 = var5.containsKey(".private:isDeviceOnly");
      boolean var14 = false;
      if(var13) {
         var14 = var5.getBoolean(".private:isDeviceOnly", false);
         var5.remove(".private:isDeviceOnly");
      }

      var11.zza(zza(".private:action", zzg(var5)));
      return (new UsageInfo.zza()).zza(UsageInfo.zza(var3, var10)).zzw(var1).zzar(var12).zza(var11.zzme()).zzO(var14).zzas(var4).zzmi();
   }

   private static zzpm.zzb zzb(String var0, Bundle var1) {
      zzpm.zzb var2 = new zzpm.zzb();
      var2.name = var0;
      var2.zzaMt = new zzpm.zzd();
      var2.zzaMt.zzaMy = zzg(var1);
      return var2;
   }

   static zzpm.zzc zzg(Bundle var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.keySet().iterator();

      while(true) {
         while(var2.hasNext()) {
            String var4 = (String)var2.next();
            Object var5 = var0.get(var4);
            if(var5 instanceof String) {
               var1.add(zzp(var4, (String)var5));
            } else if(var5 instanceof Bundle) {
               var1.add(zzb(var4, (Bundle)var5));
            } else if(var5 instanceof String[]) {
               String[] var13 = (String[])((String[])var5);
               int var14 = var13.length;

               for(int var15 = 0; var15 < var14; ++var15) {
                  String var16 = var13[var15];
                  if(var16 != null) {
                     var1.add(zzp(var4, var16));
                  }
               }
            } else if(var5 instanceof Bundle[]) {
               Bundle[] var8 = (Bundle[])((Bundle[])var5);
               int var9 = var8.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  Bundle var11 = var8[var10];
                  if(var11 != null) {
                     var1.add(zzb(var4, var11));
                  }
               }
            } else if(var5 instanceof Boolean) {
               var1.add(zzi(var4, ((Boolean)var5).booleanValue()));
            } else {
               Log.e("SearchIndex", "Unsupported value: " + var5);
            }
         }

         zzpm.zzc var3 = new zzpm.zzc();
         if(var0.containsKey("type")) {
            var3.type = var0.getString("type");
         }

         var3.zzaMu = (zzpm.zzb[])var1.toArray(new zzpm.zzb[var1.size()]);
         return var3;
      }
   }

   private static zzpm.zzb zzi(String var0, boolean var1) {
      zzpm.zzb var2 = new zzpm.zzb();
      var2.name = var0;
      var2.zzaMt = new zzpm.zzd();
      var2.zzaMt.zzaMv = var1;
      return var2;
   }

   private static zzpm.zzb zzp(String var0, String var1) {
      zzpm.zzb var2 = new zzpm.zzb();
      var2.name = var0;
      var2.zzaMt = new zzpm.zzd();
      var2.zzaMt.zzamJ = var1;
      return var2;
   }
}
