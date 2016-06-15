package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_738;
import com.google.android.gms.internal.class_741;
import com.google.android.gms.internal.km;

// $FF: renamed from: com.google.android.gms.internal.km
public class class_740 implements SafeParcelable {
   public static final class_741 CREATOR = new class_741();
   // $FF: renamed from: CK int
   private final int field_3396;
   // $FF: renamed from: NF com.google.android.gms.internal.ko
   private final class_738 field_3397;

   class_740(int var1, class_738 var2) {
      this.field_3396 = var1;
      this.field_3397 = var2;
   }

   private class_740(class_738 var1) {
      this.field_3396 = 1;
      this.field_3397 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr$b) com.google.android.gms.internal.km
   public static km method_4299(class_726.class_1681<?, ?> var0) {
      if(var0 instanceof class_738) {
         return new class_740((class_738)var0);
      } else {
         throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
      }
   }

   public int describeContents() {
      class_741 var10000 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.field_3396;
   }

   // $FF: renamed from: hF () com.google.android.gms.internal.ko
   class_738 method_4300() {
      return this.field_3397;
   }

   // $FF: renamed from: hG () com.google.android.gms.internal.kr$b
   public class_726.class_1681<?, ?> method_4301() {
      if(this.field_3397 != null) {
         return this.field_3397;
      } else {
         throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_741 var10000 = CREATOR;
      class_741.method_4302(this, var1, var2);
   }
}
