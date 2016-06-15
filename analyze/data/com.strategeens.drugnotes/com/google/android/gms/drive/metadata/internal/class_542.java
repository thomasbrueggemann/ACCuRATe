package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.a;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.j
public abstract class class_542<T extends Parcelable> extends a<T> {
   public class_542(String var1, Collection<String> var2, Collection<String> var3, int var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: renamed from: a (android.os.Bundle, android.os.Parcelable) void
   protected void method_3301(Bundle var1, T var2) {
      var1.putParcelable(this.getName(), var2);
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_3282(Bundle var1) {
      return this.method_3302(var1);
   }

   // $FF: renamed from: o (android.os.Bundle) android.os.Parcelable
   protected T method_3302(Bundle var1) {
      return var1.getParcelable(this.getName());
   }
}
