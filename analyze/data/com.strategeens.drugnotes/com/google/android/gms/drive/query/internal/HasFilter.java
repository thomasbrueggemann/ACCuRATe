package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_952;
import com.google.android.gms.drive.query.internal.class_953;
import com.google.android.gms.drive.query.internal.f;

public class HasFilter<T> extends AbstractFilter {
   public static final class_952 CREATOR = new class_952();
   // $FF: renamed from: CK int
   final int field_1711;
   // $FF: renamed from: Si com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_1712;
   // $FF: renamed from: Sj com.google.android.gms.drive.metadata.MetadataField
   final MetadataField<T> field_1713;

   HasFilter(int var1, MetadataBundle var2) {
      this.field_1711 = var1;
      this.field_1712 = var2;
      this.field_1713 = class_953.method_5258(var2);
   }

   public HasFilter(SearchableMetadataField<T> var1, T var2) {
      this(1, MetadataBundle.method_2079(var1, var2));
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <F> F method_7(f<F> var1) {
      return var1.method_929(this.field_1713, this.getValue());
   }

   public int describeContents() {
      return 0;
   }

   public T getValue() {
      return this.field_1712.method_2082(this.field_1713);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_952.method_5255(this, var1, var2);
   }
}
