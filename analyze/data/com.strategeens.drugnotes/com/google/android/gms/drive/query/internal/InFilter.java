package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.class_539;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_953;
import com.google.android.gms.drive.query.internal.class_958;
import com.google.android.gms.drive.query.internal.f;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
   public static final class_958 CREATOR = new class_958();
   // $FF: renamed from: CK int
   final int field_1701;
   // $FF: renamed from: Si com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_1702;
   // $FF: renamed from: St com.google.android.gms.drive.metadata.b
   private final b<T> field_1703;

   InFilter(int var1, MetadataBundle var2) {
      this.field_1701 = var1;
      this.field_1702 = var2;
      this.field_1703 = (class_539)class_953.method_5258(var2);
   }

   public InFilter(SearchableCollectionMetadataField<T> var1, T var2) {
      this(1, MetadataBundle.method_2079(var1, Collections.singleton(var2)));
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <F> F method_7(f<F> var1) {
      return var1.method_925(this.field_1703, this.getValue());
   }

   public int describeContents() {
      return 0;
   }

   public T getValue() {
      return ((Collection)this.field_1702.method_2082(this.field_1703)).iterator().next();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_958.method_5271(this, var1, var2);
   }
}
