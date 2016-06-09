package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.zip.GZIPOutputStream;

public class zzaj extends zzy {
   zzaj(zzw var1) {
      super(var1);
   }

   public static boolean zzI(Bundle var0) {
      return var0.getLong("_c") == 1L;
   }

   public static boolean zzQ(String var0, String var1) {
      return var0 == null && var1 == null?true:(var0 == null?false:var0.equals(var1));
   }

   private Object zza(int var1, Object var2, boolean var3) {
      if(var2 == null) {
         var2 = null;
      } else if(!(var2 instanceof Long) && !(var2 instanceof Float)) {
         if(var2 instanceof Integer) {
            return Long.valueOf((long)((Integer)var2).intValue());
         }

         if(var2 instanceof Byte) {
            return Long.valueOf((long)((Byte)var2).byteValue());
         }

         if(var2 instanceof Short) {
            return Long.valueOf((long)((Short)var2).shortValue());
         }

         if(var2 instanceof Boolean) {
            long var4;
            if(((Boolean)var2).booleanValue()) {
               var4 = 1L;
            } else {
               var4 = 0L;
            }

            return Long.valueOf(var4);
         }

         if(var2 instanceof Double) {
            return Float.valueOf((float)((Double)var2).doubleValue());
         }

         if(!(var2 instanceof String) && !(var2 instanceof Character) && !(var2 instanceof CharSequence)) {
            return null;
         }

         var2 = String.valueOf(var2);
         if(((String)var2).length() > var1) {
            if(var3) {
               return ((String)var2).substring(0, var1);
            }

            return null;
         }
      }

      return var2;
   }

   private void zza(String var1, String var2, int var3, Object var4) {
      if(var4 == null) {
         this.zzAo().zzCH().zzj(var1 + " value can\'t be null. Ignoring " + var1, var2);
      } else if(!(var4 instanceof Long) && !(var4 instanceof Float) && !(var4 instanceof Integer) && !(var4 instanceof Byte) && !(var4 instanceof Short) && !(var4 instanceof Boolean) && !(var4 instanceof Double) && (var4 instanceof String || var4 instanceof Character || var4 instanceof CharSequence)) {
         String var5 = String.valueOf(var4);
         if(var5.length() > var3) {
            this.zzAo().zzCH().zze("Ignoring " + var1 + ". Value is too long. name, value length", var2, Integer.valueOf(var5.length()));
            return;
         }
      }

   }

