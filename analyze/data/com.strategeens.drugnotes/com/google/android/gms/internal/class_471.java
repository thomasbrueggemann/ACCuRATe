package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_473;
import com.google.android.gms.internal.class_474;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.de
@ey
public final class class_471<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends class_42.class_1355 {
   // $FF: renamed from: qX com.google.ads.mediation.MediationAdapter
   private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> field_1618;
   // $FF: renamed from: qY com.google.ads.mediation.NetworkExtras
   private final NETWORK_EXTRAS field_1619;

   public class_471(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> var1, NETWORK_EXTRAS var2) {
      this.field_1618 = var1;
      this.field_1619 = var2;
   }

   // $FF: renamed from: b (java.lang.String, int, java.lang.String) com.google.ads.mediation.MediationServerParameters
   private SERVER_PARAMETERS method_3003(String param1, int param2, String param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
   public void method_206(class_198 var1, class_218 var2, String var3, class_53 var4) throws RemoteException {
      this.method_207(var1, var2, var3, (String)null, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
   public void method_207(class_198 var1, class_218 var2, String var3, String var4, class_53 var5) throws RemoteException {
      if(!(this.field_1618 instanceof MediationInterstitialAdapter)) {
         class_368.method_2506("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_1618.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_368.method_2502("Requesting interstitial ad from adapter.");

         try {
            ((MediationInterstitialAdapter)this.field_1618).requestInterstitialAd(new class_473(var5), (Activity)class_960.method_5292(var1), this.method_3003(var3, var2.field_361, var4), class_474.method_3008(var2), this.field_1619);
         } catch (Throwable var7) {
            class_368.method_2510("Could not request interstitial ad from adapter.", var7);
            throw new RemoteException();
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
   public void method_208(class_198 var1, class_237 var2, class_218 var3, String var4, class_53 var5) throws RemoteException {
      this.method_209(var1, var2, var3, var4, (String)null, var5);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
   public void method_209(class_198 var1, class_237 var2, class_218 var3, String var4, String var5, class_53 var6) throws RemoteException {
      if(!(this.field_1618 instanceof MediationBannerAdapter)) {
         class_368.method_2506("MediationAdapter is not a MediationBannerAdapter: " + this.field_1618.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_368.method_2502("Requesting banner ad from adapter.");

         try {
            ((MediationBannerAdapter)this.field_1618).requestBannerAd(new class_473(var6), (Activity)class_960.method_5292(var1), this.method_3003(var4, var3.field_361, var5), class_474.method_3007(var2), class_474.method_3008(var3), this.field_1619);
         } catch (Throwable var8) {
            class_368.method_2510("Could not request banner ad from adapter.", var8);
            throw new RemoteException();
         }
      }
   }

   public void destroy() throws RemoteException {
      try {
         this.field_1618.destroy();
      } catch (Throwable var2) {
         class_368.method_2510("Could not destroy adapter.", var2);
         throw new RemoteException();
      }
   }

   public class_198 getView() throws RemoteException {
      if(!(this.field_1618 instanceof MediationBannerAdapter)) {
         class_368.method_2506("MediationAdapter is not a MediationBannerAdapter: " + this.field_1618.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         try {
            class_198 var2 = class_960.method_5293(((MediationBannerAdapter)this.field_1618).getBannerView());
            return var2;
         } catch (Throwable var3) {
            class_368.method_2510("Could not get banner view from adapter.", var3);
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
      if(!(this.field_1618 instanceof MediationInterstitialAdapter)) {
         class_368.method_2506("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_1618.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_368.method_2502("Showing interstitial from adapter.");

         try {
            ((MediationInterstitialAdapter)this.field_1618).showInterstitial();
         } catch (Throwable var2) {
            class_368.method_2510("Could not show interstitial from adapter.", var2);
            throw new RemoteException();
         }
      }
   }
}
