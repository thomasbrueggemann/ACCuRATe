package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.class_951;
import com.google.android.gms.drive.query.internal.class_953;
import com.google.android.gms.drive.query.internal.f;

public class ComparisonFilter<T> extends AbstractFilter {
   public static final class_951 CREATOR = new class_951();
   // $FF: renamed from: CK int
   final int field_1714;
   // $FF: renamed from: Sh com.google.android.gms.drive.query.internal.Operator
   final Operator field_1715;
   // $FF: renamed from: Si com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_1716;
   // $FF: renamed from: Sj com.google.android.gms.drive.metadata.MetadataField
   final MetadataField<T> field_1717;

   ComparisonFilter(int var1, Operator var2, MetadataBundle var3) {
      this.field_1714 = var1;
      this.field_1715 = var2;
      this.field_1716 = var3;
      this.field_1717 = class_953.method_5258(var3);
   }

   public ComparisonFilter(Operator var1, SearchableMetadataField<T> var2, T var3) {
      this(1, var1, MetadataBundle.method_2079(var2, var3));
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <F> F method_7(f<F> var1) {
      return var1.method_926(this.field_1715, this.field_1717, this.getValue());
   }

   public int describeContents() {
      return 0;
   }

   public T getValue() {
      return this.field_1716.method_2082(this.field_1717);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_951.method_5252(this, var1, var2);
   }
}
