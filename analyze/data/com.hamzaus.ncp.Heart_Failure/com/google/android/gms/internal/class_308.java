package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_349;

// $FF: renamed from: com.google.android.gms.internal.jp
public class class_308 implements SafeParcelable {
   public static final class_307 CREATOR = new class_307();
   // $FF: renamed from: Wi java.lang.String
   private final String field_1156;
   private final String mTag;
   // $FF: renamed from: xJ int
   final int field_1157;

   class_308(int var1, String var2, String var3) {
      this.field_1157 = var1;
      this.field_1156 = var2;
      this.mTag = var3;
   }

   public int describeContents() {
      class_307 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_308) {
         class_308 var2 = (class_308)var1;
         if(class_349.equal(this.field_1156, var2.field_1156) && class_349.equal(this.mTag, var2.mTag)) {
            return true;
         }
      }

      return false;
   }

   public String getTag() {
      return this.mTag;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1156, this.mTag};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: je () java.lang.String
   public String method_2011() {
      return this.field_1156;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("mPlaceId", this.field_1156).method_4301("mTag", this.mTag).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_307 var10000 = CREATOR;
      class_307.method_2006(this, var1, var2);
   }
}
