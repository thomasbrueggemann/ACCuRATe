package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.dc
@ey
public final class class_472 extends class_42.class_1355 {
   // $FF: renamed from: qV com.google.android.gms.ads.mediation.MediationAdapter
   private final MediationAdapter field_1620;

   public class_472(MediationAdapter var1) {
      this.field_1620 = var1;
   }

   // $FF: renamed from: a (java.lang.String, int, java.lang.String) android.os.Bundle
   private Bundle method_3004(String param1, int param2, String param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
   public void method_206(class_198 var1, class_218 var2, String var3, class_53 var4) throws RemoteException {
      this.method_207(var1, var2, var3, (String)null, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
   public void method_207(class_198 param1, class_218 param2, String param3, String param4, class_53 param5) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
   public void method_208(class_198 var1, class_237 var2, class_218 var3, String var4, class_53 var5) throws RemoteException {
      this.method_209(var1, var2, var3, var4, (String)null, var5);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
   public void method_209(class_198 param1, class_237 param2, class_218 param3, String param4, String param5, class_53 param6) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void destroy() throws RemoteException {
      try {
         this.field_1620.onDestroy();
      } catch (Throwable var2) {
         class_368.method_2510("Could not destroy adapter.", var2);
         throw new RemoteException();
      }
   }

   public class_198 getView() throws RemoteException {
      if(!(this.field_1620 instanceof MediationBannerAdapter)) {
         class_368.method_2506("MediationAdapter is not a MediationBannerAdapter: " + this.field_1620.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         try {
            class_198 var2 = class_960.method_5293(((MediationBannerAdapter)this.field_1620).getBannerView());
            return var2;
         } catch (Throwable var3) {
            class_368.method_2510("Could not get banner view from adapter.", var3);
            throw new RemoteException();
         }
      }
   }

   public void pause() throws RemoteException {
      try {
         this.field_1620.onPause();
      } catch (Throwable var2) {
         class_368.method_2510("Could not pause adapter.", var2);
         throw new RemoteException();
      }
   }

   public void resume() throws RemoteException {
      try {
         this.field_1620.onResume();
      } catch (Throwable var2) {
         class_368.method_2510("Could not resume adapter.", var2);
         throw new RemoteException();
      }
   }

   public void showInterstitial() throws RemoteException {
      if(!(this.field_1620 instanceof MediationInterstitialAdapter)) {
         class_368.method_2506("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_1620.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_368.method_2502("Showing interstitial from adapter.");

         try {
            ((MediationInterstitialAdapter)this.field_1620).showInterstitial();
         } catch (Throwable var2) {
            class_368.method_2510("Could not show interstitial from adapter.", var2);
            throw new RemoteException();
         }
      }
   }
}
