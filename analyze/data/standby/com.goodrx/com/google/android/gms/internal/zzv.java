package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzs;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzv implements zzb {
   private final int zzaA;
   private final Map<String, zzv.zza> zzax;
   private long zzay;
   private final File zzaz;

   public zzv(File var1) {
      this(var1, 5242880);
   }

   public zzv(File var1, int var2) {
      this.zzax = new LinkedHashMap(16, 0.75F, true);
      this.zzay = 0L;
      this.zzaz = var1;
      this.zzaA = var2;
   }

   private void removeEntry(String var1) {
      zzv.zza var2 = (zzv.zza)this.zzax.get(var1);
      if(var2 != null) {
         this.zzay -= var2.zzaB;
         this.zzax.remove(var1);
      }

   }

   private static int zza(InputStream var0) throws IOException {
      int var1 = var0.read();
      if(var1 == -1) {
         throw new EOFException();
      } else {
         return var1;
      }
   }

   static void zza(OutputStream var0, int var1) throws IOException {
      var0.write(255 & var1 >> 0);
      var0.write(255 & var1 >> 8);
      var0.write(255 & var1 >> 16);
      var0.write(255 & var1 >> 24);
   }

   static void zza(OutputStream var0, long var1) throws IOException {
      var0.write((byte)((int)(var1 >>> 0)));
      var0.write((byte)((int)(var1 >>> 8)));
      var0.write((byte)((int)(var1 >>> 16)));
      var0.write((byte)((int)(var1 >>> 24)));
      var0.write((byte)((int)(var1 >>> 32)));
      var0.write((byte)((int)(var1 >>> 40)));
      var0.write((byte)((int)(var1 >>> 48)));
      var0.write((byte)((int)(var1 >>> 56)));
   }

   static void zza(OutputStream var0, String var1) throws IOException {
      byte[] var2 = var1.getBytes("UTF-8");
      zza(var0, (long)var2.length);
      var0.write(var2, 0, var2.length);
   }

   private void zza(String var1, zzv.zza var2) {
      if(!this.zzax.containsKey(var1)) {
         this.zzay += var2.zzaB;
      } else {
         zzv.zza var3 = (zzv.zza)this.zzax.get(var1);
         this.zzay += var2.zzaB - var3.zzaB;
      }

      this.zzax.put(var1, var2);
   }

   static void zza(Map<String, String> var0, OutputStream var1) throws IOException {
      if(var0 != null) {
         zza(var1, var0.size());
         Iterator var2 = var0.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            zza(var1, (String)var3.getKey());
            zza(var1, (String)var3.getValue());
         }
      } else {
         zza((OutputStream)var1, 0);
      }

   }

   private static byte[] zza(InputStream var0, int var1) throws IOException {
      byte[] var2 = new byte[var1];

      int var3;
      int var4;
      for(var3 = 0; var3 < var1; var3 += var4) {
         var4 = var0.read(var2, var3, var1 - var3);
         if(var4 == -1) {
            break;
         }
      }

      if(var3 != var1) {
         throw new IOException("Expected " + var1 + " bytes, read " + var3 + " bytes");
      } else {
         return var2;
      }
   }

   static int zzb(InputStream var0) throws IOException {
      return 0 | zza(var0) << 0 | zza(var0) << 8 | zza(var0) << 16 | zza(var0) << 24;
   }

   static long zzc(InputStream var0) throws IOException {
      return 0L | (255L & (long)zza(var0)) << 0 | (255L & (long)zza(var0)) << 8 | (255L & (long)zza(var0)) << 16 | (255L & (long)zza(var0)) << 24 | (255L & (long)zza(var0)) << 32 | (255L & (long)zza(var0)) << 40 | (255L & (long)zza(var0)) << 48 | (255L & (long)zza(var0)) << 56;
   }

   private void zzc(int var1) {
      if(this.zzay + (long)var1 >= (long)this.zzaA) {
         if(zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
         }

         long var2 = this.zzay;
         long var4 = SystemClock.elapsedRealtime();
         Iterator var6 = this.zzax.entrySet().iterator();

         int var8;
         label30: {
            int var7;
            for(var7 = 0; var6.hasNext(); var7 = var8) {
               zzv.zza var10 = (zzv.zza)((Entry)var6.next()).getValue();
               if(this.zzf(var10.key).delete()) {
                  this.zzay -= var10.zzaB;
               } else {
                  Object[] var11 = new Object[]{var10.key, this.zze(var10.key)};
                  zzs.zzb("Could not delete cache entry for key=%s, filename=%s", var11);
               }

               var6.remove();
               var8 = var7 + 1;
               if((float)(this.zzay + (long)var1) < 0.9F * (float)this.zzaA) {
                  break label30;
               }
            }

            var8 = var7;
         }

         if(zzs.DEBUG) {
            Object[] var9 = new Object[]{Integer.valueOf(var8), Long.valueOf(this.zzay - var2), Long.valueOf(SystemClock.elapsedRealtime() - var4)};
            zzs.zza("pruned %d files, %d bytes, %d ms", var9);
            return;
         }
      }

   }

   static String zzd(InputStream var0) throws IOException {
      return new String(zza(var0, (int)zzc(var0)), "UTF-8");
   }

   private String zze(String var1) {
      int var2 = var1.length() / 2;
      String var3 = String.valueOf(var1.substring(0, var2).hashCode());
      return var3 + String.valueOf(var1.substring(var2).hashCode());
   }

   static Map<String, String> zze(InputStream var0) throws IOException {
      int var1 = zzb(var0);
      Object var2;
      if(var1 == 0) {
         var2 = Collections.emptyMap();
      } else {
         var2 = new HashMap(var1);
      }

      for(int var3 = 0; var3 < var1; ++var3) {
         ((Map)var2).put(zzd(var0).intern(), zzd(var0).intern());
      }

      return (Map)var2;
   }

   public void remove(String param1) {
      // $FF: Couldn't be decompiled
   }

   public zzb.zza zza(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void zza() {
      // $FF: Couldn't be decompiled
   }

   public void zza(String var1, zzb.zza var2) {
      synchronized(this){}

      try {
         this.zzc(var2.data.length);
         File var4 = this.zzf(var1);

         try {
            FileOutputStream var5 = new FileOutputStream(var4);
            zzv.zza var6 = new zzv.zza(var1, var2);
            if(!var6.zza(var5)) {
               var5.close();
               Object[] var9 = new Object[]{var4.getAbsolutePath()};
               zzs.zzb("Failed to write header for %s", var9);
               throw new IOException();
            }

            var5.write(var2.data);
            var5.close();
            this.zza(var1, var6);
         } catch (IOException var12) {
            if(!var4.delete()) {
               Object[] var8 = new Object[]{var4.getAbsolutePath()};
               zzs.zzb("Could not clean up file %s", var8);
            }
         }
      } finally {
         ;
      }

   }

   public File zzf(String var1) {
      return new File(this.zzaz, this.zze(var1));
   }

   static class zza {
      public String key;
      public long zzaB;
      public String zzb;
      public long zzc;
      public long zzd;
      public long zze;
      public long zzf;
      public Map<String, String> zzg;

      private zza() {
      }

      public zza(String var1, zzb.zza var2) {
         this.key = var1;
         this.zzaB = (long)var2.data.length;
         this.zzb = var2.zzb;
         this.zzc = var2.zzc;
         this.zzd = var2.zzd;
         this.zze = var2.zze;
         this.zzf = var2.zzf;
         this.zzg = var2.zzg;
      }

      public static zzv.zza zzf(InputStream var0) throws IOException {
         zzv.zza var1 = new zzv.zza();
         if(zzv.zzb(var0) != 538247942) {
            throw new IOException();
         } else {
            var1.key = zzv.zzd(var0);
            var1.zzb = zzv.zzd(var0);
            if(var1.zzb.equals("")) {
               var1.zzb = null;
            }

            var1.zzc = zzv.zzc(var0);
            var1.zzd = zzv.zzc(var0);
            var1.zze = zzv.zzc(var0);
            var1.zzf = zzv.zzc(var0);
            var1.zzg = zzv.zze(var0);
            return var1;
         }
      }

      public boolean zza(OutputStream param1) {
         // $FF: Couldn't be decompiled
      }

      public zzb.zza zzb(byte[] var1) {
         zzb.zza var2 = new zzb.zza();
         var2.data = var1;
         var2.zzb = this.zzb;
         var2.zzc = this.zzc;
         var2.zzd = this.zzd;
         var2.zze = this.zze;
         var2.zzf = this.zzf;
         var2.zzg = this.zzg;
         return var2;
      }
   }

   private static class zzb extends FilterInputStream {
      private int zzaC;

      private zzb(InputStream var1) {
         super(var1);
         this.zzaC = 0;
      }

      // $FF: synthetic method
      zzb(InputStream var1, Object var2) {
         this(var1);
      }

      // $FF: synthetic method
      static int zza(zzv.zzb var0) {
         return var0.zzaC;
      }

      public int read() throws IOException {
         int var1 = super.read();
         if(var1 != -1) {
            ++this.zzaC;
         }

         return var1;
      }

      public int read(byte[] var1, int var2, int var3) throws IOException {
         int var4 = super.read(var1, var2, var3);
         if(var4 != -1) {
            this.zzaC += var4;
         }

         return var4;
      }
   }
}
