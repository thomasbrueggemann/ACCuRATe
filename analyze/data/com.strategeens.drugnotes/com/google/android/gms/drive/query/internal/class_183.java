package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.query.internal.f
public interface class_183<F> {
   // $FF: renamed from: b (com.google.android.gms.drive.metadata.b, java.lang.Object) java.lang.Object
   <T> F method_925(b<T> var1, T var2);

   // $FF: renamed from: b (com.google.android.gms.drive.query.internal.Operator, com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.Object
   <T> F method_926(Operator var1, MetadataField<T> var2, T var3);

   // $FF: renamed from: b (com.google.android.gms.drive.query.internal.Operator, java.util.List) java.lang.Object
   F method_927(Operator var1, List<F> var2);

   // $FF: renamed from: d (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   F method_928(MetadataField<?> var1);

   // $FF: renamed from: d (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.Object
   <T> F method_929(MetadataField<T> var1, T var2);

   // $FF: renamed from: j (java.lang.Object) java.lang.Object
   F method_930(F var1);

   // $FF: renamed from: jd () java.lang.Object
   F method_931();
}
