package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.internal.zzi;
import com.google.android.gms.internal.zzr;

public class zza extends zzr {
   private Intent zza;

   public zza() {
   }

   public zza(zzi var1) {
      super(var1);
   }

   public String getMessage() {
      return this.zza != null?"User needs to (re)enter credentials.":super.getMessage();
   }
}
