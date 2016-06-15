package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_343;
import com.google.android.gms.internal.class_344;
import com.google.android.gms.internal.hu;

// $FF: renamed from: com.google.android.gms.internal.hu
public class class_346 implements SafeParcelable {
   public static final class_343 CREATOR = new class_343();
   // $FF: renamed from: GS com.google.android.gms.internal.hw
   private final class_344 field_1414;
   // $FF: renamed from: xJ int
   private final int field_1415;

   class_346(int var1, class_344 var2) {
      this.field_1415 = var1;
      this.field_1414 = var2;
   }

   private class_346(class_344 var1) {
      this.field_1415 = 1;
      this.field_1414 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hz$b) com.google.android.gms.internal.hu
   public static hu method_2156(class_285.class_945<?, ?> var0) {
      if(var0 instanceof class_344) {
         return new class_346((class_344)var0);
      } else {
         throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
      }
   }

   public int describeContents() {
      class_343 var10000 = CREATOR;
      return 0;
   }

   // $FF: renamed from: fw () com.google.android.gms.internal.hw
   class_344 method_2157() {
      return this.field_1414;
   }

   // $FF: renamed from: fx () com.google.android.gms.internal.hz$b
   public class_285.class_945<?, ?> method_2158() {
      if(this.field_1414 != null) {
         return this.field_1414;
      } else {
         throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
      }
   }

   int getVersionCode() {
      return this.field_1415;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_343 var10000 = CREATOR;
      class_343.method_2143(this, var1, var2);
   }
}
