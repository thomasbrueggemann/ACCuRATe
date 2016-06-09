package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.api.internal.zzw;

@KeepName
public class SupportLifecycleFragmentImpl extends zzw {
   protected void zzb(int var1, ConnectionResult var2) {
      GooglePlayServicesUtil.showErrorDialogFragment(var2.getErrorCode(), this.getActivity(), this, 2, this);
   }

   protected void zzc(int var1, ConnectionResult var2) {
      final Dialog var3 = this.zzpS().zza(this.getActivity(), this);
      this.zzaiD = zzn.zza(this.getActivity().getApplicationContext(), new zzn() {
         protected void zzpJ() {
            SupportLifecycleFragmentImpl.this.zzpP();
            var3.dismiss();
         }
      });
   }

   // $FF: synthetic method
   protected com.google.android.gms.common.zzc zzpQ() {
      return this.zzpS();
   }

   protected GoogleApiAvailability zzpS() {
      return GoogleApiAvailability.getInstance();
   }
}
