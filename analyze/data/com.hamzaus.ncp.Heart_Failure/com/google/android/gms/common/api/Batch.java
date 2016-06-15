package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends class_797.class_1207<BatchResult> {
   // $FF: renamed from: Dw int
   private int field_47;
   // $FF: renamed from: Dx boolean
   private boolean field_48;
   // $FF: renamed from: Dy boolean
   private boolean field_49;
   // $FF: renamed from: Dz com.google.android.gms.common.api.PendingResult[]
   private final PendingResult<?>[] field_50;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_51;

   private Batch(List<PendingResult<?>> var1, Looper var2) {
      super(new class_797.class_1205(var2));
      this.field_51 = new Object();
      this.field_47 = var1.size();
      this.field_50 = new PendingResult[this.field_47];

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         PendingResult var4 = (PendingResult)var1.get(var3);
         this.field_50[var3] = var4;
         var4.method_758(new PendingResult.class_1287() {
            // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
            public void method_765(Status param1) {
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
   static Object method_907(Batch var0) {
      return var0.field_51;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Batch, boolean) boolean
   // $FF: synthetic method
   static boolean method_908(Batch var0, boolean var1) {
      var0.field_49 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.Batch) int
   // $FF: synthetic method
   static int method_909(Batch var0) {
      int var1 = var0.field_47;
      var0.field_47 = var1 - 1;
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.Batch, boolean) boolean
   // $FF: synthetic method
   static boolean method_910(Batch var0, boolean var1) {
      var0.field_48 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.Batch) int
   // $FF: synthetic method
   static int method_911(Batch var0) {
      return var0.field_47;
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.Batch) boolean
   // $FF: synthetic method
   static boolean method_912(Batch var0) {
      return var0.field_49;
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.Batch) void
   // $FF: synthetic method
   static void method_913(Batch var0) {
      var0.cancel();
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.Batch) boolean
   // $FF: synthetic method
   static boolean method_914(Batch var0) {
      return var0.field_48;
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.Batch) com.google.android.gms.common.api.PendingResult[]
   // $FF: synthetic method
   static PendingResult[] method_915(Batch var0) {
      return var0.field_50;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
   // $FF: synthetic method
   public Result method_884(Status var1) {
      return this.createFailedResult(var1);
   }

   public void cancel() {
      super.cancel();
      PendingResult[] var1 = this.field_50;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var1[var3].cancel();
      }

   }

   public BatchResult createFailedResult(Status var1) {
      return new BatchResult(var1, this.field_50);
   }

   public static final class Builder {
      // $FF: renamed from: DB java.util.List
      private List<PendingResult<?>> field_4277 = new ArrayList();
      // $FF: renamed from: DC android.os.Looper
      private Looper field_4278;

      public Builder(GoogleApiClient var1) {
         this.field_4278 = var1.getLooper();
      }

      public <R extends Result> BatchResultToken<R> add(PendingResult<R> var1) {
         BatchResultToken var2 = new BatchResultToken(this.field_4277.size());
         this.field_4277.add(var1);
         return var2;
      }

      public Batch build() {
         return new Batch(this.field_4277, this.field_4278, null);
      }
   }
}
