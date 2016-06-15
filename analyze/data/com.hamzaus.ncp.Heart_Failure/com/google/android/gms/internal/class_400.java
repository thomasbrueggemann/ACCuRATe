package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_401;

// $FF: renamed from: com.google.android.gms.internal.fj
public class class_400 implements SafeParcelable {
   public static final class_401 CREATOR = new class_401();
   // $FF: renamed from: xJ int
   final int field_1777;
   // $FF: renamed from: xN java.lang.String
   final String field_1778;
   // $FF: renamed from: xO java.lang.String
   final String field_1779;
   // $FF: renamed from: xP java.lang.String
   final String field_1780;

   class_400(int var1, String var2, String var3, String var4) {
      this.field_1777 = var1;
      this.field_1778 = var2;
      this.field_1779 = var3;
      this.field_1780 = var4;
   }

   public class_400(String var1, String var2, String var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      class_401 var10000 = CREATOR;
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1778, this.field_1779, this.field_1780};
      return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_401 var10000 = CREATOR;
      class_401.method_2486(this, var1, var2);
   }
}
