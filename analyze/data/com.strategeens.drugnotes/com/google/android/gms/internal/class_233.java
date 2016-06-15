package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.class_194;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_210;
import com.google.android.gms.internal.class_217;
import com.google.android.gms.internal.class_220;
import com.google.android.gms.internal.class_231;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_235;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_239;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_405;
import com.google.android.gms.internal.class_410;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_6;

// $FF: renamed from: com.google.android.gms.internal.bh
public final class class_233 {
   // $FF: renamed from: oH com.google.android.gms.internal.cx
   private final class_450 field_428;
   // $FF: renamed from: oI com.google.android.gms.internal.ax
   private final class_210 field_429;
   // $FF: renamed from: oJ com.google.android.gms.internal.bd
   private class_6 field_430;
   // $FF: renamed from: oK java.lang.String
   private String field_431;
   // $FF: renamed from: oL android.view.ViewGroup
   private ViewGroup field_432;
   // $FF: renamed from: oM com.google.android.gms.ads.purchase.InAppPurchaseListener
   private InAppPurchaseListener field_433;
   // $FF: renamed from: oN com.google.android.gms.ads.purchase.PlayStorePurchaseListener
   private PlayStorePurchaseListener field_434;
   // $FF: renamed from: oO com.google.android.gms.ads.doubleclick.b
   private class_194 field_435;
   // $FF: renamed from: ob com.google.android.gms.ads.AdListener
   private AdListener field_436;
   // $FF: renamed from: os com.google.android.gms.ads.doubleclick.AppEventListener
   private AppEventListener field_437;
   // $FF: renamed from: ot com.google.android.gms.ads.AdSize[]
   private AdSize[] field_438;
   // $FF: renamed from: ou java.lang.String
   private String field_439;

   public class_233(ViewGroup var1) {
      this(var1, (AttributeSet)null, false, class_210.method_1508());
   }

   public class_233(ViewGroup var1, AttributeSet var2, boolean var3) {
      this(var1, var2, var3, class_210.method_1508());
   }

   class_233(ViewGroup var1, AttributeSet var2, boolean var3, class_210 var4) {
      this(var1, var2, var3, var4, (class_6)null);
   }

   class_233(ViewGroup var1, AttributeSet var2, boolean var3, class_210 var4, class_6 var5) {
      this.field_428 = new class_450();
      this.field_432 = var1;
      this.field_429 = var4;
      if(var2 != null) {
         Context var6 = var1.getContext();

         try {
            class_234 var7 = new class_234(var6, var2);
            this.field_438 = var7.method_1595(var3);
            this.field_439 = var7.getAdUnitId();
         } catch (IllegalArgumentException var9) {
            class_367.method_2498(var1, new class_237(var6, AdSize.BANNER), var9.getMessage(), var9.getMessage());
            return;
         }

         if(var1.isInEditMode()) {
            class_367.method_2496(var1, new class_237(var6, this.field_438[0]), "Ads by Google");
            return;
         }
      }

      this.field_430 = var5;
   }

   // $FF: renamed from: bm () void
   private void method_1590() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bn () void
   private void method_1591() throws RemoteException {
      if((this.field_438 == null || this.field_439 == null) && this.field_430 == null) {
         throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
      } else {
         Context var1 = this.field_432.getContext();
         this.field_430 = class_217.method_1528(var1, new class_237(var1, this.field_438), this.field_439, this.field_428);
         if(this.field_436 != null) {
            this.field_430.method_11(new class_220(this.field_436));
         }

         if(this.field_437 != null) {
            this.field_430.method_12(new class_235(this.field_437));
         }

         if(this.field_433 != null) {
            this.field_430.method_14(new class_405(this.field_433));
         }

         if(this.field_434 != null) {
            this.field_430.method_15(new class_410(this.field_434), this.field_431);
         }

         if(this.field_435 != null) {
            this.field_430.method_13(new class_239(this.field_435));
         }

         this.method_1590();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bg) void
   public void method_1592(class_231 var1) {
      try {
         if(this.field_430 == null) {
            this.method_1591();
         }

         if(this.field_430.method_16(this.field_429.method_1509(this.field_432.getContext(), var1))) {
            this.field_428.method_2915(var1.method_1582());
         }

      } catch (RemoteException var3) {
         class_368.method_2510("Failed to load ad.", var3);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.ads.AdSize[]) void
   public void method_1593(AdSize... var1) {
      this.field_438 = var1;

      try {
         if(this.field_430 != null) {
            this.field_430.method_10(new class_237(this.field_432.getContext(), this.field_438));
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Failed to set the ad size.", var3);
      }

      this.field_432.requestLayout();
   }

   public void destroy() {
      try {
         if(this.field_430 != null) {
            this.field_430.destroy();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Failed to destroy AdView.", var2);
      }
   }

   public AdListener getAdListener() {
      return this.field_436;
   }

   public AdSize getAdSize() {
      try {
         if(this.field_430 != null) {
            AdSize var2 = this.field_430.method_18().method_1605();
            return var2;
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Failed to get the current AdSize.", var3);
      }

      return this.field_438 != null?this.field_438[0]:null;
   }

   public AdSize[] getAdSizes() {
      return this.field_438;
   }

   public String getAdUnitId() {
      return this.field_439;
   }

   public AppEventListener getAppEventListener() {
      return this.field_437;
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_433;
   }

   public String getMediationAdapterClassName() {
      try {
         if(this.field_430 != null) {
            String var2 = this.field_430.getMediationAdapterClassName();
            return var2;
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Failed to get the mediation adapter class name.", var3);
      }

      return null;
   }

   public void pause() {
      try {
         if(this.field_430 != null) {
            this.field_430.pause();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Failed to call pause.", var2);
      }
   }

   public void recordManualImpression() {
      try {
         if(this.field_430 != null) {
            this.field_430.method_19();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Failed to record impression.", var2);
      }
   }

   public void resume() {
      try {
         if(this.field_430 != null) {
            this.field_430.resume();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Failed to call resume.", var2);
      }
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdSizes(AdSize... var1) {
      if(this.field_438 != null) {
         throw new IllegalStateException("The ad size can only be set once on AdView.");
      } else {
         this.method_1593(var1);
      }
   }

   public void setAdUnitId(String var1) {
      if(this.field_439 != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
      } else {
         this.field_439 = var1;
      }
   }

   public void setAppEventListener(AppEventListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setInAppPurchaseListener(InAppPurchaseListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setPlayStorePurchaseParams(PlayStorePurchaseListener param1, String param2) {
      // $FF: Couldn't be decompiled
   }
}
