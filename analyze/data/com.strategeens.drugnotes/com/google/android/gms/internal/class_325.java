package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_327;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.ij;

// $FF: renamed from: com.google.android.gms.internal.ij
public class class_325 implements SafeParcelable {
   public static final Creator<ij> CREATOR = new class_327();
   // $FF: renamed from: CK int
   private final int field_831;
   // $FF: renamed from: Hd java.lang.String
   private String field_832;

   public class_325() {
      this(1, (String)null);
   }

   class_325(int var1, String var2) {
      this.field_831 = var1;
      this.field_832 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof class_325)) {
         return false;
      } else {
         class_325 var2 = (class_325)var1;
         return class_322.method_2262(this.field_832, var2.field_832);
      }
   }

   // $FF: renamed from: fT () java.lang.String
   public String method_2282() {
      return this.field_832;
   }

   public int getVersionCode() {
      return this.field_831;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_832};
      return class_336.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_327.method_2284(this, var1, var2);
   }
}
