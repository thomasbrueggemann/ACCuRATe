package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.l
public final class class_229 extends Metadata {
   // $FF: renamed from: IF com.google.android.gms.drive.metadata.internal.MetadataBundle
   private final MetadataBundle field_732;

   public class_229(MetadataBundle var1) {
      this.field_732 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   protected <T> T method_1415(MetadataField<T> var1) {
      return this.field_732.method_1714(var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1418();
   }

   // $FF: renamed from: gg () com.google.android.gms.drive.Metadata
   public Metadata method_1418() {
      return new class_229(MetadataBundle.method_1712(this.field_732));
   }

   public boolean isDataValid() {
      return this.field_732 != null;
   }

   public String toString() {
      return "Metadata [mImpl=" + this.field_732 + "]";
   }
}
