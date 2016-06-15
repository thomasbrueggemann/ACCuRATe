package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.m
public final class class_279 extends Metadata {
   // $FF: renamed from: PD com.google.android.gms.drive.metadata.internal.MetadataBundle
   private final MetadataBundle field_589;

   public class_279(MetadataBundle var1) {
      this.field_589 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   protected <T> T method_1759(MetadataField<T> var1) {
      return this.field_589.method_2082(var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1762();
   }

   public boolean isDataValid() {
      return this.field_589 != null;
   }

   // $FF: renamed from: iy () com.google.android.gms.drive.Metadata
   public Metadata method_1762() {
      return new class_279(MetadataBundle.method_2080(this.field_589));
   }

   public String toString() {
      return "Metadata [mImpl=" + this.field_589 + "]";
   }
}
