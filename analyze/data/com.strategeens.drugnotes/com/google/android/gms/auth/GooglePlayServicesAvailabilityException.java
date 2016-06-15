package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
   // $FF: renamed from: Eo int
   private final int field_1045;

   GooglePlayServicesAvailabilityException(int var1, String var2, Intent var3) {
      super(var2, var3);
      this.field_1045 = var1;
   }

   public int getConnectionStatusCode() {
      return this.field_1045;
   }
}
