package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.class_489;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.af
public class class_488 implements SafeParcelable {
   public static final Creator<af> CREATOR = new class_489();
   // $FF: renamed from: CK int
   private final int field_1835;
   // $FF: renamed from: Wo com.google.android.gms.fitness.data.Subscription
   private final Subscription field_1836;
   // $FF: renamed from: Wp boolean
   private final boolean field_1837;

   class_488(int var1, Subscription var2, boolean var3) {
      this.field_1835 = var1;
      this.field_1836 = var2;
      this.field_1837 = var3;
   }

   private class_488(class_488.class_1507 var1) {
      this.field_1835 = 1;
      this.field_1836 = var1.field_3044;
      this.field_1837 = var1.field_3045;
   }

   // $FF: synthetic method
   class_488(class_488.class_1507 var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.field_1835;
   }

   // $FF: renamed from: kn () com.google.android.gms.fitness.data.Subscription
   public Subscription method_3086() {
      return this.field_1836;
   }

   // $FF: renamed from: ko () boolean
   public boolean method_3087() {
      return this.field_1837;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("subscription", this.field_1836).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_489.method_3088(this, var1, var2);
   }

   public static class class_1507 {
      // $FF: renamed from: Wo com.google.android.gms.fitness.data.Subscription
      private Subscription field_3044;
      // $FF: renamed from: Wp boolean
      private boolean field_3045 = false;

      // $FF: renamed from: b (com.google.android.gms.fitness.data.Subscription) com.google.android.gms.fitness.request.af$a
      public class_488.class_1507 method_3908(Subscription var1) {
         this.field_3044 = var1;
         return this;
      }

      // $FF: renamed from: kp () com.google.android.gms.fitness.request.af
      public class_488 method_3909() {
         boolean var1;
         if(this.field_3044 != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2302(var1, "Must call setSubscription()");
         return new class_488(this);
      }
   }
}
