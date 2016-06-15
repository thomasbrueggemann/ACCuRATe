package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.class_395;
import com.google.android.gms.internal.class_403;
import com.google.android.gms.internal.hh;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hd
public class class_404 implements SafeParcelable {
   public static final class_403 CREATOR = new class_403();
   // $FF: renamed from: CK int
   final int field_1258;
   // $FF: renamed from: CL com.google.android.gms.internal.hh[]
   final class_394[] field_1259;
   // $FF: renamed from: CM java.lang.String
   public final String field_1260;
   // $FF: renamed from: CN boolean
   public final boolean field_1261;
   public final Account account;

   class_404(int var1, class_394[] var2, String var3, boolean var4, Account var5) {
      this.field_1258 = var1;
      this.field_1259 = var2;
      this.field_1260 = var3;
      this.field_1261 = var4;
      this.account = var5;
   }

   class_404(String var1, boolean var2, Account var3, class_394... var4) {
      this(1, var4, var1, var2, var3);
      BitSet var5 = new BitSet(class_395.method_2683());

      for(int var6 = 0; var6 < var4.length; ++var6) {
         int var7 = var4[var6].field_1227;
         if(var7 != -1) {
            if(var5.get(var7)) {
               throw new IllegalArgumentException("Duplicate global search section type " + class_395.method_2681(var7));
            }

            var5.set(var7);
         }
      }

   }

   public int describeContents() {
      class_403 var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_403 var10000 = CREATOR;
      class_403.method_2708(this, var1, var2);
   }

   public static class class_1530 {
      // $FF: renamed from: CO java.util.List
      private List<hh> field_4182;
      // $FF: renamed from: CP java.lang.String
      private String field_4183;
      // $FF: renamed from: CQ boolean
      private boolean field_4184;
      // $FF: renamed from: CR android.accounts.Account
      private Account field_4185;

      // $FF: renamed from: F (boolean) com.google.android.gms.internal.hd$a
      public class_404.class_1530 method_5424(boolean var1) {
         this.field_4184 = var1;
         return this;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hh) com.google.android.gms.internal.hd$a
      public class_404.class_1530 method_5425(class_394 var1) {
         if(this.field_4182 == null) {
            this.field_4182 = new ArrayList();
         }

         this.field_4182.add(var1);
         return this;
      }

      // $FF: renamed from: ar (java.lang.String) com.google.android.gms.internal.hd$a
      public class_404.class_1530 method_5426(String var1) {
         this.field_4183 = var1;
         return this;
      }

      // $FF: renamed from: fD () com.google.android.gms.internal.hd
      public class_404 method_5427() {
         String var1 = this.field_4183;
         boolean var2 = this.field_4184;
         Account var3 = this.field_4185;
         class_394[] var4;
         if(this.field_4182 != null) {
            var4 = (class_394[])this.field_4182.toArray(new class_394[this.field_4182.size()]);
         } else {
            var4 = null;
         }

         return new class_404(var1, var2, var3, var4);
      }
   }
}
