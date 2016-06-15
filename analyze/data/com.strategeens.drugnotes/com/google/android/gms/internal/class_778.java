package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_779;
import com.google.android.gms.internal.mq;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.mq
public class class_778 implements SafeParcelable {
   public static final Creator<mq> CREATOR = new class_779();
   // $FF: renamed from: CK int
   private final int field_3436;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_3437;

   class_778(int var1, List<DataType> var2) {
      this.field_3436 = var1;
      this.field_3437 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public List<DataType> getDataTypes() {
      return Collections.unmodifiableList(this.field_3437);
   }

   int getVersionCode() {
      return this.field_3436;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("dataTypes", this.field_3437).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_779.method_4398(this, var1, var2);
   }
}
