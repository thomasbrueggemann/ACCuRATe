package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.class_275;
import java.lang.ref.WeakReference;

public class PopupManager {
   // $FF: renamed from: OV com.google.android.gms.games.internal.GamesClientImpl
   protected GamesClientImpl field_3392;
   // $FF: renamed from: OW com.google.android.gms.games.internal.PopupManager$PopupLocationInfo
   protected PopupManager.PopupLocationInfo field_3393;

   private PopupManager(GamesClientImpl var1, int var2) {
      this.field_3392 = var1;
      this.method_3698(var2);
   }

   // $FF: synthetic method
   PopupManager(GamesClientImpl var1, int var2, Object var3) {
      this(var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl, int) com.google.android.gms.games.internal.PopupManager
   public static PopupManager method_3697(GamesClientImpl var0, int var1) {
      return (PopupManager)(class_275.method_1851()?new PopupManager.PopupManagerHCMR1(var0, var1):new PopupManager(var0, var1));
   }

   // $FF: renamed from: cl (int) void
   protected void method_3698(int var1) {
      this.field_3393 = new PopupManager.PopupLocationInfo(var1, new Binder());
   }

   // $FF: renamed from: g (android.view.View) void
   public void method_3699(View var1) {
   }

   // $FF: renamed from: hG () void
   public void method_3700() {
      this.field_3392.method_1512(this.field_3393.field_2814, this.field_3393.method_2877());
   }

   // $FF: renamed from: hH () android.os.Bundle
   public Bundle method_3701() {
      return this.field_3393.method_2877();
   }

   // $FF: renamed from: hI () android.os.IBinder
   public IBinder method_3702() {
      return this.field_3393.field_2814;
   }

   public void setGravity(int var1) {
      this.field_3393.gravity = var1;
   }

   public static final class PopupLocationInfo {
      // $FF: renamed from: OX android.os.IBinder
      public IBinder field_2814;
      // $FF: renamed from: OY int
      public int field_2815;
      public int bottom;
      public int gravity;
      public int left;
      public int right;
      public int top;

      private PopupLocationInfo(int var1, IBinder var2) {
         this.field_2815 = -1;
         this.left = 0;
         this.top = 0;
         this.right = 0;
         this.bottom = 0;
         this.gravity = var1;
         this.field_2814 = var2;
      }

      // $FF: synthetic method
      PopupLocationInfo(int var1, IBinder var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: hJ () android.os.Bundle
      public Bundle method_2877() {
         Bundle var1 = new Bundle();
         var1.putInt("popupLocationInfo.gravity", this.gravity);
         var1.putInt("popupLocationInfo.displayId", this.field_2815);
         var1.putInt("popupLocationInfo.left", this.left);
         var1.putInt("popupLocationInfo.top", this.top);
         var1.putInt("popupLocationInfo.right", this.right);
         var1.putInt("popupLocationInfo.bottom", this.bottom);
         return var1;
      }
   }

   private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
      // $FF: renamed from: Ns boolean
      private boolean field_3394 = false;
      // $FF: renamed from: OZ java.lang.ref.WeakReference
      private WeakReference<View> field_3395;

      protected PopupManagerHCMR1(GamesClientImpl var1, int var2) {
         super(var1, var2, null);
      }

      // $FF: renamed from: h (android.view.View) void
      private void method_3703(View var1) {
         int var2 = -1;
         if(class_275.method_1855()) {
            Display var7 = var1.getDisplay();
            if(var7 != null) {
               var2 = var7.getDisplayId();
            }
         }

         IBinder var3 = var1.getWindowToken();
         int[] var4 = new int[2];
         var1.getLocationInWindow(var4);
         int var5 = var1.getWidth();
         int var6 = var1.getHeight();
         this.OW.field_2815 = var2;
         this.OW.field_2814 = var3;
         this.OW.left = var4[0];
         this.OW.top = var4[1];
         this.OW.right = var5 + var4[0];
         this.OW.bottom = var6 + var4[1];
         if(this.field_3394) {
            this.method_3700();
            this.field_3394 = false;
         }

      }

      // $FF: renamed from: cl (int) void
      protected void method_3698(int var1) {
         this.OW = new PopupManager.PopupLocationInfo(var1, (IBinder)null);
      }

      // $FF: renamed from: g (android.view.View) void
      public void method_3699(View var1) {
         this.OV.method_1631();
         if(this.field_3395 != null) {
            View var4 = (View)this.field_3395.get();
            Context var5 = this.OV.getContext();
            if(var4 == null && var5 instanceof Activity) {
               var4 = ((Activity)var5).getWindow().getDecorView();
            }

            if(var4 != null) {
               var4.removeOnAttachStateChangeListener(this);
               ViewTreeObserver var6 = var4.getViewTreeObserver();
               if(class_275.method_1854()) {
                  var6.removeOnGlobalLayoutListener(this);
               } else {
                  var6.removeGlobalOnLayoutListener(this);
               }
            }
         }

         this.field_3395 = null;
         Context var2 = this.OV.getContext();
         if(var1 == null && var2 instanceof Activity) {
            View var3 = ((Activity)var2).findViewById(16908290);
            if(var3 == null) {
               var3 = ((Activity)var2).getWindow().getDecorView();
            }

            GamesLog.method_4573("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
            var1 = var3;
         }

         if(var1 != null) {
            this.method_3703(var1);
            this.field_3395 = new WeakReference(var1);
            var1.addOnAttachStateChangeListener(this);
            var1.getViewTreeObserver().addOnGlobalLayoutListener(this);
         } else {
            GamesLog.method_4574("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client\'s calls. Use setViewForPopups() to set your content view.");
         }
      }

      // $FF: renamed from: hG () void
      public void method_3700() {
         if(this.OW.field_2814 != null) {
            super.method_3700();
         } else {
            boolean var1;
            if(this.field_3395 != null) {
               var1 = true;
            } else {
               var1 = false;
            }

            this.field_3394 = var1;
         }
      }

      public void onGlobalLayout() {
         if(this.field_3395 != null) {
            View var1 = (View)this.field_3395.get();
            if(var1 != null) {
               this.method_3703(var1);
               return;
            }
         }

      }

      public void onViewAttachedToWindow(View var1) {
         this.method_3703(var1);
      }

      public void onViewDetachedFromWindow(View var1) {
         this.OV.method_1631();
         var1.removeOnAttachStateChangeListener(this);
      }
   }
}
