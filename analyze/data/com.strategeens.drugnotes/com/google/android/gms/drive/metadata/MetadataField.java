package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public interface MetadataField<T> {
   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   T method_221(DataHolder var1, int var2, int var3);

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.metadata.internal.MetadataBundle, int, int) void
   void method_222(DataHolder var1, MetadataBundle var2, int var3, int var4);

   // $FF: renamed from: a (java.lang.Object, android.os.Bundle) void
   void method_223(T var1, Bundle var2);

   String getName();

   // $FF: renamed from: h (android.os.Bundle) java.lang.Object
   T method_224(Bundle var1);
}
