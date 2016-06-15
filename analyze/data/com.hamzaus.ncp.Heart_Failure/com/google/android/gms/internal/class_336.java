package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_331;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.gf;

// $FF: renamed from: com.google.android.gms.internal.gf
public class class_336 implements SafeParcelable {
   public static final Creator<gf> CREATOR = new class_331();
   // $FF: renamed from: Bz java.lang.String
   private String field_1363;
   // $FF: renamed from: xJ int
   private final int field_1364;

   public class_336() {
      this(1, (String)null);
   }

   class_336(int var1, String var2) {
      this.field_1364 = var1;
      this.field_1363 = var2;
   }

   // $FF: renamed from: dX () java.lang.String
   public String method_2130() {
      return this.field_1363;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof class_336)) {
         return false;
      } else {
         class_336 var2 = (class_336)var1;
         return class_332.method_2117(this.field_1363, var2.field_1363);
      }
   }

   public int getVersionCode() {
      return this.field_1364;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1363};
      return class_349.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_331.method_2112(this, var1, var2);
   }
}