   private static void zza(StringBuilder var0, int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         var0.append("  ");
      }

   }

   private static void zza(StringBuilder var0, int var1, zzqb.zze var2) {
      if(var2 != null) {
         zza(var0, var1);
         var0.append("bundle {\n");
         zza(var0, var1, "protocol_version", (Object)var2.zzbal);
         zza(var0, var1, "platform", (Object)var2.zzbat);
         zza(var0, var1, "gmp_version", (Object)var2.zzbax);
         zza(var0, var1, "uploading_gmp_version", (Object)var2.zzbay);
         zza(var0, var1, "gmp_app_id", (Object)var2.zzaVt);
         zza(var0, var1, "app_id", (Object)var2.appId);
         zza(var0, var1, "app_version", (Object)var2.zzaMV);
         zza(var0, var1, "dev_cert_hash", (Object)var2.zzbaC);
         zza(var0, var1, "app_store", (Object)var2.zzaVu);
         zza(var0, var1, "upload_timestamp_millis", (Object)var2.zzbao);
         zza(var0, var1, "start_timestamp_millis", (Object)var2.zzbap);
         zza(var0, var1, "end_timestamp_millis", (Object)var2.zzbaq);
         zza(var0, var1, "previous_bundle_start_timestamp_millis", (Object)var2.zzbar);
         zza(var0, var1, "previous_bundle_end_timestamp_millis", (Object)var2.zzbas);
         zza(var0, var1, "app_instance_id", (Object)var2.zzbaB);
         zza(var0, var1, "resettable_device_id", (Object)var2.zzbaz);
         zza(var0, var1, "limited_ad_tracking", (Object)var2.zzbaA);
         zza(var0, var1, "os_version", (Object)var2.osVersion);
         zza(var0, var1, "device_model", (Object)var2.zzbau);
         zza(var0, var1, "user_default_language", (Object)var2.zzbav);
         zza(var0, var1, "time_zone_offset_minutes", (Object)var2.zzbaw);
         zza(var0, var1, "bundle_sequential_index", (Object)var2.zzbaD);
         zza(var0, var1, "service_upload", (Object)var2.zzbaE);
         zza(var0, var1, "health_monitor", (Object)var2.zzaVx);
         zza(var0, var1, var2.zzban);
         zza(var0, var1, var2.zzbaF);
         zza(var0, var1, var2.zzbam);
         zza(var0, var1);
         var0.append("}\n");
      }
   }

   private static void zza(StringBuilder var0, int var1, String var2, zzqb.zzf var3) {
      int var4 = 0;
      if(var3 != null) {
         int var5 = var1 + 1;
         zza(var0, var5);
         var0.append(var2);
         var0.append(" {\n");
         if(var3.zzbaH != null) {
            zza(var0, var5 + 1);
            var0.append("results: ");
            long[] var19 = var3.zzbaH;
            int var20 = var19.length;
            int var21 = 0;

            int var25;
            for(int var22 = 0; var21 < var20; var22 = var25) {
               Long var24 = Long.valueOf(var19[var21]);
               var25 = var22 + 1;
               if(var22 != 0) {
                  var0.append(", ");
               }

               var0.append(var24);
               ++var21;
            }

            var0.append('\n');
         }

         if(var3.zzbaG != null) {
            zza(var0, var5 + 1);
            var0.append("status: ");
            long[] var10 = var3.zzbaG;
            int var11 = var10.length;

            int var15;
            for(int var12 = 0; var4 < var11; var12 = var15) {
               Long var14 = Long.valueOf(var10[var4]);
               var15 = var12 + 1;
               if(var12 != 0) {
                  var0.append(", ");
               }

               var0.append(var14);
               ++var4;
            }

            var0.append('\n');
         }

         zza(var0, var5);
         var0.append("}\n");
      }
   }

   private static void zza(StringBuilder var0, int var1, String var2, Object var3) {
      if(var3 != null) {
         zza(var0, var1 + 1);
         var0.append(var2);
         var0.append(": ");
         var0.append(var3);
         var0.append('\n');
      }
   }

   private static void zza(StringBuilder var0, int var1, zzqb.zza[] var2) {
      if(var2 != null) {
         int var3 = var1 + 1;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zzqb.zza var6 = var2[var5];
            if(var6 != null) {
               zza(var0, var3);
               var0.append("audience_membership {\n");
               zza(var0, var3, "audience_id", (Object)var6.zzaZr);
               zza(var0, var3, "new_audience", (Object)var6.zzbac);
               zza(var0, var3, "current_data", var6.zzbaa);
               zza(var0, var3, "previous_data", var6.zzbab);
               zza(var0, var3);
               var0.append("}\n");
            }
         }
      }

   }

   private static void zza(StringBuilder var0, int var1, zzqb.zzb[] var2) {
      if(var2 != null) {
         int var3 = var1 + 1;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zzqb.zzb var6 = var2[var5];
            if(var6 != null) {
               zza(var0, var3);
               var0.append("event {\n");
               zza(var0, var3, "name", (Object)var6.name);
               zza(var0, var3, "timestamp_millis", (Object)var6.zzbaf);
               zza(var0, var3, "previous_timestamp_millis", (Object)var6.zzbag);
               zza(var0, var3, "count", (Object)var6.count);
               zza(var0, var3, var6.zzbae);
               zza(var0, var3);
               var0.append("}\n");
            }
         }
      }

   }

   private static void zza(StringBuilder var0, int var1, zzqb.zzc[] var2) {
      if(var2 != null) {
         int var3 = var1 + 1;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zzqb.zzc var6 = var2[var5];
            if(var6 != null) {
               zza(var0, var3);
               var0.append("event {\n");
               zza(var0, var3, "name", (Object)var6.name);
               zza(var0, var3, "string_value", (Object)var6.zzamJ);
               zza(var0, var3, "int_value", (Object)var6.zzbai);
               zza(var0, var3, "float_value", (Object)var6.zzaZo);
               zza(var0, var3);
               var0.append("}\n");
            }
         }
      }

   }

   private static void zza(StringBuilder var0, int var1, zzqb.zzg[] var2) {
      if(var2 != null) {
         int var3 = var1 + 1;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zzqb.zzg var6 = var2[var5];
            if(var6 != null) {
               zza(var0, var3);
               var0.append("user_property {\n");
               zza(var0, var3, "set_timestamp_millis", (Object)var6.zzbaJ);
               zza(var0, var3, "name", (Object)var6.name);
               zza(var0, var3, "string_value", (Object)var6.zzamJ);
               zza(var0, var3, "int_value", (Object)var6.zzbai);
               zza(var0, var3, "float_value", (Object)var6.zzaZo);
               zza(var0, var3);
               var0.append("}\n");
            }
         }
      }

   }

   public static boolean zza(Context param0, Class<? extends Service> param1) {
      // $FF: Couldn't be decompiled
   }

   public static boolean zza(Context param0, Class<? extends BroadcastReceiver> param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public static boolean zza(long[] var0, int var1) {
      return var1 < 64 * var0.length && (var0[var1 / 64] & 1L << var1 % 64) != 0L;
   }

   public static long[] zza(BitSet var0) {
      int var1 = (63 + var0.length()) / 64;
      long[] var2 = new long[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = 0L;

         for(int var4 = 0; var4 < 64 && var4 + var3 * 64 < var0.length(); ++var4) {
            if(var0.get(var4 + var3 * 64)) {
               var2[var3] |= 1L << var4;
            }
         }
      }

      return var2;
   }

   public static String zzb(zzqb.zzd var0) {
      if(var0 == null) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append("\nbatch {\n");
         if(var0.zzbaj != null) {
            zzqb.zze[] var4 = var0.zzbaj;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               zzqb.zze var7 = var4[var6];
               if(var7 != null) {
                  zza(var1, 1, (zzqb.zze)var7);
               }
            }
         }

         var1.append("}\n");
         return var1.toString();
      }
   }

   static MessageDigest zzbv(String var0) {
      for(int var1 = 0; var1 < 2; ++var1) {
         MessageDigest var3;
         try {
            var3 = MessageDigest.getInstance(var0);
         } catch (NoSuchAlgorithmException var4) {
            continue;
         }

         if(var3 != null) {
            return var3;
         }
      }

      return null;
   }

   static boolean zzfq(String var0) {
      com.google.android.gms.common.internal.zzx.zzcM(var0);
      char var2 = var0.charAt(0);
      boolean var3 = false;
      if(var2 != 95) {
         var3 = true;
      }

      return var3;
   }

   private int zzfu(String var1) {
      return "_ldl".equals(var1)?this.zzCp().zzBG():this.zzCp().zzBF();
   }

   public static boolean zzfv(String var0) {
      return !TextUtils.isEmpty(var0) && var0.startsWith("_");
   }

   static long zzq(byte[] var0) {
      int var1 = 0;
      com.google.android.gms.common.internal.zzx.zzz(var0);
      boolean var3;
      if(var0.length > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      com.google.android.gms.common.internal.zzx.zzab(var3);
      long var4 = 0L;

      for(int var6 = -1 + var0.length; var6 >= 0 && var6 >= -8 + var0.length; --var6) {
         var4 += (255L & (long)var0[var6]) << var1;
         var1 += 8;
      }

      return var4;
   }

   public void zza(Bundle var1, String var2, Object var3) {
      if(var3 instanceof Long) {
         var1.putLong(var2, ((Long)var3).longValue());
      } else {
         if(var3 instanceof Float) {
            var1.putFloat(var2, ((Float)var3).floatValue());
            return;
         }

         if(var3 instanceof String) {
            var1.putString(var2, String.valueOf(var3));
            return;
         }

         if(var2 != null) {
            this.zzAo().zzCH().zze("Not putting event parameter. Invalid value type. name, type", var2, var3.getClass().getSimpleName());
            return;
         }
      }

   }

   public void zza(zzqb.zzc var1, Object var2) {
      com.google.android.gms.common.internal.zzx.zzz(var2);
      var1.zzamJ = null;
      var1.zzbai = null;
      var1.zzaZo = null;
      if(var2 instanceof String) {
         var1.zzamJ = (String)var2;
      } else if(var2 instanceof Long) {
         var1.zzbai = (Long)var2;
      } else if(var2 instanceof Float) {
         var1.zzaZo = (Float)var2;
      } else {
         this.zzAo().zzCE().zzj("Ignoring invalid (type) event param value", var2);
      }
   }

   public void zza(zzqb.zzg var1, Object var2) {
      com.google.android.gms.common.internal.zzx.zzz(var2);
      var1.zzamJ = null;
      var1.zzbai = null;
      var1.zzaZo = null;
      if(var2 instanceof String) {
         var1.zzamJ = (String)var2;
      } else if(var2 instanceof Long) {
         var1.zzbai = (Long)var2;
      } else if(var2 instanceof Float) {
         var1.zzaZo = (Float)var2;
      } else {
         this.zzAo().zzCE().zzj("Ignoring invalid (type) user attribute value", var2);
      }
   }

   public byte[] zza(zzqb.zzd var1) {
      try {
         byte[] var3 = new byte[var1.getSerializedSize()];
         zzsn var4 = zzsn.zzE(var3);
         var1.writeTo(var4);
         var4.zzJo();
         return var3;
      } catch (IOException var5) {
         this.zzAo().zzCE().zzj("Data loss. Failed to serialize batch", var5);
         return null;
      }
   }

   @WorkerThread
   public boolean zzbk(String var1) {
      this.zzjk();
      if(this.getContext().checkCallingOrSelfPermission(var1) == 0) {
         return true;
      } else {
         this.zzAo().zzCJ().zzj("Permission not granted", var1);
         return false;
      }
   }

   void zzc(String var1, int var2, String var3) {
      if(var3 == null) {
         throw new IllegalArgumentException(var1 + " name is required and can\'t be null");
      } else if(var3.length() == 0) {
         throw new IllegalArgumentException(var1 + " name is required and can\'t be empty");
      } else {
         char var4 = var3.charAt(0);
         if(!Character.isLetter(var4) && var4 != 95) {
            throw new IllegalArgumentException(var1 + " name must start with a letter or _");
         } else {
            for(int var5 = 1; var5 < var3.length(); ++var5) {
               char var6 = var3.charAt(var5);
               if(var6 != 95 && !Character.isLetterOrDigit(var6)) {
                  throw new IllegalArgumentException(var1 + " name must consist of letters, digits or _ (underscores)");
               }
            }

            if(var3.length() > var2) {
               throw new IllegalArgumentException(var1 + " name is too long. The maximum supported length is " + var2);
            }
         }
      }
   }

   public boolean zzc(long var1, long var3) {
      return var1 == 0L || var3 <= 0L || Math.abs(this.zzjl().currentTimeMillis() - var1) > var3;
   }

   public void zzfr(String var1) {
      this.zzc("event", this.zzCp().zzBB(), var1);
   }

   public void zzfs(String var1) {
      this.zzc("user attribute", this.zzCp().zzBC(), var1);
   }

   public void zzft(String var1) {
      this.zzc("event param", this.zzCp().zzBC(), var1);
   }

   public byte[] zzg(byte[] var1) throws IOException {
      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         GZIPOutputStream var3 = new GZIPOutputStream(var2);
         var3.write(var1);
         var3.close();
         var2.close();
         byte[] var5 = var2.toByteArray();
         return var5;
      } catch (IOException var6) {
         this.zzAo().zzCE().zzj("Failed to gzip content", var6);
         throw var6;
      }
   }

   public Object zzk(String var1, Object var2) {
      int var3;
      if(zzfv(var1)) {
         var3 = this.zzCp().zzBE();
      } else {
         var3 = this.zzCp().zzBD();
      }

      return this.zza(var3, var2, false);
   }

   public void zzl(String var1, Object var2) {
      if("_ldl".equals(var1)) {
         this.zza("user attribute referrer", var1, this.zzfu(var1), var2);
      } else {
         this.zza("user attribute", var1, this.zzfu(var1), var2);
      }
   }

   public Object zzm(String var1, Object var2) {
      return "_ldl".equals(var1)?this.zza(this.zzfu(var1), var2, true):this.zza(this.zzfu(var1), var2, false);
   }

   public byte[] zzp(byte[] param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public long zzr(byte[] var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      MessageDigest var3 = zzbv("MD5");
      if(var3 == null) {
         this.zzAo().zzCE().zzfg("Failed to get MD5");
         return 0L;
      } else {
         return zzq(var3.digest(var1));
      }
   }
}
