package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import java.util.Date;

public class zzd extends com.google.android.gms.drive.metadata.zzd<Date> {
   public zzd(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   protected Object zzn(Bundle var1) {
      return this.zzp(var1);
   }

   protected Date zzp(Bundle var1) {
      return new Date(var1.getLong(this.getName()));
   }
}
