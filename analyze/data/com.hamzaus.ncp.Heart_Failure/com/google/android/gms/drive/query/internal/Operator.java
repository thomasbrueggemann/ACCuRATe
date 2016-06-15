package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.class_736;

public class Operator implements SafeParcelable {
   public static final Creator<Operator> CREATOR = new class_736();
   // $FF: renamed from: KX com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3894 = new Operator("=");
   // $FF: renamed from: KY com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3895 = new Operator("<");
   // $FF: renamed from: KZ com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3896 = new Operator("<=");
   // $FF: renamed from: La com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3897 = new Operator(">");
   // $FF: renamed from: Lb com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3898 = new Operator(">=");
   // $FF: renamed from: Lc com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3899 = new Operator("and");
   // $FF: renamed from: Ld com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3900 = new Operator("or");
   // $FF: renamed from: Le com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3901 = new Operator("not");
   // $FF: renamed from: Lf com.google.android.gms.drive.query.internal.Operator
   public static final Operator field_3902 = new Operator("contains");
   final String mTag;
   // $FF: renamed from: xJ int
   final int field_3903;

   Operator(int var1, String var2) {
      this.field_3903 = var1;
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
      class_736.method_4149(this, var1, var2);
   }
}
