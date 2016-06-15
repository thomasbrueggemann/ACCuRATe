package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bt;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_191;
import com.google.android.gms.internal.class_192;
import com.google.android.gms.internal.class_370;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bt
public final class class_195 extends class_13.class_1091 {
   // $FF: renamed from: nO java.util.Map
   private Map<Class<? extends NetworkExtras>, NetworkExtras> field_617;

   // $FF: renamed from: n (java.lang.String) com.google.android.gms.internal.bv
   private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bv method_1311(String var1) throws RemoteException {
      try {
         Class var3 = Class.forName(var1, false, bt.class.getClassLoader());
         if(MediationAdapter.class.isAssignableFrom(var3)) {
            MediationAdapter var4 = (MediationAdapter)var3.newInstance();
            return new class_191(var4, (com.google.ads.mediation.NetworkExtras)this.field_617.get(var4.getAdditionalParametersType()));
         } else if(com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(var3)) {
            return new class_192((com.google.android.gms.ads.mediation.MediationAdapter)var3.newInstance());
         } else {
            class_370.method_2358("Could not instantiate mediation adapter: " + var1 + " (not a valid adapter).");
            throw new RemoteException();
         }
      } catch (Throwable var5) {
         class_370.method_2358("Could not instantiate mediation adapter: " + var1 + ". " + var5.getMessage());
         throw new RemoteException();
      }
   }

   // $FF: renamed from: c (java.util.Map) void
   public void method_1312(Map<Class<? extends NetworkExtras>, NetworkExtras> var1) {
      this.field_617 = var1;
   }

   // $FF: renamed from: m (java.lang.String) com.google.android.gms.internal.bv
   public class_11 method_24(String var1) throws RemoteException {
      return this.method_1311(var1);
   }
}
