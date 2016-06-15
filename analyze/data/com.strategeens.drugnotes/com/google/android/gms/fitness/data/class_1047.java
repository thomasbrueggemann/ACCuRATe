package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1046;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.data.q
public class class_1047 implements SafeParcelable {
   public static final Creator<q> CREATOR = new class_1046();
   // $FF: renamed from: CK int
   final int field_4395;
   // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
   private final Session field_4396;
   // $FF: renamed from: UP com.google.android.gms.fitness.data.DataSet
   private final DataSet field_4397;

   class_1047(int var1, Session var2, DataSet var3) {
      this.field_4395 = var1;
      this.field_4396 = var2;
      this.field_4397 = var3;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.q) boolean
   private boolean method_5750(class_1047 var1) {
      return class_336.equal(this.field_4396, var1.field_4396) && class_336.equal(this.field_4397, var1.field_4397);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof class_1047 && this.method_5750((class_1047)var1);
   }

   public Session getSession() {
      return this.field_4396;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4396, this.field_4397};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jH () com.google.android.gms.fitness.data.DataSet
   public DataSet method_5751() {
      return this.field_4397;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("session", this.field_4396).method_3424("dataSet", this.field_4397).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1046.method_5747(this, var1, var2);
   }
}
