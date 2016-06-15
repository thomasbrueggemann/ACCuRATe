package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_285;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.internal.pc
public final class class_808 implements People {
   public Person getCurrentPerson(GoogleApiClient var1) {
      return Plus.method_2168(var1, Plus.field_741).getCurrentPerson();
   }

   public PendingResult<People.LoadPeopleResult> load(final GoogleApiClient var1, final Collection<String> var2) {
      return var1.method_942(new class_808.class_1330(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1233(class_285 var1) {
            var1.method_1822(this, var2);
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> load(final GoogleApiClient var1, final String... var2) {
      return var1.method_942(new class_808.class_1330(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1229(class_285 var1) {
            var1.method_1825(this, var2);
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> loadConnected(final GoogleApiClient var1) {
      return var1.method_942(new class_808.class_1330(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1232(class_285 var1) {
            var1.method_1827(this);
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> loadVisible(final GoogleApiClient var1, final int var2, final String var3) {
      return var1.method_942(new class_808.class_1330(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1230(class_285 var1) {
            this.a(var1.method_1819(this, var2, var3));
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> loadVisible(final GoogleApiClient var1, final String var2) {
      return var1.method_942(new class_808.class_1330(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1231(class_285 var1) {
            this.a(var1.method_1829(this, var2));
         }
      });
   }

   private abstract static class class_1330 extends Plus.class_1089<People.LoadPeopleResult> {
      private class_1330(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      class_1330(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: aC (com.google.android.gms.common.api.Status) com.google.android.gms.plus.People$LoadPeopleResult
      public People.LoadPeopleResult method_1228(final Status var1) {
         return new People.LoadPeopleResult() {
            public String getNextPageToken() {
               return null;
            }

            public PersonBuffer getPersonBuffer() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1228(var1);
      }
   }
}
