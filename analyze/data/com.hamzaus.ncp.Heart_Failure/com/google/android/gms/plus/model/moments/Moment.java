package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.class_287;
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
      private final Set<Integer> acp = new HashSet();
      private String adc;
      private class_286 adk;
      private class_286 adl;
      // $FF: renamed from: qU java.lang.String
      private String field_3707;
      // $FF: renamed from: xD java.lang.String
      private String field_3708;

      public Moment build() {
         return new class_287(this.acp, this.field_3708, this.adk, this.adc, this.adl, this.field_3707);
      }

      public Moment.Builder setId(String var1) {
         this.field_3708 = var1;
         this.acp.add(Integer.valueOf(2));
         return this;
      }

      public Moment.Builder setResult(ItemScope var1) {
         this.adk = (class_286)var1;
         this.acp.add(Integer.valueOf(4));
         return this;
      }

      public Moment.Builder setStartDate(String var1) {
         this.adc = var1;
         this.acp.add(Integer.valueOf(5));
         return this;
      }

      public Moment.Builder setTarget(ItemScope var1) {
         this.adl = (class_286)var1;
         this.acp.add(Integer.valueOf(6));
         return this;
      }

      public Moment.Builder setType(String var1) {
         this.field_3707 = var1;
         this.acp.add(Integer.valueOf(7));
         return this;
      }
   }
}
