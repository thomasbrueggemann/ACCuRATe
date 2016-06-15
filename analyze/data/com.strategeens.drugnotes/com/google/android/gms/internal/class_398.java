package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_396;
import com.google.android.gms.internal.class_397;
import com.google.android.gms.internal.hr;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hl
public class class_398 {
   public static class class_1609 implements SafeParcelable {
      public static final class_397 CREATOR = new class_397();
      // $FF: renamed from: CK int
      final int field_4192;
      // $FF: renamed from: Dc android.accounts.Account
      public final Account field_4193;

      public class_1609() {
         this((Account)null);
      }

      class_1609(int var1, Account var2) {
         this.field_4192 = var1;
         this.field_4193 = var2;
      }

      public class_1609(Account var1) {
         this(1, var1);
      }

      public int describeContents() {
         class_397 var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_397 var10000 = CREATOR;
         class_397.method_2687(this, var1, var2);
      }
   }

   public static class class_1610 implements Result, SafeParcelable {
      public static final class_396 CREATOR = new class_396();
      // $FF: renamed from: CK int
      final int field_4189;
      // $FF: renamed from: Dd com.google.android.gms.common.api.Status
      public Status field_4190;
      // $FF: renamed from: De java.util.List
      public List<hr> field_4191;

      public class_1610() {
         this.field_4189 = 1;
      }

      class_1610(int var1, Status var2, List<hr> var3) {
         this.field_4189 = var1;
         this.field_4190 = var2;
         this.field_4191 = var3;
      }

      public int describeContents() {
         class_396 var10000 = CREATOR;
         return 0;
      }

      public Status getStatus() {
         return this.field_4190;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_396 var10000 = CREATOR;
         class_396.method_2684(this, var1, var2);
      }
   }
}
