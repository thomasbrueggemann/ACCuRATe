package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.a;
import com.google.android.gms.fitness.data.class_1049;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_780;

// $FF: renamed from: com.google.android.gms.fitness.data.a
public final class class_1051 implements SafeParcelable {
   public static final Creator<a> CREATOR = new class_1049();
   // $FF: renamed from: TT com.google.android.gms.fitness.data.a
   public static final class_1051 field_4398 = new class_1051("com.google.android.gms", String.valueOf(6587000), (String)null);
   // $FF: renamed from: CK int
   private final int field_4399;
   // $FF: renamed from: CS java.lang.String
   private final String field_4400;
   // $FF: renamed from: TU java.lang.String
   private final String field_4401;
   // $FF: renamed from: TV java.lang.String
   private final String field_4402;

   class_1051(int var1, String var2, String var3, String var4) {
      this.field_4399 = var1;
      this.field_4400 = (String)class_335.method_2311(var2);
      this.field_4401 = "";
      this.field_4402 = var4;
   }

   public class_1051(String var1, String var2, String var3) {
      this(1, var1, "", var3);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.a) boolean
   private boolean method_5761(class_1051 var1) {
      return this.field_4400.equals(var1.field_4400) && class_336.equal(this.field_4401, var1.field_4401) && class_336.equal(this.field_4402, var1.field_4402);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof class_1051 && this.method_5761((class_1051)var1);
   }

   public String getPackageName() {
      return this.field_4400;
   }

   public String getVersion() {
      return this.field_4401;
   }

   int getVersionCode() {
      return this.field_4399;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4400, this.field_4401, this.field_4402};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jk () java.lang.String
   public String method_5762() {
      return this.field_4402;
   }

   // $FF: renamed from: jl () com.google.android.gms.fitness.data.a
   class_1051 method_5763() {
      return new class_1051(class_780.method_4401(this.field_4400), class_780.method_4401(this.field_4401), class_780.method_4401(this.field_4402));
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_4400, this.field_4401, this.field_4402};
      return String.format("Application{%s:%s:%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1049.method_5755(this, var1, var2);
   }
}
