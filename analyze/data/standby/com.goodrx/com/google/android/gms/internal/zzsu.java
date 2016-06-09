package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsv;
import java.io.IOException;

public abstract class zzsu {
   protected volatile int zzbuu = -1;

   public static final <T extends zzsu> T mergeFrom(T var0, byte[] var1) throws zzst {
      return mergeFrom(var0, var1, 0, var1.length);
   }

   public static final <T extends zzsu> T mergeFrom(T var0, byte[] var1, int var2, int var3) throws zzst {
      try {
         zzsm var6 = zzsm.zza(var1, var2, var3);
         var0.mergeFrom(var6);
         var6.zzmn(0);
         return var0;
      } catch (zzst var7) {
         throw var7;
      } catch (IOException var8) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
      }
   }

   public static final void toByteArray(zzsu var0, byte[] var1, int var2, int var3) {
      try {
         zzsn var5 = zzsn.zzb(var1, var2, var3);
         var0.writeTo(var5);
         var5.zzJo();
      } catch (IOException var6) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var6);
      }
   }

   public static final byte[] toByteArray(zzsu var0) {
      byte[] var1 = new byte[var0.getSerializedSize()];
      toByteArray(var0, var1, 0, var1.length);
      return var1;
   }

   public zzsu clone() throws CloneNotSupportedException {
      return (zzsu)super.clone();
   }

   public int getCachedSize() {
      if(this.zzbuu < 0) {
         this.getSerializedSize();
      }

      return this.zzbuu;
   }

   public int getSerializedSize() {
      int var1 = this.zzz();
      this.zzbuu = var1;
      return var1;
   }

   public abstract zzsu mergeFrom(zzsm var1) throws IOException;

   public String toString() {
      return zzsv.zzf(this);
   }

   public void writeTo(zzsn var1) throws IOException {
   }

   protected int zzz() {
      return 0;
   }
}
