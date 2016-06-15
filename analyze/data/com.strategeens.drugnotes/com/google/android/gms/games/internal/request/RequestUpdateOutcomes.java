package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.class_335;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
   private static final String[] adl = new String[]{"requestId", "outcome"};
   // $FF: renamed from: Iv int
   private final int field_1890;
   private final HashMap<String, Integer> adm;

   private RequestUpdateOutcomes(int var1, HashMap<String, Integer> var2) {
      this.field_1890 = var1;
      this.adm = var2;
   }

   // $FF: synthetic method
   RequestUpdateOutcomes(int var1, HashMap var2, Object var3) {
      this(var1, var2);
   }

   // $FF: renamed from: W (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.internal.request.RequestUpdateOutcomes
   public static RequestUpdateOutcomes method_3145(DataHolder var0) {
      RequestUpdateOutcomes.Builder var1 = new RequestUpdateOutcomes.Builder();
      var1.method_3956(var0.getStatusCode());
      int var3 = var0.getCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var0.method_5829(var4);
         var1.method_3958(var0.method_5831("requestId", var4, var5), var0.method_5830("outcome", var4, var5));
      }

      return var1.method_3957();
   }

   public Set<String> getRequestIds() {
      return this.adm.keySet();
   }

   public int getRequestOutcome(String var1) {
      class_335.method_2308(this.adm.containsKey(var1), "Request " + var1 + " was not part of the update operation!");
      return ((Integer)this.adm.get(var1)).intValue();
   }

   public static final class Builder {
      // $FF: renamed from: Iv int
      private int field_3065 = 0;
      private HashMap<String, Integer> adm = new HashMap();

      // $FF: renamed from: ek (int) com.google.android.gms.games.internal.request.RequestUpdateOutcomes$Builder
      public RequestUpdateOutcomes.Builder method_3956(int var1) {
         this.field_3065 = var1;
         return this;
      }

      // $FF: renamed from: mF () com.google.android.gms.games.internal.request.RequestUpdateOutcomes
      public RequestUpdateOutcomes method_3957() {
         return new RequestUpdateOutcomes(this.field_3065, this.adm);
      }

      // $FF: renamed from: z (java.lang.String, int) com.google.android.gms.games.internal.request.RequestUpdateOutcomes$Builder
      public RequestUpdateOutcomes.Builder method_3958(String var1, int var2) {
         if(RequestUpdateResultOutcome.isValid(var2)) {
            this.adm.put(var1, Integer.valueOf(var2));
         }

         return this;
      }
   }
}
