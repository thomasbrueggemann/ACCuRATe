package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.internal.zzsw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzsr implements Cloneable {
   private zzsp<?, ?> zzbuq;
   private Object zzbur;
   private List<zzsw> zzbus = new ArrayList();

   private byte[] toByteArray() throws IOException {
      byte[] var1 = new byte[this.zzz()];
      this.writeTo(zzsn.zzE(var1));
      return var1;
   }

   // $FF: synthetic method
   public Object clone() throws CloneNotSupportedException {
      return this.zzJr();
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof zzsr;
         var3 = false;
         if(var2) {
            zzsr var4 = (zzsr)var1;
            if(this.zzbur == null || var4.zzbur == null) {
               if(this.zzbus != null && var4.zzbus != null) {
                  return this.zzbus.equals(var4.zzbus);
               } else {
                  try {
                     boolean var6 = Arrays.equals(this.toByteArray(), var4.toByteArray());
                     return var6;
                  } catch (IOException var9) {
                     throw new IllegalStateException(var9);
                  }
               }
            }

            zzsp var7 = this.zzbuq;
            zzsp var8 = var4.zzbuq;
            var3 = false;
            if(var7 == var8) {
               if(!this.zzbuq.zzbuk.isArray()) {
                  return this.zzbur.equals(var4.zzbur);
               }

               if(this.zzbur instanceof byte[]) {
                  return Arrays.equals((byte[])((byte[])this.zzbur), (byte[])((byte[])var4.zzbur));
               }

               if(this.zzbur instanceof int[]) {
                  return Arrays.equals((int[])((int[])this.zzbur), (int[])((int[])var4.zzbur));
               }

               if(this.zzbur instanceof long[]) {
                  return Arrays.equals((long[])((long[])this.zzbur), (long[])((long[])var4.zzbur));
               }

               if(this.zzbur instanceof float[]) {
                  return Arrays.equals((float[])((float[])this.zzbur), (float[])((float[])var4.zzbur));
               }

               if(this.zzbur instanceof double[]) {
                  return Arrays.equals((double[])((double[])this.zzbur), (double[])((double[])var4.zzbur));
               }

               if(this.zzbur instanceof boolean[]) {
                  return Arrays.equals((boolean[])((boolean[])this.zzbur), (boolean[])((boolean[])var4.zzbur));
               }

               return Arrays.deepEquals((Object[])((Object[])this.zzbur), (Object[])((Object[])var4.zzbur));
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      int var2;
      try {
         var2 = Arrays.hashCode(this.toByteArray());
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }

      return var2 + 527;
   }

   void writeTo(zzsn var1) throws IOException {
      if(this.zzbur != null) {
         this.zzbuq.zza(this.zzbur, var1);
      } else {
         Iterator var2 = this.zzbus.iterator();

         while(var2.hasNext()) {
            ((zzsw)var2.next()).writeTo(var1);
         }
      }

   }

   public final zzsr zzJr() {
      // $FF: Couldn't be decompiled
   }

   void zza(zzsw var1) {
      this.zzbus.add(var1);
   }

   <T> T zzb(zzsp<?, T> var1) {
      if(this.zzbur != null) {
         if(this.zzbuq != var1) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
         }
      } else {
         this.zzbuq = var1;
         this.zzbur = var1.zzJ(this.zzbus);
         this.zzbus = null;
      }

      return this.zzbur;
   }

   int zzz() {
      int var2;
      if(this.zzbur != null) {
         var2 = this.zzbuq.zzY(this.zzbur);
      } else {
         Iterator var1 = this.zzbus.iterator();

         for(var2 = 0; var1.hasNext(); var2 += ((zzsw)var1.next()).zzz()) {
            ;
         }
      }

      return var2;
   }
}
