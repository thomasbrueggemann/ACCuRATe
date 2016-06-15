package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_755;

// $FF: renamed from: com.google.android.gms.internal.nw
public class class_752 implements SafeParcelable {
   public static final class_755 CREATOR = new class_755();
   // $FF: renamed from: CK int
   final int field_3414;
   private final String ahx;
   private final String ahy;
   private final String mTag;

   class_752(int var1, String var2, String var3, String var4) {
      this.field_3414 = var1;
      this.ahx = var2;
      this.mTag = var3;
      this.ahy = var4;
   }

   public int describeContents() {
      class_755 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_752) {
         class_752 var2 = (class_752)var1;
         if(class_336.equal(this.ahx, var2.ahx) && class_336.equal(this.mTag, var2.mTag) && class_336.equal(this.ahy, var2.ahy)) {
            return true;
         }
      }

      return false;
   }

   public String getSource() {
      return this.ahy;
   }

   public String getTag() {
      return this.mTag;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.ahx, this.mTag, this.ahy};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: nw () java.lang.String
   public String method_4329() {
      return this.ahx;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("mPlaceId", this.ahx).method_3424("mTag", this.mTag).method_3424("mSource", this.ahy).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_755 var10000 = CREATOR;
      class_755.method_4334(this, var1, var2);
   }
}
