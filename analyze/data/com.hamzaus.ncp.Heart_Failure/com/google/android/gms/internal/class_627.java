package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_236;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.internal.kn
public final class class_627 implements People {
   public Person getCurrentPerson(GoogleApiClient var1) {
      return Plus.method_1780(var1, Plus.field_896).getCurrentPerson();
   }

   public PendingResult<People.LoadPeopleResult> load(GoogleApiClient var1, final Collection<String> var2) {
      return var1.method_772(new class_627.class_1165(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_947(class_236 var1) {
            var1.method_1482(this, var2);
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> load(GoogleApiClient var1, final String... var2) {
      return var1.method_772(new class_627.class_1165(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_943(class_236 var1) {
            var1.method_1485(this, var2);
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient var1) {
      return var1.method_772(new class_627.class_1165(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_946(class_236 var1) {
            var1.method_1487(this);
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient var1, final int var2, final String var3) {
      return var1.method_772(new class_627.class_1165(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_944(class_236 var1) {
            this.a(var1.method_1479(this, var2, var3));
         }
      });
   }

   public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient var1, final String var2) {
      return var1.method_772(new class_627.class_1165(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_945(class_236 var1) {
            this.a(var1.method_1489(this, var2));
         }
      });
   }

   private abstract static class class_1165 extends Plus.class_817<People.LoadPeopleResult> {
      private class_1165() {
      }

      // $FF: synthetic method
      class_1165(Object var1) {
         this();
      }

      // $FF: renamed from: ao (com.google.android.gms.common.api.Status) com.google.android.gms.plus.People$LoadPeopleResult
      public People.LoadPeopleResult method_942(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_942(var1);
      }
   }
}
