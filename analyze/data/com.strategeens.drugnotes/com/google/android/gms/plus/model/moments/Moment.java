package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.class_728;
import com.google.android.gms.internal.class_729;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {
   String getId();

   ItemScope getResult();

   String getStartDate();

   ItemScope getTarget();

   String getType();

   boolean hasId();

   boolean hasResult();

   boolean hasStartDate();

   boolean hasTarget();

   boolean hasType();

   public static class Builder {
      // $FF: renamed from: CE java.lang.String
      private String field_3848;
      private final Set<Integer> aon = new HashSet();
      private String apa;
      private class_728 api;
      private class_728 apj;
      // $FF: renamed from: vc java.lang.String
      private String field_3849;

      public Moment build() {
         return new class_729(this.aon, this.field_3848, this.api, this.apa, this.apj, this.field_3849);
      }

      public Moment.Builder setId(String var1) {
         this.field_3848 = var1;
         this.aon.add(Integer.valueOf(2));
         return this;
      }

      public Moment.Builder setResult(ItemScope var1) {
         this.api = (class_728)var1;
         this.aon.add(Integer.valueOf(4));
         return this;
      }

      public Moment.Builder setStartDate(String var1) {
         this.apa = var1;
         this.aon.add(Integer.valueOf(5));
         return this;
      }

      public Moment.Builder setTarget(ItemScope var1) {
         this.apj = (class_728)var1;
         this.aon.add(Integer.valueOf(6));
         return this;
      }

      public Moment.Builder setType(String var1) {
         this.field_3849 = var1;
         this.aon.add(Integer.valueOf(7));
         return this;
      }
   }
}
