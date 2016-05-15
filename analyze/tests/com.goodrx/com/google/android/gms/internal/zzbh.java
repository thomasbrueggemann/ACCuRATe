package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbj;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzhb
public class zzbh {
   private final int zztp;
   private final int zztq;
   private final int zztr;
   private final zzbg zzts = new zzbj();

   public zzbh(int var1) {
      this.zztq = var1;
      this.zztp = 6;
      this.zztr = 0;
   }

   private String zzv(String var1) {
      String[] var2 = var1.split("\n");
      if(var2.length == 0) {
         return "";
      } else {
         zzbh.zza var3 = this.zzcM();
         Arrays.sort(var2, new Comparator() {
            public int compare(String var1, String var2) {
               return var2.length() - var1.length();
            }
         });

         for(int var4 = 0; var4 < var2.length && var4 < this.zztq; ++var4) {
            if(var2[var4].trim().length() != 0) {
               try {
                  var3.write(this.zzts.zzu(var2[var4]));
               } catch (IOException var6) {
                  zzin.zzb("Error while writing hash to byteStream", var6);
                  break;
               }
            }
         }

         return var3.toString();
      }
   }

   public String zza(ArrayList<String> var1) {
      StringBuffer var2 = new StringBuffer();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.append(((String)var3.next()).toLowerCase(Locale.US));
         var2.append('\n');
      }

      switch(this.zztr) {
      case 0:
         return this.zzw(var2.toString());
      case 1:
         return this.zzv(var2.toString());
      default:
         return "";
      }
   }

   zzbh.zza zzcM() {
      return new zzbh.zza();
   }

   String zzw(String var1) {
      String[] var2 = var1.split("\n");
      if(var2.length == 0) {
         return "";
      } else {
         zzbh.zza var3 = this.zzcM();
         PriorityQueue var4 = new PriorityQueue(this.zztq, new Comparator() {
            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
               return this.zza((zzbk.zza)var1, (zzbk.zza)var2);
            }

            public int zza(zzbk.zza var1, zzbk.zza var2) {
               int var3 = var1.zzty - var2.zzty;
               return var3 != 0?var3:(int)(var1.value - var2.value);
            }
         });

         for(int var5 = 0; var5 < var2.length; ++var5) {
            String[] var9 = zzbi.zzy(var2[var5]);
            if(var9.length != 0) {
               zzbk.zza(var9, this.zztq, this.zztp, var4);
            }
         }

         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            zzbk.zza var7 = (zzbk.zza)var6.next();

            try {
               var3.write(this.zzts.zzu(var7.zztx));
            } catch (IOException var10) {
               zzin.zzb("Error while writing hash to byteStream", var10);
               break;
            }
         }

         return var3.toString();
      }
   }

   static class zza {
      ByteArrayOutputStream zztu = new ByteArrayOutputStream(4096);
      Base64OutputStream zztv;

      public zza() {
         this.zztv = new Base64OutputStream(this.zztu, 10);
      }

      public String toString() {
         try {
            this.zztv.close();
         } catch (IOException var8) {
            zzin.zzb("HashManager: Unable to convert to Base64.", var8);
         }

         try {
            this.zztu.close();
            String var4 = this.zztu.toString();
            return var4;
         } catch (IOException var9) {
            zzin.zzb("HashManager: Unable to convert to Base64.", var9);
         } finally {
            this.zztu = null;
            this.zztv = null;
         }

         return "";
      }

      public void write(byte[] var1) throws IOException {
         this.zztv.write(var1);
      }
   }
}
