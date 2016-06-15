package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.class_501;
import com.google.android.gms.fitness.request.j;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.j
public class class_500 implements SafeParcelable {
   public static final Creator<j> CREATOR = new class_501();
   // $FF: renamed from: CK int
   private final int field_1906;
   private final String mName;

   class_500(int var1, String var2) {
      this.field_1906 = var1;
      this.mName = var2;
   }

   public class_500(String var1) {
      this.field_1906 = 1;
      this.mName = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.j) boolean
   private boolean method_3163(class_500 var1) {
      return class_336.equal(this.mName, var1.mName);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof class_500 && this.method_3163((class_500)var1);
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.field_1906;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("name", this.mName).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_501.method_3166(this, var1, var2);
   }
}
