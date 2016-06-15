package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_769;

// $FF: renamed from: com.google.android.gms.internal.nd
public class class_770 implements SafeParcelable {
   public static final class_769 CREATOR = new class_769();
   // $FF: renamed from: CK int
   private final int field_3429;
   public final String packageName;
   public final int uid;

   class_770(int var1, int var2, String var3) {
      this.field_3429 = var1;
      this.uid = var2;
      this.packageName = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_770) {
         class_770 var2 = (class_770)var1;
         if(var2.uid == this.uid && class_336.equal(var2.packageName, this.packageName)) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.field_3429;
   }

   public int hashCode() {
      return this.uid;
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.uid), this.packageName};
      return String.format("%d:%s", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_769.method_4388(this, var1, var2);
   }
}
