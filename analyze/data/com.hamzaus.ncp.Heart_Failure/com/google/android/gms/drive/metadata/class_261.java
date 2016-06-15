package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_347;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.drive.metadata.a
public abstract class class_261<T> implements MetadataField<T> {
   // $FF: renamed from: JE java.lang.String
   private final String field_905;
   // $FF: renamed from: JF java.util.Set
   private final Set<String> field_906;
   // $FF: renamed from: JG java.util.Set
   private final Set<String> field_907;
   // $FF: renamed from: JH int
   private final int field_908;

   protected class_261(String var1, int var2) {
      this.field_905 = (String)class_347.method_2166(var1, "fieldName");
      this.field_906 = Collections.singleton(var1);
      this.field_907 = Collections.emptySet();
      this.field_908 = var2;
   }

   protected class_261(String var1, Collection<String> var2, Collection<String> var3, int var4) {
      this.field_905 = (String)class_347.method_2166(var1, "fieldName");
      this.field_906 = Collections.unmodifiableSet(new HashSet(var2));
      this.field_907 = Collections.unmodifiableSet(new HashSet(var3));
      this.field_908 = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   public final T method_210(DataHolder var1, int var2, int var3) {
      Iterator var4 = this.field_906.iterator();

      do {
         if(!var4.hasNext()) {
            return this.method_1821(var1, var2, var3);
         }
      } while(!var1.method_4569((String)var4.next(), var2, var3));

      return null;
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Object) void
   protected abstract void method_1820(Bundle var1, T var2);

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.metadata.internal.MetadataBundle, int, int) void
   public final void method_211(DataHolder var1, MetadataBundle var2, int var3, int var4) {
      class_347.method_2166(var1, "dataHolder");
      class_347.method_2166(var2, "bundle");
      var2.method_1715(this, this.method_210(var1, var3, var4));
   }

   // $FF: renamed from: a (java.lang.Object, android.os.Bundle) void
   public final void method_212(T var1, Bundle var2) {
      class_347.method_2166(var2, "bundle");
      if(var1 == null) {
         var2.putString(this.getName(), (String)null);
      } else {
         this.method_1820(var2, var1);
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   protected abstract T method_1821(DataHolder var1, int var2, int var3);

   // $FF: renamed from: e (android.os.Bundle) java.lang.Object
   public final T method_213(Bundle var1) {
      class_347.method_2166(var1, "bundle");
      return var1.get(this.getName()) != null?this.method_1822(var1):null;
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   protected abstract T method_1822(Bundle var1);

   public final String getName() {
      return this.field_905;
   }

   // $FF: renamed from: gx () java.util.Collection
   public final Collection<String> method_214() {
      return this.field_906;
   }

   public String toString() {
      return this.field_905;
   }
}
