package com.google.android.gms.internal;

import com.google.android.gms.internal.zzu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa extends ByteArrayOutputStream {
   private final zzu zzar;

   public zzaa(zzu var1, int var2) {
      this.zzar = var1;
      this.buf = this.zzar.zzb(Math.max(var2, 256));
   }

   private void zzd(int var1) {
      if(var1 + this.count > this.buf.length) {
         byte[] var2 = this.zzar.zzb(2 * (var1 + this.count));
         System.arraycopy(this.buf, 0, var2, 0, this.count);
         this.zzar.zza(this.buf);
         this.buf = var2;
      }
   }

   public void close() throws IOException {
      this.zzar.zza(this.buf);
      this.buf = null;
      super.close();
   }

   public void finalize() {
      this.zzar.zza(this.buf);
   }

   public void write(int var1) {
      synchronized(this){}

      try {
         this.zzd(1);
         super.write(var1);
      } finally {
         ;
      }

   }

   public void write(byte[] var1, int var2, int var3) {
      synchronized(this){}

      try {
         this.zzd(var3);
         super.write(var1, var2, var3);
      } finally {
         ;
      }

   }
}
