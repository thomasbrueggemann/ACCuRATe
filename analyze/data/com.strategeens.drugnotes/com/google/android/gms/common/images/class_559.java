package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.internal.class_314;
import com.google.android.gms.internal.class_316;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_352;
import com.google.android.gms.internal.class_353;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.gms.common.images.a
public abstract class class_559 {
   // $FF: renamed from: LJ com.google.android.gms.common.images.a$a
   final class_559.class_1694 field_2617;
   // $FF: renamed from: LK int
   protected int field_2618 = 0;
   // $FF: renamed from: LL int
   protected int field_2619 = 0;
   // $FF: renamed from: LM boolean
   protected boolean field_2620 = false;
   // $FF: renamed from: LN com.google.android.gms.common.images.ImageManager$OnImageLoadedListener
   protected ImageManager.OnImageLoadedListener field_2621;
   // $FF: renamed from: LO boolean
   private boolean field_2622 = true;
   // $FF: renamed from: LP boolean
   private boolean field_2623 = false;
   // $FF: renamed from: LQ boolean
   private boolean field_2624 = true;
   // $FF: renamed from: LR int
   protected int field_2625;

   public class_559(Uri var1, int var2) {
      this.field_2617 = new class_559.class_1694(var1);
      this.field_2619 = var2;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.jc, int) android.graphics.drawable.Drawable
   private Drawable method_3426(Context var1, class_352 var2, int var3) {
      Resources var4 = var1.getResources();
      if(this.field_2625 > 0) {
         class_352.class_1620 var5 = new class_352.class_1620(var3, this.field_2625);
         Drawable var6 = (Drawable)var2.get(var5);
         if(var6 == null) {
            var6 = var4.getDrawable(var3);
            if((1 & this.field_2625) != 0) {
               var6 = this.method_3427(var4, var6);
            }

            var2.put(var5, var6);
         }

         return var6;
      } else {
         return var4.getDrawable(var3);
      }
   }

   // $FF: renamed from: a (android.content.res.Resources, android.graphics.drawable.Drawable) android.graphics.drawable.Drawable
   protected Drawable method_3427(Resources var1, Drawable var2) {
      return class_314.method_2209(var1, var2);
   }

   // $FF: renamed from: a (android.graphics.drawable.Drawable, android.graphics.drawable.Drawable) com.google.android.gms.internal.iz
   protected class_316 method_3428(Drawable var1, Drawable var2) {
      if(var1 != null) {
         if(var1 instanceof class_316) {
            var1 = ((class_316)var1).method_2214();
         }
      } else {
         var1 = null;
      }

      return new class_316(var1, var2);
   }

   // $FF: renamed from: a (android.content.Context, android.graphics.Bitmap, boolean) void
   void method_3429(Context var1, Bitmap var2, boolean var3) {
      class_349.method_2429(var2);
      if((1 & this.field_2625) != 0) {
         var2 = class_314.method_2207(var2);
      }

      BitmapDrawable var4 = new BitmapDrawable(var1.getResources(), var2);
      if(this.field_2621 != null) {
         this.field_2621.onImageLoaded(this.field_2617.uri, var4, true);
      }

      this.method_3432(var4, var3, false, true);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.jc) void
   void method_3430(Context var1, class_352 var2) {
      if(this.field_2624) {
         int var3 = this.field_2618;
         Drawable var4 = null;
         if(var3 != 0) {
            var4 = this.method_3426(var1, var2, this.field_2618);
         }

         this.method_3432(var4, false, true, false);
      }

   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.jc, boolean) void
   void method_3431(Context var1, class_352 var2, boolean var3) {
      int var4 = this.field_2619;
      Drawable var5 = null;
      if(var4 != 0) {
         var5 = this.method_3426(var1, var2, this.field_2619);
      }

      if(this.field_2621 != null) {
         this.field_2621.onImageLoaded(this.field_2617.uri, var5, false);
      }

      this.method_3432(var5, var3, false, false);
   }

   // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
   protected abstract void method_3432(Drawable var1, boolean var2, boolean var3, boolean var4);

   // $FF: renamed from: az (int) void
   public void method_3433(int var1) {
      this.field_2619 = var1;
   }

   // $FF: renamed from: b (boolean, boolean) boolean
   protected boolean method_3434(boolean var1, boolean var2) {
      return this.field_2622 && !var2 && (!var1 || this.field_2623);
   }

