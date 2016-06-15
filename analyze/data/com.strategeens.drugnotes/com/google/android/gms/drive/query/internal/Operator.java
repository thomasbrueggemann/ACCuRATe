package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.class_948;

public class Operator implements SafeParcelable {
   public static final Creator<Operator> CREATOR = new class_948();
   // $FF: renamed from: SA com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3975 = new Operator(">=");
   // $FF: renamed from: SB com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3976 = new Operator("and");
   // $FF: renamed from: SC com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3977 = new Operator("or");
   // $FF: renamed from: SD com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3978 = new Operator("not");
   // $FF: renamed from: SE com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3979 = new Operator("contains");
   // $FF: renamed from: Sw com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3980 = new Operator("=");
   // $FF: renamed from: Sx com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3981 = new Operator("<");
   // $FF: renamed from: Sy com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3982 = new Operator("<=");
   // $FF: renamed from: Sz com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3983 = new Operator(">");
   // $FF: renamed from: CK int
   final int field_3984;
   final String mTag;

   Operator(int var1, String var2) {
      this.field_3984 = var1;
      this.mTag = var2;
   }

   private Operator(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         Operator var2 = (Operator)var1;
         if(this.mTag == null) {
            if(var2.mTag != null) {
               return false;
            }
         } else if(!this.mTag.equals(var2.mTag)) {
            return false;
         }
      }

      return true;
   }

   public String getTag() {
      return this.mTag;
   }

   public int hashCode() {
      int var1;
      if(this.mTag == null) {
         var1 = 0;
      } else {
         var1 = this.mTag.hashCode();
      }

      return var1 + 31;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_948.method_5236(this, var1, var2);
   }
}
