package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.i
public class class_540<T extends Parcelable> extends b<T> {
   public class_540(String var1, int var2) {
      super(var1, Collections.emptySet(), Collections.singleton(var1), var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.util.Collection) void
   protected void method_3296(Bundle var1, Collection<T> var2) {
      var1.putParcelableArrayList(this.getName(), new ArrayList(var2));
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_3282(Bundle var1) {
      return this.method_3297(var1);
   }

   // $FF: renamed from: n (android.os.Bundle) java.util.Collection
   protected Collection<T> method_3297(Bundle var1) {
      return var1.getParcelableArrayList(this.getName());
   }
}
