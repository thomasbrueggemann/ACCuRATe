package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_236;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// $FF: renamed from: com.google.android.gms.internal.km
public final class class_626 implements Moments {
   public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient var1) {
      return var1.method_772(new class_626.class_1181(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_940(class_236 var1) {
            var1.method_1486(this);
         }
      });
   }

   public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient var1, final int var2, final String var3, final Uri var4, final String var5, final String var6) {
      return var1.method_772(new class_626.class_1181(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_941(class_236 var1) {
            var1.method_1480(this, var2, var3, var4, var5, var6);
         }
      });
   }

   public PendingResult<Status> remove(GoogleApiClient var1, final String var2) {
      return var1.method_773(new class_626.class_1247(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_936(class_236 var1) {
            var1.removeMoment(var2);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> write(GoogleApiClient var1, final Moment var2) {
      return var1.method_773(new class_626.class_1246(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_938(class_236 var1) {
            var1.method_1481(this, var2);
         }
      });
   }

   private abstract static class class_1181 extends Plus.class_817<Moments.LoadMomentsResult> {
      private class_1181() {
      }

      // $FF: synthetic method
      class_1181(Object var1) {
         this();
      }

      // $FF: renamed from: an (com.google.android.gms.common.api.Status) com.google.android.gms.plus.Moments$LoadMomentsResult
      public Moments.LoadMomentsResult method_939(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_939(var1);
      }
   }

   private abstract static class class_1247 extends Plus.class_817<Status> {
      private class_1247() {
      }

      // $FF: synthetic method
      class_1247(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_935(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_935(Status var1) {
         return var1;
      }
   }

   private abstract static class class_1246 extends Plus.class_817<Status> {
      private class_1246() {
      }

      // $FF: synthetic method
      class_1246(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_937(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_937(Status var1) {
         return var1;
      }
   }
}
