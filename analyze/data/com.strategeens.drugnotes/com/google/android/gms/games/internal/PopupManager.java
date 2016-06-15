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
import com.google.android.gms.internal.class_712;
import java.lang.ref.WeakReference;

public class PopupManager {
   // $FF: renamed from: ZQ com.google.android.gms.games.internal.GamesClientImpl
   protected GamesClientImpl field_3502;
   // $FF: renamed from: ZR com.google.android.gms.games.internal.PopupManager$PopupLocationInfo
   protected PopupManager.PopupLocationInfo field_3503;

   private PopupManager(GamesClientImpl var1, int var2) {
      this.field_3502 = var1;
      this.method_4662(var2);
   }

   // $FF: synthetic method
   PopupManager(GamesClientImpl var1, int var2, Object var3) {
      this(var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl, int) com.google.android.gms.games.internal.PopupManager
   public static PopupManager method_4661(GamesClientImpl var0, int var1) {
      return (PopupManager)(class_712.method_4178()?new PopupManager.PopupManagerHCMR1(var0, var1):new PopupManager(var0, var1));
   }

   // $FF: renamed from: dY (int) void
   protected void method_4662(int var1) {
      this.field_3503 = new PopupManager.PopupLocationInfo(var1, new Binder());
   }

   // $FF: renamed from: l (android.view.View) void
   public void method_4663(View var1) {
   }

   // $FF: renamed from: lT () void
   public void method_4664() {
      this.field_3502.method_1879(this.field_3503.field_2642, this.field_3503.method_3442());
   }

   // $FF: renamed from: lU () android.os.Bundle
   public Bundle method_4665() {
      return this.field_3503.method_3442();
   }

   // $FF: renamed from: lV () android.os.IBinder
   public IBinder method_4666() {
      return this.field_3503.field_2642;
   }

   public void setGravity(int var1) {
      this.field_3503.gravity = var1;
   }

   public static final class PopupLocationInfo {
      // $FF: renamed from: ZS android.os.IBinder
      public IBinder field_2642;
      // $FF: renamed from: ZT int
      public int field_2643;
      public int bottom;
      public int gravity;
      public int left;
      public int right;
      public int top;

      private PopupLocationInfo(int var1, IBinder var2) {
         this.field_2643 = -1;
         this.left = 0;
         this.top = 0;
         this.right = 0;
         this.bottom = 0;
         this.gravity = var1;
         this.field_2642 = var2;
      }

      // $FF: synthetic method
      PopupLocationInfo(int var1, IBinder var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: lW () android.os.Bundle
      public Bundle method_3442() {
         Bundle var1 = new Bundle();
         var1.putInt("popupLocationInfo.gravity", this.gravity);
         var1.putInt("popupLocationInfo.displayId", this.field_2643);
         var1.putInt("popupLocationInfo.left", this.left);
         var1.putInt("popupLocationInfo.top", this.top);
         var1.putInt("popupLocationInfo.right", this.right);
         var1.putInt("popupLocationInfo.bottom", this.bottom);
         return var1;
      }
   }

   private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
      // $FF: renamed from: Yq boolean
      private boolean field_3504 = false;
      // $FF: renamed from: ZU java.lang.ref.WeakReference
      private WeakReference<View> field_3505;

      protected PopupManagerHCMR1(GamesClientImpl var1, int var2) {
         super(var1, var2, null);
      }

      // $FF: renamed from: m (android.view.View) void
      private void method_4667(View var1) {
         int var2 = -1;
         if(class_712.method_4182()) {
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
         this.ZR.field_2643 = var2;
         this.ZR.field_2642 = var3;
         this.ZR.left = var4[0];
         this.ZR.top = var4[1];
         this.ZR.right = var5 + var4[0];
         this.ZR.bottom = var6 + var4[1];
         if(this.field_3504) {
            this.method_4664();
            this.field_3504 = false;
         }

      }

      // $FF: renamed from: dY (int) void
      protected void method_4662(int var1) {
         this.ZR = new PopupManager.PopupLocationInfo(var1, (IBinder)null);
      }

      // $FF: renamed from: l (android.view.View) void
      public void method_4663(View var1) {
         this.ZQ.method_1987();
         if(this.field_3505 != null) {
            View var4 = (View)this.field_3505.get();
            Context var5 = this.ZQ.getContext();
            if(var4 == null && var5 instanceof Activity) {
               var4 = ((Activity)var5).getWindow().getDecorView();
            }

            if(var4 != null) {
               var4.removeOnAttachStateChangeListener(this);
               ViewTreeObserver var6 = var4.getViewTreeObserver();
               if(class_712.method_4181()) {
                  var6.removeOnGlobalLayoutListener(this);
               } else {
                  var6.removeGlobalOnLayoutListener(this);
               }
            }
         }

         this.field_3505 = null;
         Context var2 = this.ZQ.getContext();
         if(var1 == null && var2 instanceof Activity) {
            View var3 = ((Activity)var2).findViewById(16908290);
            if(var3 == null) {
               var3 = ((Activity)var2).getWindow().getDecorView();
            }

            GamesLog.method_5847("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
            var1 = var3;
         }

         if(var1 != null) {
            this.method_4667(var1);
            this.field_3505 = new WeakReference(var1);
            var1.addOnAttachStateChangeListener(this);
            var1.getViewTreeObserver().addOnGlobalLayoutListener(this);
         } else {
            GamesLog.method_5848("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client\'s calls. Use setViewForPopups() to set your content view.");
         }
      }

      // $FF: renamed from: lT () void
      public void method_4664() {
         if(this.ZR.field_2642 != null) {
            super.method_4664();
         } else {
            boolean var1;
            if(this.field_3505 != null) {
               var1 = true;
            } else {
               var1 = false;
            }

            this.field_3504 = var1;
         }
      }

      public void onGlobalLayout() {
         if(this.field_3505 != null) {
            View var1 = (View)this.field_3505.get();
            if(var1 != null) {
               this.method_4667(var1);
               return;
            }
         }

      }

      public void onViewAttachedToWindow(View var1) {
         this.method_4667(var1);
      }

      public void onViewDetachedFromWindow(View var1) {
         this.ZQ.method_1987();
         var1.removeOnAttachStateChangeListener(this);
      }
   }
}
