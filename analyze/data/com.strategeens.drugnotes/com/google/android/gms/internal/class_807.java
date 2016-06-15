package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_285;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// $FF: renamed from: com.google.android.gms.internal.pb
public final class class_807 implements Moments {
   public PendingResult<Moments.LoadMomentsResult> load(final GoogleApiClient var1) {
      return var1.method_942(new class_807.class_1301(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1225(class_285 var1) {
            var1.method_1826(this);
         }
      });
   }

   public PendingResult<Moments.LoadMomentsResult> load(final GoogleApiClient var1, final int var2, final String var3, final Uri var4, final String var5, final String var6) {
      return var1.method_942(new class_807.class_1301(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1224(class_285 var1) {
            var1.method_1820(this, var2, var3, var4, var5, var6);
         }
      });
   }

   public PendingResult<Status> remove(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new class_807.class_1692(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1222(class_285 var1) {
            var1.removeMoment(var2);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> write(final GoogleApiClient var1, final Moment var2) {
      return var1.method_944(new class_807.class_1693(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1220(class_285 var1) {
            var1.method_1821(this, var2);
         }
      });
   }

   private abstract static class class_1301 extends Plus.class_1089<Moments.LoadMomentsResult> {
      private class_1301(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      class_1301(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: aB (com.google.android.gms.common.api.Status) com.google.android.gms.plus.Moments$LoadMomentsResult
      public Moments.LoadMomentsResult method_1223(final Status var1) {
         return new Moments.LoadMomentsResult() {
            public MomentBuffer getMomentBuffer() {
               return null;
            }

            public String getNextPageToken() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }

            public String getUpdated() {
               return null;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1223(var1);
      }
   }

   private abstract static class class_1692 extends Plus.class_1089<Status> {
      private class_1692(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      class_1692(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1221(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1221(var1);
      }
   }

   private abstract static class class_1693 extends Plus.class_1089<Status> {
      private class_1693(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      class_1693(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1219(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1219(var1);
      }
   }
}
