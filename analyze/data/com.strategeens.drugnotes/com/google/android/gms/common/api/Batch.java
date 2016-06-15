package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BaseImplementation.AbstractPendingResult<BatchResult> {
   // $FF: renamed from: JA boolean
   private boolean field_76;
   // $FF: renamed from: JB boolean
   private boolean field_77;
   // $FF: renamed from: JC com.google.android.gms.common.api.PendingResult[]
   private final PendingResult<?>[] field_78;
   // $FF: renamed from: Jz int
   private int field_79;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_80;

   private Batch(List<PendingResult<?>> var1, Looper var2) {
      super(new BaseImplementation.CallbackHandler(var2));
      this.field_80 = new Object();
      this.field_79 = var1.size();
      this.field_78 = new PendingResult[this.field_79];

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         PendingResult var4 = (PendingResult)var1.get(var3);
         this.field_78[var3] = var4;
         var4.method_919(new PendingResult.class_1650() {
            // $FF: renamed from: m (com.google.android.gms.common.api.Status) void
            public void method_940(Status param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }

   }

   // $FF: synthetic method
   Batch(List var1, Looper var2, Object var3) {
      this(var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Batch) java.lang.Object
   // $FF: synthetic method
   static Object method_1133(Batch var0) {
      return var0.field_80;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Batch, boolean) boolean
   // $FF: synthetic method
   static boolean method_1134(Batch var0, boolean var1) {
      var0.field_77 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.Batch) int
   // $FF: synthetic method
   static int method_1135(Batch var0) {
      int var1 = var0.field_79;
      var0.field_79 = var1 - 1;
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.Batch, boolean) boolean
   // $FF: synthetic method
   static boolean method_1136(Batch var0, boolean var1) {
      var0.field_76 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.Batch) int
   // $FF: synthetic method
   static int method_1137(Batch var0) {
      return var0.field_79;
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.Batch) boolean
   // $FF: synthetic method
   static boolean method_1138(Batch var0) {
      return var0.field_77;
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.Batch) void
   // $FF: synthetic method
   static void method_1139(Batch var0) {
      var0.cancel();
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.Batch) boolean
   // $FF: synthetic method
   static boolean method_1140(Batch var0) {
      return var0.field_76;
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.Batch) com.google.android.gms.common.api.PendingResult[]
   // $FF: synthetic method
   static PendingResult[] method_1141(Batch var0) {
      return var0.field_78;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
   // $FF: synthetic method
   public Result method_1109(Status var1) {
      return this.createFailedResult(var1);
   }

   public void cancel() {
      super.cancel();
      PendingResult[] var1 = this.field_78;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var1[var3].cancel();
      }

   }

   public BatchResult createFailedResult(Status var1) {
      return new BatchResult(var1, this.field_78);
   }

   public static final class Builder {
      // $FF: renamed from: JE java.util.List
      private List<PendingResult<?>> field_4427 = new ArrayList();
      // $FF: renamed from: JF android.os.Looper
      private Looper field_4428;

      public Builder(GoogleApiClient var1) {
         this.field_4428 = var1.getLooper();
      }

      public <R extends Result> BatchResultToken<R> add(PendingResult<R> var1) {
         BatchResultToken var2 = new BatchResultToken(this.field_4427.size());
         this.field_4427.add(var1);
         return var2;
      }

      public Batch build() {
         return new Batch(this.field_4427, this.field_4428, null);
      }
   }
}
