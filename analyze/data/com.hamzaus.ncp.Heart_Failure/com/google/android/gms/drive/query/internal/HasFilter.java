package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.class_733;
import com.google.android.gms.drive.query.internal.class_734;

public class HasFilter<T> implements SafeParcelable, Filter {
   public static final class_733 CREATOR = new class_733();
   // $FF: renamed from: KJ com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4088;
   // $FF: renamed from: KK com.google.android.gms.drive.metadata.MetadataField
   final MetadataField<T> field_4089;
   // $FF: renamed from: xJ int
   final int field_4090;

   HasFilter(int var1, MetadataBundle var2) {
      this.field_4090 = var1;
      this.field_4088 = var2;
      this.field_4089 = class_734.method_4145(var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_733.method_4142(this, var1, var2);
   }
}
