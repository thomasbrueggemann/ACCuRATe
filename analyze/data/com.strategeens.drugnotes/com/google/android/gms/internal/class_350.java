package com.google.android.gms.internal;

import android.accounts.Account;
import android.text.TextUtils;
import com.google.android.gms.internal.class_23;

// $FF: renamed from: com.google.android.gms.internal.jd
public class class_350 extends class_23.class_1381 {
   // $FF: renamed from: CR android.accounts.Account
   private Account field_1044;

   public class_350(Account var1) {
      this.field_1044 = var1;
   }

   // $FF: renamed from: aT (java.lang.String) com.google.android.gms.internal.jd
   public static class_350 method_2430(String var0) {
      Account var1;
      if(TextUtils.isEmpty(var0)) {
         var1 = null;
      } else {
         var1 = new Account(var0, "com.google");
      }

      return new class_350(var1);
   }

   // $FF: renamed from: hk () android.accounts.Account
   public Account method_172() {
      return this.field_1044;
   }
}
