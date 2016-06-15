package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_168;
import com.google.android.gms.internal.class_170;
import com.google.android.gms.internal.class_171;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_175;
import com.google.android.gms.internal.class_181;
import com.google.android.gms.internal.class_195;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_426;
import com.google.android.gms.internal.class_441;
import com.google.android.gms.internal.class_6;

// $FF: renamed from: com.google.android.gms.internal.av
public final class class_169 {
   // $FF: renamed from: lO com.google.android.gms.ads.AdListener
   private AdListener field_555;
   // $FF: renamed from: mA com.google.android.gms.ads.purchase.PlayStorePurchaseListener
   private PlayStorePurchaseListener field_556;
   // $FF: renamed from: mf com.google.android.gms.ads.doubleclick.AppEventListener
   private AppEventListener field_557;
   // $FF: renamed from: mg com.google.android.gms.ads.AdSize[]
   private AdSize[] field_558;
   // $FF: renamed from: mh java.lang.String
   private String field_559;
   // $FF: renamed from: mu com.google.android.gms.internal.bt
   private final class_195 field_560;
   // $FF: renamed from: mv com.google.android.gms.internal.al
   private final class_175 field_561;
   // $FF: renamed from: mw com.google.android.gms.internal.ar
   private class_6 field_562;
   // $FF: renamed from: mx java.lang.String
   private String field_563;
   // $FF: renamed from: my android.view.ViewGroup
   private ViewGroup field_564;
   // $FF: renamed from: mz com.google.android.gms.ads.purchase.InAppPurchaseListener
   private InAppPurchaseListener field_565;

   public class_169(ViewGroup var1) {
      this(var1, (AttributeSet)null, false, class_175.method_1274());
   }

   public class_169(ViewGroup var1, AttributeSet var2, boolean var3) {
      this(var1, var2, var3, class_175.method_1274());
   }

   class_169(ViewGroup var1, AttributeSet var2, boolean var3, class_175 var4) {
      this.field_560 = new class_195();
      this.field_564 = var1;
      this.field_561 = var4;
      if(var2 != null) {
         Context var5 = var1.getContext();

         try {
            class_171 var6 = new class_171(var5, var2);
            this.field_558 = var6.method_1263(var3);
            this.field_559 = var6.getAdUnitId();
         } catch (IllegalArgumentException var8) {
            class_371.method_2368(var1, new class_172(var5, AdSize.BANNER), var8.getMessage(), var8.getMessage());
            return;
         }

         if(var1.isInEditMode()) {
            class_371.method_2366(var1, new class_172(var5, this.field_558[0]), "Ads by Google");
         }
      }

   }

   // $FF: renamed from: aG () void
   private void method_1257() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aH () void
   private void method_1258() throws RemoteException {
      if((this.field_558 == null || this.field_559 == null) && this.field_562 == null) {
         throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
      } else {
         Context var1 = this.field_564.getContext();
         this.field_562 = class_181.method_1292(var1, new class_172(var1, this.field_558), this.field_559, this.field_560);
         if(this.field_555 != null) {
            this.field_562.method_11(new class_158(this.field_555));
         }

         if(this.field_557 != null) {
            this.field_562.method_12(new class_170(this.field_557));
         }

         if(this.field_565 != null) {
            this.field_562.method_13(new class_441(this.field_565));
         }

         if(this.field_556 != null) {
            this.field_562.method_14(new class_426(this.field_556), this.field_563);
         }

         this.method_1257();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.au) void
   public void method_1259(class_168 var1) {
      try {
         if(this.field_562 == null) {
            this.method_1258();
         }

         if(this.field_562.method_15(this.field_561.method_1275(this.field_564.getContext(), var1))) {
            this.field_560.method_1312(var1.method_1254());
         }

      } catch (RemoteException var3) {
         class_370.method_2361("Failed to load ad.", var3);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.ads.AdSize[]) void
   public void method_1260(AdSize... var1) {
      this.field_558 = var1;

      try {
         if(this.field_562 != null) {
            this.field_562.method_10(new class_172(this.field_564.getContext(), this.field_558));
         }
      } catch (RemoteException var3) {
         class_370.method_2361("Failed to set the ad size.", var3);
      }

      this.field_564.requestLayout();
   }

   public void destroy() {
      try {
         if(this.field_562 != null) {
            this.field_562.destroy();
         }

      } catch (RemoteException var2) {
         class_370.method_2361("Failed to destroy AdView.", var2);
      }
   }

   public AdListener getAdListener() {
      return this.field_555;
   }

   public AdSize getAdSize() {
      try {
         if(this.field_562 != null) {
            AdSize var2 = this.field_562.method_9().method_1267();
            return var2;
         }
      } catch (RemoteException var3) {
         class_370.method_2361("Failed to get the current AdSize.", var3);
      }

      return this.field_558 != null?this.field_558[0]:null;
   }

   public AdSize[] getAdSizes() {
      return this.field_558;
   }

   public String getAdUnitId() {
      return this.field_559;
   }

   public AppEventListener getAppEventListener() {
      return this.field_557;
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_565;
   }

   public void pause() {
      try {
         if(this.field_562 != null) {
            this.field_562.pause();
         }

      } catch (RemoteException var2) {
         class_370.method_2361("Failed to call pause.", var2);
      }
   }

   public void recordManualImpression() {
      try {
         this.field_562.method_16();
      } catch (RemoteException var2) {
         class_370.method_2361("Failed to record impression.", var2);
      }
   }

   public void resume() {
      try {
         if(this.field_562 != null) {
            this.field_562.resume();
         }

      } catch (RemoteException var2) {
         class_370.method_2361("Failed to call resume.", var2);
      }
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdSizes(AdSize... var1) {
      if(this.field_558 != null) {
         throw new IllegalStateException("The ad size can only be set once on AdView.");
      } else {
         this.method_1260(var1);
      }
   }

   public void setAdUnitId(String var1) {
      if(this.field_559 != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
      } else {
         this.field_559 = var1;
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
