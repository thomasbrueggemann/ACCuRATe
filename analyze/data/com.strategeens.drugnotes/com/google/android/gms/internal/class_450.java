package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_471;
import com.google.android.gms.internal.class_472;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.ey;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.cx
@ey
public final class class_450 extends class_43.class_1175 {
   // $FF: renamed from: qT java.util.Map
   private Map<Class<? extends NetworkExtras>, NetworkExtras> field_1519;

   // $FF: renamed from: z (java.lang.String) com.google.android.gms.internal.cz
   private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> cz method_2914(String var1) throws RemoteException {
      try {
         Class var3 = Class.forName(var1, false, cx.class.getClassLoader());
         if(MediationAdapter.class.isAssignableFrom(var3)) {
            MediationAdapter var4 = (MediationAdapter)var3.newInstance();
            return new class_471(var4, (com.google.ads.mediation.NetworkExtras)this.field_1519.get(var4.getAdditionalParametersType()));
         } else if(com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(var3)) {
            return new class_472((com.google.android.gms.ads.mediation.MediationAdapter)var3.newInstance());
         } else {
            class_368.method_2506("Could not instantiate mediation adapter: " + var1 + " (not a valid adapter).");
            throw new RemoteException();
         }
      } catch (Throwable var5) {
         class_368.method_2506("Could not instantiate mediation adapter: " + var1 + ". " + var5.getMessage());
         throw new RemoteException();
      }
   }

   // $FF: renamed from: d (java.util.Map) void
   public void method_2915(Map<Class<? extends NetworkExtras>, NetworkExtras> var1) {
      this.field_1519 = var1;
   }

   // $FF: renamed from: x (java.lang.String) com.google.android.gms.internal.cz
   public class_42 method_210(String var1) throws RemoteException {
      return this.method_2914(var1);
   }

   // $FF: renamed from: y (java.lang.String) boolean
   public boolean method_211(String var1) throws RemoteException {
      try {
         boolean var3 = CustomEvent.class.isAssignableFrom(Class.forName(var1, false, cx.class.getClassLoader()));
         return var3;
      } catch (Throwable var4) {
         class_368.method_2506("Could not load custom event implementation class: " + var1 + ", assuming old implementation.");
         return false;
      }
   }
}
