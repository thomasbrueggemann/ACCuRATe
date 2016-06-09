package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzhb
public final class zzdm implements zzdf {
   private final com.google.android.gms.ads.internal.zze zzzA;
   private final zzfn zzzB;
   private final zzdh zzzD;

   public zzdm(zzdh var1, com.google.android.gms.ads.internal.zze var2, zzfn var3) {
      this.zzzD = var1;
      this.zzzA = var2;
      this.zzzB = var3;
   }

   private static boolean zzc(Map<String, String> var0) {
      return "1".equals(var0.get("custom_close"));
   }

   private static int zzd(Map<String, String> var0) {
      String var1 = (String)var0.get("o");
      if(var1 != null) {
         if("p".equalsIgnoreCase(var1)) {
            return com.google.android.gms.ads.internal.zzr.zzbE().zzhw();
         }

         if("l".equalsIgnoreCase(var1)) {
            return com.google.android.gms.ads.internal.zzr.zzbE().zzhv();
         }

         if("c".equalsIgnoreCase(var1)) {
            return com.google.android.gms.ads.internal.zzr.zzbE().zzhx();
         }
      }

      return -1;
   }

   private static void zze(zzjp var0, Map<String, String> var1) {
      String var2 = (String)var1.get("u");
      if(TextUtils.isEmpty(var2)) {
         zzin.zzaK("Destination url cannot be empty.");
      } else {
         (new zzdm.zza(var0, var2)).zzhn();
      }
   }

   private static void zzf(zzjp var0, Map<String, String> var1) {
      Context var2 = var0.getContext();
      if(TextUtils.isEmpty((String)var1.get("u"))) {
         zzin.zzaK("Destination url cannot be empty.");
      } else {
         zzjq var3 = var0.zzhU();
         Intent var4 = (new zzdm.zzb(var0)).zza(var2, var1);

         try {
            var3.zza(new AdLauncherIntentInfoParcel(var4));
         } catch (ActivityNotFoundException var6) {
            zzin.zzaK(var6.getMessage());
         }
      }
   }

   private void zzo(boolean var1) {
      if(this.zzzB != null) {
         this.zzzB.zzp(var1);
      }

   }

   public void zza(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("a");
      if(var3 == null) {
         zzin.zzaK("Action missing from an open GMSG.");
      } else {
         if(this.zzzA != null && !this.zzzA.zzbh()) {
            this.zzzA.zzq((String)var2.get("u"));
            return;
         }

         zzjq var4 = var1.zzhU();
         if("expand".equalsIgnoreCase(var3)) {
            if(var1.zzhY()) {
               zzin.zzaK("Cannot expand WebView that is already expanded.");
               return;
            }

            this.zzo(false);
            var4.zza(zzc(var2), zzd(var2));
            return;
         }

         if("webapp".equalsIgnoreCase(var3)) {
            String var10 = (String)var2.get("u");
            this.zzo(false);
            if(var10 != null) {
               var4.zza(zzc(var2), zzd(var2), var10);
               return;
            }

            var4.zza(zzc(var2), zzd(var2), (String)var2.get("html"), (String)var2.get("baseurl"));
            return;
         }

         if(!"in_app_purchase".equalsIgnoreCase(var3)) {
            if("app".equalsIgnoreCase(var3) && "true".equalsIgnoreCase((String)var2.get("play_store"))) {
               zze(var1, var2);
               return;
            }

            if("app".equalsIgnoreCase(var3) && "true".equalsIgnoreCase((String)var2.get("system_browser"))) {
               this.zzo(true);
               zzf(var1, var2);
               return;
            }

            this.zzo(true);
            String var5 = (String)var2.get("u");
            String var6;
            if(!TextUtils.isEmpty(var5)) {
               var6 = com.google.android.gms.ads.internal.zzr.zzbC().zza(var1, var5);
            } else {
               var6 = var5;
            }

            var4.zza(new AdLauncherIntentInfoParcel((String)var2.get("i"), var6, (String)var2.get("m"), (String)var2.get("p"), (String)var2.get("c"), (String)var2.get("f"), (String)var2.get("e")));
            return;
         }

         String var7 = (String)var2.get("product_id");
         String var8 = (String)var2.get("report_urls");
         if(this.zzzD != null) {
            if(var8 != null && !var8.isEmpty()) {
               String[] var9 = var8.split(" ");
               this.zzzD.zza(var7, new ArrayList(Arrays.asList(var9)));
               return;
            }

            this.zzzD.zza(var7, new ArrayList());
            return;
         }
      }

   }

