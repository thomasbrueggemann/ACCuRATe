package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.internal.class_319;
import com.google.android.gms.internal.class_321;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_329;
import com.google.android.gms.internal.class_330;
import com.google.android.gms.internal.class_349;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.gms.common.images.a
public abstract class class_462 {
   // $FF: renamed from: Fj com.google.android.gms.common.images.a$a
   final class_462.class_1324 field_2791;
   // $FF: renamed from: Fk int
   protected int field_2792 = 0;
   // $FF: renamed from: Fl int
   protected int field_2793 = 0;
   // $FF: renamed from: Fm boolean
   private boolean field_2794 = true;
   // $FF: renamed from: Fn boolean
   private boolean field_2795 = false;
   // $FF: renamed from: Fo int
   protected int field_2796;

   public class_462(Uri var1, int var2) {
      this.field_2791 = new class_462.class_1324(var1);
      this.field_2793 = var2;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gx, int) android.graphics.drawable.Drawable
   private Drawable method_2864(Context var1, class_321 var2, int var3) {
      Resources var4 = var1.getResources();
      if(this.field_2796 > 0) {
         class_321.class_906 var5 = new class_321.class_906(var3, this.field_2796);
         Drawable var6 = (Drawable)var2.get(var5);
         if(var6 == null) {
            var6 = var4.getDrawable(var3);
            if((1 & this.field_2796) != 0) {
               var6 = this.method_2865(var4, var6);
            }

            var2.put(var5, var6);
         }

         return var6;
      } else {
         return var4.getDrawable(var3);
      }
   }

   // $FF: renamed from: a (android.content.res.Resources, android.graphics.drawable.Drawable) android.graphics.drawable.Drawable
   protected Drawable method_2865(Resources var1, Drawable var2) {
      return class_330.method_2111(var1, var2);
   }

   // $FF: renamed from: a (android.graphics.drawable.Drawable, android.graphics.drawable.Drawable) com.google.android.gms.internal.gu
   protected class_329 method_2866(Drawable var1, Drawable var2) {
      if(var1 != null) {
         if(var1 instanceof class_329) {
            var1 = ((class_329)var1).method_2108();
         }
      } else {
         var1 = null;
      }

      return new class_329(var1, var2);
   }

   // $FF: renamed from: a (android.content.Context, android.graphics.Bitmap, boolean) void
   void method_2867(Context var1, Bitmap var2, boolean var3) {
      class_322.method_2054(var2);
      if((1 & this.field_2796) != 0) {
         var2 = class_330.method_2109(var2);
      }

      this.method_2870(new BitmapDrawable(var1.getResources(), var2), var3, false, true);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gx) void
   void method_2868(Context var1, class_321 var2) {
      int var3 = this.field_2792;
      Drawable var4 = null;
      if(var3 != 0) {
         var4 = this.method_2864(var1, var2, this.field_2792);
      }

      this.method_2870(var4, false, true, false);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gx, boolean) void
   void method_2869(Context var1, class_321 var2, boolean var3) {
      int var4 = this.field_2793;
      Drawable var5 = null;
      if(var4 != 0) {
         var5 = this.method_2864(var1, var2, this.field_2793);
      }

      this.method_2870(var5, var3, false, false);
   }

   // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
   protected abstract void method_2870(Drawable var1, boolean var2, boolean var3, boolean var4);

   // $FF: renamed from: aj (int) void
   public void method_2871(int var1) {
      this.field_2793 = var1;
   }

   // $FF: renamed from: b (boolean, boolean) boolean
   protected boolean method_2872(boolean var1, boolean var2) {
      return this.field_2794 && !var2 && (!var1 || this.field_2795);
   }

   static final class class_1324 {
      public final Uri uri;

      public class_1324(Uri var1) {
         this.uri = var1;
      }

      public boolean equals(Object var1) {
         return !(var1 instanceof class_462.class_1324)?false:(this == var1?true:class_349.equal(((class_462.class_1324)var1).uri, this.uri));
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.uri};
         return class_349.hashCode(var1);
      }
   }

   public static final class class_1325 extends class_462 {
      // $FF: renamed from: Fp java.lang.ref.WeakReference
      private WeakReference<ImageView> field_2798;

      public class_1325(ImageView var1, int var2) {
         super((Uri)null, var2);
         class_322.method_2054(var1);
         this.field_2798 = new WeakReference(var1);
      }

      public class_1325(ImageView var1, Uri var2) {
         super(var2, 0);
         class_322.method_2054(var1);
         this.field_2798 = new WeakReference(var1);
      }

      // $FF: renamed from: a (android.widget.ImageView, android.graphics.drawable.Drawable, boolean, boolean, boolean) void
      private void method_2873(ImageView var1, Drawable var2, boolean var3, boolean var4, boolean var5) {
         boolean var6;
         if(!var4 && !var5) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var6 && var1 instanceof class_319) {
            int var12 = ((class_319)var1).method_2045();
            if(this.Fl != 0 && var12 == this.Fl) {
               return;
            }
         }

         boolean var7 = this.b(var3, var4);
         Object var8;
         if(var7) {
            var8 = this.a(var1.getDrawable(), var2);
         } else {
            var8 = var2;
         }

         var1.setImageDrawable((Drawable)var8);
         if(var1 instanceof class_319) {
            class_319 var9 = (class_319)var1;
            Uri var10;
            if(var5) {
               var10 = this.Fj.uri;
            } else {
               var10 = null;
            }

            var9.method_2044(var10);
            int var11;
            if(var6) {
               var11 = this.Fl;
            } else {
               var11 = 0;
            }

            var9.method_2043(var11);
         }

         if(var7) {
            ((class_329)var8).startTransition(250);
         }
      }

      // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
      protected void method_2870(Drawable var1, boolean var2, boolean var3, boolean var4) {
         ImageView var5 = (ImageView)this.field_2798.get();
         if(var5 != null) {
            this.method_2873(var5, var1, var2, var3, var4);
         }

      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_462.class_1325)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_462.class_1325 var2 = (class_462.class_1325)var1;
            ImageView var3 = (ImageView)this.field_2798.get();
            ImageView var4 = (ImageView)var2.field_2798.get();
            boolean var5;
            if(var4 != null && var3 != null && class_349.equal(var4, var3)) {
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

   public static final class class_1326 extends class_462 {
      // $FF: renamed from: Fq java.lang.ref.WeakReference
      private WeakReference<ImageManager.OnImageLoadedListener> field_2797;

      public class_1326(ImageManager.OnImageLoadedListener var1, Uri var2) {
         super(var2, 0);
         class_322.method_2054(var1);
         this.field_2797 = new WeakReference(var1);
      }

      // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
      protected void method_2870(Drawable var1, boolean var2, boolean var3, boolean var4) {
         if(!var3) {
            ImageManager.OnImageLoadedListener var5 = (ImageManager.OnImageLoadedListener)this.field_2797.get();
            if(var5 != null) {
               var5.onImageLoaded(this.Fj.uri, var1, var4);
            }
         }

      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_462.class_1326)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_462.class_1326 var2 = (class_462.class_1326)var1;
            ImageManager.OnImageLoadedListener var3 = (ImageManager.OnImageLoadedListener)this.field_2797.get();
            ImageManager.OnImageLoadedListener var4 = (ImageManager.OnImageLoadedListener)var2.field_2797.get();
            boolean var5;
            if(var4 != null && var3 != null && class_349.equal(var4, var3) && class_349.equal(var2.Fj, this.Fj)) {
               var5 = true;
            } else {
               var5 = false;
            }

            return var5;
         }
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.Fj};
         return class_349.hashCode(var1);
      }
   }
}
