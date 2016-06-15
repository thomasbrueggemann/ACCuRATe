package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_417;
import com.google.android.gms.internal.class_418;

// $FF: renamed from: com.google.android.gms.internal.ca
public final class class_191<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends class_11.class_1093 {
   // $FF: renamed from: nS com.google.ads.mediation.MediationAdapter
   private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> field_609;
   // $FF: renamed from: nT com.google.ads.mediation.NetworkExtras
   private final NETWORK_EXTRAS field_610;

   public class_191(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> var1, NETWORK_EXTRAS var2) {
      this.field_609 = var1;
      this.field_610 = var2;
   }

   // $FF: renamed from: b (java.lang.String, int, java.lang.String) com.google.ads.mediation.MediationServerParameters
   private SERVER_PARAMETERS method_1306(String param1, int param2, String param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.aj, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_20(class_157 var1, class_182 var2, String var3, class_12 var4) throws RemoteException {
      this.method_21(var1, var2, var3, (String)null, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.aj, java.lang.String, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_21(class_157 var1, class_182 var2, String var3, String var4, class_12 var5) throws RemoteException {
      if(!(this.field_609 instanceof MediationInterstitialAdapter)) {
         class_370.method_2358("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_609.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_370.method_2363("Requesting interstitial ad from adapter.");

         try {
            ((MediationInterstitialAdapter)this.field_609).requestInterstitialAd(new class_417(var5), (Activity)class_741.method_4177(var1), this.method_1306(var3, var2.field_583, var4), class_418.method_2547(var2), this.field_610);
         } catch (Throwable var7) {
            class_370.method_2361("Could not request interstitial ad from adapter.", var7);
            throw new RemoteException();
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.am, com.google.android.gms.internal.aj, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_22(class_157 var1, class_172 var2, class_182 var3, String var4, class_12 var5) throws RemoteException {
      this.method_23(var1, var2, var3, var4, (String)null, var5);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.am, com.google.android.gms.internal.aj, java.lang.String, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_23(class_157 var1, class_172 var2, class_182 var3, String var4, String var5, class_12 var6) throws RemoteException {
      if(!(this.field_609 instanceof MediationBannerAdapter)) {
         class_370.method_2358("MediationAdapter is not a MediationBannerAdapter: " + this.field_609.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_370.method_2363("Requesting banner ad from adapter.");

         try {
            ((MediationBannerAdapter)this.field_609).requestBannerAd(new class_417(var6), (Activity)class_741.method_4177(var1), this.method_1306(var4, var3.field_583, var5), class_418.method_2546(var2), class_418.method_2547(var3), this.field_610);
         } catch (Throwable var8) {
            class_370.method_2361("Could not request banner ad from adapter.", var8);
            throw new RemoteException();
         }
      }
   }

   public void destroy() throws RemoteException {
      try {
         this.field_609.destroy();
      } catch (Throwable var2) {
         class_370.method_2361("Could not destroy adapter.", var2);
         throw new RemoteException();
      }
   }

   public class_157 getView() throws RemoteException {
      if(!(this.field_609 instanceof MediationBannerAdapter)) {
         class_370.method_2358("MediationAdapter is not a MediationBannerAdapter: " + this.field_609.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         try {
            class_157 var2 = class_741.method_4178(((MediationBannerAdapter)this.field_609).getBannerView());
            return var2;
         } catch (Throwable var3) {
            class_370.method_2361("Could not get banner view from adapter.", var3);
            throw new RemoteException();
         }
      }
   }

   public void pause() throws RemoteException {
      throw new RemoteException();
   }

   public void resume() throws RemoteException {
      throw new RemoteException();
   }

   public void showInterstitial() throws RemoteException {
      if(!(this.field_609 instanceof MediationInterstitialAdapter)) {
         class_370.method_2358("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_609.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_370.method_2363("Showing interstitial from adapter.");

         try {
            ((MediationInterstitialAdapter)this.field_609).showInterstitial();
         } catch (Throwable var2) {
            class_370.method_2361("Could not show interstitial from adapter.", var2);
            throw new RemoteException();
         }
      }
   }
}
