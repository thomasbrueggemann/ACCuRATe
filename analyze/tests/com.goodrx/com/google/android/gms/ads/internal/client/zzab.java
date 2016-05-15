package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzab {
   private boolean zzpE;
   private String zzpS;
   private AdListener zztA;
   private zza zztz;
   private zzu zzuL;
   private ViewGroup zzuN;
   private InAppPurchaseListener zzuO;
   private PlayStorePurchaseListener zzuP;
   private OnCustomRenderedAdLoadedListener zzuQ;
   private Correlator zzuR;
   private boolean zzuS;
   private AppEventListener zzun;
   private AdSize[] zzuo;

   private static AdSizeParcel zza(Context var0, AdSize[] var1, boolean var2) {
      AdSizeParcel var3 = new AdSizeParcel(var0, var1);
      var3.zzi(var2);
      return var3;
   }

   public AdListener getAdListener() {
      return this.zztA;
   }

   public AdSize getAdSize() {
      // $FF: Couldn't be decompiled
   }

   public AdSize[] getAdSizes() {
      return this.zzuo;
   }

   public String getAdUnitId() {
      return this.zzpS;
   }

   public AppEventListener getAppEventListener() {
      return this.zzun;
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.zzuO;
   }

   public String getMediationAdapterClassName() {
      try {
         if(this.zzuL != null) {
            String var2 = this.zzuL.getMediationAdapterClassName();
            return var2;
         }
      } catch (RemoteException var3) {
         com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", var3);
      }

      return null;
   }

   public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
      return this.zzuQ;
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdSizes(AdSize... var1) {
      if(this.zzuo != null) {
         throw new IllegalStateException("The ad size can only be set once on AdView.");
      } else {
         this.zza(var1);
      }
   }

   public void setAdUnitId(String var1) {
      if(this.zzpS != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
      } else {
         this.zzpS = var1;
      }
   }

   public void setAppEventListener(AppEventListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setCorrelator(Correlator param1) {
      // $FF: Couldn't be decompiled
   }

   public void setInAppPurchaseListener(InAppPurchaseListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setManualImpressionsEnabled(boolean var1) {
      this.zzpE = var1;

      try {
         if(this.zzuL != null) {
            this.zzuL.setManualImpressionsEnabled(this.zzpE);
         }

      } catch (RemoteException var3) {
         com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", var3);
      }
   }

   public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void zza(zza param1) {
      // $FF: Couldn't be decompiled
   }

   public void zza(AdSize... var1) {
      this.zzuo = var1;

      try {
         if(this.zzuL != null) {
            this.zzuL.zza(zza(this.zzuN.getContext(), this.zzuo, this.zzuS));
         }
      } catch (RemoteException var3) {
         com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", var3);
      }

      this.zzuN.requestLayout();
   }
}
