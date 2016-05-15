package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzc;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpv;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzb extends com.google.android.gms.analytics.internal.zzc implements zzi {
   private static DecimalFormat zzOU;
   private final zzf zzOK;
   private final String zzOV;
   private final Uri zzOW;
   private final boolean zzOX;
   private final boolean zzOY;

   public zzb(zzf var1, String var2) {
      this(var1, var2, true, false);
   }

   public zzb(zzf var1, String var2, boolean var3, boolean var4) {
      super(var1);
      zzx.zzcM(var2);
      this.zzOK = var1;
      this.zzOV = var2;
      this.zzOX = var3;
      this.zzOY = var4;
      this.zzOW = zzaU(this.zzOV);
   }

   private static String zzH(Map<String, String> var0) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var1.length() != 0) {
            var1.append(", ");
         }

         var1.append((String)var3.getKey());
         var1.append("=");
         var1.append((String)var3.getValue());
      }

      return var1.toString();
   }

   private static void zza(Map<String, String> var0, String var1, double var2) {
      if(var2 != 0.0D) {
         var0.put(var1, zzb(var2));
      }

   }

   private static void zza(Map<String, String> var0, String var1, int var2, int var3) {
      if(var2 > 0 && var3 > 0) {
         var0.put(var1, var2 + "x" + var3);
      }

   }

   private static void zza(Map<String, String> var0, String var1, boolean var2) {
      if(var2) {
         var0.put(var1, "1");
      }

   }

   static Uri zzaU(String var0) {
      zzx.zzcM(var0);
      Builder var2 = new Builder();
      var2.scheme("uri");
      var2.authority("google-analytics.com");
      var2.path(var0);
      return var2.build();
   }

   static String zzb(double var0) {
      if(zzOU == null) {
         zzOU = new DecimalFormat("0.######");
      }

      return zzOU.format(var0);
   }

   private static void zzb(Map<String, String> var0, String var1, String var2) {
      if(!TextUtils.isEmpty(var2)) {
         var0.put(var1, var2);
      }

   }

   public static Map<String, String> zzc(com.google.android.gms.measurement.zzc var0) {
      HashMap var1 = new HashMap();
      zzkd var2 = (zzkd)var0.zze(zzkd.class);
      if(var2 != null) {
         Iterator var40 = var2.zziR().entrySet().iterator();

         while(var40.hasNext()) {
            Entry var41 = (Entry)var40.next();
            String var42 = zzi(var41.getValue());
            if(var42 != null) {
               var1.put(var41.getKey(), var42);
            }
         }
      }

      zzke var3 = (zzke)var0.zze(zzke.class);
      if(var3 != null) {
         zzb(var1, "t", var3.zziS());
         zzb(var1, "cid", var3.getClientId());
         zzb(var1, "uid", var3.getUserId());
         zzb(var1, "sc", var3.zziV());
         zza(var1, "sf", var3.zziX());
         zza(var1, "ni", var3.zziW());
         zzb(var1, "adid", var3.zziT());
         zza(var1, "ate", var3.zziU());
      }

      zzpw var4 = (zzpw)var0.zze(zzpw.class);
      if(var4 != null) {
         zzb(var1, "cd", var4.zzBc());
         zza(var1, "a", (double)var4.zzBd());
         zzb(var1, "dr", var4.zzBe());
      }

      zzpu var5 = (zzpu)var0.zze(zzpu.class);
      if(var5 != null) {
         zzb(var1, "ec", var5.zzAZ());
         zzb(var1, "ea", var5.getAction());
         zzb(var1, "el", var5.getLabel());
         zza(var1, "ev", (double)var5.getValue());
      }

      zzpr var6 = (zzpr)var0.zze(zzpr.class);
      if(var6 != null) {
         zzb(var1, "cn", var6.getName());
         zzb(var1, "cs", var6.getSource());
         zzb(var1, "cm", var6.zzAK());
         zzb(var1, "ck", var6.zzAL());
         zzb(var1, "cc", var6.getContent());
         zzb(var1, "ci", var6.getId());
         zzb(var1, "anid", var6.zzAM());
         zzb(var1, "gclid", var6.zzAN());
         zzb(var1, "dclid", var6.zzAO());
         zzb(var1, "aclid", var6.zzAP());
      }

      zzpv var7 = (zzpv)var0.zze(zzpv.class);
      if(var7 != null) {
         zzb(var1, "exd", var7.getDescription());
         zza(var1, "exf", var7.zzBa());
      }

      zzpx var8 = (zzpx)var0.zze(zzpx.class);
      if(var8 != null) {
         zzb(var1, "sn", var8.zzBg());
         zzb(var1, "sa", var8.getAction());
         zzb(var1, "st", var8.getTarget());
      }

      zzpy var9 = (zzpy)var0.zze(zzpy.class);
      if(var9 != null) {
         zzb(var1, "utv", var9.zzBh());
         zza(var1, "utt", (double)var9.getTimeInMillis());
         zzb(var1, "utc", var9.zzAZ());
         zzb(var1, "utl", var9.getLabel());
      }

      zzkb var10 = (zzkb)var0.zze(zzkb.class);
      if(var10 != null) {
         Iterator var36 = var10.zziP().entrySet().iterator();

         while(var36.hasNext()) {
            Entry var37 = (Entry)var36.next();
            String var38 = zzc.zzU(((Integer)var37.getKey()).intValue());
            if(!TextUtils.isEmpty(var38)) {
               var1.put(var38, var37.getValue());
            }
         }
      }

      zzkc var11 = (zzkc)var0.zze(zzkc.class);
      if(var11 != null) {
         Iterator var32 = var11.zziQ().entrySet().iterator();

         while(var32.hasNext()) {
            Entry var33 = (Entry)var32.next();
            String var34 = zzc.zzW(((Integer)var33.getKey()).intValue());
            if(!TextUtils.isEmpty(var34)) {
               var1.put(var34, zzb(((Double)var33.getValue()).doubleValue()));
            }
         }
      }

      zzpt var12 = (zzpt)var0.zze(zzpt.class);
      if(var12 != null) {
         ProductAction var15 = var12.zzAV();
         if(var15 != null) {
            Iterator var28 = var15.build().entrySet().iterator();

            while(var28.hasNext()) {
               Entry var29 = (Entry)var28.next();
               if(((String)var29.getKey()).startsWith("&")) {
                  var1.put(((String)var29.getKey()).substring(1), var29.getValue());
               } else {
                  var1.put(var29.getKey(), var29.getValue());
               }
            }
         }

         Iterator var16 = var12.zzAY().iterator();

         for(int var17 = 1; var16.hasNext(); ++var17) {
            var1.putAll(((Promotion)var16.next()).zzba(zzc.zzaa(var17)));
         }

         Iterator var18 = var12.zzAW().iterator();

         for(int var19 = 1; var18.hasNext(); ++var19) {
            var1.putAll(((Product)var18.next()).zzba(zzc.zzY(var19)));
         }

         Iterator var20 = var12.zzAX().entrySet().iterator();

         for(int var21 = 1; var20.hasNext(); ++var21) {
            Entry var22 = (Entry)var20.next();
            List var23 = (List)var22.getValue();
            String var24 = zzc.zzad(var21);
            Iterator var25 = var23.iterator();

            for(int var26 = 1; var25.hasNext(); ++var26) {
               var1.putAll(((Product)var25.next()).zzba(var24 + zzc.zzab(var26)));
            }

            if(!TextUtils.isEmpty((CharSequence)var22.getKey())) {
               var1.put(var24 + "nm", var22.getKey());
            }
         }
      }

      zzps var13 = (zzps)var0.zze(zzps.class);
      if(var13 != null) {
         zzb(var1, "ul", var13.getLanguage());
         zza(var1, "sd", (double)var13.zzAQ());
         zza(var1, "sr", var13.zzAR(), var13.zzAS());
         zza(var1, "vp", var13.zzAT(), var13.zzAU());
      }

      zzpq var14 = (zzpq)var0.zze(zzpq.class);
      if(var14 != null) {
         zzb(var1, "an", var14.zzlg());
         zzb(var1, "aid", var14.zzwK());
         zzb(var1, "aiid", var14.zzAJ());
         zzb(var1, "av", var14.zzli());
      }

      return var1;
   }

   private static String zzi(Object var0) {
      String var2;
      if(var0 == null) {
         var2 = null;
      } else {
         if(!(var0 instanceof String)) {
            if(var0 instanceof Double) {
               Double var1 = (Double)var0;
               if(var1.doubleValue() != 0.0D) {
                  return zzb(var1.doubleValue());
               }

               return null;
            }

            if(var0 instanceof Boolean) {
               if(var0 != Boolean.FALSE) {
                  return "1";
               }

               return null;
            }

            return String.valueOf(var0);
         }

         var2 = (String)var0;
         if(TextUtils.isEmpty(var2)) {
            return null;
         }
      }

      return var2;
   }

   public void zzb(com.google.android.gms.measurement.zzc var1) {
      zzx.zzz(var1);
      zzx.zzb(var1.zzAz(), "Can\'t deliver not submitted measurement");
      zzx.zzcE("deliver should be called on worker thread");
      com.google.android.gms.measurement.zzc var3 = var1.zzAu();
      zzke var4 = (zzke)var3.zzf(zzke.class);
      if(TextUtils.isEmpty(var4.zziS())) {
         this.zzjm().zzh(zzc(var3), "Ignoring measurement without type");
      } else {
         if(TextUtils.isEmpty(var4.getClientId())) {
            this.zzjm().zzh(zzc(var3), "Ignoring measurement without client id");
            return;
         }

         if(!this.zzOK.zzjz().getAppOptOut()) {
            double var5 = var4.zziX();
            if(zzam.zza(var5, var4.getClientId())) {
               this.zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(var5));
               return;
            }

            Map var7 = zzc(var3);
            var7.put("v", "1");
            var7.put("_v", zze.zzQm);
            var7.put("tid", this.zzOV);
            if(this.zzOK.zzjz().isDryRunEnabled()) {
               this.zzc("Dry run is enabled. GoogleAnalytics would have sent", zzH(var7));
               return;
            }

            HashMap var11 = new HashMap();
            zzam.zzc(var11, "uid", var4.getUserId());
            zzpq var12 = (zzpq)var1.zze(zzpq.class);
            if(var12 != null) {
               zzam.zzc(var11, "an", var12.zzlg());
               zzam.zzc(var11, "aid", var12.zzwK());
               zzam.zzc(var11, "av", var12.zzli());
               zzam.zzc(var11, "aiid", var12.zzAJ());
            }

            String var13 = var4.getClientId();
            String var14 = this.zzOV;
            boolean var15;
            if(!TextUtils.isEmpty(var4.zziT())) {
               var15 = true;
            } else {
               var15 = false;
            }

            zzh var16 = new zzh(0L, var13, var14, var15, 0L, var11);
            var7.put("_s", String.valueOf(this.zziH().zza(var16)));
            zzab var18 = new zzab(this.zzjm(), var7, var1.zzAx(), true);
            this.zziH().zza(var18);
            return;
         }
      }

   }

   public Uri zziA() {
      return this.zzOW;
   }
}
