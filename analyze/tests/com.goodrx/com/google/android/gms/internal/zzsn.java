package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzsn {
   private final ByteBuffer zzbui;

   private zzsn(ByteBuffer var1) {
      this.zzbui = var1;
      this.zzbui.order(ByteOrder.LITTLE_ENDIAN);
   }

   private zzsn(byte[] var1, int var2, int var3) {
      this(ByteBuffer.wrap(var1, var2, var3));
   }

   public static int zzC(int var0, int var1) {
      return zzmA(var0) + zzmx(var1);
   }

   public static zzsn zzE(byte[] var0) {
      return zzb(var0, 0, var0.length);
   }

   public static int zzG(byte[] var0) {
      return zzmC(var0.length) + var0.length;
   }

   private static int zza(CharSequence var0, int var1) {
      int var2 = var0.length();
      int var3 = 0;

      for(int var4 = var1; var4 < var2; ++var4) {
         char var5 = var0.charAt(var4);
         if(var5 < 2048) {
            var3 += 127 - var5 >>> 31;
         } else {
            var3 += 2;
            if('\ud800' <= var5 && var5 <= '\udfff') {
               if(Character.codePointAt(var0, var4) < 65536) {
                  throw new IllegalArgumentException("Unpaired surrogate at index " + var4);
               }

               ++var4;
            }
         }
      }

      return var3;
   }

   private static int zza(CharSequence var0, byte[] var1, int var2, int var3) {
      int var4 = var0.length();
      int var5 = 0;

      int var6;
      for(var6 = var2 + var3; var5 < var4 && var5 + var2 < var6; ++var5) {
         char var18 = var0.charAt(var5);
         if(var18 >= 128) {
            break;
         }

         var1[var2 + var5] = (byte)var18;
      }

      if(var5 == var4) {
         return var2 + var4;
      } else {
         int var7 = var2 + var5;

         while(true) {
            if(var5 >= var4) {
               return var7;
            }

            char var8 = var0.charAt(var5);
            int var14;
            if(var8 < 128 && var7 < var6) {
               var14 = var7 + 1;
               var1[var7] = (byte)var8;
            } else if(var8 < 2048 && var7 <= var6 - 2) {
               int var17 = var7 + 1;
               var1[var7] = (byte)(960 | var8 >>> 6);
               var14 = var17 + 1;
               var1[var17] = (byte)(128 | var8 & 63);
            } else if((var8 < '\ud800' || '\udfff' < var8) && var7 <= var6 - 3) {
               int var15 = var7 + 1;
               var1[var7] = (byte)(480 | var8 >>> 12);
               int var16 = var15 + 1;
               var1[var15] = (byte)(128 | 63 & var8 >>> 6);
               var14 = var16 + 1;
               var1[var16] = (byte)(128 | var8 & 63);
            } else {
               if(var7 > var6 - 4) {
                  if('\ud800' <= var8 && var8 <= '\udfff' && (var5 + 1 == var0.length() || !Character.isSurrogatePair(var8, var0.charAt(var5 + 1)))) {
                     throw new IllegalArgumentException("Unpaired surrogate at index " + var5);
                  }

                  throw new ArrayIndexOutOfBoundsException("Failed writing " + var8 + " at index " + var7);
               }

               if(var5 + 1 == var0.length()) {
                  break;
               }

               ++var5;
               char var9 = var0.charAt(var5);
               if(!Character.isSurrogatePair(var8, var9)) {
                  break;
               }

               int var10 = Character.toCodePoint(var8, var9);
               int var11 = var7 + 1;
               var1[var7] = (byte)(240 | var10 >>> 18);
               int var12 = var11 + 1;
               var1[var11] = (byte)(128 | 63 & var10 >>> 12);
               int var13 = var12 + 1;
               var1[var12] = (byte)(128 | 63 & var10 >>> 6);
               var14 = var13 + 1;
               var1[var13] = (byte)(128 | var10 & 63);
            }

            ++var5;
            var7 = var14;
         }

         throw new IllegalArgumentException("Unpaired surrogate at index " + (var5 - 1));
      }
   }

   private static void zza(CharSequence var0, ByteBuffer var1) {
      if(var1.isReadOnly()) {
         throw new ReadOnlyBufferException();
      } else if(var1.hasArray()) {
         try {
            var1.position(zza(var0, var1.array(), var1.arrayOffset() + var1.position(), var1.remaining()) - var1.arrayOffset());
         } catch (ArrayIndexOutOfBoundsException var4) {
            BufferOverflowException var3 = new BufferOverflowException();
            var3.initCause(var4);
            throw var3;
         }
      } else {
         zzb(var0, var1);
      }
   }

   public static int zzaA(boolean var0) {
      return 1;
   }

   public static int zzar(long var0) {
      return zzav(var0);
   }

   public static int zzas(long var0) {
      return zzav(var0);
   }

   public static int zzat(long var0) {
      return zzav(zzax(var0));
   }

   public static int zzav(long var0) {
      return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((Long.MIN_VALUE & var0) == 0L?9:10))))))));
   }

   public static long zzax(long var0) {
      return var0 << 1 ^ var0 >> 63;
   }

   public static int zzb(int var0, double var1) {
      return zzmA(var0) + zzl(var1);
   }

   public static int zzb(int var0, zzsu var1) {
      return 2 * zzmA(var0) + zzd(var1);
   }

   public static int zzb(int var0, byte[] var1) {
      return zzmA(var0) + zzG(var1);
   }

   public static zzsn zzb(byte[] var0, int var1, int var2) {
      return new zzsn(var0, var1, var2);
   }

   private static void zzb(CharSequence var0, ByteBuffer var1) {
      int var2 = var0.length();
      int var3 = 0;

      while(true) {
         if(var3 >= var2) {
            return;
         }

         char var4 = var0.charAt(var3);
         if(var4 < 128) {
            var1.put((byte)var4);
         } else if(var4 < 2048) {
            var1.put((byte)(960 | var4 >>> 6));
            var1.put((byte)(128 | var4 & 63));
         } else if(var4 >= '\ud800' && '\udfff' >= var4) {
            if(var3 + 1 == var0.length()) {
               break;
            }

            ++var3;
            char var8 = var0.charAt(var3);
            if(!Character.isSurrogatePair(var4, var8)) {
               break;
            }

            int var9 = Character.toCodePoint(var4, var8);
            var1.put((byte)(240 | var9 >>> 18));
            var1.put((byte)(128 | 63 & var9 >>> 12));
            var1.put((byte)(128 | 63 & var9 >>> 6));
            var1.put((byte)(128 | var9 & 63));
         } else {
            var1.put((byte)(480 | var4 >>> 12));
            var1.put((byte)(128 | 63 & var4 >>> 6));
            var1.put((byte)(128 | var4 & 63));
         }

         ++var3;
      }

      throw new IllegalArgumentException("Unpaired surrogate at index " + (var3 - 1));
   }

   public static int zzc(int var0, float var1) {
      return zzmA(var0) + zzk(var1);
   }

   public static int zzc(int var0, zzsu var1) {
      return zzmA(var0) + zze(var1);
   }

   private static int zzc(CharSequence var0) {
      int var1 = var0.length();

      int var2;
      for(var2 = 0; var2 < var1 && var0.charAt(var2) < 128; ++var2) {
         ;
      }

      int var3 = var2;

      int var4;
      int var6;
      for(var4 = var1; var3 < var1; var4 = var6) {
         char var5 = var0.charAt(var3);
         if(var5 >= 2048) {
            var4 += zza(var0, var3);
            break;
         }

         var6 = var4 + (127 - var5 >>> 31);
         ++var3;
      }

      if(var4 < var1) {
         throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (4294967296L + (long)var4));
      } else {
         return var4;
      }
   }

   public static int zzd(int var0, long var1) {
      return zzmA(var0) + zzas(var1);
   }

   public static int zzd(zzsu var0) {
      return var0.getSerializedSize();
   }

   public static int zze(int var0, long var1) {
      return zzmA(var0) + zzat(var1);
   }

   public static int zze(zzsu var0) {
      int var1 = var0.getSerializedSize();
      return var1 + zzmC(var1);
   }

   public static int zzf(int var0, boolean var1) {
      return zzmA(var0) + zzaA(var1);
   }

   public static int zzgO(String var0) {
      int var1 = zzc((CharSequence)var0);
      return var1 + zzmC(var1);
   }

   public static int zzk(float var0) {
      return 4;
   }

   public static int zzl(double var0) {
      return 8;
   }

   public static int zzmA(int var0) {
      return zzmC(zzsx.zzF(var0, 0));
   }

   public static int zzmC(int var0) {
      return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
   }

   public static int zzmx(int var0) {
      return var0 >= 0?zzmC(var0):10;
   }

   public static int zzo(int var0, String var1) {
      return zzmA(var0) + zzgO(var1);
   }

   public void zzA(int var1, int var2) throws IOException {
      this.zzE(var1, 0);
      this.zzmv(var2);
   }

   public void zzE(int var1, int var2) throws IOException {
      this.zzmB(zzsx.zzF(var1, var2));
   }

   public void zzF(byte[] var1) throws IOException {
      this.zzmB(var1.length);
      this.zzH(var1);
   }

   public void zzH(byte[] var1) throws IOException {
      this.zzc(var1, 0, var1.length);
   }

   public int zzJn() {
      return this.zzbui.remaining();
   }

   public void zzJo() {
      if(this.zzJn() != 0) {
         throw new IllegalStateException("Did not write as much data as expected.");
      }
   }

   public void zza(int var1, double var2) throws IOException {
      this.zzE(var1, 1);
      this.zzk(var2);
   }

   public void zza(int var1, long var2) throws IOException {
      this.zzE(var1, 0);
      this.zzao(var2);
   }

   public void zza(int var1, zzsu var2) throws IOException {
      this.zzE(var1, 2);
      this.zzc(var2);
   }

   public void zza(int var1, byte[] var2) throws IOException {
      this.zzE(var1, 2);
      this.zzF(var2);
   }

   public void zzao(long var1) throws IOException {
      this.zzau(var1);
   }

   public void zzap(long var1) throws IOException {
      this.zzau(var1);
   }

   public void zzaq(long var1) throws IOException {
      this.zzau(zzax(var1));
   }

   public void zzau(long var1) throws IOException {
      while((-128L & var1) != 0L) {
         this.zzmz(128 | 127 & (int)var1);
         var1 >>>= 7;
      }

      this.zzmz((int)var1);
   }

   public void zzaw(long var1) throws IOException {
      if(this.zzbui.remaining() < 8) {
         throw new zzsn.zza(this.zzbui.position(), this.zzbui.limit());
      } else {
         this.zzbui.putLong(var1);
      }
   }

   public void zzaz(boolean var1) throws IOException {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.zzmz(var2);
   }

   public void zzb(byte var1) throws IOException {
      if(!this.zzbui.hasRemaining()) {
         throw new zzsn.zza(this.zzbui.position(), this.zzbui.limit());
      } else {
         this.zzbui.put(var1);
      }
   }

   public void zzb(int var1, float var2) throws IOException {
      this.zzE(var1, 5);
      this.zzj(var2);
   }

   public void zzb(int var1, long var2) throws IOException {
      this.zzE(var1, 0);
      this.zzap(var2);
   }

   public void zzb(zzsu var1) throws IOException {
      var1.writeTo(this);
   }

   public void zzc(int var1, long var2) throws IOException {
      this.zzE(var1, 0);
      this.zzaq(var2);
   }

   public void zzc(zzsu var1) throws IOException {
      this.zzmB(var1.getCachedSize());
      var1.writeTo(this);
   }

   public void zzc(byte[] var1, int var2, int var3) throws IOException {
      if(this.zzbui.remaining() >= var3) {
         this.zzbui.put(var1, var2, var3);
      } else {
         throw new zzsn.zza(this.zzbui.position(), this.zzbui.limit());
      }
   }

   public void zze(int var1, boolean var2) throws IOException {
      this.zzE(var1, 0);
      this.zzaz(var2);
   }

   public void zzgN(String var1) throws IOException {
      try {
         int var5 = zzmC(var1.length());
         if(var5 == zzmC(3 * var1.length())) {
            int var6 = this.zzbui.position();
            if(this.zzbui.remaining() < var5) {
               throw new zzsn.zza(var5 + var6, this.zzbui.limit());
            } else {
               this.zzbui.position(var6 + var5);
               zza(var1, this.zzbui);
               int var8 = this.zzbui.position();
               this.zzbui.position(var6);
               this.zzmB(var8 - var6 - var5);
               this.zzbui.position(var8);
            }
         } else {
            this.zzmB(zzc((CharSequence)var1));
            zza(var1, this.zzbui);
         }
      } catch (BufferOverflowException var9) {
         zzsn.zza var3 = new zzsn.zza(this.zzbui.position(), this.zzbui.limit());
         var3.initCause(var9);
         throw var3;
      }
   }

   public void zzj(float var1) throws IOException {
      this.zzmD(Float.floatToIntBits(var1));
   }

   public void zzk(double var1) throws IOException {
      this.zzaw(Double.doubleToLongBits(var1));
   }

   public void zzmB(int var1) throws IOException {
      while((var1 & -128) != 0) {
         this.zzmz(128 | var1 & 127);
         var1 >>>= 7;
      }

      this.zzmz(var1);
   }

   public void zzmD(int var1) throws IOException {
      if(this.zzbui.remaining() < 4) {
         throw new zzsn.zza(this.zzbui.position(), this.zzbui.limit());
      } else {
         this.zzbui.putInt(var1);
      }
   }

   public void zzmv(int var1) throws IOException {
      if(var1 >= 0) {
         this.zzmB(var1);
      } else {
         this.zzau((long)var1);
      }
   }

   public void zzmz(int var1) throws IOException {
      this.zzb((byte)var1);
   }

   public void zzn(int var1, String var2) throws IOException {
      this.zzE(var1, 2);
      this.zzgN(var2);
   }

   public static class zza extends IOException {
      zza(int var1, int var2) {
         super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
      }
   }
}
