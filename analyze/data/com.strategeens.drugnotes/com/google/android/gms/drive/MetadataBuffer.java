package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.internal.class_279;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.class_539;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.class_878;
import com.google.android.gms.internal.class_714;
import java.util.Iterator;

public final class MetadataBuffer extends DataBuffer<Metadata> {
   // $FF: renamed from: OB java.lang.String
   private final String field_1599;
   // $FF: renamed from: OC com.google.android.gms.drive.MetadataBuffer$a
   private MetadataBuffer.class_1420 field_1600;

   public MetadataBuffer(DataHolder var1, String var2) {
      super(var1);
      this.field_1599 = var2;
      var1.method_5837().setClassLoader(MetadataBuffer.class.getClassLoader());
   }

   public Metadata get(int var1) {
      MetadataBuffer.class_1420 var2 = this.field_1600;
      if(var2 == null || var2.field_588 != var1) {
         var2 = new MetadataBuffer.class_1420(this.JG, var1);
         this.field_1600 = var2;
      }

      return var2;
   }

   public String getNextPageToken() {
      return this.field_1599;
   }

   private static class class_1420 extends Metadata {
      // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
      private final DataHolder field_586;
      // $FF: renamed from: La int
      private final int field_587;
      // $FF: renamed from: OD int
      private final int field_588;

      public class_1420(DataHolder var1, int var2) {
         this.field_586 = var1;
         this.field_588 = var2;
         this.field_587 = var1.method_5829(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
      protected <T> T method_1759(MetadataField<T> var1) {
         return var1.method_221(this.field_586, this.field_588, this.field_587);
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1761();
      }

      public boolean isDataValid() {
         return !this.field_586.isClosed();
      }

      // $FF: renamed from: iy () com.google.android.gms.drive.Metadata
      public Metadata method_1761() {
         MetadataBundle var1 = MetadataBundle.method_2081();
         Iterator var2 = class_878.method_4948().iterator();

         while(var2.hasNext()) {
            MetadataField var3 = (MetadataField)var2.next();
            if(!(var3 instanceof class_539) && var3 != class_714.field_3304) {
               var3.method_222(this.field_586, var1, this.field_588, this.field_587);
            }
         }

         return new class_279(var1);
      }
   }
}
