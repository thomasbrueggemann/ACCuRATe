package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.class_1034;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;

public final class Scope implements SafeParcelable {
   public static final Creator<Scope> CREATOR = new class_1034();
   // $FF: renamed from: CK int
   final int field_508;
   // $FF: renamed from: Kv java.lang.String
   private final String field_509;

   Scope(int var1, String var2) {
      class_335.method_2307(var2, "scopeUri must not be null or empty");
      this.field_508 = var1;
      this.field_509 = var2;
   }

   public Scope(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Scope)?false:this.field_509.equals(((Scope)var1).field_509));
   }

   // $FF: renamed from: gO () java.lang.String
   public String method_1632() {
      return this.field_509;
   }

   public int hashCode() {
      return this.field_509.hashCode();
   }

   public String toString() {
      return this.field_509;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1034.method_5680(this, var1, var2);
   }
}
