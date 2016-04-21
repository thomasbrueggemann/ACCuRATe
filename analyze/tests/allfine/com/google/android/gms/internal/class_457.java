package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_459;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cu;
import com.google.android.gms.internal.ez;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.cs
@ez
public final class class_457 extends class_39.class_1422 {
    // $FF: renamed from: qC java.util.Map
    private Map<Class<? extends NetworkExtras>, NetworkExtras> field_1768;

    // $FF: renamed from: z (java.lang.String) com.google.android.gms.internal.cu
    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> cu method_2833(String var1) throws RemoteException {
        try {
            Class var3 = Class.forName(var1, false, cs.class.getClassLoader());
            if(MediationAdapter.class.isAssignableFrom(var3)) {
                MediationAdapter var4 = (MediationAdapter)var3.newInstance();
                return new class_458(var4, (com.google.ads.mediation.NetworkExtras)this.field_1768.get(var4.getAdditionalParametersType()));
            } else if(com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(var3)) {
                return new class_459((com.google.android.gms.ads.mediation.MediationAdapter)var3.newInstance());
            } else {
                class_378.method_2461("Could not instantiate mediation adapter: " + var1 + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable var5) {
            class_378.method_2461("Could not instantiate mediation adapter: " + var1 + ". " + var5.getMessage());
            throw new RemoteException();
        }
    }

    // $FF: renamed from: d (java.util.Map) void
    public void method_2834(Map<Class<? extends NetworkExtras>, NetworkExtras> var1) {
        this.field_1768 = var1;
    }

    // $FF: renamed from: x (java.lang.String) com.google.android.gms.internal.cu
    public class_41 method_172(String var1) throws RemoteException {
        return this.method_2833(var1);
    }

    // $FF: renamed from: y (java.lang.String) boolean
    public boolean method_173(String var1) throws RemoteException {
        try {
            boolean var3 = CustomEvent.class.isAssignableFrom(Class.forName(var1, false, cs.class.getClassLoader()));
            return var3;
        } catch (Throwable var4) {
            class_378.method_2461("Could not load custom event implementation class: " + var1 + ", assuming old implementation.");
            return false;
        }
    }
}
