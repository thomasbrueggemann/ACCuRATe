package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzsp<M extends zzso<M>, T> {
   public final int tag;
   protected final int type;
   protected final Class<T> zzbuk;
   protected final boolean zzbul;

   private zzsp(int var1, Class<T> var2, int var3, boolean var4) {
      this.type = var1;
      this.zzbuk = var2;
      this.tag = var3;
      this.zzbul = var4;
   }

   private T zzK(List<zzsw> var1) {
      int var2 = 0;
      ArrayList var3 = new ArrayList();

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         zzsw var7 = (zzsw)var1.get(var4);
         if(var7.zzbuv.length != 0) {
            this.zza((zzsw)var7, (List)var3);
         }
      }

      int var5 = var3.size();
      Object var6;
      if(var5 == 0) {
         var6 = null;
      } else {
         for(var6 = this.zzbuk.cast(Array.newInstance(this.zzbuk.getComponentType(), var5)); var2 < var5; ++var2) {
            Array.set(var6, var2, var3.get(var2));
         }
      }

      return var6;
   }

   private T zzL(List<zzsw> var1) {
      if(var1.isEmpty()) {
         return null;
      } else {
         zzsw var2 = (zzsw)var1.get(-1 + var1.size());
         return this.zzbuk.cast(this.zzP(zzsm.zzD(var2.zzbuv)));
      }
   }

   public static <M extends zzso<M>, T extends zzsu> zzsp<M, T> zza(int var0, Class<T> var1, long var2) {
      return new zzsp(var0, var1, (int)var2, false);
   }

   final T zzJ(List<zzsw> var1) {
      return var1 == null?null:(this.zzbul?this.zzK(var1):this.zzL(var1));
   }

   protected Object zzP(zzsm var1) {
      Class var2;
      if(this.zzbul) {
         var2 = this.zzbuk.getComponentType();
      } else {
         var2 = this.zzbuk;
      }

      try {
         switch(this.type) {
         case 10:
            zzsu var7 = (zzsu)var2.newInstance();
            var1.zza(var7, zzsx.zzmJ(this.tag));
            return var7;
         case 11:
            zzsu var6 = (zzsu)var2.newInstance();
            var1.zza(var6);
            return var6;
         default:
            throw new IllegalArgumentException("Unknown type " + this.type);
         }
      } catch (InstantiationException var8) {
         throw new IllegalArgumentException("Error creating instance of class " + var2, var8);
      } catch (IllegalAccessException var9) {
         throw new IllegalArgumentException("Error creating instance of class " + var2, var9);
      } catch (IOException var10) {
         throw new IllegalArgumentException("Error reading extension field", var10);
      }
   }

   int zzY(Object var1) {
      return this.zzbul?this.zzZ(var1):this.zzaa(var1);
   }

   protected int zzZ(Object var1) {
      int var2 = 0;
      int var3 = Array.getLength(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(Array.get(var1, var4) != null) {
            var2 += this.zzaa(Array.get(var1, var4));
         }
      }

      return var2;
   }

   protected void zza(zzsw var1, List<Object> var2) {
      var2.add(this.zzP(zzsm.zzD(var1.zzbuv)));
   }

   void zza(Object var1, zzsn var2) throws IOException {
      if(this.zzbul) {
         this.zzc(var1, var2);
      } else {
         this.zzb(var1, var2);
      }
   }

   protected int zzaa(Object var1) {
      int var2 = zzsx.zzmJ(this.tag);
      switch(this.type) {
      case 10:
         return zzsn.zzb(var2, (zzsu)var1);
      case 11:
         return zzsn.zzc(var2, (zzsu)var1);
      default:
         throw new IllegalArgumentException("Unknown type " + this.type);
      }
   }

   protected void zzb(Object var1, zzsn var2) {
      try {
         var2.zzmB(this.tag);
         switch(this.type) {
         case 10:
            zzsu var4 = (zzsu)var1;
            int var5 = zzsx.zzmJ(this.tag);
            var2.zzb(var4);
            var2.zzE(var5, 4);
            return;
         case 11:
            var2.zzc((zzsu)var1);
            return;
         default:
            throw new IllegalArgumentException("Unknown type " + this.type);
         }
      } catch (IOException var6) {
         throw new IllegalStateException(var6);
      }
   }

   protected void zzc(Object var1, zzsn var2) {
      int var3 = Array.getLength(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = Array.get(var1, var4);
         if(var5 != null) {
            this.zzb(var5, var2);
         }
      }

   }
}
