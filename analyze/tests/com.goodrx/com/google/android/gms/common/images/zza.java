package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.lang.ref.WeakReference;

public abstract class zza {
   final zza.zza zzajO;
   protected int zzajQ;
   protected ImageManager.OnImageLoadedListener zzajS;
   protected int zzajW;

   private Drawable zza(Context var1, zzmd var2, int var3) {
      Resources var4 = var1.getResources();
      if(this.zzajW > 0) {
         zzmd.zza var5 = new zzmd.zza(var3, this.zzajW);
         Drawable var6 = (Drawable)var2.get(var5);
         if(var6 == null) {
            var6 = var4.getDrawable(var3);
            if((1 & this.zzajW) != 0) {
               var6 = this.zza(var4, var6);
            }

            var2.put(var5, var6);
         }

         return var6;
      } else {
         return var4.getDrawable(var3);
      }
   }

   protected Drawable zza(Resources var1, Drawable var2) {
      return zzmb.zza(var1, var2);
   }

   void zza(Context var1, Bitmap var2, boolean var3) {
      com.google.android.gms.common.internal.zzb.zzv(var2);
      if((1 & this.zzajW) != 0) {
         var2 = zzmb.zzb(var2);
      }

      BitmapDrawable var4 = new BitmapDrawable(var1.getResources(), var2);
      if(this.zzajS != null) {
         this.zzajS.onImageLoaded(this.zzajO.uri, var4, true);
      }

      this.zza(var4, var3, false, true);
   }

   void zza(Context var1, zzmd var2, boolean var3) {
      int var4 = this.zzajQ;
      Drawable var5 = null;
      if(var4 != 0) {
         var5 = this.zza(var1, var2, this.zzajQ);
      }

      if(this.zzajS != null) {
         this.zzajS.onImageLoaded(this.zzajO.uri, var5, false);
      }

      this.zza(var5, var3, false, false);
   }

   protected abstract void zza(Drawable var1, boolean var2, boolean var3, boolean var4);

   static final class zza {
      public final Uri uri;

      public zza(Uri var1) {
         this.uri = var1;
      }

      public boolean equals(Object var1) {
         return !(var1 instanceof zza.zza)?false:(this == var1?true:zzw.equal(((zza.zza)var1).uri, this.uri));
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.uri};
         return zzw.hashCode(var1);
      }
   }

   public static final class zzc extends zza {
      private WeakReference<ImageManager.OnImageLoadedListener> zzajY;

      public boolean equals(Object var1) {
         if(!(var1 instanceof zza.zzc)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            zza.zzc var2 = (zza.zzc)var1;
            ImageManager.OnImageLoadedListener var3 = (ImageManager.OnImageLoadedListener)this.zzajY.get();
            ImageManager.OnImageLoadedListener var4 = (ImageManager.OnImageLoadedListener)var2.zzajY.get();
            boolean var5;
            if(var4 != null && var3 != null && zzw.equal(var4, var3) && zzw.equal(var2.zzajO, this.zzajO)) {
               var5 = true;
            } else {
               var5 = false;
            }

            return var5;
         }
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.zzajO};
         return zzw.hashCode(var1);
      }

      protected void zza(Drawable var1, boolean var2, boolean var3, boolean var4) {
         if(!var3) {
            ImageManager.OnImageLoadedListener var5 = (ImageManager.OnImageLoadedListener)this.zzajY.get();
            if(var5 != null) {
               var5.onImageLoaded(this.zzajO.uri, var1, var4);
            }
         }

      }
   }
}
