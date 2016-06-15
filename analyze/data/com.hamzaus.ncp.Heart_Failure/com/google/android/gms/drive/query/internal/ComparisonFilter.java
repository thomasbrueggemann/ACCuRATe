package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.class_731;
import com.google.android.gms.drive.query.internal.class_734;

public class ComparisonFilter<T> implements SafeParcelable, Filter {
   public static final class_731 CREATOR = new class_731();
   // $FF: renamed from: KI com.google.android.gms.drive.query.internal.Operator
   final Operator field_3848;
   // $FF: renamed from: KJ com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3849;
   // $FF: renamed from: KK com.google.android.gms.drive.metadata.MetadataField
   final MetadataField<T> field_3850;
   // $FF: renamed from: xJ int
   final int field_3851;

   ComparisonFilter(int var1, Operator var2, MetadataBundle var3) {
      this.field_3851 = var1;
      this.field_3848 = var2;
      this.field_3849 = var3;
      this.field_3850 = class_734.method_4145(var3);
   }

   public ComparisonFilter(Operator var1, SearchableMetadataField<T> var2, T var3) {
      this(1, var1, MetadataBundle.method_1711(var2, var3));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_731.method_4136(this, var1, var2);
   }
}
