package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.i
public class class_267<T extends Parcelable> extends b<T> {
   public class_267(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.util.Collection) void
   protected void method_1836(Bundle var1, Collection<T> var2) {
      var1.putParcelableArrayList(this.getName(), new ArrayList(var2));
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_1822(Bundle var1) {
      return this.method_1837(var1);
   }

   // $FF: renamed from: k (android.os.Bundle) java.util.Collection
   protected Collection<T> method_1837(Bundle var1) {
      return var1.getParcelableArrayList(this.getName());
   }
}
