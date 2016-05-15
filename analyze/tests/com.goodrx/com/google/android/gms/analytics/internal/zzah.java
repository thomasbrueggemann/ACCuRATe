package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaj;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzm;
import com.google.android.gms.analytics.internal.zzo;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

class zzah extends zzd {
   private static final byte[] zzTd = "\n".getBytes();
   private final zzaj zzTc;
   private final String zzzN;

   zzah(zzf var1) {
      super(var1);
      this.zzzN = zza("GoogleAnalytics", zze.VERSION, VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
      this.zzTc = new zzaj(var1.zzjl());
   }

   private int zza(URL param1, byte[] param2) {
      // $FF: Couldn't be decompiled
   }

   private static String zza(String var0, String var1, String var2, String var3, String var4, String var5) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var0, var1, var2, var3, var4, var5});
   }

   private void zza(StringBuilder var1, String var2, String var3) throws UnsupportedEncodingException {
      if(var1.length() != 0) {
         var1.append('&');
      }

      var1.append(URLEncoder.encode(var2, "UTF-8"));
      var1.append('=');
      var1.append(URLEncoder.encode(var3, "UTF-8"));
   }

   private int zzb(URL param1) {
      // $FF: Couldn't be decompiled
   }

   private int zzb(URL param1, byte[] param2) {
      // $FF: Couldn't be decompiled
   }

   private URL zzb(zzab var1, String var2) {
      String var3;
      if(var1.zzlt()) {
         var3 = this.zzjn().zzkF() + this.zzjn().zzkH() + "?" + var2;
      } else {
         var3 = this.zzjn().zzkG() + this.zzjn().zzkH() + "?" + var2;
      }

      try {
         URL var4 = new URL(var3);
         return var4;
      } catch (MalformedURLException var6) {
         this.zze("Error trying to parse the hardcoded host url", var6);
         return null;
      }
   }

   private void zzb(HttpURLConnection param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private boolean zzg(zzab var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      boolean var3;
      if(!var1.zzlt()) {
         var3 = true;
      } else {
         var3 = false;
      }

      String var4 = this.zza(var1, var3);
      if(var4 == null) {
         this.zzjm().zza(var1, "Error formatting hit for upload");
      } else if(var4.length() <= this.zzjn().zzku()) {
         URL var8 = this.zzb(var1, var4);
         if(var8 == null) {
            this.zzbh("Failed to build collect GET endpoint url");
            return false;
         }

         if(this.zzb(var8) != 200) {
            return false;
         }
      } else {
         String var5 = this.zza(var1, false);
         if(var5 == null) {
            this.zzjm().zza(var1, "Error formatting hit for POST upload");
            return true;
         }

         byte[] var6 = var5.getBytes();
         if(var6.length > this.zzjn().zzkw()) {
            this.zzjm().zza(var1, "Hit payload exceeds size limit");
            return true;
         }

         URL var7 = this.zzh(var1);
         if(var7 == null) {
            this.zzbh("Failed to build collect POST endpoint url");
            return false;
         }

         if(this.zza(var7, var6) != 200) {
            return false;
         }
      }

      return true;
   }

   private static byte[] zzg(byte[] var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      GZIPOutputStream var2 = new GZIPOutputStream(var1);
      var2.write(var0);
      var2.close();
      var1.close();
      return var1.toByteArray();
   }

   private URL zzh(zzab var1) {
      String var2;
      if(var1.zzlt()) {
         var2 = this.zzjn().zzkF() + this.zzjn().zzkH();
      } else {
         var2 = this.zzjn().zzkG() + this.zzjn().zzkH();
      }

      try {
         URL var3 = new URL(var2);
         return var3;
      } catch (MalformedURLException var5) {
         this.zze("Error trying to parse the hardcoded host url", var5);
         return null;
      }
   }

   private String zzi(zzab var1) {
      return String.valueOf(var1.zzlq());
   }

   private URL zzlC() {
      String var1 = this.zzjn().zzkF() + this.zzjn().zzkI();

      try {
         URL var2 = new URL(var1);
         return var2;
      } catch (MalformedURLException var4) {
         this.zze("Error trying to parse the hardcoded host url", var4);
         return null;
      }
   }

   String zza(zzab param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   List<Long> zza(List<zzab> var1, boolean var2) {
      boolean var3;
      if(!var1.isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      com.google.android.gms.common.internal.zzx.zzac(var3);
      this.zza("Uploading batched hits. compression, count", Boolean.valueOf(var2), Integer.valueOf(var1.size()));
      zzah.zza var4 = new zzah.zza();
      ArrayList var5 = new ArrayList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         zzab var9 = (zzab)var6.next();
         if(!var4.zzj(var9)) {
            break;
         }

         var5.add(Long.valueOf(var9.zzlq()));
      }

      if(var4.zzlE() == 0) {
         return var5;
      } else {
         URL var7 = this.zzlC();
         if(var7 == null) {
            this.zzbh("Failed to build batching endpoint url");
            return Collections.emptyList();
         } else {
            int var8;
            if(var2) {
               var8 = this.zzb(var7, var4.getPayload());
            } else {
               var8 = this.zza(var7, var4.getPayload());
            }

            if(200 == var8) {
               this.zza("Batched upload completed. Hits batched", Integer.valueOf(var4.zzlE()));
               return var5;
            } else {
               this.zza("Network error uploading hits. status code", Integer.valueOf(var8));
               if(this.zzjn().zzkL().contains(Integer.valueOf(var8))) {
                  this.zzbg("Server instructed the client to stop batching");
                  this.zzTc.start();
               }

               return Collections.emptyList();
            }
         }
      }
   }

   HttpURLConnection zzc(URL var1) throws IOException {
      URLConnection var2 = HttpInstrumentation.openConnection(var1.openConnection());
      if(!(var2 instanceof HttpURLConnection)) {
         throw new IOException("Failed to obtain http connection");
      } else {
         HttpURLConnection var3 = (HttpURLConnection)var2;
         var3.setDefaultUseCaches(false);
         var3.setConnectTimeout(this.zzjn().zzkU());
         var3.setReadTimeout(this.zzjn().zzkV());
         var3.setInstanceFollowRedirects(false);
         var3.setRequestProperty("User-Agent", this.zzzN);
         var3.setDoInput(true);
         return var3;
      }
   }

   protected void zziJ() {
      this.zza("Network initialized. User agent", this.zzzN);
   }

   public boolean zzlB() {
      this.zzjk();
      this.zzjv();
      ConnectivityManager var1 = (ConnectivityManager)this.getContext().getSystemService("connectivity");

      NetworkInfo var3;
      label19: {
         NetworkInfo var4;
         try {
            var4 = var1.getActiveNetworkInfo();
         } catch (SecurityException var5) {
            var3 = null;
            break label19;
         }

         var3 = var4;
      }

      if(var3 != null && var3.isConnected()) {
         return true;
      } else {
         this.zzbd("No network connectivity");
         return false;
      }
   }

   public List<Long> zzq(List<zzab> var1) {
      boolean var2 = true;
      this.zzjk();
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      boolean var4;
      if(!this.zzjn().zzkL().isEmpty() && this.zzTc.zzv(1000L * this.zzjn().zzkE())) {
         if(this.zzjn().zzkJ() != zzm.zzRk) {
            var4 = var2;
         } else {
            var4 = false;
         }

         if(this.zzjn().zzkK() != zzo.zzRv) {
            var2 = false;
         }
      } else {
         var2 = false;
         var4 = false;
      }

      return var4?this.zza(var1, var2):this.zzr(var1);
   }

   List<Long> zzr(List<zzab> var1) {
      ArrayList var2 = new ArrayList(var1.size());
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         zzab var4 = (zzab)var3.next();
         if(!this.zzg(var4)) {
            break;
         }

         var2.add(Long.valueOf(var4.zzlq()));
         if(var2.size() >= this.zzjn().zzkC()) {
            return var2;
         }
      }

      return var2;
   }

   private class zza {
      private int zzTe;
      private ByteArrayOutputStream zzTf = new ByteArrayOutputStream();

      public byte[] getPayload() {
         return this.zzTf.toByteArray();
      }

      public boolean zzj(zzab var1) {
         com.google.android.gms.common.internal.zzx.zzz(var1);
         if(1 + this.zzTe > zzah.this.zzjn().zzkD()) {
            return false;
         } else {
            String var3 = zzah.this.zza(var1, false);
            if(var3 == null) {
               zzah.this.zzjm().zza(var1, "Error formatting hit");
               return true;
            } else {
               byte[] var4 = var3.getBytes();
               int var5 = var4.length;
               if(var5 > zzah.this.zzjn().zzkv()) {
                  zzah.this.zzjm().zza(var1, "Hit size exceeds the maximum size limit");
                  return true;
               } else {
                  if(this.zzTf.size() > 0) {
                     ++var5;
                  }

                  if(var5 + this.zzTf.size() > zzah.this.zzjn().zzkx()) {
                     return false;
                  } else {
                     try {
                        if(this.zzTf.size() > 0) {
                           this.zzTf.write(zzah.zzTd);
                        }

                        this.zzTf.write(var4);
                     } catch (IOException var7) {
                        zzah.this.zze("Failed to write payload when batching hits", var7);
                        return true;
                     }

                     ++this.zzTe;
                     return true;
                  }
               }
            }
         }
      }

      public int zzlE() {
         return this.zzTe;
      }
   }
}
