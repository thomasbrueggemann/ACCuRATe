package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.class_347;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
   // $FF: renamed from: Sk java.lang.String[]
   private static final String[] field_2166 = new String[]{"requestId", "outcome"};
   // $FF: renamed from: CQ int
   private final int field_2167;
   // $FF: renamed from: Sl java.util.HashMap
   private final HashMap<String, Integer> field_2168;

   private RequestUpdateOutcomes(int var1, HashMap<String, Integer> var2) {
      this.field_2167 = var1;
      this.field_2168 = var2;
   }

   // $FF: synthetic method
   RequestUpdateOutcomes(int var1, HashMap var2, Object var3) {
      this(var1, var2);
   }

   // $FF: renamed from: U (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.internal.request.RequestUpdateOutcomes
   public static RequestUpdateOutcomes method_2732(DataHolder var0) {
      RequestUpdateOutcomes.Builder var1 = new RequestUpdateOutcomes.Builder();
      var1.method_3310(var0.getStatusCode());
      int var3 = var0.getCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var0.method_4556(var4);
         var1.method_3312(var0.method_4560("requestId", var4, var5), var0.method_4558("outcome", var4, var5));
      }

      return var1.method_3311();
   }

   public Set<String> getRequestIds() {
      return this.field_2168.keySet();
   }

   public int getRequestOutcome(String var1) {
      class_347.method_2168(this.field_2168.containsKey(var1), "Request " + var1 + " was not part of the update operation!");
      return ((Integer)this.field_2168.get(var1)).intValue();
   }

   public static final class Builder {
      // $FF: renamed from: CQ int
      private int field_3117 = 0;
      // $FF: renamed from: Sl java.util.HashMap
      private HashMap<String, Integer> field_3118 = new HashMap();

      // $FF: renamed from: cw (int) com.google.android.gms.games.internal.request.RequestUpdateOutcomes$Builder
      public RequestUpdateOutcomes.Builder method_3310(int var1) {
         this.field_3117 = var1;
         return this;
      }

      // $FF: renamed from: it () com.google.android.gms.games.internal.request.RequestUpdateOutcomes
      public RequestUpdateOutcomes method_3311() {
         return new RequestUpdateOutcomes(this.field_3117, this.field_3118);
      }

      // $FF: renamed from: v (java.lang.String, int) com.google.android.gms.games.internal.request.RequestUpdateOutcomes$Builder
      public RequestUpdateOutcomes.Builder method_3312(String var1, int var2) {
         if(RequestUpdateResultOutcome.isValid(var2)) {
            this.field_3118.put(var1, Integer.valueOf(var2));
         }

         return this;
      }
   }
}
