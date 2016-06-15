package com.google.android.gms.common;

import android.content.Intent;
import com.google.android.gms.common.UserRecoverableException;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
   // $FF: renamed from: yV int
   private final int field_4099;

   GooglePlayServicesRepairableException(int var1, String var2, Intent var3) {
      super(var2, var3);
      this.field_4099 = var1;
   }

   public int getConnectionStatusCode() {
      return this.field_4099;
   }
}
