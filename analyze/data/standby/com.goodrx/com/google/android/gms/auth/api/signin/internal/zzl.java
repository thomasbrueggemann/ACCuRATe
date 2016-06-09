package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zzl extends zzf.zza {
   private final Context mContext;

   public zzl(Context var1) {
      this.mContext = var1;
   }

   private void zzni() {
      if(!GooglePlayServicesUtil.zzf(this.mContext, Binder.getCallingUid())) {
         throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
      }
   }

   private void zznj() {
      // $FF: Couldn't be decompiled
   }

   public void zznf() {
      this.zzni();
      this.zznj();
   }
}
