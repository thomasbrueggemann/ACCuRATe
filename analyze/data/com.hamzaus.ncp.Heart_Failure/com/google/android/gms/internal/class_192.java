package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_370;

// $FF: renamed from: com.google.android.gms.internal.by
public final class class_192 extends class_11.class_1093 {
   // $FF: renamed from: nQ com.google.android.gms.ads.mediation.MediationAdapter
   private final MediationAdapter field_611;

   public class_192(MediationAdapter var1) {
      this.field_611 = var1;
   }

   // $FF: renamed from: a (java.lang.String, int, java.lang.String) android.os.Bundle
   private Bundle method_1307(String param1, int param2, String param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.aj, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_20(class_157 var1, class_182 var2, String var3, class_12 var4) throws RemoteException {
      this.method_21(var1, var2, var3, (String)null, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.aj, java.lang.String, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_21(class_157 param1, class_182 param2, String param3, String param4, class_12 param5) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.am, com.google.android.gms.internal.aj, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_22(class_157 var1, class_172 var2, class_182 var3, String var4, class_12 var5) throws RemoteException {
      this.method_23(var1, var2, var3, var4, (String)null, var5);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.am, com.google.android.gms.internal.aj, java.lang.String, java.lang.String, com.google.android.gms.internal.bw) void
   public void method_23(class_157 param1, class_172 param2, class_182 param3, String param4, String param5, class_12 param6) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void destroy() throws RemoteException {
      try {
         this.field_611.onDestroy();
      } catch (Throwable var2) {
         class_370.method_2361("Could not destroy adapter.", var2);
         throw new RemoteException();
      }
   }

   public class_157 getView() throws RemoteException {
      if(!(this.field_611 instanceof MediationBannerAdapter)) {
         class_370.method_2358("MediationAdapter is not a MediationBannerAdapter: " + this.field_611.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         try {
            class_157 var2 = class_741.method_4178(((MediationBannerAdapter)this.field_611).getBannerView());
            return var2;
         } catch (Throwable var3) {
            class_370.method_2361("Could not get banner view from adapter.", var3);
            throw new RemoteException();
         }
      }
   }

   public void pause() throws RemoteException {
      try {
         this.field_611.onPause();
      } catch (Throwable var2) {
         class_370.method_2361("Could not pause adapter.", var2);
         throw new RemoteException();
      }
   }

   public void resume() throws RemoteException {
      try {
         this.field_611.onResume();
      } catch (Throwable var2) {
         class_370.method_2361("Could not resume adapter.", var2);
         throw new RemoteException();
      }
   }

   public void showInterstitial() throws RemoteException {
      if(!(this.field_611 instanceof MediationInterstitialAdapter)) {
         class_370.method_2358("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_611.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         class_370.method_2363("Showing interstitial from adapter.");

         try {
            ((MediationInterstitialAdapter)this.field_611).showInterstitial();
         } catch (Throwable var2) {
            class_370.method_2361("Could not show interstitial from adapter.", var2);
            throw new RemoteException();
         }
      }
   }
}
