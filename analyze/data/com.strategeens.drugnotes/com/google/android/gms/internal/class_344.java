package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_23;
import com.google.android.gms.internal.class_343;
import com.google.android.gms.internal.jj;

// $FF: renamed from: com.google.android.gms.internal.jj
public class class_344 implements SafeParcelable {
   public static final Creator<jj> CREATOR = new class_343();
   // $FF: renamed from: MD int
   final int field_967;
   // $FF: renamed from: ME int
   int field_968;
   // $FF: renamed from: MF java.lang.String
   String field_969;
   // $FF: renamed from: MG android.os.IBinder
   IBinder field_970;
   // $FF: renamed from: MH com.google.android.gms.common.api.Scope[]
   Scope[] field_971;
   // $FF: renamed from: MI android.os.Bundle
   Bundle field_972;
   final int version;

   public class_344(int var1) {
      this.version = 1;
      this.field_968 = 6587000;
      this.field_967 = var1;
   }

   class_344(int var1, int var2, int var3, String var4, IBinder var5, Scope[] var6, Bundle var7) {
      this.version = var1;
      this.field_967 = var2;
      this.field_968 = var3;
      this.field_969 = var4;
      this.field_970 = var5;
      this.field_971 = var6;
      this.field_972 = var7;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jq) com.google.android.gms.internal.jj
   public class_344 method_2359(class_23 var1) {
      if(var1 != null) {
         this.field_970 = var1.asBinder();
      }

      return this;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Scope[]) com.google.android.gms.internal.jj
   public class_344 method_2360(Scope[] var1) {
      this.field_971 = var1;
      return this;
   }

   // $FF: renamed from: aX (java.lang.String) com.google.android.gms.internal.jj
   public class_344 method_2361(String var1) {
      this.field_969 = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: e (android.os.Bundle) com.google.android.gms.internal.jj
   public class_344 method_2362(Bundle var1) {
      this.field_972 = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_343.method_2356(this, var1, var2);
   }
}
