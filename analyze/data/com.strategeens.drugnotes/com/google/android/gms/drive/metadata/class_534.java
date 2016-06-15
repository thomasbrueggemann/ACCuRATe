package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_335;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.drive.metadata.a
public abstract class class_534<T> implements MetadataField<T> {
   // $FF: renamed from: QY java.lang.String
   private final String field_2518;
   // $FF: renamed from: QZ java.util.Set
   private final Set<String> field_2519;
   // $FF: renamed from: Ra java.util.Set
   private final Set<String> field_2520;
   // $FF: renamed from: Rb int
   private final int field_2521;

   protected class_534(String var1, int var2) {
      this.field_2518 = (String)class_335.method_2306(var1, "fieldName");
      this.field_2519 = Collections.singleton(var1);
      this.field_2520 = Collections.emptySet();
      this.field_2521 = var2;
   }

   protected class_534(String var1, Collection<String> var2, Collection<String> var3, int var4) {
      this.field_2518 = (String)class_335.method_2306(var1, "fieldName");
      this.field_2519 = Collections.unmodifiableSet(new HashSet(var2));
      this.field_2520 = Collections.unmodifiableSet(new HashSet(var3));
      this.field_2521 = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   public final T method_221(DataHolder var1, int var2, int var3) {
      return this.method_3280(var1, var2, var3)?this.method_3281(var1, var2, var3):null;
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Object) void
   protected abstract void method_3279(Bundle var1, T var2);

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.metadata.internal.MetadataBundle, int, int) void
   public final void method_222(DataHolder var1, MetadataBundle var2, int var3, int var4) {
      class_335.method_2306(var1, "dataHolder");
      class_335.method_2306(var2, "bundle");
      var2.method_2083(this, this.method_221(var1, var3, var4));
   }

   // $FF: renamed from: a (java.lang.Object, android.os.Bundle) void
   public final void method_223(T var1, Bundle var2) {
      class_335.method_2306(var2, "bundle");
      if(var1 == null) {
         var2.putString(this.getName(), (String)null);
      } else {
         this.method_3279(var2, var1);
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) boolean
   protected boolean method_3280(DataHolder var1, int var2, int var3) {
      Iterator var4 = this.field_2519.iterator();

      do {
         if(!var4.hasNext()) {
            return true;
         }
      } while(!var1.method_5841((String)var4.next(), var2, var3));

      return false;
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   protected abstract T method_3281(DataHolder var1, int var2, int var3);

   public final String getName() {
      return this.field_2518;
   }

   // $FF: renamed from: h (android.os.Bundle) java.lang.Object
   public final T method_224(Bundle var1) {
      class_335.method_2306(var1, "bundle");
      return var1.get(this.getName()) != null?this.method_3282(var1):null;
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   protected abstract T method_3282(Bundle var1);

   public String toString() {
      return this.field_2518;
   }
}