   static final class class_1694 {
      public final Uri uri;

      public class_1694(Uri var1) {
         this.uri = var1;
      }

      public boolean equals(Object var1) {
         return !(var1 instanceof class_559.class_1694)?false:(this == var1?true:class_336.equal(((class_559.class_1694)var1).uri, this.uri));
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.uri};
         return class_336.hashCode(var1);
      }
   }

   public static final class class_1695 extends class_559 {
      // $FF: renamed from: LS java.lang.ref.WeakReference
      private WeakReference<ImageView> field_2627;

      public class_1695(ImageView var1, int var2) {
         super((Uri)null, var2);
         class_349.method_2429(var1);
         this.field_2627 = new WeakReference(var1);
      }

      public class_1695(ImageView var1, Uri var2) {
         super(var2, 0);
         class_349.method_2429(var1);
         this.field_2627 = new WeakReference(var1);
      }

      // $FF: renamed from: a (android.widget.ImageView, android.graphics.drawable.Drawable, boolean, boolean, boolean) void
      private void method_3435(ImageView var1, Drawable var2, boolean var3, boolean var4, boolean var5) {
         boolean var6;
         if(!var4 && !var5) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var6 && var1 instanceof class_353) {
            int var12 = ((class_353)var1).method_2437();
            if(this.LL != 0 && var12 == this.LL) {
               return;
            }
         }

         boolean var7 = this.b(var3, var4);
         Object var8;
         if(this.LM && var2 != null) {
            var8 = var2.getConstantState().newDrawable();
         } else {
            var8 = var2;
         }

         if(var7) {
            var8 = this.a(var1.getDrawable(), (Drawable)var8);
         }

         var1.setImageDrawable((Drawable)var8);
         if(var1 instanceof class_353) {
            class_353 var9 = (class_353)var1;
            Uri var10;
            if(var5) {
               var10 = this.LJ.uri;
            } else {
               var10 = null;
            }

            var9.method_2436(var10);
            int var11;
            if(var6) {
               var11 = this.LL;
            } else {
               var11 = 0;
            }

            var9.method_2435(var11);
         }

         if(var7) {
            ((class_316)var8).startTransition(250);
         }
      }

      // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
      protected void method_3432(Drawable var1, boolean var2, boolean var3, boolean var4) {
         ImageView var5 = (ImageView)this.field_2627.get();
         if(var5 != null) {
            this.method_3435(var5, var1, var2, var3, var4);
         }

      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_559.class_1695)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_559.class_1695 var2 = (class_559.class_1695)var1;
            ImageView var3 = (ImageView)this.field_2627.get();
            ImageView var4 = (ImageView)var2.field_2627.get();
            boolean var5;
            if(var4 != null && var3 != null && class_336.equal(var4, var3)) {
               var5 = true;
            } else {
               var5 = false;
            }

            return var5;
         }
      }

      public int hashCode() {
         return 0;
      }
   }

   public static final class class_1696 extends class_559 {
      // $FF: renamed from: LT java.lang.ref.WeakReference
      private WeakReference<ImageManager.OnImageLoadedListener> field_2626;

      public class_1696(ImageManager.OnImageLoadedListener var1, Uri var2) {
         super(var2, 0);
         class_349.method_2429(var1);
         this.field_2626 = new WeakReference(var1);
      }

      // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
      protected void method_3432(Drawable var1, boolean var2, boolean var3, boolean var4) {
         if(!var3) {
            ImageManager.OnImageLoadedListener var5 = (ImageManager.OnImageLoadedListener)this.field_2626.get();
            if(var5 != null) {
               var5.onImageLoaded(this.LJ.uri, var1, var4);
            }
         }

      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_559.class_1696)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_559.class_1696 var2 = (class_559.class_1696)var1;
            ImageManager.OnImageLoadedListener var3 = (ImageManager.OnImageLoadedListener)this.field_2626.get();
            ImageManager.OnImageLoadedListener var4 = (ImageManager.OnImageLoadedListener)var2.field_2626.get();
            boolean var5;
            if(var4 != null && var3 != null && class_336.equal(var4, var3) && class_336.equal(var2.LJ, this.LJ)) {
               var5 = true;
            } else {
               var5 = false;
            }

            return var5;
         }
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.LJ};
         return class_336.hashCode(var1);
      }
   }
}
