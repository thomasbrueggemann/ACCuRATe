package com.google.android.gms.internal;

import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public final class zzsm {
   private final byte[] buffer;
   private int zzbtZ;
   private int zzbua;
   private int zzbub;
   private int zzbuc;
   private int zzbud;
   private int zzbue = Integer.MAX_VALUE;
   private int zzbuf;
   private int zzbug = 64;
   private int zzbuh = 67108864;

   private zzsm(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.zzbtZ = var2;
      this.zzbua = var2 + var3;
      this.zzbuc = var2;
   }

   public static zzsm zzD(byte[] var0) {
      return zza(var0, 0, var0.length);
   }

   private void zzJj() {
      this.zzbua += this.zzbub;
      int var1 = this.zzbua;
      if(var1 > this.zzbue) {
         this.zzbub = var1 - this.zzbue;
         this.zzbua -= this.zzbub;
      } else {
         this.zzbub = 0;
      }
   }

   public static zzsm zza(byte[] var0, int var1, int var2) {
      return new zzsm(var0, var1, var2);
   }

   public static long zzan(long var0) {
      return var0 >>> 1 ^ -(1L & var0);
   }

   public int getPosition() {
      return this.zzbuc - this.zzbtZ;
   }

   public byte[] readBytes() throws IOException {
      int var1 = this.zzJf();
      if(var1 <= this.zzbua - this.zzbuc && var1 > 0) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.zzbuc, var2, 0, var1);
         this.zzbuc += var1;
         return var2;
      } else {
         return var1 == 0?zzsx.zzbuD:this.zzmt(var1);
      }
   }

   public double readDouble() throws IOException {
      return Double.longBitsToDouble(this.zzJi());
   }

   public float readFloat() throws IOException {
      return Float.intBitsToFloat(this.zzJh());
   }

   public String readString() throws IOException {
      int var1 = this.zzJf();
      if(var1 <= this.zzbua - this.zzbuc && var1 > 0) {
         String var2 = new String(this.buffer, this.zzbuc, var1, "UTF-8");
         this.zzbuc += var1;
         return var2;
      } else {
         return new String(this.zzmt(var1), "UTF-8");
      }
   }

   public int zzIX() throws IOException {
      if(this.zzJl()) {
         this.zzbud = 0;
         return 0;
      } else {
         this.zzbud = this.zzJf();
         if(this.zzbud == 0) {
            throw zzst.zzJv();
         } else {
            return this.zzbud;
         }
      }
   }

   public void zzIY() throws IOException {
      int var1;
      do {
         var1 = this.zzIX();
      } while(var1 != 0 && this.zzmo(var1));

   }

   public long zzIZ() throws IOException {
      return this.zzJg();
   }

   public long zzJa() throws IOException {
      return this.zzJg();
   }

   public int zzJb() throws IOException {
      return this.zzJf();
   }

   public boolean zzJc() throws IOException {
      return this.zzJf() != 0;
   }

   public long zzJe() throws IOException {
      return zzan(this.zzJg());
   }

   public int zzJf() throws IOException {
      int var1 = this.zzJm();
      if(var1 < 0) {
         int var2 = var1 & 127;
         byte var3 = this.zzJm();
         if(var3 >= 0) {
            return var2 | var3 << 7;
         }

         int var4 = var2 | (var3 & 127) << 7;
         byte var5 = this.zzJm();
         if(var5 >= 0) {
            return var4 | var5 << 14;
         }

         int var6 = var4 | (var5 & 127) << 14;
         byte var7 = this.zzJm();
         if(var7 >= 0) {
            return var6 | var7 << 21;
         }

         int var8 = var6 | (var7 & 127) << 21;
         byte var9 = this.zzJm();
         var1 = var8 | var9 << 28;
         if(var9 < 0) {
            int var10 = 0;

            while(true) {
               if(var10 >= 5) {
                  throw zzst.zzJu();
               }

               if(this.zzJm() >= 0) {
                  break;
               }

               ++var10;
            }
         }
      }

      return var1;
   }

   public long zzJg() throws IOException {
      int var1 = 0;

      for(long var2 = 0L; var1 < 64; var1 += 7) {
         byte var4 = this.zzJm();
         var2 |= (long)(var4 & 127) << var1;
         if((var4 & 128) == 0) {
            return var2;
         }
      }

      throw zzst.zzJu();
   }

   public int zzJh() throws IOException {
      byte var1 = this.zzJm();
      byte var2 = this.zzJm();
      byte var3 = this.zzJm();
      byte var4 = this.zzJm();
      return var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24;
   }

   public long zzJi() throws IOException {
      byte var1 = this.zzJm();
      byte var2 = this.zzJm();
      byte var3 = this.zzJm();
      byte var4 = this.zzJm();
      byte var5 = this.zzJm();
      byte var6 = this.zzJm();
      byte var7 = this.zzJm();
      byte var8 = this.zzJm();
      return 255L & (long)var1 | (255L & (long)var2) << 8 | (255L & (long)var3) << 16 | (255L & (long)var4) << 24 | (255L & (long)var5) << 32 | (255L & (long)var6) << 40 | (255L & (long)var7) << 48 | (255L & (long)var8) << 56;
   }

   public int zzJk() {
      if(this.zzbue == Integer.MAX_VALUE) {
         return -1;
      } else {
         int var1 = this.zzbuc;
         return this.zzbue - var1;
      }
   }

   public boolean zzJl() {
      return this.zzbuc == this.zzbua;
   }

   public byte zzJm() throws IOException {
      if(this.zzbuc == this.zzbua) {
         throw zzst.zzJs();
      } else {
         byte[] var1 = this.buffer;
         int var2 = this.zzbuc;
         this.zzbuc = var2 + 1;
         return var1[var2];
      }
   }

   public void zza(zzsu var1) throws IOException {
      int var2 = this.zzJf();
      if(this.zzbuf >= this.zzbug) {
         throw zzst.zzJy();
      } else {
         int var3 = this.zzmq(var2);
         ++this.zzbuf;
         var1.mergeFrom(this);
         this.zzmn(0);
         this.zzbuf += -1;
         this.zzmr(var3);
      }
   }

   public void zza(zzsu var1, int var2) throws IOException {
      if(this.zzbuf >= this.zzbug) {
         throw zzst.zzJy();
      } else {
         ++this.zzbuf;
         var1.mergeFrom(this);
         this.zzmn(zzsx.zzF(var2, 4));
         this.zzbuf += -1;
      }
   }

   public void zzmn(int var1) throws zzst {
      if(this.zzbud != var1) {
         throw zzst.zzJw();
      }
   }

   public boolean zzmo(int var1) throws IOException {
      switch(zzsx.zzmI(var1)) {
      case 0:
         this.zzJb();
         return true;
      case 1:
         this.zzJi();
         return true;
      case 2:
         this.zzmu(this.zzJf());
         return true;
      case 3:
         this.zzIY();
         this.zzmn(zzsx.zzF(zzsx.zzmJ(var1), 4));
         return true;
      case 4:
         return false;
      case 5:
         this.zzJh();
         return true;
      default:
         throw zzst.zzJx();
      }
   }

   public int zzmq(int var1) throws zzst {
      if(var1 < 0) {
         throw zzst.zzJt();
      } else {
         int var2 = var1 + this.zzbuc;
         int var3 = this.zzbue;
         if(var2 > var3) {
            throw zzst.zzJs();
         } else {
            this.zzbue = var2;
            this.zzJj();
            return var3;
         }
      }
   }

   public void zzmr(int var1) {
      this.zzbue = var1;
      this.zzJj();
   }

   public void zzms(int var1) {
      if(var1 > this.zzbuc - this.zzbtZ) {
         throw new IllegalArgumentException("Position " + var1 + " is beyond current " + (this.zzbuc - this.zzbtZ));
      } else if(var1 < 0) {
         throw new IllegalArgumentException("Bad position " + var1);
      } else {
         this.zzbuc = var1 + this.zzbtZ;
      }
   }

   public byte[] zzmt(int var1) throws IOException {
      if(var1 < 0) {
         throw zzst.zzJt();
      } else if(var1 + this.zzbuc > this.zzbue) {
         this.zzmu(this.zzbue - this.zzbuc);
         throw zzst.zzJs();
      } else if(var1 <= this.zzbua - this.zzbuc) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.zzbuc, var2, 0, var1);
         this.zzbuc += var1;
         return var2;
      } else {
         throw zzst.zzJs();
      }
   }

   public void zzmu(int var1) throws IOException {
      if(var1 < 0) {
         throw zzst.zzJt();
      } else if(var1 + this.zzbuc > this.zzbue) {
         this.zzmu(this.zzbue - this.zzbuc);
         throw zzst.zzJs();
      } else if(var1 <= this.zzbua - this.zzbuc) {
         this.zzbuc += var1;
      } else {
         throw zzst.zzJs();
      }
   }

   public byte[] zzz(int var1, int var2) {
      if(var2 == 0) {
         return zzsx.zzbuD;
      } else {
         byte[] var3 = new byte[var2];
         int var4 = var1 + this.zzbtZ;
         System.arraycopy(this.buffer, var4, var3, 0, var2);
         return var3;
      }
   }
}
