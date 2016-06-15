package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.internal.class_229;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.class_266;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.class_681;
import com.google.android.gms.internal.class_276;
import java.util.ArrayList;
import java.util.Iterator;

public final class MetadataBuffer extends DataBuffer<Metadata> {
   // $FF: renamed from: HO java.lang.String[]
   private static final String[] field_1923;
   // $FF: renamed from: HP java.lang.String
   private final String field_1924;
   // $FF: renamed from: HQ com.google.android.gms.drive.MetadataBuffer$a
   private MetadataBuffer.class_1099 field_1925;

   static {
      ArrayList var0 = new ArrayList();
      Iterator var1 = class_681.method_3963().iterator();

      while(var1.hasNext()) {
         var0.addAll(((MetadataField)var1.next()).method_214());
      }

      field_1923 = (String[])var0.toArray(new String[0]);
   }

   public MetadataBuffer(DataHolder var1, String var2) {
      super(var1);
      this.field_1924 = var2;
      var1.method_4563().setClassLoader(MetadataBuffer.class.getClassLoader());
   }

   public Metadata get(int var1) {
      MetadataBuffer.class_1099 var2 = this.field_1925;
      if(var2 == null || var2.field_731 != var1) {
         var2 = new MetadataBuffer.class_1099(this.DD, var1);
         this.field_1925 = var2;
      }

      return var2;
   }

   public String getNextPageToken() {
      return this.field_1924;
   }

   private static class class_1099 extends Metadata {
      // $FF: renamed from: DD com.google.android.gms.common.data.DataHolder
      private final DataHolder field_729;
      // $FF: renamed from: EA int
      private final int field_730;
      // $FF: renamed from: HR int
      private final int field_731;

      public class_1099(DataHolder var1, int var2) {
         this.field_729 = var1;
         this.field_731 = var2;
         this.field_730 = var1.method_4556(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
      protected <T> T method_1415(MetadataField<T> var1) {
         return var1.method_210(this.field_729, this.field_731, this.field_730);
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1417();
      }

      // $FF: renamed from: gg () com.google.android.gms.drive.Metadata
      public Metadata method_1417() {
         MetadataBundle var1 = MetadataBundle.method_1713();
         Iterator var2 = class_681.method_3963().iterator();

         while(var2.hasNext()) {
            MetadataField var3 = (MetadataField)var2.next();
            if(!(var3 instanceof class_266) && var3 != class_276.field_935) {
               var3.method_211(this.field_729, var1, this.field_731, this.field_730);
            }
         }

         return new class_229(var1);
      }

      public boolean isDataValid() {
         return !this.field_729.isClosed();
      }
   }
}