   public static class zza extends zzim {
      private final String zzF;
      private final zzjp zzpD;
      private final String zzzE = "play.google.com";
      private final String zzzF = "market";
      private final int zzzG = 10;

      public zza(zzjp var1, String var2) {
         this.zzpD = var1;
         this.zzF = var2;
      }

      public Intent zzT(String var1) {
         Uri var2 = Uri.parse(var1);
         Intent var3 = new Intent("android.intent.action.VIEW");
         var3.addFlags(268435456);
         var3.setData(var2);
         return var3;
      }

      public void zzbr() {
         // $FF: Couldn't be decompiled
      }
   }

   public static class zzb {
      private final zzjp zzpD;

      public zzb(zzjp var1) {
         this.zzpD = var1;
      }

      public Intent zza(Context var1, Map<String, String> var2) {
         ActivityManager var3 = (ActivityManager)var1.getSystemService("activity");
         String var4 = (String)var2.get("u");
         boolean var5 = TextUtils.isEmpty(var4);
         Intent var6 = null;
         if(!var5) {
            if(this.zzpD != null) {
               var4 = com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzpD, var4);
            }

            Uri var7 = Uri.parse(var4);
            boolean var8 = Boolean.parseBoolean((String)var2.get("use_first_package"));
            boolean var9 = Boolean.parseBoolean((String)var2.get("use_running_process"));
            Uri var10;
            if("http".equalsIgnoreCase(var7.getScheme())) {
               var10 = var7.buildUpon().scheme("https").build();
            } else if("https".equalsIgnoreCase(var7.getScheme())) {
               var10 = var7.buildUpon().scheme("http").build();
            } else {
               var10 = null;
            }

            ArrayList var11 = new ArrayList();
            Intent var12 = this.zzd(var7);
            Intent var13 = this.zzd(var10);
            ResolveInfo var14 = this.zza(var1, var12, var11);
            if(var14 != null) {
               return this.zza(var12, var14);
            } else {
               if(var13 != null) {
                  ResolveInfo var19 = this.zza(var1, var13);
                  if(var19 != null) {
                     var6 = this.zza(var12, var19);
                     if(this.zza(var1, var6) != null) {
                        return var6;
                     }
                  }
               }

               if(var11.size() == 0) {
                  return var12;
               } else {
                  if(var9 && var3 != null) {
                     List var15 = var3.getRunningAppProcesses();
                     if(var15 != null) {
                        Iterator var16 = var11.iterator();

                        while(var16.hasNext()) {
                           ResolveInfo var17 = (ResolveInfo)var16.next();
                           Iterator var18 = var15.iterator();

                           while(var18.hasNext()) {
                              if(((RunningAppProcessInfo)var18.next()).processName.equals(var17.activityInfo.packageName)) {
                                 return this.zza(var12, var17);
                              }
                           }
                        }
                     }
                  }

                  if(var8) {
                     return this.zza(var12, (ResolveInfo)var11.get(0));
                  } else {
                     return var12;
                  }
               }
            }
         } else {
            return var6;
         }
      }

      public Intent zza(Intent var1, ResolveInfo var2) {
         Intent var3 = new Intent(var1);
         var3.setClassName(var2.activityInfo.packageName, var2.activityInfo.name);
         return var3;
      }

      public ResolveInfo zza(Context var1, Intent var2) {
         return this.zza(var1, var2, new ArrayList());
      }

      public ResolveInfo zza(Context var1, Intent var2, ArrayList<ResolveInfo> var3) {
         PackageManager var4 = var1.getPackageManager();
         if(var4 == null) {
            return null;
         } else {
            List var5;
            ResolveInfo var7;
            label28: {
               var5 = var4.queryIntentActivities(var2, 65536);
               ResolveInfo var6 = var4.resolveActivity(var2, 65536);
               if(var5 != null && var6 != null) {
                  for(int var9 = 0; var9 < var5.size(); ++var9) {
                     ResolveInfo var10 = (ResolveInfo)var5.get(var9);
                     if(var6 != null && var6.activityInfo.name.equals(var10.activityInfo.name)) {
                        var7 = var6;
                        break label28;
                     }
                  }
               }

               var7 = null;
            }

            var3.addAll(var5);
            return var7;
         }
      }

      public Intent zzd(Uri var1) {
         if(var1 == null) {
            return null;
         } else {
            Intent var2 = new Intent("android.intent.action.VIEW");
            var2.addFlags(268435456);
            var2.setData(var1);
            var2.setAction("android.intent.action.VIEW");
            return var2;
         }
      }
   }
}
